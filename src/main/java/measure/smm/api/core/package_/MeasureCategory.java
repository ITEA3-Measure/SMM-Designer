/*
 * WARNING: GENERATED FILE - DO NOT EDIT
 * Module: SMM v0.1.14

 * This file was generated on 5/30/16 6:00 PM by Modelio Studio.
 */
package measure.smm.api.core.package_;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import measure.smm.api.ISMMPeerModule;
import measure.smm.api.measures.modelelement.AbstractMeasureElement;
import org.modelio.api.model.PropertyConverter;
import org.modelio.api.modelio.Modelio;
import org.modelio.metamodel.factory.ExtensionNotFoundException;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyDefinition;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyTableDefinition;
import org.modelio.metamodel.uml.statik.Package;

@objid ("f9e1b55f-6994-4526-9054-7620b3206263")
public class MeasureCategory extends AbstractMeasureElement {
    @objid ("2c8c06d0-6c47-49f1-9d8d-3debdc93b22c")
    public static final String STEREOTYPE_NAME = "MeasureCategory";

    @objid ("d915f3f7-d4c2-4c91-8eec-f65356b5727b")
    public Package getElement() {
        return (Package)super.getElement();
    }

    @objid ("f67a7626-8322-4224-90a9-2aedb7c86d4d")
    public static MeasureCategory create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Package");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, MeasureCategory.STEREOTYPE_NAME);
        return MeasureCategory.instantiate((Package)e);
    }

    @objid ("4bcb006a-23b1-4d64-bb16-2288d4969bc1")
    protected MeasureCategory(final Package elt) {
        super(elt);
    }

    @objid ("e0fcbcac-301e-42fa-85d4-541ff1f26ffa")
    public static MeasureCategory instantiate(final Package elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, MeasureCategory.STEREOTYPE_NAME))
            throw new Exception("Missing 'MeasureCategory' stereotype");
        return new MeasureCategory(elt);
    }

}
