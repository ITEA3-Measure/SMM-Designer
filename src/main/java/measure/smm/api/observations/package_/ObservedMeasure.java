/*
 * WARNING: GENERATED FILE - DO NOT EDIT
 * Module: SMM v0.1.14

 * This file was generated on 5/30/16 6:00 PM by Modelio Studio.
 */
package measure.smm.api.observations.package_;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import measure.smm.api.ISMMPeerModule;
import measure.smm.api.core.modelelement.SmmElement;
import org.modelio.api.model.PropertyConverter;
import org.modelio.api.modelio.Modelio;
import org.modelio.metamodel.factory.ExtensionNotFoundException;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyDefinition;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyTableDefinition;
import org.modelio.metamodel.uml.statik.Package;

@objid ("0d151dce-3986-4dfd-b2bd-69f7248454a3")
public class ObservedMeasure extends SmmElement {
    @objid ("2897a2ec-cfeb-40bd-aee6-ae26f1967329")
    public static final String STEREOTYPE_NAME = "ObservedMeasure";

    @objid ("c65ed106-6284-4b37-ac17-42265592eb2d")
    public static final String ARGUMENT_TYPES_TAGTYPE = "argument_types";

    @objid ("547d250b-1b0e-4d85-9398-b186f4541d9d")
    public static final String ARGUMENT_VALUES_TAGTYPE = "argument_values";

    @objid ("87d2671a-def4-4b74-b0d0-22a65196dca5")
    public Package getElement() {
        return (Package)super.getElement();
    }

    @objid ("f3cc9cdc-d37b-4cd2-8bdb-eda199839624")
    public static ObservedMeasure create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Package");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, ObservedMeasure.STEREOTYPE_NAME);
        return ObservedMeasure.instantiate((Package)e);
    }

    @objid ("03966e72-4d17-449d-9030-0a65e745fe42")
    protected ObservedMeasure(final Package elt) {
        super(elt);
    }

    @objid ("f012f3e9-4006-41a5-b948-70827efc9c9a")
    public static ObservedMeasure instantiate(final Package elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, ObservedMeasure.STEREOTYPE_NAME))
            throw new Exception("Missing 'ObservedMeasure' stereotype");
        return new ObservedMeasure(elt);
    }

    /**
     * Getter for property 'ObservedMeasure.argument_types'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("607ebbd2-b63d-4584-a77b-25cd2f3bb2f3")
    public String getArgument_types() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, ARGUMENT_TYPES_TAGTYPE);
    }

    /**
     * Setter for property 'ObservedMeasure.argument_types'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("8352b23a-5a2b-41f0-9583-a4a74a2c64ff")
    public void setArgument_types(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, ARGUMENT_TYPES_TAGTYPE, value);
    }

    /**
     * Getter for property 'ObservedMeasure.argument_values'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("16259b2c-f813-449c-aadf-4bbefac3c199")
    public String getArgument_values() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, ARGUMENT_VALUES_TAGTYPE);
    }

    /**
     * Setter for property 'ObservedMeasure.argument_values'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("98730031-1865-4690-b952-10067ae2ff66")
    public void setArgument_values(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, ARGUMENT_VALUES_TAGTYPE, value);
    }

}
