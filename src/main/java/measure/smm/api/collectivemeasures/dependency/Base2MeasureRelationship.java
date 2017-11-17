/*
 * WARNING: GENERATED FILE - DO NOT EDIT
 * Module: SMM v0.1.14

 * This file was generated on 5/30/16 6:00 PM by Modelio Studio.
 */
package measure.smm.api.collectivemeasures.dependency;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import measure.smm.api.ISMMPeerModule;
import org.modelio.api.model.PropertyConverter;
import org.modelio.api.modelio.Modelio;
import org.modelio.metamodel.factory.ExtensionNotFoundException;
import org.modelio.metamodel.uml.infrastructure.Dependency;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyDefinition;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyTableDefinition;

@objid ("69957acb-f7bd-4779-879f-008923be8a1a")
public class Base2MeasureRelationship extends BaseMeasureRelationhip {
    @objid ("89aa1570-3590-46c6-912e-61c44a3783c1")
    public static final String STEREOTYPE_NAME = "Base2MeasureRelationship";

    @objid ("dfb80b3e-c4b8-4724-89ff-29f7477f136e")
    public Dependency getElement() {
        return (Dependency)super.getElement();
    }

    @objid ("450e2b5e-1050-4df2-ba99-0dfbbec770bf")
    public static Base2MeasureRelationship create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Dependency");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, Base2MeasureRelationship.STEREOTYPE_NAME);
        return Base2MeasureRelationship.instantiate((Dependency)e);
    }

    @objid ("7cc4cfac-170c-4b28-a936-ec40df603f5c")
    protected Base2MeasureRelationship(final Dependency elt) {
        super(elt);
    }

    @objid ("83f1952b-4d43-41c5-a5bd-05c78801c2bf")
    public static Base2MeasureRelationship instantiate(final Dependency elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, Base2MeasureRelationship.STEREOTYPE_NAME))
            throw new Exception("Missing 'Base2MeasureRelationship' stereotype");
        return new Base2MeasureRelationship(elt);
    }

}
