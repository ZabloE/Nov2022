package lv.venta.demo.services;





import org.springframework.security.core.userdetails.UserDetailsService;

import lv.venta.demo.models.User;
import lv.venta.demo.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{

	User save (UserRegistrationDto registrationDto);

	
}
