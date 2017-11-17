package measure.smm.handlers.tools;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.modelio.api.diagram.IDiagramGraphic;
import org.modelio.api.diagram.IDiagramHandle;
import org.modelio.api.diagram.IDiagramLink.LinkRouterKind;
import org.modelio.api.diagram.IDiagramLink;
import org.modelio.api.diagram.IDiagramNode;
import org.modelio.api.diagram.ILinkPath;
import org.modelio.api.diagram.InvalidDestinationPointException;
import org.modelio.api.diagram.InvalidPointsPathException;
import org.modelio.api.diagram.InvalidSourcePointException;
import org.modelio.api.diagram.tools.DefaultLinkTool;
import org.modelio.api.model.ITransaction;
import org.modelio.api.modelio.Modelio;
import org.modelio.metamodel.factory.ExtensionNotFoundException;
import org.modelio.metamodel.uml.infrastructure.Dependency;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.statik.Class;

@objid ("b572a063-6b7a-4b23-8ef5-a89710b5f677")
public class RescaleLinkHandler extends DefaultLinkTool {
    @objid ("4a248efb-1e0c-415e-8241-0ecc9f9d8bb9")
    @Override
    public boolean acceptFirstElement(final IDiagramHandle diagramHandle, final IDiagramGraphic targetNode) {
        return (targetNode.getElement() instanceof Class) && ((Class) targetNode.getElement()).isStereotyped("SMM", "RescaledMeasure");
    }

    @objid ("8e22f810-dd2d-4dbb-ba14-e40de870c9e4")
    @Override
    public boolean acceptSecondElement(final IDiagramHandle diagramHandle, final IDiagramGraphic originNode, final IDiagramGraphic targetNode) {
        return (targetNode.getElement() instanceof Dependency);
    }

    @objid ("43bc6a74-bdee-41df-880b-6ae3603215dc")
    @Override
    public void actionPerformed(final IDiagramHandle diagramHandle, final IDiagramGraphic originNode, final IDiagramGraphic targetNode, final LinkRouterKind routerKind, final ILinkPath path) {
        try (ITransaction tr = Modelio.getInstance().getModelingSession().createTransaction("RescaleLinkHandler")) {
            Dependency newDep = Modelio.getInstance().getModelingSession().getModel().createDependency((ModelElement) originNode.getElement(), (ModelElement) targetNode.getElement(), "SMM", "Rescales");
        
            List<IDiagramGraphic> graphs = diagramHandle.unmask(newDep, 0, 0);
        
            IDiagramLink gLink = (IDiagramLink) graphs.get(0);
            gLink.setRouterKind(routerKind);
        
            tr.commit();
        } catch (ExtensionNotFoundException e) {
            e.printStackTrace();
        }
    }

}
