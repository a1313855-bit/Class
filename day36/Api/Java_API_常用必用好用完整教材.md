# Java 常用、必用、好用 API 完整教材

適用環境：JDK 11、Eclipse、Maven、Java SE、WindowBuilder、MVC + DAO Pattern、MySQL、Spring Boot。



## 建議順序

1. `java.lang`：String、StringBuilder、Exception
2. `java.util`：List、Set、Map、Collections、Optional
3. `java.time`：LocalDate、LocalDateTime、DateTimeFormatter
4. `java.math`：BigDecimal
5. `java.io` / `java.nio.file`：檔案讀寫
6. `java.sql`：JDBC + DAO Pattern
7. `java.util.stream` / `java.util.function`：Stream 與 Lambda
8. `java.net.http`：REST API 呼叫
9. `java.util.concurrent`：非同步與背景工作
10. `javax.swing`：WindowBuilder GUI 專案
11. 第三方 API：Jackson、Apache POI、SLF4J、Lombok、JUnit、Mockito、HikariCP
12. Spring Boot API：REST Controller、Validation

## Maven 範例依賴

以下版本為課程範例版本，可依公司環境或專案規範調整。

```xml
<dependencies>
    <!-- MySQL JDBC Driver -->
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <version>8.0.33</version>
    </dependency>

    <!-- Jackson JSON -->
    <dependency>
        <groupId>com.fasterxml.jackson.core</groupId>
        <artifactId>jackson-databind</artifactId>
        <version>2.17.2</version>
    </dependency>

    <!-- Apache POI Excel -->
    <dependency>
        <groupId>org.apache.poi</groupId>
        <artifactId>poi-ooxml</artifactId>
        <version>5.2.5</version>
    </dependency>

    <!-- SLF4J + Logback -->
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-api</artifactId>
        <version>2.0.13</version>
    </dependency>
    <dependency>
        <groupId>ch.qos.logback</groupId>
        <artifactId>logback-classic</artifactId>
        <version>1.5.6</version>
    </dependency>

    <!-- Lombok -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>1.18.32</version>
        <scope>provided</scope>
    </dependency>

    <!-- JUnit 5 -->
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter</artifactId>
        <version>5.10.2</version>
        <scope>test</scope>
    </dependency>

    <!-- Mockito -->
    <dependency>
        <groupId>org.mockito</groupId>
        <artifactId>mockito-core</artifactId>
        <version>5.12.0</version>
        <scope>test</scope>
    </dependency>

    <!-- HikariCP -->
    <dependency>
        <groupId>com.zaxxer</groupId>
        <artifactId>HikariCP</artifactId>
        <version>5.1.0</version>
    </dependency>
</dependencies>
```

---

## Java 基礎核心 API

### 1. String / StringBuilder

- Package：`java.lang`
- 用途：處理文字資料。String 適合固定文字；StringBuilder 適合大量字串組合。
- 常用類別：`String`、`StringBuilder`
- 適用場景：
  - 會員姓名、商品名稱、查詢關鍵字
  - 組合 SQL 片段、報表文字、Log 訊息
- 教學提醒：
  - String 是 immutable，不會直接改變原物件。
  - 大量串接字串時優先用 StringBuilder。

完整範例：

```java
public class StringApiDemo {
    public static void main(String[] args) {
        String name = "Allen";
        String keyword = "  Java API  ";

        System.out.println(name.length());
        System.out.println(keyword.trim());
        System.out.println(keyword.toLowerCase());
        System.out.println(keyword.contains("Java"));

        StringBuilder sb = new StringBuilder();
        sb.append("學員：").append(name).append("\n");
        sb.append("課程：").append(keyword.trim()).append("\n");
        sb.append("狀態：報名成功");

        System.out.println(sb.toString());
    }
}
```

### 2. Wrapper / Math / System

- Package：`java.lang`
- 用途：處理基本型別轉換、數學運算與系統輸出。
- 常用類別：`Integer`、`Double`、`Boolean`、`Math`、`System`
- 適用場景：
  - 表單輸入轉數字
  - 金額、分數、折扣初步運算
  - Console 教學與除錯輸出
- 教學提醒：
  - parseInt / parseDouble 常用於 GUI 或 Web 表單。
  - 金額正式計算請改用 BigDecimal。

完整範例：

```java
public class LangApiDemo {
    public static void main(String[] args) {
        String qtyText = "3";
        String priceText = "99.5";

        int qty = Integer.parseInt(qtyText);
        double price = Double.parseDouble(priceText);
        double total = qty * price;

        System.out.println("數量 = " + qty);
        System.out.println("總金額 = " + total);
        System.out.println("四捨五入 = " + Math.round(total));
        System.out.println("最大值 = " + Math.max(80, 95));
        System.out.println("目前時間毫秒 = " + System.currentTimeMillis());
    }
}
```

### 3. Exception / RuntimeException

