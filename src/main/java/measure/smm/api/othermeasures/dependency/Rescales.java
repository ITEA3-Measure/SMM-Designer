/*
 * WARNING: GENERATED FILE - DO NOT EDIT
 * Module: SMM v0.1.14

 * This file was generated on 5/30/16 6:00 PM by Modelio Studio.
 */
package measure.smm.api.othermeasures.dependency;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import measure.smm.api.ISMMPeerModule;
import org.modelio.api.model.PropertyConverter;
import org.modelio.api.modelio.Modelio;
import org.modelio.metamodel.factory.ExtensionNotFoundException;
import org.modelio.metamodel.uml.infrastructure.Dependency;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyDefinition;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyTableDefinition;

@objid ("09e40b3a-eae7-46b2-9290-61fa172946f9")
public class Rescales {
    @objid ("56b4ad74-8905-41dd-9164-8b8fed213b83")
    public static final String STEREOTYPE_NAME = "Rescales";

    @objid ("273959fb-2714-4a20-98ed-49d5801ded0f")
    protected final Dependency elt;

    @objid ("34639ce9-4958-497c-b3be-99fcc726645c")
    public Dependency getElement() {
        return this.elt;
    }

    @objid ("a6d62e45-8989-47ce-905e-d4b34d5ddcdf")
    public static Rescales create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Dependency");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, Rescales.STEREOTYPE_NAME);
        return Rescales.instantiate((Dependency)e);
    }

    @objid ("e9af446e-004a-4806-988e-0e6a4fe71254")
    protected Rescales(final Dependency elt) {
        this.elt = elt;
    }

    @objid ("f9c0eb31-1e61-4746-82ce-5a7c84756d18")
    public static Rescales instantiate(final Dependency elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, Rescales.STEREOTYPE_NAME))
            throw new Exception("Missing 'Rescales' stereotype");
        return new Rescales(elt);
    }

}
