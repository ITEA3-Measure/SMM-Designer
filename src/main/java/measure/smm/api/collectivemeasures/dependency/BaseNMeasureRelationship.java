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

@objid ("744cd5df-3b7b-4ab2-9ca5-d8c05f98cee1")
public class BaseNMeasureRelationship extends BaseMeasureRelationhip {
    @objid ("3c09c2db-767c-4d27-8590-23779f5894be")
    public static final String STEREOTYPE_NAME = "BaseNMeasureRelationship";

    @objid ("d17438f0-ba35-4353-a2e6-8c82f4a34b90")
    public Dependency getElement() {
        return (Dependency)super.getElement();
    }

    @objid ("a8981db3-43f3-413f-af8a-265eee0e520f")
    public static BaseNMeasureRelationship create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Dependency");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, BaseNMeasureRelationship.STEREOTYPE_NAME);
        return BaseNMeasureRelationship.instantiate((Dependency)e);
    }

    @objid ("aa80bb44-ee4c-4e2f-914c-b8ae1d7717e5")
    protected BaseNMeasureRelationship(final Dependency elt) {
        super(elt);
    }

    @objid ("983d2dd6-0209-4b79-85ce-1a00f15f06d8")
    public static BaseNMeasureRelationship instantiate(final Dependency elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, BaseNMeasureRelationship.STEREOTYPE_NAME))
            throw new Exception("Missing 'BaseNMeasureRelationship' stereotype");
        return new BaseNMeasureRelationship(elt);
    }

}
