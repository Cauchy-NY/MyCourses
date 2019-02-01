package cn.cauchyny.mycourses.dao;

import cn.cauchyny.mycourses.model.Course;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseDao {
    @Insert({
            "insert into course (courseName, courseDes,",
            "courseNum, courseId, teacherId, isApproval)",
            "values (#{courseName,jdbcType=VARCHAR}, #{courseDes,jdbcType=VARCHAR},",
            "#{courseNum,jdbcType=INTEGER}, #{courseId,jdbcType=VARCHAR}, #{teacherId,jdbcType=VARCHAR}, #{isApproval,jdbcType=TINYINT})"
    })
    int insert(Course course);

    @Update("update course " +
            "set isApproval = true " +
            "where courseId = #{courseId}")
    int update(String courseId);

    @Select("select * from course where teacherId = #{teacherId,jdbcType=VARCHAR} and isApproval = true")
    List<Course> selectByTeacherId(String teacherId);

    @Select("select * from course where courseId = #{courseId,jdbcType=VARCHAR}")
    Course selectByCourseId(String courseId);

    @Select("select * from course")
    List<Course> getAllCourse();

    @Select("select * from course where isApproval = false")
    List<Course> getUnapprovalCourse();

    @Select("select count(*) from course where isApproval = true")
    int getCourseNum();
}
