package com.f6car.mapper.order;

import com.f6car.biz.order.so.OrderSo;
import com.f6car.mapper.base.BaseRepository;
import com.f6car.model.Order;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface OrderRepository extends BaseRepository<Order,OrderSo,Integer>{

}
