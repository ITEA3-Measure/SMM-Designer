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

@objid ("e31eff5e-d492-4c4c-bfd1-cb6a6471e701")
public class BaseNMeasurementRelationship extends MeasurementRelationship {
    @objid ("eddd29ce-6e67-4cd5-960c-0d82954bac3f")
    public static final String STEREOTYPE_NAME = "BaseNMeasurementRelationship";

    @objid ("838f2ac8-12d5-409b-adee-085753ff0c27")
    public Dependency getElement() {
        return (Dependency)super.getElement();
    }

    @objid ("0d7ee8ee-8713-4e8d-bae1-de0513f0a796")
    public static BaseNMeasurementRelationship create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Dependency");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, BaseNMeasurementRelationship.STEREOTYPE_NAME);
        return BaseNMeasurementRelationship.instantiate((Dependency)e);
    }

    @objid ("0bc237d5-dbdf-4811-b462-9d86f629e4a3")
    protected BaseNMeasurementRelationship(final Dependency elt) {
        super(elt);
    }

    @objid ("fd549906-3e03-4124-b1cf-8677cbefc095")
    public static BaseNMeasurementRelationship instantiate(final Dependency elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, BaseNMeasurementRelationship.STEREOTYPE_NAME))
            throw new Exception("Missing 'BaseNMeasurementRelationship' stereotype");
        return new BaseNMeasurementRelationship(elt);
    }

}
