package measure.smm.handlers.tools;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.modelio.api.diagram.IDiagramGraphic;
import org.modelio.api.diagram.IDiagramHandle;
import org.modelio.api.diagram.tools.DefaultBoxTool;

@objid ("6676d0c3-c0a6-4a41-b98d-c5d36d18cb89")
public class DirectMeasure extends DefaultBoxTool {
    @objid ("989d0eea-673a-4c16-8c80-9ffa1091e8ef")
    @Override
    public boolean acceptElement(final IDiagramHandle diagramHandle, final IDiagramGraphic targetNode) {
        // TODO Auto-generated method stub
        return false;
    }

    @objid ("ddeb3905-a9ad-4a7c-891e-59f0781fe9cf")
    @Override
    public void actionPerformed(final IDiagramHandle diagramHandle, final IDiagramGraphic parent, final Rectangle rect) {
        // TODO implement the DirectMeasure handler. 
        MessageDialog.openInformation(Display.getDefault().getActiveShell(), "DirectMeasure", "Tool not implemented!");
    }

}
