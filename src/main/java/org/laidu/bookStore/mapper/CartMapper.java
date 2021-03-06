package org.laidu.bookStore.mapper;

import org.laidu.bookStore.domain.Cart;
import org.laidu.bookStore.model.CartModel;

import java.util.List;

public interface CartMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cart
     *
     * @mbg.generated Mon Sep 12 23:32:28 GMT+08:00 2016
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cart
     *
     * @mbg.generated Mon Sep 12 23:32:28 GMT+08:00 2016
     */
    int insert(Cart record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cart
     *
     * @mbg.generated Mon Sep 12 23:32:28 GMT+08:00 2016
     */
    int insertSelective(Cart record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cart
     *
     * @mbg.generated Mon Sep 12 23:32:28 GMT+08:00 2016
     */
    Cart selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cart
     *
     * @mbg.generated Mon Sep 12 23:32:28 GMT+08:00 2016
     */
    int updateByPrimaryKeySelective(Cart record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cart
     *
     * @mbg.generated Mon Sep 12 23:32:28 GMT+08:00 2016
     */
    int updateByPrimaryKey(Cart record);

    List<CartModel> findListByUid(int uid);

    int cleanByUid(int uid);

    int delCartByBid(int uid, int bid);
}