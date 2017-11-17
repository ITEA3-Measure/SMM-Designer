/*
 * WARNING: GENERATED FILE - DO NOT EDIT
 * Module: SMM v0.1.14

 * This file was generated on 5/30/16 6:00 PM by Modelio Studio.
 */
package measure.smm.api.othermeasures.class_;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import measure.smm.api.ISMMPeerModule;
import measure.smm.api.measures.class_.DimensionalMeasure;
import org.modelio.api.model.PropertyConverter;
import org.modelio.api.modelio.Modelio;
import org.modelio.metamodel.factory.ExtensionNotFoundException;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyDefinition;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyTableDefinition;
import org.modelio.metamodel.uml.statik.Class;

@objid ("2baa6966-23fa-4939-8bab-f09345727cb0")
public class RescaledMeasure extends DimensionalMeasure {
    @objid ("ac94ba5e-f09e-4ff6-bf68-c4c6d02b665a")
    public static final String STEREOTYPE_NAME = "RescaledMeasure";

    @objid ("22bf43af-ec26-4bb7-bb7b-cdda73f61078")
    public static final String MULTIPLIER_TAGTYPE = "multiplier";

    @objid ("51761ecd-f4f1-4b20-8ad7-db3825bf8f3a")
    public static final String OFFSET_TAGTYPE = "offset";

    @objid ("ff5fe0c3-c812-49e0-8e7a-fa8d7e5ef0c7")
    public static final String OPERATION_BODY_TAGTYPE = "operation_body";

    @objid ("dfe9e837-4402-4492-abd3-109ffafe6afa")
    public static final String OPERATION_LANGUAGE_TAGTYPE = "operation_language";

    @objid ("3ab6ec01-75ff-4ae4-ad61-f4af47eabc0d")
    public Class getElement() {
        return (Class)super.getElement();
    }

    @objid ("d85d2f79-8fab-4e9d-a713-cbddf154fe54")
    public static RescaledMeasure create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Class");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, RescaledMeasure.STEREOTYPE_NAME);
        return RescaledMeasure.instantiate((Class)e);
    }

    @objid ("9bc424da-0c94-4eb1-9f0b-dd8adcb58dbe")
    protected RescaledMeasure(final Class elt) {
        super(elt);
    }

    @objid ("3af56abe-c674-4356-bf69-389489fbd77d")
    public static RescaledMeasure instantiate(final Class elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, RescaledMeasure.STEREOTYPE_NAME))
            throw new Exception("Missing 'RescaledMeasure' stereotype");
        return new RescaledMeasure(elt);
    }

    /**
     * Getter for property 'RescaledMeasure.offset'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("0155826b-58e5-42df-bba3-ae77696fe181")
    public String getOffset() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, OFFSET_TAGTYPE);
    }

    /**
     * Setter for property 'RescaledMeasure.offset'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("b55f80e2-4d65-4611-b05c-cb56f3d0b909")
    public void setOffset(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, OFFSET_TAGTYPE, value);
    }

    /**
     * Getter for property 'RescaledMeasure.multiplier'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("0171abf4-de62-46d5-9ebc-ca5b3e2f6621")
    public String getMultiplier() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, MULTIPLIER_TAGTYPE);
    }

    /**
     * Setter for property 'RescaledMeasure.multiplier'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("499e3677-c8a9-43ea-9a26-773b4156d880")
    public void setMultiplier(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, MULTIPLIER_TAGTYPE, value);
    }

    /**
     * Getter for property 'RescaledMeasure.operation_language'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("7f0e4882-5667-4700-b5e8-387cf2ae8b17")
    public String getOperation_language() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, OPERATION_LANGUAGE_TAGTYPE);
    }

    /**
     * Setter for property 'RescaledMeasure.operation_language'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("cb618c9c-9ec7-4dc1-8fb3-597ed7c350cf")
    public void setOperation_language(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, OPERATION_LANGUAGE_TAGTYPE, value);
    }

    /**
     * Getter for property 'RescaledMeasure.operation_body'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("f0878b6c-e19c-4fb5-968f-c63f66dbffe9")
    public String getOperation_body() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, OPERATION_BODY_TAGTYPE);
    }

    /**
     * Setter for property 'RescaledMeasure.operation_body'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("c2a2c2d8-a4ee-485d-afda-71f7dfbf7e2b")
    public void setOperation_body(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, OPERATION_BODY_TAGTYPE, value);
    }

}
