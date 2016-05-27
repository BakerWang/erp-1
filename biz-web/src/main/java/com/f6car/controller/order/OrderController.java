package com.f6car.controller.order;

import com.f6car.biz.order.so.OrderSo;
import com.f6car.biz.order.vo.OrderVo;
import com.f6car.controller.order.base.BaseController;
import com.f6car.mapper.order.OrderRepository;
import com.f6car.model.Order;
import com.f6car.service.order.OrderService;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by qixiaobo on 16/5/17.
 */
@RequestMapping("/orders")
public class OrderController extends BaseController<Integer,OrderVo,OrderSo,Order,OrderRepository,OrderService>{

}
