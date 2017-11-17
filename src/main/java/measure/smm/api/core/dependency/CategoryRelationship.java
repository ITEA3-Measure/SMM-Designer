/*
 * WARNING: GENERATED FILE - DO NOT EDIT
 * Module: SMM v0.1.14

 * This file was generated on 5/30/16 6:00 PM by Modelio Studio.
 */
package measure.smm.api.core.dependency;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import measure.smm.api.ISMMPeerModule;
import org.modelio.api.model.PropertyConverter;
import org.modelio.api.modelio.Modelio;
import org.modelio.metamodel.factory.ExtensionNotFoundException;
import org.modelio.metamodel.uml.infrastructure.Dependency;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyDefinition;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyTableDefinition;

@objid ("f20f3595-b951-4d46-8412-2a918c48ef56")
public class CategoryRelationship extends SmmRelationship {
    @objid ("b234bc25-d103-45d4-8b93-aa5e32223aea")
    public static final String STEREOTYPE_NAME = "CategoryRelationship";

    @objid ("930b74a5-0f06-47bd-9af1-43c0f05c75ab")
    public Dependency getElement() {
        return (Dependency)super.getElement();
    }

    @objid ("5cae02f4-c0a9-41a4-84da-9edf2d2b50cd")
    public static CategoryRelationship create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Dependency");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, CategoryRelationship.STEREOTYPE_NAME);
        return CategoryRelationship.instantiate((Dependency)e);
    }

    @objid ("02b1789c-fe6f-490b-ab12-e039bb860a2c")
    protected CategoryRelationship(final Dependency elt) {
        super(elt);
    }

    @objid ("79900ca2-85ce-47b3-b1ea-ee9c808900cd")
    public static CategoryRelationship instantiate(final Dependency elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, CategoryRelationship.STEREOTYPE_NAME))
            throw new Exception("Missing 'CategoryRelationship' stereotype");
        return new CategoryRelationship(elt);
    }

}
