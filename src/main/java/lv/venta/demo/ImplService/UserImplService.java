package lv.venta.demo.ImplService;

import java.util.Arrays;
import java.util.Collection;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import lv.venta.demo.models.User;

import lv.venta.demo.repos.IUserRepo;
import lv.venta.demo.services.UserService;
import lv.venta.demo.web.dto.UserRegistrationDto;
import lv.venta.demo.models.Role;
@Service

public class UserImplService implements UserService{

	@Autowired
	private IUserRepo userRepo;
	
	
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public UserImplService(IUserRepo userRepo)
	{
		super();
		this.userRepo = userRepo;
	}

	
	@Override
	public User save( UserRegistrationDto registrationDto) {
		User user = new User(registrationDto.getName(), registrationDto.getSurname(),passwordEncoder.encode
				(registrationDto.getPassword()), registrationDto.getEmail(), Arrays.asList(new Role("ROLE_USER")));
		return userRepo.save(user);
		
		
	}
	
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByEmail(username);
		if(user == null)
		{
			
			throw new UsernameNotFoundException("Invalid user name or password");
			
			
		}
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role>roles)
	{
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}


	
	
	

	
	  

}
