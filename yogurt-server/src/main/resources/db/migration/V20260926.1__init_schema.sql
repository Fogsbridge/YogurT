SET NAMES utf8mb4;

-- 用户表
CREATE TABLE `user` (
    `id`            BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `username`      VARCHAR(100) NOT NULL COMMENT '用户名',
    `password`      VARCHAR(255) CHARACTER SET ascii COLLATE ascii_bin NOT NULL COMMENT '密码',
    `nickname`      VARCHAR(100) DEFAULT NULL COMMENT '昵称',
    `email`         VARCHAR(255) DEFAULT NULL COMMENT '电子邮箱',
    `avatar_image`  VARCHAR(500) DEFAULT NULL COMMENT '头像URL',
    `intro`         VARCHAR(500) DEFAULT NULL COMMENT '个人简介',
    `website`       VARCHAR(255) DEFAULT NULL COMMENT '个人网站',
    `last_login_at` DATETIME DEFAULT NULL COMMENT '最后登录时间',
    `last_login_ip` VARCHAR(64) DEFAULT NULL COMMENT '最后登录IP',
    `created_at`    DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at`    DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted`       BIGINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '逻辑删除：0-未删除 非0-删除时的毫秒时间戳',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_username` (`username`, `deleted`),
    UNIQUE KEY `uk_email` (`email`, `deleted`)
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4
  DEFAULT COLLATE = utf8mb4_0900_ai_ci
  COMMENT = '用户表';

-- 用户token表
CREATE TABLE `user_token` (
    `id`            BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `user_id`       BIGINT UNSIGNED NOT NULL COMMENT '用户ID',
    `token`         VARCHAR(255) CHARACTER SET ascii COLLATE ascii_bin NOT NULL COMMENT 'token值',
    `expires_at`    DATETIME NOT NULL COMMENT '过期时间',
    `created_at`    DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `last_used_at`  DATETIME DEFAULT NULL COMMENT '最后使用时间',
    `revoked`       TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否失效：0-有效 1-失效',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_token` (`token`),
    KEY `idx_user_id` (`user_id`)
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4
  DEFAULT COLLATE = utf8mb4_0900_ai_ci
  COMMENT = '用户token表';

-- 站点配置表
CREATE TABLE `site_config` (
    `id`            BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `config_key`    VARCHAR(100) NOT NULL COMMENT '配置项名',
    `config_value`  JSON DEFAULT NULL COMMENT '配置项值',
    `description`   VARCHAR(255) DEFAULT NULL COMMENT '配置说明',
    `created_at`    DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at`    DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_config_key` (`config_key`)
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4
  DEFAULT COLLATE = utf8mb4_0900_ai_ci
  COMMENT = '站点配置表';

-- 文章表
CREATE TABLE `post` (
    `id`            BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `title`         VARCHAR(255) NOT NULL COMMENT '文章标题',
    `slug`          VARCHAR(255) DEFAULT NULL COMMENT 'URL别名',
    `summary`       VARCHAR(500) DEFAULT NULL COMMENT '文章摘要',
    `content`       LONGTEXT NOT NULL COMMENT 'Markdown原文',
    `cover_image`   VARCHAR(500) DEFAULT NULL COMMENT '封面图URL',
    `category_id`   BIGINT UNSIGNED DEFAULT NULL COMMENT '分类ID',
    `author_id`     BIGINT UNSIGNED DEFAULT NULL COMMENT '作者ID (user.id)',
    `status`        TINYINT NOT NULL DEFAULT 0 COMMENT '状态：0-草稿 1-已发布 2-已下线',
    `top_weight`    SMALLINT NOT NULL DEFAULT 0 COMMENT '置顶权重：0-不置顶 大于0-置顶，值越大权重越高',
    `allow_comment` TINYINT NOT NULL DEFAULT 1 COMMENT '是否允许评论：0-否 1-是',
    `view_count`    BIGINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '浏览量',
    `like_count`    BIGINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '点赞量',
    `comment_count` BIGINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '评论量',
    `word_count`    INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '字数',
    `reading_time`  INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '预计阅读时长(分钟)',
    `published_at`  DATETIME DEFAULT NULL COMMENT '发布时间',
    `created_at`    DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at`    DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted`       BIGINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '逻辑删除：0-未删除 非0-删除时的毫秒时间戳',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_slug` (`slug`, `deleted`),
    KEY `idx_category_id` (`category_id`, `status`, `deleted`),
    KEY `idx_list` (`status`, `deleted`, `top_weight`, `published_at`),
    FULLTEXT KEY `ft_title_summary` (`title`, `summary`) WITH PARSER ngram
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4
  DEFAULT COLLATE = utf8mb4_0900_ai_ci
  COMMENT = '文章表';

-- 分类表
CREATE TABLE `category` (
    `id`            BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `name`          VARCHAR(100) NOT NULL COMMENT '分类名称',
    `slug`          VARCHAR(100) DEFAULT NULL COMMENT 'URL别名',
    `cover_image`   VARCHAR(500) DEFAULT NULL COMMENT '封面图URL',
    `sort_order`    INT NOT NULL DEFAULT 0 COMMENT '排序值，值越小越靠前',
    `created_at`    DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at`    DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted`       BIGINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '逻辑删除：0-未删除 非0-删除时的毫秒时间戳',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_name` (`name`, `deleted`),
    UNIQUE KEY `uk_slug` (`slug`, `deleted`),
    KEY `idx_sort_order` (`deleted`, `sort_order`)
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4
  DEFAULT COLLATE = utf8mb4_0900_ai_ci
  COMMENT = '文章分类表';

-- 标签表
CREATE TABLE `tag` (
    `id`            BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `name`          VARCHAR(100) NOT NULL COMMENT '标签名称',
    `slug`          VARCHAR(100) DEFAULT NULL COMMENT 'URL别名',
    `color`         VARCHAR(50) NOT NULL COMMENT '标签颜色',
    `sort_order`    INT NOT NULL DEFAULT 0 COMMENT '排序值，值越小越靠前',
    `created_at`    DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at`    DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted`       BIGINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '逻辑删除：0-未删除 非0-删除时的毫秒时间戳',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_name` (`name`, `deleted`),
    UNIQUE KEY `uk_slug` (`slug`, `deleted`),
    KEY `idx_sort_order` (`deleted`, `sort_order`)
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4
  DEFAULT COLLATE = utf8mb4_0900_ai_ci
  COMMENT = '标签表';

-- 文章标签关联表
CREATE TABLE `post_tag` (
    `id`            BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `post_id`       BIGINT UNSIGNED NOT NULL COMMENT '文章ID',
    `tag_id`        BIGINT UNSIGNED NOT NULL COMMENT '标签ID',
    `created_at`    DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_post_tag` (`post_id`, `tag_id`),
    KEY `idx_tag_id` (`tag_id`)
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4
  DEFAULT COLLATE = utf8mb4_0900_ai_ci
  COMMENT = '文章标签关联表';

-- 评论表
CREATE TABLE `comment` (
    `id`                BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `post_id`           BIGINT UNSIGNED NOT NULL COMMENT '文章ID',
    `root_id`           BIGINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '根评论ID，0-自身即为根评论',
    `parent_id`         BIGINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '父评论ID，0-无父评论',
    `nickname`          VARCHAR(100) NOT NULL COMMENT '评论者昵称',
    `email`             VARCHAR(255) DEFAULT NULL COMMENT '评论者邮箱',
    `website`           VARCHAR(255) DEFAULT NULL COMMENT '评论者网站',
    `avatar_image`      VARCHAR(500) DEFAULT NULL COMMENT '评论者头像URL',
    `reply_nickname`    VARCHAR(100) DEFAULT NULL COMMENT '被回复者昵称',
    `content`           VARCHAR(2000) NOT NULL COMMENT '评论内容',
    `ip`                VARCHAR(64) NOT NULL COMMENT '评论者IP',
    `ip_location`       VARCHAR(100) DEFAULT NULL COMMENT '评论者IP属地',
    `user_agent`        VARCHAR(1000) DEFAULT NULL COMMENT '浏览器UA',
    `like_count`        BIGINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '点赞量',
    `children_count`    BIGINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '回复量(仅统计直接子回复)',
    `status`            TINYINT NOT NULL DEFAULT 0 COMMENT '状态：0-待审核 1-已通过 2-未通过',
    `created_at`        DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at`        DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted`           BIGINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '逻辑删除：0-未删除 非0-删除时的毫秒时间戳',
    PRIMARY KEY (`id`),
    KEY `idx_post_id` (`post_id`, `status`, `deleted`, `created_at`),
    KEY `idx_root_id` (`root_id`, `status`, `deleted`),
    KEY `idx_parent_id` (`parent_id`, `status`, `deleted`),
    KEY `idx_status` (`status`, `deleted`, `created_at`)
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4
  DEFAULT COLLATE = utf8mb4_0900_ai_ci
  COMMENT = '评论表';

-- 友情链接表
CREATE TABLE `friend_link` (
    `id`            BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `name`          VARCHAR(100) NOT NULL COMMENT '站点名称',
    `site_url`      VARCHAR(255) NOT NULL COMMENT '站点地址',
    `avatar_image`  VARCHAR(500) DEFAULT NULL COMMENT '站点头像/Logo',
    `description`   VARCHAR(500) DEFAULT NULL COMMENT '站点描述',
    `email`         VARCHAR(255) NOT NULL COMMENT '站长邮箱',
    `sort_order`    INT NOT NULL DEFAULT 0 COMMENT '排序值，值越小越靠前',
    `status`        TINYINT NOT NULL DEFAULT 1 COMMENT '状态：0-隐藏 1-显示',
    `created_at`    DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at`    DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted`       BIGINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '逻辑删除：0-未删除 非0-删除时的毫秒时间戳',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_site_url` (`site_url`, `deleted`),
    KEY `idx_sort_order` (`status`, `deleted`, `sort_order`)
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4
  DEFAULT COLLATE = utf8mb4_0900_ai_ci
  COMMENT = '友情链接表';