package org.laidu.bookStore.mapper;

import org.laidu.bookStore.domain.Order;
import org.laidu.bookStore.model.OrderModel;
import org.laidu.bookStore.model.OrderdetailModel;

import java.util.List;

public interface OrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders
     *
     * @mbg.generated Mon Sep 12 23:32:28 GMT+08:00 2016
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders
     *
     * @mbg.generated Mon Sep 12 23:32:28 GMT+08:00 2016
     */
    int insert(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders
     *
     * @mbg.generated Mon Sep 12 23:32:28 GMT+08:00 2016
     */
    int insertSelective(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders
     *
     * @mbg.generated Mon Sep 12 23:32:28 GMT+08:00 2016
     */
    OrderModel selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders
     *
     * @mbg.generated Mon Sep 12 23:32:28 GMT+08:00 2016
     */
    int updateByPrimaryKeySelective(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders
     *
     * @mbg.generated Mon Sep 12 23:32:28 GMT+08:00 2016
     */
    int updateByPrimaryKey(Order record);

    List<OrderModel> findListByUid(int uid);

}