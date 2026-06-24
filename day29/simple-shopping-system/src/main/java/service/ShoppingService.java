package service;

import java.math.BigDecimal;
import java.util.List;

import model.CartItem;
import model.Product;

public interface ShoppingService {
    void createProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(Integer id);

    List<Product> findAllProducts();

    void addToCart(Integer memberId, Integer productId, Integer quantity);

    void updateCartQuantity(Integer cartItemId, Integer quantity);

    void deleteCartItem(Integer cartItemId);

    List<CartItem> findCart(Integer memberId);

    BigDecimal calculateTotal(Integer memberId);

    void checkout(Integer memberId);
}
