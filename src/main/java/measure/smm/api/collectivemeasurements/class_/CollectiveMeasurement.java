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

@objid ("954ab71f-34d9-4794-b02c-1423f03d589e")
public class CollectiveMeasurement extends DimensionalMeasurement {
    @objid ("752705c0-9480-4941-8496-09ef27b78fe7")
    public static final String STEREOTYPE_NAME = "CollectiveMeasurement";

    @objid ("c3b303ed-0009-46b2-80e9-a95c22fa5def")
    public static final String COLLECTIVEMEASUREMENT_BASE_QUERY_BODY_TAGTYPE = "CollectiveMeasurement_Base_query_body";

    @objid ("9799df20-52f2-4867-aa37-95803bfcc342")
    public static final String COLLECTIVEMEASUREMENT_BASE_QUERY_LANGUAGE_TAGTYPE = "CollectiveMeasurement_Base_query_language";

    @objid ("6bbf1925-92a3-44b9-8646-227bdfd807b6")
    public static final String COLLECTIVEMEASUREMENT_ISBASESUPPLIED_TAGTYPE = "CollectiveMeasurement_isBaseSupplied";

    @objid ("1b8507a7-15ef-4fec-88fd-255a6447246c")
    public Class getElement() {
        return (Class)super.getElement();
    }

    @objid ("41f4147f-119c-4fb1-96d8-1073373063a7")
    public static CollectiveMeasurement create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Class");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, CollectiveMeasurement.STEREOTYPE_NAME);
        return CollectiveMeasurement.instantiate((Class)e);
    }

    @objid ("0c66ad7b-25ee-4f8f-854e-da9da5a74109")
    protected CollectiveMeasurement(final Class elt) {
        super(elt);
    }

    @objid ("6840157d-e672-4d5b-ba96-be57da0935ce")
    public static CollectiveMeasurement instantiate(final Class elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, CollectiveMeasurement.STEREOTYPE_NAME))
            throw new Exception("Missing 'CollectiveMeasurement' stereotype");
        return new CollectiveMeasurement(elt);
    }

    /**
     * Getter for property 'CollectiveMeasurement.CollectiveMeasurement_Base_query_language'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("fab2ad3e-9a0b-4a21-8a25-343b9cd9eeea")
    public String getCollectiveMeasurement_Base_query_language() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, COLLECTIVEMEASUREMENT_BASE_QUERY_LANGUAGE_TAGTYPE);
    }

    /**
     * Setter for property 'CollectiveMeasurement.CollectiveMeasurement_Base_query_language'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("3aef3ed5-7df5-4c53-9b6c-c54f340b346d")
    public void setCollectiveMeasurement_Base_query_language(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, COLLECTIVEMEASUREMENT_BASE_QUERY_LANGUAGE_TAGTYPE, value);
    }

    /**
     * Getter for property 'CollectiveMeasurement.CollectiveMeasurement_Base_query_body'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("f88e4c80-0e11-41bf-92ff-b07a1123c3e8")
    public String getCollectiveMeasurement_Base_query_body() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, COLLECTIVEMEASUREMENT_BASE_QUERY_BODY_TAGTYPE);
    }

    /**
     * Setter for property 'CollectiveMeasurement.CollectiveMeasurement_Base_query_body'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("2aa960b1-5eab-4122-a75f-61d7fdd9bbe8")
    public void setCollectiveMeasurement_Base_query_body(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, COLLECTIVEMEASUREMENT_BASE_QUERY_BODY_TAGTYPE, value);
    }

    /**
     * Getter for property 'CollectiveMeasurement.CollectiveMeasurement_isBaseSupplied'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("688d96f8-a860-4fe7-b0d8-1da6b1702971")
    public String getCollectiveMeasurement_isBaseSupplied() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, COLLECTIVEMEASUREMENT_ISBASESUPPLIED_TAGTYPE);
    }

    /**
     * Setter for property 'CollectiveMeasurement.CollectiveMeasurement_isBaseSupplied'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("80133d4f-fe87-4659-b968-9cd881e6c1fb")
    public void setCollectiveMeasurement_isBaseSupplied(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, COLLECTIVEMEASUREMENT_ISBASESUPPLIED_TAGTYPE, value);
    }

}
