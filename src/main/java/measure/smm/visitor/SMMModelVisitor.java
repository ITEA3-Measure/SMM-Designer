package measure.smm.visitor;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.infrastructure.ModelElement;

@objid ("cda3bc32-8d73-4bd6-be3a-1b9392efc5a5")
public interface SMMModelVisitor {
// core package
    @objid ("91a405cc-8751-4fcb-b173-1fd0e75c8381")
    Object visitSmmModel(ModelElement element, Object data) throws Exception;

    @objid ("0de108ae-79f6-4666-bc87-574673e0b1a4")
    Object visitMeasureLibrary(ModelElement element, Object data) throws Exception;

    @objid ("d0dcaee9-0220-40d9-9ada-76c13740c853")
    Object visitMeasureCategory(ModelElement element, Object data) throws Exception;

    @objid ("2b162830-b8a4-48e9-9f16-037343942a5b")
    Object visitCategoryRelationship(ModelElement element, Object data) throws Exception;

// Measures package
    @objid ("fe52eec5-e01a-483a-9041-5d00cd54de83")
    Object visitCharacteristic(ModelElement element, Object data) throws Exception;

    @objid ("6a29e76a-4104-4ce0-8842-ff16ffb166d1")
    Object visitScope(ModelElement element, Object data) throws Exception;

    @objid ("4d36f612-8e56-4b75-bb55-67a9d1322e25")
    Object visitUnitOfMeasure(ModelElement element, Object data) throws Exception;

    @objid ("241f7eca-7686-494f-9574-0f68abcee1fb")
    Object visitEquivalentMeasureRelationship(ModelElement element, Object data) throws Exception;

    @objid ("73662bd7-ab52-487d-a1dd-c811071309b7")
    Object visitRefinementMeasureRelationship(ModelElement element, Object data) throws Exception;

    @objid ("5faca3bf-d86a-4347-bcd7-4bf8551a226b")
    Object visitGradeMeasure(ModelElement element, Object data) throws Exception;

    @objid ("16c92c91-b51a-4146-a143-ff4f0ec021b8")
    Object visitGradeMeasureRelationship(ModelElement element, Object data) throws Exception;

    @objid ("c8ebd1e6-c5ab-42d1-adc3-dd46e68e26d0")
    Object visitGradeInterval(ModelElement element, Object data) throws Exception;

    @objid ("e55ffc4d-85ed-4f9d-b92c-8cc66f321c9a")
    Object visitRankingMeasure(ModelElement element, Object data) throws Exception;

    @objid ("a64905a5-fb92-434f-beb5-2c1efb0eb368")
    Object visitRankingMeasureRelationship(ModelElement element, Object data) throws Exception;

    @objid ("70210bd8-e948-445f-9a31-f5b344b995e7")
    Object visitRankingInterval(ModelElement element, Object data) throws Exception;

// Collective measures package
    @objid ("6cafbba6-d3f4-4dbc-a048-a18f8751017f")
    Object visitCollectiveMeasure(ModelElement element, Object data) throws Exception;

    @objid ("5d79e4d3-9d3e-464e-b2c3-b454227be134")
    Object visitDirectMeasure(ModelElement element, Object data) throws Exception;

    @objid ("baa125bb-14c8-4656-b85e-3894eb8fb681")
    Object visitCountingMeasure(ModelElement element, Object data) throws Exception;

    @objid ("ec49edfa-d3e3-426c-8d25-7ab52fe81047")
    Object visitBinaryMeasure(ModelElement element, Object data) throws Exception;

    @objid ("6e6c5b5f-b22a-4eda-91e0-1730fa2e753b")
    Object visitRatioMeasure(ModelElement element, Object data) throws Exception;

    @objid ("afe4c4a0-4457-4851-a454-06c674487154")
    Object visitBaseNMeasureRelationship(ModelElement element, Object data) throws Exception;

    @objid ("2fd020ff-0e65-451a-8c14-5290685a39b0")
    Object visitBase1MeasureRelationship(ModelElement element, Object data) throws Exception;

    @objid ("b7bee496-0324-478a-97e6-a91cf6f106bf")
    Object visitBase2MeasureRelationship(ModelElement element, Object data) throws Exception;

// Other measures package
    @objid ("fca2e7d8-bc7b-4340-8d15-c5eab23fa81f")
    Object visitNamedMeasure(ModelElement element, Object data) throws Exception;

