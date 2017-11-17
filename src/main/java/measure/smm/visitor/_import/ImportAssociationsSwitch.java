package measure.smm.visitor._import;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import eu.measure.smm.AbstractMeasureElement;
import eu.measure.smm.Annotation;
import eu.measure.smm.Argument;
import eu.measure.smm.Attribute;
import eu.measure.smm.Base1MeasureRelationship;
import eu.measure.smm.Base1MeasurementRelationship;
import eu.measure.smm.Base2MeasureRelationship;
import eu.measure.smm.Base2MeasurementRelationship;
import eu.measure.smm.BaseMeasureRelationship;
import eu.measure.smm.BaseMeasurementRelationship;
import eu.measure.smm.BaseNMeasureRelationship;
import eu.measure.smm.BaseNMeasurementRelationship;
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
import eu.measure.smm.EquivalentMeasureRelationship;
import eu.measure.smm.EquivalentMeasurementRelationship;
import eu.measure.smm.GradeInterval;
import eu.measure.smm.GradeMeasure;
import eu.measure.smm.GradeMeasureRelationship;
import eu.measure.smm.GradeMeasurement;
import eu.measure.smm.GradeMeasurementRelationship;
import eu.measure.smm.Interval;
import eu.measure.smm.Measure;
import eu.measure.smm.MeasureCategory;
import eu.measure.smm.MeasureLibrary;
import eu.measure.smm.MeasureRelationship;
import eu.measure.smm.Measurement;
import eu.measure.smm.MeasurementRelationship;
import eu.measure.smm.NamedMeasure;
import eu.measure.smm.NamedMeasurement;
import eu.measure.smm.OCLOperation;
import eu.measure.smm.Observation;
import eu.measure.smm.ObservationScope;
import eu.measure.smm.ObservedMeasure;
import eu.measure.smm.Operation;
import eu.measure.smm.RankingInterval;
import eu.measure.smm.RankingMeasure;
import eu.measure.smm.RankingMeasureRelationship;
import eu.measure.smm.RankingMeasurement;
import eu.measure.smm.RankingMeasurementRelationship;
import eu.measure.smm.RatioMeasure;
import eu.measure.smm.RatioMeasurement;
import eu.measure.smm.RefinementMeasureRelationship;
import eu.measure.smm.RefinementMeasurementRelationship;
import eu.measure.smm.RescaledMeasure;
import eu.measure.smm.RescaledMeasureRelationship;
import eu.measure.smm.RescaledMeasurement;
import eu.measure.smm.RescaledMeasurementRelationship;
import eu.measure.smm.Scope;
import eu.measure.smm.SmmElement;
import eu.measure.smm.SmmModel;
import eu.measure.smm.SmmRelationship;
import eu.measure.smm.UnitOfMeasure;
import eu.measure.smm.util.SmmSwitch;
import measure.smm.api.measurements.dependency.Measurand;
import measure.smm.api.measurements.dependency.RankingMeasureementRelationship;
import measure.smm.api.measures.dependency.ScopeLink;
import measure.smm.api.measures.dependency.TraitLink;
import measure.smm.api.measures.dependency.UnitLink;
import measure.smm.api.observations.dependency.ObservedMeasureLink;
import measure.smm.api.observations.dependency.RequestedMeasureLink;
import measure.smm.api.othermeasures.dependency.Rescales;
import org.eclipse.emf.ecore.EObject;
import org.modelio.api.model.IUmlModel;
import org.modelio.metamodel.uml.infrastructure.Dependency;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.ModelTree;
import org.modelio.metamodel.uml.statik.Class;
import org.modelio.metamodel.uml.statik.Instance;
import org.modelio.metamodel.uml.statik.NameSpace;
import org.modelio.metamodel.uml.statik.Package;

/**
 * A EMF Switch calls the <pre>caseX</pre> methods bottom up in the hierarchy until one of them returns non-null.
 * Here the strategy is to reuse this behavior to make it call all <pre>caseX</pre> methods. So all methods in this class should return <pre>null</pre>!
 * 
 * Traverses a Modelio UML model, creating the associations in the EMF model
 * Needs to get an initialized <pre>ImportStructure</pre> as input
 * 
 * @author malmeida
 */
