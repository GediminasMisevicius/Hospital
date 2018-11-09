package lt.bit.hospital.auth;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import static org.springframework.security.core.userdetails.User.withUsername;

import lt.bit.hospital.patient.Patient;

public class UserDetailsServiceImp implements UserDetailsService {
	
	@Autowired
	private AuthJpaRepository rep;
	
	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

		/*
		 * Here we are using dummy data, you need to load user data from database or
		 * other third party application
		 */
		Patient user = findPatientbyName(name);

		UserBuilder builder = null;
		if (user != null) {
			builder = withUsername(name);
			builder.username(user.getSurname());
//			List<String> strings = user
//					.getRoles()
//					.stream()
//					.map(Roles::toString)
//					.collect(Collectors.toList());
//			String[] strArr = new String[strings.size()];
//			strArr = strings.toArray(strArr);
//			builder.roles(strArr);
		} else {
			throw new UsernameNotFoundException("User not found.");
		}

		return builder.build();
	}

	private Patient findPatientbyName(String name) {
		return rep.findByName(name).orElseThrow();
	}
}
