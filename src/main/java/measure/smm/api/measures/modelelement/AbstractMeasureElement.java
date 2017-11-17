/*
 * WARNING: GENERATED FILE - DO NOT EDIT
 * Module: SMM v0.1.14

 * This file was generated on 5/30/16 6:00 PM by Modelio Studio.
 */
package measure.smm.api.measures.modelelement;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import measure.smm.api.ISMMPeerModule;
import measure.smm.api.core.modelelement.SmmElement;
import org.modelio.api.model.PropertyConverter;
import org.modelio.api.modelio.Modelio;
import org.modelio.metamodel.factory.ExtensionNotFoundException;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyDefinition;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyTableDefinition;

@objid ("692779dc-f6c5-4d4f-ae2d-0ce82bd28ed7")
public abstract class AbstractMeasureElement extends SmmElement {
    @objid ("43de93fb-4d35-44f2-b7ce-9aa4937bbd16")
    public static final String STEREOTYPE_NAME = "AbstractMeasureElement";

    @objid ("6ab1180f-7a2f-4485-bfdc-ce1807de1a30")
    public ModelElement getElement() {
        return (ModelElement)super.getElement();
    }

    @objid ("e2e95119-47a7-44ba-a21d-de281c21e8f5")
    protected AbstractMeasureElement(final ModelElement elt) {
        super(elt);
    }

}
