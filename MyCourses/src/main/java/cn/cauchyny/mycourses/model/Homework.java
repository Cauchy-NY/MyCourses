package cn.cauchyny.mycourses.model;

import java.util.Date;

public class Homework {

    private int id;

    private int recordId;

    private String title;

    private Date endTime;

    private String state;

    public Homework() {}

    public Homework(int id, int recordId, String title, Date endTime, String state) {
        this.id = id;
        this.recordId = recordId;
        this.title = title;
        this.endTime = endTime;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Homework{" +
                "id=" + id +
                ", recordId=" + recordId +
                ", title='" + title + '\'' +
                ", endTime=" + endTime +
                ", state='" + state + '\'' +
                '}';
    }
}
