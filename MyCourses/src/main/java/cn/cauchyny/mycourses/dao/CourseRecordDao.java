package cn.cauchyny.mycourses.dao;

import cn.cauchyny.mycourses.model.CourseRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRecordDao {
    @Insert({
            "insert into courseRecord (courseId, semester, year, " +
                    "classes, isNumLimited, state, isApproval)",
            "values (#{courseId,jdbcType=VARCHAR}, #{semester,jdbcType=VARCHAR},",
            "#{year,jdbcType=VARCHAR}, #{classes,jdbcType=VARCHAR}, " +
                    "#{isNumLimited,jdbcType=TINYINT}, #{state,jdbcType=VARCHAR}, #{isApproval,jdbcType=TINYINT})"
    })
    int insert(CourseRecord courseRecord);

    @Update("update courseRecord " +
            "set isApproval = true " +
            "where recordId = #{recordId}")
    int update(String courseRecord);

    @Select("select * from courseRecord where courseId = #{courseId,jdbcType=VARCHAR} and isApproval = true")
    List<CourseRecord> selectByCourseId(String courseId);

    @Select("select * from courseRecord where recordId = #{recordId,jdbcType=INTEGER}")
    CourseRecord selectByRecordId(int recordId);

    @Select("select * from courseRecord where isApproval = false")
    List<CourseRecord> selectUnapprovalCourseRecord();

    @Select("select count(*) from courseRecord where isApproval = true")
    int getCourseRecordNum();
}
