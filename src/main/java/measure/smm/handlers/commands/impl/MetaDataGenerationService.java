package measure.smm.handlers.commands.impl;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.measure.smm.measure.model.FieldType;
import org.measure.smm.measure.model.MeasureReference;
import org.measure.smm.measure.model.MeasureType;
import org.measure.smm.measure.model.MeasureUnit;
import org.measure.smm.measure.model.MeasureUnitField;
import org.measure.smm.measure.model.SMMMeasure;
import org.measure.smm.measure.model.ScopeProperty;
import org.measure.smm.measure.model.ScopePropertyEnum;
import org.measure.smm.measure.model.ScopePropertyEnumValue;
import org.measure.smm.measure.model.ScopePropertyType;
import org.modelio.metamodel.uml.infrastructure.Dependency;
import org.modelio.metamodel.uml.statik.AggregationKind;
import org.modelio.metamodel.uml.statik.AssociationEnd;
import org.modelio.metamodel.uml.statik.Attribute;
import org.modelio.metamodel.uml.statik.Class;
import org.modelio.metamodel.uml.statik.Classifier;
import org.modelio.metamodel.uml.statik.Enumeration;
import org.modelio.metamodel.uml.statik.EnumerationLiteral;
import org.modelio.metamodel.uml.statik.GeneralClass;

@objid("1f366570-7e57-415a-aa7e-7467a0f1a71b")
public class MetaDataGenerationService {
	@objid("aaaeccb6-4514-45d3-8579-9943906542ed")
	private Class measure;

	@objid("831e2246-fa09-4690-86b5-6bb46fe5dfcc")
	public MetaDataGenerationService(Class measure) {
		this.measure = measure;
	}

