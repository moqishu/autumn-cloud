package com.natsucloud.appshop.service.impl;

import com.natsucloud.appshop.entity.Order;
import com.natsucloud.appshop.mapper.OrderMapper;
import com.natsucloud.appshop.service.IOrderService;
import com.opencloud.common.mybatis.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author moQiShu
 * @since 2020-04-09
 */
@Service
public class OrderServiceImpl extends BaseServiceImpl<OrderMapper, Order> implements IOrderService {

}