- Package：`java.lang`
- 用途：處理錯誤流程，讓程式錯誤可控、可追蹤、可提示使用者。
- 常用類別：`Exception`、`RuntimeException`、`IllegalArgumentException`
- 適用場景：
  - 登入失敗
  - 資料庫錯誤
  - 輸入格式錯誤
  - 商業規則不通過
- 教學提醒：
  - 不要只寫 e.printStackTrace() 就結束。
  - Service 層適合丟出自訂 RuntimeException。

完整範例：

```java
class MemberNotFoundException extends RuntimeException {
    public MemberNotFoundException(String message) {
        super(message);
    }
}

public class ExceptionApiDemo {
    public static void main(String[] args) {
        try {
            login("allen", "wrong-password");
        } catch (MemberNotFoundException e) {
            System.out.println("登入失敗：" + e.getMessage());
        }
    }

    static void login(String username, String password) {
        if (!"1234".equals(password)) {
            throw new MemberNotFoundException("帳號或密碼錯誤");
        }
        System.out.println("登入成功");
    }
}
```

---

## 集合框架 API

### 4. List / ArrayList

- Package：`java.util`
- 用途：儲存有順序、可重複的資料，是專案中最常用的集合。
- 常用類別：`List`、`ArrayList`
- 適用場景：
  - 查詢所有會員
  - 訂單明細
  - 商品列表
  - JTable 表格資料
- 教學提醒：
  - 宣告用 List，實作常用 ArrayList。
  - DAO 查詢結果幾乎都會回傳 List<T>。

完整範例：

```java
import java.util.ArrayList;
import java.util.List;

class Product {
    String name;
    int price;
    Product(String name, int price) {
        this.name = name;
        this.price = price;
    }
}

public class ListApiDemo {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("A 商品", 100));
        products.add(new Product("B 商品", 200));
        products.add(new Product("C 商品", 300));

        for (Product p : products) {
            System.out.println(p.name + "：" + p.price);
        }
    }
}
```

### 5. Set / HashSet / TreeSet

- Package：`java.util`
- 用途：儲存不重複資料；HashSet 重視查找效率，TreeSet 會排序。
- 常用類別：`Set`、`HashSet`、`TreeSet`
- 適用場景：
  - 去除重複標籤
  - 不重複帳號
  - 報表分類項目
  - 商品類別集合
- 教學提醒：
  - HashSet 不保證順序。
  - TreeSet 會依自然排序或 Comparator 排序。

完整範例：

```java
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetApiDemo {
    public static void main(String[] args) {
        Set<String> tags = new HashSet<>();
        tags.add("Java");
        tags.add("MySQL");
        tags.add("Java");
        tags.add("Spring Boot");

        System.out.println("不重複標籤：" + tags);

        Set<Integer> scores = new TreeSet<>();
        scores.add(90);
        scores.add(70);
        scores.add(100);
        scores.add(90);

        System.out.println("排序後分數：" + scores);
    }
}
```

### 6. Map / HashMap / LinkedHashMap

- Package：`java.util`
- 用途：以 Key / Value 儲存資料，適合做查表、統計、設定資料。
- 常用類別：`Map`、`HashMap`、`LinkedHashMap`
- 適用場景：
  - 商品代號對價格
  - 帳號對會員資料
  - 統計每類商品數量
  - JSON-like 暫存資料
- 教學提醒：
  - Key 不可重複，Value 可以重複。
  - LinkedHashMap 可保留放入順序。

完整範例：

```java
import java.util.HashMap;
import java.util.Map;

public class MapApiDemo {
    public static void main(String[] args) {
        Map<String, Integer> productPrice = new HashMap<>();
        productPrice.put("A", 100);
        productPrice.put("B", 200);
        productPrice.put("C", 300);

        String code = "B";
        if (productPrice.containsKey(code)) {
            System.out.println(code + " 價格 = " + productPrice.get(code));
        }

        for (Map.Entry<String, Integer> entry : productPrice.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }
}
```

### 7. Collections / Arrays / Comparator

- Package：`java.util`
- 用途：集合與陣列的工具 API，常用於排序、搜尋、轉換。
- 常用類別：`Collections`、`Arrays`、`Comparator`
- 適用場景：
  - 商品價格排序
  - 學生成績排序
  - 陣列轉 List
  - 最大值最小值
- 教學提醒：
  - Collections 操作 Collection。
  - Arrays 操作 array。
  - Comparator 可自訂排序規則。

完整範例：

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Item {
    String name;
    int price;
    Item(String name, int price) {
        this.name = name;
        this.price = price;
    }
}

public class SortApiDemo {
    public static void main(String[] args) {
        List<Integer> scores = new ArrayList<>(Arrays.asList(80, 100, 60));
        Collections.sort(scores);
        System.out.println(scores);

        List<Item> items = new ArrayList<>();
        items.add(new Item("A", 300));
        items.add(new Item("B", 100));
        items.add(new Item("C", 200));

        items.sort(Comparator.comparingInt(i -> i.price));
        for (Item i : items) {
            System.out.println(i.name + "：" + i.price);
        }
    }
}
```

### 8. Optional

- Package：`java.util`
- 用途：表達「可能有值，也可能沒有值」，降低 NullPointerException 風險。
- 常用類別：`Optional`
- 適用場景：
  - DAO 查詢單筆資料
  - Service 查不到會員
  - 預設值處理
- 教學提醒：
  - Optional 適合當回傳值，不建議濫用在欄位。
  - orElse / orElseThrow 是常用處理方式。

完整範例：

```java
import java.util.Optional;

