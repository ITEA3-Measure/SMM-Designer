package measure.smm.visitor.export;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import eu.measure.smm.Measure;
import eu.measure.smm.MeasureCategory;
import eu.measure.smm.MeasureRelationship;
import eu.measure.smm.Measurement;
import eu.measure.smm.MeasurementRelationship;
import eu.measure.smm.Observation;
import measure.smm.api.ISMMPeerModule;
import measure.smm.api.collectivemeasurements.class_.BinaryMeasurement;
import measure.smm.api.collectivemeasurements.class_.CollectiveMeasurement;
import measure.smm.api.collectivemeasurements.class_.CountingMeasurement;
import measure.smm.api.collectivemeasurements.class_.DirectMeasurement;
import measure.smm.api.collectivemeasurements.class_.RatioMeasurement;
import measure.smm.api.collectivemeasures.class_.BinaryMeasure;
import measure.smm.api.collectivemeasures.class_.CollectiveMeasure;
import measure.smm.api.collectivemeasures.class_.CountingMeasure;
import measure.smm.api.collectivemeasures.class_.DirectMeasure;
import measure.smm.api.collectivemeasures.class_.RatioMeasure;
import measure.smm.api.collectivemeasures.dependency.Base1MeasureRelationship;
import measure.smm.api.collectivemeasures.dependency.Base2MeasureRelationship;
import measure.smm.api.collectivemeasures.dependency.BaseNMeasureRelationship;
import measure.smm.api.core.package_.MeasureLibrary;
import measure.smm.api.measurements.class_.GradeMeasurement;
import measure.smm.api.measurements.class_.RankingMeasurement;
import measure.smm.api.measures.class_.GradeMeasure;
import measure.smm.api.measures.class_.OCLOperation;
import measure.smm.api.measures.class_.RankingMeasure;
import measure.smm.api.measures.class_.ScopeElement;
import measure.smm.api.measures.class_.UnitOfMeasure;
import measure.smm.api.measures.dependency.EquivalentMeasureRelationship;
import measure.smm.api.measures.dependency.GradeMeasureRelationship;
import measure.smm.api.measures.dependency.RankingMeasureRelationship;
import measure.smm.api.measures.dependency.RefinementMeasureRelationship;
import measure.smm.api.measures.dependency.ScopeLink;
import measure.smm.api.namedandrescaledmeasurements.class_.NamedMeasurement;
import measure.smm.api.namedandrescaledmeasurements.class_.RescaledMeasurement;
import measure.smm.api.othermeasures.class_.NamedMeasure;
import measure.smm.api.othermeasures.class_.RescaledMeasure;
import measure.smm.api.othermeasures.dependency.RescaledMeasureRelationship;
import org.modelio.metamodel.uml.infrastructure.Dependency;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.ModelTree;

/**
 * Performs a pre-order visit on the model, takes a visitor and passes the parent of every element as <pre>data</pre> parameter.
 * The output of each <pre>visit</pre> is passed as <pre>data</pre> to the subsequent calls at each level, the semantics of this object is up to the visitors.
 */
@objid ("64da0e50-1309-4953-bef0-8df264770a6f")
public class SMMModelGeneratorNavigator {
    @objid ("653122b9-6c9a-4201-bcad-597948eb22ba")
    public Object acceptSmmModel(ModelElement smmModel, SMMModelVisitor visitor) throws Exception {
        Object output = visitor.visitSmmModel(smmModel, null);
        for(ModelTree child : ((org.modelio.metamodel.uml.statik.Package)smmModel).getOwnedElement()) {
            if (child.isStereotyped(ISMMPeerModule.MODULE_NAME, MeasureLibrary.STEREOTYPE_NAME)) {
                acceptMeasureLibrary(child, visitor, output);
            } else if (child.isStereotyped(ISMMPeerModule.MODULE_NAME, measure.smm.api.observations.package_.Observation.STEREOTYPE_NAME)) {
                acceptObservation(child, visitor, output);                
            }
        }
        return output;
    }

    @objid ("80225cdf-b11d-4e55-9c60-3be9cf79c86b")
    private Object acceptObservation(ModelElement element, SMMModelVisitor visitor, Object data) throws Exception {
        Object output = visitor.visitObservation(element, data);
        acceptObservationScope(element, visitor, output);
        for(ModelTree child : ((org.modelio.metamodel.uml.statik.Package)element).getOwnedElement()) {
            acceptObservedMeasure(child, visitor, output);
        }
        return output;
    }

