package com.f6car.common.response;

import com.f6car.common.query.BaseVo;

/**
 * Created by qixiaobo on 16/5/21.
 */
public class Response<VO extends BaseVo> extends BaseResponse {

    private VO vo;

    public Response(){

    }

    public Response(VO entity) {
        this.vo = entity;
    }

    public VO getVo() {
        return vo;
    }

    public void setVo(VO vo) {
        this.vo = vo;
    }
}
