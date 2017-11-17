/*
 * WARNING: GENERATED FILE - DO NOT EDIT
 * Module: SMM v0.1.14

 * This file was generated on 5/30/16 6:00 PM by Modelio Studio.
 */
package measure.smm.api.collectivemeasurements.dependency;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import measure.smm.api.ISMMPeerModule;
import measure.smm.api.measurements.dependency.MeasurementRelationship;
import org.modelio.api.model.PropertyConverter;
import org.modelio.api.modelio.Modelio;
import org.modelio.metamodel.factory.ExtensionNotFoundException;
import org.modelio.metamodel.uml.infrastructure.Dependency;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyDefinition;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyTableDefinition;

@objid ("8899ff38-c326-40b5-8824-a6cee04a067c")
public class Base1MeasurementRelationship extends MeasurementRelationship {
    @objid ("781c6ed7-842e-45c5-a005-e28d661d1098")
    public static final String STEREOTYPE_NAME = "Base1MeasurementRelationship";

    @objid ("ea537bf6-ac2a-461c-879c-0f5f36403a0d")
    public Dependency getElement() {
        return (Dependency)super.getElement();
    }

    @objid ("d6d2890a-ede7-4ce4-8f8a-3943c166359c")
    public static Base1MeasurementRelationship create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Dependency");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, Base1MeasurementRelationship.STEREOTYPE_NAME);
        return Base1MeasurementRelationship.instantiate((Dependency)e);
    }

    @objid ("e7a1c0aa-fcc0-4fc3-9f4f-e9ebdbe50d63")
    protected Base1MeasurementRelationship(final Dependency elt) {
        super(elt);
    }

    @objid ("7fc35b63-c6d5-430d-baed-1bd57c1e8be0")
    public static Base1MeasurementRelationship instantiate(final Dependency elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, Base1MeasurementRelationship.STEREOTYPE_NAME))
            throw new Exception("Missing 'Base1MeasurementRelationship' stereotype");
        return new Base1MeasurementRelationship(elt);
    }

}
