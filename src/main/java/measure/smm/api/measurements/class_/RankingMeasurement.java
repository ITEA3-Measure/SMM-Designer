/*
 * WARNING: GENERATED FILE - DO NOT EDIT
 * Module: SMM v0.1.14

 * This file was generated on 5/30/16 6:00 PM by Modelio Studio.
 */
package measure.smm.api.measurements.class_;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import measure.smm.api.ISMMPeerModule;
import org.modelio.api.model.PropertyConverter;
import org.modelio.api.modelio.Modelio;
import org.modelio.metamodel.factory.ExtensionNotFoundException;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyDefinition;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyTableDefinition;
import org.modelio.metamodel.uml.statik.Class;

@objid ("038a455e-8cc9-4116-a114-3a839771d13d")
public class RankingMeasurement extends DimensionalMeasurement {
    @objid ("97955443-d8f5-4a71-bd2d-349ba3b0b03a")
    public static final String STEREOTYPE_NAME = "RankingMeasurement";

    @objid ("36e7f39c-4dc5-42e2-8aff-d93a4a335b06")
    public static final String RANKINGMEASUREMENT_BASEQUERY_BODY_TAGTYPE = "RankingMeasurement_baseQuery_body";

    @objid ("8f54da77-e236-47b5-9906-7cf6a2b350ed")
    public static final String RANKINGMEASUREMENT_BASEQUERY_LANGUAGE_TAGTYPE = "RankingMeasurement_baseQuery_language";

    @objid ("b0b08b3f-e3d2-4bd4-b508-9e5428177b11")
    public static final String RANKINGMEASUREMENT_ISBASESUPPLIED_TAGTYPE = "RankingMeasurement_isBaseSupplied";

    @objid ("ed63bd0a-42a9-487e-81c4-cbc4f4299731")
    public Class getElement() {
        return (Class)super.getElement();
    }

    @objid ("f64f78cf-bf4e-4dbe-8b2a-2de52a3d76be")
    public static RankingMeasurement create() throws Exception {
        ModelElement e = (ModelElement)Modelio.getInstance().getModelingSession().getModel().createElement("Class");
        e.addStereotype(ISMMPeerModule.MODULE_NAME, RankingMeasurement.STEREOTYPE_NAME);
        return RankingMeasurement.instantiate((Class)e);
    }

    @objid ("7f19013c-dc19-40e9-ad99-75c08b7711ba")
    protected RankingMeasurement(final Class elt) {
        super(elt);
    }

    @objid ("90b6f0bb-7a20-4bd4-9e69-8569ebdcdf7b")
    public static RankingMeasurement instantiate(final Class elt) throws Exception {
        if (!elt.isStereotyped(ISMMPeerModule.MODULE_NAME, RankingMeasurement.STEREOTYPE_NAME))
            throw new Exception("Missing 'RankingMeasurement' stereotype");
        return new RankingMeasurement(elt);
    }

    /**
     * Getter for property 'RankingMeasurement.RankingMeasurement_isBaseSupplied'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("159f0687-c7a9-4e61-9d5d-5d973c1966ed")
    public String getRankingMeasurement_isBaseSupplied() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, RANKINGMEASUREMENT_ISBASESUPPLIED_TAGTYPE);
    }

    /**
     * Setter for property 'RankingMeasurement.RankingMeasurement_isBaseSupplied'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("0dbf6a4d-0a16-44b5-8cd8-3a4bbffe2b88")
    public void setRankingMeasurement_isBaseSupplied(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, RANKINGMEASUREMENT_ISBASESUPPLIED_TAGTYPE, value);
    }

    /**
     * Getter for property 'RankingMeasurement.RankingMeasurement_baseQuery_body'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("33168141-0e90-4e66-b565-6cd2d9d3ffca")
    public String getRankingMeasurement_baseQuery_body() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, RANKINGMEASUREMENT_BASEQUERY_BODY_TAGTYPE);
    }

    /**
     * Setter for property 'RankingMeasurement.RankingMeasurement_baseQuery_body'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("b685f1b5-4746-4995-b24f-eb71d52df8ca")
    public void setRankingMeasurement_baseQuery_body(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, RANKINGMEASUREMENT_BASEQUERY_BODY_TAGTYPE, value);
    }

    /**
     * Getter for property 'RankingMeasurement.RankingMeasurement_baseQuery_language'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("4877ce9c-9558-4b5c-9e21-2d17f80a93ff")
    public String getRankingMeasurement_baseQuery_language() {
        return this.elt.getTagValue(ISMMPeerModule.MODULE_NAME, RANKINGMEASUREMENT_BASEQUERY_LANGUAGE_TAGTYPE);
    }

    /**
     * Setter for property 'RankingMeasurement.RankingMeasurement_baseQuery_language'
     * <p>Property description:
     * <br/><i></i></p>
     */
    @objid ("1430c12b-d216-4cdf-995d-90c477a4b726")
    public void setRankingMeasurement_baseQuery_language(final String value) throws ExtensionNotFoundException {
        this.elt.putTagValue(ISMMPeerModule.MODULE_NAME, RANKINGMEASUREMENT_BASEQUERY_LANGUAGE_TAGTYPE, value);
    }

}
