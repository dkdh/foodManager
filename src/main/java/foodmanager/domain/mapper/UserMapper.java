package foodmanager.domain.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import foodmanager.domain.model.User;

@Mapper
public interface UserMapper {
	
	@Select("SELECT * FROM user WHERE username = #{username}")
	public User findOne(String userName);
}
