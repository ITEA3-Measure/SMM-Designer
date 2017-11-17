/*
 * WARNING: GENERATED FILE - DO NOT EDIT
 * Module: SMM v0.1.14

 * This file was generated on 5/30/16 6:00 PM by Modelio Studio.
 */
package measure.smm.api.measures.dependency;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import measure.smm.api.ISMMPeerModule;
import org.modelio.api.model.PropertyConverter;
import org.modelio.api.modelio.Modelio;
import org.modelio.metamodel.factory.ExtensionNotFoundException;
import org.modelio.metamodel.uml.infrastructure.Dependency;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyDefinition;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyTableDefinition;

@objid ("444fc524-1be3-49c0-803e-07e611d60f48")
public class GradeMeasureRelationship extends MeasureRelationship {
    @objid ("99350cc2-a7d2-4db1-bf55-8c8001321617")
    public static final String STEREOTYPE_NAME = "GradeMeasureRelationship";

    @objid ("95653639-27b3-47fb-b201-cf1ccb8394a4")
    public Dependency getElement() {
        return (Dependency)super.getElement();
    }

    @objid ("03577ec2-9e3f-4292-83d6-9681275cb89c")
    public static GradeMeasureRelationship create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Dependency");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, GradeMeasureRelationship.STEREOTYPE_NAME);
        return GradeMeasureRelationship.instantiate((Dependency)e);
    }

    @objid ("a622da0f-63a3-412c-8978-d07332238d1b")
    protected GradeMeasureRelationship(final Dependency elt) {
        super(elt);
    }

    @objid ("d321bca9-8eed-42f2-9003-74cc1f1c5d24")
    public static GradeMeasureRelationship instantiate(final Dependency elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, GradeMeasureRelationship.STEREOTYPE_NAME))
            throw new Exception("Missing 'GradeMeasureRelationship' stereotype");
        return new GradeMeasureRelationship(elt);
    }

}
