package measure.smm.visitor.export;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import eu.measure.smm.BaseMeasureRelationship;
import eu.measure.smm.CategoryRelationship;
import eu.measure.smm.Characteristic;
import eu.measure.smm.CollectiveMeasure;
import eu.measure.smm.DimensionalMeasure;
import eu.measure.smm.EquivalentMeasureRelationship;
import eu.measure.smm.Measure;
import eu.measure.smm.MeasureRelationship;
import eu.measure.smm.Observation;
import eu.measure.smm.ObservedMeasure;
import eu.measure.smm.Operation;
import eu.measure.smm.RescaledMeasure;
import eu.measure.smm.RescaledMeasurement;
import eu.measure.smm.Scope;
import eu.measure.smm.SmmElement;
import eu.measure.smm.SmmRelationship;
import eu.measure.smm.UnitOfMeasure;
import measure.smm.api.ISMMPeerModule;
import measure.smm.api.measures.class_.ScopeElement;
import measure.smm.api.measures.dependency.ScopeLink;
import measure.smm.api.measures.dependency.TraitLink;
import measure.smm.api.measures.dependency.UnitLink;
import measure.smm.api.observations.dependency.ObservedMeasureLink;
import measure.smm.api.observations.dependency.RequestedMeasureLink;
import measure.smm.api.othermeasures.dependency.RescaledMeasureRelationship;
import measure.smm.api.othermeasures.dependency.Rescales;
import org.eclipse.emf.ecore.EObject;
import org.modelio.metamodel.uml.infrastructure.Dependency;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.ModelTree;
import org.modelio.metamodel.uml.statik.Class;
import org.modelio.metamodel.uml.statik.Generalization;

/**
 * Takes as input an initialized <pre>ExportStructureVisitor</pre> and adds the associations on the UML model to the EMF SMM model.
 * All methods in this class return <pre>null</pre> and the <pre>data</pre> parameter is never used.
 * 
 * @author malmeida
 */
@objid ("7ca68465-2950-447f-89a4-0233aa9e0b1b")
public class ExportAssociationsVisitor implements SMMModelVisitor {
    @objid ("bcb71db3-aaa1-4cb3-9352-48c46b4c59eb")
    private ExportStructureVisitor structureVisitor;

    @objid ("c2920d25-8b4f-4a2e-9218-32aa00d55c45")
    private EObject getEmfElementFor(ModelElement modelioElement) {
        return structureVisitor.getEObject(modelioElement.getUuid().toString());
    }

    @objid ("8a4ee49a-b36b-49b7-8bd8-d37f5d1cbe4e")
    private Operation getOperationFor(ModelElement modelioElement, String bodyTag) {
        return (Operation) structureVisitor.getEObject(modelioElement.getUuid().toString()+"_"+bodyTag);
    }

    /**
     * @param structureVisitor an initialized ExportStructureVisitor (i.e. where <pre>visitX</pre> methods have been called for all elements).
     */
    @objid ("d70e10f0-ada5-4894-977a-c984836bd341")
    public ExportAssociationsVisitor(ExportStructureVisitor structureVisitor) {
        this.structureVisitor = structureVisitor;
    }

// core package
    @objid ("155ae72d-78e0-45b0-806a-09677f2d8f14")
    @Override
    public Object visitSmmModel(ModelElement element, Object data) throws Exception {
        return null;
    }

    @objid ("fc4add5b-f7d1-4a02-a168-d4eb5153cc8e")
    @Override
    public Object visitMeasureLibrary(ModelElement element, Object data) throws Exception {
        return null;
    }

    @objid ("2c39117b-a490-4f3b-9bc3-62cddea635ae")
    @Override
    public Object visitMeasureCategory(ModelElement element, Object data) throws Exception {
        ModelTree modelioElement = (ModelTree) element;
        eu.measure.smm.MeasureCategory emfElement = (eu.measure.smm.MeasureCategory) getEmfElementFor(modelioElement);
        for(ModelTree child : modelioElement.getOwnedElement()) {
            if (child.isStereotyped(ISMMPeerModule.MODULE_NAME, measure.smm.api.core.package_.MeasureCategory.STEREOTYPE_NAME)) {
                eu.measure.smm.MeasureCategory emfOtherElement = (eu.measure.smm.MeasureCategory) getEmfElementFor(child);
                emfElement.getCategoryElement().add(emfOtherElement);
            } else {
                Measure emfOtherElement = (Measure) getEmfElementFor(child);
                emfElement.getCategoryMeasure().add(emfOtherElement);
            }
        }
        return null;
    }

