/*
 * WARNING: GENERATED FILE - DO NOT EDIT
 * Module: SMM v0.1.14

 * This file was generated on 5/30/16 6:00 PM by Modelio Studio.
 */
package measure.smm.api.othermeasures.dependency;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import measure.smm.api.ISMMPeerModule;
import measure.smm.api.measures.dependency.MeasureRelationship;
import org.modelio.api.model.PropertyConverter;
import org.modelio.api.modelio.Modelio;
import org.modelio.metamodel.factory.ExtensionNotFoundException;
import org.modelio.metamodel.uml.infrastructure.Dependency;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyDefinition;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyTableDefinition;

@objid ("1f853db5-4d5f-4470-84a1-cfeed6fd0ac9")
public class RescaledMeasureRelationship extends MeasureRelationship {
    @objid ("4c84b7a9-19ae-4846-a2f7-17688485bc2c")
    public static final String STEREOTYPE_NAME = "RescaledMeasureRelationship";

    @objid ("8df1687c-8d23-4722-8ad9-bdb2a3e6b073")
    public Dependency getElement() {
        return (Dependency)super.getElement();
    }

    @objid ("0c57f2e4-3774-40af-a329-a6717605205b")
    public static RescaledMeasureRelationship create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Dependency");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, RescaledMeasureRelationship.STEREOTYPE_NAME);
        return RescaledMeasureRelationship.instantiate((Dependency)e);
    }

    @objid ("17d610a0-bd4b-457d-9d1d-996843100939")
    protected RescaledMeasureRelationship(final Dependency elt) {
        super(elt);
    }

    @objid ("5d872067-cd48-4df7-9bc2-145218461ed2")
    public static RescaledMeasureRelationship instantiate(final Dependency elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, RescaledMeasureRelationship.STEREOTYPE_NAME))
            throw new Exception("Missing 'RescaledMeasureRelationship' stereotype");
        return new RescaledMeasureRelationship(elt);
    }

}
