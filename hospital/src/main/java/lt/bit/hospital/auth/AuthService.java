package lt.bit.hospital.auth;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lt.bit.hospital.patient.Patient;

@Service
@Transactional
public class AuthService {

	private AuthJpaRepository rep;

	private PasswordEncoder passwordEncoder;

	public AuthService(AuthJpaRepository rep, PasswordEncoder passwordEncoder) {
		this.rep = rep;
		this.passwordEncoder = passwordEncoder;
	}

	public boolean authenticateUser(String username, String password) {

		return false;
	}
	
	public boolean registerUser(String name, String surname) {
		if(rep.findByName(name).isPresent()) {
			return false;
		} else {
			Patient user = new Patient()
					.setName(name)
					.setSurname(passwordEncoder.encode(surname));
					//.setRoles(Set.of(Roles.PATIENT));
			rep.save(user);
			return true;
		}
	
	}

}
