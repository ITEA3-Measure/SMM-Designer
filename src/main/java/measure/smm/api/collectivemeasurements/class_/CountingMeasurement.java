/*
 * WARNING: GENERATED FILE - DO NOT EDIT
 * Module: SMM v0.1.14

 * This file was generated on 5/30/16 6:00 PM by Modelio Studio.
 */
package measure.smm.api.collectivemeasurements.class_;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import measure.smm.api.ISMMPeerModule;
import org.modelio.api.model.PropertyConverter;
import org.modelio.api.modelio.Modelio;
import org.modelio.metamodel.factory.ExtensionNotFoundException;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyDefinition;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyTableDefinition;
import org.modelio.metamodel.uml.statik.Class;

@objid ("31cd6258-f9c4-48a4-bc23-bbd8b6ac39d5")
public class CountingMeasurement extends DirectMeasurement {
    @objid ("71c8047e-f616-4a8a-bf80-4fba7b653858")
    public static final String STEREOTYPE_NAME = "CountingMeasurement";

    @objid ("0afbf877-89ad-4556-88c8-115b5b2ff9a3")
    public Class getElement() {
        return (Class)super.getElement();
    }

    @objid ("9c00fdff-1033-49df-9f6f-875a6137cf85")
    public static CountingMeasurement create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Class");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, CountingMeasurement.STEREOTYPE_NAME);
        return CountingMeasurement.instantiate((Class)e);
    }

    @objid ("f5196621-620b-4e33-9813-b3c00868823c")
    protected CountingMeasurement(final Class elt) {
        super(elt);
    }

    @objid ("362355b0-e242-44b5-b1c0-13a027b044dc")
    public static CountingMeasurement instantiate(final Class elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, CountingMeasurement.STEREOTYPE_NAME))
            throw new Exception("Missing 'CountingMeasurement' stereotype");
        return new CountingMeasurement(elt);
    }

}
