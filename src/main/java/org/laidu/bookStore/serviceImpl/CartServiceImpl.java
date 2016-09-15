package org.laidu.bookStore.serviceImpl;

import org.laidu.bookStore.mapper.CartMapper;
import org.laidu.bookStore.model.CartModel;
import org.laidu.bookStore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by laidu on 16-9-13.
 */
@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartMapper cartMapper;

    @Override
    public int addCart(CartModel cartModel) {
        return cartMapper.insertSelective(cartModel);
    }

    @Override
    public int delCart(int id) {
        return cartMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int clean(int uid) {
        return cartMapper.cleanByUid(uid);
    }

    @Override
    public List<CartModel> findListByUid(int uid) {

        List<CartModel> cartModel = cartMapper.findListByUid(uid);
        for(int i=0;i<cartModel.size();i++){
            for(int j=i+1;j<cartModel.size();j++){
                if(cartModel.get(i).getBid()==cartModel.get(j).getBid()&&cartModel.get(i).getBid()==cartModel.get(j).getBid()){
                    cartModel.get(i).setCounts(cartModel.get(i).getCounts()+cartModel.get(j).getCounts());
                    cartModel.get(i).setTotalprice(cartModel.get(i).getTotalprice()+cartModel.get(j).getTotalprice());
                    cartModel.remove(j);
                    j--;
                }
            }
        }
        return cartModel;
    }

    @Override
    public CartModel findDetial(int id) {
        return (CartModel) cartMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateCart(CartModel cartModel) {
        return cartMapper.updateByPrimaryKeySelective(cartModel);
    }

    @Override
    public int delCartByBid(int uid,int bid) {
        return cartMapper.delCartByBid(uid, bid);
    }
}
