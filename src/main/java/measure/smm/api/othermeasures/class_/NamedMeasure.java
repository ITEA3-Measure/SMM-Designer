/*
 * WARNING: GENERATED FILE - DO NOT EDIT
 * Module: SMM v0.1.14

 * This file was generated on 5/30/16 6:00 PM by Modelio Studio.
 */
package measure.smm.api.othermeasures.class_;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import measure.smm.api.ISMMPeerModule;
import measure.smm.api.measures.class_.DimensionalMeasure;
import org.modelio.api.model.PropertyConverter;
import org.modelio.api.modelio.Modelio;
import org.modelio.metamodel.factory.ExtensionNotFoundException;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyDefinition;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyTableDefinition;
import org.modelio.metamodel.uml.statik.Class;

@objid ("b0e12841-9235-47c4-ab28-3dc1f79869a5")
public class NamedMeasure extends DimensionalMeasure {
    @objid ("b9443277-5058-477f-8224-e028f3166ed7")
    public static final String STEREOTYPE_NAME = "NamedMeasure";

    @objid ("679c7953-47c3-4f33-87ee-597fd78f1126")
    public Class getElement() {
        return (Class)super.getElement();
    }

    @objid ("6adad981-c939-4f92-a7d6-64175437180d")
    public static NamedMeasure create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Class");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, NamedMeasure.STEREOTYPE_NAME);
        return NamedMeasure.instantiate((Class)e);
    }

    @objid ("5ae9de22-c02d-404e-bd22-00198e6f09d8")
    protected NamedMeasure(final Class elt) {
        super(elt);
    }

    @objid ("564ad36d-ed56-423b-941c-b29f763605c7")
    public static NamedMeasure instantiate(final Class elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, NamedMeasure.STEREOTYPE_NAME))
            throw new Exception("Missing 'NamedMeasure' stereotype");
        return new NamedMeasure(elt);
    }

}
