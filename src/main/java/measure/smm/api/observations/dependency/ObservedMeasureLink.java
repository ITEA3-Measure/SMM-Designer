/*
 * WARNING: GENERATED FILE - DO NOT EDIT
 * Module: SMM v0.1.14

 * This file was generated on 5/30/16 6:00 PM by Modelio Studio.
 */
package measure.smm.api.observations.dependency;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import measure.smm.api.ISMMPeerModule;
import org.modelio.api.model.PropertyConverter;
import org.modelio.api.modelio.Modelio;
import org.modelio.metamodel.factory.ExtensionNotFoundException;
import org.modelio.metamodel.uml.infrastructure.Dependency;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyDefinition;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyTableDefinition;

@objid ("bb14a760-da84-48b9-9abd-c4a3622b7e2a")
public class ObservedMeasureLink {
    @objid ("bac22369-d554-471f-9cc7-67e00518d06c")
    public static final String STEREOTYPE_NAME = "ObservedMeasureLink";

    @objid ("c9ceccd0-970b-4594-a0bb-96bdb0b85023")
    protected final Dependency elt;

    @objid ("c37fd214-b397-46c0-aecd-e1f6a71fdabc")
    public Dependency getElement() {
        return this.elt;
    }

    @objid ("82fff830-540d-475c-8d50-981783a67a29")
    public static ObservedMeasureLink create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Dependency");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, ObservedMeasureLink.STEREOTYPE_NAME);
        return ObservedMeasureLink.instantiate((Dependency)e);
    }

    @objid ("0add3a94-0f00-446c-aa5d-f25ea5296fc9")
    protected ObservedMeasureLink(final Dependency elt) {
        this.elt = elt;
    }

    @objid ("df8e4acb-0740-4696-95af-98554faa8c9d")
    public static ObservedMeasureLink instantiate(final Dependency elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, ObservedMeasureLink.STEREOTYPE_NAME))
            throw new Exception("Missing 'ObservedMeasureLink' stereotype");
        return new ObservedMeasureLink(elt);
    }

}