@objid ("30baaece-d475-40a5-933c-3343a9ddcfc3")
public class ImportAssociationsSwitch extends SmmSwitch<ModelElement> {
    @objid ("dc44cca0-5d53-4371-8ef7-88190df9353c")
    private ImportStructureSwitch importStructureSwitch;

    @objid ("fe68eb9f-2061-4c11-9aac-5bb4a8b478d1")
    private IUmlModel modellingFacade;

    /**
     * @param modellingFacade
     * @param importStructureSwitch an initialized ImportStructureSwitch (i.e. doSwitch has already been called for all elements in an EMF model
     */
    @objid ("d1b3aa29-a789-4840-b27e-8e6c946f5ef9")
    public ImportAssociationsSwitch(IUmlModel modellingFacade, ImportStructureSwitch importStructureSwitch) {
        this.importStructureSwitch = importStructureSwitch;
        this.modellingFacade = modellingFacade;
    }

    @objid ("980702bf-44da-4611-b1ee-6f6225aef99b")
    private ModelElement getModelioElement(EObject emfElement) {
        return ((measure.smm.api.core.modelelement.SmmElement)importStructureSwitch.getObjects().get(emfElement)).getElement();
    }

    @objid ("d6f5dc53-26d6-4aa5-8d1a-aa09d1483621")
    private void registerModelioElement(EObject emfElement, measure.smm.api.core.modelelement.SmmElement modelioElement) {
        importStructureSwitch.getObjects().put(emfElement, modelioElement);
    }

    @objid ("66d3d4aa-9fa2-4b95-a098-ce63b7e4e0e1")
    @Override
    public ModelElement caseAbstractMeasureElement(AbstractMeasureElement object) {
        return null;
    }

    @objid ("c7e8651d-a16d-4130-8894-7230533f2eec")
    @Override
    public ModelElement caseSmmElement(SmmElement object) {
        return null;
    }

    @objid ("cdbaaf61-fd8d-4771-a2ab-10d8fee85d42")
    @Override
    public ModelElement caseSmmRelationship(SmmRelationship object) {
        if (!(object instanceof CategoryRelationship)) {
            System.out.println(object.toString());
            ModelTree from = (ModelTree) getModelioElement(object.getFrom());
            ModelTree to = (ModelTree) getModelioElement(object.getTo());
            
            Dependency dep = (Dependency) (getModelioElement(object));
            dep.setDependsOn(to);
            dep.setImpacted(from);
            
            dep.setName(object.getName());            
        }
        return null;
    }

    @objid ("d7790f4c-398e-401a-9f89-1a94315291d3")
    @Override
    public ModelElement caseAttribute(Attribute object) {
        return null;
    }

    @objid ("9ff29c60-9f6c-4fbb-a7a5-0c8f45500baa")
    @Override
    public ModelElement caseAnnotation(Annotation object) {
        return null;
    }

    @objid ("730e66c6-6776-42f3-96e1-d4753cb32cbf")
    @Override
    public ModelElement caseArgument(Argument object) {
        return null;
    }

