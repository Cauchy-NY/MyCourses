package cn.cauchyny.mycourses.service;

import cn.cauchyny.mycourses.dao.CourseDao;
import cn.cauchyny.mycourses.dao.CourseRecordDao;
import cn.cauchyny.mycourses.dao.HomeworkDao;
import cn.cauchyny.mycourses.dao.SelectionDao;
import cn.cauchyny.mycourses.dto.CourseDto;
import cn.cauchyny.mycourses.dto.UnapprovalListDto;
import cn.cauchyny.mycourses.model.*;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private CourseRecordDao courseRecordDao;

    @Autowired
    private SelectionDao selectionDao;

    @Autowired
    private HomeworkDao homeworkDao;

    public List<Course> getCourseList(String teacherId) {
        return courseDao.selectByTeacherId(teacherId);
    }

    public String insertCourse(Course course) {
        courseDao.insert(course);
        return new JSONObject(){{put("message","success");}}.toString();
    }

    public void updateCourse(String courseId) {
        courseDao.update(courseId);
    }

    public List<CourseDto> getCourseDetailList(String teacherId) {
        List<Course> courseList = getCourseList(teacherId);
        List<CourseDto> courseDtoList = new ArrayList<>();
        for (Course course: courseList) {
            List<CourseRecord> part = courseRecordDao.selectByCourseId(course.getCourseId());
            for (CourseRecord courseRecord: part)
                courseDtoList.add(new CourseDto(new Course(course), courseRecord));
        }
        return courseDtoList;
    }

    public String insertCourseRecord(CourseRecord courseRecord) {
        courseRecordDao.insert(courseRecord);
        return new JSONObject(){{put("message","success");}}.toString();
    }

    public void updateCourseRecord(String courseRecordId) {
        courseRecordDao.update(courseRecordId);
    }

    public List<CourseDto> getSelectedCourse(String studentId) {
        List<Selection> selectionList = selectionDao.getSelectionByStudentId(studentId);
        List<CourseDto> courseDtoList = new ArrayList<>();
        for (Selection selection: selectionList) {
            CourseRecord courseRecord = courseRecordDao.selectByRecordId(selection.getCourseRecordId());
            Course course = courseDao.selectByCourseId(courseRecord.getCourseId());
            courseDtoList.add(new CourseDto(course, courseRecord));
        }
        return courseDtoList;
    }

    public List<CourseDto> getUnselectedCourse(String studentId) {
        List<Selection> selectionList = selectionDao.getSelectionByStudentId(studentId);
        List<Course> courseList = courseDao.getAllCourse();
        List<CourseDto> courseDtoList = new ArrayList<>();
        for (Course course: courseList) {
            List<CourseRecord> part = courseRecordDao.selectByCourseId(course.getCourseId());
            for (CourseRecord courseRecord: part) {
                if (!isContained(selectionList, courseRecord.getRecordId()))
                    courseDtoList.add(new CourseDto(course, courseRecord));
            }
        }
        return courseDtoList;
    }

    private boolean isContained(List<Selection> selectionList, int recordId) {
        for (Selection selection: selectionList) {
            if (selection.getCourseRecordId() == recordId)
                return true;
        }
        return false;
    }

    public String selectCourse(Selection selection) {
        selectionDao.insert(selection);
        return new JSONObject(){{put("message","success");}}.toString();
    }

    public String quitCourse(Selection selection) {
        selectionDao.delete(selection);
        return new JSONObject(){{put("message","success");}}.toString();
    }

    public String insertHomework(Homework homework) {
        homeworkDao.insert(homework);
        return new JSONObject(){{put("message","success");}}.toString();
    }

    public List<Homework> getHomework(String id) {
        return homeworkDao.selectByRecordId(id);
    }

    public List<Selection> getSelections(String id) {
        return selectionDao.getSelectionByRecordId(id);
    }

    public void updateSelections(List<Selection> selectionList) {
        for (Selection selection: selectionList) {
            selectionDao.update(selection);
        }
    }

    public double getGrade(String userId, String recordId) {
        return selectionDao.getGrade(userId, recordId).getGrade();
    }

    public UnapprovalListDto getUnapprovalList() {
        return new UnapprovalListDto(
                courseDao.getUnapprovalCourse(),
                courseRecordDao.selectUnapprovalCourseRecord()
        );
    }
}
