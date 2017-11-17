package measure.smm.handlers.tools;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import measure.smm.api.ISMMPeerModule;
import org.eclipse.draw2d.geometry.Rectangle;
import org.modelio.api.diagram.IDiagramGraphic;
import org.modelio.api.diagram.IDiagramHandle;
import org.modelio.api.diagram.tools.GenericBoxTool;
import org.modelio.api.model.ITransaction;
import org.modelio.api.modelio.Modelio;
import org.modelio.metamodel.diagrams.StaticDiagram;
import org.modelio.metamodel.factory.ExtensionNotFoundException;
import org.modelio.metamodel.uml.statik.Class;
import org.modelio.metamodel.uml.statik.Package;

@objid ("f60ae6eb-4f42-4a5e-8878-bbbe30306ab0")
public class CreateMeasureHandler extends GenericBoxTool {
    @objid ("7c49fa0c-91a4-4849-8ced-0029896bef39")
    @Override
    public void actionPerformed(final IDiagramHandle diagramHandle, final IDiagramGraphic parent, final Rectangle rect) {
        super.actionPerformed(diagramHandle, parent, rect);
        Package parentPackage = (Package) ((StaticDiagram)parent.getElement()).getOrigin();
        Class createdMerasure = (Class) parentPackage.getOwnedElement().get(parentPackage.getOwnedElement().size() - 1);
        try (ITransaction tr = Modelio.getInstance().getModelingSession().createTransaction("CreateMeasureHandler")){
            createdMerasure.putNoteContent("ModelerModule", "description", "TODO : Please fill the measure description");
            createdMerasure.putNoteContent("ModelerModule", "comment", "TODO : Please fill the measure description");
            createdMerasure.addStereotype("SMM", "metadata");
            createdMerasure.getNote("ModelerModule", "description").setMimeType("RTF");
            StaticDiagram newDiagram = Modelio.getInstance().getModelingSession().getModel().createStaticDiagram("Measure diagram", createdMerasure, "SMM", "Measure_Diagram");
            try (IDiagramHandle newDiagramHandle = Modelio.getInstance().getDiagramService().getDiagramHandle(newDiagram)) {
                newDiagramHandle.getDiagramNode().setStyle(Modelio.getInstance().getDiagramService().getStyle("Measurement diagram style"));
                newDiagramHandle.unmask(createdMerasure, 50, 100);
                newDiagramHandle.save();
            }
            
            if(createdMerasure.isStereotyped("SMM", "DirectMeasure") || createdMerasure.isStereotyped("SMM", "CountingMeasure")){
                 
                Map<String,Object> values = new HashMap<>();
                values.put("DirectMeasureImpl", createdMerasure);
                try {
                    Modelio.getInstance().getPatternService().applyPattern(Modelio.getInstance().getModuleService().getPeerModule(ISMMPeerModule.class).getConfiguration().getModuleResourcesPath().resolve("res/generated/patterns/DirectMeasureImpl.umlt"), values);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else{
                Map<String,Object> values = new HashMap<>();
                values.put("DerivedMeasureImpl", createdMerasure);
                try {
                    Modelio.getInstance().getPatternService().applyPattern(Modelio.getInstance().getModuleService().getPeerModule(ISMMPeerModule.class).getConfiguration().getModuleResourcesPath().resolve("res/generated/patterns/DerivedMeasureImpl.umlt"), values);
                } catch (IOException e) {
                    e.printStackTrace();
                }
        
            }
            
        
            tr.commit();
        
        } catch (ExtensionNotFoundException e) {
            e.printStackTrace();
        }
    }

}
