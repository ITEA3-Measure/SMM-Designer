/*
 * WARNING: GENERATED FILE - DO NOT EDIT
 * Module: SMM v0.1.14

 * This file was generated on 5/30/16 6:00 PM by Modelio Studio.
 */
package measure.smm.api.collectivemeasures.class_;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import measure.smm.api.ISMMPeerModule;
import org.modelio.api.model.PropertyConverter;
import org.modelio.api.modelio.Modelio;
import org.modelio.metamodel.factory.ExtensionNotFoundException;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyDefinition;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyTableDefinition;
import org.modelio.metamodel.uml.statik.Class;

@objid ("0fc44fbe-e4c9-4fc9-87ba-7a21abae0258")
public class RatioMeasure extends BinaryMeasure {
    @objid ("400b8073-7f57-4715-92d2-75236e44395a")
    public static final String STEREOTYPE_NAME = "RatioMeasure";

    @objid ("3690383c-5ea0-4dc0-aca0-8284a6c78d03")
    public Class getElement() {
        return (Class)super.getElement();
    }

    @objid ("d9225c12-a605-44e4-b9ac-224e4930e20a")
    public static RatioMeasure create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Class");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, RatioMeasure.STEREOTYPE_NAME);
        return RatioMeasure.instantiate((Class)e);
    }

    @objid ("83df0436-1662-4b11-ba49-6f0f5c5f4688")
    protected RatioMeasure(final Class elt) {
        super(elt);
    }

    @objid ("7001db29-a3ad-4aa0-a4bc-ff5c6e49aebc")
    public static RatioMeasure instantiate(final Class elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, RatioMeasure.STEREOTYPE_NAME))
            throw new Exception("Missing 'RatioMeasure' stereotype");
        return new RatioMeasure(elt);
    }

}
