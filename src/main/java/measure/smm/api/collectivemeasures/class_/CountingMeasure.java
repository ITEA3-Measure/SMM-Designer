/*
 * WARNING: GENERATED FILE - DO NOT EDIT
 * Module: SMM v0.1.14

 * This file was generated on 5/30/16 6:00 PM by Modelio Studio.
 */
package measure.smm.api.collectivemeasures.class_;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import measure.smm.api.ISMMPeerModule;
import org.modelio.api.model.PropertyConverter;
import org.modelio.api.modelio.Modelio;
import org.modelio.metamodel.factory.ExtensionNotFoundException;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyDefinition;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyTableDefinition;
import org.modelio.metamodel.uml.statik.Class;

@objid ("ea6efd94-837c-4430-9864-ed0ec0433df5")
public class CountingMeasure extends DirectMeasure {
    @objid ("2432c799-7e8a-48c9-bb24-a8f5398aee6a")
    public static final String STEREOTYPE_NAME = "CountingMeasure";

    @objid ("3aec898a-5a15-4dff-a1ab-005db1b9ef1e")
    public Class getElement() {
        return (Class)super.getElement();
    }

    @objid ("1fbe5ec4-4209-4897-8514-723efb6e89ee")
    public static CountingMeasure create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Class");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, CountingMeasure.STEREOTYPE_NAME);
        return CountingMeasure.instantiate((Class)e);
    }

    @objid ("972a2320-e1ee-4517-97be-d6457dd3d6ff")
    protected CountingMeasure(final Class elt) {
        super(elt);
    }

    @objid ("c3663a75-2204-4b9a-a24b-b1ef6899769e")
    public static CountingMeasure instantiate(final Class elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, CountingMeasure.STEREOTYPE_NAME))
            throw new Exception("Missing 'CountingMeasure' stereotype");
        return new CountingMeasure(elt);
    }

}
