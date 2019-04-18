package com.drx.po;

import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Alias("token")
public class Token {
    private int tokenId;
    private Long tokenNum;
    private Date beginTime;
    private Date endTime;
    private int carId;

    public int getTokenId() {
        return tokenId;
    }

    public void setTokenId(int tokenId) {
        this.tokenId = tokenId;
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

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    @Override
    public String toString() {
        return "Token{" +
                "tokenId=" + tokenId +
                ", tokenNum=" + tokenNum +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", carId=" + carId +
                '}';
    }
}
