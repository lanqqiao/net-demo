package com.lqq.demo.model.Flyweight;

//经理
public class Manager implements Employee {

    //所在部门
    private String department;
    //报告内容
    private String reportContent;


    public Manager(String department) {
        this.department = department;
    }

    @Override
    public void report() {
        System.out.println(reportContent);
    }

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }
}