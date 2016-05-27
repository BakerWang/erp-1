package com.f6car.service.base;

import com.f6car.common.query.BaseSo;
import com.f6car.common.query.BaseVo;
import com.f6car.mapper.base.BaseRepository;
import com.f6car.model.base.BaseModel;
import com.f6car.utitly.OrikaBeanUtil;
import com.google.common.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * Created by qixiaobo on 16/5/19.
 */
@SuppressWarnings("unchecked")
public abstract class BaseServiceImpl<VO extends BaseVo, SO extends BaseSo, PK extends Serializable, PO extends BaseModel<PK>, Rep extends BaseRepository<PO, SO, PK>> implements BaseService<VO, SO, PK, PO, Rep> {

    @Autowired
    protected Rep rep;

    private TypeToken<PO> poType = new TypeToken<PO>(getClass()) {
    };

    private TypeToken<VO> voType = new TypeToken<VO>(getClass()) {
    };

    public VO findById(PK pk) {
        PO po = rep.findById(pk);
        return (VO) OrikaBeanUtil.convert(po, voType.getRawType());
    }

    public int deleteById(PK pk) {
        return rep.deleteById(pk);
    }

    public VO updateVo(VO vo) {
        PO po = (PO) OrikaBeanUtil.convert(vo, poType.getRawType());
        rep.updatePo(po);
        po = rep.findById(po.getId());
        return (VO) OrikaBeanUtil.convert(po, voType.getRawType());
    }

    public VO createReturnVo(VO vo) {
        PO po = (PO) OrikaBeanUtil.convert(vo, poType.getRawType());
        PK id = rep.createReturnPK(po);
        po = rep.findById(id);
        return (VO) OrikaBeanUtil.convert(po, voType.getRawType());
    }

    public long countBySo(SO so) {
        return rep.countBySo(so);
    }

    public List<VO> searchBySo(SO so) {
        List<PO> pos = rep.searchBySo(so);
        return (List<VO>) OrikaBeanUtil.convertList(pos, voType.getRawType());
    }
}
