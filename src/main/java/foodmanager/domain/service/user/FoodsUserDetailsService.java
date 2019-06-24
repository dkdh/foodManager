package foodmanager.domain.service.user;
/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import foodmanager.domain.mapper.UserMapper;
import foodmanager.domain.model.User;

@Service
public class FoodsUserDetailsService implements UserDetailsService {
	//UserMapper userMapper;
	UserMapper userMapper = new UserMapper();
	
	@Override
	public UserDetails loadUserByUsername(String userIds) throws UsernameNotFoundException {
		int userId = Integer.parseInt(userIds);
		User user = userMapper.findOne(userId);
		if(user==null) {
			throw new UsernameNotFoundException(userIds+" is not found");
		}
		return new FoodsUserDetails(user);
	}
}
*/