/*
 * WARNING: GENERATED FILE - DO NOT EDIT
 * Module: SMM v0.1.14

 * This file was generated on 5/30/16 6:00 PM by Modelio Studio.
 */
package measure.smm.api.core.package_;

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

@objid ("a63059a7-62c2-4f9b-886b-8821a0bd697d")
public class SmmModel extends SmmElement {
    @objid ("d8c4df1f-e024-4c8b-99ac-ff6b9d7a5fb3")
    public static final String STEREOTYPE_NAME = "SmmModel";

    @objid ("3b0e4550-50e1-4b68-87ec-7836e97cb55d")
    public Package getElement() {
        return (Package)super.getElement();
    }

    @objid ("6c0e0153-9f58-41bf-be2e-c556186d9c13")
    public static SmmModel create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Package");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, SmmModel.STEREOTYPE_NAME);
        return SmmModel.instantiate((Package)e);
    }

    @objid ("13060fd1-1900-4a33-b661-776413546948")
    protected SmmModel(final Package elt) {
        super(elt);
    }

    @objid ("7542b5f4-6146-41be-8829-0104b7163044")
    public static SmmModel instantiate(final Package elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, SmmModel.STEREOTYPE_NAME))
            throw new Exception("Missing 'SmmModel' stereotype");
        return new SmmModel(elt);
    }

}
