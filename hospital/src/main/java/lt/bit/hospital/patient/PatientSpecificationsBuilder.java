package lt.bit.hospital.patient;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

public class PatientSpecificationsBuilder {
	
	private PatientSpecificationsBuilder() {}

	public static Specification<Patient> buildSpecificationByFilter(PatientFilter patientFilter) {
		Specification<Patient> spec = null;

		if (!patientFilter.getName().isEmpty()) {
			spec = patientName(spec, patientFilter);
		}

		if (!patientFilter.getDiagnosis().isEmpty()) {
			spec = patientDiagnosis(spec, patientFilter);
		}
		if (!patientFilter.getAddress().toString().isEmpty()) {
			spec = patientAddress(spec, patientFilter);
		}

		return spec;
	}

	public static Specification<Patient> patientName(Specification<Patient> spec, PatientFilter patientFilter) {

		spec = spec.and(new Specification<Patient>() {

			@Override
			public Predicate toPredicate(Root<Patient> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				return criteriaBuilder.like(root.get("name"), "%" + patientFilter.getName() + "%");
			}
		});

		return spec;
	}

	public static Specification<Patient> patientDiagnosis(Specification<Patient> spec, PatientFilter patientFilter) {

		spec = spec.and(new Specification<Patient>() {

			@Override
			public Predicate toPredicate(Root<Patient> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				return criteriaBuilder.like(root.get("diagnosis"), "%" + patientFilter.getDiagnosis() + "%");
			}
		});

		return spec;
	}

	public static Specification<Patient> patientAddress(Specification<Patient> spec, PatientFilter patientFilter) {

		spec = spec.and(new Specification<Patient>() {

			@Override
			public Predicate toPredicate(Root<Patient> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				return criteriaBuilder.like(root.get("address"), "%" + patientFilter.getAddress().toString() + "%");
			}
		});

		return spec;
	}

}
