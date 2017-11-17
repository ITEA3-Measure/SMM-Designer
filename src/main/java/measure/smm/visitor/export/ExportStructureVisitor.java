package measure.smm.visitor.export;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import eu.measure.smm.Accumulator;
import eu.measure.smm.Annotation;
import eu.measure.smm.Argument;
import eu.measure.smm.Attribute;
import eu.measure.smm.BinaryFunctor;
import eu.measure.smm.BinaryMeasure;
import eu.measure.smm.BinaryMeasurement;
import eu.measure.smm.CategoryRelationship;
import eu.measure.smm.Characteristic;
import eu.measure.smm.CollectiveMeasure;
import eu.measure.smm.CollectiveMeasurement;
import eu.measure.smm.CountingMeasure;
import eu.measure.smm.CountingMeasurement;
import eu.measure.smm.DimensionalMeasure;
import eu.measure.smm.DimensionalMeasurement;
import eu.measure.smm.DirectMeasure;
import eu.measure.smm.DirectMeasurement;
import eu.measure.smm.GradeInterval;
import eu.measure.smm.GradeMeasure;
import eu.measure.smm.GradeMeasurement;
import eu.measure.smm.Influence;
import eu.measure.smm.Interval;
import eu.measure.smm.Measure;
import eu.measure.smm.MeasureCategory;
import eu.measure.smm.MeasureLibrary;
import eu.measure.smm.MeasureRelationship;
import eu.measure.smm.Measurement;
import eu.measure.smm.MeasurementRelationship;
import eu.measure.smm.NamedMeasure;
import eu.measure.smm.NamedMeasurement;
import eu.measure.smm.Observation;
import eu.measure.smm.ObservationScope;
import eu.measure.smm.ObservedMeasure;
import eu.measure.smm.Operation;
import eu.measure.smm.RankingInterval;
import eu.measure.smm.RankingMeasure;
import eu.measure.smm.RankingMeasurement;
import eu.measure.smm.RatioMeasure;
import eu.measure.smm.RatioMeasurement;
import eu.measure.smm.RescaledMeasure;
import eu.measure.smm.RescaledMeasurement;
import eu.measure.smm.ScaleOfMeasurement;
import eu.measure.smm.Scope;
import eu.measure.smm.SmmElement;
import eu.measure.smm.SmmFactory;
import eu.measure.smm.SmmModel;
import eu.measure.smm.SmmRelationship;
import eu.measure.smm.UnitOfMeasure;
import measure.smm.api.ISMMPeerModule;
import measure.smm.api.measurements.dependency.Measurand;
import org.eclipse.emf.ecore.EObject;
import org.modelio.metamodel.uml.infrastructure.Dependency;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.statik.Class;
import org.modelio.metamodel.uml.statik.Package;

/* XXX In the future, it would be nice to have a validator to check the model before exporting... 
   For now, I marked the things that need to be checked with // Validate */
/**
 * Visits a Modelio UML model and creates the equivalent EMF SMM model
 * The <pre>data</pre> parameter should contain the EMF parent of the to be created element.
 * Each method should return the newly created element.
 * 
 * The objects created by this visitor can be retrieved by using the <pre>getEObject</pre> method.
 * @author malmeida
 */
@objid ("9652752e-0f2d-42fd-b33c-e6db63e7c9b3")
public class ExportStructureVisitor implements SMMModelVisitor {
    @objid ("41af2f08-5c45-4360-96aa-a34592b7c94f")
    private MeasureLibrary currentMeasureLibrary;

    @objid ("e6a74070-3ce5-4c0b-b9bc-b65bca158681")
    private Map<String, EObject> objects = new HashMap<String, EObject>();

// core package
    @objid ("991310c2-afce-4c49-999c-eabaf2c24ff0")
    @Override
    public Object visitSmmModel(ModelElement element, Object data) throws Exception {
        SmmModel model = SmmFactory.eINSTANCE.createSmmModel();
        visitSmmElement(model, measure.smm.api.core.package_.SmmModel.instantiate((Package) element));
        return model;
    }

    @objid ("639aee42-50aa-4aa9-b659-7880d80ba645")
    private void visitSmmElement(SmmElement emfElement, measure.smm.api.core.modelelement.SmmElement modelioElement) {
        emfElement.setName(modelioElement.getElement().getName());
        emfElement.setDescription(modelioElement.getDescription());
        emfElement.setShortDescription(modelioElement.getShortDescription());
        
        objects.put(modelioElement.getElement().getUuid().toString(), emfElement);
        
        // Extensions package
        List<String> attribute_tags = modelioElement.getElement().getTagValues(ISMMPeerModule.MODULE_NAME, measure.smm.api.core.modelelement.SmmElement.EXTENSIONS_ATTRIBUTE_TAG_TAGTYPE);        
        List<String> attribute_values = modelioElement.getElement().getTagValues(ISMMPeerModule.MODULE_NAME, measure.smm.api.core.modelelement.SmmElement.EXTENSIONS_ATTRIBUTE_VALUE_TAGTYPE);        
        if (attribute_tags != null && attribute_values != null) { // Validation
            for(int i=0;i<attribute_tags.size();++i) {                
                Attribute emfAttribute = SmmFactory.eINSTANCE.createAttribute();
                emfAttribute.setTag(attribute_tags.get(i));
                emfAttribute.setValue(attribute_values.get(i));
                emfElement.getAttributes().add(emfAttribute);
            }
        }
        
        List<String> annotations = modelioElement.getElement().getTagValues(ISMMPeerModule.MODULE_NAME, measure.smm.api.core.modelelement.SmmElement.EXTENSIONS_ANNOTATION_TEXT_TAGTYPE);        
        if (annotations != null) {
            for(String annotationText : annotations) {
                Annotation emfAnnotation = SmmFactory.eINSTANCE.createAnnotation();
                emfAnnotation.setText(annotationText);
                emfElement.getAnnotations().add(emfAnnotation);
            }
        }
    }

    @objid ("676610d2-927f-4cfb-a022-7d1984da7268")
    private void visitSmmRelationship(SmmRelationship emfElement, measure.smm.api.core.dependency.SmmRelationship modelioElement) {
        visitSmmElement(emfElement, modelioElement);
    }

    @objid ("331893dd-ef37-48cb-8e03-523a3f67166d")
    @Override
    public Object visitMeasureLibrary(ModelElement element, Object data) throws Exception {
        SmmModel parent = (SmmModel) data;
        MeasureLibrary newElement = SmmFactory.eINSTANCE.createMeasureLibrary();
        parent.getLibraries().add(newElement);
        measure.smm.api.core.package_.MeasureLibrary modelioElement = measure.smm.api.core.package_.MeasureLibrary.instantiate((Package) element); 
        visitSmmElement(newElement, modelioElement);
        currentMeasureLibrary = newElement;
        return newElement;
    }

