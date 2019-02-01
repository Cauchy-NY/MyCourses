package cn.cauchyny.mycourses.dao;

import cn.cauchyny.mycourses.model.Homework;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomeworkDao {
    @Insert({"insert into homework (recordId, title, endTime, state) " +
            "values (#{recordId}, #{title}, #{endTime}, #{state})"})
    int insert(Homework homework);

    @Select("select * from homework where recordId = #{recordId}")
    List<Homework> selectByRecordId(String recordId);

    @Select("select count(*) from homework")
    int getHomeWorkNum();
}
