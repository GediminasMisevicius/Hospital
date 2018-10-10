package lt.bit.hospital.patient;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class PatientController {
	
	@Autowired
	private PatientService patientService;

	@GetMapping("/info/{id}")
	public String getPatientInfo(@PathVariable String id, Model model) {
		Patient getP = patientService.getPatientInfo(id);
		model.addAttribute(getP);
		return "info";
	}
	
	@PostMapping("/register")
	public String registerPatient(HttpServletRequest request) {
		Patient regP = new Patient();
				regP.setName(request.getParameter("name"));
		patientService.registerPatient(regP);
		return "register";
	}
	
	@PutMapping("/edit")
	public String editPatientInfo(Model model, HttpServletRequest request) {
		Patient eP = new Patient();
				eP.setId(request.getParameter("id"));
				String[] info = request.getParameterValues("info");
		patientService.editPatientInfo(eP.getId(), info);
		model.addAttribute(eP);
		return "edit";
	}
}