    @objid ("25c8b207-5c32-430f-bde3-ba061a56a6f1")
    Object visitRescaledMeasure(ModelElement element, Object data) throws Exception;

    @objid ("ac61e3a5-430b-4c91-8345-a0937d8ce3af")
    Object visitRescaledMeasureRelationship(ModelElement element, Object data) throws Exception;

// Measurements package
    @objid ("788baf7e-022d-4e91-a736-c1907d63ab29")
    Object visitEquivalentMeasurementRelationship(ModelElement element, Object data) throws Exception;

    @objid ("bee114ec-81fc-476f-be34-01366fb83d06")
    Object visitRefinementMeasurementRelationship(ModelElement element, Object data) throws Exception;

    @objid ("5eb2dead-5913-41db-a8db-387437a2200d")
    Object visitGradeMeasurement(ModelElement element, Object data) throws Exception;

    @objid ("d7d7dd69-e1a3-4521-be0e-bbb7cf59049b")
    Object visitGradeMeasurementRelationship(ModelElement element, Object data) throws Exception;

    @objid ("76b46c85-a11e-47fc-bf4b-ccc2ad93a997")
    Object visitRankingMeasurement(ModelElement element, Object data) throws Exception;

    @objid ("da4f8734-7408-4319-aa84-cf406472807a")
    Object visitRankingMeasurementRelationship(ModelElement element, Object data) throws Exception;

// Collective measurements
    @objid ("cdf8f2f2-1952-4f8a-820e-ba6e1d205ef0")
    Object visitCollectiveMeasurement(ModelElement element, Object data) throws Exception;

    @objid ("fe96474b-b0db-479e-b1af-037b34f211df")
    Object visitDirectMeasurement(ModelElement element, Object data) throws Exception;

    @objid ("3de95647-ddf2-412a-bb84-ee0164005137")
    Object visitCountingMeasurement(ModelElement element, Object data) throws Exception;

    @objid ("c18c65bf-6bb3-45ad-b746-c5d042347508")
    Object visitBinaryMeasurement(ModelElement element, Object data) throws Exception;

    @objid ("602ecacf-e6e9-414c-8f50-5f4b10fbef0e")
    Object visitRatioMeasurement(ModelElement element, Object data) throws Exception;

    @objid ("fa017099-8cf5-4a2e-8768-b9253bce528d")
    Object visitBaseNMeasurementRelationship(ModelElement element, Object data) throws Exception;

    @objid ("151b2f0a-6204-4e04-8b18-13d4a1d4776a")
    Object visitBase1MeasurementRelationship(ModelElement element, Object data) throws Exception;

    @objid ("7d5ba9a0-2f25-4ca9-af18-68200e53dec6")
    Object visitBase2MeasurementRelationship(ModelElement element, Object data) throws Exception;

// Named and rescaled measurements
    @objid ("19ea2342-b886-4dad-84d1-8b83c17fd185")
    Object visitNamedMeasurement(ModelElement element, Object data) throws Exception;

    @objid ("c54e337d-b3f1-41ff-9982-23615b5396f2")
    Object visitRescaledMeasurement(ModelElement element, Object data) throws Exception;

    @objid ("7f94cd7b-c5ed-45c7-b2a6-aa2b01ececee")
    Object visitRescaledMeasurementRelationship(ModelElement element, Object data) throws Exception;

// Observations
    @objid ("7af5ce10-8b14-4184-92f8-eec9cb053245")
    Object visitObservation(ModelElement element, Object data) throws Exception;

    @objid ("9ac9ce50-9ce9-4d6a-8900-815e2426b5bb")
    Object visitObservedMeasure(ModelElement element, Object data) throws Exception;

    @objid ("44f59237-441e-4196-b46c-e615f8d032cb")
    Object visitObservationScope(ModelElement element, Object data) throws Exception;

    @objid ("150d0006-59ff-4a65-9edd-ce038fc95beb")
    Object visitOCLOperation(ModelElement element, Object data) throws Exception;


//Object visitTimeStamp(ModelElement element, Object data); // not necessary
}
