/*
 * WARNING: GENERATED FILE - DO NOT EDIT
 * Module: SMM v0.1.14

 * This file was generated on 5/30/16 6:00 PM by Modelio Studio.
 */
package measure.smm.api.measurements.dependency;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import measure.smm.api.ISMMPeerModule;
import measure.smm.api.core.dependency.SmmRelationship;
import org.modelio.api.model.PropertyConverter;
import org.modelio.api.modelio.Modelio;
import org.modelio.metamodel.factory.ExtensionNotFoundException;
import org.modelio.metamodel.uml.infrastructure.Dependency;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyDefinition;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyTableDefinition;

@objid ("50ac0917-7422-43e3-b848-72a2817d4d78")
public class MeasurementRelationship extends SmmRelationship {
    @objid ("9d111f31-905d-4159-a32c-5aec24f12d76")
    public static final String STEREOTYPE_NAME = "MeasurementRelationship";

    @objid ("02f671dc-8a21-4262-a021-0a96ee3aa219")
    public Dependency getElement() {
        return (Dependency)super.getElement();
    }

    @objid ("d17d18e0-84e2-4a3b-8234-e48c7bd32aa3")
    public static MeasurementRelationship create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Dependency");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, MeasurementRelationship.STEREOTYPE_NAME);
        return MeasurementRelationship.instantiate((Dependency)e);
    }

    @objid ("de911c9c-0ea2-4927-849f-446a626aabb3")
    protected MeasurementRelationship(final Dependency elt) {
        super(elt);
    }

    @objid ("26a919be-2285-480f-91c9-3de1679495fa")
    public static MeasurementRelationship instantiate(final Dependency elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, MeasurementRelationship.STEREOTYPE_NAME))
            throw new Exception("Missing 'MeasurementRelationship' stereotype");
        return new MeasurementRelationship(elt);
    }

}
