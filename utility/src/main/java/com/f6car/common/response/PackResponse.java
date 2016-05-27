package com.f6car.common.response;

import com.f6car.common.query.BaseVo;

import java.util.List;

/**
 * Created by qixiaobo on 16/5/21.
 */
public class PackResponse<VO extends BaseVo> extends BaseResponse{

    private List<VO> vos;


    public PackResponse() {
    }

    public PackResponse(List<VO> entities) {
        this.vos = entities;
    }

    public List<VO> getVos() {
        return vos;
    }

    public void setVos(List<VO> vos) {
        this.vos = vos;
    }
}