    @objid ("eafe3680-e3cf-4136-a57d-36b9d0efb99b")
    private Object acceptMeasureLibrary(ModelElement element, SMMModelVisitor visitor, Object data) throws Exception {
        Object output = visitor.visitMeasureLibrary(element, data);
        
        for(ModelTree child : ((org.modelio.metamodel.uml.statik.Package)element).getOwnedElement()) {
            if (child.isStereotyped(ISMMPeerModule.MODULE_NAME, UnitOfMeasure.STEREOTYPE_NAME)) {
                acceptUnitOfMeasure(child, visitor, output);
            } else if (child.isStereotyped(ISMMPeerModule.MODULE_NAME, measure.smm.api.core.package_.MeasureCategory.STEREOTYPE_NAME)) {
                acceptMeasureCategory(child, visitor, output);                
            } else if (child.isStereotyped(ISMMPeerModule.MODULE_NAME, ScopeElement.STEREOTYPE_NAME)) {
                acceptScope(child, visitor, output);                
            } else if (child.isStereotyped(ISMMPeerModule.MODULE_NAME, measure.smm.api.measures.class_.Characteristic.STEREOTYPE_NAME)) {
                acceptCharacteristic(child, visitor, output);                
            } else if (child.isStereotyped(ISMMPeerModule.MODULE_NAME, OCLOperation.STEREOTYPE_NAME)) {
                acceptOCLOperation(child, visitor, output);                
            } else {
                acceptMeasure(child, visitor, output);                
            }
        }
        
        element.getDependsOnDependency()
            .stream()
            .filter(d -> d.isStereotyped(
                            ISMMPeerModule.MODULE_NAME,
                            measure.smm.api.core.dependency.CategoryRelationship.STEREOTYPE_NAME))
            .forEach(d -> wrapAcceptCategoryRelationship(d, visitor, output));
        return output;
    }

    @objid ("29ee5ae1-1de8-40c5-a4c2-def218c4919e")
    private Object acceptMeasureCategory(ModelElement element, SMMModelVisitor visitor, Object data) throws Exception {
        Object output = visitor.visitMeasureCategory(element, data);
        
        // OPEN This only works if measures appear only in one category at a time! On the spec, MeasureCategories work more as tags than as packages!
        // Pg 12 of spec: "A measure may appear in multiple categories. A category can be a subcategory of other categories indicating only that its
        // measures also are measures of these other categories."
        for(ModelTree child : ((org.modelio.metamodel.uml.statik.Package)element).getOwnedElement()) {
            if (child.isStereotyped(ISMMPeerModule.MODULE_NAME, measure.smm.api.core.package_.MeasureCategory.STEREOTYPE_NAME)) {
                acceptMeasureCategory(child, visitor, output);
            } else {
                acceptMeasure(child, visitor, output);                
            }
        }
        
        element.getDependsOnDependency()
            .stream()
            .filter(d -> d.isStereotyped(
                            ISMMPeerModule.MODULE_NAME,
                            measure.smm.api.core.dependency.CategoryRelationship.STEREOTYPE_NAME))
            .forEach(d -> wrapAcceptCategoryRelationship(d, visitor, output));
        return output;
    }

