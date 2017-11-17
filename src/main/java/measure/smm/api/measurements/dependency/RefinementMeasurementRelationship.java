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

@objid ("ced02d92-1d72-4880-b26e-853415e08635")
public class RefinementMeasurementRelationship extends MeasurementRelationship {
    @objid ("32192c0f-2f4a-47de-94dc-19fa40d446a5")
    public static final String STEREOTYPE_NAME = "RefinementMeasurementRelationship";

    @objid ("494c7232-a0bf-46f8-bb3f-e6bc29d38e61")
    public Dependency getElement() {
        return (Dependency)super.getElement();
    }

    @objid ("686cbad6-30ad-448c-bf53-4cc9464dfcb9")
    public static RefinementMeasurementRelationship create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Dependency");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, RefinementMeasurementRelationship.STEREOTYPE_NAME);
        return RefinementMeasurementRelationship.instantiate((Dependency)e);
    }

    @objid ("770b8ccc-9f7d-4619-9e4b-1f937c127d00")
    protected RefinementMeasurementRelationship(final Dependency elt) {
        super(elt);
    }

    @objid ("51ee8305-9f18-48d5-963a-4b677363ae44")
    public static RefinementMeasurementRelationship instantiate(final Dependency elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, RefinementMeasurementRelationship.STEREOTYPE_NAME))
            throw new Exception("Missing 'RefinementMeasurementRelationship' stereotype");
        return new RefinementMeasurementRelationship(elt);
    }

}
