package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.MemberDao;
import exception.AppException;
import model.Member;
import util.DbUtil;

public class MemberDaoImpl implements MemberDao {

    @Override
    public Member login(String username, String password) {
        String sql = "SELECT * FROM members WHERE username = ? AND password = ?";
        try (Connection conn = DbUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return map(rs);
                }
            }
        } catch (SQLException e) {
            throw new AppException("會員登入查詢失敗", e);
        }
        return null;
    }

    @Override
    public void insert(Member member) {
        String sql = "INSERT INTO members(username, password, name, email, phone, role) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DbUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, member.getUsername());
            ps.setString(2, member.getPassword());
            ps.setString(3, member.getName());
            ps.setString(4, member.getEmail());
            ps.setString(5, member.getPhone());
            ps.setString(6, member.getRole());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new AppException("新增會員失敗，帳號可能已存在", e);
        }
    }

    @Override
    public void update(Member member) {
        String sql = "UPDATE members SET username = ?, password = ?, name = ?, email = ?, phone = ?, role = ? WHERE id = ?";
        try (Connection conn = DbUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, member.getUsername());
            ps.setString(2, member.getPassword());
            ps.setString(3, member.getName());
            ps.setString(4, member.getEmail());
            ps.setString(5, member.getPhone());
            ps.setString(6, member.getRole());
            ps.setInt(7, member.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new AppException("修改會員失敗", e);
        }
    }

    @Override
    public void deleteById(Integer id) {
        String sql = "DELETE FROM members WHERE id = ?";
        try (Connection conn = DbUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new AppException("刪除會員失敗", e);
        }
    }

    @Override
    public Member findById(Integer id) {
        String sql = "SELECT * FROM members WHERE id = ?";
        try (Connection conn = DbUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return map(rs);
                }
            }
        } catch (SQLException e) {
            throw new AppException("查詢會員失敗", e);
        }
        return null;
    }

    @Override
    public List<Member> findAll() {
        List<Member> list = new ArrayList<>();
        String sql = "SELECT * FROM members ORDER BY id";
        try (Connection conn = DbUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(map(rs));
            }
        } catch (SQLException e) {
            throw new AppException("查詢會員清單失敗", e);
        }
        return list;
    }

    private Member map(ResultSet rs) throws SQLException {
        return new Member(
                rs.getInt("id"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("name"),
                rs.getString("email"),
                rs.getString("phone"),
                rs.getString("role"),
                rs.getTimestamp("created_at"));
    }
}
