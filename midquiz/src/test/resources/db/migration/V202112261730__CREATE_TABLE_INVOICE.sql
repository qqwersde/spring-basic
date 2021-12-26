CREATE TABLE `invoice`
(
    `id`          bigint UNSIGNED AUTO_INCREMENT NOT NULL COMMENT 'id',
    `payment_id`  bigint UNSIGNED                NOT NULL COMMENT '支付id',
    `btc_id`      bigint UNSIGNED                NOT NULL COMMENT '合同id',
    `status`      VARCHAR(64)                    NOT NULL COMMENT '发票状态',
    `create_time` DATETIME                       NOT NULL COMMENT '创建时间',
    `modify_time` DATETIME                       NOT NULL COMMENT '修改时间',
    PRIMARY KEY (`id`)
);