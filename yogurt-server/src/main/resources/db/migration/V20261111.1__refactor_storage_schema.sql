SET NAMES utf8mb4;

-- ==========================================
-- 1. 清空表记录
-- ==========================================
TRUNCATE TABLE storage_config;
TRUNCATE TABLE storage_policy;
TRUNCATE TABLE file_record;
TRUNCATE TABLE file_reference;

-- ==========================================
-- 2. 修改表 storage_config
-- ==========================================
-- 2.1 修改 storage_config 表名为 storage_source
RENAME TABLE `storage_config` TO `storage_source`;
-- 2.2 修改 storage_source 表 comment 信息
ALTER TABLE `storage_source` COMMENT='存储源表';
-- 2.3 字段名 config_name 修改为 source_name，同步修改对应索引
ALTER TABLE `storage_source` CHANGE COLUMN `config_name` `source_name` VARCHAR(100) NOT NULL COMMENT '存储源名称';
ALTER TABLE `storage_source` DROP INDEX `uk_config_name`;
ALTER TABLE `storage_source` ADD UNIQUE KEY `uk_source_name` (`source_name`);
-- 2.4 修改 storage_type 字段 comment 信息
ALTER TABLE `storage_source` MODIFY COLUMN `storage_type` VARCHAR(100) NOT NULL COMMENT '存储类型 (如 Local、S3、阿里云OSS)';
-- 2.5 删除字段 bucket_name、base_path
ALTER TABLE `storage_source` DROP COLUMN `bucket_name`;
ALTER TABLE `storage_source` DROP COLUMN `base_path`;
-- 2.6 新增字段 path_style
ALTER TABLE `storage_source` ADD COLUMN `path_style` TINYINT UNSIGNED NOT NULL COMMENT '是否是路径风格（0-域名风格，1-路径风格）' AFTER `secret_key`;
-- 2.7 新增唯一索引（endpoint）
ALTER TABLE `storage_source` ADD UNIQUE KEY `uk_endpoint` (`endpoint`);
-- 2.8 修改 region 字段排序规则为 utf8mb4_bin
ALTER TABLE `storage_source` MODIFY COLUMN `region` VARCHAR(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '区域';
-- 2.9 新增字段 builtin
ALTER TABLE `storage_source` ADD COLUMN `builtin` TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否是内置存储源（0-第三方存储，1-Local本地存储）' AFTER `region`;

-- ==========================================
-- 3. 新增表 storage_bucket
-- ==========================================
CREATE TABLE `storage_bucket` (
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `source_id` BIGINT UNSIGNED NOT NULL COMMENT '存储源ID（storage_source.id）',
    `bucket_name` VARCHAR(255) COLLATE utf8mb4_bin NOT NULL COMMENT '存储桶名称（如 桶名-public、桶名-private）',
    `access_level` TINYINT UNSIGNED NOT NULL DEFAULT 3 COMMENT '访问级别（1-公开，2-私有，3-隔离）',
    `builtin` TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否是内置存储桶（0-第三方存储，1-Local本地存储）',
    `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY uk_name_source (`bucket_name`, `source_id`),
    UNIQUE KEY uk_access_source (`access_level`, `source_id`)
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4
  DEFAULT COLLATE = utf8mb4_0900_ai_ci
  COMMENT = '存储桶表';

-- ==========================================
-- 4. 修改表 storage_policy
-- ==========================================
-- 4.1 修改 storage_policy 表名为 upload_scene
RENAME TABLE `storage_policy` TO `upload_scene`;
-- 4.2 字段名 policy_name 修改为 scene_name，同步修改对应索引
ALTER TABLE `upload_scene` CHANGE COLUMN `policy_name` `scene_name` VARCHAR(100) NOT NULL COMMENT '场景名称';
ALTER TABLE `upload_scene` DROP INDEX `uk_policy_name`;
ALTER TABLE `upload_scene` ADD UNIQUE KEY `uk_scene_name` (`scene_name`);
-- 4.3 新增字段 scene_type，并添加唯一索引
ALTER TABLE `upload_scene` ADD COLUMN `scene_type` VARCHAR(100) NOT NULL COMMENT '场景类型（如 avatar，post_image）' AFTER `scene_name`;
ALTER TABLE `upload_scene` ADD UNIQUE KEY `uk_scene_type` (`scene_type`);
-- 4.4 字段名 config_id 修改为 source_id，并删除对应索引
ALTER TABLE `upload_scene` CHANGE COLUMN `config_id` `source_id` BIGINT UNSIGNED NOT NULL COMMENT '存储源ID（storage_source.id）';
ALTER TABLE `upload_scene` DROP INDEX `uk_config_base_path`;
-- 4.5 更新 base_path 字段注释
ALTER TABLE `upload_scene` MODIFY COLUMN `base_path` VARCHAR(500) COLLATE utf8mb4_bin NOT NULL COMMENT '桶内的基础路径（如 avatar/）';
-- 4.6 删除字段 is_private
ALTER TABLE `upload_scene` DROP COLUMN `is_private`;
-- 4.7 新增唯一索引（base_path）
ALTER TABLE `upload_scene` ADD UNIQUE KEY `uk_base_path` (`base_path`);
-- 4.8 修改 upload_scene 表 comment 信息
ALTER TABLE `upload_scene` COMMENT='上传场景表';
-- 4.9 新增字段 builtin
ALTER TABLE `upload_scene` ADD COLUMN `builtin` TINYINT UNSIGNED NOT NULL DEFAULT 1 COMMENT '是否是内置上传场景（0-自定义场景，1-内置场景）' AFTER `allowed_types`;

-- ==========================================
-- 5. 修改表 file_record
-- ==========================================
-- 5.1 更新 status 字段的注释
ALTER TABLE `file_record` MODIFY COLUMN `status` TINYINT UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态（1-待处理，2-正常，3-已删除，4-已拒绝）';
-- 5.2 字段名 policy_id 修改为 scene_id，同步修改对应索引
ALTER TABLE `file_record` CHANGE COLUMN `policy_id` `scene_id` BIGINT UNSIGNED NOT NULL COMMENT '场景ID（upload_scene.id）';
ALTER TABLE `file_record` DROP INDEX `idx_policy_id`;
ALTER TABLE `file_record` ADD INDEX `idx_scene_id` (`scene_id`);
-- 5.3 新增字段 bucket_id
ALTER TABLE `file_record` ADD COLUMN `bucket_id` BIGINT UNSIGNED NOT NULL COMMENT '桶ID（storage_bucket.id）' AFTER `scene_id`;
-- 5.4 新增字段 reject_reason
ALTER TABLE `file_record` ADD COLUMN `reject_reason` VARCHAR(100) DEFAULT NULL COMMENT '拒绝原因' AFTER `status`;
-- 5.5 新增字段 deleted_at
ALTER TABLE `file_record` ADD COLUMN `deleted_at` DATETIME DEFAULT NULL COMMENT '删除时间' AFTER `reject_reason`;
-- 5.6 更新索引加入 deleted_at 字段
ALTER TABLE `file_record` DROP INDEX `uk_policy_file_key`;
ALTER TABLE `file_record` ADD UNIQUE KEY `uk_scene_file_key_deleted` (`scene_id`, `file_key`, `deleted_at`);
ALTER TABLE `file_record` DROP INDEX `uk_parent_variant`;
ALTER TABLE `file_record` ADD UNIQUE KEY `uk_parent_variant_deleted` (`parent_id`, `file_variant`, `deleted_at`);
ALTER TABLE `file_record` DROP INDEX `uk_public_code`;
ALTER TABLE `file_record` ADD UNIQUE KEY `uk_public_deleted` (`public_code`, `deleted_at`);

-- ==========================================
-- 6. 修改表 file_reference
-- ==========================================
-- 6.1 修改字段名为 ref_type、ref_id 并同步更新索引
ALTER TABLE `file_reference` CHANGE COLUMN `target_type` `ref_type` VARCHAR(200) NOT NULL COMMENT '引用的业务类型（如 post 文章、comment 评论）';
ALTER TABLE `file_reference` CHANGE COLUMN `target_id` `ref_id` BIGINT UNSIGNED NOT NULL COMMENT '引用的业务主键ID（如文章ID、评论ID）';
ALTER TABLE `file_reference` DROP INDEX `uk_target_file`;
ALTER TABLE `file_reference` DROP INDEX `idx_target`;
-- 6.2 新增字段 deleted_at，并调整索引
ALTER TABLE `file_reference` ADD COLUMN `deleted_at` DATETIME DEFAULT NULL COMMENT '删除时间' AFTER `ref_id`;
ALTER TABLE `file_reference` ADD UNIQUE KEY `uk_ref_file_deleted` (`ref_type`, `ref_id`, `file_id`, `deleted_at`);
