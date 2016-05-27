package com.f6car.model.base;

import com.f6car.enums.OperateType;

import java.io.Serializable;
import java.util.Date;

import se.spagettikod.optimist.Identity;
import se.spagettikod.optimist.Version;


/**
 * Created by qixiaobo on 16/5/17.
 */
public abstract class BaseModel<PK extends Serializable> implements Serializable {

    private Boolean deleteFlag;

    private Integer updateUserId;

    private Integer createUserId;

    private Date createDate;

    private Date updateDate;

    @Version("version")
    private Integer version;

    private OperateType operate;


    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Integer getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public OperateType getOperate() {
        return operate;
    }

    public void setOperate(OperateType operate) {
        this.operate = operate;
    }

    public abstract PK getId();
}