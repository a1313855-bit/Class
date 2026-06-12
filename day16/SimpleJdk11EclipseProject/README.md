# SimpleJdk11EclipseProject

這是一個 **JDK 11 + Eclipse Java Project** 的簡易範例，適合初學者練習 Java 專案結構、物件導向、DAO Pattern、Service Layer 與 Console CRUD。

## 一、開發環境

- JDK：11
- IDE：Eclipse IDE for Java Developers / Eclipse IDE for Enterprise Java and Web Developers
- Project Type：一般 Java Project，非 Maven
- Database：無，使用記憶體 ArrayList 模擬資料庫

## 二、功能

會員管理 Console CRUD：

1. 新增會員
2. 查詢全部會員
3. 依 ID 查詢會員
4. 修改會員
5. 刪除會員
0. 離開系統

## 三、專案架構

```text
SimpleJdk11EclipseProject/
├─ .project
├─ .classpath
├─ README.md
├─ run_windows.bat
├─ bin/
└─ src/
   └─ com/
      └─ codebyx/
         ├─ app/
         │  └─ MainApp.java
         ├─ model/
         │  └─ Member.java
         ├─ dao/
         │  └─ MemberDao.java
         ├─ dao/impl/
         │  └─ MemberDaoMemoryImpl.java
         └─ service/
            └─ MemberService.java
```

## 四、匯入 Eclipse

1. 打開 Eclipse
2. 選擇 `File` → `Import`
3. 選擇 `General` → `Existing Projects into Workspace`
4. 選擇此資料夾：`SimpleJdk11EclipseProject`
5. 勾選專案後按 `Finish`
6. 確認 Project 使用 JDK 11
7. 打開 `src/com/codebyx/app/MainApp.java`
8. 右鍵 → `Run As` → `Java Application`

## 五、使用 Windows 批次檔執行

在專案資料夾中雙擊：

```text
run_windows.bat
```

若視窗一閃而過，請用命令提示字元進入資料夾後執行：

```bat
run_windows.bat
```

## 六、教學重點

### 1. Model

`Member.java` 是資料模型，負責封裝會員資料。

### 2. DAO Interface

`MemberDao.java` 定義資料存取方法，例如新增、查詢、修改、刪除。

### 3. DAO Implementation

`MemberDaoMemoryImpl.java` 使用 `ArrayList` 模擬資料庫，讓初學者先理解 DAO 架構。

### 4. Service Layer

`MemberService.java` 負責商業邏輯與簡單驗證，例如姓名不可空白、Email 必須包含 `@`。

### 5. MainApp

`MainApp.java` 是 Console UI，負責接收使用者輸入並呼叫 Service。

## 七、可延伸方向

後續可以升級成：

1. JDBC + MySQL 版本
2. Maven Project 版本
3. Swing / JavaFX GUI 版本
4. Servlet + JSP Web 版本
5. Spring Boot REST API 版本