class Member {
    String username;
    Member(String username) {
        this.username = username;
    }
}

public class OptionalApiDemo {
    public static void main(String[] args) {
        Optional<Member> result = findByUsername("allen");

        Member member = result.orElseThrow(
            () -> new RuntimeException("找不到會員")
        );

        System.out.println("會員帳號：" + member.username);
    }

    static Optional<Member> findByUsername(String username) {
        if ("allen".equals(username)) {
            return Optional.of(new Member("allen"));
        }
        return Optional.empty();
    }
}
```

---

## 日期時間 API

### 9. LocalDate / LocalDateTime / DateTimeFormatter

- Package：`java.time`
- 用途：處理日期、時間與格式化，是新專案優先選擇。
- 常用類別：`LocalDate`、`LocalDateTime`、`DateTimeFormatter`
- 適用場景：
  - 會員建立日期
  - 訂單成立時間
  - 報表查詢區間
  - 付款時間
- 教學提醒：
  - 不要再優先使用 Date / Calendar。
  - DateTimeFormatter 負責日期格式化與解析。

完整範例：

```java
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeApiDemo {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String formatted = now.format(formatter);
        LocalDate birthday = LocalDate.parse("1990-05-20");

        System.out.println("今天：" + today);
        System.out.println("現在：" + formatted);
        System.out.println("生日：" + birthday);
    }
}
```

### 10. Duration / Period

- Package：`java.time`
- 用途：Duration 計算時間差；Period 計算日期差。
- 常用類別：`Duration`、`Period`
- 適用場景：
  - 租借時數
  - 任務執行時間
  - 會員年資
  - 貸款期數
- 教學提醒：
  - Duration 常用於小時、分鐘、秒。
  - Period 常用於年、月、日。

完整範例：

```java
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class DurationPeriodDemo {
    public static void main(String[] args) {
        LocalDateTime start = LocalDateTime.of(2026, 7, 1, 9, 0);
        LocalDateTime end = LocalDateTime.of(2026, 7, 1, 12, 30);

        Duration duration = Duration.between(start, end);
        System.out.println("課程分鐘數：" + duration.toMinutes());

        LocalDate joinDate = LocalDate.of(2024, 1, 10);
        LocalDate today = LocalDate.of(2026, 7, 7);

        Period period = Period.between(joinDate, today);
        System.out.println("會員年資：" + period.getYears() + " 年 "
            + period.getMonths() + " 月");
    }
}
```

---

## 金額與精準計算 API

### 11. BigDecimal / RoundingMode

- Package：`java.math`
- 用途：處理金額、利率、報表統計，避免 double 浮點誤差。
- 常用類別：`BigDecimal`、`RoundingMode`
- 適用場景：
  - 訂單金額
  - 貸款利息
  - 分期付款
  - 發票、薪資、財務報表
- 教學提醒：
  - BigDecimal 建議用字串建立。
  - 除法要指定小數位與 RoundingMode。

完整範例：

```java
import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalApiDemo {
    public static void main(String[] args) {
        BigDecimal price = new BigDecimal("199.90");
        BigDecimal qty = new BigDecimal("3");
        BigDecimal discount = new BigDecimal("0.9");

        BigDecimal subtotal = price.multiply(qty);
        BigDecimal total = subtotal.multiply(discount)
                .setScale(0, RoundingMode.HALF_UP);

        BigDecimal avg = total.divide(new BigDecimal("3"), 2, RoundingMode.HALF_UP);

        System.out.println("小計：" + subtotal);
        System.out.println("折扣後：" + total);
        System.out.println("平均：" + avg);
    }
}
```

---

## 檔案處理 API

### 12. Path / Paths / Files

- Package：`java.nio.file`
- 用途：新式檔案 API，適合讀寫文字檔、CSV、設定檔。
- 常用類別：`Path`、`Paths`、`Files`
- 適用場景：
  - CSV 匯入
  - 報表輸出
  - 設定檔讀取
  - 建立資料夾
- 教學提醒：
  - JDK 11 可使用 Files.readString / writeString。
  - 路徑建議用 Path，不要硬串字串。

完整範例：

```java
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FilesApiDemo {
    public static void main(String[] args) throws Exception {
        Path dir = Paths.get("output");
        Files.createDirectories(dir);

        Path file = dir.resolve("products.csv");
        List<String> lines = List.of(
            "id,name,price",
            "1,A 商品,100",
            "2,B 商品,200"
        );

        Files.write(file, lines);
        List<String> readLines = Files.readAllLines(file);

        readLines.forEach(System.out::println);
    }
}
```

### 13. BufferedReader / BufferedWriter

- Package：`java.io`
- 用途：傳統但仍常見的高效率文字檔讀寫 API。
- 常用類別：`BufferedReader`、`BufferedWriter`、`FileReader`、`FileWriter`
- 適用場景：
  - 逐行讀取大型檔案
  - 寫入 Log 或 CSV
  - 教 JDBC 前的資料流概念
- 教學提醒：
  - try-with-resources 可自動關閉檔案。
  - 大型檔案逐行處理比一次讀入更安全。

完整範例：

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class BufferedIoApiDemo {
    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("demo.txt"))) {
            bw.write("Java\n");
            bw.write("MySQL\n");
            bw.write("Spring Boot\n");
        }

        try (BufferedReader br = new BufferedReader(new FileReader("demo.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("讀到：" + line);
            }
        }
    }
}
```

