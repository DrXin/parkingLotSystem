package com.drx.dto;

import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Alias("tokenMsg")
public class TokenMsg {
    private String licenseNum;
    private Long tokenNum;
    private Date beginTime;
    private Date endTime;

    public String getLicenseNum() {
        return licenseNum;
    }

    public void setLicenseNum(String licenseNum) {
        this.licenseNum = licenseNum;
    }

    public Long getTokenNum() {
        return tokenNum;
    }

    public void setTokenNum(Long tokenNum) {
        this.tokenNum = tokenNum;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
