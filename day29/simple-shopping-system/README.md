# Simple Shopping System

Java SE + Swing(WindowBuilder) + MySQL 8.0 + Maven 範例。

## 開發環境

- JDK 11
- MySQL 8.0
- Eclipse IDE for Java Developers 或 Eclipse Java EE
- WindowBuilder
- Maven Project

## 專案架構

```text
src/main/java
├── model
├── dao
│   └── impl
├── service
│   └── impl
├── controller
├── util
├── exception
└── view
```

## 功能

- 會員登入
- 會員 CRUD
- 商品 CRUD
- 購物車 CRUD：加入商品、修改數量、刪除購物項目、結帳清空購物車

## 資料庫設定

1. 開啟 MySQL 8.0。
2. 執行 `src/main/resources/db/schema.sql`。
3. 預設連線設定在 `src/main/java/util/DbUtil.java`：

```java
private static final String URL = "jdbc:mysql://localhost:3306/simple_shop";
private static final String USER = "root";
private static final String PASSWORD = "1234";
```

如果你的 MySQL 密碼不是 `1234`，請修改 `DbUtil.java`。

## Eclipse 匯入方式

1. Eclipse 選擇 `File -> Import`。
2. 選擇 `Existing Maven Projects`。
3. 選擇本專案資料夾 `simple-shopping-system`。
4. 等 Maven 載入完成。
5. 執行 `controller.AppLauncher`。

## 測試帳號

| 帳號 | 密碼 | 說明 |
|---|---|---|
| admin | admin123 | 管理者 |
| user | user123 | 一般會員 |