    @objid ("f928bd29-8dce-4811-bf7f-b639cb55ac1a")
    @Override
    public Object visitMeasureCategory(ModelElement element, Object data) throws Exception {
        MeasureLibrary parent = currentMeasureLibrary;
        MeasureCategory newElement = SmmFactory.eINSTANCE.createMeasureCategory();
        parent.getMeasureElements().add(newElement);
        measure.smm.api.core.package_.MeasureCategory modelioElement = measure.smm.api.core.package_.MeasureCategory.instantiate((Package) element); 
        visitSmmElement(newElement, modelioElement);
        return newElement;
    }

    @objid ("23e6c52a-46cc-40ca-a322-dcae98fd4f19")
    @Override
    public Object visitCategoryRelationship(ModelElement element, Object data) throws Exception {
        MeasureLibrary parent = currentMeasureLibrary;
        CategoryRelationship newElement = SmmFactory.eINSTANCE.createCategoryRelationship();
        parent.getCategoryRelationships().add(newElement);
        measure.smm.api.core.dependency.CategoryRelationship modelioElement = measure.smm.api.core.dependency.CategoryRelationship.instantiate((Dependency) element);
        visitSmmElement(newElement, modelioElement);
        return newElement;
    }

// Measures package
    @objid ("9aedaac7-299c-406f-9756-77ad10423f1f")
    @Override
    public Object visitCharacteristic(ModelElement element, Object data) throws Exception {
        MeasureLibrary parent = (MeasureLibrary) data;
        Characteristic newElement = SmmFactory.eINSTANCE.createCharacteristic();
        parent.getMeasureElements().add(newElement);
        measure.smm.api.measures.class_.Characteristic modelioElement = measure.smm.api.measures.class_.Characteristic.instantiate((Class) element);
        visitSmmElement(newElement, modelioElement);
        return newElement;
    }

    @objid ("db930e43-cb0d-49d0-b58c-c829c8390aa9")
    @Override
    public Object visitScope(ModelElement element, Object data) throws Exception {
        MeasureLibrary parent = currentMeasureLibrary;
        Scope newElement = SmmFactory.eINSTANCE.createScope();
        parent.getMeasureElements().add(newElement);
        if (element instanceof Class) {
                measure.smm.api.measures.class_.ScopeElement modelioElement = measure.smm.api.measures.class_.ScopeElement.instantiate((Class) element);
                visitSmmElement(newElement, modelioElement);
                newElement.setClass_(modelioElement.getClass_MOF());
                newElement.setStereotype(modelioElement.getStereotype());
        
                Operation op = createOperation(modelioElement, modelioElement.BREAK_CONDITION_BODY_TAGTYPE, modelioElement.getBreak_condition_body(),  modelioElement.getBreak_condition_language());
                if (op != null) {
                    parent.getMeasureElements().add(op);
                }
                op = createOperation(modelioElement, modelioElement.RECOGNIZER_BODY_TAGTYPE, modelioElement.getRecognizer_body(),  modelioElement.getRecognizer_language());
                if (op != null) {
                    parent.getMeasureElements().add(op); 
                }
        } else if (element instanceof Dependency) {
                measure.smm.api.measures.dependency.ScopeLink modelioElement = measure.smm.api.measures.dependency.ScopeLink.instantiate((Dependency) element);
                visitSmmElement(newElement, modelioElement);
                newElement.setClass_(modelioElement.getElement().getDependsOn().getName()); 
        
                Operation op = createOperation(modelioElement, modelioElement.BREAK_CONDITION_BODY_TAGTYPE, modelioElement.getBreak_condition_body(),  modelioElement.getBreak_condition_language());
                if (op != null) {
                    parent.getMeasureElements().add(op);
                }
                op = createOperation(modelioElement, modelioElement.RECOGNIZER_BODY_TAGTYPE, modelioElement.getRecognizer_body(),  modelioElement.getRecognizer_language());
                if (op != null) {
                    parent.getMeasureElements().add(op); 
                }
        }
        return newElement;
    }

    @objid ("8e68cc24-19ff-4998-bd06-035f77313fc4")
    @Override
    public Object visitUnitOfMeasure(ModelElement element, Object data) throws Exception {
        MeasureLibrary parent = currentMeasureLibrary;
        UnitOfMeasure newElement = SmmFactory.eINSTANCE.createUnitOfMeasure();
        parent.getMeasureElements().add(newElement);
        measure.smm.api.measures.class_.UnitOfMeasure modelioElement = measure.smm.api.measures.class_.UnitOfMeasure.instantiate((Class) element);
        visitSmmElement(newElement, modelioElement);
        return newElement;
    }

    @objid ("58a8c249-0f27-4c0e-8b64-e2b8ccb86f63")
    @Override
    public Object visitEquivalentMeasureRelationship(ModelElement element, Object data) throws Exception {
        MeasureLibrary parent = currentMeasureLibrary;        
        eu.measure.smm.EquivalentMeasureRelationship newElement = SmmFactory.eINSTANCE.createEquivalentMeasureRelationship(); 
        measure.smm.api.measures.dependency.EquivalentMeasureRelationship modelioElement = measure.smm.api.measures.dependency.EquivalentMeasureRelationship.instantiate((Dependency) element);
        Operation op = createOperation(modelioElement, modelioElement.MAPPING_BODY_TAGTYPE, modelioElement.getMapping_body(),  modelioElement.getMapping_language());
        if (op != null) {
              parent.getMeasureElements().add(op); 
        }
        
        visitMeasureRelationship(newElement, modelioElement, (Measure)data);
        return newElement;
    }

    @objid ("c6b42be3-ef6d-484b-a5ce-84e350d034fa")
    @Override
    public Object visitRefinementMeasureRelationship(ModelElement element, Object data) throws Exception {
        return visitMeasureRelationship(SmmFactory.eINSTANCE.createRefinementMeasureRelationship(), measure.smm.api.measures.dependency.RefinementMeasureRelationship.instantiate((Dependency) element), (Measure)data);
    }