---

## 設定檔 API

### 14. Properties

- Package：`java.util`
- 用途：讀取 .properties 設定檔，常用於資料庫連線設定。
- 常用類別：`Properties`
- 適用場景：
  - db.properties
  - 系統設定
  - 環境參數
  - 簡易設定管理
- 教學提醒：
  - 設定檔不要寫死在 Java 程式碼中。
  - 資料庫帳密可先放 properties，進階再改環境變數。

完整範例：

```java
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesApiDemo {
    public static void main(String[] args) throws Exception {
        Properties props = new Properties();

        try (FileInputStream fis = new FileInputStream("db.properties")) {
            props.load(fis);
        }

        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String password = props.getProperty("db.password");

        System.out.println(url);
        System.out.println(user);
        System.out.println(password);
    }
}
```

---

## 資料庫 API

### 15. JDBC：Connection / PreparedStatement / ResultSet

- Package：`java.sql`
- 用途：Java 連接關聯式資料庫的核心 API，是 DAO Pattern 的基礎。
- 常用類別：`Connection`、`DriverManager`、`PreparedStatement`、`ResultSet`、`SQLException`
- 適用場景：
  - MySQL CRUD
  - 會員登入
  - 商品查詢
  - 報表資料來源
- 教學提醒：
  - PreparedStatement 可降低 SQL Injection 風險。
  - try-with-resources 必教，避免連線未關閉。

完整範例：

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

class DBUtil {
    static Connection getConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/gjun?serverTimezone=Asia/Taipei";
        String user = "root";
        String password = "1234";
        return DriverManager.getConnection(url, user, password);
    }
}

class Member {
    int id;
    String name;
    String username;
}

public class JdbcApiDemo {
    public static void main(String[] args) throws Exception {
        List<Member> members = findAll();
        for (Member m : members) {
            System.out.println(m.id + ", " + m.name + ", " + m.username);
        }
    }

    static List<Member> findAll() throws Exception {
        List<Member> list = new ArrayList<>();
        String sql = "select id, name, username from member";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Member m = new Member();
                m.id = rs.getInt("id");
                m.name = rs.getString("name");
                m.username = rs.getString("username");
                list.add(m);
            }
        }
        return list;
    }
}
```

---

## 資料處理 API

### 16. Stream / Collectors

- Package：`java.util.stream`
- 用途：對集合資料做過濾、轉換、排序、統計、分組。
- 常用類別：`Stream`、`Collectors`
- 適用場景：
  - 商品篩選
  - 訂單統計
  - 會員分組
  - 報表資料彙總
- 教學提醒：
  - Stream 不會修改原集合。
  - collect 常用來轉回 List、Map 或做 groupingBy。

完整範例：

```java
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Order {
    String category;
    int amount;
    Order(String category, int amount) {
        this.category = category;
        this.amount = amount;
    }
}