    @objid ("40f93bd9-1d49-46ef-b7f1-758c6e985f3a")
    private Object acceptMeasure(ModelElement element, SMMModelVisitor visitor, Object data) throws Exception {
        Measure measure = null;
        boolean foundKind = true;
        
        if (element.isStereotyped(ISMMPeerModule.MODULE_NAME,
                NamedMeasure.STEREOTYPE_NAME)) {
            measure = (Measure) visitor.visitNamedMeasure(element, data);
        } else
        
        if (element.isStereotyped(ISMMPeerModule.MODULE_NAME,
                RescaledMeasure.STEREOTYPE_NAME)) {
            measure = (Measure) visitor.visitRescaledMeasure(element, data);
        } else
        
        if (element.isStereotyped(ISMMPeerModule.MODULE_NAME,
                GradeMeasure.STEREOTYPE_NAME)) {
            measure = (Measure) visitor.visitGradeMeasure(element, data);
            for(ModelTree sub : ((ModelTree)element).getOwnedElement()) {
                acceptGradeInterval(sub, visitor, measure);
            }
        } else
        
        if (element.isStereotyped(ISMMPeerModule.MODULE_NAME,
                RankingMeasure.STEREOTYPE_NAME)) {
            measure = (Measure) visitor.visitRankingMeasure(element, data);
            for(ModelTree sub : ((ModelTree)element).getOwnedElement()) {
                acceptRakingInterval(sub, visitor, measure);
            }
        } else
        
        if (element.isStereotyped(ISMMPeerModule.MODULE_NAME,
                CollectiveMeasure.STEREOTYPE_NAME)) {
            measure = (Measure) visitor.visitCollectiveMeasure(element, data);
        } else
        
        if (element.isStereotyped(ISMMPeerModule.MODULE_NAME,
                DirectMeasure.STEREOTYPE_NAME)) {
            measure = (Measure) visitor.visitDirectMeasure(element, data);
        } else
        
        if (element.isStereotyped(ISMMPeerModule.MODULE_NAME,
                CountingMeasure.STEREOTYPE_NAME)) {
            measure = (Measure) visitor.visitCountingMeasure(element, data);
        } else
        
        
        if (element.isStereotyped(ISMMPeerModule.MODULE_NAME,
                RatioMeasure.STEREOTYPE_NAME)) {
            measure = (Measure) visitor.visitRatioMeasure(element, data);
        } else
        
        if (element.isStereotyped(ISMMPeerModule.MODULE_NAME,
                BinaryMeasure.STEREOTYPE_NAME)) {
            measure = (Measure) visitor.visitBinaryMeasure(element, data);
        } else
        
        {
            foundKind = false;
        }
        
        if (foundKind) {
            for (Dependency d : element.getDependsOnDependency()) {
                if (d.isStereotyped(ISMMPeerModule.MODULE_NAME, ScopeLink.STEREOTYPE_NAME)) {
                    acceptScope(d, visitor, data);
                } else {                    
                    acceptMeasureRelationship(d, visitor, measure);                    
                }
            }            
        }
        return measure;
    }

