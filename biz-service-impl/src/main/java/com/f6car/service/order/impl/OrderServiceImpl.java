package com.f6car.service.order.impl;

import com.f6car.biz.order.so.OrderSo;
import com.f6car.biz.order.vo.OrderVo;
import com.f6car.mapper.order.OrderRepository;
import com.f6car.model.Order;
import com.f6car.service.order.OrderService;
import com.f6car.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


/**
 * Created by qixiaobo on 16/5/17.
 */
@Service("orderService")
public class OrderServiceImpl extends BaseServiceImpl<OrderVo,OrderSo,Integer,Order,OrderRepository> implements OrderService{


}
