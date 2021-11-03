package com.movierating.model.people;

public class PeopleDTO {
    private int pid;
    private String name;
    private String profileImageUrl;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public PeopleDTO() {
    }

    public PeopleDTO(int pid, String name, String profileImageUrl) {
        this.pid = pid;
        this.name = name;
        this.profileImageUrl = profileImageUrl;
    }

    public PeopleDTO(String name, String profileImageUrl) {
        this.name = name;
        this.profileImageUrl = profileImageUrl;
    }
}
