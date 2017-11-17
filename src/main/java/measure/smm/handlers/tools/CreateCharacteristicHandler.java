package measure.smm.handlers.tools;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.modelio.api.diagram.IDiagramGraphic;
import org.modelio.api.diagram.IDiagramHandle;
import org.modelio.api.diagram.IDiagramNode;
import org.modelio.api.diagram.tools.DefaultBoxTool;
import org.modelio.api.model.ITransaction;
import org.modelio.api.modelio.Modelio;
import org.modelio.metamodel.diagrams.StaticDiagram;
import org.modelio.metamodel.factory.ExtensionNotFoundException;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.ModelTree;
import org.modelio.metamodel.uml.statik.Class;
import org.modelio.metamodel.uml.statik.NameSpace;
import org.modelio.metamodel.uml.statik.Package;

@objid ("e8cda506-58aa-4956-b3bb-da2a54d42946")
public class CreateCharacteristicHandler extends DefaultBoxTool {
    @objid ("50c059b5-317b-4ae0-aea9-6d1fcc67ccfb")
    @Override
    public boolean acceptElement(final IDiagramHandle diagramHandle, final IDiagramGraphic targetNode) {
        if (targetNode.getElement() instanceof StaticDiagram) {
            if (targetNode.getElement().getCompositionOwner() instanceof ModelElement && ((ModelElement) targetNode.getElement().getCompositionOwner()).isStereotyped("SMM", "Measure"))
                return true;
        
            if (targetNode.getElement().getCompositionOwner() instanceof ModelElement && ((ModelElement) targetNode.getElement().getCompositionOwner()).isStereotyped("SMM", "MeasureCategory"))
                return true;
        } else {
            if (targetNode.getElement().getCompositionOwner() instanceof ModelElement && ((ModelElement) targetNode.getElement().getCompositionOwner()).isStereotyped("SMM", "MeasureCategory"))
                return true;
        }
        return false;
    }

    @objid ("08ae620b-af00-404e-810f-e1812f1915c2")
    @Override
    public void actionPerformed(final IDiagramHandle diagramHandle, final IDiagramGraphic parent, final Rectangle rect) {
        try (ITransaction tr = Modelio.getInstance().getModelingSession().createTransaction("CreateCharacteristicHandler")) {
        
            try {
                NameSpace owner = null;
                if (parent.getElement() instanceof StaticDiagram) {
                    Package category = null;
                    ModelElement ow1 = ((StaticDiagram) parent.getElement()).getOrigin();
                    if (ow1.isStereotyped("SMM", "Measure")) {
                        category = (Package) ow1.getCompositionOwner();
                    } else if (ow1.isStereotyped("SMM", "MeasureCategory")) {
                        category = (Package) ow1;
                    }
        
                    for (ModelTree sub : category.getOwnedElement()) {
                        if (sub.isStereotyped("SMM", "MeasureDefinitionContainer")) {
                            owner = (Package) sub;
                            break;
                        }
                    }
        
                    if (owner == null && category != null) {
                        owner = Modelio.getInstance().getModelingSession().getModel().createPackage("Common", category, "SMM", "MeasureDefinitionContainer");
                    }
                }
        
                if (owner != null) {
                    Class element = Modelio.getInstance().getModelingSession().getModel().createClass("Characteristic", owner, "SMM", "Characteristic");
                    List<IDiagramGraphic> graph = diagramHandle.unmask(element, rect.x, rect.y);
                    ((IDiagramNode) graph.get(0)).setBounds(rect);
                }
            } catch (ExtensionNotFoundException e) {
                tr.rollback();
                e.printStackTrace();
                return;
            }
            tr.commit();
        }
    }

}
