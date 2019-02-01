package cn.cauchyny.mycourses.model;

public class CourseRecord {

    private int recordId;

    private String courseId;

    private String semester;

    private String year;

    private String classes;

    private boolean isNumLimited;

    private String state;

    private boolean isApproval;

    public CourseRecord() {}

    public CourseRecord(int recordId, String courseId, String semester, String year,
                        String classes, boolean isNumLimited, String state) {
        this.recordId = recordId;
        this.courseId = courseId;
        this.semester = semester;
        this.year = year;
        this.classes = classes;
        this.isNumLimited = isNumLimited;
        this.state = state;
        this.isApproval = false;
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public boolean isNumLimited() {
        return isNumLimited;
    }

    public void setNumLimited(boolean numLimited) {
        isNumLimited = numLimited;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "CourseRecord{" +
                "recordId=" + recordId +
                ", courseId='" + courseId + '\'' +
                ", semester='" + semester + '\'' +
                ", year='" + year + '\'' +
                ", classes='" + classes + '\'' +
                ", isNumLimited=" + isNumLimited +
                ", state='" + state + '\'' +
                '}';
    }
}
