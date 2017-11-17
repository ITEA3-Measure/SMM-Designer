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

@objid ("d2aed32b-f167-4e65-b465-b3e8215c78f5")
public class Observation extends SmmElement {
    @objid ("a4eb78ff-2c45-4ab2-a99d-c2e1f486a079")
    public static final String STEREOTYPE_NAME = "Observation";

    @objid ("67b97fa4-c5b2-4848-b9ce-1a5b8a7778e9")
    public static final String ARGUMENT_TYPES_TAGTYPE = "argument_types";

    @objid ("bad64f5f-8fa3-468a-a8eb-a3f06b53f59f")
    public static final String ARGUMENT_VALUES_TAGTYPE = "argument_values";

    @objid ("3ea2d0a4-799c-4fa4-a09a-168c94578935")
    public static final String OBSERVATIONSCOPE_TAGTYPE = "observationScope";

    @objid ("c277f6bc-527e-488a-8e80-5d8cb17f01c5")
    public static final String OBSERVER_TAGTYPE = "observer";

    @objid ("6deb3233-561e-4236-af73-4ac78095d31c")
    public static final String TOOL_TAGTYPE = "tool";

    @objid ("5ed9d515-b348-4e94-b1d5-3bc8fbd2363a")
    public static final String WHENOBSERVED_TAGTYPE = "whenObserved";

    @objid ("f757a787-9292-4305-b24e-dfa9bc5c0742")
    public Package getElement() {
        return (Package)super.getElement();
    }

    @objid ("cbe6e235-9059-4fc8-a8c1-bcb9d3ca5e15")
    public static Observation create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Package");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, Observation.STEREOTYPE_NAME);
        return Observation.instantiate((Package)e);
    }

    @objid ("66c31e7d-b716-4cb7-b1f8-bc90afefc8e1")
    protected Observation(final Package elt) {
        super(elt);
    }

    @objid ("c2a38b9a-c105-4c75-9f49-fe83be2a0b9b")
    public static Observation instantiate(final Package elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, Observation.STEREOTYPE_NAME))
            throw new Exception("Missing 'Observation' stereotype");
        return new Observation(elt);
    }

    /**
     * Getter for property 'Observation.whenObserved'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("17031904-9900-4ef4-abf4-b70ac5558a35")
    public String getWhenObserved() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, WHENOBSERVED_TAGTYPE);
    }

    /**
     * Setter for property 'Observation.whenObserved'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("2324014a-02ab-4afd-98ff-b1fdc4ae4fe3")
    public void setWhenObserved(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, WHENOBSERVED_TAGTYPE, value);
    }

    /**
     * Getter for property 'Observation.tool'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("ca94f290-0c84-4ddb-8ba0-5ecee919126b")
    public String getTool() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, TOOL_TAGTYPE);
    }

    /**
     * Setter for property 'Observation.tool'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("4f041f46-ab30-4cca-bc24-55f9fa1308ca")
    public void setTool(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, TOOL_TAGTYPE, value);
    }

    /**
     * Getter for property 'Observation.observer'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("5fac3364-8964-464f-8641-fb3c9f49bde8")
    public String getObserver() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, OBSERVER_TAGTYPE);
    }

    /**
     * Setter for property 'Observation.observer'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("d973b048-1061-4a31-be3c-453b4bec7b40")
    public void setObserver(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, OBSERVER_TAGTYPE, value);
    }

    /**
     * Getter for property 'Observation.observationScope'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("d7de749c-3c73-44fa-bd28-c30b2bea5f8e")
    public String getObservationScope() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, OBSERVATIONSCOPE_TAGTYPE);
    }

    /**
     * Setter for property 'Observation.observationScope'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("7863f05f-2d0c-494a-a91b-5236b7741bd5")
    public void setObservationScope(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, OBSERVATIONSCOPE_TAGTYPE, value);
    }

    /**
     * Getter for property 'Observation.argument_values'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("275d77c5-e388-4b05-9583-782191e037bf")
    public String getArgument_values() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, ARGUMENT_VALUES_TAGTYPE);
    }

    /**
     * Setter for property 'Observation.argument_values'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("835ecfab-a7a7-4a2f-a61a-710ad50db2e3")
    public void setArgument_values(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, ARGUMENT_VALUES_TAGTYPE, value);
    }

    /**
     * Getter for property 'Observation.argument_types'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("5339cf68-4a41-4772-a889-2f9b4ac0feda")
    public String getArgument_types() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, ARGUMENT_TYPES_TAGTYPE);
    }

    /**
     * Setter for property 'Observation.argument_types'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("6cdff418-5afd-4fcb-be4c-684f7d6e5afb")
    public void setArgument_types(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, ARGUMENT_TYPES_TAGTYPE, value);
    }

}
