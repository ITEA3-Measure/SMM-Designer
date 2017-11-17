/*
 * WARNING: GENERATED FILE - DO NOT EDIT
 * Module: SMM v0.1.14

 * This file was generated on 5/30/16 6:00 PM by Modelio Studio.
 */
package measure.smm.api.measurements.class_;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import measure.smm.api.ISMMPeerModule;
import org.modelio.api.model.PropertyConverter;
import org.modelio.api.modelio.Modelio;
import org.modelio.metamodel.factory.ExtensionNotFoundException;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyDefinition;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyTableDefinition;
import org.modelio.metamodel.uml.statik.Class;

@objid ("81047f25-d779-4d0b-a717-54db819d039c")
public class DimensionalMeasurement extends Measurement {
    @objid ("b2f66f1d-74c0-40d9-b846-7401606e354d")
    public static final String STEREOTYPE_NAME = "DimensionalMeasurement";

    @objid ("eba374ac-0c98-4b2e-989b-11565e857ea6")
    public static final String DIMENSIONALMEASUREMENT_VALUE_TAGTYPE = "DimensionalMeasurement_value";

    @objid ("cb979967-93e6-410e-9cbf-8ae41897ff36")
    public Class getElement() {
        return (Class)super.getElement();
    }

    @objid ("845d794d-2b00-4767-8592-b97b314789a0")
    public static DimensionalMeasurement create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Class");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, DimensionalMeasurement.STEREOTYPE_NAME);
        return DimensionalMeasurement.instantiate((Class)e);
    }

    @objid ("9983b8c4-fac6-4ba2-b604-0af95f9b51d3")
    protected DimensionalMeasurement(final Class elt) {
        super(elt);
    }

    @objid ("da32f764-e963-4a19-bd46-630ecb3570b6")
    public static DimensionalMeasurement instantiate(final Class elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, DimensionalMeasurement.STEREOTYPE_NAME))
            throw new Exception("Missing 'DimensionalMeasurement' stereotype");
        return new DimensionalMeasurement(elt);
    }

    /**
     * Getter for property 'DimensionalMeasurement.DimensionalMeasurement_value'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("57882b10-6943-41f8-83db-ef178690c32a")
    public String getDimensionalMeasurement_value() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, DIMENSIONALMEASUREMENT_VALUE_TAGTYPE);
    }

    /**
     * Setter for property 'DimensionalMeasurement.DimensionalMeasurement_value'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("593afa8a-4072-4b38-9ba1-1fac40d4bd07")
    public void setDimensionalMeasurement_value(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, DIMENSIONALMEASUREMENT_VALUE_TAGTYPE, value);
    }

}
