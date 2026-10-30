SET NAMES utf8mb4;

-- ==========================================
-- 存储配置表：定义存储类型（本地、对象存储等）
-- ==========================================
CREATE TABLE `storage_config` (
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `config_name` VARCHAR(100) NOT NULL COMMENT '配置名称',
    `storage_type` VARCHAR(100) NOT NULL COMMENT '存储类型 (Local、对象存储)',
    `endpoint` VARCHAR(500) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '端点URL（Local留空）',
    `access_key` VARCHAR(500) COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'Access Key（Local留空）',
    `secret_key` VARCHAR(500) COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'Secret Key（Local留空）',
    `bucket_name` VARCHAR(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '存储桶名称（Local留空）',
    `base_path` VARCHAR(500) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '基础存储路径',
    `region` VARCHAR(255) DEFAULT NULL COMMENT '区域',
    `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_config_name` (`config_name`)
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4
  DEFAULT COLLATE = utf8mb4_0900_ai_ci
  COMMENT = '存储配置表';

-- ==========================================
-- 存储策略表：定义图片、视频等不同媒体类型的存储策略
-- ==========================================
CREATE TABLE `storage_policy` (
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `config_id` BIGINT UNSIGNED NOT NULL COMMENT '存储配置ID（storage_config.id）',
    `policy_name` VARCHAR(100) NOT NULL COMMENT '策略名称',
    `file_type` VARCHAR(64) NOT NULL COMMENT '文件类型（如 image、video、audio）',
    `base_path` VARCHAR(500) COLLATE utf8mb4_bin NOT NULL COMMENT '桶/磁盘内的基础路径（如 post/images/）',
    `is_private` TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否私有（0-公开，1-私有）',
    `max_size` BIGINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '允许上传文件的最大大小（单位：字节），0表示不做限制',
    `chunk_size` BIGINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '分片大小（单位：字节），0表示不分片',
    `allowed_types` JSON NOT NULL COMMENT '允许的文件格式（JSON数组，如 ["jpg", "png"]）',
    `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_policy_name` (`policy_name`),
    UNIQUE KEY `uk_config_base_path` (`config_id`, `base_path`)
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4
  DEFAULT COLLATE = utf8mb4_0900_ai_ci
  COMMENT = '存储策略表';

-- ==========================================
-- 文件记录表：记录上传的文件信息
-- ==========================================
CREATE TABLE `file_record` (
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `policy_id` BIGINT UNSIGNED NOT NULL COMMENT '存储策略ID（storage_policy.id）',
    `file_key` VARCHAR(500) COLLATE utf8mb4_bin NOT NULL COMMENT '存储路径 Key（如 post/images/2026/uuid.jpg）',
    `public_code` VARCHAR(128) COLLATE utf8mb4_bin NOT NULL COMMENT '对外访问的随机码',
    `original_name` VARCHAR(500) DEFAULT NULL COMMENT '原始文件名',
    `mime_type` VARCHAR(128) NOT NULL COMMENT 'MIME 类型（如 image/jpeg）',
    `file_variant` VARCHAR(100) NOT NULL COMMENT '衍生文件（如 original 原文件、thumbnail 缩略图、compressed 压缩图）',
    `parent_id` BIGINT UNSIGNED DEFAULT NULL COMMENT '父文件ID（衍生文件指向原文件，原文件为NULL）',
    `file_size` BIGINT UNSIGNED NOT NULL COMMENT '文件大小（单位：字节）',
    `file_hash` VARCHAR(256) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '文件哈希值',
    `ref_count` INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '被业务引用数',
    `metadata` JSON DEFAULT NULL COMMENT '文件元数据（如宽高、时长等）',
    `user_id` BIGINT UNSIGNED DEFAULT NULL COMMENT '上传者用户ID',
    `visitor_id` BIGINT UNSIGNED DEFAULT NULL COMMENT '匿名上传者的ID',
    `status` TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '状态（0-待确认，1-正常）',
    `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '上传时间',
    `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_policy_file_key` (`policy_id`, `file_key`),
    UNIQUE KEY `uk_public_code` (`public_code`),
    UNIQUE KEY `uk_parent_variant` (`parent_id`, `file_variant`),
    KEY `idx_parent_id` (`parent_id`),
    KEY `idx_hash_size` (`file_hash`, `file_size`),
    KEY `idx_policy_id` (`policy_id`),
    KEY `idx_status_created` (`status`, `created_at`),
    KEY `idx_user_id` (`user_id`),
    KEY `idx_visitor_id` (`visitor_id`)
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4
  DEFAULT COLLATE = utf8mb4_0900_ai_ci
  COMMENT = '文件记录表';

-- ==========================================
-- 文件引用表：记录某条业务记录引用了某个文件
-- ==========================================
CREATE TABLE `file_reference` (
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `file_id` BIGINT UNSIGNED NOT NULL COMMENT '关联的文件ID（file_record.id）',
    `target_type` VARCHAR(200) NOT NULL COMMENT '关联的目标类型（如 post 文章、 comment 评论）',
    `target_id` BIGINT UNSIGNED NOT NULL COMMENT '关联的目标主键ID（如文章ID、评论ID）',
    `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '关联时间',
    `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_target_file` (`target_type`, `target_id`, `file_id`),
    KEY `idx_target` (`target_type`, `target_id`),
    KEY `idx_file_id` (`file_id`)
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4
  DEFAULT COLLATE = utf8mb4_0900_ai_ci
  COMMENT = '文件引用表';
