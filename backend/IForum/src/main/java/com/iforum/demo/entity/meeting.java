package com.iforum.demo.entity;

public class meeting {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column meeting.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column meeting.title
     *
     * @mbg.generated
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column meeting.agenda
     *
     * @mbg.generated
     */
    private String agenda;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column meeting.chairmanid
     *
     * @mbg.generated
     */
    private Integer chairmanid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column meeting.time
     *
     * @mbg.generated
     */
    private String time;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column meeting.id
     *
     * @return the value of meeting.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column meeting.id
     *
     * @param id the value for meeting.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column meeting.title
     *
     * @return the value of meeting.title
     *
     * @mbg.generated
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column meeting.title
     *
     * @param title the value for meeting.title
     *
     * @mbg.generated
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column meeting.agenda
     *
     * @return the value of meeting.agenda
     *
     * @mbg.generated
     */
    public String getAgenda() {
        return agenda;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column meeting.agenda
     *
     * @param agenda the value for meeting.agenda
     *
     * @mbg.generated
     */
    public void setAgenda(String agenda) {
        this.agenda = agenda == null ? null : agenda.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column meeting.chairmanid
     *
     * @return the value of meeting.chairmanid
     *
     * @mbg.generated
     */
    public Integer getChairmanid() {
        return chairmanid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column meeting.chairmanid
     *
     * @param chairmanid the value for meeting.chairmanid
     *
     * @mbg.generated
     */
    public void setChairmanid(Integer chairmanid) {
        this.chairmanid = chairmanid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column meeting.time
     *
     * @return the value of meeting.time
     *
     * @mbg.generated
     */
    public String getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column meeting.time
     *
     * @param time the value for meeting.time
     *
     * @mbg.generated
     */
    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }
}