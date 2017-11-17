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

@objid ("1092bd31-a15a-4fbc-a147-2c5f9a2ad6db")
public class RefinementMeasureRelationship extends MeasureRelationship {
    @objid ("ee71dba6-f5f0-4c50-b5af-f76b9f3aaef7")
    public static final String STEREOTYPE_NAME = "RefinementMeasureRelationship";

    @objid ("589ff676-fa3c-494a-ad9f-f71a028ed56c")
    public Dependency getElement() {
        return (Dependency)super.getElement();
    }

    @objid ("7e19df43-2872-4ecf-8529-72a849643da5")
    public static RefinementMeasureRelationship create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Dependency");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, RefinementMeasureRelationship.STEREOTYPE_NAME);
        return RefinementMeasureRelationship.instantiate((Dependency)e);
    }

    @objid ("2d28594b-339a-49ff-b7ec-158d3a057a7d")
    protected RefinementMeasureRelationship(final Dependency elt) {
        super(elt);
    }

    @objid ("dc941797-6364-43a4-83f2-073f1a28175e")
    public static RefinementMeasureRelationship instantiate(final Dependency elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, RefinementMeasureRelationship.STEREOTYPE_NAME))
            throw new Exception("Missing 'RefinementMeasureRelationship' stereotype");
        return new RefinementMeasureRelationship(elt);
    }

}
