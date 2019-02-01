package cn.cauchyny.mycourses.dao;

import cn.cauchyny.mycourses.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    @Insert({
        "insert into user (email, password, ",
        "name, id, type)",
        "values (#{email,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
        "#{name,jdbcType=VARCHAR}, #{id,jdbcType=VARCHAR}, #{type,jdbcType=CHAR})"
    })
    int insert(User user);

    @Select("select * from user")
    List<User> getAllUsers();

    @Select("select * from user where id = #{id,jdbcType=VARCHAR}")
    User getUserById(String id);

    @Select("select * from user where id = #{id,jdbcType=VARCHAR} and password = #{password,jdbcType=VARCHAR}")
    User getUserByIdAndPassword(String id, String password);

    @Delete("delete from user where id = #{id}")
    int delete(String id);

    @Select("select count(*) from user where type = 'teacher'")
    int getTeacherNum();

    @Select("select count(*) from user where type = 'student'")
    int getstudentNum();
}