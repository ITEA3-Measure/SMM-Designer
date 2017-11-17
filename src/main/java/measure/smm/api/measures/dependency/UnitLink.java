/*
 * WARNING: GENERATED FILE - DO NOT EDIT
 * Module: SMM v0.1.14

 * This file was generated on 5/30/16 6:00 PM by Modelio Studio.
 */
package measure.smm.api.measures.dependency;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import measure.smm.api.ISMMPeerModule;
import org.modelio.api.model.PropertyConverter;
import org.modelio.api.modelio.Modelio;
import org.modelio.metamodel.factory.ExtensionNotFoundException;
import org.modelio.metamodel.uml.infrastructure.Dependency;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyDefinition;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyTableDefinition;

@objid ("74ee6a6a-d118-41d8-914f-1b2f00ef40ab")
public class UnitLink {
    @objid ("ade2966d-90ea-4e97-94d2-cc287dad498b")
    public static final String STEREOTYPE_NAME = "UnitLink";

    @objid ("eae88b80-5f39-43f2-bc22-949da3c43719")
    protected final Dependency elt;

    @objid ("20916641-9437-4505-a568-bdea47fd0b93")
    public Dependency getElement() {
        return this.elt;
    }

    @objid ("60d177ef-b331-47bc-8e36-021fba95e100")
    public static UnitLink create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Dependency");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, UnitLink.STEREOTYPE_NAME);
        return UnitLink.instantiate((Dependency)e);
    }

    @objid ("2a3f5e10-591f-4fc6-ad5a-8acf276bfdbb")
    protected UnitLink(final Dependency elt) {
        this.elt = elt;
    }

    @objid ("63990b06-8f5d-4627-aa2b-684c2eeeaa73")
    public static UnitLink instantiate(final Dependency elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, UnitLink.STEREOTYPE_NAME))
            throw new Exception("Missing 'UnitLink' stereotype");
        return new UnitLink(elt);
    }

}
