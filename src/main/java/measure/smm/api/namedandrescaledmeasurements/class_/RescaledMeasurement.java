/*
 * WARNING: GENERATED FILE - DO NOT EDIT
 * Module: SMM v0.1.14

 * This file was generated on 5/30/16 6:00 PM by Modelio Studio.
 */
package measure.smm.api.namedandrescaledmeasurements.class_;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import measure.smm.api.ISMMPeerModule;
import measure.smm.api.measurements.class_.DimensionalMeasurement;
import org.modelio.api.model.PropertyConverter;
import org.modelio.api.modelio.Modelio;
import org.modelio.metamodel.factory.ExtensionNotFoundException;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyDefinition;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyTableDefinition;
import org.modelio.metamodel.uml.statik.Class;

@objid ("b9000821-e820-4017-a63d-14c3dc59f21e")
public class RescaledMeasurement extends DimensionalMeasurement {
    @objid ("fd7873a0-04f2-4cc6-947c-f093ac55f9d6")
    public static final String STEREOTYPE_NAME = "RescaledMeasurement";

    @objid ("e1f00be8-660d-419b-8fdf-a4ed5bb04d6b")
    public static final String RESCALEDMEASUREMENT_BASEQUERY_BODY_TAGTYPE = "RescaledMeasurement_baseQuery_body";

    @objid ("bd201b47-f6cc-4564-a98d-2272c813b567")
    public static final String RESCALEDMEASUREMENT_BASEQUERY_LANGUAGE_TAGTYPE = "RescaledMeasurement_baseQuery_language";

    @objid ("0f7535a3-cb9e-4d20-a27a-b456c4263da3")
    public static final String RESCALEDMEASUREMENT_ISBASESUPPLIED_TAGTYPE = "RescaledMeasurement_isBaseSupplied";

    @objid ("4548a122-2ce2-4c77-bfec-a7d5a1a94e45")
    public Class getElement() {
        return (Class)super.getElement();
    }

    @objid ("adbccd1d-364f-44ff-a4f8-611610ae977b")
    public static RescaledMeasurement create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Class");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, RescaledMeasurement.STEREOTYPE_NAME);
        return RescaledMeasurement.instantiate((Class)e);
    }

    @objid ("93911d30-e40e-4b08-a26c-4ef48114b5cb")
    protected RescaledMeasurement(final Class elt) {
        super(elt);
    }

    @objid ("805f3085-2918-489f-935b-cef2c4bb3049")
    public static RescaledMeasurement instantiate(final Class elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, RescaledMeasurement.STEREOTYPE_NAME))
            throw new Exception("Missing 'RescaledMeasurement' stereotype");
        return new RescaledMeasurement(elt);
    }

    /**
     * Getter for property 'RescaledMeasurement.RescaledMeasurement_isBaseSupplied'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("33a41b85-dd20-40ff-a28c-6a2ff2b50568")
    public String getRescaledMeasurement_isBaseSupplied() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, RESCALEDMEASUREMENT_ISBASESUPPLIED_TAGTYPE);
    }

    /**
     * Setter for property 'RescaledMeasurement.RescaledMeasurement_isBaseSupplied'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("474cbc97-ab49-49d7-b8f0-c8a68a5bf073")
    public void setRescaledMeasurement_isBaseSupplied(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, RESCALEDMEASUREMENT_ISBASESUPPLIED_TAGTYPE, value);
    }

    /**
     * Getter for property 'RescaledMeasurement.RescaledMeasurement_baseQuery_body'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("85d854a8-e948-47de-b74d-cfed042dcf4b")
    public String getRescaledMeasurement_baseQuery_body() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, RESCALEDMEASUREMENT_BASEQUERY_BODY_TAGTYPE);
    }

    /**
     * Setter for property 'RescaledMeasurement.RescaledMeasurement_baseQuery_body'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("0e118bca-562c-46d8-aec9-5e409e8a3e74")
    public void setRescaledMeasurement_baseQuery_body(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, RESCALEDMEASUREMENT_BASEQUERY_BODY_TAGTYPE, value);
    }

    /**
     * Getter for property 'RescaledMeasurement.RescaledMeasurement_baseQuery_language'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("c62c748a-d3ce-4890-9d3c-bad7a43bef5b")
    public String getRescaledMeasurement_baseQuery_language() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, RESCALEDMEASUREMENT_BASEQUERY_LANGUAGE_TAGTYPE);
    }

    /**
     * Setter for property 'RescaledMeasurement.RescaledMeasurement_baseQuery_language'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("ff0e5e79-176c-4f84-ade6-3e76e083388b")
    public void setRescaledMeasurement_baseQuery_language(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, RESCALEDMEASUREMENT_BASEQUERY_LANGUAGE_TAGTYPE, value);
    }

}