public class StreamApiDemo {
    public static void main(String[] args) {
        List<Order> orders = List.of(
            new Order("書籍", 500),
            new Order("食品", 300),
            new Order("書籍", 700)
        );

        int total = orders.stream()
                .mapToInt(o -> o.amount)
                .sum();

        List<Order> highOrders = orders.stream()
                .filter(o -> o.amount >= 500)
                .collect(Collectors.toList());

        Map<String, Integer> sumByCategory = orders.stream()
                .collect(Collectors.groupingBy(
                    o -> o.category,
                    Collectors.summingInt(o -> o.amount)
                ));

        System.out.println("總金額：" + total);
        System.out.println("高金額筆數：" + highOrders.size());
        System.out.println(sumByCategory);
    }
}
```

### 17. Predicate / Function / Consumer / Supplier

- Package：`java.util.function`
- 用途：Lambda 與 Stream 的函式型介面，是現代 Java 寫法的核心。
- 常用類別：`Predicate`、`Function`、`Consumer`、`Supplier`
- 適用場景：
  - 自訂過濾條件
  - 資料轉換
  - 批次處理
  - 延遲建立物件
- 教學提醒：
  - Predicate 回傳 boolean。
  - Function 做 T -> R 轉換。
  - Consumer 只接收不回傳。
  - Supplier 不接收但回傳。

完整範例：

```java
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionApiDemo {
    public static void main(String[] args) {
        List<Integer> scores = List.of(50, 80, 90);

        Predicate<Integer> pass = score -> score >= 60;
        Function<Integer, String> toLevel = score -> score >= 90 ? "A" : "B";
        Consumer<String> printer = text -> System.out.println("結果：" + text);
        Supplier<String> title = () -> "成績報表";

        System.out.println(title.get());

        for (Integer score : scores) {
            if (pass.test(score)) {
                printer.accept(score + " => " + toLevel.apply(score));
            }
        }
    }
}
```

---

## 網路 API

### 18. HttpClient / HttpRequest / HttpResponse

- Package：`java.net.http`
- 用途：JDK 11 內建 HTTP Client，可呼叫 REST API。
- 常用類別：`HttpClient`、`HttpRequest`、`HttpResponse`、`URI`
- 適用場景：
  - 串接 RESTful API
  - OpenAI API
  - 天氣 API
  - 股票資料 API
  - Spring Boot 後端測試
- 教學提醒：
  - JDK 11 開始標準化，無需額外 Apache HttpClient。
  - send 是同步；sendAsync 是非同步。

完整範例：

```java
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientApiDemo {
    public static void main(String[] args) throws Exception {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts/1"))
                .GET()
                .build();

        HttpResponse<String> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );

        System.out.println("狀態碼：" + response.statusCode());
        System.out.println("內容：" + response.body());
    }
}
```

---

## 非同步與多執行緒 API

### 19. ExecutorService / Callable / Future

- Package：`java.util.concurrent`
- 用途：管理背景工作與執行緒池，避免手動管理 Thread。
- 常用類別：`ExecutorService`、`Executors`、`Callable`、`Future`
- 適用場景：
  - 背景匯出 Excel
  - 大量資料查詢
  - GUI 避免卡住
  - 批次任務
- 教學提醒：
  - 工作完成後要 shutdown。
  - Callable 可回傳結果，Runnable 不回傳結果。

完整範例：

```java
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorApiDemo {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Callable<Integer> task = () -> {
            Thread.sleep(1000);
            return 100 + 200;
        };

        Future<Integer> future = executor.submit(task);

        System.out.println("背景工作執行中...");
        Integer result = future.get();
        System.out.println("結果：" + result);

        executor.shutdown();
    }
}
```

### 20. CompletableFuture

- Package：`java.util.concurrent`
- 用途：現代 Java 非同步流程 API，可串接任務、轉換結果、處理完成事件。
- 常用類別：`CompletableFuture`
- 適用場景：
  - 非同步呼叫 API
  - 背景查詢資料
  - GUI 不阻塞
  - 多任務合併
- 教學提醒：
  - supplyAsync 會回傳結果。
  - thenApply 轉換結果，thenAccept 消費結果。

完整範例：

```java
import java.util.concurrent.CompletableFuture;

public class CompletableFutureApiDemo {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> {
            sleep(1000);
            return "會員資料";
        }).thenApply(data -> {
            return data + " + 訂單資料";
        }).thenAccept(result -> {
            System.out.println("查詢完成：" + result);
        }).join();
    }

    static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
```

---

## 安全與工具 API

### 21. UUID / Base64 / SecureRandom

- Package：`java.util / java.security`
- 用途：產生唯一 ID、做基本編碼、產生安全隨機數。
- 常用類別：`UUID`、`Base64`、`SecureRandom`
- 適用場景：
  - 訂單編號
  - Token
  - 驗證碼
  - 簡易資料編碼
- 教學提醒：
  - Base64 是編碼，不是加密。
  - 安全用途的隨機數優先使用 SecureRandom。

完整範例：

```java
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.UUID;

