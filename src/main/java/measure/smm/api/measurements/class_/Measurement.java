/*
 * WARNING: GENERATED FILE - DO NOT EDIT
 * Module: SMM v0.1.14

 * This file was generated on 5/30/16 6:00 PM by Modelio Studio.
 */
package measure.smm.api.measurements.class_;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import measure.smm.api.ISMMPeerModule;
import measure.smm.api.core.modelelement.SmmElement;
import org.modelio.api.model.PropertyConverter;
import org.modelio.api.modelio.Modelio;
import org.modelio.metamodel.factory.ExtensionNotFoundException;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyDefinition;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyTableDefinition;
import org.modelio.metamodel.uml.statik.Class;

@objid ("d1bd41c3-0fee-4962-8c38-a41b3c9032c4")
public class Measurement extends SmmElement {
    @objid ("1a2c87d1-ed14-4615-8bbe-616d2cfaaae7")
    public static final String STEREOTYPE_NAME = "Measurement";

    @objid ("d2d821db-d252-4a39-b5b3-669de28c05e6")
    public static final String BREAKVALUE_TAGTYPE = "breakValue";

    @objid ("cfcaf382-0489-423e-bbcb-63ba6b2fa041")
    public static final String ERROR_TAGTYPE = "error";

    @objid ("c95ea494-d154-4736-9cc1-34197c3fc53c")
    public Class getElement() {
        return (Class)super.getElement();
    }

    @objid ("2a32db7a-ee8f-417b-a54b-ed130e197f26")
    public static Measurement create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Class");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, Measurement.STEREOTYPE_NAME);
        return Measurement.instantiate((Class)e);
    }

    @objid ("08eee2f0-7180-4885-9cfe-709420bf9527")
    protected Measurement(final Class elt) {
        super(elt);
    }

    @objid ("55df670d-e4f9-4337-a508-3cbc2f4654d2")
    public static Measurement instantiate(final Class elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, Measurement.STEREOTYPE_NAME))
            throw new Exception("Missing 'Measurement' stereotype");
        return new Measurement(elt);
    }

    /**
     * Getter for property 'Measurement.breakValue'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("5c2ce8c3-b5c3-45e9-8117-628f431a22c4")
    public String getBreakValue() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, BREAKVALUE_TAGTYPE);
    }

    /**
     * Setter for property 'Measurement.breakValue'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("f02fa2c6-ae72-4478-9655-2094e2738062")
    public void setBreakValue(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, BREAKVALUE_TAGTYPE, value);
    }

    /**
     * Getter for property 'Measurement.error'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("4bd997e7-88a8-4763-a98c-5a7ac08ef89e")
    public String getError() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, ERROR_TAGTYPE);
    }

    /**
     * Setter for property 'Measurement.error'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("66583350-f1f1-4d17-b96f-e83d62135b5b")
    public void setError(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, ERROR_TAGTYPE, value);
    }

}