	@objid("dba3f673-e5c8-44f0-9f24-7c4601288f01")
	public void generateMetadatas(Path metadataFile) {
		SMMMeasure measureModel = calculateMetadata();

		if (metadataFile.toFile().exists()) {
			metadataFile.toFile().delete();
		}

		JAXBContext context;
		try {
			context = JAXBContext.newInstance(SMMMeasure.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.marshal(measureModel, metadataFile.toFile());
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	@objid("266486da-438a-4ec2-821c-792d01de4572")
	public SMMMeasure createDerivedMeasure(MeasureType type) {
		// Create Measure
		SMMMeasure measureModel = new SMMMeasure();
		measureModel.setName(this.measure.getName().replace(" ", ""));
		String description = this.measure.getNoteContent("ModelerModule", "description");
		if (description != null) {
			measureModel.setDescription(description);
		}

		String mtype = this.measure.getTagValue("SMM", "metadata.type");
		if (mtype != null || !"".equals(mtype)) {
			measureModel.setCategory(mtype);
		}

		String developer = this.measure.getTagValue("SMM", "matadata.developer");
		if (developer != null && !"".equals(developer)) {
			measureModel.setProvider(developer);
		}

		measureModel.setType(type);

		Class unit = getDependency(this.measure, "SMM", "UnitLink");
		if (unit != null) {
			measureModel.setUnit(createUnit(unit));
		}

		measureModel.getScopeProperties().addAll(createScopeModel());

		for (Dependency dp : this.measure.getDependsOnDependency()) {
			if (dp.isStereotyped("SMM", "BaseMeasureRelationhip")) {
				String refRole = dp.getName();
				String refType = dp.getDependsOn().getName();
				int number = 1;

				if (dp.isStereotyped("SMM", "BaseNMeasureRelationship")) {
					try {
						number = Integer.valueOf(dp.getTagValue("SMM", "influence"));
					} catch (NumberFormatException e) {
						System.out.println(e);
					}
				}

				MeasureReference ref = new MeasureReference();
				ref.setMeasureRef(refType);
				ref.setRole(refRole);
				ref.setNumber(number);
				measureModel.getReferences().add(ref);
			}
		}
		return measureModel;
	}

	@objid("72877d0b-e740-4d97-99b0-a767ebaf65a6")
	private SMMMeasure createDirectMeasure(MeasureType type) {
		// Create Measure
		SMMMeasure measureModel = new SMMMeasure();
		measureModel.setName(this.measure.getName().replace(" ", ""));

		String description = this.measure.getNoteContent("ModelerModule", "description");
		if (description != null) {
			measureModel.setDescription(description);
		}

		String mtype = this.measure.getTagValue("SMM", "metadata.type");
		if (mtype != null || !"".equals(mtype)) {
			measureModel.setCategory(mtype);
		}

		String developer = this.measure.getTagValue("SMM", "matadata.developer");
		if (developer != null && !"".equals(developer)) {
			measureModel.setProvider(developer);
		}

		measureModel.setType(type);

		Class unit = getDependency(this.measure, "SMM", "UnitLink");
		if (unit != null) {
			measureModel.setUnit(createUnit(unit));
		}

		measureModel.getScopeProperties().addAll(createScopeModel());
		return measureModel;
	}

	@objid("de49dc0f-7fc7-432f-9bec-f3c1b9cd18f6")
	private List<ScopeProperty> createScopeModel() {
		List<ScopeProperty> result = new ArrayList<ScopeProperty>();

		Class scope = getDependency(this.measure, "SMM", "ScopeLink");
		if (scope != null) {
			for (Attribute property : scope.getOwnedAttribute()) {
				ScopeProperty scopeProp = new ScopeProperty();
				scopeProp.setName(property.getName());
				scopeProp.setDefaultValue(property.getValue());
				scopeProp.setType(findScopeType(property));

				if (property.getType() instanceof Enumeration) {
					ScopePropertyEnum scopeEnum = new ScopePropertyEnum();
					for (EnumerationLiteral val : ((Enumeration) property.getType()).getValue()) {
						ScopePropertyEnumValue value = new ScopePropertyEnumValue();
						value.setLabel(val.getName());
						value.setValue(val.getName());
						scopeEnum.getEnumvalue().add(value);
					}
					scopeProp.setEnumType(scopeEnum);
				}

				String description = this.measure.getNoteContent("ModelerModule", "decription");
				if (description != null) {
					scopeProp.setDescription(description);
				}
				result.add(scopeProp);
			}
		}
		return result;
	}

	@objid("f57d1a25-ae16-4f8f-a01b-7b24503d4615")
	private Class getDependency(Class source, String module, String stereotype) {
		for (Dependency dp : source.getDependsOnDependency()) {
			if (dp.isStereotyped(module, stereotype)) {
				return (Class) dp.getDependsOn();
			}
		}
		return null;
	}

	@objid("5212bab8-ed3d-4b6e-b3ea-3ce3f924cfcf")
	public SMMMeasure calculateMetadata() {
		if (this.measure.isStereotyped("SMM", "CountingMeasure")) {
			return createDirectMeasure(MeasureType.COUNTING);
		} else if (this.measure.isStereotyped("SMM", "CollectiveMeasure")) {
			return createDerivedMeasure(MeasureType.COLLECTIVE);
		} else if (this.measure.isStereotyped("SMM", "BinaryMeasure")) {
			return createDerivedMeasure(MeasureType.BINARY);
		} else if (this.measure.isStereotyped("SMM", "RatioMeasure")) {
			return createDerivedMeasure(MeasureType.RATIO);
		} else if (this.measure.isStereotyped("SMM", "RescaledMeasure")) {
			return createDerivedMeasure(MeasureType.RESCALED);
		} else if (this.measure.isStereotyped("SMM", "GradeMeasure")) {
			return createDerivedMeasure(MeasureType.GRADE);
		} else if (this.measure.isStereotyped("SMM", "RankingMeasure")) {
			return createDerivedMeasure(MeasureType.RACKING);
		}

		return createDirectMeasure(MeasureType.DIRECT);
	}

	@objid("73f3a3b2-5646-4fa9-b5b2-0628e8b1661c")
	private FieldType findFinedType(Attribute attr) {
		if (attr.getType() != null) {
			String mftype = attr.getType().getName();
			if ("string".equals(mftype)) {
				return FieldType.u_text;
			} else if ("boolean".equals(mftype)) {
				return FieldType.u_boolean;
			} else if ("char".equals(mftype)) {
				return FieldType.u_text;
			} else if ("date".equals(mftype)) {
				return FieldType.u_date;
			} else if ("double".equals(mftype)) {
				return FieldType.u_double;
			} else if ("float".equals(mftype)) {
				return FieldType.u_float;
			} else if ("integer".equals(mftype)) {
				return FieldType.u_integer;
			} else if ("long".equals(mftype)) {
				return FieldType.u_long;
			} else if ("short".equals(mftype)) {
				return FieldType.u_short;
			}

			for (FieldType ftype : FieldType.values()) {
				if (attr.getType().getName().equals(ftype.name())) {
					return ftype;
				}
			}
		}
		return FieldType.u_text;
	}

	@objid("edaac945-ed04-4a26-8369-dccae7d6220e")
	private MeasureUnit createUnit(Class unit) {
		MeasureUnit nunit = new MeasureUnit();
		nunit.setName(unit.getName());
		for (Attribute attr : unit.getOwnedAttribute()) {
			MeasureUnitField field = new MeasureUnitField();
			field.setFieldName(attr.getName());
			field.setFieldType(findFinedType(attr));
			nunit.getFields().add(field);
		}
		for (AssociationEnd end : unit.getOwnedEnd()) {
			if (end.getAggregation().equals(AggregationKind.KINDISCOMPOSITION)) {
				Classifier target = end.getOppositeOwner().getOwner();
				if (target instanceof Class) {
					MeasureUnitField field = new MeasureUnitField();
					field.setFieldName(target.getName());
					field.setSubtype(createUnit((Class) target));
					nunit.getFields().add(field);
				}
			}
		}
		return nunit;
	}

	@objid("e5f1bd1f-4a77-467c-965b-f98cd1a1443c")
	private ScopePropertyType findScopeType(Attribute property) {
		if (property.getType() != null) {
			GeneralClass sptype = property.getType();
			if (sptype instanceof Enumeration) {
				return ScopePropertyType.ENUM;
			}
			for (ScopePropertyType type : ScopePropertyType.values()) {
				if (sptype.getName().equals(type.name())) {
					return type;
				}
			}

			if ("string".equals(sptype)) {
				return ScopePropertyType.STRING;
			} else if ("date".equals(sptype)) {
				return ScopePropertyType.DATE;
			} else if ("integer".equals(sptype)) {
				return ScopePropertyType.INTEGER;
			} else if ("float".equals(sptype)) {
				return ScopePropertyType.FLOAT;
			}
		}
		return ScopePropertyType.STRING;
	}

}
