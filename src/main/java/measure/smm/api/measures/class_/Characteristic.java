/*
 * WARNING: GENERATED FILE - DO NOT EDIT
 * Module: SMM v0.1.14

 * This file was generated on 5/30/16 6:00 PM by Modelio Studio.
 */
package measure.smm.api.measures.class_;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import measure.smm.api.ISMMPeerModule;
import measure.smm.api.measures.modelelement.AbstractMeasureElement;
import org.modelio.api.model.PropertyConverter;
import org.modelio.api.modelio.Modelio;
import org.modelio.metamodel.factory.ExtensionNotFoundException;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyDefinition;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyTableDefinition;
import org.modelio.metamodel.uml.statik.Class;

@objid ("524e9f2d-51db-495b-9d6b-02a0f9ae7eec")
public class Characteristic extends AbstractMeasureElement {
    @objid ("47c0a732-9fc0-47af-ab74-cf1d24969f86")
    public static final String STEREOTYPE_NAME = "Characteristic";

    @objid ("7c4f2d8d-d2a8-4ee5-b47e-1e972f02fdc7")
    public Class getElement() {
        return (Class)super.getElement();
    }

    @objid ("c0049e8e-4667-43dd-8d40-7a17b5ca9499")
    public static Characteristic create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Class");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, Characteristic.STEREOTYPE_NAME);
        return Characteristic.instantiate((Class)e);
    }

    @objid ("6d3485ac-a97e-43cf-b4fb-90afc128af13")
    protected Characteristic(final Class elt) {
        super(elt);
    }

    @objid ("28589b6b-5312-4790-b2a1-ee17265ab972")
    public static Characteristic instantiate(final Class elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, Characteristic.STEREOTYPE_NAME))
            throw new Exception("Missing 'Characteristic' stereotype");
        return new Characteristic(elt);
    }

}
