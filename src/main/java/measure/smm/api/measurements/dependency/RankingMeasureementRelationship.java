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

@objid ("564f4fdc-725a-4599-9751-dba3ea42d702")
public class RankingMeasureementRelationship extends MeasurementRelationship {
    @objid ("27c4896c-7339-44d5-b7a4-f4f489221bb3")
    public static final String STEREOTYPE_NAME = "RankingMeasureementRelationship";

    @objid ("a96e5adf-3efd-422b-8bd3-f64e0e6758fa")
    public Dependency getElement() {
        return (Dependency)super.getElement();
    }

    @objid ("98c504e8-632d-4520-bde0-1f3aae5f85f7")
    public static RankingMeasureementRelationship create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Dependency");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, RankingMeasureementRelationship.STEREOTYPE_NAME);
        return RankingMeasureementRelationship.instantiate((Dependency)e);
    }

    @objid ("c67c9dc9-b0c5-494a-b35f-81d816eb3dfc")
    protected RankingMeasureementRelationship(final Dependency elt) {
        super(elt);
    }

    @objid ("6e9cc192-bf72-422b-b8c4-486f0d202f7d")
    public static RankingMeasureementRelationship instantiate(final Dependency elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, RankingMeasureementRelationship.STEREOTYPE_NAME))
            throw new Exception("Missing 'RankingMeasureementRelationship' stereotype");
        return new RankingMeasureementRelationship(elt);
    }

}
