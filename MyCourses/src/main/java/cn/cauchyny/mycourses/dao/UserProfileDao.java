package cn.cauchyny.mycourses.dao;

import cn.cauchyny.mycourses.model.UserProfile;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileDao {
    @Insert({"insert into userProfile (userId, userName, backupEmail, state) " +
            "values (#{userId}, #{userName}, #{backupEmail}, #{state})"})
    int insert(UserProfile userProfile);

    @Select("select * from userProfile where userId = #{userId}")
    UserProfile selectByUserId(String userId);

    @Update("update userProfile " +
            "set userName = #{userName}, backupEmail = #{backupEmail}, state = #{state} " +
            "where userId = #{userId}")
    int updateByUserId(UserProfile userProfile);
}
