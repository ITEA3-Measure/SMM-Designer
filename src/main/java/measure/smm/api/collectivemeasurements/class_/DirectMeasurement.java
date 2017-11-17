/*
 * WARNING: GENERATED FILE - DO NOT EDIT
 * Module: SMM v0.1.14

 * This file was generated on 5/30/16 6:00 PM by Modelio Studio.
 */
package measure.smm.api.collectivemeasurements.class_;

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

@objid ("dc9091db-145a-41a3-bbb2-fddf1525d37d")
public class DirectMeasurement extends DimensionalMeasurement {
    @objid ("c3d062be-4309-46ed-9791-8c2715941590")
    public static final String STEREOTYPE_NAME = "DirectMeasurement";

    @objid ("77da12f8-78c8-46c1-a6cc-3a2ee3a43b52")
    public Class getElement() {
        return (Class)super.getElement();
    }

    @objid ("3db8c864-8d35-404c-a26b-8d5bfb24e46f")
    public static DirectMeasurement create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Class");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, DirectMeasurement.STEREOTYPE_NAME);
        return DirectMeasurement.instantiate((Class)e);
    }

    @objid ("12e2bb97-d913-4695-8d08-e48d9102f2a4")
    protected DirectMeasurement(final Class elt) {
        super(elt);
    }

    @objid ("af05a434-2a62-4f01-91e9-463fdda8bed7")
    public static DirectMeasurement instantiate(final Class elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, DirectMeasurement.STEREOTYPE_NAME))
            throw new Exception("Missing 'DirectMeasurement' stereotype");
        return new DirectMeasurement(elt);
    }

}