    @objid ("aa5d302d-d0ad-40e8-8249-8d1eabd8ce56")
    @Override
    public Object visitGradeMeasure(ModelElement element, Object data) throws Exception {
        MeasureLibrary parent = currentMeasureLibrary;
        GradeMeasure newElement = SmmFactory.eINSTANCE.createGradeMeasure();
        parent.getMeasureElements().add(newElement);
        measure.smm.api.measures.class_.GradeMeasure modelioElement = measure.smm.api.measures.class_.GradeMeasure.instantiate((Class) element);
        visitSmmElement(newElement, modelioElement);
        visitMeasure(newElement, modelioElement);
        return newElement;
    }

    @objid ("1932579f-3923-4045-a70b-2fc08fc255c1")
    @Override
    public Object visitGradeMeasureRelationship(ModelElement element, Object data) throws Exception {
        return visitMeasureRelationship(SmmFactory.eINSTANCE.createGradeMeasureRelationship(), measure.smm.api.measures.dependency.GradeMeasureRelationship.instantiate((Dependency) element), (Measure)data);
    }

    @objid ("bbac1a8d-07dd-4325-90b3-afad932595ef")
    private void visitInterval(Interval emfElement, measure.smm.api.measures.class_.Interval modelioElement) {
        try {
            emfElement.setMinimumOpen(new Boolean(modelioElement.getMinimumOpen()));
        } catch(Exception e) {
            // e.printStackTrace(); // Validate
        }
        try {
            emfElement.setMaximumOpen(new Boolean(modelioElement.getMaximumOpen()));
        } catch(Exception e) {
            // e.printStackTrace(); // Validate
        }
        try {
            emfElement.setMinimumEndpoint(new Double(modelioElement.getMinimum()));
        } catch(Exception e) {
            // e.printStackTrace(); // Validate
        }
        try {
            emfElement.setMaximumEndpoint(new Double(modelioElement.getMaximum()));
        } catch(Exception e) {
            // e.printStackTrace(); // Validate
        }
    }

    @objid ("75df6f9e-4fda-45a9-9f7d-60429ad3b21c")
    @Override
    public Object visitGradeInterval(ModelElement element, Object data) throws Exception {
        GradeMeasure parent = (GradeMeasure) data;
        GradeInterval newElement = SmmFactory.eINSTANCE.createGradeInterval();
        parent.getInterval().add(newElement);
        measure.smm.api.measures.class_.GradeInterval modelioElement = measure.smm.api.measures.class_.GradeInterval.instantiate((Class) element);
        visitSmmElement(newElement, modelioElement);
        visitInterval(newElement, modelioElement);
        
        newElement.setSymbol(modelioElement.getElement().getName());
        return newElement;
    }

    @objid ("c62dcadb-778b-49f7-a03c-a4d77d074122")
    @Override
    public Object visitRankingMeasure(ModelElement element, Object data) throws Exception {
        MeasureLibrary parent = currentMeasureLibrary;
        RankingMeasure newElement = SmmFactory.eINSTANCE.createRankingMeasure();
        parent.getMeasureElements().add(newElement);
        measure.smm.api.measures.class_.RankingMeasure modelioElement = measure.smm.api.measures.class_.RankingMeasure.instantiate((Class) element);
        visitSmmElement(newElement, modelioElement);
        visitMeasure(newElement, modelioElement);
        return newElement;
    }

    @objid ("b2969824-0ff4-4468-8e26-bb1ee0f5fa99")
    @Override
    public Object visitRankingMeasureRelationship(ModelElement element, Object data) throws Exception {
        return visitMeasureRelationship(SmmFactory.eINSTANCE.createRankingMeasureRelationship(), measure.smm.api.measures.dependency.RankingMeasureRelationship.instantiate((Dependency) element), (Measure)data);
    }

    @objid ("e81200e1-5268-4ae4-9fdc-a4a922d62b01")
    @Override
    public Object visitRankingInterval(ModelElement element, Object data) throws Exception {
        RankingMeasure parent = (RankingMeasure) data;
        RankingInterval newElement = SmmFactory.eINSTANCE.createRankingInterval();
        parent.getInterval().add(newElement);
        measure.smm.api.measures.class_.RankingInterval modelioElement = measure.smm.api.measures.class_.RankingInterval.instantiate((Class) element);
        visitSmmElement(newElement, modelioElement);
        visitInterval(newElement, modelioElement);
        try {
            newElement.setValue(new Double(modelioElement.getValue())); // Validation
        } catch(Exception e) {
            // e.printStackTrace(); // Validate
        }
        return newElement;
    }

// Collective measures package
    @objid ("e82f7cc6-dfa8-48a5-9ad2-2bf88fbaaa90")
    @Override
    public Object visitCollectiveMeasure(ModelElement element, Object data) throws Exception {
        MeasureLibrary parent = currentMeasureLibrary;
        CollectiveMeasure newElement = SmmFactory.eINSTANCE.createCollectiveMeasure();
        parent.getMeasureElements().add(newElement);
        measure.smm.api.collectivemeasures.class_.CollectiveMeasure modelioElement = measure.smm.api.collectivemeasures.class_.CollectiveMeasure.instantiate((Class) element);
        visitSmmElement(newElement, modelioElement);
        visitMeasure(newElement, modelioElement);
        
         Operation op = createOperation(modelioElement, modelioElement.CUSTOMACCUMULATOR_BODY_TAGTYPE, modelioElement.getCustomAccumulator_body(),  modelioElement.getCustomAccumulator_language());
        if (op != null) {
            parent.getMeasureElements().add(op);
            newElement.setAccumulator(Accumulator.CUSTOM);
        } else { // Validate
            if ("sum".equals(modelioElement.getAccumulator())) {
                newElement.setAccumulator(Accumulator.SUM);
            } else if ("minimum".equals(modelioElement.getAccumulator())) {
                    newElement.setAccumulator(Accumulator.MINIMUM);
            } else if ("maximum".equals(modelioElement.getAccumulator())) {
                newElement.setAccumulator(Accumulator.MAXIMUM);
            } else if ("average".equals(modelioElement.getAccumulator())) {
                newElement.setAccumulator(Accumulator.AVERAGE);
            } else if ("standardDeviation".equals(modelioElement.getAccumulator())) {
                newElement.setAccumulator(Accumulator.STANDARD_DEVIATION);
            } else if ("product".equals(modelioElement.getAccumulator())) {
                newElement.setAccumulator(Accumulator.PRODUCT);
            } else {
                newElement.setAccumulator(Accumulator.CUSTOM);
            }
        }
        return newElement;
    }

