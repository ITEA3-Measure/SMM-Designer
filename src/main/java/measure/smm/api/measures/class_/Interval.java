/*
 * WARNING: GENERATED FILE - DO NOT EDIT
 * Module: SMM v0.1.14

 * This file was generated on 5/30/16 6:00 PM by Modelio Studio.
 */
package measure.smm.api.measures.class_;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import measure.smm.api.ISMMPeerModule;
import measure.smm.api.core.modelelement.SmmElement;
import org.modelio.api.model.PropertyConverter;
import org.modelio.api.modelio.Modelio;
import org.modelio.metamodel.factory.ExtensionNotFoundException;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyDefinition;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyTableDefinition;
import org.modelio.metamodel.uml.statik.Class;

@objid ("621f2df5-3632-489a-8c17-121ed7a1d9f6")
public class Interval extends SmmElement {
    @objid ("372f452c-91a8-4614-8971-a39b56803b24")
    public static final String STEREOTYPE_NAME = "Interval";

    @objid ("50230482-7312-47b2-98d8-76c7aabe893a")
    public static final String MAXIMUM_TAGTYPE = "maximum";

    @objid ("eb7f8f3a-1ddc-4ee1-a2f6-f4d042c9310f")
    public static final String MAXIMUMOPEN_TAGTYPE = "maximumOpen";

    @objid ("b3212d49-ce51-43e2-8b86-b1592e4c2029")
    public static final String MINIMUM_TAGTYPE = "minimum";

    @objid ("8f58df11-0f13-49e9-8fc0-e2c11acdcb0c")
    public static final String MINIMUMOPEN_TAGTYPE = "minimumOpen";

    @objid ("634f8a93-addb-42d6-9204-830bef21619b")
    public Class getElement() {
        return (Class)super.getElement();
    }

    @objid ("c66022f8-c25a-435b-b24c-68ee2203b828")
    public static Interval create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Class");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, Interval.STEREOTYPE_NAME);
        return Interval.instantiate((Class)e);
    }

    @objid ("18bffa8b-1d31-4e78-813f-bf13e21051cf")
    protected Interval(final Class elt) {
        super(elt);
    }

    @objid ("4b9c06a5-3c3c-4b82-b16e-c137b5c405af")
    public static Interval instantiate(final Class elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, Interval.STEREOTYPE_NAME))
            throw new Exception("Missing 'Interval' stereotype");
        return new Interval(elt);
    }

    /**
     * Getter for property 'Interval.maximumOpen'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("96d80f1f-767f-421e-9e4e-a6a299d952b4")
    public String getMaximumOpen() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, MAXIMUMOPEN_TAGTYPE);
    }

    /**
     * Setter for property 'Interval.maximumOpen'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("aca9e229-1db2-4173-ba1b-8ed3d007326b")
    public void setMaximumOpen(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, MAXIMUMOPEN_TAGTYPE, value);
    }

    /**
     * Getter for property 'Interval.minimumOpen'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("dbc0dd2a-064c-4251-9d9f-e1c71bbc1973")
    public String getMinimumOpen() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, MINIMUMOPEN_TAGTYPE);
    }

    /**
     * Setter for property 'Interval.minimumOpen'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("9b2d65c6-80a2-47d6-85c4-dbfd9f3efb5e")
    public void setMinimumOpen(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, MINIMUMOPEN_TAGTYPE, value);
    }

    /**
     * Getter for property 'Interval.maximum'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("f52360a0-8199-4402-8ae5-52aecdc9047f")
    public String getMaximum() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, MAXIMUM_TAGTYPE);
    }

    /**
     * Setter for property 'Interval.maximum'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("0a438fd8-0a35-40a6-a18f-4a78ca3dca1f")
    public void setMaximum(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, MAXIMUM_TAGTYPE, value);
    }

    /**
     * Getter for property 'Interval.minimum'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("69c5c733-8e18-485d-9e47-5947e216efac")
    public String getMinimum() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, MINIMUM_TAGTYPE);
    }

    /**
     * Setter for property 'Interval.minimum'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("8af3974a-6a51-45a1-b942-cd4880178217")
    public void setMinimum(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, MINIMUM_TAGTYPE, value);
    }

}
