package com.cts.pm.project;

public class ProjectFilter {

    private int id;
    private String name;
    private String subStageName;
    private String stageName;

    public ProjectFilter() {
    }

    public ProjectFilter(int id, String name, String subStageName, String stageName) {
        this.id = id;
        this.name = name;
        this.subStageName = subStageName;
        this.stageName = stageName;
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public String getSubStageName() {
        return subStageName;
    }

    public void setSubStageName(String subStageName) {
        this.subStageName = subStageName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