    @objid ("a19f8729-55a9-4510-83b1-b6ea5b813e6b")
    @Override
    public Object visitCategoryRelationship(ModelElement element, Object data) throws Exception {
        Dependency modelioElement = (Dependency) element;
        CategoryRelationship emfRelationship = (CategoryRelationship) getEmfElementFor(modelioElement);
        eu.measure.smm.MeasureCategory fromElement = (eu.measure.smm.MeasureCategory) getEmfElementFor(modelioElement.getImpacted());
        SmmElement toElement = (SmmElement) getEmfElementFor(modelioElement.getDependsOn());
        
        emfRelationship.setFrom(fromElement);
        emfRelationship.setTo(toElement);
        return null;
    }

// Measures package
    @objid ("8727a856-b6b4-4705-8006-48805c9e7df3")
    @Override
    public Object visitCharacteristic(ModelElement element, Object data) throws Exception {
        org.modelio.metamodel.uml.statik.Class modelioElement = (org.modelio.metamodel.uml.statik.Class) element;
        Characteristic emfElement = (Characteristic) getEmfElementFor(modelioElement);
        for(Generalization generalization : modelioElement.getParent()) {
            org.modelio.metamodel.uml.statik.Class parent = (Class) generalization.getSuperType();
            emfElement.setParent((Characteristic) getEmfElementFor(parent));
            // Validation: if there's more than one, the model is not valid!
        }
        return null;
    }

    @objid ("34d010dd-7a02-45fa-a0bc-903bc416893b")
    @Override
    public Object visitScope(ModelElement element, Object data) throws Exception {
        Scope emfElement = (Scope) getEmfElementFor(element);
        Operation op1 = getOperationFor(element, ScopeElement.BREAK_CONDITION_BODY_TAGTYPE);
        Operation op2 = getOperationFor(element, ScopeLink.BREAK_CONDITION_BODY_TAGTYPE);
        emfElement.setBreakCondition(op1==null?op2:op1);
        
        op1 = getOperationFor(element, ScopeElement.RECOGNIZER_BODY_TAGTYPE);
        op2 = getOperationFor(element, ScopeLink.RECOGNIZER_BODY_TAGTYPE);
        emfElement.setRecognizer(op1==null?op2:op1);
        return null;
    }

    @objid ("965c8d4a-9495-4381-a29a-4b11a5ee79cb")
    @Override
    public Object visitUnitOfMeasure(ModelElement element, Object data) throws Exception {
        return null;
    }

    @objid ("59b3b809-e29f-47cd-a8ff-664d25481f45")
    @Override
    public Object visitEquivalentMeasureRelationship(ModelElement element, Object data) throws Exception {
        Dependency modelioElement = (Dependency) element;
        EquivalentMeasureRelationship emfRelationship = (EquivalentMeasureRelationship) getEmfElementFor(modelioElement);
        
        emfRelationship.setMapping(getOperationFor(element, measure.smm.api.measures.dependency.EquivalentMeasureRelationship.MAPPING_BODY_TAGTYPE));
        visitMeasureRelationship(modelioElement);
        return null;
    }

    @objid ("b25b8d2f-714a-4a00-971f-884b346e4bbf")
    private Object visitMeasureRelationship(ModelElement modelioElement) {
        MeasureRelationship emfElement = (MeasureRelationship) getEmfElementFor(modelioElement);
        emfElement.setMeasurandQuery(getOperationFor(modelioElement, measure.smm.api.measures.dependency.MeasureRelationship.MEASURANTQUERY_BODY_TAGTYPE));
        return visitSmmRelationship(modelioElement);
    }

