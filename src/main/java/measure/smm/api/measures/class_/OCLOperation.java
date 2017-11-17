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

@objid ("f4bb9143-9fc5-4633-a6e1-4ea224d14123")
public class OCLOperation extends AbstractMeasureElement {
    @objid ("a63cc5c7-dc17-4567-8c89-352f7b086ec9")
    public static final String STEREOTYPE_NAME = "OCLOperation";

    @objid ("547f4434-f6c6-423b-8bd0-79e1aa404a06")
    public static final String BODY_TAGTYPE = "body";

    @objid ("16b70aad-e441-4230-af12-704e10eda90c")
    public static final String CONTEXT_TAGTYPE = "context";

    @objid ("40737242-4475-4b20-a97c-b9b8d53fa2b8")
    public Class getElement() {
        return (Class)super.getElement();
    }

    @objid ("7a56f985-cff9-4a79-a9c6-8fcefebf6578")
    public static OCLOperation create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Class");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, OCLOperation.STEREOTYPE_NAME);
        return OCLOperation.instantiate((Class)e);
    }

    @objid ("be1f7500-055e-434f-afd4-7142f84f3b41")
    protected OCLOperation(final Class elt) {
        super(elt);
    }

    @objid ("73284a6a-22a2-49bd-853c-7daf1fe5a33d")
    public static OCLOperation instantiate(final Class elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, OCLOperation.STEREOTYPE_NAME))
            throw new Exception("Missing 'OCLOperation' stereotype");
        return new OCLOperation(elt);
    }

    /**
     * Getter for property 'OCLOperation.context'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("7bade185-6546-40c8-8f97-dc3a0fb461bb")
    public String getContext() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, CONTEXT_TAGTYPE);
    }

    /**
     * Setter for property 'OCLOperation.context'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("1b5e24fd-20fc-41de-8494-66ee5aeac8c1")
    public void setContext(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, CONTEXT_TAGTYPE, value);
    }

    /**
     * Getter for property 'OCLOperation.body'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("2b9ad849-c57f-4c5e-90ee-f454e77feb77")
    public String getBody() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, BODY_TAGTYPE);
    }

    /**
     * Setter for property 'OCLOperation.body'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("588be48e-2d53-442d-b852-1c8c902c0d15")
    public void setBody(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, BODY_TAGTYPE, value);
    }

}
