package dao;

import java.util.List;

import model.CartItem;

public interface CartItemDao {
    void insert(CartItem item);

    void updateQuantity(Integer id, Integer quantity);

    void deleteById(Integer id);

    List<CartItem> findByMemberId(Integer memberId);

    void clearByMemberId(Integer memberId);
}
