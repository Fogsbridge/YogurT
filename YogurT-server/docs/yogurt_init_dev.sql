# 开发环境数据库初始化脚本

# 创建数据库
CREATE DATABASE IF NOT EXISTS `yogurt_dev` CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;

# 创建应用 API 访问用户
CREATE USER IF NOT EXISTS 'yogurt_api_dev'@'%' IDENTIFIED BY 'dev123';
GRANT SELECT, INSERT, UPDATE, DELETE ON `yogurt_dev`.* TO 'yogurt_api_dev'@'%';

# 创建 Flyway 数据库迁移用户
CREATE USER IF NOT EXISTS 'yogurt_flyway'@'%' IDENTIFIED BY 'flyway123';
GRANT ALL PRIVILEGES ON `yogurt_dev`.* TO 'yogurt_flyway'@'%';