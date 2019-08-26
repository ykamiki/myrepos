package jp.co.internous.myshop.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import jp.co.internous.myshop.model.domain.User;

@Mapper
public interface UserMapper {

	List<User> findByUserNameAndPassword(
			@Param("userName") String userName,
			@Param("password") String password);
	
}
