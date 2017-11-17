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

@objid ("20994749-a642-46c8-9e62-910f1c180233")
public class GradeInterval extends Interval {
    @objid ("6ec92e04-caf9-43a0-bc68-6a352adcac9b")
    public static final String STEREOTYPE_NAME = "GradeInterval";

    @objid ("d52d6bb3-95d8-4f4e-a1e8-2ca086941348")
    public Class getElement() {
        return (Class)super.getElement();
    }

    @objid ("afba3539-20e7-40d1-9b66-52d466bc3ac7")
    public static GradeInterval create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Class");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, GradeInterval.STEREOTYPE_NAME);
        return GradeInterval.instantiate((Class)e);
    }

    @objid ("f1b50260-5d75-4acf-b572-1f48ceb25a02")
    protected GradeInterval(final Class elt) {
        super(elt);
    }

    @objid ("744b4302-1aea-441e-89b4-7dd262fe70c6")
    public static GradeInterval instantiate(final Class elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, GradeInterval.STEREOTYPE_NAME))
            throw new Exception("Missing 'GradeInterval' stereotype");
        return new GradeInterval(elt);
    }

}
