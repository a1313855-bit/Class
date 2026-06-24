package controller;

import java.math.BigDecimal;
import java.util.List;

import model.CartItem;
import model.Product;
import service.ShoppingService;
import service.impl.ShoppingServiceImpl;

public class ShoppingController {
    private final ShoppingService shoppingService = new ShoppingServiceImpl();

    public List<Product> findAllProducts() {
        return shoppingService.findAllProducts();
    }

    public void createProduct(Product product) {
        shoppingService.createProduct(product);
    }

    public void updateProduct(Product product) {
        shoppingService.updateProduct(product);
    }

    public void deleteProduct(Integer id) {
        shoppingService.deleteProduct(id);
    }

    public void addToCart(Integer memberId, Integer productId, Integer quantity) {
        shoppingService.addToCart(memberId, productId, quantity);
    }

    public void updateCartQuantity(Integer cartItemId, Integer quantity) {
        shoppingService.updateCartQuantity(cartItemId, quantity);
    }

    public void deleteCartItem(Integer cartItemId) {
        shoppingService.deleteCartItem(cartItemId);
    }

    public List<CartItem> findCart(Integer memberId) {
        return shoppingService.findCart(memberId);
    }

    public BigDecimal calculateTotal(Integer memberId) {
        return shoppingService.calculateTotal(memberId);
    }

    public void checkout(Integer memberId) {
        shoppingService.checkout(memberId);
    }
}
