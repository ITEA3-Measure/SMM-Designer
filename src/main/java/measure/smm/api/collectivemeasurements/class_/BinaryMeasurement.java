/*
 * WARNING: GENERATED FILE - DO NOT EDIT
 * Module: SMM v0.1.14

 * This file was generated on 5/30/16 6:00 PM by Modelio Studio.
 */
package measure.smm.api.collectivemeasurements.class_;

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

@objid ("da7ca079-65fd-4233-a894-a351940e027b")
public class BinaryMeasurement extends DimensionalMeasurement {
    @objid ("8027a4b7-b192-41b8-aee7-bb7b3cc28056")
    public static final String STEREOTYPE_NAME = "BinaryMeasurement";

    @objid ("8ee0750b-bfb2-4f06-bbd8-e139bc6c4f24")
    public static final String BINARYMEASUREMENT_BASEQUERY_BODY_TAGTYPE = "BinaryMeasurement_baseQuery_body";

    @objid ("af2d39d3-9cf2-448c-98c2-fa34df8e006d")
    public static final String BINARYMEASUREMENT_BASEQUERY_LANGUAGE_TAGTYPE = "BinaryMeasurement_baseQuery_language";

    @objid ("4337203d-4d2f-49de-8eae-e09151241fdd")
    public static final String BINARYMEASUREMENT_ISBASESUPPLIED_TAGTYPE = "BinaryMeasurement_isBaseSupplied";

    @objid ("ebc30556-1d8d-48a3-a7ca-9269c18afa9c")
    public Class getElement() {
        return (Class)super.getElement();
    }

    @objid ("75cb911e-5d63-4c44-8eca-330d1bfe4a1f")
    public static BinaryMeasurement create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Class");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, BinaryMeasurement.STEREOTYPE_NAME);
        return BinaryMeasurement.instantiate((Class)e);
    }

    @objid ("b5b82124-1008-4a53-b7a8-9bfb6bfa1761")
    protected BinaryMeasurement(final Class elt) {
        super(elt);
    }

    @objid ("3c3e9550-9d8d-4214-acb5-79e9e3ccb0b7")
    public static BinaryMeasurement instantiate(final Class elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, BinaryMeasurement.STEREOTYPE_NAME))
            throw new Exception("Missing 'BinaryMeasurement' stereotype");
        return new BinaryMeasurement(elt);
    }

    /**
     * Getter for property 'BinaryMeasurement.BinaryMeasurement_isBaseSupplied'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("4adeff61-0469-409c-9c36-7bf4ddcf9fae")
    public String getBinaryMeasurement_isBaseSupplied() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, BINARYMEASUREMENT_ISBASESUPPLIED_TAGTYPE);
    }

    /**
     * Setter for property 'BinaryMeasurement.BinaryMeasurement_isBaseSupplied'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("22a0b9c7-3f04-422f-811c-6af6e72161fd")
    public void setBinaryMeasurement_isBaseSupplied(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, BINARYMEASUREMENT_ISBASESUPPLIED_TAGTYPE, value);
    }

    /**
     * Getter for property 'BinaryMeasurement.BinaryMeasurement_baseQuery_language'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("fd6e563f-53ec-4528-b297-5f8b2319886d")
    public String getBinaryMeasurement_baseQuery_language() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, BINARYMEASUREMENT_BASEQUERY_LANGUAGE_TAGTYPE);
    }

    /**
     * Setter for property 'BinaryMeasurement.BinaryMeasurement_baseQuery_language'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("ee70a0f2-eb7d-47ba-97a0-ccb33b10a25e")
    public void setBinaryMeasurement_baseQuery_language(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, BINARYMEASUREMENT_BASEQUERY_LANGUAGE_TAGTYPE, value);
    }

    /**
     * Getter for property 'BinaryMeasurement.BinaryMeasurement_baseQuery_body'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("8d6a509c-f913-404c-8cd8-9df403749709")
    public String getBinaryMeasurement_baseQuery_body() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, BINARYMEASUREMENT_BASEQUERY_BODY_TAGTYPE);
    }

    /**
     * Setter for property 'BinaryMeasurement.BinaryMeasurement_baseQuery_body'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("cc19c449-ab23-4922-8bdf-7ae9181fbadc")
    public void setBinaryMeasurement_baseQuery_body(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, BINARYMEASUREMENT_BASEQUERY_BODY_TAGTYPE, value);
    }

}
