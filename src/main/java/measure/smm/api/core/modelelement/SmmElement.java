/*
 * WARNING: GENERATED FILE - DO NOT EDIT
 * Module: SMM v0.1.14

 * This file was generated on 5/30/16 6:00 PM by Modelio Studio.
 */
package measure.smm.api.core.modelelement;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import measure.smm.api.ISMMPeerModule;
import org.modelio.api.model.PropertyConverter;
import org.modelio.api.modelio.Modelio;
import org.modelio.metamodel.factory.ExtensionNotFoundException;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyDefinition;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyTableDefinition;

@objid ("4bbb822f-43cd-4e71-a4dd-073370fcfb41")
public abstract class SmmElement {
    @objid ("56ac93b5-ad0f-4573-9eb5-5d7c0c5db062")
    public static final String STEREOTYPE_NAME = "SmmElement";

    @objid ("664455c8-eac3-4dda-998b-31ba741f6783")
    public static final String EXTENSIONS_ANNOTATION_TEXT_TAGTYPE = "Extensions_annotation_text";

    @objid ("515b2bc9-9b69-4216-b0ef-0674ff38498d")
    public static final String EXTENSIONS_ATTRIBUTE_TAG_TAGTYPE = "Extensions_attribute_tag";

    @objid ("17987c96-91d0-4250-8c17-a915b7232b3c")
    public static final String EXTENSIONS_ATTRIBUTE_VALUE_TAGTYPE = "Extensions_attribute_value";

    @objid ("c6fdb8c3-8ada-4170-b5e7-090362c95406")
    public static final String DESCRIPTION_TAGTYPE = "description";

    @objid ("5d81bf22-a076-47d7-b258-1ad0c83fcacf")
    public static final String SHORTDESCRIPTION_TAGTYPE = "shortDescription";

    @objid ("1afc3775-a26c-4694-b77a-01aa02621f28")
    protected final ModelElement elt;

    @objid ("31b72f10-d8f7-4a97-babe-43b1e77c5d43")
    public ModelElement getElement() {
        return this.elt;
    }

    @objid ("31a0dab4-f07d-4e74-8de9-485c5d04d631")
    protected SmmElement(final ModelElement elt) {
        this.elt = elt;
    }

    /**
     * Getter for property 'SmmElement.Extensions_attribute_tag'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("bac524af-5a89-4738-9a45-3863106854d1")
    public String getExtensions_attribute_tag() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, EXTENSIONS_ATTRIBUTE_TAG_TAGTYPE);
    }

    /**
     * Setter for property 'SmmElement.Extensions_attribute_tag'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("db21dce0-c3d2-4ae9-81a1-490efc91a14b")
    public void setExtensions_attribute_tag(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, EXTENSIONS_ATTRIBUTE_TAG_TAGTYPE, value);
    }

    /**
     * Getter for property 'SmmElement.Extensions_attribute_value'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("e64da589-bcfe-4ffa-bf09-dc40d5566591")
    public String getExtensions_attribute_value() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, EXTENSIONS_ATTRIBUTE_VALUE_TAGTYPE);
    }

    /**
     * Setter for property 'SmmElement.Extensions_attribute_value'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("726dd68f-f827-4f08-a17a-6bfab2ba5c15")
    public void setExtensions_attribute_value(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, EXTENSIONS_ATTRIBUTE_VALUE_TAGTYPE, value);
    }

    /**
     * Getter for property 'SmmElement.shortDescription'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("067f5def-69d1-4416-9183-f07cd727998f")
    public String getShortDescription() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, SHORTDESCRIPTION_TAGTYPE);
    }

    /**
     * Setter for property 'SmmElement.shortDescription'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("8e4ee4d3-0f2e-467d-af3b-00f311fc8485")
    public void setShortDescription(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, SHORTDESCRIPTION_TAGTYPE, value);
    }

    /**
     * Getter for property 'SmmElement.description'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("3fa9b418-7bdc-4319-8188-10416d6c7e9a")
    public String getDescription() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, DESCRIPTION_TAGTYPE);
    }

    /**
     * Setter for property 'SmmElement.description'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("0d45e52a-9ffd-4b2b-967f-1145cd877797")
    public void setDescription(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, DESCRIPTION_TAGTYPE, value);
    }

    /**
     * Getter for property 'SmmElement.Extensions_annotation_text'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("bcefaf72-35d2-4a63-bc39-199f4bc63d1e")
    public String getExtensions_annotation_text() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, EXTENSIONS_ANNOTATION_TEXT_TAGTYPE);
    }

    /**
     * Setter for property 'SmmElement.Extensions_annotation_text'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("a474da46-434f-435b-81fa-921729d7e75e")
    public void setExtensions_annotation_text(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, EXTENSIONS_ANNOTATION_TEXT_TAGTYPE, value);
    }

}