    @objid ("fdc8d2dd-9989-451c-bc62-c9611fba290f")
    @Override
    public Object visitDirectMeasure(ModelElement element, Object data) throws Exception {
        MeasureLibrary parent = currentMeasureLibrary;
        DirectMeasure newElement = SmmFactory.eINSTANCE.createDirectMeasure();
        parent.getMeasureElements().add(newElement);
        measure.smm.api.collectivemeasures.class_.DirectMeasure modelioElement = measure.smm.api.collectivemeasures.class_.DirectMeasure.instantiate((Class) element);
        visitSmmElement(newElement, modelioElement);
        visitMeasure(newElement, modelioElement);
        visitDimensionalMeasure(newElement, modelioElement);
        
        Operation op = createOperation(modelioElement, modelioElement.OPERATION_BODY_TAGTYPE, modelioElement.getOperation_body(),  modelioElement.getOperation_language());
        if (op != null) {
            parent.getMeasureElements().add(op);
        }
        return newElement;
    }

    @objid ("8cdcff71-e1cb-4a71-884a-b1d48412c8e3")
    @Override
    public Object visitCountingMeasure(ModelElement element, Object data) throws Exception {
        MeasureLibrary parent = currentMeasureLibrary;
        CountingMeasure newElement = SmmFactory.eINSTANCE.createCountingMeasure();
        parent.getMeasureElements().add(newElement);
        measure.smm.api.collectivemeasures.class_.CountingMeasure modelioElement = measure.smm.api.collectivemeasures.class_.CountingMeasure.instantiate((Class) element);
        visitSmmElement(newElement, modelioElement);
        visitMeasure(newElement, modelioElement);
        visitDimensionalMeasure(newElement, modelioElement);
        return newElement;
    }

    @objid ("605d3009-52e5-4fc8-a338-bbbe4b1e3e83")
    @Override
    public Object visitBinaryMeasure(ModelElement element, Object data) throws Exception {
        MeasureLibrary parent = currentMeasureLibrary;
        BinaryMeasure newElement = SmmFactory.eINSTANCE.createBinaryMeasure();
        parent.getMeasureElements().add(newElement);
        measure.smm.api.collectivemeasures.class_.BinaryMeasure modelioElement = measure.smm.api.collectivemeasures.class_.BinaryMeasure.instantiate((Class) element);
        visitSmmElement(newElement, modelioElement);
        visitMeasure(newElement, modelioElement);
        visitDimensionalMeasure(newElement, modelioElement);
        
        Operation op = createOperation(modelioElement, modelioElement.CUSTOMFUNCTOR_BODY_TAGTYPE, modelioElement.getCustomFunctor_body(),  modelioElement.getCustomFunctor_language());
        if (op != null) {
            parent.getMeasureElements().add(op);
            newElement.setFunctor(BinaryFunctor.CUSTOM);
        } else {
            if ("plus".equals(modelioElement.getFunctor())) {
                newElement.setFunctor(BinaryFunctor.PLUS);
            } else if ("minus".equals(modelioElement.getFunctor())) {
                newElement.setFunctor(BinaryFunctor.MINUS);
            } else if ("multiply".equals(modelioElement.getFunctor())) { 
                newElement.setFunctor(BinaryFunctor.MULTIPLY);
            } else if ("divide".equals(modelioElement.getFunctor())) {
                newElement.setFunctor(BinaryFunctor.DIVIDE);
            } // Validate
        }
        return newElement;
    }

    @objid ("a3f0f529-8e72-427b-9ee6-716f4f10dad5")
    @Override
    public Object visitRatioMeasure(ModelElement element, Object data) throws Exception {
        MeasureLibrary parent = currentMeasureLibrary;
        RatioMeasure newElement = SmmFactory.eINSTANCE.createRatioMeasure();
        parent.getMeasureElements().add(newElement);
        measure.smm.api.collectivemeasures.class_.RatioMeasure modelioElement = measure.smm.api.collectivemeasures.class_.RatioMeasure.instantiate((Class) element);
        visitSmmElement(newElement, modelioElement);
        visitMeasure(newElement, modelioElement);
        visitDimensionalMeasure(newElement, modelioElement);
        newElement.setFunctor(BinaryFunctor.DIVIDE);
        return newElement;
    }

    @objid ("85527c06-17c1-44ba-ba29-18374dfd3fc0")
    @Override
    public Object visitBaseNMeasureRelationship(ModelElement element, Object data) throws Exception {
        return visitMeasureRelationship(SmmFactory.eINSTANCE.createBaseNMeasureRelationship(), measure.smm.api.collectivemeasures.dependency.BaseNMeasureRelationship.instantiate((Dependency) element), (Measure)data);
    }

    @objid ("c19530a3-786b-4853-8a4a-64436d6c384d")
    @Override
    public Object visitBase1MeasureRelationship(ModelElement element, Object data) throws Exception {
        return visitMeasureRelationship(SmmFactory.eINSTANCE.createBase1MeasureRelationship(), measure.smm.api.collectivemeasures.dependency.Base1MeasureRelationship.instantiate((Dependency) element), (Measure)data);
    }

    @objid ("f8ada6fc-77ae-4e6b-844f-428cb127074b")
    @Override
    public Object visitBase2MeasureRelationship(ModelElement element, Object data) throws Exception {
        return visitMeasureRelationship(SmmFactory.eINSTANCE.createBase2MeasureRelationship(), measure.smm.api.collectivemeasures.dependency.Base2MeasureRelationship.instantiate((Dependency) element), (Measure)data);
    }

// Other measures package
    @objid ("e4ee2b0f-c45e-40e4-a25f-2992b11dcb60")
    @Override
    public Object visitNamedMeasure(ModelElement element, Object data) throws Exception {
        MeasureLibrary parent = currentMeasureLibrary;
        NamedMeasure newElement = SmmFactory.eINSTANCE.createNamedMeasure();
        parent.getMeasureElements().add(newElement);
        measure.smm.api.othermeasures.class_.NamedMeasure modelioElement = measure.smm.api.othermeasures.class_.NamedMeasure.instantiate((Class) element);
        visitSmmElement(newElement, modelioElement);
        visitMeasure(newElement, modelioElement);
        visitDimensionalMeasure(newElement, modelioElement);
        newElement.setName(modelioElement.getElement().getName());
        return newElement;
    }

