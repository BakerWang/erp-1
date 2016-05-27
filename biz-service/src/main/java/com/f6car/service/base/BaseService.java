package com.f6car.service.base;

import com.f6car.common.query.BaseSo;
import com.f6car.common.query.BaseVo;
import com.f6car.mapper.base.BaseRepository;
import com.f6car.model.base.BaseModel;

import java.io.Serializable;
import java.util.List;

/**
 * Created by qixiaobo on 16/5/19.
 */
public interface BaseService <VO extends BaseVo,SO extends BaseSo,PK extends Serializable,PO extends BaseModel<PK>,Rep extends BaseRepository<PO,SO,PK>>{

    VO findById(PK pk);

    int deleteById(PK pk);

    VO updateVo(VO po);

    VO createReturnVo(VO po);

    long countBySo(SO so);

    List<VO> searchBySo(SO so);

}
