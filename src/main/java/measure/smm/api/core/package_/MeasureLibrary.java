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

@objid ("c558c0e0-7d49-4fac-b9a2-cc22ccb52696")
public class MeasureLibrary extends SmmElement {
    @objid ("c6e1047e-77e7-4e86-9b79-f6f5ff2dcb8a")
    public static final String STEREOTYPE_NAME = "MeasureLibrary";

    @objid ("38c900fc-2782-4ddc-afed-d0d80c49d037")
    public Package getElement() {
        return (Package)super.getElement();
    }

    @objid ("ed1b9fa3-f3e7-4fff-88ff-f7cba863ceac")
    public static MeasureLibrary create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Package");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, MeasureLibrary.STEREOTYPE_NAME);
        return MeasureLibrary.instantiate((Package)e);
    }

    @objid ("656fe326-ca6e-4c28-8012-af65f6acaf04")
    protected MeasureLibrary(final Package elt) {
        super(elt);
    }

    @objid ("9ddb5223-f61b-42a1-8a07-f7db977e0532")
    public static MeasureLibrary instantiate(final Package elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, MeasureLibrary.STEREOTYPE_NAME))
            throw new Exception("Missing 'MeasureLibrary' stereotype");
        return new MeasureLibrary(elt);
    }

}