    @objid ("9b5764ed-8ddd-4afb-8500-2dd2b3b21a45")
    private Object visitSmmRelationship(ModelElement element) {
        Dependency modelioElement = (Dependency) element;
        SmmRelationship emfElement = (SmmRelationship) getEmfElementFor(element);
        
        emfElement.setFrom((SmmElement) getEmfElementFor(modelioElement.getImpacted())); 
        emfElement.setTo((SmmElement) getEmfElementFor(modelioElement.getDependsOn()));
        return visitSmmElement(modelioElement, null);
    }

    @objid ("c728900c-b99f-4a3d-b665-f19f0ab3c187")
    @Override
    public Object visitRefinementMeasureRelationship(ModelElement element, Object data) throws Exception {
        return visitMeasureRelationship(element);
    }

    @objid ("a4634d59-5525-45a3-b59d-f48f7695a639")
    @Override
    public Object visitGradeMeasure(ModelElement element, Object data) throws Exception {
        return visitMeasure(element);
    }

    @objid ("a2fc9554-265c-4896-97d8-de0fbaee7ed8")
    private Object visitMeasure(ModelElement element) {
        Measure emfElement = (Measure) getEmfElementFor(element);
        
        emfElement.setDefaultQuery(getOperationFor(element, measure.smm.api.measures.class_.Measure.DEFAULTQUERY_BODY_TAGTYPE));            
        
        for (Dependency d : element.getDependsOnDependency()) {
            if (d.isStereotyped(ISMMPeerModule.MODULE_NAME, ScopeLink.STEREOTYPE_NAME)) {
                Scope target;
                if (d.getDependsOn().isStereotyped(ISMMPeerModule.MODULE_NAME,  ScopeElement.STEREOTYPE_NAME)) {
                    target = (Scope) getEmfElementFor(d.getDependsOn());
                } else {
                    target = (Scope) getEmfElementFor(d);
                }
                
               emfElement.setScope(target);
               
               // Validation: there should be only one
            } else 
            if (d.isStereotyped(ISMMPeerModule.MODULE_NAME, TraitLink.STEREOTYPE_NAME)) {
                Characteristic target = (Characteristic) getEmfElementFor(d.getDependsOn());
               emfElement.setTrait(target);
               
               // Validation: there should be only one
            } 
        }
        return visitSmmElement(element, null);
    }

    @objid ("e5aa33d4-d527-4f0f-adb0-eecc17ee7989")
    @Override
    public Object visitGradeMeasureRelationship(ModelElement element, Object data) throws Exception {
        return visitMeasureRelationship(element);
    }

    @objid ("77d78099-8bd9-4bc6-a10e-cd6caad9591d")
    @Override
    public Object visitGradeInterval(ModelElement element, Object data) throws Exception {
        return null;
    }

    @objid ("57c1adfc-406b-4316-b1e2-63c2fd3f9f01")
    @Override
    public Object visitRankingMeasure(ModelElement element, Object data) throws Exception {
        return visitDimensionalMeasure(element);
    }

    @objid ("2be8b1fa-4e53-47ec-9279-2a55acd73f92")
    @Override
    public Object visitRankingMeasureRelationship(ModelElement element, Object data) throws Exception {
        return visitMeasureRelationship(element);
    }

    @objid ("088d8522-59f6-487a-bd61-2000e5da8342")
    @Override
    public Object visitRankingInterval(ModelElement element, Object data) throws Exception {
        return null;
    }

// Collective measures package
    @objid ("9c5a6b32-c31f-4b62-8606-552733461b09")
    @Override
    public Object visitCollectiveMeasure(ModelElement element, Object data) throws Exception {
        CollectiveMeasure emfElement = (CollectiveMeasure) getEmfElementFor(element);
        emfElement.setCustomAccumulator(getOperationFor(element, measure.smm.api.collectivemeasures.class_.CollectiveMeasure.CUSTOMACCUMULATOR_BODY_TAGTYPE));
        return visitDimensionalMeasure(element);
    }

