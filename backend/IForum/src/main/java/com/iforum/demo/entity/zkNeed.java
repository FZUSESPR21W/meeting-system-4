package com.iforum.demo.entity;

public class zkNeed {
    private String sForumTitle;
    private String meetingTitle;
    private int meetingId;
    private int sForumSize;

    public zkNeed(){}

    @Override
    public String toString() {
        return "zkNeed{" +
                "sForumTitle='" + sForumTitle + '\'' +
                ", meetingTitle='" + meetingTitle + '\'' +
                ", meetingId='" + meetingId + '\'' +
                ", sForumSize=" + sForumSize +
                '}';
    }

    public String getsForumTitle() {
        return sForumTitle;
    }

    public void setsForumTitle(String sForumTitle) {
        this.sForumTitle = sForumTitle;
    }

    public String getMeetingTitle() {
        return meetingTitle;
    }

    public void setMeetingTitle(String meetingTitle) {
        this.meetingTitle = meetingTitle;
    }

    public int getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(int meetingId) {
        this.meetingId = meetingId;
    }

    public int getsForumSize() {
        return sForumSize;
    }

    public void setsForumSize(int sForumSize) {
        this.sForumSize = sForumSize;
    }

    public zkNeed(String sForumTitle, String meetingTitle, int meetingId, int sForumSize) {
        this.sForumTitle = sForumTitle;
        this.meetingTitle = meetingTitle;
        this.meetingId = meetingId;
        this.sForumSize = sForumSize;
    }
}
