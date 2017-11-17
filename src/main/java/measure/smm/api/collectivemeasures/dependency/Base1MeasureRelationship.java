/*
 * WARNING: GENERATED FILE - DO NOT EDIT
 * Module: SMM v0.1.14

 * This file was generated on 5/30/16 6:00 PM by Modelio Studio.
 */
package measure.smm.api.collectivemeasures.dependency;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import measure.smm.api.ISMMPeerModule;
import org.modelio.api.model.PropertyConverter;
import org.modelio.api.modelio.Modelio;
import org.modelio.metamodel.factory.ExtensionNotFoundException;
import org.modelio.metamodel.uml.infrastructure.Dependency;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyDefinition;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyTableDefinition;

@objid ("43d9cc67-3c75-4018-a963-bfa5febfc990")
public class Base1MeasureRelationship extends BaseMeasureRelationhip {
    @objid ("479b3c33-4b8c-4f4d-8c7f-3d4742bb75dd")
    public static final String STEREOTYPE_NAME = "Base1MeasureRelationship";

    @objid ("747f574f-77e8-4064-b0a2-f061cb403254")
    public Dependency getElement() {
        return (Dependency)super.getElement();
    }

    @objid ("0b9d0046-5ada-4bbb-a92a-aa576204f6a0")
    public static Base1MeasureRelationship create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Dependency");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, Base1MeasureRelationship.STEREOTYPE_NAME);
        return Base1MeasureRelationship.instantiate((Dependency)e);
    }

    @objid ("82b438e8-52a5-4811-a1ad-cd6d5410f70f")
    protected Base1MeasureRelationship(final Dependency elt) {
        super(elt);
    }

    @objid ("9f99daea-62d6-4b49-b7c0-fdb8d85755ec")
    public static Base1MeasureRelationship instantiate(final Dependency elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, Base1MeasureRelationship.STEREOTYPE_NAME))
            throw new Exception("Missing 'Base1MeasureRelationship' stereotype");
        return new Base1MeasureRelationship(elt);
    }

}
