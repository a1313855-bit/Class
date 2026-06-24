package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import exception.AppException;

public class DbUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/simple_shop?serverTimezone=Asia/Taipei&useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    private DbUtil() {
    }

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new AppException("找不到 MySQL JDBC Driver", e);
        } catch (SQLException e) {
            throw new AppException("資料庫連線失敗，請確認 MySQL、帳號、密碼與 schema.sql 是否已建立", e);
        }
    }
}