    @objid ("0a1eacd0-c17e-4429-a3ba-b639b8b72fd8")
    @Override
    public ModelElement caseObservedMeasure(ObservedMeasure object) {
        if (object.getMeasure()!=null) {
            try {
                measure.smm.api.observations.package_.ObservedMeasure modelioElement = measure.smm.api.observations.package_.ObservedMeasure.instantiate((Package) getModelioElement(object));
                ObservedMeasureLink dep = ObservedMeasureLink.create();
                dep.getElement().setImpacted(modelioElement.getElement());
                dep.getElement().setDependsOn(getModelioElement(object.getMeasure()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        return null;
    }

    @objid ("eb40888f-8d3d-4ef0-a3f5-754252416cdf")
    @Override
    public ModelElement caseMeasurement(Measurement object) {
        if (object.getMeasurand()!=null) {
            try {
                measure.smm.api.measurements.class_.Measurement modelioElement = measure.smm.api.measurements.class_.Measurement.instantiate((Class) getModelioElement(object));
                Package smmModel = (Package) modelioElement.getElement().getOwner().getOwner().getOwner();
                ModelElement measurand = null;
                for (Instance element : smmModel.getDeclared()) {
                    if (element.getName().equals(object.getMeasurand())) {
                        measurand = element;
                        break;
                    }
                }
                
                if (measurand == null) {
                    measurand = modellingFacade.createInstance(object.getMeasurand(), (Package) smmModel);            
                }
            
                Measurand dep = Measurand.create();
                dep.getElement().setDependsOn(measurand);
                dep.getElement().setImpacted(modelioElement.getElement());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @objid ("4700d9ac-62d1-4c7c-87c9-ef0391ba7526")
    @Override
    public ModelElement caseEquivalentMeasurementRelationship(EquivalentMeasurementRelationship object) {
        try {
            registerModelioElement(object, measure.smm.api.measurements.dependency.EquivalentMeasurementRelationship.create());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @objid ("8a4f0c13-dc30-4d12-95c6-ae1e8df2782d")
    @Override
    public ModelElement caseMeasurementRelationship(MeasurementRelationship object) {
        return null;
    }

    @objid ("cd391561-a723-4a16-8860-969fbef115ec")
    @Override
    public ModelElement caseRefinementMeasurementRelationship(RefinementMeasurementRelationship object) {
        try {
            registerModelioElement(object, measure.smm.api.measurements.dependency.RefinementMeasurementRelationship.create());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @objid ("28645394-3e91-4429-a52f-5be1cbed8bb5")
    @Override
    public ModelElement caseMeasure(Measure object) {
        measure.smm.api.measures.class_.Measure modelioElement;
        try {
            modelioElement = measure.smm.api.measures.class_.Measure.instantiate((Class) getModelioElement(object));
            if (object.getScope() != null) {
                ScopeLink dep = ScopeLink.create();
                dep.getElement().setImpacted(modelioElement.getElement());
                dep.getElement().setDependsOn(getModelioElement(object.getScope()));
            }
            if (object.getTrait() != null) {
                TraitLink dep = TraitLink.create();
                dep.getElement().setImpacted(modelioElement.getElement());
                dep.getElement().setDependsOn(getModelioElement(object.getTrait()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @objid ("ea643a9b-fc80-4ed6-b57a-17d48c5cedea")
    @Override
    public ModelElement caseRefinementMeasureRelationship(RefinementMeasureRelationship object) {
        try {
            registerModelioElement(object, measure.smm.api.measures.dependency.RefinementMeasureRelationship.create());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @objid ("31998c59-a4a8-42b3-b287-8177d1661bec")
    @Override
    public ModelElement caseMeasureRelationship(MeasureRelationship object) {
        try {
            Dependency dep = (Dependency) (getModelioElement(object));
            measure.smm.api.measures.dependency.MeasureRelationship modelioElement = measure.smm.api.measures.dependency.MeasureRelationship.instantiate(dep);
            if (object.getInfluence()!=null) modelioElement.setInfluence(object.getInfluence().getLiteral());
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @objid ("a3e4df76-3efe-4000-b502-411e32d4f6c6")
    @Override
    public ModelElement caseOperation(Operation object) {
        return null;
    }

    @objid ("b2d5be78-541c-48b4-95a2-54f484c4e54c")
    @Override
    public ModelElement caseEquivalentMeasureRelationship(EquivalentMeasureRelationship object) {
        try {
            registerModelioElement(object, measure.smm.api.measures.dependency.EquivalentMeasureRelationship.create());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @objid ("a4346a03-8418-4965-b9ad-ed7b4dce0ce5")
    @Override
    public ModelElement caseMeasureCategory(MeasureCategory object) {
        // OPEN see comment in SMMModelGeneratorNavigator.acceptMeasureCategory()
        ModelTree modelioElement = (ModelTree) getModelioElement(object);
        for(MeasureCategory category : object.getCategoryElement()) {
            modelioElement.getOwnedElement().add((ModelTree) getModelioElement(category));
        }
        
        for(Measure measure : object.getCategoryMeasure()) {
            modelioElement.getOwnedElement().add((ModelTree) getModelioElement(measure));
        }
        return null;
    }

    @objid ("a4758886-8421-4e74-92d9-591f12d01fc0")
    @Override
    public ModelElement caseScope(Scope object) {
        return null;
    }

    @objid ("b1955024-9597-4572-a7fa-7043fd0d2161")
    @Override
    public ModelElement caseCharacteristic(Characteristic object) {
        Characteristic from = object;
        Characteristic to   = object.getParent();
        if (to != null) {
            modellingFacade.createGeneralization((NameSpace)getModelioElement(from), (NameSpace)getModelioElement(to));
        }
        return null;
    }

    @objid ("c5e636cd-e74c-4a13-b81c-c38dfe7bad0c")
    @Override
    public ModelElement caseBase1MeasureRelationship(Base1MeasureRelationship object) {
        try  {
            registerModelioElement(object, measure.smm.api.collectivemeasures.dependency.Base1MeasureRelationship.create());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @objid ("cc67be15-b980-4082-81d7-7b15e048ebf4")
    @Override
    public ModelElement caseBaseMeasureRelationship(BaseMeasureRelationship object) {
        return null;
    }

    @objid ("1fc1e5fa-8986-4e6f-a79b-d08eb734ff2f")
    @Override
    public ModelElement caseRescaledMeasure(RescaledMeasure object) {
        BaseMeasureRelationship rescaled = object.getRescales();
        
        if (rescaled!=null) {
            try {
                Rescales dep = Rescales.create();
                dep.getElement().setDependsOn(getModelioElement(rescaled));
                dep.getElement().setImpacted(getModelioElement(object));
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @objid ("1339e094-6041-4842-8f50-e03d5d0e949c")
    @Override
    public ModelElement caseDimensionalMeasure(DimensionalMeasure object) {
        try {
            measure.smm.api.measures.class_.DimensionalMeasure modelioElement = measure.smm.api.measures.class_.DimensionalMeasure.instantiate((Class) getModelioElement(object));
            if (object.getUnit() != null) {
                UnitLink dep = UnitLink.create();
                dep.getElement().setImpacted(modelioElement.getElement());
                dep.getElement().setDependsOn(getModelioElement(object.getUnit()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @objid ("129c5f02-446e-4655-9555-2a8251f7f03a")
    @Override
    public ModelElement caseBaseNMeasureRelationship(BaseNMeasureRelationship object) {
        try {
            registerModelioElement(object, measure.smm.api.collectivemeasures.dependency.BaseNMeasureRelationship.create());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @objid ("93fa8572-411d-4ca5-b2bd-9b1a6e82061d")
    @Override
    public ModelElement caseCollectiveMeasure(CollectiveMeasure object) {
        return null;
    }

    @objid ("05801a98-131d-4711-be43-5e7cb74adb2e")
    @Override
    public ModelElement caseBase2MeasureRelationship(Base2MeasureRelationship object) {
        try {
            registerModelioElement(object, measure.smm.api.collectivemeasures.dependency.Base2MeasureRelationship.create());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @objid ("9d019aea-eaba-440e-be1e-9793eb1b8517")
    @Override
    public ModelElement caseBinaryMeasure(BinaryMeasure object) {
        return null;
    }

    @objid ("e0790a1d-8be6-4439-be3b-080550bbe0af")
    @Override
    public ModelElement caseRankingMeasureRelationship(RankingMeasureRelationship object) {
        try {
            registerModelioElement(object, measure.smm.api.measures.dependency.RankingMeasureRelationship.create());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @objid ("3e23ef88-8c48-43be-8323-45871fb716a3")
    @Override
    public ModelElement caseRankingMeasure(RankingMeasure object) {
        return null;
    }

    @objid ("9a9dfbfd-3bd7-4d7b-93ee-a3f6a145016c")
    @Override
    public ModelElement caseRankingInterval(RankingInterval object) {
        return null;
    }

    @objid ("d0d9f88d-7045-4291-b404-2d6de500f2b4")
    @Override
    public ModelElement caseInterval(Interval object) {
        return null;
    }

    @objid ("061fa6a8-992d-4606-b4d5-091027adf143")
    @Override
    public ModelElement caseRescaledMeasureRelationship(RescaledMeasureRelationship object) {
        try {
            registerModelioElement(object, measure.smm.api.othermeasures.dependency.RescaledMeasureRelationship.create());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @objid ("471900c8-1c26-4029-b278-df661faeaead")
    @Override
    public ModelElement caseGradeMeasureRelationship(GradeMeasureRelationship object) {
        try {
            registerModelioElement(object, measure.smm.api.measures.dependency.GradeMeasureRelationship.create());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @objid ("9ccae9ff-43d3-421b-aa2f-c9665a3fb140")
    @Override
    public ModelElement caseGradeMeasure(GradeMeasure object) {
        return null;
    }

    @objid ("4b3c5f36-15e8-42c5-bfa0-ab64933f5851")
    @Override
    public ModelElement caseGradeInterval(GradeInterval object) {
        return null;
    }

    @objid ("3c5362c5-9ee1-4fa7-874f-57808f044c0a")
    @Override
    public ModelElement caseUnitOfMeasure(UnitOfMeasure object) {
        return null;
    }

    @objid ("09c297f7-2504-4c40-a969-3a15c9593cd4")
    @Override
    public ModelElement caseBase1MeasurementRelationship(Base1MeasurementRelationship object) {
        try {
            registerModelioElement(object, measure.smm.api.collectivemeasurements.dependency.Base1MeasurementRelationship.create());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @objid ("e3df33e9-675b-4a37-b69e-3d9efb203ad9")
    @Override
    public ModelElement caseBaseMeasurementRelationship(BaseMeasurementRelationship object) {
        return null;
    }

    @objid ("0a0e8984-2cc7-41e9-aafb-07100c7219e9")
    @Override
    public ModelElement caseDimensionalMeasurement(DimensionalMeasurement object) {
        return null;
    }

    @objid ("0e44ef0c-a8f6-4fb1-8f10-0e77e8ca8677")
    @Override
    public ModelElement caseBaseNMeasurementRelationship(BaseNMeasurementRelationship object) {
        try {
            registerModelioElement(object, measure.smm.api.collectivemeasurements.dependency.BaseNMeasurementRelationship.create());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @objid ("819c1f57-6fa1-438e-9911-4640d3aac049")
    @Override
    public ModelElement caseCollectiveMeasurement(CollectiveMeasurement object) {
        return null;
    }

    @objid ("050d893b-28cc-4a88-8df9-1bbe0626b2ca")
    @Override
    public ModelElement caseBase2MeasurementRelationship(Base2MeasurementRelationship object) {
        try {
            registerModelioElement(object, measure.smm.api.collectivemeasurements.dependency.Base2MeasurementRelationship.create());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @objid ("238aef46-42cf-4ba3-b21b-c7fb21650647")
    @Override
    public ModelElement caseBinaryMeasurement(BinaryMeasurement object) {
        return null;
    }

    @objid ("df7b1bd6-4e6a-40df-bef3-c02fee3bc4f1")
    @Override
    public ModelElement caseGradeMeasurementRelationship(GradeMeasurementRelationship object) {
        try {
            registerModelioElement(object, measure.smm.api.measurements.dependency.GradeMeasurementRelationship.create());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @objid ("069821c1-ae54-4319-be6b-f1c021c73e24")
    @Override
    public ModelElement caseGradeMeasurement(GradeMeasurement object) {
        return null;
    }

    @objid ("51dbd8c5-d3fd-4135-9f7c-52571c2830bf")
    @Override
    public ModelElement caseRescaledMeasurementRelationship(RescaledMeasurementRelationship object) {
        try {
            registerModelioElement(object, measure.smm.api.namedandrescaledmeasurements.dependency.RescaledMeasurementRelationship.create());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @objid ("91bc2f4f-afea-4ee9-9384-9f196c73f078")
    @Override
    public ModelElement caseRescaledMeasurement(RescaledMeasurement object) {
        return null;
    }

    @objid ("4a26d8b0-4543-4b2e-8bac-c3dcc1404350")
    @Override
    public ModelElement caseRankingMeasurementRelationship(RankingMeasurementRelationship object) {
        try {
            registerModelioElement(object, RankingMeasureementRelationship.create());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @objid ("3524cc69-4e3d-44b0-9e50-92e0df3650f8")
    @Override
    public ModelElement caseRankingMeasurement(RankingMeasurement object) {
        return null;
    }

    @objid ("13940bd9-14d7-4004-97c8-477df49d1aac")
    @Override
    public ModelElement caseCategoryRelationship(CategoryRelationship object) {
        return null;
    }

    @objid ("3c29b667-5a77-4a62-aab2-1789b8ffa8c0")
    @Override
    public ModelElement caseCountingMeasurement(CountingMeasurement object) {
        return null;
    }

    @objid ("c8573bff-552f-4533-9e2b-c5eaa1f9bb0b")
    @Override
    public ModelElement caseDirectMeasurement(DirectMeasurement object) {
        return null;
    }

    @objid ("08d86ad1-542a-4403-9c20-a5984fbf3218")
    @Override
    public ModelElement caseCountingMeasure(CountingMeasure object) {
        return null;
    }

    @objid ("cdba9737-ca49-4f41-a58a-8d0fa0b6808e")
    @Override
    public ModelElement caseDirectMeasure(DirectMeasure object) {
        return null;
    }

    @objid ("7c5e26c0-f178-4cd8-8b62-31be3d564440")
    @Override
    public ModelElement caseMeasureLibrary(MeasureLibrary object) {
        try {
            measure.smm.api.core.package_.MeasureLibrary modelioElement = measure.smm.api.core.package_.MeasureLibrary.instantiate((Package) getModelioElement(object));
            for(CategoryRelationship categoryRelationship : object.getCategoryRelationships()) {
                ModelElement from = modelioElement.getElement();
                ModelElement to   = getModelioElement(categoryRelationship.getTo());
                
                measure.smm.api.core.dependency.CategoryRelationship modelioRelationship = measure.smm.api.core.dependency.CategoryRelationship.create();
                modelioRelationship.getElement().setImpacted(from);
                modelioRelationship.getElement().setDependsOn(to);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @objid ("1cf69d8b-a1ef-4d8a-987a-3c71be80516b")
    @Override
    public ModelElement caseNamedMeasure(NamedMeasure object) {
        return null;
    }

    @objid ("7fdb4390-7b37-4c3e-8291-0cca88010fb7")
    @Override
    public ModelElement caseNamedMeasurement(NamedMeasurement object) {
        return null;
    }

    @objid ("d5c33b9d-6380-410a-95f7-cc125bfd883f")
    @Override
    public ModelElement caseOCLOperation(OCLOperation object) {
        return null;
    }

    @objid ("3c166291-c22c-454c-be8a-d66168770eba")
    @Override
    public ModelElement caseObservation(Observation object) {
        measure.smm.api.observations.package_.Observation modelioElement;
        try {
            modelioElement = measure.smm.api.observations.package_.Observation.instantiate((Package) getModelioElement(object));
            for(AbstractMeasureElement measure : object.getRequestedMeasures()) {
                RequestedMeasureLink dep = RequestedMeasureLink.create();
                ModelElement target = getModelioElement(measure);
                dep.getElement().setDependsOn(target);
                dep.getElement().setImpacted(modelioElement.getElement());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @objid ("0601979d-9092-4caa-94d4-8d9f2426133d")
    @Override
    public ModelElement caseObservationScope(ObservationScope object) {
        return null;
    }

    @objid ("c41b8ed2-dfaa-4488-b9c2-0fe395af545e")
    @Override
    public ModelElement caseRatioMeasure(RatioMeasure object) {
        return null;
    }

    @objid ("f1d77fb3-76d4-4d59-bc00-ffc048dc4304")
    @Override
    public ModelElement caseRatioMeasurement(RatioMeasurement object) {
        return null;
    }

    @objid ("7db70ec7-91fe-4486-85e6-49380986e7b1")
    @Override
    public ModelElement caseSmmModel(SmmModel object) {
        return null;
    }

}
