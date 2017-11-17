/*
 * WARNING: GENERATED FILE - DO NOT EDIT
 * Module: SMM v0.1.14

 * This file was generated on 5/30/16 6:00 PM by Modelio Studio.
 */
package measure.smm.api.measures.class_;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import measure.smm.api.ISMMPeerModule;
import measure.smm.api.measures.modelelement.AbstractMeasureElement;
import org.modelio.api.model.PropertyConverter;
import org.modelio.api.modelio.Modelio;
import org.modelio.metamodel.factory.ExtensionNotFoundException;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyDefinition;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyTableDefinition;
import org.modelio.metamodel.uml.statik.Class;

@objid ("f055c491-777f-4a7e-a59b-52aae9ef94ea")
public class Measure extends AbstractMeasureElement {
    @objid ("a491eb85-dc97-4080-a084-29db9de9cb5a")
    public static final String STEREOTYPE_NAME = "Measure";

    @objid ("1059e4d4-ad2a-495e-b800-13fc9c8b185c")
    public static final String CUSTOM_SCALE_TAGTYPE = "Custom_scale";

    @objid ("497a18fb-7017-482d-9ed0-5427d3b5c18b")
    public static final String SCALE_TAGTYPE = "Scale";

    @objid ("3b7c7374-4a53-408d-8597-37580f49388c")
    public static final String SCOPE_DESCRIPTION_TAGTYPE = "Scope_description";

    @objid ("2c45ddde-71f7-49d0-83bf-cc81e341d18d")
    public static final String SCOPE_NAME_TAGTYPE = "Scope_name";

    @objid ("10d48fb7-e6d7-4e73-acb6-e854df68ffee")
    public static final String SOURCE_TAGTYPE = "Source";

    @objid ("a8716481-f959-4ad0-b10f-0201d7ab8490")
    public static final String VISIBLE_TAGTYPE = "Visible";

    @objid ("92e804cf-3675-4584-9d43-02cf10db29cf")
    public static final String DEFAULTQUERY_BODY_TAGTYPE = "defaultQuery_body";

    @objid ("e6344b39-dd31-4ab3-9bb4-714c82e190ef")
    public static final String DEFAULTQUERY_LANGUAGE_TAGTYPE = "defaultQuery_language";

    @objid ("0db71ed1-c8cc-41b4-87b0-5a6e705d3d95")
    public static final String MEASURELABELFORMAT_TAGTYPE = "measureLabelFormat";

    @objid ("17886e49-d592-4a82-a7dc-51b2e37ccf8a")
    public static final String MEASUREMENTLABELFORMAT_TAGTYPE = "measurementLabelFormat";

    @objid ("1904b282-4e61-4e70-bd38-f5f2aa678658")
    public Class getElement() {
        return (Class)super.getElement();
    }

