package measure.smm.visitor._import;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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
import measure.smm.api.ISMMPeerModule;
import measure.smm.api.measures.class_.ScopeElement;
import org.eclipse.emf.ecore.EObject;
import org.modelio.api.model.IUmlModel;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.ModelTree;

/**
 * A EMF Switch calls the <pre>caseX</pre> methods bottom up in the hierarchy until one of them returns non-null.
 * Here the strategy is to reuse this behavior to make it call all <pre>caseX</pre> methods. So all methods in this class should return <pre>null</pre>!
 * 
 * There are three general patterns for <pre>caseX</pre> methods:
 * <li> for concrete (leaf) classes: create Modelio element, add it to objects, fill it's attributes/tag values</li>
 * <li> for concrete (intermediate) classes: see if Modelio element exists, if so, retrieves it otherwise creates it, then fills it's attributes
 * <li> for abstract classes: retrieve Modelio element (created by a concrete subclass), fill it's attributes/tag values</li>
 * 
 * This class is supposed to be used by a traversal algorithm that calls <pre>setCurrentParent</pre> before each <pre>doSwitch</pre>, so that <pre>caseX</pre> methods
 * know where they should add the newly created elements.
 */
@objid ("5725dd94-887c-4e11-bcfb-9ac7e3e0e235")
public class ImportStructureSwitch extends SmmSwitch<ModelElement> {
    @objid ("ff0bf32e-5218-4b42-a8ba-02f2301391b6")
    private Map<EObject, Object> objects = new HashMap<EObject, Object>();

    @objid ("140dae2f-7944-4d51-93ac-b4f228c817ec")
    private IUmlModel modellingFacade;

    @objid ("10d85c9a-0478-47af-ac66-e3e083b7e2e7")
    private ModelTree owner;

    @objid ("7422c2d4-8974-44f9-8af4-579d247e644b")
    private ModelTree currentParent;

    @objid ("2a8e9843-fe36-4e4d-b4b1-e67f667365f7")
    public Map<EObject, Object> getObjects() {
        return objects;
    }

    @objid ("80a1287a-4bdd-4956-83eb-567ccb5aedc1")
    public ModelTree getCurrentParent() {
        return currentParent;
    }

    @objid ("480c93d0-6a6e-45e3-9e4a-6121902f790f")
    public ImportStructureSwitch(IUmlModel modellingFacade, ModelTree owner) {
        this.modellingFacade = modellingFacade;
        this.owner = owner;
    }

