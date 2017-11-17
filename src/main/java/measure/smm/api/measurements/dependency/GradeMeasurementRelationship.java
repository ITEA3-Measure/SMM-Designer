/*
 * WARNING: GENERATED FILE - DO NOT EDIT
 * Module: SMM v0.1.14

 * This file was generated on 5/30/16 6:00 PM by Modelio Studio.
 */
package measure.smm.api.measurements.dependency;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import measure.smm.api.ISMMPeerModule;
import org.modelio.api.model.PropertyConverter;
import org.modelio.api.modelio.Modelio;
import org.modelio.metamodel.factory.ExtensionNotFoundException;
import org.modelio.metamodel.uml.infrastructure.Dependency;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyDefinition;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyTableDefinition;

@objid ("228d57ab-4f8e-4419-905d-826b66503e90")
public class GradeMeasurementRelationship extends MeasurementRelationship {
    @objid ("5042b3f8-24fc-4031-9b34-7a6c11a6dcd5")
    public static final String STEREOTYPE_NAME = "GradeMeasurementRelationship";

    @objid ("27327602-d72b-45b8-a428-07943a0a9f53")
    public Dependency getElement() {
        return (Dependency)super.getElement();
    }

    @objid ("5931f1d3-8bf1-48b9-807c-838524d3d952")
    public static GradeMeasurementRelationship create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Dependency");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, GradeMeasurementRelationship.STEREOTYPE_NAME);
        return GradeMeasurementRelationship.instantiate((Dependency)e);
    }

    @objid ("6a8db4c9-abbf-4fb9-9711-847b0251835c")
    protected GradeMeasurementRelationship(final Dependency elt) {
        super(elt);
    }

    @objid ("22ad5b0d-ccea-4b2a-9263-c9008aa319ad")
    public static GradeMeasurementRelationship instantiate(final Dependency elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, GradeMeasurementRelationship.STEREOTYPE_NAME))
            throw new Exception("Missing 'GradeMeasurementRelationship' stereotype");
        return new GradeMeasurementRelationship(elt);
    }

}
