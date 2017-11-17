/*
 * WARNING: GENERATED FILE - DO NOT EDIT
 * Module: SMM v0.1.14

 * This file was generated on 5/30/16 6:00 PM by Modelio Studio.
 */
package measure.smm.api.collectivemeasures.class_;

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

@objid ("db09380e-80bb-4fbc-9b52-64fc0af21ee5")
public class CollectiveMeasure extends DimensionalMeasure {
    @objid ("d8643446-a460-43e7-9fc1-8bd038661ae7")
    public static final String STEREOTYPE_NAME = "CollectiveMeasure";

    @objid ("55f60ebd-0b26-4157-8873-448f989659eb")
    public static final String ACCUMULATOR_TAGTYPE = "Accumulator";

    @objid ("980ae3ce-edd8-4d24-bc56-e1d044e0f092")
    public static final String CUSTOMACCUMULATOR_BODY_TAGTYPE = "customAccumulator_body";

    @objid ("4e763188-4128-4b79-90a2-2ccbba353019")
    public static final String CUSTOMACCUMULATOR_LANGUAGE_TAGTYPE = "customAccumulator_language";

    @objid ("f0cd92bb-6c66-4faf-b012-0d0cbc864493")
    public Class getElement() {
        return (Class)super.getElement();
    }

    @objid ("44264a8e-617a-4e2a-9925-18b77f272cf0")
    public static CollectiveMeasure create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Class");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, CollectiveMeasure.STEREOTYPE_NAME);
        return CollectiveMeasure.instantiate((Class)e);
    }

    @objid ("52e78419-3068-42f7-9181-845d977e8e80")
    protected CollectiveMeasure(final Class elt) {
        super(elt);
    }

    @objid ("b4ed1300-f16a-41cd-80e2-c49b23f3d135")
    public static CollectiveMeasure instantiate(final Class elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, CollectiveMeasure.STEREOTYPE_NAME))
            throw new Exception("Missing 'CollectiveMeasure' stereotype");
        return new CollectiveMeasure(elt);
    }

    /**
     * Getter for property 'CollectiveMeasure.Accumulator'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("7c1c6b9a-8e01-4f63-bd39-f5776c98e594")
    public String getAccumulator() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, ACCUMULATOR_TAGTYPE);
    }

    /**
     * Setter for property 'CollectiveMeasure.Accumulator'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("eef4da9b-f0a9-406c-8080-27655e743cc2")
    public void setAccumulator(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, ACCUMULATOR_TAGTYPE, value);
    }

    /**
     * Getter for property 'CollectiveMeasure.customAccumulator_body'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("12096140-da7f-4cb0-b497-8143c140707a")
    public String getCustomAccumulator_body() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, CUSTOMACCUMULATOR_BODY_TAGTYPE);
    }

    /**
     * Setter for property 'CollectiveMeasure.customAccumulator_body'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("4854911f-8f21-4f0a-82c2-a0e90c1d9c90")
    public void setCustomAccumulator_body(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, CUSTOMACCUMULATOR_BODY_TAGTYPE, value);
    }

    /**
     * Getter for property 'CollectiveMeasure.customAccumulator_language'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("1175f3dc-7621-4db7-817a-bd1b76d6e461")
    public String getCustomAccumulator_language() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, CUSTOMACCUMULATOR_LANGUAGE_TAGTYPE);
    }

    /**
     * Setter for property 'CollectiveMeasure.customAccumulator_language'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("e2b92c34-0888-4120-8c89-8079f2d51877")
    public void setCustomAccumulator_language(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, CUSTOMACCUMULATOR_LANGUAGE_TAGTYPE, value);
    }

}
