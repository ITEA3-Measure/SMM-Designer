/*
 * WARNING: GENERATED FILE - DO NOT EDIT
 * Module: SMM v0.1.14

 * This file was generated on 5/30/16 6:00 PM by Modelio Studio.
 */
package measure.smm.api.measures.dependency;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import measure.smm.api.ISMMPeerModule;
import measure.smm.api.core.modelelement.SmmElement;
import org.modelio.api.model.PropertyConverter;
import org.modelio.api.modelio.Modelio;
import org.modelio.metamodel.factory.ExtensionNotFoundException;
import org.modelio.metamodel.uml.infrastructure.Dependency;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyDefinition;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyTableDefinition;

@objid ("b25ec4ae-e09e-46f8-802c-e6cb59562506")
public class ScopeLink extends SmmElement {
    @objid ("9cd7a010-7160-4241-8016-1ec0d8b47159")
    public static final String STEREOTYPE_NAME = "ScopeLink";

    @objid ("72e336f0-17f4-473e-82d4-9f2729921134")
    public static final String BREAK_CONDITION_BODY_TAGTYPE = "Break_condition_body";

    @objid ("5052b5dc-30c2-47fd-85c3-f52a5fa5e82c")
    public static final String BREAK_CONDITION_LANGUAGE_TAGTYPE = "Break_condition_language";

    @objid ("ccc4e5c6-5cbc-409b-93b1-9de793e149b0")
    public static final String RECOGNIZER_BODY_TAGTYPE = "Recognizer_body";

    @objid ("ff11f1e2-33cb-4c77-87db-03b67ed06d0d")
    public static final String RECOGNIZER_LANGUAGE_TAGTYPE = "Recognizer_language";

    @objid ("7ad3ad1e-3036-4fa9-b6e7-154cacf2c1d7")
    public Dependency getElement() {
        return (Dependency)super.getElement();
    }

    @objid ("2b2564bc-db2a-4b4b-848c-0f98fe48d3a2")
    public static ScopeLink create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Dependency");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, ScopeLink.STEREOTYPE_NAME);
        return ScopeLink.instantiate((Dependency)e);
    }

    @objid ("e2049edd-acaa-4862-b075-6744b06a91d1")
    protected ScopeLink(final Dependency elt) {
        super(elt);
    }

    @objid ("62f85030-ac83-4d51-b272-0abfd7047fa5")
    public static ScopeLink instantiate(final Dependency elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, ScopeLink.STEREOTYPE_NAME))
            throw new Exception("Missing 'ScopeLink' stereotype");
        return new ScopeLink(elt);
    }

    /**
     * Getter for property 'ScopeLink.Break_condition_language'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("56e244a4-461d-49e0-91f8-03ed4019afea")
    public String getBreak_condition_language() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, BREAK_CONDITION_LANGUAGE_TAGTYPE);
    }

    /**
     * Setter for property 'ScopeLink.Break_condition_language'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("dce21ad8-2365-4a46-ab50-b6b324d75871")
    public void setBreak_condition_language(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, BREAK_CONDITION_LANGUAGE_TAGTYPE, value);
    }

    /**
     * Getter for property 'ScopeLink.Break_condition_body'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("7dfc16f0-6b46-49ff-b717-36c79ca73e6c")
    public String getBreak_condition_body() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, BREAK_CONDITION_BODY_TAGTYPE);
    }

    /**
     * Setter for property 'ScopeLink.Break_condition_body'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("50652057-2a11-4bde-8abb-2f6c812f18c7")
    public void setBreak_condition_body(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, BREAK_CONDITION_BODY_TAGTYPE, value);
    }

    /**
     * Getter for property 'ScopeLink.Recognizer_language'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("f45ce5c2-c9a2-4d00-91bd-730b0d218815")
    public String getRecognizer_language() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, RECOGNIZER_LANGUAGE_TAGTYPE);
    }

    /**
     * Setter for property 'ScopeLink.Recognizer_language'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("25597202-3a7d-4601-97e0-a3c7fa469f8d")
    public void setRecognizer_language(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, RECOGNIZER_LANGUAGE_TAGTYPE, value);
    }

    /**
     * Getter for property 'ScopeLink.Recognizer_body'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("4283925c-4c37-49e6-9caf-2681ac0dde4a")
    public String getRecognizer_body() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, RECOGNIZER_BODY_TAGTYPE);
    }

    /**
     * Setter for property 'ScopeLink.Recognizer_body'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("65a3815b-f09d-4faa-ab84-754922c2b336")
    public void setRecognizer_body(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, RECOGNIZER_BODY_TAGTYPE, value);
    }

}
