-- 建立資料庫 schema
CREATE DATABASE IF NOT EXISTS `homework3.0`
DEFAULT CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

-- 使用該資料庫
USE `homework3.0`;

-- 建立玩家帳號資料表 (player)
-- 用於存放玩家的帳號基本資訊，未來一個帳號可以選擇/創建多個遊戲角色
CREATE TABLE IF NOT EXISTS `player` (
    `id` INT AUTO_INCREMENT COMMENT '玩家帳號唯一的識別 ID',
    `username` VARCHAR(50) NOT NULL UNIQUE COMMENT '玩家登入帳號，不可重複',
    `password` VARCHAR(100) NOT NULL COMMENT '玩家登入密碼',
    `nick_name` VARCHAR(50) NOT NULL COMMENT '玩家顯示的暱稱',
    `mail` VARCHAR(100) COMMENT '玩家的電子信箱',
    `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '帳號註冊/創建時間',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- 新增一筆初始測試用的帳號資料 (預設密碼 123456)
INSERT INTO `player` (`username`, `password`, `nick_name`, `mail`) 
VALUES ('testuser', '123456', '測試小勇者', 'test@game.com')
ON DUPLICATE KEY UPDATE `username`=`username`;
