package measure.smm.visitor.export;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.infrastructure.ModelElement;

/**
 * This interface provides a visitor to traverse a UML model representing a SMM model
 * Each method has one parameter besides the visited element called <pre>data</pre>.
 * It is used by traversal algorithms to pass data to the visitor, it has no specific semantics.
 * Similarly, each method returns an <pre>Object</pre>. It is used by visitors to pass information back to traversal algorithms.
 * 
 * @author malmeida
 */
@objid ("8c38ee42-0f5a-495a-87a2-ceac38d400ec")
public interface SMMModelVisitor {
// core package
    @objid ("c73af833-b14d-4f52-9f61-0194b3c337ce")
    Object visitSmmModel(ModelElement element, Object data) throws Exception;

    @objid ("82452b53-b045-403b-9f90-31e2bd5a61c5")
    Object visitMeasureLibrary(ModelElement element, Object data) throws Exception;

    @objid ("2e617d65-50d4-4a81-8e40-c3273e542566")
    Object visitMeasureCategory(ModelElement element, Object data) throws Exception;

    @objid ("cc28b82a-fc54-4a6b-9224-b02adfbe4d42")
    Object visitCategoryRelationship(ModelElement element, Object data) throws Exception;

// Measures package
    @objid ("394bb667-162e-4eb3-aa50-f50aaf924926")
    Object visitCharacteristic(ModelElement element, Object data) throws Exception;

    @objid ("5b5e8ab9-eb08-4e6d-8153-dc35ecf7cd8f")
    Object visitScope(ModelElement element, Object data) throws Exception;

    @objid ("028399f5-7c4a-4682-884c-d39cd1135f0d")
    Object visitUnitOfMeasure(ModelElement element, Object data) throws Exception;

    @objid ("595a9df9-767b-456f-8b83-9db5c8d95cc8")
    Object visitEquivalentMeasureRelationship(ModelElement element, Object data) throws Exception;

    @objid ("9a19c214-a9df-4140-9c3b-cede019351ca")
    Object visitRefinementMeasureRelationship(ModelElement element, Object data) throws Exception;

    @objid ("1e9cacea-5d7d-438c-8c25-c2f6981b90ed")
    Object visitGradeMeasure(ModelElement element, Object data) throws Exception;

    @objid ("15dc395b-8a6e-4b41-b7a4-011904b0119e")
    Object visitGradeMeasureRelationship(ModelElement element, Object data) throws Exception;

    @objid ("3c7f480f-3a15-4663-b2e6-7744e9f68bb8")
    Object visitGradeInterval(ModelElement element, Object data) throws Exception;

    @objid ("ef065148-dbe9-4b4c-8efb-9925ff810e6b")
    Object visitRankingMeasure(ModelElement element, Object data) throws Exception;

    @objid ("729760cf-6252-4fe8-8e12-41c4668feb01")
    Object visitRankingMeasureRelationship(ModelElement element, Object data) throws Exception;

    @objid ("3277d9a9-02a4-4ddc-9f24-48422f179e8c")
    Object visitRankingInterval(ModelElement element, Object data) throws Exception;

// Collective measures package
    @objid ("759c9669-8c35-4ed8-983f-6c5d1e160f40")
    Object visitCollectiveMeasure(ModelElement element, Object data) throws Exception;

    @objid ("a957a092-1adf-484b-a7b4-92188aff3d4f")
    Object visitDirectMeasure(ModelElement element, Object data) throws Exception;

    @objid ("c2892f04-0d96-4602-ab20-079cc1bd3aea")
    Object visitCountingMeasure(ModelElement element, Object data) throws Exception;

    @objid ("b333db0d-1b07-4093-9a77-2cd78d81673c")
    Object visitBinaryMeasure(ModelElement element, Object data) throws Exception;

    @objid ("473cf889-7ca9-4ac2-a97c-bf518ad99851")
    Object visitRatioMeasure(ModelElement element, Object data) throws Exception;

    @objid ("1ca74230-c127-41a0-b9e6-749a95d4109c")
    Object visitBaseNMeasureRelationship(ModelElement element, Object data) throws Exception;

    @objid ("dcbb119e-7d2c-4811-88f2-b33395616664")
    Object visitBase1MeasureRelationship(ModelElement element, Object data) throws Exception;

