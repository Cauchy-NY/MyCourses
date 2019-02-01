package cn.cauchyny.mycourses.dao;

import cn.cauchyny.mycourses.model.Selection;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SelectionDao {
    @Insert({
            "insert into selection (studentId, courseRecordId, grade)",
            "values (#{studentId,jdbcType=VARCHAR}, #{courseRecordId,jdbcType=INTEGER}, #{grade, jdbcType=DOUBLE})"
    })
    int insert(Selection selection);

    @Select({"select * from selection where studentId = #{studentId,jdbcType=VARCHAR}"})
    List<Selection> getSelectionByStudentId(String studentId);

    @Select({"select * from selection where courseRecordId = #{recordId,jdbcType=VARCHAR}"})
    List<Selection> getSelectionByRecordId(String recordId);

    @Update({"update selection " +
            "set grade = #{grade} " +
            "where studentId = #{studentId} and courseRecordId = #{courseRecordId}"})
    int update(Selection selection);

    @Delete({"delete from selection where studentId = #{studentId} and courseRecordId = #{courseRecordId}"})
    int delete(Selection selection);

    @Select({"select * from selection where studentId = #{userId} and courseRecordId = #{recordId}"})
    Selection getGrade(String userId, String recordId);
}
