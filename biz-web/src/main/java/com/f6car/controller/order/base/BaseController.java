package com.f6car.controller.order.base;

import com.f6car.common.query.BaseSo;
import com.f6car.common.query.BaseVo;
import com.f6car.common.response.BaseResponse;
import com.f6car.common.response.PackResponse;
import com.f6car.common.response.Response;
import com.f6car.mapper.base.BaseRepository;
import com.f6car.model.base.BaseModel;
import com.f6car.service.base.BaseService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

/**
 * Created by qixiaobo on 16/5/21.
 */
@RestController
public abstract class BaseController<PK extends Serializable, VO extends BaseVo, SO extends BaseSo, PO extends BaseModel<PK>, Rep extends BaseRepository<PO, SO, PK>, Service extends BaseService<VO, SO, PK, PO, Rep>> {

    protected Service service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public BaseResponse findById(@PathVariable PK id) {
        return new Response<VO>(service.findById(id));
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public PackResponse<VO> search(SO so) {
        return new PackResponse<VO>(service.searchBySo(so));
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public BaseResponse create(VO vo) {
        return new Response<VO>(service.createReturnVo(vo));
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public BaseResponse delete(PK pk) {
        int deletes = service.deleteById(pk);
        Response<VO> rep = new Response<VO>();
        rep.setUdf1(deletes);
        return rep;
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public BaseResponse update(VO vo) {
        return new Response<VO>(service.updateVo(vo));
    }


}
