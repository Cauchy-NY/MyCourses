package cn.cauchyny.mycourses.dto;

public class WebStatisticsDto {
    private int studentNum;
    private int teacherNum;
    private int courseNum;
    private int courseRecordNum;
    private int homeworkNum;

    public WebStatisticsDto() {}

    public WebStatisticsDto(int studentNum, int teacherNum, int courseNum,
                            int courseRecordNum, int homeworkNum) {
        this.studentNum = studentNum;
        this.teacherNum = teacherNum;
        this.courseNum = courseNum;
        this.courseRecordNum = courseRecordNum;
        this.homeworkNum = homeworkNum;
    }

    public int getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(int studentNum) {
        this.studentNum = studentNum;
    }

    public int getTeacherNum() {
        return teacherNum;
    }

    public void setTeacherNum(int teacherNum) {
        this.teacherNum = teacherNum;
    }

    public int getCourseNum() {
        return courseNum;
    }

    public void setCourseNum(int courseNum) {
        this.courseNum = courseNum;
    }

    public int getCourseRecordNum() {
        return courseRecordNum;
    }

    public void setCourseRecordNum(int courseRecordNum) {
        this.courseRecordNum = courseRecordNum;
    }

    public int getHomeworkNum() {
        return homeworkNum;
    }

    public void setHomeworkNum(int homeworkNum) {
        this.homeworkNum = homeworkNum;
    }
}
