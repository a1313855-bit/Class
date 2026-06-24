package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CartItemDao;
import exception.AppException;
import model.CartItem;
import util.DbUtil;

public class CartItemDaoImpl implements CartItemDao {

    @Override
    public void insert(CartItem item) {
        String sql = "INSERT INTO cart_items(member_id, product_id, quantity) VALUES (?, ?, ?)";
        try (Connection conn = DbUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, item.getMemberId());
            ps.setInt(2, item.getProductId());
            ps.setInt(3, item.getQuantity());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new AppException("加入購物車失敗", e);
        }
    }

    @Override
    public void updateQuantity(Integer id, Integer quantity) {
        String sql = "UPDATE cart_items SET quantity = ? WHERE id = ?";
        try (Connection conn = DbUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, quantity);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new AppException("修改購物車數量失敗", e);
        }
    }

    @Override
    public void deleteById(Integer id) {
        String sql = "DELETE FROM cart_items WHERE id = ?";
        try (Connection conn = DbUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new AppException("刪除購物項目失敗", e);
        }
    }

    @Override
    public List<CartItem> findByMemberId(Integer memberId) {
        List<CartItem> list = new ArrayList<>();
        String sql = "SELECT c.id, c.member_id, c.product_id, p.name, p.price, c.quantity "
                + "FROM cart_items c JOIN products p ON c.product_id = p.id "
                + "WHERE c.member_id = ? ORDER BY c.id";
        try (Connection conn = DbUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, memberId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(new CartItem(
                            rs.getInt("id"),
                            rs.getInt("member_id"),
                            rs.getInt("product_id"),
                            rs.getString("name"),
                            rs.getBigDecimal("price"),
                            rs.getInt("quantity")));
                }
            }
        } catch (SQLException e) {
            throw new AppException("查詢購物車失敗", e);
        }
        return list;
    }

    @Override
    public void clearByMemberId(Integer memberId) {
        String sql = "DELETE FROM cart_items WHERE member_id = ?";
        try (Connection conn = DbUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, memberId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new AppException("清空購物車失敗", e);
        }
    }
}
