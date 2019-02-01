package cn.cauchyny.mycourses.dao;

import cn.cauchyny.mycourses.model.Discussion;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscussionDao {
    @Insert({"insert into discussion (id, userId, userType, title, content, seq, ansTo, hasTitle) " +
            "values (#{id}, #{userId}, #{userType}, #{title}, #{content}, #{seq}, #{ansTo}, #{hasTitle})"})
    int insert(Discussion discussion);

    @Select({"select * from discussion where id = #{id}"})
    List<Discussion> selectById(String id);

    @Select({"select * from discussion where hasTitle = true"})
    List<Discussion> selectByHasTitle();
}
