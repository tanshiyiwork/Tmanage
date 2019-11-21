package com.github.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "SYS_LOG")
public class SysLog {
    private String stId;
    private String requestIp;
    private Integer type;
    private String userName;
    private String description;
    private String actionMethod;
    private String actionUrl;
    private String params;
    private String ua;
    private String classPath;
    private String requestMethod;
    private Timestamp startTime;
    private Timestamp finishTime;
    private Long consumingTime;
    private String exDesc;
    private String exDetail;

    @Id
    @Column(name = "ST_ID", nullable = false, length = 50)
    public String getStId() {
        return stId;
    }

    public void setStId(String stId) {
        this.stId = stId;
    }

    @Basic
    @Column(name = "REQUEST_IP", nullable = true, length = 50)
    public String getRequestIp() {
        return requestIp;
    }

    public void setRequestIp(String requestIp) {
        this.requestIp = requestIp;
    }

    @Basic
    @Column(name = "TYPE", nullable = true)
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Basic
    @Column(name = "USER_NAME", nullable = true, length = 20)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "DESCRIPTION", nullable = true, length = 50)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "ACTION_METHOD", nullable = true, length = 50)
    public String getActionMethod() {
        return actionMethod;
    }

    public void setActionMethod(String actionMethod) {
        this.actionMethod = actionMethod;
    }

    @Basic
    @Column(name = "ACTION_URL", nullable = true, length = 50)
    public String getActionUrl() {
        return actionUrl;
    }

    public void setActionUrl(String actionUrl) {
        this.actionUrl = actionUrl;
    }

    @Basic
    @Column(name = "PARAMS", nullable = true, length = 1000)
    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    @Basic
    @Column(name = "UA", nullable = true, length = 500)
    public String getUa() {
        return ua;
    }

    public void setUa(String ua) {
        this.ua = ua;
    }

    @Basic
    @Column(name = "CLASS_PATH", nullable = true, length = 255)
    public String getClassPath() {
        return classPath;
    }

    public void setClassPath(String classPath) {
        this.classPath = classPath;
    }

    @Basic
    @Column(name = "REQUEST_METHOD", nullable = true, length = 10)
    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    @Basic
    @Column(name = "START_TIME", nullable = true)
    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "FINISH_TIME", nullable = true)
    public Timestamp getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Timestamp finishTime) {
        this.finishTime = finishTime;
    }

    @Basic
    @Column(name = "CONSUMING_TIME", nullable = true)
    public Long getConsumingTime() {
        return consumingTime;
    }

    public void setConsumingTime(Long consumingTime) {
        this.consumingTime = consumingTime;
    }

    @Basic
    @Column(name = "EX_DESC", nullable = true, length = 1000)
    public String getExDesc() {
        return exDesc;
    }

    public void setExDesc(String exDesc) {
        this.exDesc = exDesc;
    }

    @Basic
    @Column(name = "EX_DETAIL", nullable = true, length = -1)
    public String getExDetail() {
        return exDetail;
    }

    public void setExDetail(String exDetail) {
        this.exDetail = exDetail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysLog sysLog = (SysLog) o;
        return Objects.equals(stId, sysLog.stId) &&
                Objects.equals(requestIp, sysLog.requestIp) &&
                Objects.equals(type, sysLog.type) &&
                Objects.equals(userName, sysLog.userName) &&
                Objects.equals(description, sysLog.description) &&
                Objects.equals(actionMethod, sysLog.actionMethod) &&
                Objects.equals(actionUrl, sysLog.actionUrl) &&
                Objects.equals(params, sysLog.params) &&
                Objects.equals(ua, sysLog.ua) &&
                Objects.equals(classPath, sysLog.classPath) &&
                Objects.equals(requestMethod, sysLog.requestMethod) &&
                Objects.equals(startTime, sysLog.startTime) &&
                Objects.equals(finishTime, sysLog.finishTime) &&
                Objects.equals(consumingTime, sysLog.consumingTime) &&
                Objects.equals(exDesc, sysLog.exDesc) &&
                Objects.equals(exDetail, sysLog.exDetail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stId, requestIp, type, userName, description, actionMethod, actionUrl, params, ua, classPath, requestMethod, startTime, finishTime, consumingTime, exDesc, exDetail);
    }
}
