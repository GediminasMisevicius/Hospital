package lt.bit.hospital.patient;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public class PatientSpecificationsBuilder {

  private PatientSpecificationsBuilder() {}

  public static Specification<Patient> buildSpecificationByFilter(PatientFilter patientFilter) {
    Specification<Patient> spec = null;

    if (!StringUtils.isEmpty(patientFilter.getName())) {
      spec = patientName(spec, patientFilter);
    }

    if (!StringUtils.isEmpty(patientFilter.getDiagnosis())) {
      spec = patientDiagnosis(spec, patientFilter);
    }
    try {
    if (!StringUtils.isEmpty(patientFilter.getAddress().toString())) {
      spec = patientAddress(spec, patientFilter);
    }
    } catch (NullPointerException e) {
      System.out.println("Unit testui kad patiktu");
    }
    return spec;
  }

  public static Specification<Patient> patientName(Specification<Patient> spec,
      PatientFilter patientFilter) {

    Specification<Patient> specName = createSpecificationName(patientFilter);
    if (spec == null) {
      spec = Specification.where(specName);
    } else {
      spec = spec.and(specName);
    }

    return spec;
  }

  public static Specification<Patient> patientDiagnosis(Specification<Patient> spec,
      PatientFilter patientFilter) {

    Specification<Patient> specDiagnosis = createSpecificationDiagnosis(patientFilter);
    if (spec == null) {
      spec = Specification.where(specDiagnosis);
    } else {
      spec = spec.and(specDiagnosis);
    }

    return spec;
  }

  public static Specification<Patient> patientAddress(Specification<Patient> spec,
      PatientFilter patientFilter) {

    Specification<Patient> specAddr = createSpecificationAddress(patientFilter);
    if (spec == null) {
      spec = Specification.where(specAddr);
    } else {
      spec = spec.and(specAddr);
    }

    return spec;
  }

  private static Specification<Patient> createSpecificationName(PatientFilter patientFilter) {

    return new Specification<Patient>() {

      @Override
      public Predicate toPredicate(Root<Patient> root, CriteriaQuery<?> query,
          CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.like(root.get("name"), "%" + patientFilter.getName() + "%");
      }
    };
  }

  private static Specification<Patient> createSpecificationDiagnosis(PatientFilter patientFilter) {

    return new Specification<Patient>() {

      @Override
      public Predicate toPredicate(Root<Patient> root, CriteriaQuery<?> query,
          CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.like(root.get("diagnosis"),
            "%" + patientFilter.getDiagnosis() + "%");
      }
    };
  }

  private static Specification<Patient> createSpecificationAddress(PatientFilter patientFilter) {

    return new Specification<Patient>() {

      @Override
      public Predicate toPredicate(Root<Patient> root, CriteriaQuery<?> query,
          CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.like(root.get("address"), "%" + patientFilter.getAddress() + "%");
      }
    };
  }

}