    @objid ("8b3e6375-3806-4ba0-9df9-b60f82821a1c")
    private Object visitDimensionalMeasure(ModelElement element) {
        DimensionalMeasure emfElement = (DimensionalMeasure) getEmfElementFor(element);
        for (Dependency d : element.getDependsOnDependency()) {
            if (d.isStereotyped(ISMMPeerModule.MODULE_NAME, UnitLink.STEREOTYPE_NAME)) {
               UnitOfMeasure target = (UnitOfMeasure) getEmfElementFor(d.getDependsOn());
               emfElement.setUnit(target);
               
               // Validation: there should be only one
               break;
            } 
        }
        return visitMeasure(element);
    }

    @objid ("ae0bb01d-64ee-494f-86ea-2887aab218bc")
    @Override
    public Object visitDirectMeasure(ModelElement element, Object data) throws Exception {
        eu.measure.smm.DirectMeasure emfElement = (eu.measure.smm.DirectMeasure) getEmfElementFor(element);
        emfElement.setOperation(getOperationFor(element, measure.smm.api.collectivemeasures.class_.DirectMeasure.OPERATION_BODY_TAGTYPE));
        return visitDimensionalMeasure(element);
    }

    @objid ("6ed451b6-ea66-44dd-9961-5766dde79e98")
    @Override
    public Object visitCountingMeasure(ModelElement element, Object data) throws Exception {
        return visitDirectMeasure(element, data);
    }

    @objid ("089748c0-56dc-4724-a29b-bbdd17d4240c")
    @Override
    public Object visitBinaryMeasure(ModelElement element, Object data) throws Exception {
        eu.measure.smm.BinaryMeasure emfElement = (eu.measure.smm.BinaryMeasure) getEmfElementFor(element);
        emfElement.setCustomFunctor(getOperationFor(element, measure.smm.api.collectivemeasures.class_.BinaryMeasure.CUSTOMFUNCTOR_BODY_TAGTYPE));
        return visitDimensionalMeasure(element);
    }

    @objid ("69f602a5-915b-4358-914f-9dfe843be8af")
    @Override
    public Object visitRatioMeasure(ModelElement element, Object data) throws Exception {
        return visitBinaryMeasure(element, data);
    }

    @objid ("91507992-aa34-4589-bd72-c99257931327")
    @Override
    public Object visitBaseNMeasureRelationship(ModelElement element, Object data) throws Exception {
        return visitBaseMeasureRelationship(element);
    }

    @objid ("70891e44-133c-47be-8cfd-6db1a891fea9")
    private Object visitBaseMeasureRelationship(ModelElement element) {
        return visitMeasureRelationship(element);
    }

    @objid ("ee102bef-26c0-4d85-afec-d24d9d9aab69")
    @Override
    public Object visitBase1MeasureRelationship(ModelElement element, Object data) throws Exception {
        return visitBaseMeasureRelationship(element);
    }

    @objid ("eeb27c6b-030f-43a6-a163-4707c4e5e8ef")
    @Override
    public Object visitBase2MeasureRelationship(ModelElement element, Object data) throws Exception {
        return visitBaseMeasureRelationship(element);
    }

// Other measures package
    @objid ("4e693f20-25aa-4096-873d-0aca883dd1be")
    @Override
    public Object visitNamedMeasure(ModelElement element, Object data) throws Exception {
        return visitDimensionalMeasure(element);
    }

    @objid ("fa895951-9cad-4974-9d29-181a2ff3d714")
    @Override
    public Object visitRescaledMeasure(ModelElement element, Object data) throws Exception {
        RescaledMeasure emfElement = (RescaledMeasure) getEmfElementFor(element);
        emfElement.setOperation(getOperationFor(element, measure.smm.api.othermeasures.class_.RescaledMeasure.OPERATION_BODY_TAGTYPE));
        
        for (Dependency d : element.getDependsOnDependency()) { 
            if (d.isStereotyped(ISMMPeerModule.MODULE_NAME, Rescales.STEREOTYPE_NAME)) {
               BaseMeasureRelationship target = (BaseMeasureRelationship) getEmfElementFor(d.getDependsOn());
               emfElement.setRescales(target);
               
               // Validation: there should be only one
               break;
            }  
        }
        return visitDimensionalMeasure(element);
    }

