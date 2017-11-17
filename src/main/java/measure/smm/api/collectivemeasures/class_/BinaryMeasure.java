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

@objid ("c4b20d2d-d593-429a-8b23-2a9464c976f0")
public class BinaryMeasure extends DimensionalMeasure {
    @objid ("4fecc115-2d46-4350-89c3-7b02ac6723fc")
    public static final String STEREOTYPE_NAME = "BinaryMeasure";

    @objid ("91b8b7c1-722d-4dfa-a0d3-67cddaae110d")
    public static final String CUSTOMFUNCTOR_BODY_TAGTYPE = "customFunctor_body";

    @objid ("a0119333-45f3-4569-b2a5-90be2b03720d")
    public static final String CUSTOMFUNCTOR_LANGUAGE_TAGTYPE = "customFunctor_language";

    @objid ("899780b2-b97b-49be-a7b4-993ec9470db0")
    public static final String FUNCTOR_TAGTYPE = "functor";

    @objid ("350c0869-8c42-4305-b527-29bcdeb832bd")
    public Class getElement() {
        return (Class)super.getElement();
    }

    @objid ("2e124caf-0518-4b85-bf70-95a9ba74e658")
    public static BinaryMeasure create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Class");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, BinaryMeasure.STEREOTYPE_NAME);
        return BinaryMeasure.instantiate((Class)e);
    }

    @objid ("bd54f9ce-c827-4b1f-becc-ea479caaebb9")
    protected BinaryMeasure(final Class elt) {
        super(elt);
    }

    @objid ("8016ed87-a7c1-47ec-b4f4-5cf29e5a793a")
    public static BinaryMeasure instantiate(final Class elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, BinaryMeasure.STEREOTYPE_NAME))
            throw new Exception("Missing 'BinaryMeasure' stereotype");
        return new BinaryMeasure(elt);
    }

    /**
     * Getter for property 'BinaryMeasure.functor'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("d6c733eb-ef85-47cd-ae0c-89cd1ace89b0")
    public String getFunctor() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, FUNCTOR_TAGTYPE);
    }

    /**
     * Setter for property 'BinaryMeasure.functor'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("0540841b-f5b6-45ee-8bbb-e00d267035b1")
    public void setFunctor(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, FUNCTOR_TAGTYPE, value);
    }

    /**
     * Getter for property 'BinaryMeasure.customFunctor_body'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("54607185-3e17-4142-adad-0df59906bfec")
    public String getCustomFunctor_body() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, CUSTOMFUNCTOR_BODY_TAGTYPE);
    }

    /**
     * Setter for property 'BinaryMeasure.customFunctor_body'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("5e179601-0d8b-4a5e-88e3-a94b74100bc1")
    public void setCustomFunctor_body(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, CUSTOMFUNCTOR_BODY_TAGTYPE, value);
    }

    /**
     * Getter for property 'BinaryMeasure.customFunctor_language'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("9f194dc4-50e0-4a2f-8313-3834dc54357a")
    public String getCustomFunctor_language() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, CUSTOMFUNCTOR_LANGUAGE_TAGTYPE);
    }

    /**
     * Setter for property 'BinaryMeasure.customFunctor_language'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("8dc6ec47-de1a-4795-8520-9f9b1f807fce")
    public void setCustomFunctor_language(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, CUSTOMFUNCTOR_LANGUAGE_TAGTYPE, value);
    }

}
