/*
 * WARNING: GENERATED FILE - DO NOT EDIT
 * Module: SMM v0.1.14

 * This file was generated on 5/30/16 6:00 PM by Modelio Studio.
 */
package measure.smm.api.core.dependency;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import measure.smm.api.ISMMPeerModule;
import org.modelio.api.model.PropertyConverter;
import org.modelio.api.modelio.Modelio;
import org.modelio.metamodel.factory.ExtensionNotFoundException;
import org.modelio.metamodel.uml.infrastructure.Dependency;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyDefinition;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyTableDefinition;

@objid ("44473f00-c85f-48fe-8852-71ceab5f187e")
public class CategoryMeasure {
    @objid ("437c6daa-1330-492c-a192-73cd159d345b")
    public static final String STEREOTYPE_NAME = "CategoryMeasure";

    @objid ("753d8028-644e-4bab-9b53-10b1b5c399a0")
    protected final Dependency elt;

    @objid ("11ac7598-9937-4226-bcdc-82b6041b0e39")
    public Dependency getElement() {
        return this.elt;
    }

    @objid ("cf7f54a1-01ec-4afc-9d13-16a93a6c16fa")
    public static CategoryMeasure create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Dependency");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, CategoryMeasure.STEREOTYPE_NAME);
        return CategoryMeasure.instantiate((Dependency)e);
    }

    @objid ("1a7b58e5-e43c-4b03-9819-93375504127a")
    protected CategoryMeasure(final Dependency elt) {
        this.elt = elt;
    }

    @objid ("6fbfeaa1-cdcb-4e2e-85d3-90ecdd256038")
    public static CategoryMeasure instantiate(final Dependency elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, CategoryMeasure.STEREOTYPE_NAME))
            throw new Exception("Missing 'CategoryMeasure' stereotype");
        return new CategoryMeasure(elt);
    }

}
