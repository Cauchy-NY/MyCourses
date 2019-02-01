package cn.cauchyny.mycourses.model;

public class Course {

    private String courseName;

    private String courseDes;

    private int courseNum;

    private String courseId;

    private String teacherId;

    private boolean isApproval;

    public Course() {}

    public Course(Course course) {
        this.courseName = course.getCourseName();
        this.courseDes = course.getCourseDes();
        this.courseNum = course.getCourseNum();
        this.courseId = course.getCourseId();
        this.teacherId = course.getTeacherId();
        this.isApproval = course.isApproval();
    }

    public Course(String courseName, String courseDes, int courseNum,
                  String courseId, String teacherId) {
        this.courseName = courseName;
        this.courseDes = courseDes;
        this.courseNum = courseNum;
        this.courseId = courseId;
        this.teacherId = teacherId;
        this.isApproval = false;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDes() {
        return courseDes;
    }

    public void setCourseDes(String courseDes) {
        this.courseDes = courseDes;
    }

    public int getCourseNum() {
        return courseNum;
    }

    public void setCourseNum(int courseNum) {
        this.courseNum = courseNum;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public boolean isApproval() {
        return isApproval;
    }

    public void setApproval(boolean approval) {
        isApproval = approval;
    }


    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", courseDes='" + courseDes + '\'' +
                ", courseNum=" + courseNum +
                ", courseId='" + courseId + '\'' +
                ", teacherId='" + teacherId + '\'' +
                ", isApproval=" + isApproval +
                '}';
    }
}