    @objid ("4ec86aa6-f733-4895-8737-772de92b760a")
    @Override
    public Object visitRescaledMeasure(ModelElement element, Object data) throws Exception {
        MeasureLibrary parent = currentMeasureLibrary;
        RescaledMeasure newElement = SmmFactory.eINSTANCE.createRescaledMeasure();
        parent.getMeasureElements().add(newElement);
        measure.smm.api.othermeasures.class_.RescaledMeasure modelioElement = measure.smm.api.othermeasures.class_.RescaledMeasure.instantiate((Class) element);
        visitSmmElement(newElement, modelioElement);
        visitMeasure(newElement, modelioElement);
        visitDimensionalMeasure(newElement, modelioElement);
        try {
            newElement.setMultiplier(new Double(modelioElement.getMultiplier()));
        } catch(Exception e) {
            // e.printStackTrace(); // Validate
        }
            
        try {
            newElement.setOffset(new Double(modelioElement.getOffset()));
        } catch(Exception e) {
            // Validate
        }
        Operation op = createOperation(modelioElement, modelioElement.OPERATION_BODY_TAGTYPE, modelioElement.getOperation_body(),  modelioElement.getOperation_language());
        if (op != null) {
            parent.getMeasureElements().add(op);
        }
        return newElement;
    }

    @objid ("5a013cf5-65e2-46f3-b6c4-949bfead888a")
    @Override
    public Object visitRescaledMeasureRelationship(ModelElement element, Object data) throws Exception {
        return visitMeasureRelationship(SmmFactory.eINSTANCE.createRescaledMeasureRelationship(), measure.smm.api.othermeasures.dependency.RescaledMeasureRelationship.instantiate((Dependency) element), (Measure)data);
    }

// Measurements package
    @objid ("6ce88915-5a99-475a-8be2-02494d525240")
    @Override
    public Object visitEquivalentMeasurementRelationship(ModelElement element, Object data) throws Exception {
        return visitMeasurementRelationship(SmmFactory.eINSTANCE.createEquivalentMeasurementRelationship(), measure.smm.api.measurements.dependency.EquivalentMeasurementRelationship.instantiate((Dependency) element), (Measurement)data);
    }

    @objid ("616e54a6-4562-49ed-a07b-da5768e083f1")
    @Override
    public Object visitRefinementMeasurementRelationship(ModelElement element, Object data) throws Exception {
        return visitMeasurementRelationship(SmmFactory.eINSTANCE.createRefinementMeasurementRelationship(), measure.smm.api.measurements.dependency.RefinementMeasurementRelationship.instantiate((Dependency) element), (Measurement)data);
    }

    @objid ("d52e7bbd-250d-4313-afbc-2ebcd7191967")
    @Override
    public Object visitGradeMeasurement(ModelElement element, Object data) throws Exception {
        ObservedMeasure parent = (ObservedMeasure) data;
        GradeMeasurement newElement = SmmFactory.eINSTANCE.createGradeMeasurement();
        measure.smm.api.measurements.class_.GradeMeasurement modelioElement = measure.smm.api.measurements.class_.GradeMeasurement.instantiate((Class) element);
        visitSmmElement(newElement, modelioElement);
        parent.getMeasurements().add(newElement); 
        
        newElement.setValue(modelioElement.getGradeMeasurement_value());
        
        visitMeasurement(newElement, modelioElement);
        try {
            newElement.setIsBaseSupplied(new Boolean(modelioElement.getGradeMeasurement_isBaseSupplied()));
        } catch(Exception e) {
            // e.printStackTrace(); // Validate
        }
        Operation op = createOperation(modelioElement, modelioElement.GRADEMEASUREMENT_BASEQUERY_BODY_TAGTYPE, modelioElement.getGradeMeasurement_baseQuery_body(),  modelioElement.getGradeMeasurement_baseQuery_language());
        if (op != null) {
            addOperationToLibratyFor(parent, op);
        }
        return newElement;
    }

    @objid ("97eb9d19-ce28-441f-b4cb-4089761c4eb4")
    @Override
    public Object visitGradeMeasurementRelationship(ModelElement element, Object data) throws Exception {
        return visitMeasurementRelationship(SmmFactory.eINSTANCE.createGradeMeasurementRelationship(), measure.smm.api.measurements.dependency.GradeMeasurementRelationship.instantiate((Dependency) element), (Measurement)data);
    }

    @objid ("2ca6bd00-19ca-4bfe-a215-0b6fc2a3e58c")
    @Override
    public Object visitRankingMeasurement(ModelElement element, Object data) throws Exception {
        ObservedMeasure parent = (ObservedMeasure) data;
        RankingMeasurement newElement = SmmFactory.eINSTANCE.createRankingMeasurement();
        measure.smm.api.measurements.class_.RankingMeasurement modelioElement = measure.smm.api.measurements.class_.RankingMeasurement.instantiate((Class) element);
        visitSmmElement(newElement, modelioElement);
        parent.getMeasurements().add(newElement); 
        
        visitMeasurement(newElement, modelioElement);
        visitDimensionalMeasurement(newElement, modelioElement);
        try {
            newElement.setIsBaseSupplied(new Boolean(modelioElement.getRankingMeasurement_isBaseSupplied()));
        } catch(Exception e) {
            // e.printStackTrace(); // Validate
        }
        Operation op = createOperation(modelioElement, modelioElement.RANKINGMEASUREMENT_BASEQUERY_BODY_TAGTYPE, modelioElement.getRankingMeasurement_baseQuery_body(),  modelioElement.getRankingMeasurement_baseQuery_language());
        if (op != null) {
            addOperationToLibratyFor(parent, op);
        }
        return newElement;
    }

    @objid ("3b0283dd-b821-4210-b34f-06fc897acd44")
    @Override
    public Object visitRankingMeasurementRelationship(ModelElement element, Object data) throws Exception {
        return visitMeasurementRelationship(SmmFactory.eINSTANCE.createRankingMeasurementRelationship(), measure.smm.api.measurements.dependency.RankingMeasureementRelationship.instantiate((Dependency) element), (Measurement)data);
    }

// Collective measurements
    @objid ("86786f5d-fa1d-472e-9a50-dfa7ffd773ff")
    @Override
    public Object visitCollectiveMeasurement(ModelElement element, Object data) throws Exception {
        ObservedMeasure parent = (ObservedMeasure) data;
        CollectiveMeasurement newElement = SmmFactory.eINSTANCE.createCollectiveMeasurement();
        measure.smm.api.collectivemeasurements.class_.CollectiveMeasurement modelioElement = measure.smm.api.collectivemeasurements.class_.CollectiveMeasurement.instantiate((Class) element);
        visitSmmElement(newElement, modelioElement);
        parent.getMeasurements().add(newElement); 
        
        visitMeasurement(newElement, modelioElement);
        visitDimensionalMeasurement(newElement, modelioElement);
        try {
            newElement.setIsBaseSupplied(new Boolean(modelioElement.getCollectiveMeasurement_isBaseSupplied()));
        } catch(Exception e) {
            // e.printStackTrace(); // Validate
        }
        Operation op = createOperation(modelioElement, modelioElement.COLLECTIVEMEASUREMENT_BASE_QUERY_BODY_TAGTYPE, modelioElement.getCollectiveMeasurement_Base_query_body(),  modelioElement.getCollectiveMeasurement_Base_query_language());
        if (op != null) {
            addOperationToLibratyFor(parent, op);
        }
        return newElement;
    }

