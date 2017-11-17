/*
 * WARNING: GENERATED FILE - DO NOT EDIT
 * Module: SMM v0.1.14

 * This file was generated on 5/30/16 6:00 PM by Modelio Studio.
 */
package measure.smm.api.collectivemeasures.dependency;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import measure.smm.api.ISMMPeerModule;
import measure.smm.api.measures.dependency.MeasureRelationship;
import org.modelio.api.model.PropertyConverter;
import org.modelio.api.modelio.Modelio;
import org.modelio.metamodel.factory.ExtensionNotFoundException;
import org.modelio.metamodel.uml.infrastructure.Dependency;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyDefinition;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyTableDefinition;

@objid ("7c107b6c-d02a-4a6c-a86d-d06c4087be76")
public class BaseMeasureRelationhip extends MeasureRelationship {
    @objid ("41976a8c-ce5d-4efe-b217-364534e8da2c")
    public static final String STEREOTYPE_NAME = "BaseMeasureRelationhip";

    @objid ("5ed449ef-87ae-41c2-a3c1-34eddcb34f61")
    public Dependency getElement() {
        return (Dependency)super.getElement();
    }

    @objid ("14641bab-292d-4c49-84e4-1ccc964f9719")
    public static BaseMeasureRelationhip create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Dependency");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, BaseMeasureRelationhip.STEREOTYPE_NAME);
        return BaseMeasureRelationhip.instantiate((Dependency)e);
    }

    @objid ("311202a9-7116-46bc-8b24-ff4b9ec878a1")
    protected BaseMeasureRelationhip(final Dependency elt) {
        super(elt);
    }

    @objid ("ff914329-cca4-4a0d-a2c0-44a619860abd")
    public static BaseMeasureRelationhip instantiate(final Dependency elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, BaseMeasureRelationhip.STEREOTYPE_NAME))
            throw new Exception("Missing 'BaseMeasureRelationhip' stereotype");
        return new BaseMeasureRelationhip(elt);
    }

}
