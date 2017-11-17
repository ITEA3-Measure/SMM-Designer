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

@objid ("7f27c23a-1bcb-4428-880d-791c792bfac9")
public class EquivalentMeasurementRelationship extends MeasurementRelationship {
    @objid ("066cf668-13c4-4ed2-967b-83c917ad4f7e")
    public static final String STEREOTYPE_NAME = "EquivalentMeasurementRelationship";

    @objid ("f576cd42-d68e-4c58-a214-a4e7f559f3a0")
    public Dependency getElement() {
        return (Dependency)super.getElement();
    }

    @objid ("3c9f319d-b8eb-42a6-80b3-c605bc1c11df")
    public static EquivalentMeasurementRelationship create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Dependency");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, EquivalentMeasurementRelationship.STEREOTYPE_NAME);
        return EquivalentMeasurementRelationship.instantiate((Dependency)e);
    }

    @objid ("b070dbd9-f67f-4217-8a25-73bdc38603d0")
    protected EquivalentMeasurementRelationship(final Dependency elt) {
        super(elt);
    }

    @objid ("2c228fa5-6b70-4c56-b9bb-e8aa27626eb0")
    public static EquivalentMeasurementRelationship instantiate(final Dependency elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, EquivalentMeasurementRelationship.STEREOTYPE_NAME))
            throw new Exception("Missing 'EquivalentMeasurementRelationship' stereotype");
        return new EquivalentMeasurementRelationship(elt);
    }

}
