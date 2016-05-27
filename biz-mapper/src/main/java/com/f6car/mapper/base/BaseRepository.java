package com.f6car.mapper.base;

import com.f6car.common.query.BaseSo;
import com.f6car.model.base.BaseModel;

import java.io.Serializable;
import java.util.List;

/**
 * Created by qixiaobo on 16/5/19.
 */
public interface BaseRepository<PO extends BaseModel, SO extends BaseSo, PK extends Serializable> {

    PO findById(PK pk);

    int deleteById(PK pk);

    int updatePo(PO po);

    PK createReturnPK(PO po);

    long countBySo(SO so);

    List<PO> searchBySo(SO so);
}
