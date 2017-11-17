package measure.smm.handlers.tools;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.geometry.Rectangle;
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

@objid ("3c7d9a24-658e-42da-87bf-034ffddda743")
public class CreateScopeHandler extends DefaultBoxTool {
    @objid ("943510fb-fa7e-46b5-aed6-fa4a7e2b5e10")
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

    @objid ("c90f4b82-f1ff-4a61-8a90-852b27e8df90")
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
                    Class element = Modelio.getInstance().getModelingSession().getModel().createClass("Scope", owner, "SMM", "ScopeElement");
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
