package cn.cauchyny.mycourses.model;

public class Discussion {
    private String id;
    private String userId;
    private String userType;
    private String title;
    private String content;
    private int seq;
    private int ansTo;
    private boolean hasTitle;

    public Discussion() {}

    public Discussion(String id, String userId, String userType, String title,
                      String content, int seq, int ansTo, boolean hasTitle) {
        this.id = id;
        this.userId = userId;
        this.userType = userType;
        this.title = title;
        this.content = content;
        this.seq = seq;
        this.ansTo = ansTo;
        this.hasTitle = hasTitle;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public int getAnsTo() {
        return ansTo;
    }

    public void setAnsTo(int ansTo) {
        this.ansTo = ansTo;
    }

    public boolean isHasTitle() {
        return hasTitle;
    }

    public void setHasTitle(boolean hasTitle) {
        this.hasTitle = hasTitle;
    }

    @Override
    public String toString() {
        return "Discussion{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", userType='" + userType + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", seq=" + seq +
                ", ansTo=" + ansTo +
                ", hasTitle=" + hasTitle +
                '}';
    }
}
