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

@objid ("cd6685c8-a59a-4d91-a7ad-bfddfefee466")
public class DimensionalMeasure extends Measure {
    @objid ("f073f3e0-94a0-4e1b-97ff-b6288d9f7a60")
    public static final String STEREOTYPE_NAME = "DimensionalMeasure";

    @objid ("5850a987-a6c5-458f-b871-34dc46939d43")
    public static final String FORMULA_TAGTYPE = "formula";

    @objid ("9d7c6c85-82ba-4c06-8cee-c5e890603366")
    public Class getElement() {
        return (Class)super.getElement();
    }

    @objid ("6de69994-e3e1-4ef3-9ae7-6cc7996f9ecd")
    public static DimensionalMeasure create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Class");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, DimensionalMeasure.STEREOTYPE_NAME);
        return DimensionalMeasure.instantiate((Class)e);
    }

    @objid ("cd58a63b-3c6b-4ea8-9b09-52efda420b0c")
    protected DimensionalMeasure(final Class elt) {
        super(elt);
    }

    @objid ("30f5cf55-92ef-4c6b-95ed-f5704a8bd83b")
    public static DimensionalMeasure instantiate(final Class elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, DimensionalMeasure.STEREOTYPE_NAME))
            throw new Exception("Missing 'DimensionalMeasure' stereotype");
        return new DimensionalMeasure(elt);
    }

    /**
     * Getter for property 'DimensionalMeasure.formula'
     * <p>Property description:
     * <br/><i>
     * </i></p>
     */
    @objid ("e29379e0-20ac-4751-9bce-811433f4b3bd")
    public String getFormula() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, FORMULA_TAGTYPE);
    }

    /**
     * Setter for property 'DimensionalMeasure.formula'
     * <p>Property description:
     * <br/><i>
     * </i></p>
     */
    @objid ("7176315e-ce77-4026-a62b-57f71f84f67a")
    public void setFormula(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, FORMULA_TAGTYPE, value);
    }

}
