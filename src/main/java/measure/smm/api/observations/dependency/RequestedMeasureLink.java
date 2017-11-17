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

@objid ("278116c8-13e9-464a-96d2-bc0888a48983")
public class RequestedMeasureLink {
    @objid ("2716ed23-c290-470a-b4bd-0bdd73db828e")
    public static final String STEREOTYPE_NAME = "RequestedMeasureLink";

    @objid ("b087fdaf-4a96-49f8-a2e1-8e42276ca74d")
    protected final Dependency elt;

    @objid ("2185b767-6861-4be3-8c8f-9ab8aec67ef5")
    public Dependency getElement() {
        return this.elt;
    }

    @objid ("cd2565bc-11a7-4e47-99c8-a897d7a50813")
    public static RequestedMeasureLink create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Dependency");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, RequestedMeasureLink.STEREOTYPE_NAME);
        return RequestedMeasureLink.instantiate((Dependency)e);
    }

    @objid ("0f12a24a-f3ed-412f-8bda-e1758965a8e7")
    protected RequestedMeasureLink(final Dependency elt) {
        this.elt = elt;
    }

    @objid ("20a23b3b-9cdb-4d7b-8176-faa13633db10")
    public static RequestedMeasureLink instantiate(final Dependency elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, RequestedMeasureLink.STEREOTYPE_NAME))
            throw new Exception("Missing 'RequestedMeasureLink' stereotype");
        return new RequestedMeasureLink(elt);
    }

}
