package com.f6car.model;

import com.f6car.model.base.BaseModel;
import se.spagettikod.optimist.Identity;
import se.spagettikod.optimist.OptimisticLocking;

/**
 * Created by qixiaobo on 16/5/17.
 */
@OptimisticLocking("s_order")
public class Order extends BaseModel<Integer>{
    private static final long serialVersionUID = -1L;

    @Identity("id")
    private Integer id;

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