public class SecurityUtilApiDemo {
    public static void main(String[] args) {
        String orderNo = UUID.randomUUID().toString();
        System.out.println("訂單編號：" + orderNo);

        String raw = "allen:1234";
        String encoded = Base64.getEncoder()
                .encodeToString(raw.getBytes(StandardCharsets.UTF_8));
        String decoded = new String(Base64.getDecoder().decode(encoded), StandardCharsets.UTF_8);

        SecureRandom random = new SecureRandom();
        int code = 100000 + random.nextInt(900000);

        System.out.println("Base64：" + encoded);
        System.out.println("還原：" + decoded);
        System.out.println("驗證碼：" + code);
    }
}
```

### 22. MessageDigest

- Package：`java.security`
- 用途：產生雜湊值，例如 SHA-256，適合做完整性檢查。
- 常用類別：`MessageDigest`
- 適用場景：
  - 檔案校驗
  - 資料雜湊
  - 密碼教學概念
  - Token 簽章概念前導
- 教學提醒：
  - 正式密碼儲存不應只用 SHA-256，應使用 bcrypt / Argon2 等。
  - 這裡作為 Java API 教學示範。

完整範例：

```java
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class MessageDigestApiDemo {
    public static void main(String[] args) throws Exception {
        String text = "hello-java";
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(text.getBytes(StandardCharsets.UTF_8));

        StringBuilder hex = new StringBuilder();
        for (byte b : hash) {
            hex.append(String.format("%02x", b));
        }

        System.out.println("SHA-256：" + hex);
    }
}
```

---

## Swing GUI API

### 23. JFrame / JButton / JTextField / JOptionPane

- Package：`javax.swing`
- 用途：Java SE 視窗程式基本元件，適合 WindowBuilder 課程。
- 常用類別：`JFrame`、`JPanel`、`JButton`、`JTextField`、`JPasswordField`、`JOptionPane`
- 適用場景：
  - 登入畫面
  - 會員管理
  - 商品輸入
  - 查詢表單
- 教學提醒：
  - WindowBuilder 是視覺化工具，底層仍是 Swing API。
  - 事件處理常用 addActionListener。

完整範例：

```java
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SwingLoginDemo extends JFrame {
    private JTextField txtUsername = new JTextField();
    private JPasswordField txtPassword = new JPasswordField();
    private JButton btnLogin = new JButton("登入");

    public SwingLoginDemo() {
        setTitle("會員登入");
        setSize(360, 220);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lblUser = new JLabel("帳號");
        lblUser.setBounds(40, 30, 80, 25);
        txtUsername.setBounds(120, 30, 160, 25);

        JLabel lblPass = new JLabel("密碼");
        lblPass.setBounds(40, 70, 80, 25);
        txtPassword.setBounds(120, 70, 160, 25);

        btnLogin.setBounds(120, 115, 100, 30);
        btnLogin.addActionListener(e -> login());

        add(lblUser);
        add(txtUsername);
        add(lblPass);
        add(txtPassword);
        add(btnLogin);
    }

    private void login() {
        String username = txtUsername.getText();
        String password = new String(txtPassword.getPassword());
        if ("admin".equals(username) && "1234".equals(password)) {
            JOptionPane.showMessageDialog(this, "登入成功");
        } else {
            JOptionPane.showMessageDialog(this, "登入失敗");
        }
    }

    public static void main(String[] args) {
        new SwingLoginDemo().setVisible(true);
    }
}
```

### 24. JTable / DefaultTableModel

- Package：`javax.swing / javax.swing.table`
- 用途：表格顯示資料，是會員管理、商品管理、訂單管理最常用 GUI 元件。
- 常用類別：`JTable`、`DefaultTableModel`、`JScrollPane`
- 適用場景：
  - 查詢結果列表
  - 商品清單
  - 訂單明細
  - 報表預覽
- 教學提醒：
  - JTable 顯示畫面，DefaultTableModel 管理資料。
  - 從 DAO 查到 List<T> 後，轉成 table model。

完整範例：

```java
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.List;

class MemberRow {
    int id;
    String name;
    String phone;
    MemberRow(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }
}

public class JTableApiDemo extends JFrame {
    private JTable table = new JTable();
    private DefaultTableModel model = new DefaultTableModel();

    public JTableApiDemo() {
        setTitle("會員列表");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        model.addColumn("編號");
        model.addColumn("姓名");
        model.addColumn("電話");
        table.setModel(model);

        add(new JScrollPane(table));
        loadData();
    }

    private void loadData() {
        List<MemberRow> members = List.of(
            new MemberRow(1, "Allen", "0912-111-111"),
            new MemberRow(2, "Mary", "0922-222-222")
        );

        model.setRowCount(0);
        for (MemberRow m : members) {
            model.addRow(new Object[] { m.id, m.name, m.phone });
        }
    }

    public static void main(String[] args) {
        new JTableApiDemo().setVisible(true);
    }
}
```

---

## JSON 第三方 API

### 25. Jackson ObjectMapper

- Package：`com.fasterxml.jackson.databind`
- 用途：Java 物件與 JSON 互轉，是 REST API 專案常用工具。
- 常用類別：`ObjectMapper`
- 適用場景：
  - Spring Boot JSON
  - 呼叫外部 API 回傳資料
  - 設定檔 JSON
  - 前後端資料交換
- 教學提醒：
  - Spring Boot 預設常用 Jackson。
  - 純 Java 專案需加入 Maven dependency。

完整範例：

```java
import com.fasterxml.jackson.databind.ObjectMapper;

class UserDto {
    public int id;
    public String name;

    public UserDto() {}