    @objid ("497c335d-5938-4b7a-8806-fe792558931d")
    @Override
    public ModelElement caseSmmModel(SmmModel emfModel) {
        measure.smm.api.core.package_.SmmModel modelioModel = null;
        try {
            modelioModel = measure.smm.api.core.package_.SmmModel.create();
            objects.put(emfModel, modelioModel);
            owner.getOwnedElement().add(modelioModel.getElement());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @objid ("bcced675-6a0f-4c75-8b92-f6d81f786a88")
    @Override
    public ModelElement caseAbstractMeasureElement(AbstractMeasureElement object) {
        return null;
    }

    @objid ("1c74ae9c-c4e4-4946-9abc-4f98cc3586c4")
    @Override
    public ModelElement caseSmmElement(SmmElement object) {
        measure.smm.api.core.modelelement.SmmElement modelioElement = (measure.smm.api.core.modelelement.SmmElement) objects.get(object);
        if (modelioElement != null) {
            try {
                // Special case: Scope, we set a name there that shouldn't be overwritten here
                if (!(object instanceof Scope) && !(object.getName()==null)) {
                    modelioElement.getElement().setName(object.getName());
                }
                modelioElement.setDescription(object.getDescription());
                modelioElement.setShortDescription(object.getShortDescription());                            
                
                modelioElement
                        .getElement()
                        .putTagValues(
                                ISMMPeerModule.MODULE_NAME,
                                measure.smm.api.core.modelelement.SmmElement.EXTENSIONS_ATTRIBUTE_TAG_TAGTYPE,
                                object.getAttributes().stream()
                                        .map(Attribute::getTag)
                                        .map(s -> ""+s)
                                        .collect(Collectors.toList()));
                modelioElement
                        .getElement()
                        .putTagValues(
                                ISMMPeerModule.MODULE_NAME,
                                measure.smm.api.core.modelelement.SmmElement.EXTENSIONS_ATTRIBUTE_VALUE_TAGTYPE,
                                object.getAttributes().stream()
                                        .map(Attribute::getValue)
                                        .map(s -> ""+s)
                                        .collect(Collectors.toList()));
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @objid ("8c80faae-e3de-4bc8-8a2d-ea28680fba22")
    @Override
    public ModelElement caseSmmRelationship(SmmRelationship object) {
        return null;
    }

    @objid ("dc3c9332-0120-4591-9240-beacbec25fd1")
    @Override
    public ModelElement caseAttribute(Attribute object) {
        return null;
    }

    @objid ("8edcf18f-c993-4f67-a7ba-95f6ff8b3a47")
    @Override
    public ModelElement caseAnnotation(Annotation object) {
        return null;
    }

    @objid ("6e7d17ad-5c21-43ea-8502-0daa483b7316")
    @Override
    public ModelElement caseArgument(Argument object) {
        return null;
    }

    @objid ("938c5587-db87-46aa-aa4e-dc10ed65d584")
    @Override
    public ModelElement caseObservedMeasure(ObservedMeasure object) {
        measure.smm.api.observations.package_.ObservedMeasure modelioModel = null;
        try {
            modelioModel = measure.smm.api.observations.package_.ObservedMeasure.create();
            objects.put(object, modelioModel);
            currentParent.getOwnedElement().add(modelioModel.getElement());
            
            modelioModel
            .getElement()
            .putTagValues(
                    ISMMPeerModule.MODULE_NAME,
                    measure.smm.api.observations.package_.ObservedMeasure.ARGUMENT_TYPES_TAGTYPE,
                    object.getArguments().stream()
                            .map(Argument::getType)
                            .map(s -> ""+s)
                            .collect(Collectors.toList()));
            modelioModel
            .getElement()
            .putTagValues(
                    ISMMPeerModule.MODULE_NAME,
                    measure.smm.api.observations.package_.ObservedMeasure.ARGUMENT_VALUES_TAGTYPE,
                    object.getArguments().stream()
                            .map(Argument::getValue)
                            .map(s -> ""+s)
                            .collect(Collectors.toList()));
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @objid ("7576a602-08d1-45ca-a19a-7090dc5c8f58")
    @Override
    public ModelElement caseMeasurement(Measurement object) {
        measure.smm.api.measurements.class_.Measurement modelioElement = (measure.smm.api.measurements.class_.Measurement) objects.get(object);
        if (modelioElement != null) {
            try {
                modelioElement.setBreakValue(object.getBreakValue());
                modelioElement.setError(object.getError());
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @objid ("1867860a-79ed-4bf9-9d82-c541b360711f")
    @Override
    public ModelElement caseEquivalentMeasurementRelationship(EquivalentMeasurementRelationship object) {
        return null;
    }

    @objid ("ae169cbc-4b47-4ac2-ba6d-96c333fb7c9c")
    @Override
    public ModelElement caseMeasurementRelationship(MeasurementRelationship object) {
        return null;
    }

    @objid ("95feb920-3d80-429f-a7a9-0905c47d5319")
    @Override
    public ModelElement caseRefinementMeasurementRelationship(RefinementMeasurementRelationship object) {
        return null;
    }

    @objid ("cf09d1a6-2da8-4870-a215-ee137897476c")
    @Override
    public ModelElement caseMeasure(Measure object) {
        measure.smm.api.measures.class_.Measure modelioElement = (measure.smm.api.measures.class_.Measure) objects.get(object);
        if (modelioElement != null) {
            try {
                modelioElement.setMeasureLabelFormat(object.getMeasureLabelFormat());
                modelioElement.setMeasurementLabelFormat(object.getMeasurementLabelFormat());
                if (object.getVisible()!=null) modelioElement.setVisible(object.getVisible().toString());
                modelioElement.setSource(object.getSource());
                if (object.getScale()!=null) modelioElement.setScale(object.getScale().getLiteral());
                
                if (object.getDefaultQuery() != null) {
                    modelioElement.setDefaultQuery_body(object.getDefaultQuery().getBody());
                    modelioElement.setDefaultQuery_language(object.getDefaultQuery().getLanguage());
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @objid ("05119ce1-aa22-4ce0-8c5f-0091b281b53c")
    @Override
    public ModelElement caseRefinementMeasureRelationship(RefinementMeasureRelationship object) {
        return null;
    }

    @objid ("30b37bf7-3731-41c9-a9e0-1d5136893f72")
    @Override
    public ModelElement caseMeasureRelationship(MeasureRelationship object) {
        return null;
    }

    @objid ("3b67a71e-6caa-410e-9a02-64016a23c42b")
    @Override
    public ModelElement caseOperation(Operation object) {
        return null;
    }

    @objid ("cd57fe47-4f07-4f67-ba92-4fe95ffecefb")
    @Override
    public ModelElement caseEquivalentMeasureRelationship(EquivalentMeasureRelationship object) {
        return null;
    }

    @objid ("eaee4503-98c9-4266-a8e3-800b3fbaf51e")
    @Override
    public ModelElement caseMeasureCategory(MeasureCategory object) {
        measure.smm.api.core.package_.MeasureCategory modelioElement = null;
        try {
            modelioElement = measure.smm.api.core.package_.MeasureCategory.create();
            objects.put(object, modelioElement);
            currentParent.getOwnedElement().add(modelioElement.getElement());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @objid ("3558ebf0-710c-4323-a7bb-2bc41737d027")
    @Override
    public ModelElement caseScope(Scope object) {
        ScopeElement modelioElement = null;
        try {
            modelioElement = ScopeElement.create();
            objects.put(object, modelioElement);
            currentParent.getOwnedElement().add(modelioElement.getElement());
            
            modelioElement.setClass_MOF(object.getClass_());
            modelioElement.setStereotype(object.getStereotype());
            
            modelioElement.getElement().setName((emptyForNull(object.getName()) + " " + emptyForNull(object.getClass_()) + " " + emptyForNull(object.getStereotype())).trim());
        
            if (object.getRecognizer() != null) {
                modelioElement.setRecognizer_body(object.getRecognizer().getBody());
                modelioElement.setRecognizer_language(object.getRecognizer().getLanguage());
            }
            if (object.getBreakCondition() != null) {
                modelioElement.setBreak_condition_body(object.getBreakCondition().getBody());
                modelioElement.setBreak_condition_language(object.getBreakCondition().getLanguage());
            }
        } catch (Exception e) {
              e.printStackTrace();
        }
        return null;
    }

    @objid ("4333a0e4-c40f-45be-aa71-daa730e194de")
    @Override
    public ModelElement caseCharacteristic(Characteristic object) {
        measure.smm.api.measures.class_.Characteristic modelioElement = null;
        
        try {
            modelioElement = measure.smm.api.measures.class_.Characteristic.create();
            objects.put(object, modelioElement);
            currentParent.getOwnedElement().add(modelioElement.getElement());
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @objid ("ec450368-7300-46b6-ac61-72f0446be76f")
    @Override
    public ModelElement caseBase1MeasureRelationship(Base1MeasureRelationship object) {
        return null;
    }

    @objid ("149578e7-533d-4091-8568-de95827840b5")
    @Override
    public ModelElement caseBaseMeasureRelationship(BaseMeasureRelationship object) {
        return null;
    }

    @objid ("36c5929e-3d83-4d5c-9246-46cc52431a38")
    @Override
    public ModelElement caseRescaledMeasure(RescaledMeasure object) {
        measure.smm.api.othermeasures.class_.RescaledMeasure modelioElement = null;
        try {
            modelioElement = measure.smm.api.othermeasures.class_.RescaledMeasure.create();
            objects.put(object, modelioElement);
            currentParent.getOwnedElement().add(modelioElement.getElement());
            
            if (object.getOffset()!=null) modelioElement.setOffset(object.getOffset().toString()); 
            if (object.getMultiplier()!=null) modelioElement.setMultiplier(object.getMultiplier().toString());
        
            if (object.getOperation() != null) {
                modelioElement.setOperation_body(object.getOperation().getBody());
                modelioElement.setOperation_language(object.getOperation().getLanguage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @objid ("9ab1d2fa-7e2d-48cd-b4d5-a415a04c36bc")
    @Override
    public ModelElement caseDimensionalMeasure(DimensionalMeasure object) {
        measure.smm.api.measures.class_.DimensionalMeasure modelioElement = (measure.smm.api.measures.class_.DimensionalMeasure) objects.get(object);
        if (modelioElement != null) {
            try {
                modelioElement.setFormula(object.getFormula());
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @objid ("e309c11b-b83c-4e0f-ab43-136c0414d5b5")
    @Override
    public ModelElement caseBaseNMeasureRelationship(BaseNMeasureRelationship object) {
        return null;
    }

    @objid ("35089669-eb7c-4c59-ad5b-e087e66715ee")
    @Override
    public ModelElement caseCollectiveMeasure(CollectiveMeasure object) {
        measure.smm.api.collectivemeasures.class_.CollectiveMeasure modelioElement = null;
        try {
            modelioElement = measure.smm.api.collectivemeasures.class_.CollectiveMeasure.create();
            objects.put(object, modelioElement);
            currentParent.getOwnedElement().add(modelioElement.getElement());
            
            if (object.getAccumulator()!=null) modelioElement.setAccumulator(object.getAccumulator().getLiteral());
            
            if (object.getCustomAccumulator() != null) {
                modelioElement.setCustomAccumulator_body(object.getCustomAccumulator().getBody());
                modelioElement.setCustomAccumulator_language(object.getCustomAccumulator().getLanguage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @objid ("211e6fc6-e506-4b94-b776-c9b8673f3144")
    @Override
    public ModelElement caseBase2MeasureRelationship(Base2MeasureRelationship object) {
        return null;
    }

    @objid ("d970981e-039c-4eb9-b5f1-ea2b25deea17")
    @Override
    public ModelElement caseBinaryMeasure(BinaryMeasure object) {
        measure.smm.api.collectivemeasures.class_.BinaryMeasure modelioElement = null;
        try {
            if (objects.get(object) == null) {
                modelioElement = measure.smm.api.collectivemeasures.class_.BinaryMeasure.create();
                objects.put(object, modelioElement);
                currentParent.getOwnedElement().add(modelioElement.getElement());
            } else {
                modelioElement = (measure.smm.api.collectivemeasures.class_.BinaryMeasure) objects.get(object);
            }
            
            if (object.getFunctor()!=null) modelioElement.setFunctor(object.getFunctor().getLiteral());
            if (object.getCustomFunctor() != null) {
                modelioElement.setCustomFunctor_body(object.getCustomFunctor().getBody());
                modelioElement.setCustomFunctor_language(object.getCustomFunctor().getLanguage());
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @objid ("6a36d76d-f4d4-488d-a4a2-ea21b12f08b0")
    @Override
    public ModelElement caseRankingMeasureRelationship(RankingMeasureRelationship object) {
        return null;
    }

    @objid ("a1234c4a-af95-402c-a932-907e1a5b5baa")
    @Override
    public ModelElement caseRankingMeasure(RankingMeasure object) {
        measure.smm.api.measures.class_.RankingMeasure modelioElement = null;
        try {
            modelioElement = measure.smm.api.measures.class_.RankingMeasure.create();
            objects.put(object, modelioElement);
            currentParent.getOwnedElement().add(modelioElement.getElement());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @objid ("182f8c94-b54c-4e62-a74c-561f2dcb5cd4")
    @Override
    public ModelElement caseRankingInterval(RankingInterval object) {
        measure.smm.api.measures.class_.RankingInterval modelioElement = null;
        try {
            modelioElement = measure.smm.api.measures.class_.RankingInterval.create();
            objects.put(object, modelioElement);
            currentParent.getOwnedElement().add(modelioElement.getElement());
            
            try {
                modelioElement.setValue(new Double(object.getValue()).toString());
            } catch(Exception e) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @objid ("c54416cd-7cad-405e-929b-8aacc5fa119d")
    @Override
    public ModelElement caseInterval(Interval object) {
        measure.smm.api.measures.class_.Interval modelioElement = (measure.smm.api.measures.class_.Interval) objects.get(object);
        try {
            currentParent.getOwnedElement().add(modelioElement.getElement());
            if (object.getMaximumOpen()!=null) modelioElement.setMaximumOpen(object.getMaximumOpen().toString());
            if (object.getMinimumOpen()!=null) modelioElement.setMinimumOpen(object.getMinimumOpen().toString());
            if (object.getMaximumEndpoint()!=null) modelioElement.setMaximum(object.getMaximumEndpoint().toString());
            if (object.getMinimumEndpoint()!=null) modelioElement.setMinimum(object.getMinimumEndpoint().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @objid ("c79539c2-3fa6-4c9c-87f4-9f16b8adc514")
    @Override
    public ModelElement caseRescaledMeasureRelationship(RescaledMeasureRelationship object) {
        return null;
    }

    @objid ("d81ae82c-e537-401a-bdf4-de2bc3921950")
    @Override
    public ModelElement caseGradeMeasureRelationship(GradeMeasureRelationship object) {
        return null;
    }

    @objid ("b6f75c1f-75b2-4807-b14a-bb6913d71648")
    @Override
    public ModelElement caseGradeMeasure(GradeMeasure object) {
        measure.smm.api.measures.class_.GradeMeasure modelioElement = null;
        try {
            modelioElement = measure.smm.api.measures.class_.GradeMeasure.create();
            objects.put(object, modelioElement);
            currentParent.getOwnedElement().add(modelioElement.getElement());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @objid ("378af221-676c-415b-8ee8-1d39d6a5feda")
    @Override
    public ModelElement caseGradeInterval(GradeInterval object) {
        measure.smm.api.measures.class_.GradeInterval  modelioElement = null;
        try {
            modelioElement = measure.smm.api.measures.class_.GradeInterval.create();
            objects.put(object, modelioElement);
            currentParent.getOwnedElement().add(modelioElement.getElement());
            
            modelioElement.getElement().setName(object.getSymbol());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @objid ("f4a5a865-0852-4e0b-bab7-8790225d7a46")
    @Override
    public ModelElement caseUnitOfMeasure(UnitOfMeasure object) {
        measure.smm.api.measures.class_.UnitOfMeasure  modelioElement = null;
        try {
            modelioElement = measure.smm.api.measures.class_.UnitOfMeasure.create();
            objects.put(object, modelioElement);
            currentParent.getOwnedElement().add(modelioElement.getElement());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @objid ("b91d2759-6f3c-46b9-931d-3602a8828c85")
    @Override
    public ModelElement caseBase1MeasurementRelationship(Base1MeasurementRelationship object) {
        return null;
    }

    @objid ("8978fa98-ef77-4492-b2ae-2846ae53d751")
    @Override
    public ModelElement caseBaseMeasurementRelationship(BaseMeasurementRelationship object) {
        return null;
    }

    @objid ("51c0409f-a650-4002-8839-fe2a1148895d")
    @Override
    public ModelElement caseDimensionalMeasurement(DimensionalMeasurement object) {
        measure.smm.api.measurements.class_.DimensionalMeasurement modelioElement = (measure.smm.api.measurements.class_.DimensionalMeasurement) objects.get(object);
        if (modelioElement != null) {
            try {
                if (object.getValue()!=null) modelioElement.setDimensionalMeasurement_value(object.getValue().toString());
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @objid ("39e67c22-f600-436c-b8db-82b3b8be9a56")
    @Override
    public ModelElement caseBaseNMeasurementRelationship(BaseNMeasurementRelationship object) {
        return null;
    }

    @objid ("2496b825-2f00-4c6b-8b79-ebd517b08d15")
    @Override
    public ModelElement caseCollectiveMeasurement(CollectiveMeasurement object) {
        measure.smm.api.collectivemeasurements.class_.CollectiveMeasurement modelioElement = null;
        try {
            modelioElement = measure.smm.api.collectivemeasurements.class_.CollectiveMeasurement.create();
            objects.put(object, modelioElement);
            currentParent.getOwnedElement().add(modelioElement.getElement());
            
            modelioElement.setCollectiveMeasurement_isBaseSupplied(new Boolean(""+object.getIsBaseSupplied()).toString());
            
            if (object.getBaseQuery() != null) {
                modelioElement.setCollectiveMeasurement_Base_query_body(object.getBaseQuery().getBody());
                modelioElement.setCollectiveMeasurement_Base_query_language(object.getBaseQuery().getLanguage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @objid ("a67b0bc6-3516-4f64-a812-ca0b0f82b65d")
    @Override
    public ModelElement caseBase2MeasurementRelationship(Base2MeasurementRelationship object) {
        return null;
    }

    @objid ("9f7b0e9d-55ff-49dc-86dd-7a111c9336f7")
    @Override
    public ModelElement caseBinaryMeasurement(BinaryMeasurement object) {
        measure.smm.api.collectivemeasurements.class_.BinaryMeasurement modelioElement = null;
        try {
            if (objects.get(object)==null) {
                modelioElement = measure.smm.api.collectivemeasurements.class_.BinaryMeasurement.create();
                objects.put(object, modelioElement);
                currentParent.getOwnedElement().add(modelioElement.getElement());
            } else {
                modelioElement = (measure.smm.api.collectivemeasurements.class_.BinaryMeasurement) objects.get(object);
            }
            
            modelioElement.setBinaryMeasurement_isBaseSupplied(new Boolean(""+object.getIsBaseSupplied()).toString());
            if (object.getBaseQuery() != null) {
                modelioElement.setBinaryMeasurement_baseQuery_body(object.getBaseQuery().getBody());
                modelioElement.setBinaryMeasurement_baseQuery_language(object.getBaseQuery().getLanguage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @objid ("0b2f4db7-fa65-40ab-a2bf-198aa693164c")
    @Override
    public ModelElement caseGradeMeasurementRelationship(GradeMeasurementRelationship object) {
        return null;
    }

    @objid ("de08adbd-1a64-4738-b1d0-966a18fab479")
    @Override
    public ModelElement caseGradeMeasurement(GradeMeasurement object) {
        measure.smm.api.measurements.class_.GradeMeasurement modelioElement = null;
        try {
            modelioElement = measure.smm.api.measurements.class_.GradeMeasurement.create();
            objects.put(object, modelioElement);
            currentParent.getOwnedElement().add(modelioElement.getElement());
            
            modelioElement.setGradeMeasurement_value(object.getValue());
            
            modelioElement.setGradeMeasurement_isBaseSupplied(new Boolean(""+object.getIsBaseSupplied()).toString());
            if (object.getBaseQuery() != null) {
                modelioElement.setGradeMeasurement_baseQuery_body(object.getBaseQuery().getBody());
                modelioElement.setGradeMeasurement_baseQuery_language(object.getBaseQuery().getLanguage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @objid ("df7302e5-57d8-44cb-a174-00224d905739")
    @Override
    public ModelElement caseRescaledMeasurementRelationship(RescaledMeasurementRelationship object) {
        return null;
    }

    @objid ("eed036ae-d9fb-4dd9-88f2-498e05a8d58a")
    @Override
    public ModelElement caseRescaledMeasurement(RescaledMeasurement object) {
        measure.smm.api.namedandrescaledmeasurements.class_.RescaledMeasurement modelioElement = null;
        try {
            modelioElement = measure.smm.api.namedandrescaledmeasurements.class_.RescaledMeasurement.create();
            objects.put(object, modelioElement);
            currentParent.getOwnedElement().add(modelioElement.getElement());
            
            modelioElement.setRescaledMeasurement_isBaseSupplied(new Boolean(""+object.getIsBaseSupplied()).toString());
            if (object.getBaseQuery() != null) {
                modelioElement.setRescaledMeasurement_baseQuery_body(object.getBaseQuery().getBody());
                modelioElement.setRescaledMeasurement_baseQuery_language(object.getBaseQuery().getLanguage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @objid ("37557671-18de-4d23-9a0f-751a8c003f2e")
    @Override
    public ModelElement caseRankingMeasurementRelationship(RankingMeasurementRelationship object) {
        return null;
    }

    @objid ("cf46f0cc-81ce-4bdc-b76f-7739eaa7a248")
    @Override
    public ModelElement caseRankingMeasurement(RankingMeasurement object) {
        measure.smm.api.measurements.class_.RankingMeasurement modelioElement = null;
        try {
            modelioElement = measure.smm.api.measurements.class_.RankingMeasurement.create();
            objects.put(object, modelioElement);
            currentParent.getOwnedElement().add(modelioElement.getElement());
            
            modelioElement.setRankingMeasurement_isBaseSupplied(new Boolean(""+object.getIsBaseSupplied()).toString());
            if (object.getBaseQuery() != null) {
                modelioElement.setRankingMeasurement_baseQuery_body(object.getBaseQuery().getBody());
                modelioElement.setRankingMeasurement_baseQuery_language(object.getBaseQuery().getLanguage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @objid ("21d7d938-4d15-4a49-9528-f53c21059426")
    @Override
    public ModelElement caseCategoryRelationship(CategoryRelationship object) {
        return null;
    }

    @objid ("d6becc8e-73fe-45be-aeaa-696b704ea353")
    @Override
    public ModelElement caseCountingMeasurement(CountingMeasurement object) {
        measure.smm.api.collectivemeasurements.class_.CountingMeasurement modelioElement = null;
        try {
            modelioElement = measure.smm.api.collectivemeasurements.class_.CountingMeasurement.create();
            objects.put(object, modelioElement);
            currentParent.getOwnedElement().add(modelioElement.getElement());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @objid ("703bbaa4-4e46-4b68-b97b-1facf38ab169")
    @Override
    public ModelElement caseDirectMeasurement(DirectMeasurement object) {
        if (!objects.containsKey(object)) {
            measure.smm.api.collectivemeasurements.class_.DirectMeasurement modelioElement = null;
            try {
                modelioElement = measure.smm.api.collectivemeasurements.class_.DirectMeasurement.create();
                objects.put(object, modelioElement);
                currentParent.getOwnedElement().add(modelioElement.getElement());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @objid ("a12813a8-e886-417a-95c0-449165641fe9")
    @Override
    public ModelElement caseCountingMeasure(CountingMeasure object) {
        measure.smm.api.collectivemeasures.class_.CountingMeasure modelioElement = null;
        try {
            modelioElement = measure.smm.api.collectivemeasures.class_.CountingMeasure.create();
            objects.put(object, modelioElement);
            currentParent.getOwnedElement().add(modelioElement.getElement());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @objid ("bfb2b13c-aaa9-49b4-9d04-a591ea96820b")
    @Override
    public ModelElement caseDirectMeasure(DirectMeasure object) {
        measure.smm.api.collectivemeasures.class_.DirectMeasure modelioElement = null;
        try {
            if (!objects.containsKey(object)) {
                    modelioElement = measure.smm.api.collectivemeasures.class_.DirectMeasure.create();
                    objects.put(object, modelioElement);
                    currentParent.getOwnedElement().add(modelioElement.getElement());
            } else {
                modelioElement = (measure.smm.api.collectivemeasures.class_.DirectMeasure) objects.get(object);
            }
            
            if (object.getOperation() != null) {
                modelioElement.setOperation_body(object.getOperation().getBody());
                modelioElement.setOperation_language(object.getOperation().getLanguage());
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @objid ("87091fe2-8407-4d37-8234-17dd2f7cca12")
    @Override
    public ModelElement caseMeasureLibrary(MeasureLibrary object) {
        measure.smm.api.core.package_.MeasureLibrary modelioElement = null;
        try {
            modelioElement = measure.smm.api.core.package_.MeasureLibrary.create();
            objects.put(object, modelioElement);
            currentParent.getOwnedElement().add(modelioElement.getElement());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @objid ("1ddefb36-7fe6-4bbb-bba2-a9b6d1f17783")
    @Override
    public ModelElement caseNamedMeasure(NamedMeasure object) {
        measure.smm.api.othermeasures.class_.NamedMeasure modelioElement = null;
        try {
            modelioElement = measure.smm.api.othermeasures.class_.NamedMeasure.create();
            objects.put(object, modelioElement);
            currentParent.getOwnedElement().add(modelioElement.getElement());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @objid ("f1f3e171-f3c0-40a2-a72c-73c48d6ab1d9")
    @Override
    public ModelElement caseNamedMeasurement(NamedMeasurement object) {
        measure.smm.api.namedandrescaledmeasurements.class_.NamedMeasurement modelioElement = null;
        try {
            modelioElement = measure.smm.api.namedandrescaledmeasurements.class_.NamedMeasurement.create();
            objects.put(object, modelioElement);
            currentParent.getOwnedElement().add(modelioElement.getElement());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @objid ("0061d43a-98d0-44a8-828c-4f288a3ef777")
    @Override
    public ModelElement caseOCLOperation(OCLOperation object) {
        measure.smm.api.measures.class_.OCLOperation modelioElement = null;
        try {
            modelioElement = measure.smm.api.measures.class_.OCLOperation.create();
            objects.put(object, modelioElement);
            currentParent.getOwnedElement().add(modelioElement.getElement());
            
            modelioElement.setBody(object.getBody());
            modelioElement.setContext(object.getContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @objid ("78b2d7c7-39e3-4d56-97dc-c46c3e209b96")
    @Override
    public ModelElement caseObservation(Observation object) {
        measure.smm.api.observations.package_.Observation modelioElement = null;
        try {
            modelioElement = measure.smm.api.observations.package_.Observation.create();
            objects.put(object, modelioElement);
            currentParent.getOwnedElement().add(modelioElement.getElement());
            
            if (object.getWhenObserved()!=null) modelioElement.setWhenObserved(object.getWhenObserved().toString());
        
            modelioElement.setObserver(object.getObserver());
            modelioElement.setTool(object.getTool());
        
            List<String> types = new ArrayList<String>();            
            List<String> values = new ArrayList<String>();
            for(Argument argument : object.getArguments()) {
                types.add(argument.getType());
                values.add(argument.getValue());
            }
            modelioElement.getElement().putTagValues(ISMMPeerModule.MODULE_NAME, measure.smm.api.observations.package_.Observation.ARGUMENT_TYPES_TAGTYPE, types);
            modelioElement.getElement().putTagValues(ISMMPeerModule.MODULE_NAME, measure.smm.api.observations.package_.Observation.ARGUMENT_VALUES_TAGTYPE, values);
            
            List<String> scopes = new ArrayList<String>();
            for (ObservationScope scope : object.getScopes()) {
                scopes.add(scope.getScopeUri());
            }
            modelioElement.getElement().putTagValues(ISMMPeerModule.MODULE_NAME, measure.smm.api.observations.package_.Observation.OBSERVATIONSCOPE_TAGTYPE, scopes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @objid ("db3caac2-1bda-45bc-bef4-bb9f9d84a06b")
    @Override
    public ModelElement caseObservationScope(ObservationScope object) {
        return null;
    }

    @objid ("0c1e1f3b-869b-4af8-82c1-ce86b80e293c")
    @Override
    public ModelElement caseRatioMeasure(RatioMeasure object) {
        measure.smm.api.collectivemeasures.class_.RatioMeasure modelioElement = null;
        try {
            modelioElement = measure.smm.api.collectivemeasures.class_.RatioMeasure.create();
            objects.put(object, modelioElement);
            currentParent.getOwnedElement().add(modelioElement.getElement());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @objid ("5ddec476-4fdb-47f4-8bff-76e375add8e4")
    @Override
    public ModelElement caseRatioMeasurement(RatioMeasurement object) {
        measure.smm.api.collectivemeasurements.class_.RatioMeasurement modelioElement = null;
        try {
            modelioElement = measure.smm.api.collectivemeasurements.class_.RatioMeasurement.create();
            objects.put(object, modelioElement);
            currentParent.getOwnedElement().add(modelioElement.getElement());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param root
     */
    @objid ("bc005a25-8fe3-4de7-9240-de97bc107878")
    public void setCurrentParent(EObject root) {
        measure.smm.api.core.modelelement.SmmElement smmElement = (measure.smm.api.core.modelelement.SmmElement) objects.get(root);
        if (smmElement!=null) {
            this.currentParent = (ModelTree) smmElement.getElement();
        }
    }

    @objid ("371d52eb-9129-4141-9cc9-3d89f3bab39b")
    private String emptyForNull(String s) {
        return s==null?"":s;
    }

}
