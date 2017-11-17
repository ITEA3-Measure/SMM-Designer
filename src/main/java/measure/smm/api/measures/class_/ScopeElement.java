/*
 * WARNING: GENERATED FILE - DO NOT EDIT
 * Module: SMM v0.1.14

 * This file was generated on 5/30/16 6:00 PM by Modelio Studio.
 */
package measure.smm.api.measures.class_;

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

@objid ("0d6e0e4a-7f52-4ffb-8cbd-174dbf1e1ec2")
public class ScopeElement extends SmmElement {
    @objid ("2b88e91c-9fd9-46dc-8485-197e883d8688")
    public static final String STEREOTYPE_NAME = "ScopeElement";

    @objid ("09441d31-aabf-40de-8c08-387a29e25713")
    public static final String BREAK_CONDITION_BODY_TAGTYPE = "break_condition_body";

    @objid ("05710d96-3da5-4482-a9de-0ae5d0742140")
    public static final String BREAK_CONDITION_LANGUAGE_TAGTYPE = "break_condition_language";

    @objid ("2e0686b9-3b31-4f73-9bac-49a6482a7b29")
    public static final String CLASS_MOF_TAGTYPE = "class_MOF";

    @objid ("279353f3-d144-42aa-9538-e7ebc1b4fd54")
    public static final String RECOGNIZER_BODY_TAGTYPE = "recognizer_body";

    @objid ("9869f0df-5a56-4ca9-8de2-7dc924de37dd")
    public static final String RECOGNIZER_LANGUAGE_TAGTYPE = "recognizer_language";

    @objid ("7492abb8-c38d-4d04-ab98-54edc9a34089")
    public static final String STEREOTYPE_TAGTYPE = "stereotype";

    @objid ("0470e9bd-489f-443f-a35f-5985f60fac57")
    public Class getElement() {
        return (Class)super.getElement();
    }

    @objid ("63ed7685-f2a6-403b-a0c1-20153002fbae")
    public static ScopeElement create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Class");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, ScopeElement.STEREOTYPE_NAME);
        return ScopeElement.instantiate((Class)e);
    }

    @objid ("accf5eb9-90a5-4f68-80fc-209de4e0f8ca")
    protected ScopeElement(final Class elt) {
        super(elt);
    }

    @objid ("2894b931-d21e-4378-804b-3db80c30b0aa")
    public static ScopeElement instantiate(final Class elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, ScopeElement.STEREOTYPE_NAME))
            throw new Exception("Missing 'ScopeElement' stereotype");
        return new ScopeElement(elt);
    }

    /**
     * Getter for property 'ScopeElement.class_MOF'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("8fac7b68-e819-4cfd-8258-47546e03a132")
    public String getClass_MOF() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, CLASS_MOF_TAGTYPE);
    }

    /**
     * Setter for property 'ScopeElement.class_MOF'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("120e4a21-30e8-40d3-9eed-a625fe116b18")
    public void setClass_MOF(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, CLASS_MOF_TAGTYPE, value);
    }

    /**
     * Getter for property 'ScopeElement.stereotype'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("f3920bb4-5965-474a-a8ba-fd2a45139a15")
    public String getStereotype() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, STEREOTYPE_TAGTYPE);
    }

    /**
     * Setter for property 'ScopeElement.stereotype'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("7cc7ee44-e014-4ce7-81ac-5d9207a0085e")
    public void setStereotype(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, STEREOTYPE_TAGTYPE, value);
    }

    /**
     * Getter for property 'ScopeElement.break_condition_language'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("1f92363a-7f1e-4b71-ba46-028b1fdfd807")
    public String getBreak_condition_language() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, BREAK_CONDITION_LANGUAGE_TAGTYPE);
    }

    /**
     * Setter for property 'ScopeElement.break_condition_language'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("f994ed77-7cf9-49b7-a8e0-5915050d0c1f")
    public void setBreak_condition_language(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, BREAK_CONDITION_LANGUAGE_TAGTYPE, value);
    }

    /**
     * Getter for property 'ScopeElement.break_condition_body'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("77e47a1f-9281-4ad5-9941-eb41340c8f65")
    public String getBreak_condition_body() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, BREAK_CONDITION_BODY_TAGTYPE);
    }

    /**
     * Setter for property 'ScopeElement.break_condition_body'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("0aad1f17-9fcb-4fdc-b1d7-8bc5908ff641")
    public void setBreak_condition_body(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, BREAK_CONDITION_BODY_TAGTYPE, value);
    }

    /**
     * Getter for property 'ScopeElement.recognizer_language'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("60d1a048-851e-402c-ae61-ccda314af38c")
    public String getRecognizer_language() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, RECOGNIZER_LANGUAGE_TAGTYPE);
    }

    /**
     * Setter for property 'ScopeElement.recognizer_language'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("5390effd-9d24-44b4-b11e-3954534a9fc8")
    public void setRecognizer_language(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, RECOGNIZER_LANGUAGE_TAGTYPE, value);
    }

    /**
     * Getter for property 'ScopeElement.recognizer_body'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("81e651bb-f36d-4ec4-985d-13eb47f4300c")
    public String getRecognizer_body() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, RECOGNIZER_BODY_TAGTYPE);
    }

    /**
     * Setter for property 'ScopeElement.recognizer_body'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("affe8320-b4e1-42c7-83e3-3182cf096eb1")
    public void setRecognizer_body(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, RECOGNIZER_BODY_TAGTYPE, value);
    }

}
