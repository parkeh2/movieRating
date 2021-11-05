package com.movierating.model.casting;

public class CastingDTO {
    private int movieNo;
    private int pid;
    private String name;
    private String profileImageUrl;
    private String role;

    public CastingDTO() {
    }

    public CastingDTO(int movieNo, int pid, String name, String profileImageUrl, String role) {
        this.movieNo = movieNo;
        this.pid = pid;
        this.name = name;
        this.profileImageUrl = profileImageUrl;
        this.role = role;
    }

    public CastingDTO(int pid, String name, String profileImageUrl, String role) {
        this.pid = pid;
        this.name = name;
        this.profileImageUrl = profileImageUrl;
        this.role = role;
    }

    public int getMovieNo() {
        return movieNo;
    }

    public void setMovieNo(int movieNo) {
        this.movieNo = movieNo;
    }

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
