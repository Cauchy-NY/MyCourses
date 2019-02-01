package cn.cauchyny.mycourses.dto;

import cn.cauchyny.mycourses.model.Course;
import cn.cauchyny.mycourses.model.CourseRecord;

import java.util.List;

public class UnapprovalListDto {

    private List<Course> courseList;
    private List<CourseRecord> courseRecordList;

    public UnapprovalListDto() {}

    public UnapprovalListDto(List<Course> courseList, List<CourseRecord> courseRecordList) {
        this.courseList = courseList;
        this.courseRecordList = courseRecordList;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public List<CourseRecord> getCourseRecordList() {
        return courseRecordList;
    }

    public void setCourseRecordList(List<CourseRecord> courseRecordList) {
        this.courseRecordList = courseRecordList;
    }
}