    public UserDto(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class JacksonApiDemo {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        UserDto user = new UserDto(1, "Allen");
        String json = mapper.writeValueAsString(user);
        System.out.println("轉 JSON：" + json);

        UserDto result = mapper.readValue(json, UserDto.class);
        System.out.println("轉物件：" + result.id + ", " + result.name);
    }
}
```

---

## Excel 第三方 API

### 26. Apache POI Workbook / Sheet / Row / Cell

- Package：`org.apache.poi`
- 用途：讀寫 Excel 檔案，是 Java 報表匯出常用 API。
- 常用類別：`Workbook`、`XSSFWorkbook`、`Sheet`、`Row`、`Cell`
- 適用場景：
  - 會員清單匯出
  - 訂單報表
  - 貸款分期表
  - 課程作業輸出
- 教學提醒：
  - XSSFWorkbook 用於 .xlsx。
  - 大量資料可再進階使用 SXSSFWorkbook。

完整範例：

```java
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;

public class PoiExcelApiDemo {
    public static void main(String[] args) throws Exception {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("會員資料");

            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("編號");
            header.createCell(1).setCellValue("姓名");
            header.createCell(2).setCellValue("電話");

            Row row = sheet.createRow(1);
            row.createCell(0).setCellValue(1);
            row.createCell(1).setCellValue("Allen");
            row.createCell(2).setCellValue("0912-111-111");

            for (int i = 0; i < 3; i++) {
                sheet.autoSizeColumn(i);
            }

            try (FileOutputStream fos = new FileOutputStream("members.xlsx")) {
                workbook.write(fos);
            }
        }
        System.out.println("Excel 匯出完成");
    }
}
```

---

## Logging 第三方 API

### 27. SLF4J Logger / LoggerFactory

- Package：`org.slf4j`
- 用途：標準化 Log 輸出，取代 System.out.println 做正式除錯與追蹤。
- 常用類別：`Logger`、`LoggerFactory`
- 適用場景：
  - DAO SQL 錯誤
  - Service 商業邏輯
  - Controller 請求追蹤
  - 例外紀錄
- 教學提醒：
  - 教學可以先 println，專案要改 logger。
  - SLF4J 是 facade，常搭配 Logback。

完整範例：

```java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jApiDemo {
    private static final Logger log = LoggerFactory.getLogger(Slf4jApiDemo.class);

    public static void main(String[] args) {
        String username = "allen";
        log.info("使用者登入：{}", username);

        try {
            int result = 10 / 0;
            log.info("result={}", result);
        } catch (Exception e) {
            log.error("系統發生錯誤", e);
        }
    }
}
```

---

## 樣板程式簡化 API

### 28. Lombok @Data / @Builder

- Package：`lombok`
- 用途：自動產生 getter、setter、toString、builder，減少樣板程式。
- 常用類別：`@Data`、`@Builder`、`@NoArgsConstructor`、`@AllArgsConstructor`
- 適用場景：
  - Model
  - DTO
  - Entity
  - 查詢條件物件
- 教學提醒：
  - Eclipse 需要安裝 Lombok 支援。
  - 正式教學要讓學生知道 Lombok 只是產生程式碼，不是魔法。

完整範例：

```java
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class ProductDto {
    private Integer id;
    private String name;
    private Integer price;
}

public class LombokApiDemo {
    public static void main(String[] args) {
        ProductDto product = ProductDto.builder()
                .id(1)
                .name("A 商品")
                .price(100)
                .build();

        System.out.println(product.getName());
        System.out.println(product);
    }
}
```

---

## 測試 API

### 29. JUnit @Test / Assertions

- Package：`org.junit.jupiter.api`
- 用途：撰寫單元測試，驗證方法是否正確。
- 常用類別：`@Test`、`Assertions`、`assertEquals`、`assertThrows`
- 適用場景：
  - Service 計算邏輯
  - DAO 測試
  - 工具類測試
  - 回歸測試
- 教學提醒：
  - 先測 Service / Util 最容易上手。
  - 測試不是額外工作，是保護專案的安全網。

完整範例：

```java
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PriceService {
    BigDecimal subtotal(BigDecimal price, int qty) {
        if (qty <= 0) {
            throw new IllegalArgumentException("數量必須大於 0");
        }
        return price.multiply(BigDecimal.valueOf(qty));
    }
}

public class JUnitApiDemo {
    private PriceService service = new PriceService();

    @Test
    void testSubtotal() {
        BigDecimal result = service.subtotal(new BigDecimal("100"), 3);
        assertEquals(new BigDecimal("300"), result);
    }

    @Test
    void testInvalidQty() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.subtotal(new BigDecimal("100"), 0);
        });
    }
}
```

### 30. Mockito mock / when / verify

- Package：`org.mockito`
- 用途：模擬 DAO 或外部依賴，讓 Service 測試更乾淨。
- 常用類別：`Mockito`、`mock`、`when`、`verify`
- 適用場景：
  - Service 測試不想真的連資料庫
  - 模擬外部 API
  - 測試 Controller 依賴
- 教學提醒：
  - mock DAO，測 Service。
  - verify 可檢查方法是否被呼叫。

完整範例：

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

interface MemberDao {
    String findNameById(int id);
}

class MemberService {
    private MemberDao dao;
    MemberService(MemberDao dao) {
        this.dao = dao;
    }
    String getDisplayName(int id) {
        return "會員：" + dao.findNameById(id);
    }
}

public class MockitoApiDemo {
    @Test
    void testGetDisplayName() {
        MemberDao dao = mock(MemberDao.class);
        when(dao.findNameById(1)).thenReturn("Allen");

        MemberService service = new MemberService(dao);
        String result = service.getDisplayName(1);

        assertEquals("會員：Allen", result);
        verify(dao).findNameById(1);
    }
}
```

---

## 資料庫連線池 API

### 31. HikariCP HikariDataSource

