package cn.cauchyny.mycourses.model;

public class Selection {

    private String studentId;

    private int courseRecordId;

    private double grade;

    public Selection() {}

    public Selection(String studentId, int courseRecordId, double grade) {
        this.studentId = studentId;
        this.courseRecordId = courseRecordId;
        this.grade = grade;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getCourseRecordId() {
        return courseRecordId;
    }

    public void setCourseRecordId(int courseRecordId) {
        this.courseRecordId = courseRecordId;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Selection{" +
                "studentId='" + studentId + '\'' +
                ", courseRecordId=" + courseRecordId +
                ", grade=" + grade +
                '}';
    }
}