    @objid ("256811e9-e52b-4a31-879b-32244c7ed8b8")
    @Override
    public Object visitDirectMeasurement(ModelElement element, Object data) throws Exception {
        ObservedMeasure parent = (ObservedMeasure) data;
        DirectMeasurement newElement = SmmFactory.eINSTANCE.createDirectMeasurement();
        measure.smm.api.collectivemeasurements.class_.DirectMeasurement modelioElement = measure.smm.api.collectivemeasurements.class_.DirectMeasurement.instantiate((Class) element);
        visitSmmElement(newElement, modelioElement);
        parent.getMeasurements().add(newElement); 
        
        visitMeasurement(newElement, modelioElement);
        visitDimensionalMeasurement(newElement, modelioElement);
        return newElement;
    }

    @objid ("3c94ae6c-da36-48ff-8d33-16926c9c1754")
    @Override
    public Object visitCountingMeasurement(ModelElement element, Object data) throws Exception {
        ObservedMeasure parent = (ObservedMeasure) data;
        CountingMeasurement newElement = SmmFactory.eINSTANCE.createCountingMeasurement();
        measure.smm.api.collectivemeasurements.class_.CountingMeasurement modelioElement = measure.smm.api.collectivemeasurements.class_.CountingMeasurement.instantiate((Class) element);
        visitSmmElement(newElement, modelioElement);
        parent.getMeasurements().add(newElement); 
        
        visitMeasurement(newElement, modelioElement);
        visitDimensionalMeasurement(newElement, modelioElement);
        return newElement;
    }

    @objid ("b845c65c-48a2-4b0a-9d29-68c43eca8285")
    @Override
    public Object visitBinaryMeasurement(ModelElement element, Object data) throws Exception {
        ObservedMeasure parent = (ObservedMeasure) data;
        BinaryMeasurement newElement = SmmFactory.eINSTANCE.createBinaryMeasurement();
        measure.smm.api.collectivemeasurements.class_.BinaryMeasurement modelioElement = measure.smm.api.collectivemeasurements.class_.BinaryMeasurement.instantiate((Class) element);
        visitSmmElement(newElement, modelioElement);
        parent.getMeasurements().add(newElement); 
        
        visitMeasurement(newElement, modelioElement);
        visitDimensionalMeasurement(newElement, modelioElement);
        try {
            newElement.setIsBaseSupplied(new Boolean(modelioElement.getBinaryMeasurement_isBaseSupplied()));
        } catch(Exception e) {
            // e.printStackTrace(); // Validate
        }
        Operation op = createOperation(modelioElement, modelioElement.BINARYMEASUREMENT_BASEQUERY_BODY_TAGTYPE, modelioElement.getBinaryMeasurement_baseQuery_body(),  modelioElement.getBinaryMeasurement_baseQuery_language());
        if (op != null) {
            addOperationToLibratyFor(parent, op);
        }
        return newElement;
    }

    @objid ("b1fb6585-aa5e-4a32-ae3d-4b4697d0624e")
    @Override
    public Object visitRatioMeasurement(ModelElement element, Object data) throws Exception {
        ObservedMeasure parent = (ObservedMeasure) data;
        RatioMeasurement newElement = SmmFactory.eINSTANCE.createRatioMeasurement();
        measure.smm.api.collectivemeasurements.class_.RatioMeasurement modelioElement = measure.smm.api.collectivemeasurements.class_.RatioMeasurement.instantiate((Class) element);
        visitSmmElement(newElement, modelioElement);
        parent.getMeasurements().add(newElement); 
        
        visitMeasurement(newElement, modelioElement);
        visitDimensionalMeasurement(newElement, modelioElement);
        try {
            newElement.setIsBaseSupplied(new Boolean(modelioElement.getBinaryMeasurement_isBaseSupplied()));
        } catch(Exception e) {
            // e.printStackTrace(); // Validate
        }
        Operation op = createOperation(modelioElement, modelioElement.BINARYMEASUREMENT_BASEQUERY_BODY_TAGTYPE, modelioElement.getBinaryMeasurement_baseQuery_body(),  modelioElement.getBinaryMeasurement_baseQuery_language());
        if (op != null) {
            addOperationToLibratyFor(parent, op);
        }
        return newElement;
    }

    @objid ("5e3b45a6-0a04-42b0-aeb1-dca6587d3e80")
    @Override
    public Object visitBaseNMeasurementRelationship(ModelElement element, Object data) throws Exception {
        return visitMeasurementRelationship(SmmFactory.eINSTANCE.createBaseNMeasurementRelationship(), measure.smm.api.collectivemeasurements.dependency.BaseNMeasurementRelationship.instantiate((Dependency) element), (Measurement)data);
    }

    @objid ("9807e31a-6a77-4662-8e36-e104ed44bb34")
    @Override
    public Object visitBase1MeasurementRelationship(ModelElement element, Object data) throws Exception {
        return visitMeasurementRelationship(SmmFactory.eINSTANCE.createBase1MeasurementRelationship(), measure.smm.api.collectivemeasurements.dependency.Base1MeasurementRelationship.instantiate((Dependency) element), (Measurement)data);
    }

    @objid ("f2c8267d-372e-45d1-8cf1-78b95741b38a")
    @Override
    public Object visitBase2MeasurementRelationship(ModelElement element, Object data) throws Exception {
        return visitMeasurementRelationship(SmmFactory.eINSTANCE.createBase2MeasurementRelationship(), measure.smm.api.collectivemeasurements.dependency.Base2MeasurementRelationship.instantiate((Dependency) element), (Measurement)data);
    }

// Named and rescaled measurements
    @objid ("6c6f0f5e-2020-4e41-9b27-f7cae72960e6")
    @Override
    public Object visitNamedMeasurement(ModelElement element, Object data) throws Exception {
        ObservedMeasure parent = (ObservedMeasure) data;
        NamedMeasurement newElement = SmmFactory.eINSTANCE.createNamedMeasurement();
        measure.smm.api.namedandrescaledmeasurements.class_.NamedMeasurement modelioElement = measure.smm.api.namedandrescaledmeasurements.class_.NamedMeasurement.instantiate((Class) element);
        visitSmmElement(newElement, modelioElement);
        parent.getMeasurements().add(newElement); 
        
        visitMeasurement(newElement, modelioElement);
        visitDimensionalMeasurement(newElement, modelioElement);
        return newElement;
    }

