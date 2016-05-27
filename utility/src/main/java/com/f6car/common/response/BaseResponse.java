package com.f6car.common.response;

/**
 * Created by qixiaobo on 16/5/21.
 */
public abstract class BaseResponse {

    private int status = 0;
    private String message;
    private int udf1;//eg return count
    private long udf2;
    private double udf3;
    private boolean udf4;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getUdf1() {
        return udf1;
    }

    public void setUdf1(int udf1) {
        this.udf1 = udf1;
    }

    public long getUdf2() {
        return udf2;
    }

    public void setUdf2(long udf2) {
        this.udf2 = udf2;
    }

    public double getUdf3() {
        return udf3;
    }

    public void setUdf3(double udf3) {
        this.udf3 = udf3;
    }

    public boolean isUdf4() {
        return udf4;
    }

    public void setUdf4(boolean udf4) {
        this.udf4 = udf4;
    }
}
