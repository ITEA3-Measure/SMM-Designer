/*
 * WARNING: GENERATED FILE - DO NOT EDIT
 * Module: SMM v0.1.14

 * This file was generated on 5/30/16 6:00 PM by Modelio Studio.
 */
package measure.smm.api.collectivemeasurements.class_;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import measure.smm.api.ISMMPeerModule;
import org.modelio.api.model.PropertyConverter;
import org.modelio.api.modelio.Modelio;
import org.modelio.metamodel.factory.ExtensionNotFoundException;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyDefinition;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyTableDefinition;
import org.modelio.metamodel.uml.statik.Class;

@objid ("1fa07c08-b081-401e-875b-d21ad29d7f5a")
public class RatioMeasurement extends BinaryMeasurement {
    @objid ("370b98d1-99d9-4294-8cb9-80befe631d36")
    public static final String STEREOTYPE_NAME = "RatioMeasurement";

    @objid ("527b60a2-10f7-4043-b34b-9b2bf0715154")
    public Class getElement() {
        return (Class)super.getElement();
    }

    @objid ("d419be67-e5da-481c-9a3a-68d7b990e470")
    public static RatioMeasurement create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Class");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, RatioMeasurement.STEREOTYPE_NAME);
        return RatioMeasurement.instantiate((Class)e);
    }

    @objid ("5ba439cc-98ee-4092-a199-ae2d48f08449")
    protected RatioMeasurement(final Class elt) {
        super(elt);
    }

    @objid ("b1ec6e94-9fea-48bf-bf1f-36244f92d3b5")
    public static RatioMeasurement instantiate(final Class elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, RatioMeasurement.STEREOTYPE_NAME))
            throw new Exception("Missing 'RatioMeasurement' stereotype");
        return new RatioMeasurement(elt);
    }

}