    @objid ("65bbf4b0-da9b-4c42-84cd-13b5c614275c")
    @Override
    public Object visitRescaledMeasurement(ModelElement element, Object data) throws Exception {
        ObservedMeasure parent = (ObservedMeasure) data;
        RescaledMeasurement newElement = SmmFactory.eINSTANCE.createRescaledMeasurement();
        measure.smm.api.namedandrescaledmeasurements.class_.RescaledMeasurement modelioElement = measure.smm.api.namedandrescaledmeasurements.class_.RescaledMeasurement.instantiate((Class) element);
        visitSmmElement(newElement, modelioElement);
        parent.getMeasurements().add(newElement); 
        
        visitMeasurement(newElement, modelioElement);
        visitDimensionalMeasurement(newElement, modelioElement);
        try {
            newElement.setIsBaseSupplied(new Boolean(modelioElement.getRescaledMeasurement_isBaseSupplied()));
        } catch(Exception e) {
            // e.printStackTrace(); // Validate
        }
        Operation op = createOperation(modelioElement, modelioElement.RESCALEDMEASUREMENT_BASEQUERY_BODY_TAGTYPE, modelioElement.getRescaledMeasurement_baseQuery_body(),  modelioElement.getRescaledMeasurement_baseQuery_language());
        if (op != null) {
            addOperationToLibratyFor(parent, op);
        }
        return newElement;
    }

    @objid ("47c9671d-ccad-4139-8ede-a5836f4cfaa6")
    @Override
    public Object visitRescaledMeasurementRelationship(ModelElement element, Object data) throws Exception {
        return visitMeasurementRelationship(SmmFactory.eINSTANCE.createRescaledMeasurementRelationship(), measure.smm.api.namedandrescaledmeasurements.dependency.RescaledMeasurementRelationship.instantiate((Dependency) element), (Measurement)data);
    }

// Observations
    @objid ("90efe5f4-28e1-4270-b723-fe527fcb7061")
    @Override
    public Object visitObservation(ModelElement element, Object data) throws Exception {
        SmmModel parent = (SmmModel) data;
        Observation newElement = SmmFactory.eINSTANCE.createObservation();
        parent.getObservations().add(newElement);
        
        measure.smm.api.observations.package_.Observation modelioElement = measure.smm.api.observations.package_.Observation.instantiate((Package)element); 
        newElement.setObserver(modelioElement.getObserver());
        newElement.setTool(modelioElement.getTool());
        
        try {
            newElement.setWhenObserved(new Date(modelioElement.getWhenObserved()));
        } catch(Exception e) {
            // e.printStackTrace(); // Validate
        }
        
        List<String> argument_types = modelioElement.getElement().getTagValues(ISMMPeerModule.MODULE_NAME, measure.smm.api.observations.package_.Observation.ARGUMENT_TYPES_TAGTYPE);        
        List<String> argument_values = modelioElement.getElement().getTagValues(ISMMPeerModule.MODULE_NAME, measure.smm.api.observations.package_.Observation.ARGUMENT_VALUES_TAGTYPE);        
        if (argument_types != null && argument_values != null) { // Validation
            for(int i=0;i<argument_types.size();++i) {                
                Argument emfArgument = SmmFactory.eINSTANCE.createArgument();
                emfArgument.setType(argument_types.get(i));
                emfArgument.setValue(argument_values.get(i));
                newElement.getArguments().add(emfArgument);
            }
        }
        visitSmmElement(newElement, modelioElement);
        return newElement;
    }

    @objid ("127c90b8-ba7b-4a75-a9c7-b713530358c7")
    @Override
    public Object visitObservedMeasure(ModelElement element, Object data) throws Exception {
        Observation parent = (Observation) data;
        ObservedMeasure newElement = SmmFactory.eINSTANCE.createObservedMeasure();
        parent.getObservedMeasures().add(newElement);
        measure.smm.api.observations.package_.ObservedMeasure modelioElement = measure.smm.api.observations.package_.ObservedMeasure.instantiate((Package) element);
        
        List<String> argument_types = modelioElement.getElement().getTagValues(ISMMPeerModule.MODULE_NAME, measure.smm.api.observations.package_.ObservedMeasure.ARGUMENT_TYPES_TAGTYPE);        
        List<String> argument_values = modelioElement.getElement().getTagValues(ISMMPeerModule.MODULE_NAME, measure.smm.api.observations.package_.ObservedMeasure.ARGUMENT_VALUES_TAGTYPE);        
        if (argument_types != null && argument_values != null) { // Validation
            for(int i=0;i<argument_types.size();++i) {                
                Argument emfArgument = SmmFactory.eINSTANCE.createArgument();
                emfArgument.setType(argument_types.get(i));
                emfArgument.setValue(argument_values.get(i));
                newElement.getArguments().add(emfArgument);
            }
        }
        visitSmmElement(newElement, modelioElement);
        return newElement;
    }

    @objid ("71516bf0-9a9b-4420-bbae-891a8f6631cc")
    private void visitMeasure(Measure emfElement, measure.smm.api.measures.class_.Measure modelioElement) {
        emfElement.setMeasureLabelFormat(modelioElement.getMeasureLabelFormat());
        emfElement.setMeasurementLabelFormat(modelioElement.getMeasurementLabelFormat());
        
        if (modelioElement.getVisible()==null || modelioElement.getVisible().isEmpty()) emfElement.setVisible(true); // Validate
        else emfElement.setVisible(new Boolean(modelioElement.getVisible()));            
        
        emfElement.setSource(modelioElement.getSource());
        emfElement.setCustomScale(modelioElement.getCustom_scale());
        
        if ("nominal".equals(modelioElement.getScale())) { // Validate
            emfElement.setScale(ScaleOfMeasurement.NOMINAL);
        } else if ("ordinal".equals(modelioElement.getScale())) {
            emfElement.setScale(ScaleOfMeasurement.ORDINAL);
        } else if ("interval".equals(modelioElement.getScale())) {
            emfElement.setScale(ScaleOfMeasurement.INTERVAL);
        } else if ("ratio".equals(modelioElement.getScale())) {
            emfElement.setScale(ScaleOfMeasurement.RATIO);
        } else if ("custom".equals(modelioElement.getScale())) {
            emfElement.setScale(ScaleOfMeasurement.CUSTOM);
        }
        
        Operation op = createOperation(modelioElement, modelioElement.DEFAULTQUERY_BODY_TAGTYPE, modelioElement.getDefaultQuery_body(),  modelioElement.getDefaultQuery_language());
        if (op != null) {
            currentMeasureLibrary.getMeasureElements().add(op);
        }
    }