    @objid ("4b0ccf4f-942b-4a0f-82aa-5c9d97dbe976")
    private Object acceptUnitOfMeasure(ModelElement element, SMMModelVisitor visitor, Object data) throws Exception {
        return visitor.visitUnitOfMeasure(element, data);
    }

// can't use methods that throw checked exceptions on streams :s
    @objid ("7c6786f6-fee8-4bed-8964-214422fe9d9b")
    private Object wrapAcceptCategoryRelationship(ModelElement element, SMMModelVisitor visitor, Object data) {
        try {
            return acceptCategoryRelationship(element, visitor, data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @objid ("ccfb643a-bf34-43e7-8475-809a5414df68")
    private Object acceptCategoryRelationship(ModelElement element, SMMModelVisitor visitor, Object data) throws Exception {
        return visitor.visitCategoryRelationship(element, data);
    }

    @objid ("39815b0b-e735-43d3-9120-35ccfb0a6223")
    private Object acceptObservedMeasure(ModelElement element, SMMModelVisitor visitor, Object data) throws Exception {
        Object output = visitor.visitObservedMeasure(element, data);
        
        for(ModelTree child : ((org.modelio.metamodel.uml.statik.Package)element).getOwnedElement()) {
            acceptMeasurement(child, visitor, output);                
        }
        return output;
    }

    @objid ("59ed604a-abd3-4aea-9090-09ef5ea75ea7")
    private Object acceptScope(ModelElement element, SMMModelVisitor visitor, Object data) throws Exception {
        return visitor.visitScope(element, data);
    }

    @objid ("c7a018e5-9aa1-4c26-a441-22a279729f3e")
    private Object acceptMeasurement(ModelElement element, SMMModelVisitor visitor, Object data) throws Exception {
        Measurement measurement = null;
        boolean foundKind = true;
        if (element.isStereotyped(ISMMPeerModule.MODULE_NAME,
                RankingMeasurement.STEREOTYPE_NAME)) {
            measurement = (Measurement) visitor.visitRankingMeasurement(
                    element, data);
        } else
        
        if (element.isStereotyped(ISMMPeerModule.MODULE_NAME,
                CollectiveMeasurement.STEREOTYPE_NAME)) {
            measurement = (Measurement) visitor.visitCollectiveMeasurement(
                    element, data);
        } else
        if (element.isStereotyped(ISMMPeerModule.MODULE_NAME,
                    CountingMeasurement.STEREOTYPE_NAME)) {
             measurement = (Measurement) visitor.visitCountingMeasurement(
                        element, data);
        } else        
        if (element.isStereotyped(ISMMPeerModule.MODULE_NAME,
                DirectMeasurement.STEREOTYPE_NAME)) {
            measurement = (Measurement) visitor.visitDirectMeasurement(element,
                    data);
        } else
        if (element.isStereotyped(ISMMPeerModule.MODULE_NAME,
                RatioMeasurement.STEREOTYPE_NAME)) {
            measurement = (Measurement) visitor.visitRatioMeasurement(element,
                    data);
        } else
        
        if (element.isStereotyped(ISMMPeerModule.MODULE_NAME,
                BinaryMeasurement.STEREOTYPE_NAME)) {
            measurement = (Measurement) visitor.visitBinaryMeasurement(element,
                    data);
        } else
        
        if (element.isStereotyped(ISMMPeerModule.MODULE_NAME,
                GradeMeasurement.STEREOTYPE_NAME)) {
            measurement = (Measurement) visitor.visitGradeMeasurement(element,
                    data);
        } else
        
        if (element.isStereotyped(ISMMPeerModule.MODULE_NAME,
                NamedMeasurement.STEREOTYPE_NAME)) {
            measurement = (Measurement) visitor.visitNamedMeasurement(element,
                    data);
        } else
        
        if (element.isStereotyped(ISMMPeerModule.MODULE_NAME,
                RescaledMeasurement.STEREOTYPE_NAME)) {
            measurement = (Measurement) visitor.visitRescaledMeasurement(
                    element, data);
        } else
        
        {
            foundKind = false;;
        }
            
        if (foundKind) {
            for(Dependency d : element.getDependsOnDependency()) {
                acceptMeasurementRelationship(d, visitor, measurement);
            }
        }
        return measurement;
    }

    @objid ("67e1a92e-bc0f-47ad-9065-3644caf14960")
    private Object acceptCharacteristic(ModelElement element, SMMModelVisitor visitor, Object data) throws Exception {
        return visitor.visitCharacteristic(element, data);
    }

    @objid ("c41f2866-9999-4495-a910-8a386a2d912a")
    private Object acceptObservationScope(ModelElement element, SMMModelVisitor visitor, Object data) throws Exception {
        return visitor.visitObservationScope(element, data);
    }

    @objid ("de3ef415-1a18-4a4f-b9c2-bc115740bc90")
    private Object acceptMeasureRelationship(Dependency dependency, SMMModelVisitor visitor, Measure measure) throws Exception {
        MeasureRelationship relationship = null;
        
        if (dependency.isStereotyped(ISMMPeerModule.MODULE_NAME,
                EquivalentMeasureRelationship.STEREOTYPE_NAME)) {
            relationship = (MeasureRelationship) visitor
                    .visitEquivalentMeasureRelationship(dependency, measure);
        } else
        
        if (dependency.isStereotyped(ISMMPeerModule.MODULE_NAME,
                RefinementMeasureRelationship.STEREOTYPE_NAME)) {
            relationship = (MeasureRelationship) visitor
                    .visitRefinementMeasureRelationship(dependency, measure);
        } else
        
        if (dependency.isStereotyped(ISMMPeerModule.MODULE_NAME,
                GradeMeasureRelationship.STEREOTYPE_NAME)) {
            relationship = (MeasureRelationship) visitor
                    .visitGradeMeasureRelationship(dependency, measure);
        } else
        
        if (dependency.isStereotyped(ISMMPeerModule.MODULE_NAME,
                RankingMeasureRelationship.STEREOTYPE_NAME)) {
            relationship = (MeasureRelationship) visitor
                    .visitRankingMeasureRelationship(dependency, measure);
        } else
        
        if (dependency.isStereotyped(ISMMPeerModule.MODULE_NAME,
                BaseNMeasureRelationship.STEREOTYPE_NAME)) {
            relationship = (MeasureRelationship) visitor
                    .visitBaseNMeasureRelationship(dependency, measure);
        } else
        
        if (dependency.isStereotyped(ISMMPeerModule.MODULE_NAME,
                Base1MeasureRelationship.STEREOTYPE_NAME)) {
            relationship = (MeasureRelationship) visitor
                    .visitBase1MeasureRelationship(dependency, measure);
        } else
        
        if (dependency.isStereotyped(ISMMPeerModule.MODULE_NAME,
                Base2MeasureRelationship.STEREOTYPE_NAME)) {
            
            relationship = (MeasureRelationship) visitor
                    .visitBase2MeasureRelationship(dependency, measure);
        } else
        
        if (dependency.isStereotyped(ISMMPeerModule.MODULE_NAME,
                RescaledMeasureRelationship.STEREOTYPE_NAME)) {
            relationship = (MeasureRelationship) visitor
                    .visitRescaledMeasureRelationship(dependency, measure);
        }
        return relationship;
    }

    @objid ("b6276c75-3a2b-4afc-986f-de17eed5256b")
    private Object acceptMeasurementRelationship(Dependency dependency, SMMModelVisitor visitor, Measurement measurement) throws Exception {
        MeasurementRelationship relationship = null;
        
        if (dependency.isStereotyped(ISMMPeerModule.MODULE_NAME,measure.smm.api.measurements.dependency.EquivalentMeasurementRelationship.STEREOTYPE_NAME)) {
            relationship = (MeasurementRelationship)visitor.visitEquivalentMeasurementRelationship(dependency, measurement);            
        } else 
        
        if (dependency.isStereotyped(ISMMPeerModule.MODULE_NAME,measure.smm.api.measurements.dependency.RefinementMeasurementRelationship.STEREOTYPE_NAME)) {
            relationship = (MeasurementRelationship)visitor.visitRefinementMeasurementRelationship(dependency, measurement);            
        } else 
        
        if (dependency.isStereotyped(ISMMPeerModule.MODULE_NAME,measure.smm.api.measurements.dependency.GradeMeasurementRelationship.STEREOTYPE_NAME)) {
            relationship = (MeasurementRelationship)visitor.visitGradeMeasurementRelationship(dependency, measurement);            
        } else 
        
        if (dependency.isStereotyped(ISMMPeerModule.MODULE_NAME,measure.smm.api.measurements.dependency.RankingMeasureementRelationship.STEREOTYPE_NAME)) {
            relationship = (MeasurementRelationship)visitor.visitRankingMeasurementRelationship(dependency, measurement);            
        } else 
        
        if (dependency.isStereotyped(ISMMPeerModule.MODULE_NAME,measure.smm.api.collectivemeasurements.dependency.BaseNMeasurementRelationship.STEREOTYPE_NAME)) {
            relationship = (MeasurementRelationship)visitor.visitBaseNMeasurementRelationship(dependency, measurement);            
        } else 
        
        if (dependency.isStereotyped(ISMMPeerModule.MODULE_NAME,measure.smm.api.collectivemeasurements.dependency.Base1MeasurementRelationship.STEREOTYPE_NAME)) {
            relationship = (MeasurementRelationship)visitor.visitBase1MeasurementRelationship(dependency, measurement);            
        } else 
        
        if (dependency.isStereotyped(ISMMPeerModule.MODULE_NAME,measure.smm.api.collectivemeasurements.dependency.Base2MeasurementRelationship.STEREOTYPE_NAME)) {
            relationship = (MeasurementRelationship)visitor.visitBase2MeasurementRelationship(dependency, measurement);            
        } else 
        
        if (dependency.isStereotyped(ISMMPeerModule.MODULE_NAME,measure.smm.api.namedandrescaledmeasurements.dependency.RescaledMeasurementRelationship.STEREOTYPE_NAME)) {
            relationship = (MeasurementRelationship)visitor.visitRescaledMeasurementRelationship(dependency, measurement);            
        }
        return relationship;
    }

    @objid ("0a20b6d5-d16f-4ec2-93da-bb66e4d2b139")
    private Object acceptRakingInterval(ModelTree element, SMMModelVisitor visitor, Object data) throws Exception {
        return visitor.visitRankingInterval(element, data);
    }

    @objid ("b0614c42-cdb7-4889-a9d8-645f9cae89ba")
    private Object acceptGradeInterval(ModelElement element, SMMModelVisitor visitor, Object data) throws Exception {
        return visitor.visitGradeInterval(element, data);
    }

    @objid ("451edd6d-1729-48c0-b125-f345702c4ed6")
    private void acceptOCLOperation(ModelTree child, SMMModelVisitor visitor, Object output) throws Exception {
        visitor.visitOCLOperation(child, output);
    }

}
