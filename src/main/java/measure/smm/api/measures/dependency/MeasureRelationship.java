/*
 * WARNING: GENERATED FILE - DO NOT EDIT
 * Module: SMM v0.1.14

 * This file was generated on 5/30/16 6:00 PM by Modelio Studio.
 */
package measure.smm.api.measures.dependency;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import measure.smm.api.ISMMPeerModule;
import measure.smm.api.core.dependency.SmmRelationship;
import org.modelio.api.model.PropertyConverter;
import org.modelio.api.modelio.Modelio;
import org.modelio.metamodel.factory.ExtensionNotFoundException;
import org.modelio.metamodel.uml.infrastructure.Dependency;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyDefinition;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyTableDefinition;

@objid ("4ea76bff-c37d-44c3-9249-e192eda13af2")
public class MeasureRelationship extends SmmRelationship {
    @objid ("f6eefc90-b87b-4cb7-bbe6-e1f0694e5f16")
    public static final String STEREOTYPE_NAME = "MeasureRelationship";

    @objid ("4f24bb36-435e-4f4f-bd3a-128449385dfe")
    public static final String INFLUENCE_TAGTYPE = "influence";

    @objid ("57fba795-d580-4827-986a-c77fd5d69e1f")
    public static final String MEASURANTQUERY_BODY_TAGTYPE = "measurantQuery_body";

    @objid ("cd2596fb-016c-46b0-9016-66e122b58952")
    public static final String MEASURANTQUERY_LANGUAGE_TAGTYPE = "measurantQuery_language";

    @objid ("31d5a4fd-1a41-4591-8856-7e78d79aa097")
    public Dependency getElement() {
        return (Dependency)super.getElement();
    }

    @objid ("202ac67c-d9c4-43b5-b0c3-40820a1cb92a")
    public static MeasureRelationship create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Dependency");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, MeasureRelationship.STEREOTYPE_NAME);
        return MeasureRelationship.instantiate((Dependency)e);
    }

    @objid ("dea87aba-6d88-4f01-b23e-0de41570e7da")
    protected MeasureRelationship(final Dependency elt) {
        super(elt);
    }

    @objid ("e802ebf0-6db5-4073-ba04-c71d0b8763c8")
    public static MeasureRelationship instantiate(final Dependency elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, MeasureRelationship.STEREOTYPE_NAME))
            throw new Exception("Missing 'MeasureRelationship' stereotype");
        return new MeasureRelationship(elt);
    }

    /**
     * Getter for property 'MeasureRelationship.influence'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("19ca055f-2043-4106-bdfd-7bf2cdd2a420")
    public String getInfluence() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, INFLUENCE_TAGTYPE);
    }

    /**
     * Setter for property 'MeasureRelationship.influence'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("7ea9a6e9-5f73-4790-ba45-e5f58bdf7954")
    public void setInfluence(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, INFLUENCE_TAGTYPE, value);
    }

    /**
     * Getter for property 'MeasureRelationship.measurantQuery_body'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("27a2db70-8e4a-4a94-9b81-a5163b23abd3")
    public String getMeasurantQuery_body() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, MEASURANTQUERY_BODY_TAGTYPE);
    }

    /**
     * Setter for property 'MeasureRelationship.measurantQuery_body'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("abba510b-888c-47da-9087-a28889a119ac")
    public void setMeasurantQuery_body(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, MEASURANTQUERY_BODY_TAGTYPE, value);
    }

    /**
     * Getter for property 'MeasureRelationship.measurantQuery_language'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("e6b7623a-a8b9-4ee0-866e-752639a7cdcf")
    public String getMeasurantQuery_language() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, MEASURANTQUERY_LANGUAGE_TAGTYPE);
    }

    /**
     * Setter for property 'MeasureRelationship.measurantQuery_language'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("2a264312-fb81-4903-8c71-da8564c1dae9")
    public void setMeasurantQuery_language(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, MEASURANTQUERY_LANGUAGE_TAGTYPE, value);
    }

}
