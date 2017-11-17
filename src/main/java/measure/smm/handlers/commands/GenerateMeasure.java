package measure.smm.handlers.commands;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import measure.smm.handlers.commands.impl.MeasureGeneratoionService;
import org.modelio.api.modelio.Modelio;
import org.modelio.api.module.IModule;
import org.modelio.api.module.commands.DefaultModuleCommandHandler;
import org.modelio.metamodel.uml.infrastructure.ModelTree;
import org.modelio.metamodel.uml.statik.Class;
import org.modelio.metamodel.uml.statik.Package;
import org.modelio.vcore.smkernel.mapi.MObject;

@objid ("85be1821-e152-44a5-8531-8c7c8b99e190")
public class GenerateMeasure extends DefaultModuleCommandHandler {
    @objid ("a72c9659-e84c-4155-b758-4c4e27b2a3dc")
    @Override
    public void actionPerformed(final List<MObject> selectedElements, final IModule module) {
        if(selectedElements.get(0) instanceof Class){
               generateMeasure((Class)selectedElements.get(0));
        }else if(selectedElements.get(0) instanceof Package){
            List<Class> measures = findMeasures((Package)selectedElements.get(0));        
            for(Class measure : measures){
                 generateMeasure((Class)measure);
            }
        }
    }

    @objid ("67af550c-9194-4117-8241-cc11dc9db9a4")
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

    @objid ("93c18abd-c839-4307-a292-112cac7eabba")
    private List<Class> findMeasures(Package contaner) {
        List<Class> result = new ArrayList<>();
        for(ModelTree sub : contaner.getOwnedElement()){
           if(sub instanceof Package){
               result.addAll(findMeasures((Package)sub));
           }else if(sub instanceof Class && sub.isStereotyped("SMM", "Measure")){
               result.add((Class)sub);
           }
        }
        return result;
    }

    @objid ("865c8da6-f45e-4750-9537-71ec9542a1d6")
    private void generateMeasure(Class measure) {
        Path measurePath = Modelio.getInstance().getContext().getProjectSpacePath().toPath().resolve("Measures").resolve(measure.getName().replace(" ", ""));
        MeasureGeneratoionService generator = new MeasureGeneratoionService(measure);
        generator.generateMeasure();
    }

}
