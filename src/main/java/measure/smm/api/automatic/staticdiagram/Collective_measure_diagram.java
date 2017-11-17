/*
 * WARNING: GENERATED FILE - DO NOT EDIT
 * Module: SMM v0.1.14

 * This file was generated on 5/30/16 6:00 PM by Modelio Studio.
 */
package measure.smm.api.automatic.staticdiagram;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import measure.smm.api.ISMMPeerModule;
import org.modelio.api.model.PropertyConverter;
import org.modelio.api.modelio.Modelio;
import org.modelio.metamodel.diagrams.StaticDiagram;
import org.modelio.metamodel.factory.ExtensionNotFoundException;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyDefinition;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyTableDefinition;

@objid ("c9ee7eb6-f9b7-44be-9d00-b30c2c27814f")
public class Collective_measure_diagram {
    @objid ("5a3ba5f6-1860-40ca-9b59-16df4506d4d2")
    public static final String STEREOTYPE_NAME = "Collective_measure_diagram";

    @objid ("268e7d91-53dc-49a2-8c3e-4e278c865be4")
    protected final StaticDiagram elt;

    @objid ("6cd37868-55b7-40a4-98e7-5d17052ddf2c")
    public StaticDiagram getElement() {
        return this.elt;
    }

    @objid ("08fbe14c-067f-4488-b399-0d1425bf0d7c")
    public static Collective_measure_diagram create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("StaticDiagram");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, Collective_measure_diagram.STEREOTYPE_NAME);
        return Collective_measure_diagram.instantiate((StaticDiagram)e);
    }

    @objid ("5aea8924-b29c-4176-bc40-00ad5076f4ca")
    protected Collective_measure_diagram(final StaticDiagram elt) {
        this.elt = elt;
    }

    @objid ("2f1fe04a-dfd7-4f12-9af0-203c65ca78ff")
    public static Collective_measure_diagram instantiate(final StaticDiagram elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, Collective_measure_diagram.STEREOTYPE_NAME))
            throw new Exception("Missing 'Collective_measure_diagram' stereotype");
        return new Collective_measure_diagram(elt);
    }

}
