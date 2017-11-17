/*
 * WARNING: GENERATED FILE - DO NOT EDIT
 * Module: SMM v0.1.14

 * This file was generated on 5/30/16 6:00 PM by Modelio Studio.
 */
package measure.smm.api.measures.dependency;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import measure.smm.api.ISMMPeerModule;
import org.modelio.api.model.PropertyConverter;
import org.modelio.api.modelio.Modelio;
import org.modelio.metamodel.factory.ExtensionNotFoundException;
import org.modelio.metamodel.uml.infrastructure.Dependency;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyDefinition;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyTableDefinition;

@objid ("4a0c825a-c4af-4b1e-9fe2-e51cb0c60af1")
public class EquivalentMeasureRelationship extends MeasureRelationship {
    @objid ("c3a9feb7-b0be-4a4a-8250-1700d4458e80")
    public static final String STEREOTYPE_NAME = "EquivalentMeasureRelationship";

    @objid ("f052d098-73ce-4884-8480-8e0a20ea4381")
    public static final String MAPPING_BODY_TAGTYPE = "Mapping_body";

    @objid ("758f0bbd-c730-4d1e-b4a2-c96d292e2dc3")
    public static final String MAPPING_LANGUAGE_TAGTYPE = "Mapping_language";

    @objid ("cb396e8a-59e0-4f29-8478-6bd4b93610dc")
    public Dependency getElement() {
        return (Dependency)super.getElement();
    }

    @objid ("ef9f574f-a738-42e6-a33a-e0da72507f26")
    public static EquivalentMeasureRelationship create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Dependency");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, EquivalentMeasureRelationship.STEREOTYPE_NAME);
        return EquivalentMeasureRelationship.instantiate((Dependency)e);
    }

    @objid ("f01b5d2a-0d8e-4b34-8789-f7fd155d90ec")
    protected EquivalentMeasureRelationship(final Dependency elt) {
        super(elt);
    }

    @objid ("b30a0cd0-39c5-4aa8-9aff-8ce49987e20a")
    public static EquivalentMeasureRelationship instantiate(final Dependency elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, EquivalentMeasureRelationship.STEREOTYPE_NAME))
            throw new Exception("Missing 'EquivalentMeasureRelationship' stereotype");
        return new EquivalentMeasureRelationship(elt);
    }

    /**
     * Getter for property 'EquivalentMeasureRelationship.Mapping_language'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("983ae6bd-29b3-40e8-9f4f-e13084cec476")
    public String getMapping_language() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, MAPPING_LANGUAGE_TAGTYPE);
    }

    /**
     * Setter for property 'EquivalentMeasureRelationship.Mapping_language'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("e68af88d-08fc-40b6-8c5c-86b1f8d7fc58")
    public void setMapping_language(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, MAPPING_LANGUAGE_TAGTYPE, value);
    }

    /**
     * Getter for property 'EquivalentMeasureRelationship.Mapping_body'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("cf6ce03b-24bb-4a88-bd2c-ada773fc3520")
    public String getMapping_body() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, MAPPING_BODY_TAGTYPE);
    }

    /**
     * Setter for property 'EquivalentMeasureRelationship.Mapping_body'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("b09e2964-44a4-46d2-9e1d-d18ec41c389c")
    public void setMapping_body(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, MAPPING_BODY_TAGTYPE, value);
    }

}
