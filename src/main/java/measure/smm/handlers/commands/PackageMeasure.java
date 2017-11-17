package measure.smm.handlers.commands;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import measure.smm.handlers.commands.impl.MeasureGeneratoionService;
import measure.smm.handlers.commands.impl.MeasurePackagerService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.internal.keys.model.ModelElement;
import org.modelio.api.modelio.Modelio;
import org.modelio.api.module.IModule;
import org.modelio.api.module.commands.DefaultModuleCommandHandler;
import org.modelio.metamodel.uml.infrastructure.ModelTree;
import org.modelio.metamodel.uml.statik.Class;
import org.modelio.metamodel.uml.statik.Package;
import org.modelio.vcore.smkernel.mapi.MObject;

@objid ("1cf13c93-5e5d-428e-800a-4449cc610130")
public class PackageMeasure extends DefaultModuleCommandHandler {
    @objid ("96318bd4-159e-4114-95a8-bbbfc4336eb1")
    @Override
    public void actionPerformed(final List<MObject> selectedElements, final IModule module) {
        if (selectedElements.get(0) instanceof Class) {
            Class measure = (Class) selectedElements.get(0);
        
            MeasureGeneratoionService generator = new MeasureGeneratoionService(measure);
            generator.generateMeasure();
        
            MeasurePackagerService packager = new MeasurePackagerService(measure);
        
            boolean success = packager.buildMeasure();
        
            if (success) {
                FileDialog dialog = new FileDialog(new Shell(), SWT.SAVE);
                dialog.setText("Package Measure");
                dialog.setFileName(measure.getName().replace(" ", "") + ".zip");
                Path targetpath = Paths.get(dialog.open());
                packager.packageMeasure(targetpath,true);
            }
        } else if (selectedElements.get(0) instanceof Package) {
        
            DirectoryDialog dialog = new DirectoryDialog(new Shell(), SWT.SAVE);
            dialog.setText("Package Measure");
            Path targetpath = Paths.get(dialog.open());
            List<Class> measures = findMeasures((Package) selectedElements.get(0));
            for (Class measure : measures) {
                MeasureGeneratoionService generator = new MeasureGeneratoionService(measure);
                generator.generateMeasure();
                MeasurePackagerService packager = new MeasurePackagerService(measure);
        
                boolean success = packager.buildMeasure();
                if (success) {
                    Path mpath = targetpath.resolve(measure.getName().replace(" ", "_")+ ".zip");
                    packager.packageMeasure(mpath,false);
                }
            }
        }
    }

    @objid ("b9f1eb29-e2b2-47ec-ac50-18c52b22f8e7")
    @Override
    public boolean accept(final List<MObject> selectedElements, final IModule module) {
        // Generated call to the super method will check the scope conditions
        // defined in Studio.
        // Do not remove this call unless you need to take full control on the
        // checks to be carried out.
        // However you can safely extends the checked conditions by adding
        // custom code.
        if (super.accept(selectedElements, module) == false) {
            return false;
        }
        return true;
    }

    @objid ("e2113d15-19c8-410d-86da-fbd5bfc78bbb")
    private List<Class> findMeasures(Package contaner) {
        List<Class> result = new ArrayList<>();
        for (ModelTree sub : contaner.getOwnedElement()) {
            if (sub instanceof Package) {
                result.addAll(findMeasures((Package) sub));
            } else if (sub instanceof Class && sub.isStereotyped("SMM", "Measure")) {
                result.add((Class) sub);
            }
        }
        return result;
    }

}
