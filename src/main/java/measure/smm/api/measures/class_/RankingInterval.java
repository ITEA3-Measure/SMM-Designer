/*
 * WARNING: GENERATED FILE - DO NOT EDIT
 * Module: SMM v0.1.14

 * This file was generated on 5/30/16 6:00 PM by Modelio Studio.
 */
package measure.smm.api.measures.class_;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import measure.smm.api.ISMMPeerModule;
import org.modelio.api.model.PropertyConverter;
import org.modelio.api.modelio.Modelio;
import org.modelio.metamodel.factory.ExtensionNotFoundException;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyDefinition;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyTableDefinition;
import org.modelio.metamodel.uml.statik.Class;

@objid ("8435e107-f896-4f8d-a368-4edd4b36578e")
public class RankingInterval extends Interval {
    @objid ("b4e87747-3c05-46e4-95f5-83f27e39879f")
    public static final String STEREOTYPE_NAME = "RankingInterval";

    @objid ("d0895416-1d57-45a5-9093-0bfdc698dd34")
    public static final String VALUE_TAGTYPE = "value";

    @objid ("194a3273-b85a-4776-ae94-1acfe98aad67")
    public Class getElement() {
        return (Class)super.getElement();
    }

    @objid ("3522a098-6faf-4933-8a37-3f5ae9431a56")
    public static RankingInterval create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Class");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, RankingInterval.STEREOTYPE_NAME);
        return RankingInterval.instantiate((Class)e);
    }

    @objid ("6572d0a9-7050-44ed-a653-3eb59d4ebbf4")
    protected RankingInterval(final Class elt) {
        super(elt);
    }

    @objid ("bae7475a-830c-4307-ba9a-c0d91619874a")
    public static RankingInterval instantiate(final Class elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, RankingInterval.STEREOTYPE_NAME))
            throw new Exception("Missing 'RankingInterval' stereotype");
        return new RankingInterval(elt);
    }

    /**
     * Getter for property 'RankingInterval.value'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("b2ab21f1-36e0-47fa-89c1-88f155e196af")
    public String getValue() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, VALUE_TAGTYPE);
    }

    /**
     * Setter for property 'RankingInterval.value'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("8a560c23-4c64-41aa-82cb-a57186b11daa")
    public void setValue(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, VALUE_TAGTYPE, value);
    }

}