    @objid ("0051925b-3dba-47d9-ab43-f03e9eee297c")
    public static Measure create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Class");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, Measure.STEREOTYPE_NAME);
        return Measure.instantiate((Class)e);
    }

    @objid ("04308b14-fa67-4162-a8f6-f9447e25bffb")
    protected Measure(final Class elt) {
        super(elt);
    }

    @objid ("bc1997d4-49ce-48f2-813a-594cabe82e88")
    public static Measure instantiate(final Class elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, Measure.STEREOTYPE_NAME))
            throw new Exception("Missing 'Measure' stereotype");
        return new Measure(elt);
    }

    /**
     * Getter for property 'Measure.Visible'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("9b335860-9aaa-4807-a2d4-d72359d623c1")
    public String getVisible() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, VISIBLE_TAGTYPE);
    }

    /**
     * Setter for property 'Measure.Visible'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("63edc0ea-a52f-4027-a87b-74b93a53b8bc")
    public void setVisible(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, VISIBLE_TAGTYPE, value);
    }

    /**
     * Getter for property 'Measure.Scale'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("fa56f627-c1f5-4c13-ba3f-27ed95bfdf6c")
    public String getScale() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, SCALE_TAGTYPE);
    }

    /**
     * Setter for property 'Measure.Scale'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("ac2f5cbd-bcc2-4fec-bd6c-9a21410243ce")
    public void setScale(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, SCALE_TAGTYPE, value);
    }

    /**
     * Getter for property 'Measure.Source'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("de855476-0f5f-4d7c-acbf-5461cda9be2d")
    public String getSource() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, SOURCE_TAGTYPE);
    }

    /**
     * Setter for property 'Measure.Source'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("4a34d739-b35e-408a-879e-3243de79068e")
    public void setSource(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, SOURCE_TAGTYPE, value);
    }

    /**
     * Getter for property 'Measure.Scope_name'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("d3d43ee5-a858-4e3b-8e44-2d1845745a4d")
    public String getScope_name() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, SCOPE_NAME_TAGTYPE);
    }

    /**
     * Setter for property 'Measure.Scope_name'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("2d87be12-beb7-48ed-a9fb-a0ea0d0def74")
    public void setScope_name(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, SCOPE_NAME_TAGTYPE, value);
    }

    /**
     * Getter for property 'Measure.Scope_description'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("d1a17f82-89c9-4125-aff8-15d2de660e69")
    public String getScope_description() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, SCOPE_DESCRIPTION_TAGTYPE);
    }

    /**
     * Setter for property 'Measure.Scope_description'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("82508926-cdf6-46b2-9e98-0cbf93dbf45d")
    public void setScope_description(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, SCOPE_DESCRIPTION_TAGTYPE, value);
    }

    /**
     * Getter for property 'Measure.Custom_scale'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("ada26b1b-3490-40c0-bbc4-f175bb392ac7")
    public String getCustom_scale() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, CUSTOM_SCALE_TAGTYPE);
    }

    /**
     * Setter for property 'Measure.Custom_scale'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("a1a93b45-1236-4343-bd3e-7751b7d4f644")
    public void setCustom_scale(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, CUSTOM_SCALE_TAGTYPE, value);
    }

    /**
     * Getter for property 'Measure.measureLabelFormat'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("ccc3a194-e119-4b02-88e6-22d1ea3eb77b")
    public String getMeasureLabelFormat() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, MEASURELABELFORMAT_TAGTYPE);
    }

    /**
     * Setter for property 'Measure.measureLabelFormat'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("1898c059-2ec8-4047-8f62-8e7022512446")
    public void setMeasureLabelFormat(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, MEASURELABELFORMAT_TAGTYPE, value);
    }

    /**
     * Getter for property 'Measure.measurementLabelFormat'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("ae0616b1-5929-4f18-9be8-4d71889caa78")
    public String getMeasurementLabelFormat() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, MEASUREMENTLABELFORMAT_TAGTYPE);
    }

    /**
     * Setter for property 'Measure.measurementLabelFormat'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("ba52564a-9756-4513-89e3-15edce7af33d")
    public void setMeasurementLabelFormat(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, MEASUREMENTLABELFORMAT_TAGTYPE, value);
    }

    /**
     * Getter for property 'Measure.defaultQuery_body'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("19a276b7-a4de-4bac-9b43-53ea232d3df2")
    public String getDefaultQuery_body() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, DEFAULTQUERY_BODY_TAGTYPE);
    }

    /**
     * Setter for property 'Measure.defaultQuery_body'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("a4e94a9f-7f8b-4636-9524-aa7820eda8e2")
    public void setDefaultQuery_body(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, DEFAULTQUERY_BODY_TAGTYPE, value);
    }

    /**
     * Getter for property 'Measure.defaultQuery_language'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("a1f56c2d-5d94-4548-b526-8f801bbe400e")
    public String getDefaultQuery_language() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, DEFAULTQUERY_LANGUAGE_TAGTYPE);
    }

    /**
     * Setter for property 'Measure.defaultQuery_language'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("efb6ef32-0ae5-4d46-972a-dfb6d16c9e2e")
    public void setDefaultQuery_language(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, DEFAULTQUERY_LANGUAGE_TAGTYPE, value);
    }

}
