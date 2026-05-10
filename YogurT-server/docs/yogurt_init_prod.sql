# 生产环境数据库初始化脚本

# 创建数据库
CREATE DATABASE IF NOT EXISTS `yogurt_prod` CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;

# 创建应用 API 访问用户
CREATE USER IF NOT EXISTS 'yogurt_api_prod'@'%' IDENTIFIED BY 'prod123';
GRANT SELECT, INSERT, UPDATE, DELETE ON `yogurt_prod`.* TO 'yogurt_api_prod'@'%';

# 创建 Flyway 数据库迁移用户
CREATE USER IF NOT EXISTS 'yogurt_flyway'@'%' IDENTIFIED BY 'flyway123';
GRANT ALL PRIVILEGES ON `yogurt_prod`.* TO 'yogurt_flyway'@'%';