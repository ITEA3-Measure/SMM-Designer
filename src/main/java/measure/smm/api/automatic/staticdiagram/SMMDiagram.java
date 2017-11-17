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

@objid ("50ac11ec-09e7-4207-9c0e-07dc71403adf")
public class SMMDiagram {
    @objid ("2f9b8e00-d875-4491-a24b-978d52565ce2")
    public static final String STEREOTYPE_NAME = "SMMDiagram";

    @objid ("dce57ef5-65ce-4590-9b85-8549b8863c9f")
    protected final StaticDiagram elt;

    @objid ("a6cbfd2e-384e-4edf-9b4c-faf8ee3acf52")
    public StaticDiagram getElement() {
        return this.elt;
    }

    @objid ("2aeeef63-6736-4e91-ae16-57c51b8224a8")
    public static SMMDiagram create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("StaticDiagram");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, SMMDiagram.STEREOTYPE_NAME);
        return SMMDiagram.instantiate((StaticDiagram)e);
    }

    @objid ("fdee065c-11a1-4cfd-9b9b-f4fcdfd6bf4e")
    protected SMMDiagram(final StaticDiagram elt) {
        this.elt = elt;
    }

    @objid ("341c5c36-ab0e-4e1b-b7f2-c2ade46ce11f")
    public static SMMDiagram instantiate(final StaticDiagram elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, SMMDiagram.STEREOTYPE_NAME))
            throw new Exception("Missing 'SMMDiagram' stereotype");
        return new SMMDiagram(elt);
    }

}
