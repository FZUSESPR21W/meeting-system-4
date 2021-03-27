package com.iforum.demo.entity;

public class zkNeed2 {

    private String meetingTitle;
    private int num;

    @Override
    public String toString() {
        return "zkNeed2{" +
                "meetingTitle='" + meetingTitle + '\'' +
                ", num=" + num +
                '}';
    }

    public String getMeetingTitle() {
        return meetingTitle;
    }

    public void setMeetingTitle(String meetingTitle) {
        this.meetingTitle = meetingTitle;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
