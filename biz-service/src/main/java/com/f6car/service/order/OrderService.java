package com.f6car.service.order;

import com.f6car.biz.order.so.OrderSo;
import com.f6car.biz.order.vo.OrderVo;
import com.f6car.mapper.order.OrderRepository;
import com.f6car.model.Order;
import com.f6car.service.base.BaseService;

import java.util.List;

/**
 * Created by qixiaobo on 16/5/17.
 */
public interface OrderService extends BaseService<OrderVo,OrderSo,Integer,Order,OrderRepository>{

}
