package measure.smm.handlers.tools;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.modelio.api.diagram.IDiagramGraphic;
import org.modelio.api.diagram.IDiagramHandle;
import org.modelio.api.diagram.tools.DefaultBoxTool;

@objid ("7e87aaef-8589-4bd4-9f8e-9e152108ae4a")
public class DirectMeasureDiagramCommande extends DefaultBoxTool {
    @objid ("84387c86-ee9c-43b5-a586-0a80e2b30125")
    @Override
    public boolean acceptElement(final IDiagramHandle diagramHandle, final IDiagramGraphic targetNode) {
        // TODO Auto-generated method stub
        return false;
    }

    @objid ("d0301b97-a259-4d2a-9db0-9aaa4505073e")
    @Override
    public void actionPerformed(final IDiagramHandle diagramHandle, final IDiagramGraphic parent, final Rectangle rect) {
        // TODO implement the DirectMeasureDiagramCommande handler. 
        MessageDialog.openInformation(Display.getDefault().getActiveShell(), "DirectMeasureDiagramCommande", "Tool not implemented!");
    }

}
