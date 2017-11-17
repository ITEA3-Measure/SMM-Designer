/*
 * WARNING: GENERATED FILE - DO NOT EDIT
 * Module: SMM v0.1.14

 * This file was generated on 5/30/16 6:00 PM by Modelio Studio.
 */
package measure.smm.api.measures.class_;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import measure.smm.api.ISMMPeerModule;
import measure.smm.api.measures.modelelement.AbstractMeasureElement;
import org.modelio.api.model.PropertyConverter;
import org.modelio.api.modelio.Modelio;
import org.modelio.metamodel.factory.ExtensionNotFoundException;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyDefinition;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyTableDefinition;
import org.modelio.metamodel.uml.statik.Class;

@objid ("5e157128-e82f-4c80-8d62-ee6e8269e5f4")
public class UnitOfMeasure extends AbstractMeasureElement {
    @objid ("c1ce17fa-964b-4408-b490-6f5e85acbaa2")
    public static final String STEREOTYPE_NAME = "UnitOfMeasure";

    @objid ("2107d491-2842-4def-baf7-a9cb0a263adf")
    public Class getElement() {
        return (Class)super.getElement();
    }

    @objid ("6bbcce9c-8ac6-498d-a10f-cdf7eb621048")
    public static UnitOfMeasure create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Class");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, UnitOfMeasure.STEREOTYPE_NAME);
        return UnitOfMeasure.instantiate((Class)e);
    }

    @objid ("cc600c06-8d0f-420e-842e-7a02a2083032")
    protected UnitOfMeasure(final Class elt) {
        super(elt);
    }

    @objid ("dc4a5412-4964-4f67-a2b6-a93f569fcca1")
    public static UnitOfMeasure instantiate(final Class elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, UnitOfMeasure.STEREOTYPE_NAME))
            throw new Exception("Missing 'UnitOfMeasure' stereotype");
        return new UnitOfMeasure(elt);
    }

}
