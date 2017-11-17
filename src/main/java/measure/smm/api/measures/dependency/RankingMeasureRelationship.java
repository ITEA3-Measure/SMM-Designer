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

@objid ("cf64c284-2a19-4404-9359-eb09b7f5a92c")
public class RankingMeasureRelationship extends MeasureRelationship {
    @objid ("709f4bfc-cbf7-49ba-90cc-68329f0d4a22")
    public static final String STEREOTYPE_NAME = "RankingMeasureRelationship";

    @objid ("382cc6fc-e2d3-4662-b297-4938faeccfc7")
    public Dependency getElement() {
        return (Dependency)super.getElement();
    }

    @objid ("86258d50-7edb-4f85-b158-d6291e3509b3")
    public static RankingMeasureRelationship create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Dependency");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, RankingMeasureRelationship.STEREOTYPE_NAME);
        return RankingMeasureRelationship.instantiate((Dependency)e);
    }

    @objid ("9453f5aa-f28d-40d2-a976-a16868423a4c")
    protected RankingMeasureRelationship(final Dependency elt) {
        super(elt);
    }

    @objid ("ff736cfa-3059-48f2-81a2-79dc93e08541")
    public static RankingMeasureRelationship instantiate(final Dependency elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, RankingMeasureRelationship.STEREOTYPE_NAME))
            throw new Exception("Missing 'RankingMeasureRelationship' stereotype");
        return new RankingMeasureRelationship(elt);
    }

}
