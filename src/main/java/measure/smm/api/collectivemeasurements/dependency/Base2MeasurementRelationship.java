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

@objid ("0723bccd-63b6-412e-8f7d-12d62088b07c")
public class Base2MeasurementRelationship extends MeasurementRelationship {
    @objid ("c053b97d-595b-4ba0-8203-329bfd39732d")
    public static final String STEREOTYPE_NAME = "Base2MeasurementRelationship";

    @objid ("ba0a13c8-cc1a-469a-8018-903e3c8d51ac")
    public Dependency getElement() {
        return (Dependency)super.getElement();
    }

    @objid ("d60a482c-65f8-4f28-8c46-fcccda7230f5")
    public static Base2MeasurementRelationship create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Dependency");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, Base2MeasurementRelationship.STEREOTYPE_NAME);
        return Base2MeasurementRelationship.instantiate((Dependency)e);
    }

    @objid ("740b831a-49eb-4d8c-b72c-54330301a23c")
    protected Base2MeasurementRelationship(final Dependency elt) {
        super(elt);
    }

    @objid ("a4565b53-b24d-4d0d-9734-44a0f4f1f5a5")
    public static Base2MeasurementRelationship instantiate(final Dependency elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, Base2MeasurementRelationship.STEREOTYPE_NAME))
            throw new Exception("Missing 'Base2MeasurementRelationship' stereotype");
        return new Base2MeasurementRelationship(elt);
    }

}
