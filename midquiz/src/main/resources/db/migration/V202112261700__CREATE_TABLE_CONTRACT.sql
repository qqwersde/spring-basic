CREATE TABLE IF NOT EXISTS `contract`
(
    `id`           bigint UNSIGNED AUTO_INCREMENT NOT NULL COMMENT 'id',
    `company_name` VARCHAR(256)                   NOT NULL COMMENT '公司名称',
    `expired_time` DATETIME                       NOT NULL COMMENT '过期时间',
    `create_time`  DATETIME                       NOT NULL COMMENT '创建时间',
    `modify_time`  DATETIME                       NOT NULL COMMENT '修改时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;