CREATE TABLE `CONTRACT`
(
    `ID`           BIGINT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT 'id',
    `COMPANY_NAME` VARCHAR(256)                   NOT NULL COMMENT '公司名称',
    `EXPIRED_TIME` DATETIME                       NOT NULL COMMENT '过期时间',
    `CREATE_TIME`  DATETIME                       NOT NULL COMMENT '创建时间',
    `MODIFY_TIME`  DATETIME                       NOT NULL COMMENT '修改时间',
    PRIMARY KEY (`ID`)
);