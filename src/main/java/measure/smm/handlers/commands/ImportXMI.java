package measure.smm.handlers.commands;

import java.io.File;
import java.util.List;

import org.modelio.api.module.IModule;
import org.modelio.api.module.commands.DefaultModuleCommandHandler;
import org.modelio.vcore.smkernel.mapi.MObject;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("88d38d40-3f08-455b-afa3-b055fb6d9806")
public class ImportXMI extends DefaultModuleCommandHandler {
    @objid ("f6c91f51-ae62-40d9-8a2c-ccd348553993")
    private File result = null;

    @objid ("59af40bf-9866-43f6-827e-a70548a8c908")
    @Override
    public void actionPerformed(final List<MObject> selectedElements, final IModule module) {
//        IModelingSession session = Modelio.getInstance().getModelingSession();
//        
//        try {
//            SmmPackage pkg = SmmPackage.eINSTANCE; // register package
//        } catch(Exception e) {            
//        }
//        
//        File fileToImport = selectImportPath();
//        if (fileToImport == null) return;
//        
//        SmmResourceImpl resource = new SmmResourceImpl(URI.createFileURI(fileToImport.getAbsolutePath()));
//        try (ITransaction transaction = session
//                .createTransaction("ImportXMI")) {
//            resource.load(null);            
//            IUmlModel modellingFacade = session.getModel();
//            ModelTree selectedElement = (ModelTree) selectedElements.get(0);
//            runImporter(resource, modellingFacade, selectedElement);            
//            transaction.commit();
//        } catch (IOException e) {
//            e.printStackTrace();
//            MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Import XMI Error", e.getMessage());                        
//        }
    }

    @objid ("1ad57f64-58da-4727-85bd-4c64d152a7b9")
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

//    @objid ("169dd064-3420-422a-99cb-41ea6d4a8fde")
//    private File selectImportPath() {
//        result = null;
//        Display.getDefault().syncExec(new Runnable() {
//            
//            @Override
//            public void run() {
//                showDialogAndSelectImportPath();
//            }
//        });
//        return result;
//    }
//
//    @objid ("e5f8e28b-74e1-4aa6-8371-7772e219ed1a")
//    private void showDialogAndSelectImportPath() {
//        String extension = ".smm";
//        FileDialog dialog = new FileDialog(Display.getDefault()
//                .getActiveShell(), SWT.OPEN);
//        
//        String[] extensions = { "*" + extension }; //$NON-NLS-1$
//        dialog.setFilterNames(extensions);
//        dialog.setFilterExtensions(extensions);
//        
//        String selectFilename = dialog.open();
//        
//        if (selectFilename != null) {
//        
//            if (extension != null && !selectFilename.endsWith(extension)) {
//                selectFilename = selectFilename + extension;
//            }
//        
//            result = new File(selectFilename);
//        }
//    }
//
//    @objid ("a51ac79c-3162-45d4-8da2-c423b3e9eaa2")
//    private void traverse(SmmResourceImpl resource, ImportStructureSwitch structureImporter, ImportAssociationsSwitch associationsImporter) {
//        for(EObject root : resource.getContents()) {
//            structureImporter.doSwitch(root);
//            traverse(root, structureImporter);
//        }
//        
//        // For some reason it visits some objects more than once!!
//        // adding a visited set to keep track of that
//        Set<EObject> visited = new HashSet<EObject>();
//        Iterator<EObject> it = resource.getAllContents();
//        while(it.hasNext()) {
//            EObject current=it.next();
//            if (visited.contains(current)) continue;
//            visited.add(current);
//            associationsImporter.doSwitch(current);
//        }
//    }
//
//    @objid ("0c8e12f2-769e-49af-8812-7c4077be0074")
//    private void traverse(EObject root, ImportStructureSwitch structureImporter) {
//        for(EObject child : root.eContents()) {
//            structureImporter.setCurrentParent(root);
//            structureImporter.doSwitch(child);
//            traverse(child, structureImporter);
//        }
//    }
//
//    @objid ("8ff53e17-2d59-48e1-9e90-709a3f8f1c97")
//    private void runImporter(SmmResourceImpl resource, IUmlModel modellingFacade, ModelTree selectedElement) {
//        ImportStructureSwitch structureImporter = new ImportStructureSwitch(modellingFacade, selectedElement);
//        ImportAssociationsSwitch associationsImporter = new ImportAssociationsSwitch(modellingFacade, structureImporter);
//            
//        traverse(resource, structureImporter, associationsImporter);
//    }

}
