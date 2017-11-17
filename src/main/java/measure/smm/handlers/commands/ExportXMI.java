package measure.smm.handlers.commands;

import java.io.File;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import eu.measure.smm.SmmModel;
import eu.measure.smm.SmmPackage;
import eu.measure.smm.util.SmmResourceFactoryImpl;
import measure.smm.visitor.export.ExportAssociationsVisitor;
import measure.smm.visitor.export.ExportStructureVisitor;
import measure.smm.visitor.export.SMMModelGeneratorNavigator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.modelio.api.editor.EditorType;
import org.modelio.api.modelio.Modelio;
import org.modelio.api.module.IModule;
import org.modelio.api.module.commands.DefaultModuleCommandHandler;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.vcore.smkernel.mapi.MObject;

@objid ("86ab77da-533f-412d-8cbd-bb61d55d1aa4")
public class ExportXMI extends DefaultModuleCommandHandler {
    @objid ("a463c658-e3ef-480a-a931-0b8ec0686831")
    private File result = null;

    @objid ("881ef2bd-a30f-49ce-878e-a6beca7ba6c8")
    @Override
    public void actionPerformed(final List<MObject> selectedElements, final IModule module) {
        ModelElement root = (ModelElement) selectedElements.get(0);
        ResourceSet resourceSet = new ResourceSetImpl();
        
        initializeEMF(resourceSet);
        
        File outputFile = selectGenerationPath();
        if (outputFile==null) return;
        
        Resource resource = resourceSet.createResource(URI.createFileURI(outputFile.getAbsolutePath()));        
        
        try {
            SmmModel generated = runExporter(root);
            resource.getContents().add(generated);            
            resource.save(null);
            
            Modelio.getInstance().getEditionService().openEditor(root, outputFile, EditorType.TXTEditor, true);
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Export XMI Error", e.getMessage());            
        }
    }

    @objid ("73f02e9e-4b69-4135-8c1f-01768cd8cf7e")
    @Override
    public boolean accept(final List<MObject> selectedElements, final IModule module) {
        // Generated call to the super method will check the scope conditions defined in Studio.
        // Do not remove this call unless you need to take full control on the checks to be carried out.
        // However you can safely extends the checked conditions by adding custom code.
        if (super.accept(selectedElements, module) == false) {
            return false;
        }
        return true;
    }

    @objid ("8826ae12-55f3-49f8-b4cf-f73363facb13")
    private File selectGenerationPath() {
        result = null;
        Display.getDefault().syncExec(new Runnable() {
            
            @Override
            public void run() {
                showDialogAndSelectGenerationPath();
            }
        });
        return result;
    }

    @objid ("df1658bd-274c-46f1-8df2-23a9b8c0e7bf")
    private void showDialogAndSelectGenerationPath() {
        String extension = ".smm";
        FileDialog dialog = new FileDialog(Display.getDefault()
                .getActiveShell(), SWT.SAVE);
        
        String[] extensions = { "*" + extension }; //$NON-NLS-1$
        dialog.setFilterNames(extensions);
        dialog.setFilterExtensions(extensions);
        
        while(true) {
            String selectFilename = dialog.open();
            
            if (selectFilename != null) {
            
                if (extension != null && !selectFilename.endsWith(extension)) {
                    selectFilename = selectFilename + extension;
                }
            
                result = new File(selectFilename);
                
                if (!result.exists() || MessageDialog.openConfirm(Display.getDefault().getActiveShell(), "Export XMI", "Are you sure you want to overwrite an existing file?")) {                    
                       break;
                }
            } else {
                break;
            }
        }
    }

    @objid ("2d280517-9914-49c1-b581-45f188b146c6")
    private void initializeEMF(ResourceSet resourceSet) {
        try {
            resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put
            (Resource.Factory.Registry.DEFAULT_EXTENSION, 
             new SmmResourceFactoryImpl());
            
            resourceSet.getPackageRegistry().put
            (SmmPackage.eNS_URI, 
             SmmPackage.eINSTANCE);
        } catch(Exception e) {
        }
    }

    @objid ("58fd1bcc-7308-42df-81d7-5c17a3191098")
    private SmmModel runExporter(ModelElement root) throws Exception {
        SMMModelGeneratorNavigator navigator = new SMMModelGeneratorNavigator();
        ExportStructureVisitor structureVisitor = new ExportStructureVisitor();
        ExportAssociationsVisitor associationsVisitor = new ExportAssociationsVisitor(structureVisitor); 
              
        SmmModel generated = (SmmModel)navigator.acceptSmmModel(root, structureVisitor);
        
        navigator.acceptSmmModel(root, associationsVisitor);
        return generated;
    }

}
