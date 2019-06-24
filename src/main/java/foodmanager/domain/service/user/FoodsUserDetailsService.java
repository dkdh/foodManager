package foodmanager.domain.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import foodmanager.domain.mapper.UserMapper;
import foodmanager.domain.model.User;

@Service
public class FoodsUserDetailsService implements UserDetailsService {
	@Autowired
	UserMapper userMapper;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userMapper.findOne(userName);
		
		if(user==null) {
			System.out.println("noooo");
			throw new UsernameNotFoundException(userName+" is not found");
		}

		return new FoodsUserDetails(user);
	}
}
