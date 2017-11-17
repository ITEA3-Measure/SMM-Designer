/*
 * WARNING: GENERATED FILE - DO NOT EDIT
 * Module: SMM v0.1.14

 * This file was generated on 5/30/16 6:00 PM by Modelio Studio.
 */
package measure.smm.api.namedandrescaledmeasurements.class_;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import measure.smm.api.ISMMPeerModule;
import measure.smm.api.measurements.class_.DimensionalMeasurement;
import org.modelio.api.model.PropertyConverter;
import org.modelio.api.modelio.Modelio;
import org.modelio.metamodel.factory.ExtensionNotFoundException;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyDefinition;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyTableDefinition;
import org.modelio.metamodel.uml.statik.Class;

@objid ("e80c888d-4ff6-4a43-ae4e-aa54e6f4de89")
public class NamedMeasurement extends DimensionalMeasurement {
    @objid ("b6214e74-3807-44a5-a0e7-6cb9e708eebf")
    public static final String STEREOTYPE_NAME = "NamedMeasurement";

    @objid ("564b5407-72fc-4fbb-a797-de27d5994c5e")
    public Class getElement() {
        return (Class)super.getElement();
    }

    @objid ("2dc92a13-ce8e-459e-9ecb-e00f968686ae")
    public static NamedMeasurement create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Class");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, NamedMeasurement.STEREOTYPE_NAME);
        return NamedMeasurement.instantiate((Class)e);
    }

    @objid ("b89c44a2-a437-417c-8b98-2d05f0cdc950")
    protected NamedMeasurement(final Class elt) {
        super(elt);
    }

    @objid ("2b00a7ce-380b-4b1d-83dd-5247f3d33680")
    public static NamedMeasurement instantiate(final Class elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, NamedMeasurement.STEREOTYPE_NAME))
            throw new Exception("Missing 'NamedMeasurement' stereotype");
        return new NamedMeasurement(elt);
    }

}
