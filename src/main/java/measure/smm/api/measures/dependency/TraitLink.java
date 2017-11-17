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

@objid ("df89ac5a-b634-4082-aef2-6669c7430990")
public class TraitLink {
    @objid ("1d1766e5-2b7b-4c8a-a0a7-8bd2d7012bf6")
    public static final String STEREOTYPE_NAME = "TraitLink";

    @objid ("76686cc9-31a1-49d6-bc11-886aeaff098d")
    protected final Dependency elt;

    @objid ("72fb3b8c-4025-4133-b0c4-61da17310680")
    public Dependency getElement() {
        return this.elt;
    }

    @objid ("b0cf5bed-596a-40fd-bf06-87c7e81dfb9a")
    public static TraitLink create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Dependency");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, TraitLink.STEREOTYPE_NAME);
        return TraitLink.instantiate((Dependency)e);
    }

    @objid ("c95f6337-3a76-4e6d-aef9-cbb71af5a3ec")
    protected TraitLink(final Dependency elt) {
        this.elt = elt;
    }

    @objid ("2bdfc705-40f6-4401-82c6-14d1225dad30")
    public static TraitLink instantiate(final Dependency elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, TraitLink.STEREOTYPE_NAME))
            throw new Exception("Missing 'TraitLink' stereotype");
        return new TraitLink(elt);
    }

}
