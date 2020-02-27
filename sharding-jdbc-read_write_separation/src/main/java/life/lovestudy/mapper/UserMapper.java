package life.lovestudy.mapper;

import life.lovestudy.entity.UserEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
	@Select("SELECT * FROM  user_info ")
	public List<UserEntity> findUser();

	@Insert("insert into user_info values (#{userName}); ")
	public int insertUser(@Param("userName") String userName);
}