    @objid ("e1e09d3b-c282-4daf-96c7-08a5948e49a2")
    Object visitBase2MeasureRelationship(ModelElement element, Object data) throws Exception;

// Other measures package
    @objid ("ec0eacd5-8464-45dc-ac36-004553af21c3")
    Object visitNamedMeasure(ModelElement element, Object data) throws Exception;

    @objid ("5a0d3ddf-4509-401b-aa99-591cc5b6da7c")
    Object visitRescaledMeasure(ModelElement element, Object data) throws Exception;

    @objid ("a4d853f8-0043-44a2-a73e-13f0c273f17f")
    Object visitRescaledMeasureRelationship(ModelElement element, Object data) throws Exception;

// Measurements package
    @objid ("118e4a13-a226-4e6d-9143-e86890284b3f")
    Object visitEquivalentMeasurementRelationship(ModelElement element, Object data) throws Exception;

    @objid ("c8c15301-e167-4baa-8aa9-c8437935096c")
    Object visitRefinementMeasurementRelationship(ModelElement element, Object data) throws Exception;

    @objid ("73be9f72-cbe2-4a81-834a-88d2996cc1d8")
    Object visitGradeMeasurement(ModelElement element, Object data) throws Exception;

    @objid ("c5721c0b-30e0-46aa-abe1-64687587d3c0")
    Object visitGradeMeasurementRelationship(ModelElement element, Object data) throws Exception;

    @objid ("b392d44b-ee62-4f7e-bb26-9b6ce99694a6")
    Object visitRankingMeasurement(ModelElement element, Object data) throws Exception;

    @objid ("47b84ef9-3bcd-4265-9acc-89d6ee86dcc4")
    Object visitRankingMeasurementRelationship(ModelElement element, Object data) throws Exception;

// Collective measurements
    @objid ("2d1d1c36-ab54-46d5-a6e7-0786222e9f82")
    Object visitCollectiveMeasurement(ModelElement element, Object data) throws Exception;

    @objid ("4352dc5e-ccb0-495e-918a-5246962547dd")
    Object visitDirectMeasurement(ModelElement element, Object data) throws Exception;

    @objid ("d7559259-2365-40d3-a655-aec2dab664ef")
    Object visitCountingMeasurement(ModelElement element, Object data) throws Exception;

    @objid ("19bb5283-657a-47a4-bb97-f52efcef22d9")
    Object visitBinaryMeasurement(ModelElement element, Object data) throws Exception;

    @objid ("34f7439d-6d07-49fb-8ff8-b23535695916")
    Object visitRatioMeasurement(ModelElement element, Object data) throws Exception;

    @objid ("d266fff6-c703-407a-935e-6f3e9e38237f")
    Object visitBaseNMeasurementRelationship(ModelElement element, Object data) throws Exception;

    @objid ("e463d43a-9531-413f-82fd-6dc1681942d6")
    Object visitBase1MeasurementRelationship(ModelElement element, Object data) throws Exception;

    @objid ("c8c890b8-3768-494d-afc1-a414a375e27f")
    Object visitBase2MeasurementRelationship(ModelElement element, Object data) throws Exception;

// Named and rescaled measurements
    @objid ("a24d983b-6ce2-4d7c-a669-6c612b64a402")
    Object visitNamedMeasurement(ModelElement element, Object data) throws Exception;

    @objid ("63c5792f-3328-42de-b1a5-baea811b2dcb")
    Object visitRescaledMeasurement(ModelElement element, Object data) throws Exception;

    @objid ("84ae4702-b307-4333-b324-fdca95acdc10")
    Object visitRescaledMeasurementRelationship(ModelElement element, Object data) throws Exception;

// Observations
    @objid ("c0db8217-0c0e-4f8c-831e-f0148772f914")
    Object visitObservation(ModelElement element, Object data) throws Exception;

    @objid ("b0d89034-489f-468f-83eb-7703ee6c42b6")
    Object visitObservedMeasure(ModelElement element, Object data) throws Exception;

    @objid ("8a716ac0-b81e-41c9-8f18-1f1d0625ccc0")
    Object visitObservationScope(ModelElement element, Object data) throws Exception;

    @objid ("35ea8209-a2a3-4232-ace2-40e2524c5d40")
    Object visitOCLOperation(ModelElement element, Object data) throws Exception;


//Object visitTimeStamp(ModelElement element, Object data); // not necessary
}
