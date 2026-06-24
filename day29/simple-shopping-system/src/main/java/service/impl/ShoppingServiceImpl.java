package service.impl;

import java.math.BigDecimal;
import java.util.List;

import dao.CartItemDao;
import dao.ProductDao;
import dao.impl.CartItemDaoImpl;
import dao.impl.ProductDaoImpl;
import exception.AppException;
import model.CartItem;
import model.Product;
import service.ShoppingService;

public class ShoppingServiceImpl implements ShoppingService {
    private final ProductDao productDao = new ProductDaoImpl();
    private final CartItemDao cartItemDao = new CartItemDaoImpl();

    @Override
    public void createProduct(Product product) {
        validateProduct(product);
        productDao.insert(product);
    }

    @Override
    public void updateProduct(Product product) {
        if (product.getId() == null) {
            throw new AppException("請先選擇要修改的商品");
        }
        validateProduct(product);
        productDao.update(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        if (id == null) {
            throw new AppException("請先選擇要刪除的商品");
        }
        productDao.deleteById(id);
    }

    @Override
    public List<Product> findAllProducts() {
        return productDao.findAll();
    }

    @Override
    public void addToCart(Integer memberId, Integer productId, Integer quantity) {
        validateCart(memberId, productId, quantity);
        Product product = productDao.findById(productId);
        if (product == null) {
            throw new AppException("商品不存在");
        }
        if (quantity > product.getStock()) {
            throw new AppException("加入數量不可大於庫存");
        }
        cartItemDao.insert(new CartItem(null, memberId, productId, product.getName(), product.getPrice(), quantity));
    }

    @Override
    public void updateCartQuantity(Integer cartItemId, Integer quantity) {
        if (cartItemId == null) {
            throw new AppException("請先選擇購物車項目");
        }
        if (quantity == null || quantity <= 0) {
            throw new AppException("數量必須大於 0");
        }
        cartItemDao.updateQuantity(cartItemId, quantity);
    }

    @Override
    public void deleteCartItem(Integer cartItemId) {
        if (cartItemId == null) {
            throw new AppException("請先選擇購物車項目");
        }
        cartItemDao.deleteById(cartItemId);
    }

    @Override
    public List<CartItem> findCart(Integer memberId) {
        if (memberId == null) {
            throw new AppException("會員不存在");
        }
        return cartItemDao.findByMemberId(memberId);
    }

    @Override
    public BigDecimal calculateTotal(Integer memberId) {
        return findCart(memberId).stream()
                .map(CartItem::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public void checkout(Integer memberId) {
        if (findCart(memberId).isEmpty()) {
            throw new AppException("購物車目前沒有資料");
        }
        cartItemDao.clearByMemberId(memberId);
    }

    private void validateProduct(Product product) {
        if (product == null) {
            throw new AppException("商品資料不可為空");
        }
        if (product.getName() == null || product.getName().trim().isEmpty()) {
            throw new AppException("商品名稱不可空白");
        }
        if (product.getPrice() == null || product.getPrice().compareTo(BigDecimal.ZERO) < 0) {
            throw new AppException("商品價格不可小於 0");
        }
        if (product.getStock() == null || product.getStock() < 0) {
            throw new AppException("商品庫存不可小於 0");
        }
    }

    private void validateCart(Integer memberId, Integer productId, Integer quantity) {
        if (memberId == null) {
            throw new AppException("會員不存在");
        }
        if (productId == null) {
            throw new AppException("請先選擇商品");
        }
        if (quantity == null || quantity <= 0) {
            throw new AppException("數量必須大於 0");
        }
    }
}
