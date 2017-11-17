/*
 * WARNING: GENERATED FILE - DO NOT EDIT
 * Module: SMM v0.1.14

 * This file was generated on 5/30/16 6:00 PM by Modelio Studio.
 */
package measure.smm.api.measurements.class_;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import measure.smm.api.ISMMPeerModule;
import org.modelio.api.model.PropertyConverter;
import org.modelio.api.modelio.Modelio;
import org.modelio.metamodel.factory.ExtensionNotFoundException;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyDefinition;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyTableDefinition;
import org.modelio.metamodel.uml.statik.Class;

@objid ("238e3521-873b-40dc-8e28-622db1066bac")
public class GradeMeasurement extends Measurement {
    @objid ("d30d7b93-34f6-4ceb-a389-4aeb424657de")
    public static final String STEREOTYPE_NAME = "GradeMeasurement";

    @objid ("18948276-4001-4309-ae05-0a71ef022d4d")
    public static final String GRADEMEASUREMENT_BASEQUERY_BODY_TAGTYPE = "GradeMeasurement_baseQuery_body";

    @objid ("c96f0a82-22c3-47ee-a309-580bc39e9908")
    public static final String GRADEMEASUREMENT_BASEQUERY_LANGUAGE_TAGTYPE = "GradeMeasurement_baseQuery_language";

    @objid ("e9c5ec63-5737-47ec-9859-404ab76cfbb3")
    public static final String GRADEMEASUREMENT_ISBASESUPPLIED_TAGTYPE = "GradeMeasurement_isBaseSupplied";

    @objid ("dbacd68e-9187-459e-b6e5-1269e9a309b4")
    public static final String GRADEMEASUREMENT_VALUE_TAGTYPE = "GradeMeasurement_value";

    @objid ("55b90ec5-a6f6-4024-843d-f26b26cca097")
    public Class getElement() {
        return (Class)super.getElement();
    }

    @objid ("21376550-1af7-4762-a83b-35657dbe58ff")
    public static GradeMeasurement create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Class");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, GradeMeasurement.STEREOTYPE_NAME);
        return GradeMeasurement.instantiate((Class)e);
    }

    @objid ("8edd22e9-0d30-495b-ab4e-cfbb9c9690eb")
    protected GradeMeasurement(final Class elt) {
        super(elt);
    }

    @objid ("e394f1cb-0338-4fc1-ba74-4027d6e09b61")
    public static GradeMeasurement instantiate(final Class elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, GradeMeasurement.STEREOTYPE_NAME))
            throw new Exception("Missing 'GradeMeasurement' stereotype");
        return new GradeMeasurement(elt);
    }

    /**
     * Getter for property 'GradeMeasurement.GradeMeasurement_value'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("9f5511e7-c482-46e5-b353-47adcf8f0eb9")
    public String getGradeMeasurement_value() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, GRADEMEASUREMENT_VALUE_TAGTYPE);
    }

    /**
     * Setter for property 'GradeMeasurement.GradeMeasurement_value'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("09e3e986-d011-4907-8520-6905bda852dd")
    public void setGradeMeasurement_value(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, GRADEMEASUREMENT_VALUE_TAGTYPE, value);
    }

    /**
     * Getter for property 'GradeMeasurement.GradeMeasurement_isBaseSupplied'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("73403024-eaf9-43cd-abcc-cb4d632c3177")
    public String getGradeMeasurement_isBaseSupplied() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, GRADEMEASUREMENT_ISBASESUPPLIED_TAGTYPE);
    }

    /**
     * Setter for property 'GradeMeasurement.GradeMeasurement_isBaseSupplied'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("412bd317-231e-4ff7-ade3-2357189f8e8f")
    public void setGradeMeasurement_isBaseSupplied(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, GRADEMEASUREMENT_ISBASESUPPLIED_TAGTYPE, value);
    }

    /**
     * Getter for property 'GradeMeasurement.GradeMeasurement_baseQuery_body'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("55048c4d-e6ed-40e5-95f8-fa131d12b600")
    public String getGradeMeasurement_baseQuery_body() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, GRADEMEASUREMENT_BASEQUERY_BODY_TAGTYPE);
    }

    /**
     * Setter for property 'GradeMeasurement.GradeMeasurement_baseQuery_body'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("db9a7afb-ce68-4351-a7a8-86e748e3fc54")
    public void setGradeMeasurement_baseQuery_body(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, GRADEMEASUREMENT_BASEQUERY_BODY_TAGTYPE, value);
    }

    /**
     * Getter for property 'GradeMeasurement.GradeMeasurement_baseQuery_language'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("423abb5e-9d8d-4e10-a29c-92df9e4a9322")
    public String getGradeMeasurement_baseQuery_language() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, GRADEMEASUREMENT_BASEQUERY_LANGUAGE_TAGTYPE);
    }

    /**
     * Setter for property 'GradeMeasurement.GradeMeasurement_baseQuery_language'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("e32f3d0d-c155-4e4f-8335-275e341a2a32")
    public void setGradeMeasurement_baseQuery_language(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, GRADEMEASUREMENT_BASEQUERY_LANGUAGE_TAGTYPE, value);
    }

}