- Package：`com.zaxxer.hikari`
- 用途：高效能資料庫連線池，正式專案比 DriverManager 更適合。
- 常用類別：`HikariConfig`、`HikariDataSource`
- 適用場景：
  - 桌面程式多人使用
  - Web 專案
  - Spring Boot 連線池
  - 高頻資料庫存取
- 教學提醒：
  - DriverManager 適合入門；連線池適合專案。
  - Spring Boot 預設常使用 HikariCP。

完整範例：

```java
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HikariApiDemo {
    public static void main(String[] args) throws Exception {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/gjun?serverTimezone=Asia/Taipei");
        config.setUsername("root");
        config.setPassword("1234");
        config.setMaximumPoolSize(10);

        try (HikariDataSource ds = new HikariDataSource(config);
             Connection conn = ds.getConnection();
             PreparedStatement ps = conn.prepareStatement("select count(*) from member");
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                System.out.println("會員數：" + rs.getInt(1));
            }
        }
    }
}
```

---

## Spring Boot 常用 API

### 32. REST Controller Annotations

- Package：`org.springframework.web.bind.annotation`
- 用途：建立 RESTful API，讓前端、jQuery、Vue、React 或 n8n 呼叫後端。
- 常用類別：`@RestController`、`@RequestMapping`、`@GetMapping`、`@PostMapping`、`@RequestBody`、`@PathVariable`
- 適用場景：
  - 會員 API
  - 商品 API
  - 訂單 API
  - 前後端分離
  - n8n 串接 Java 後端
- 教學提醒：
  - Controller 負責接收請求，不直接寫 SQL。
  - 商業邏輯放 Service，資料存取放 DAO/Repository。

完整範例：

```java
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

class MemberDto {
    public Integer id;
    public String name;
}

@RestController
@RequestMapping("/api/members")
public class MemberRestController {
    private List<MemberDto> members = new ArrayList<>();

    @GetMapping
    public List<MemberDto> findAll() {
        return members;
    }

    @GetMapping("/{id}")
    public MemberDto findById(@PathVariable Integer id) {
        return members.stream()
                .filter(m -> m.id.equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("找不到會員"));
    }

    @PostMapping
    public MemberDto add(@RequestBody MemberDto member) {
        members.add(member);
        return member;
    }
}
```

### 33. Bean Validation Annotations

- Package：`jakarta.validation / javax.validation`
- 用途：驗證表單與 API 輸入資料，避免髒資料進入系統。
- 常用類別：`@NotBlank`、`@NotNull`、`@Size`、`@Email`、`@Valid`
- 適用場景：
  - 註冊會員
  - 新增商品
  - 訂單送出
  - API 請求驗證
- 教學提醒：
  - Spring Boot 3 使用 jakarta.validation。
  - Spring Boot 2 常見 javax.validation。

完整範例：

```java
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

class RegisterRequest {
    @NotBlank(message = "姓名不可空白")
    public String name;

    @Email(message = "Email 格式錯誤")
    public String email;

    @Size(min = 6, message = "密碼至少 6 碼")
    public String password;
}

@RestController
public class ValidationController {
    @PostMapping("/api/register")
    public String register(@Valid @RequestBody RegisterRequest request) {
        return "註冊成功：" + request.name;
    }
}
```

---

## 練習作業

### 作業 1：會員資料處理

- 使用 `List<Member>` 儲存會員。
- 使用 `Stream` 查詢姓名包含指定關鍵字的會員。
- 使用 `LocalDateTime` 記錄建立時間。
- 使用 `JTable` 顯示結果。

### 作業 2：商品與訂單金額

- 使用 `BigDecimal` 計算商品小計。
- 使用 `Map<String, BigDecimal>` 儲存商品代號與價格。
- 使用 `Apache POI` 匯出 Excel。

### 作業 3：JDBC + DAO

- 建立 `member` 資料表。
- 撰寫 `DBUtil`。
- 撰寫 `MemberDao` 的 `add`、`findAll`、`login`。
- 透過 Swing 畫面呼叫 Controller / Service / DAO。

### 作業 4：REST API 串接

- 使用 `HttpClient` 呼叫公開 JSON API。
- 使用 `Jackson ObjectMapper` 解析 JSON。
- 將結果顯示在 Console 或 JTable。

## 參考文件

- Oracle Java SE 11 API Documentation: https://docs.oracle.com/en/java/javase/11/docs/api/
- Oracle Java Tutorials - Collections, Concurrency, JDBC: https://docs.oracle.com/javase/tutorial/
- Jackson Databind ObjectMapper: https://fasterxml.github.io/jackson-databind/
- Apache POI Documentation: https://poi.apache.org/
- SLF4J Manual: https://www.slf4j.org/manual.html
- JUnit 5 User Guide: https://junit.org/junit5/docs/current/user-guide/
- Mockito Documentation: https://site.mockito.org/
- HikariCP GitHub Documentation: https://github.com/brettwooldridge/HikariCP
- Spring Framework Web MVC Documentation: https://docs.spring.io/spring-framework/reference/web/webmvc.html
