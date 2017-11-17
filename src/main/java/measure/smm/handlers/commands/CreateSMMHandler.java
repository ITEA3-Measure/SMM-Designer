package measure.smm.handlers.commands;

import java.util.List;
import java.util.Map;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.ui.internal.keys.model.ModelElement;
import org.modelio.api.module.IModule;
import org.modelio.api.module.commands.ApplyPatternStandardHandler;
import org.modelio.metamodel.mda.Project;
import org.modelio.vcore.smkernel.mapi.MObject;

@objid ("c8325767-f8fa-4525-adc8-da14d9e4c9ab")
public class CreateSMMHandler extends ApplyPatternStandardHandler {
    @objid ("5db704b9-2eb4-412c-b1dc-a172ff2eb9f1")
    @Override
    public boolean accept(final List<MObject> selectedElements, final IModule module) {
        if (super.accept(selectedElements, module) == false) {
            return false;
        }
        
        MObject parent = selectedElements.get(0);
        if(parent.getCompositionOwner() instanceof Project){
            return true;
        }
        return false;
    }

}