    @objid ("7f59ca4e-f1f4-4619-a6e2-fad7d23ea1ee")
    @Override
    public Object visitRescaledMeasureRelationship(ModelElement element, Object data) throws Exception {
        return visitMeasureRelationship(element);
    }

// Measurements package
    @objid ("f7771d80-67ac-45e8-ad9c-c54c0859a464")
    @Override
    public Object visitEquivalentMeasurementRelationship(ModelElement element, Object data) throws Exception {
        return visitMeasurementRelationship(element);
    }

    @objid ("29df949b-eadb-4b2a-9fc5-06b350fefdef")
    @Override
    public Object visitRefinementMeasurementRelationship(ModelElement element, Object data) throws Exception {
        return visitMeasurementRelationship(element);
    }

    @objid ("47208aef-5402-4850-94d5-fe2debe57193")
    @Override
    public Object visitGradeMeasurement(ModelElement element, Object data) throws Exception {
        eu.measure.smm.GradeMeasurement emfElement = (eu.measure.smm.GradeMeasurement) getEmfElementFor(element);
        emfElement.setBaseQuery(getOperationFor(element, measure.smm.api.measurements.class_.GradeMeasurement.GRADEMEASUREMENT_BASEQUERY_BODY_TAGTYPE));
        return visitMeasurement(element);
    }

    @objid ("526b39e0-0dd3-43a6-969d-48c71e109ace")
    private Object visitMeasurement(ModelElement element) {
        return visitSmmElement(element, null);
    }

    @objid ("1ff0c7b3-19bd-46fb-b182-bf1edb94434a")
    @Override
    public Object visitGradeMeasurementRelationship(ModelElement element, Object data) throws Exception {
        return visitMeasurementRelationship(element);
    }

    @objid ("8ea51092-4030-4277-afda-45e4bdb06164")
    @Override
    public Object visitRankingMeasurement(ModelElement element, Object data) throws Exception {
        return visitMeasurement(element);
    }

    @objid ("27887fb2-43c6-44d4-9cdc-eadbd274eaf8")
    private Object visitMeasurementRelationship(ModelElement element) {
        return visitSmmRelationship(element);
    }

    @objid ("2b04ad24-59a5-4dda-a3aa-d02bb6716196")
    @Override
    public Object visitRankingMeasurementRelationship(ModelElement element, Object data) throws Exception {
        return visitMeasurementRelationship(element);
    }

// Collective measurements
    @objid ("01fdabd2-f4f8-42fc-8ac8-a41ee80afa77")
    @Override
    public Object visitCollectiveMeasurement(ModelElement element, Object data) throws Exception {
        eu.measure.smm.CollectiveMeasurement emfElement = (eu.measure.smm.CollectiveMeasurement) getEmfElementFor(element);
        emfElement.setBaseQuery(getOperationFor(element, measure.smm.api.collectivemeasurements.class_.CollectiveMeasurement.COLLECTIVEMEASUREMENT_BASE_QUERY_BODY_TAGTYPE));
        return visitMeasurement(element);
    }

    @objid ("951daf5e-37d1-416f-95f7-5bf267106ae9")
    @Override
    public Object visitDirectMeasurement(ModelElement element, Object data) throws Exception {
        return visitDimensionalMeasurent(element);
    }

    @objid ("53072191-1c83-417b-b097-885d1113f54c")
    private Object visitDimensionalMeasurent(ModelElement element) {
        return visitMeasurement(element);
    }

    @objid ("b4e55dad-9ebb-48a0-9657-2fc543e21ff4")
    @Override
    public Object visitCountingMeasurement(ModelElement element, Object data) throws Exception {
        return visitDirectMeasurement(element, null);
    }

    @objid ("b7960671-d2dc-4cb0-84da-1face7669785")
    @Override
    public Object visitBinaryMeasurement(ModelElement element, Object data) throws Exception {
        return visitDirectMeasurement(element, data);
    }