    @objid ("5c49deb1-de9b-48aa-a58f-733a7cd4d142")
    private void visitMeasurement(Measurement emfElement, measure.smm.api.measurements.class_.Measurement modelioElement) {
        emfElement.setBreakValue(modelioElement.getBreakValue());
        emfElement.setError(modelioElement.getError());
        for (Dependency d : modelioElement.getElement().getDependsOnDependency()) {
            if (d.isStereotyped(ISMMPeerModule.MODULE_NAME, Measurand.STEREOTYPE_NAME)) {
               ModelElement target = d.getDependsOn();
               emfElement.setMeasurand(target.getName());
               
               // Validation: there should be only one
               break;
            } 
        }
        visitSmmElement(emfElement, modelioElement); // XXX avoid this repetition of super classes, this will cause lots of bugs
    }

    @objid ("9304e877-e207-4363-b0b2-4c42a6738208")
    private boolean isEmpty(String s) {
        return s==null || s.trim().isEmpty();
    }

    @objid ("bdad1ebf-e946-4300-9d5d-6c3c92cc4116")
    private Operation createOperation(String id, String body, String language) {
        if (isEmpty(language)) return null;
        else {
            Operation op = SmmFactory.eINSTANCE.createOperation();
            op.setBody(body);
            op.setLanguage(language);
            objects.put(id, op);
            return op;
        }
    }

    @objid ("7a5d2762-8a2e-496c-b9bc-fda68347ebd5")
    @Override
    public Object visitObservationScope(ModelElement element, Object data) throws Exception {
        Observation emfElement = (Observation) data;
        measure.smm.api.observations.package_.Observation modelioElement = measure.smm.api.observations.package_.Observation.instantiate((Package) element) ;
        
        List<String> scopes = modelioElement.getElement().getTagValues(ISMMPeerModule.MODULE_NAME, measure.smm.api.observations.package_.Observation.OBSERVATIONSCOPE_TAGTYPE);
        if (scopes != null) {
            for (String scope : scopes) {
                ObservationScope emfScope = SmmFactory.eINSTANCE.createObservationScope();
                emfScope.setScopeUri(scope);
                emfElement.getScopes().add(emfScope);
            }
        }
        return emfElement;
    }

    @objid ("8cd94221-fbc0-4658-824a-392c32d5effd")
    private void visitDimensionalMeasure(DimensionalMeasure emfElement, measure.smm.api.measures.class_.DimensionalMeasure modelioElement) {
        emfElement.setFormula(modelioElement.getFormula());
    }

    @objid ("2aec3463-a580-49a8-95a0-ef4efff5ee33")
    private void visitDimensionalMeasurement(DimensionalMeasurement emfElement, measure.smm.api.measurements.class_.DimensionalMeasurement modelioElement) {
        try {
            emfElement.setValue(new Double(modelioElement.getDimensionalMeasurement_value()));
        } catch (Exception e) {
            // e.printStackTrace(); // Validate
        }
    }

    @objid ("b6bed92a-d9fa-48f3-ac13-d1db0fe8b9f4")
    private Object visitMeasureRelationship(MeasureRelationship emfElement, measure.smm.api.measures.dependency.MeasureRelationship modelioElement, Measure parent) throws Exception {
        parent.getMeasureRelationships().add(emfElement);
        visitSmmRelationship(emfElement, modelioElement);
        
        if ("Positive".equals(modelioElement.getInfluence())) {  // Validate
            emfElement.setInfluence(Influence.POSITIVE);            
        } else if ("Negative".equals(modelioElement.getInfluence())) {
            emfElement.setInfluence(Influence.NEGATIVE);            
        }
        
        Operation op = createOperation(modelioElement, modelioElement.MEASURANTQUERY_BODY_TAGTYPE, modelioElement.getMeasurantQuery_body(),  modelioElement.getMeasurantQuery_language());
        if (op != null) {
            currentMeasureLibrary.getMeasureElements().add(op);
        }
        return emfElement;
    }

    @objid ("77e27203-bcb5-4de9-8bfe-6010efd5c35b")
    private Object visitMeasurementRelationship(MeasurementRelationship emfElement, measure.smm.api.measurements.dependency.MeasurementRelationship modelioElement, Measurement parent) throws Exception {
        parent.getMeasurementRelationships().add(emfElement);
        visitSmmRelationship(emfElement, modelioElement);
        return emfElement;
    }

    @objid ("f2cddc56-26a0-45cb-b037-2bd0ba8089a5")
    private void addOperationToLibratyFor(ObservedMeasure observedMeasure, Operation operation) throws Exception {
        MeasureLibrary parent = currentMeasureLibrary;
        parent.getMeasureElements().add(operation);
    }

    @objid ("81f3ba8e-d2dd-4df8-a307-d71af6790256")
    private Operation createOperation(measure.smm.api.core.modelelement.SmmElement element, String operationBodyTag, String body, String language) {
        return createOperation(element.getElement().getUuid().toString()+"_"+operationBodyTag, body, language);
    }

    @objid ("f07751f5-ef0e-4d71-bc9c-705a9deb8837")
    private Operation createOperation(ModelElement element, String operationBodyTag, String body, String language) {
        return createOperation(element.getUuid().toString()+"_"+operationBodyTag, body, language);
    }

    /**
     * This class keeps a map ModelioUUID -> EMF SMM element. It can be used when in a series of visitors, one needs to access elements created by this one.
     * @param modelioId @return
     */
    @objid ("f8fc07f4-8ba4-4caf-9072-bcf5eb6413ea")
    public EObject getEObject(String modelioId) {
        return objects.get(modelioId);
    }

    @objid ("52cd726f-7915-4903-9799-68966ee29202")
    @Override
    public Object visitOCLOperation(ModelElement element, Object data) throws Exception {
        MeasureLibrary parent = currentMeasureLibrary;
        measure.smm.api.measures.class_.OCLOperation modelioElement = measure.smm.api.measures.class_.OCLOperation.instantiate((Class) element);
        eu.measure.smm.OCLOperation emfElement = SmmFactory.eINSTANCE.createOCLOperation();
        parent.getMeasureElements().add(emfElement);
        emfElement.setBody(modelioElement.getBody());
        emfElement.setContext(modelioElement.getBody());
        visitSmmElement(emfElement, modelioElement);
        return emfElement;
    }

}
