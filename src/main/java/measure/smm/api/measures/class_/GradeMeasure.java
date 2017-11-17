/*
 * WARNING: GENERATED FILE - DO NOT EDIT
 * Module: SMM v0.1.14

 * This file was generated on 5/30/16 6:00 PM by Modelio Studio.
 */
package measure.smm.api.measures.class_;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import measure.smm.api.ISMMPeerModule;
import org.modelio.api.model.PropertyConverter;
import org.modelio.api.modelio.Modelio;
import org.modelio.metamodel.factory.ExtensionNotFoundException;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyDefinition;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyTableDefinition;
import org.modelio.metamodel.uml.statik.Class;

@objid ("8a0f4fee-e77f-41b2-aa38-11916978f75d")
public class GradeMeasure extends Measure {
    @objid ("5e6b338d-18b0-4fd9-93e4-a12806c1b2ac")
    public static final String STEREOTYPE_NAME = "GradeMeasure";

    @objid ("2cda30a9-2a97-454b-a59d-909541402b49")
    public Class getElement() {
        return (Class)super.getElement();
    }

    @objid ("c2c20d3a-01f9-42eb-9b1f-80963bad7000")
    public static GradeMeasure create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Class");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, GradeMeasure.STEREOTYPE_NAME);
        return GradeMeasure.instantiate((Class)e);
    }

    @objid ("2f905bc2-2d77-4c92-8564-8cbec4149004")
    protected GradeMeasure(final Class elt) {
        super(elt);
    }

    @objid ("db601c26-d408-4c4a-a45e-fb1247279da5")
    public static GradeMeasure instantiate(final Class elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, GradeMeasure.STEREOTYPE_NAME))
            throw new Exception("Missing 'GradeMeasure' stereotype");
        return new GradeMeasure(elt);
    }

}