    @objid ("85f175a2-943b-49a4-ae85-36b71e5ea365")
    @Override
    public Object visitRatioMeasurement(ModelElement element, Object data) throws Exception {
        return visitBinaryMeasurement(element, data);
    }

    @objid ("5dceb18c-7da0-46b7-9f94-213a2d0b00bd")
    @Override
    public Object visitBaseNMeasurementRelationship(ModelElement element, Object data) throws Exception {
        return visitBaseMeasurementRelationship(element);
    }

    @objid ("db0e2c22-33b0-4ee5-b22d-01f6f72ad9dd")
    @Override
    public Object visitBase1MeasurementRelationship(ModelElement element, Object data) throws Exception {
        return visitBaseMeasurementRelationship(element);
    }

    @objid ("252d21da-9135-4f98-9d2a-b8bf0ca90de9")
    private Object visitBaseMeasurementRelationship(ModelElement element) {
        return visitMeasurementRelationship(element);
    }

    @objid ("287ec923-e312-4624-88d7-b443feecba67")
    @Override
    public Object visitBase2MeasurementRelationship(ModelElement element, Object data) throws Exception {
        return visitBaseMeasurementRelationship(element);
    }

// Named and rescaled measurements
    @objid ("d2ef6464-7104-4076-b1b7-89f6b317b782")
    @Override
    public Object visitNamedMeasurement(ModelElement element, Object data) throws Exception {
        return visitDimensionalMeasurent(element);
    }

    @objid ("c0336a6c-e21d-47b3-98b6-bed93e77e6e7")
    @Override
    public Object visitRescaledMeasurement(ModelElement element, Object data) throws Exception {
        RescaledMeasurement emfElement = (RescaledMeasurement) getEmfElementFor(element);
        emfElement.setBaseQuery(getOperationFor(element, measure.smm.api.namedandrescaledmeasurements.class_.RescaledMeasurement.RESCALEDMEASUREMENT_BASEQUERY_BODY_TAGTYPE));
        return visitDimensionalMeasurent(element);
    }

    @objid ("402f1b5c-f09a-4bc8-bd74-57423aaa7667")
    @Override
    public Object visitRescaledMeasurementRelationship(ModelElement element, Object data) throws Exception {
        return visitMeasurementRelationship(element);
    }

// Observations
    @objid ("c44762f7-4213-4c01-9427-c318c82b85bc")
    @Override
    public Object visitObservation(ModelElement element, Object data) throws Exception {
        Observation emfElement = (Observation) getEmfElementFor(element);
        for (Dependency d : element.getDependsOnDependency()) {
            if (d.isStereotyped(ISMMPeerModule.MODULE_NAME, RequestedMeasureLink.STEREOTYPE_NAME)) {
               Measure target = (Measure) getEmfElementFor(d.getDependsOn());
               emfElement.getRequestedMeasures().add(target);
            } 
        }
        return visitSmmElement(element, data);
    }

    @objid ("f64168dc-065a-4c31-afda-fc0b948fcabe")
    private Object visitSmmElement(ModelElement element, Object data) {
        return null;
    }

    @objid ("b2d6d69f-5383-4439-8306-a693898ff802")
    @Override
    public Object visitObservedMeasure(ModelElement element, Object data) throws Exception {
        ObservedMeasure emfElement = (ObservedMeasure) getEmfElementFor(element);
        for (Dependency d : element.getDependsOnDependency()) {
            if (d.isStereotyped(ISMMPeerModule.MODULE_NAME, ObservedMeasureLink.STEREOTYPE_NAME)) {
               Measure target = (Measure) getEmfElementFor(d.getDependsOn());
               emfElement.setMeasure(target);
               
               // Validation: there should be only one
               break;
            } 
        }
        return visitSmmElement(element, data);
    }

    @objid ("fc92d718-71b2-446b-b68e-8b2b88b6a4f4")
    @Override
    public Object visitObservationScope(ModelElement element, Object data) throws Exception {
        return null;
    }

    @objid ("635bbae1-5972-4864-8c37-980485851e46")
    @Override
    public Object visitOCLOperation(ModelElement element, Object data) throws Exception {
        return visitSmmElement(element, data);
    }

}
