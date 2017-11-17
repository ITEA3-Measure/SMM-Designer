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

@objid ("b6adff08-4a2f-4e98-b603-459a32b8e482")
public class BaseMeasurementRelationship extends MeasurementRelationship {
    @objid ("99ae67d9-c263-4c0c-81d0-d5d74a6cdc0e")
    public static final String STEREOTYPE_NAME = "BaseMeasurementRelationship";

    @objid ("1e4b4c8c-813c-4c01-b2c2-ab4909913956")
    public Dependency getElement() {
        return (Dependency)super.getElement();
    }

    @objid ("30401075-bc12-4d58-bd54-41bc7e1d9500")
    public static BaseMeasurementRelationship create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Dependency");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, BaseMeasurementRelationship.STEREOTYPE_NAME);
        return BaseMeasurementRelationship.instantiate((Dependency)e);
    }

    @objid ("250e3964-3b3e-4a62-89ad-375f0aa20cff")
    protected BaseMeasurementRelationship(final Dependency elt) {
        super(elt);
    }

    @objid ("cfa44944-e37e-4935-a567-5c7c1cec4996")
    public static BaseMeasurementRelationship instantiate(final Dependency elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, BaseMeasurementRelationship.STEREOTYPE_NAME))
            throw new Exception("Missing 'BaseMeasurementRelationship' stereotype");
        return new BaseMeasurementRelationship(elt);
    }

}
