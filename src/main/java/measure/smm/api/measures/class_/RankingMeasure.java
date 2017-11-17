/*
 * WARNING: GENERATED FILE - DO NOT EDIT
 * Module: SMM v0.1.14

 * This file was generated on 5/30/16 6:00 PM by Modelio Studio.
 */
package measure.smm.api.measures.class_;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import measure.smm.api.ISMMPeerModule;
import org.modelio.api.model.PropertyConverter;
import org.modelio.api.modelio.Modelio;
import org.modelio.metamodel.factory.ExtensionNotFoundException;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyDefinition;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyTableDefinition;
import org.modelio.metamodel.uml.statik.Class;

@objid ("ded71b8c-fa4c-4b07-a218-467f17b27120")
public class RankingMeasure extends DimensionalMeasure {
    @objid ("d38918a5-3d99-4e37-90d9-4f487272b14f")
    public static final String STEREOTYPE_NAME = "RankingMeasure";

    @objid ("bb91bfa5-3873-4a81-a63a-4d36e0f7ab0d")
    public Class getElement() {
        return (Class)super.getElement();
    }

    @objid ("028b0ac2-8509-440f-b8df-b69b30750967")
    public static RankingMeasure create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Class");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, RankingMeasure.STEREOTYPE_NAME);
        return RankingMeasure.instantiate((Class)e);
    }

    @objid ("c3a16a2c-2510-4547-9c89-36d8b1027e22")
    protected RankingMeasure(final Class elt) {
        super(elt);
    }

    @objid ("e33d588c-d57c-4a02-8e84-858a10628bba")
    public static RankingMeasure instantiate(final Class elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, RankingMeasure.STEREOTYPE_NAME))
            throw new Exception("Missing 'RankingMeasure' stereotype");
        return new RankingMeasure(elt);
    }

}
