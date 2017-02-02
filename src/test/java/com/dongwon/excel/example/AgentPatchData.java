package com.dongwon.excel.example;

public class AgentPatchData {
    private String name;
    private String computer;
    private String dep1;
    private String dep2;
    private String dep3;
    private String dep4;
    private int applyCount;
    private int notApplyCount;

    public AgentPatchData() {
    }

    public AgentPatchData(String name, String computer, String dep1, String dep2, String dep3, String dep4, int applyCount, int notApplyCount) {
        this.name = name;
        this.computer = computer;
        this.dep1 = dep1;
        this.dep2 = dep2;
        this.dep3 = dep3;
        this.dep4 = dep4;
        this.applyCount = applyCount;
        this.notApplyCount = notApplyCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComputer() {
        return computer;
    }

    public void setComputer(String computer) {
        this.computer = computer;
    }

    public String getDep1() {
        return dep1;
    }

    public void setDep1(String dep1) {
        this.dep1 = dep1;
    }

    public String getDep2() {
        return dep2;
    }

    public void setDep2(String dep2) {
        this.dep2 = dep2;
    }

    public String getDep3() {
        return dep3;
    }

    public void setDep3(String dep3) {
        this.dep3 = dep3;
    }

    public String getDep4() {
        return dep4;
    }

    public void setDep4(String dep4) {
        this.dep4 = dep4;
    }

    public int getApplyCount() {
        return applyCount;
    }

    public void setApplyCount(int applyCount) {
        this.applyCount = applyCount;
    }

    public int getNotApplyCount() {
        return notApplyCount;
    }

    public void setNotApplyCount(int notApplyCount) {
        this.notApplyCount = notApplyCount;
    }
}
