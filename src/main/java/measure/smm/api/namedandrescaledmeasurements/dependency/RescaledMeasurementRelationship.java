/*
 * WARNING: GENERATED FILE - DO NOT EDIT
 * Module: SMM v0.1.14

 * This file was generated on 5/30/16 6:00 PM by Modelio Studio.
 */
package measure.smm.api.namedandrescaledmeasurements.dependency;

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

@objid ("1e7e9257-1fc8-49d7-ae28-ae0cb1235e6e")
public class RescaledMeasurementRelationship extends MeasurementRelationship {
    @objid ("a2191b42-3f5e-4ee8-b401-109a9dc9bc22")
    public static final String STEREOTYPE_NAME = "RescaledMeasurementRelationship";

    @objid ("44b1fc58-3cda-47c2-913a-cf69dc3bd6b0")
    public Dependency getElement() {
        return (Dependency)super.getElement();
    }

    @objid ("dbcc727d-50c8-410f-981e-b41e8f8cb05d")
    public static RescaledMeasurementRelationship create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Dependency");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, RescaledMeasurementRelationship.STEREOTYPE_NAME);
        return RescaledMeasurementRelationship.instantiate((Dependency)e);
    }

    @objid ("19bb42c2-70b8-4f53-af53-1befffd56c7a")
    protected RescaledMeasurementRelationship(final Dependency elt) {
        super(elt);
    }

    @objid ("ab9df414-dc27-4bf7-b559-3feb7eb86d79")
    public static RescaledMeasurementRelationship instantiate(final Dependency elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, RescaledMeasurementRelationship.STEREOTYPE_NAME))
            throw new Exception("Missing 'RescaledMeasurementRelationship' stereotype");
        return new RescaledMeasurementRelationship(elt);
    }

}
