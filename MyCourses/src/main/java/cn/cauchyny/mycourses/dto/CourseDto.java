package cn.cauchyny.mycourses.dto;

import cn.cauchyny.mycourses.model.Course;
import cn.cauchyny.mycourses.model.CourseRecord;

public class CourseDto {

    private Course course;

    private CourseRecord courseRecord;

    public CourseDto() {}

    public CourseDto(Course course, CourseRecord courseRecord) {
        this.course = course;
        this.courseRecord = courseRecord;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public CourseRecord getCourseRecord() {
        return courseRecord;
    }

    public void setCourseRecord(CourseRecord courseRecord) {
        this.courseRecord = courseRecord;
    }
}
