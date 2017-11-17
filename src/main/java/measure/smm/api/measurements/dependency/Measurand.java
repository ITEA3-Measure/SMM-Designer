/*
 * WARNING: GENERATED FILE - DO NOT EDIT
 * Module: SMM v0.1.14

 * This file was generated on 5/30/16 6:00 PM by Modelio Studio.
 */
package measure.smm.api.measurements.dependency;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import measure.smm.api.ISMMPeerModule;
import org.modelio.api.model.PropertyConverter;
import org.modelio.api.modelio.Modelio;
import org.modelio.metamodel.factory.ExtensionNotFoundException;
import org.modelio.metamodel.uml.infrastructure.Dependency;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyDefinition;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyTableDefinition;

@objid ("9a481c40-c046-4336-84f0-ceaa3c7f85ed")
public class Measurand {
    @objid ("1c7fa0c3-4ea0-4e87-b332-de13dbbb4239")
    public static final String STEREOTYPE_NAME = "Measurand";

    @objid ("457b1dd6-cf30-438a-89f6-68909388149d")
    protected final Dependency elt;

    @objid ("0cce1171-8cd9-4415-8f44-72e16b9e8f43")
    public Dependency getElement() {
        return this.elt;
    }

    @objid ("5583c2ae-c3e7-416d-8f74-33ecf9f6f3f2")
    public static Measurand create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Dependency");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, Measurand.STEREOTYPE_NAME);
        return Measurand.instantiate((Dependency)e);
    }

    @objid ("37a7dfbd-a96b-4f24-8326-7156d9f7f03e")
    protected Measurand(final Dependency elt) {
        this.elt = elt;
    }

    @objid ("e7ebbc63-825f-4adc-b396-227ecce6def8")
    public static Measurand instantiate(final Dependency elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, Measurand.STEREOTYPE_NAME))
            throw new Exception("Missing 'Measurand' stereotype");
        return new Measurand(elt);
    }

}
