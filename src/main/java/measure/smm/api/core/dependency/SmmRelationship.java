/*
 * WARNING: GENERATED FILE - DO NOT EDIT
 * Module: SMM v0.1.14

 * This file was generated on 5/30/16 6:00 PM by Modelio Studio.
 */
package measure.smm.api.core.dependency;

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

@objid ("533357da-4023-410f-a6b5-f76eff890689")
public class SmmRelationship extends SmmElement {
    @objid ("22e0b70d-51ad-4d92-b47b-ccb34b2af8f6")
    public static final String STEREOTYPE_NAME = "SmmRelationship";

    @objid ("8d07e61e-22ce-4673-9011-bda0ddf3a4ea")
    public Dependency getElement() {
        return (Dependency)super.getElement();
    }

    @objid ("e10535cf-025d-4e2c-8f2e-0c1ebe0ce8b4")
    public static SmmRelationship create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Dependency");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, SmmRelationship.STEREOTYPE_NAME);
        return SmmRelationship.instantiate((Dependency)e);
    }

    @objid ("f178013d-067f-4855-b268-8b7f8e2e83fd")
    protected SmmRelationship(final Dependency elt) {
        super(elt);
    }

    @objid ("c67ff1a7-ac59-4e7e-acd9-0b3aaeea3188")
    public static SmmRelationship instantiate(final Dependency elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, SmmRelationship.STEREOTYPE_NAME))
            throw new Exception("Missing 'SmmRelationship' stereotype");
        return new SmmRelationship(elt);
    }

}
