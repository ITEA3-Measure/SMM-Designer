/*
 * WARNING: GENERATED FILE - DO NOT EDIT
 * Module: SMM v0.1.14

 * This file was generated on 5/30/16 6:00 PM by Modelio Studio.
 */
package measure.smm.api.collectivemeasures.class_;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import measure.smm.api.ISMMPeerModule;
import measure.smm.api.measures.class_.DimensionalMeasure;
import org.modelio.api.model.PropertyConverter;
import org.modelio.api.modelio.Modelio;
import org.modelio.metamodel.factory.ExtensionNotFoundException;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyDefinition;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyTableDefinition;
import org.modelio.metamodel.uml.statik.Class;

@objid ("ab93e41c-ad7d-4f4d-921d-005e0e540ccd")
public class DirectMeasure extends DimensionalMeasure {
    @objid ("fea9401c-76a1-41b4-afce-d2b4bdda0597")
    public static final String STEREOTYPE_NAME = "DirectMeasure";

    @objid ("50da03ad-5f6e-4256-9207-259e32d84e7c")
    public static final String OPERATION_BODY_TAGTYPE = "Operation_body";

    @objid ("d577e4cc-b0a7-49a2-9f3c-c8a820b2bcab")
    public static final String OPERATION_LANGUAGE_TAGTYPE = "Operation_language";

    @objid ("fd420f82-8c25-4745-8e76-d8c163e507ff")
    public Class getElement() {
        return (Class)super.getElement();
    }

    @objid ("c24fe47b-444b-4d75-9eb7-1dcefd453899")
    public static DirectMeasure create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Class");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, DirectMeasure.STEREOTYPE_NAME);
        return DirectMeasure.instantiate((Class)e);
    }

    @objid ("c646b3a4-3631-4030-90ea-121ab75ca1a6")
    protected DirectMeasure(final Class elt) {
        super(elt);
    }

    @objid ("9d58a8e4-b1d7-4554-947d-ec553a765e5d")
    public static DirectMeasure instantiate(final Class elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, DirectMeasure.STEREOTYPE_NAME))
            throw new Exception("Missing 'DirectMeasure' stereotype");
        return new DirectMeasure(elt);
    }

    /**
     * Getter for property 'DirectMeasure.Operation_language'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("9d93775d-2f31-4e84-a0ff-1cff11baca02")
    public String getOperation_language() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, OPERATION_LANGUAGE_TAGTYPE);
    }

    /**
     * Setter for property 'DirectMeasure.Operation_language'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("24cbab49-00ab-4f9f-9f76-f22e65092d27")
    public void setOperation_language(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, OPERATION_LANGUAGE_TAGTYPE, value);
    }

    /**
     * Getter for property 'DirectMeasure.Operation_body'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("31d780ca-e647-423b-af31-f3096e2927dd")
    public String getOperation_body() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, OPERATION_BODY_TAGTYPE);
    }

    /**
     * Setter for property 'DirectMeasure.Operation_body'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("b55519a4-d817-4ac0-b33e-15e0a4f9aec0")
    public void setOperation_body(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, OPERATION_BODY_TAGTYPE, value);
    }

}
