/*
 * WARNING: GENERATED FILE - DO NOT EDIT
 * Module: SMM v0.1.14

 * This file was generated on 5/30/16 6:00 PM by Modelio Studio.
 */
package measure.smm.api.observations.dependency;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import measure.smm.api.ISMMPeerModule;
import org.modelio.api.model.PropertyConverter;
import org.modelio.api.modelio.Modelio;
import org.modelio.metamodel.factory.ExtensionNotFoundException;
import org.modelio.metamodel.uml.infrastructure.Dependency;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyDefinition;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyTableDefinition;

@objid ("2277ce19-92c8-4d09-a324-ff9e5b75e1ec")
public class ObservedMeasurement {
    @objid ("21583ee0-8973-462f-9632-fcd79271083d")
    public static final String STEREOTYPE_NAME = "ObservedMeasurement";

    @objid ("d0995d27-9ffd-4bba-aa43-e98260e41032")
    protected final Dependency elt;

    @objid ("d73c2eb5-f147-46ab-bcc4-06154d189733")
    public Dependency getElement() {
        return this.elt;
    }

    @objid ("f401e1e2-4ca3-4670-a4b2-075c54e1102c")
    public static ObservedMeasurement create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Dependency");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, ObservedMeasurement.STEREOTYPE_NAME);
        return ObservedMeasurement.instantiate((Dependency)e);
    }

    @objid ("5e8ddcdd-aa6b-4f06-8bed-56ae4a615ad2")
    protected ObservedMeasurement(final Dependency elt) {
        this.elt = elt;
    }

    @objid ("2cc7eb3c-b095-4edf-8a38-23232b051209")
    public static ObservedMeasurement instantiate(final Dependency elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, ObservedMeasurement.STEREOTYPE_NAME))
            throw new Exception("Missing 'ObservedMeasurement' stereotype");
        return new ObservedMeasurement(elt);
    }

}
