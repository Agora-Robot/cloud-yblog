/*
 Navicat Premium Data Transfer

 Source Server         : demo-01
 Source Server Type    : MySQL
 Source Server Version : 50711
 Source Host           : localhost:3306
 Source Schema         : nacos_config

 Target Server Type    : MySQL
 Target Server Version : 50711
 File Encoding         : 65001

 Date: 04/08/2021 22:49:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for config_info
-- ----------------------------
DROP TABLE IF EXISTS `config_info`;
CREATE TABLE `config_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'content',
  `md5` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `src_user` text CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT 'source user',
  `src_ip` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'source ip',
  `app_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT '租户字段',
  `c_desc` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `c_use` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `effect` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `type` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `c_schema` text CHARACTER SET utf8 COLLATE utf8_bin NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_configinfo_datagrouptenant`(`data_id`, `group_id`, `tenant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 270 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'config_info' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of config_info
-- ----------------------------
INSERT INTO `config_info` VALUES (209, 'transport.type', 'SEATA_GROUP', 'TCP', 'b136ef5f6a01d816991fe3cf7a6ac763', '2021-07-29 02:26:34', '2021-07-29 02:26:34', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (210, 'transport.server', 'SEATA_GROUP', 'NIO', 'b6d9dfc0fb54277321cebc0fff55df2f', '2021-07-29 02:26:34', '2021-07-29 02:26:34', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (211, 'transport.heartbeat', 'SEATA_GROUP', 'true', 'b326b5062b2f0e69046810717534cb09', '2021-07-29 02:26:34', '2021-07-29 02:26:34', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (212, 'transport.thread-factory.boss-thread-prefix', 'SEATA_GROUP', 'NettyBoss', '0f8db59a3b7f2823f38a70c308361836', '2021-07-29 02:26:34', '2021-07-29 02:26:34', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (213, 'transport.thread-factory.worker-thread-prefix', 'SEATA_GROUP', 'NettyServerNIOWorker', 'a78ec7ef5d1631754c4e72ae8a3e9205', '2021-07-29 02:26:34', '2021-07-29 02:26:34', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (214, 'transport.thread-factory.server-executor-thread-prefix', 'SEATA_GROUP', 'NettyServerBizHandler', '11a36309f3d9df84fa8b59cf071fa2da', '2021-07-29 02:26:34', '2021-07-29 02:26:34', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (215, 'transport.thread-factory.share-boss-worker', 'SEATA_GROUP', 'false', '68934a3e9455fa72420237eb05902327', '2021-07-29 02:26:35', '2021-07-29 02:26:35', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (216, 'transport.thread-factory.client-selector-thread-prefix', 'SEATA_GROUP', 'NettyClientSelector', 'cd7ec5a06541e75f5a7913752322c3af', '2021-07-29 02:26:35', '2021-07-29 02:26:35', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (217, 'transport.thread-factory.client-selector-thread-size', 'SEATA_GROUP', '1', 'c4ca4238a0b923820dcc509a6f75849b', '2021-07-29 02:26:35', '2021-07-29 02:26:35', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (218, 'transport.thread-factory.client-worker-thread-prefix', 'SEATA_GROUP', 'NettyClientWorkerThread', '61cf4e69a56354cf72f46dc86414a57e', '2021-07-29 02:26:35', '2021-07-29 02:26:35', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (219, 'transport.thread-factory.boss-thread-size', 'SEATA_GROUP', '1', 'c4ca4238a0b923820dcc509a6f75849b', '2021-07-29 02:26:35', '2021-07-29 02:26:35', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (220, 'transport.thread-factory.worker-thread-size', 'SEATA_GROUP', '8', 'c9f0f895fb98ab9159f51fd0297e236d', '2021-07-29 02:26:35', '2021-07-29 02:26:35', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (221, 'transport.shutdown.wait', 'SEATA_GROUP', '3', 'eccbc87e4b5ce2fe28308fd9f2a7baf3', '2021-07-29 02:26:35', '2021-07-29 02:26:35', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (222, 'service.vgroupMapping.my_test_tx_group', 'SEATA_GROUP', 'default', 'c21f969b5f03d33d43e04f8f136e7682', '2021-07-29 02:26:35', '2021-07-29 02:26:35', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (223, 'service.enableDegrade', 'SEATA_GROUP', 'false', '68934a3e9455fa72420237eb05902327', '2021-07-29 02:26:35', '2021-07-29 02:26:35', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (224, 'service.disable', 'SEATA_GROUP', 'false', '68934a3e9455fa72420237eb05902327', '2021-07-29 02:26:35', '2021-07-29 02:26:35', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (225, 'service.max.commit.retry.timeout', 'SEATA_GROUP', '-1', '6bb61e3b7bce0931da574d19d1d82c88', '2021-07-29 02:26:35', '2021-07-29 02:26:35', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (226, 'service.max.rollback.retry.timeout', 'SEATA_GROUP', '-1', '6bb61e3b7bce0931da574d19d1d82c88', '2021-07-29 02:26:35', '2021-07-29 02:26:35', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (227, 'client.async.commit.buffer.limit', 'SEATA_GROUP', '10000', 'b7a782741f667201b54880c925faec4b', '2021-07-29 02:26:35', '2021-07-29 02:26:35', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (228, 'client.lock.retry.internal', 'SEATA_GROUP', '10', 'd3d9446802a44259755d38e6d163e820', '2021-07-29 02:26:35', '2021-07-29 02:26:35', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (229, 'client.lock.retry.times', 'SEATA_GROUP', '30', '34173cb38f07f89ddbebc2ac9128303f', '2021-07-29 02:26:35', '2021-07-29 02:26:35', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (230, 'client.lock.retry.policy.branch-rollback-on-conflict', 'SEATA_GROUP', 'true', 'b326b5062b2f0e69046810717534cb09', '2021-07-29 02:26:35', '2021-07-29 02:26:35', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (231, 'client.table.meta.check.enable', 'SEATA_GROUP', 'true', 'b326b5062b2f0e69046810717534cb09', '2021-07-29 02:26:35', '2021-07-29 02:26:35', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (232, 'client.report.retry.count', 'SEATA_GROUP', '5', 'e4da3b7fbbce2345d7772b0674a318d5', '2021-07-29 02:26:35', '2021-07-29 02:26:35', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (233, 'client.tm.commit.retry.count', 'SEATA_GROUP', '1', 'c4ca4238a0b923820dcc509a6f75849b', '2021-07-29 02:26:35', '2021-07-29 02:26:35', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (234, 'client.tm.rollback.retry.count', 'SEATA_GROUP', '1', 'c4ca4238a0b923820dcc509a6f75849b', '2021-07-29 02:26:35', '2021-07-29 02:26:35', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (235, 'store.mode', 'SEATA_GROUP', 'file', '8c7dd922ad47494fc02c388e12c00eac', '2021-07-29 02:26:36', '2021-07-29 02:26:36', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (236, 'store.file.dir', 'SEATA_GROUP', 'file_store/data', '6a8dec07c44c33a8a9247cba5710bbb2', '2021-07-29 02:26:36', '2021-07-29 02:26:36', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (237, 'store.file.max-branch-session-size', 'SEATA_GROUP', '16384', 'c76fe1d8e08462434d800487585be217', '2021-07-29 02:26:36', '2021-07-29 02:26:36', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (238, 'store.file.max-global-session-size', 'SEATA_GROUP', '512', '10a7cdd970fe135cf4f7bb55c0e3b59f', '2021-07-29 02:26:36', '2021-07-29 02:26:36', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (239, 'store.file.file-write-buffer-cache-size', 'SEATA_GROUP', '16384', 'c76fe1d8e08462434d800487585be217', '2021-07-29 02:26:36', '2021-07-29 02:26:36', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (240, 'store.file.flush-disk-mode', 'SEATA_GROUP', 'async', '0df93e34273b367bb63bad28c94c78d5', '2021-07-29 02:26:36', '2021-07-29 02:26:36', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (241, 'store.file.session.reload.read_size', 'SEATA_GROUP', '100', 'f899139df5e1059396431415e770c6dd', '2021-07-29 02:26:36', '2021-07-29 02:26:36', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (242, 'store.db.datasource', 'SEATA_GROUP', 'dbcp', '3a9f384fb40c59fbdc67024ee97d94b1', '2021-07-29 02:26:36', '2021-07-29 02:26:36', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (243, 'store.db.db-type', 'SEATA_GROUP', 'mysql', '81c3b080dad537de7e10e0987a4bf52e', '2021-07-29 02:26:36', '2021-07-29 02:26:36', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (244, 'store.db.driver-class-name', 'SEATA_GROUP', 'com.mysql.jdbc.Driver', '683cf0c3a5a56cec94dfac94ca16d760', '2021-07-29 02:26:36', '2021-07-29 02:26:36', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (245, 'store.db.url', 'SEATA_GROUP', 'jdbc:mysql://127.0.0.1:3306/seata?useUnicode=true', 'cbb3bd573704f125fb4f2489208abaec', '2021-07-29 02:26:36', '2021-07-29 02:26:36', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (246, 'store.db.user', 'SEATA_GROUP', 'mysql', '81c3b080dad537de7e10e0987a4bf52e', '2021-07-29 02:26:36', '2021-07-29 02:26:36', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (247, 'store.db.password', 'SEATA_GROUP', 'mysql', '81c3b080dad537de7e10e0987a4bf52e', '2021-07-29 02:26:36', '2021-07-29 02:26:36', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (248, 'store.db.min-conn', 'SEATA_GROUP', '1', 'c4ca4238a0b923820dcc509a6f75849b', '2021-07-29 02:26:36', '2021-07-29 02:26:36', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (249, 'store.db.max-conn', 'SEATA_GROUP', '3', 'eccbc87e4b5ce2fe28308fd9f2a7baf3', '2021-07-29 02:26:36', '2021-07-29 02:26:36', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (250, 'store.db.global.table', 'SEATA_GROUP', 'global_table', '8b28fb6bb4c4f984df2709381f8eba2b', '2021-07-29 02:26:36', '2021-07-29 02:26:36', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (251, 'store.db.branch.table', 'SEATA_GROUP', 'branch_table', '54bcdac38cf62e103fe115bcf46a660c', '2021-07-29 02:26:36', '2021-07-29 02:26:36', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (252, 'store.db.query-limit', 'SEATA_GROUP', '100', 'f899139df5e1059396431415e770c6dd', '2021-07-29 02:26:36', '2021-07-29 02:26:36', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (253, 'store.db.lock-table', 'SEATA_GROUP', 'lock_table', '55e0cae3b6dc6696b768db90098b8f2f', '2021-07-29 02:26:37', '2021-07-29 02:26:37', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (254, 'recovery.committing-retry-period', 'SEATA_GROUP', '1000', 'a9b7ba70783b617e9998dc4dd82eb3c5', '2021-07-29 02:26:37', '2021-07-29 02:26:37', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (255, 'recovery.asyn-committing-retry-period', 'SEATA_GROUP', '1000', 'a9b7ba70783b617e9998dc4dd82eb3c5', '2021-07-29 02:26:37', '2021-07-29 02:26:37', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (256, 'recovery.rollbacking-retry-period', 'SEATA_GROUP', '1000', 'a9b7ba70783b617e9998dc4dd82eb3c5', '2021-07-29 02:26:37', '2021-07-29 02:26:37', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (257, 'recovery.timeout-retry-period', 'SEATA_GROUP', '1000', 'a9b7ba70783b617e9998dc4dd82eb3c5', '2021-07-29 02:26:37', '2021-07-29 02:26:37', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (258, 'transaction.undo.data.validation', 'SEATA_GROUP', 'true', 'b326b5062b2f0e69046810717534cb09', '2021-07-29 02:26:37', '2021-07-29 02:26:37', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (259, 'transaction.undo.log.serialization', 'SEATA_GROUP', 'jackson', 'b41779690b83f182acc67d6388c7bac9', '2021-07-29 02:26:37', '2021-07-29 02:26:37', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (260, 'transaction.undo.log.save.days', 'SEATA_GROUP', '7', '8f14e45fceea167a5a36dedd4bea2543', '2021-07-29 02:26:37', '2021-07-29 02:26:37', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (261, 'transaction.undo.log.delete.period', 'SEATA_GROUP', '86400000', 'f4c122804fe9076cb2710f55c3c6e346', '2021-07-29 02:26:37', '2021-07-29 02:26:37', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (262, 'transaction.undo.log.table', 'SEATA_GROUP', 'undo_log', '2842d229c24afe9e61437135e8306614', '2021-07-29 02:26:37', '2021-07-29 02:26:37', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (263, 'transport.serialization', 'SEATA_GROUP', 'seata', 'b943081c423b9a5416a706524ee05d40', '2021-07-29 02:26:37', '2021-07-29 02:26:37', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (264, 'transport.compressor', 'SEATA_GROUP', 'none', '334c4a4c42fdb79d7ebc3e73b517e6f8', '2021-07-29 02:26:37', '2021-07-29 02:26:37', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (265, 'metrics.enabled', 'SEATA_GROUP', 'false', '68934a3e9455fa72420237eb05902327', '2021-07-29 02:26:37', '2021-07-29 02:26:37', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (266, 'metrics.registry-type', 'SEATA_GROUP', 'compact', '7cf74ca49c304df8150205fc915cd465', '2021-07-29 02:26:37', '2021-07-29 02:26:37', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (267, 'metrics.exporter-list', 'SEATA_GROUP', 'prometheus', 'e4f00638b8a10e6994e67af2f832d51c', '2021-07-29 02:26:37', '2021-07-29 02:26:37', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (268, 'metrics.exporter-prometheus-port', 'SEATA_GROUP', '9898', '7b9dc501afe4ee11c56a4831e20cee71', '2021-07-29 02:26:37', '2021-07-29 02:26:37', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (269, 'support.spring.datasource.autoproxy', 'SEATA_GROUP', 'false', '68934a3e9455fa72420237eb05902327', '2021-07-29 02:26:37', '2021-07-29 02:26:37', NULL, '127.0.0.1', '', '', NULL, NULL, NULL, 'text', NULL);

-- ----------------------------
-- Table structure for config_info_aggr
-- ----------------------------
DROP TABLE IF EXISTS `config_info_aggr`;
CREATE TABLE `config_info_aggr`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'group_id',
  `datum_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'datum_id',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '内容',
  `gmt_modified` datetime(0) NOT NULL COMMENT '修改时间',
  `app_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT '租户字段',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_configinfoaggr_datagrouptenantdatum`(`data_id`, `group_id`, `tenant_id`, `datum_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '增加租户字段' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of config_info_aggr
-- ----------------------------

-- ----------------------------
-- Table structure for config_info_beta
-- ----------------------------
DROP TABLE IF EXISTS `config_info_beta`;
CREATE TABLE `config_info_beta`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'group_id',
  `app_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'app_name',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'content',
  `beta_ips` varchar(1024) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'betaIps',
  `md5` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `src_user` text CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT 'source user',
  `src_ip` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'source ip',
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT '租户字段',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_configinfobeta_datagrouptenant`(`data_id`, `group_id`, `tenant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'config_info_beta' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of config_info_beta
-- ----------------------------

-- ----------------------------
-- Table structure for config_info_tag
-- ----------------------------
DROP TABLE IF EXISTS `config_info_tag`;
CREATE TABLE `config_info_tag`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'group_id',
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT 'tenant_id',
  `tag_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'tag_id',
  `app_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'app_name',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'content',
  `md5` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `src_user` text CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT 'source user',
  `src_ip` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'source ip',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_configinfotag_datagrouptenanttag`(`data_id`, `group_id`, `tenant_id`, `tag_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'config_info_tag' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of config_info_tag
-- ----------------------------

-- ----------------------------
-- Table structure for config_tags_relation
-- ----------------------------
DROP TABLE IF EXISTS `config_tags_relation`;
CREATE TABLE `config_tags_relation`  (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `tag_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'tag_name',
  `tag_type` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'tag_type',
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'group_id',
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT 'tenant_id',
  `nid` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`nid`) USING BTREE,
  UNIQUE INDEX `uk_configtagrelation_configidtag`(`id`, `tag_name`, `tag_type`) USING BTREE,
  INDEX `idx_tenant_id`(`tenant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'config_tag_relation' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of config_tags_relation
-- ----------------------------

-- ----------------------------
-- Table structure for group_capacity
-- ----------------------------
DROP TABLE IF EXISTS `group_capacity`;
CREATE TABLE `group_capacity`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `group_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT 'Group ID，空字符表示整个集群',
  `quota` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '配额，0表示使用默认值',
  `usage` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '使用量',
  `max_size` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '单个配置大小上限，单位为字节，0表示使用默认值',
  `max_aggr_count` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '聚合子配置最大个数，，0表示使用默认值',
  `max_aggr_size` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '单个聚合数据的子配置大小上限，单位为字节，0表示使用默认值',
  `max_history_count` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '最大变更历史数量',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_group_id`(`group_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '集群、各Group容量信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of group_capacity
-- ----------------------------

-- ----------------------------
-- Table structure for his_config_info
-- ----------------------------
DROP TABLE IF EXISTS `his_config_info`;
CREATE TABLE `his_config_info`  (
  `id` bigint(64) UNSIGNED NOT NULL,
  `nid` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `group_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `app_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'app_name',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `md5` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `src_user` text CHARACTER SET utf8 COLLATE utf8_bin NULL,
  `src_ip` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `op_type` char(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT '租户字段',
  PRIMARY KEY (`nid`) USING BTREE,
  INDEX `idx_gmt_create`(`gmt_create`) USING BTREE,
  INDEX `idx_gmt_modified`(`gmt_modified`) USING BTREE,
  INDEX `idx_did`(`data_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 397 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '多租户改造' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of his_config_info
-- ----------------------------
INSERT INTO `his_config_info` VALUES (0, 1, 'aaa', 'DEFAULT_GROUP', '', '222', 'bcbe3365e6ac95ea2c0343a2395834dd', '2021-07-28 10:01:23', '2021-07-28 02:01:24', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (1, 2, 'aaa', 'DEFAULT_GROUP', '', '222', 'bcbe3365e6ac95ea2c0343a2395834dd', '2021-07-28 10:01:42', '2021-07-28 02:01:42', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (0, 3, 'sentinel-service-flow-rules', 'SENTINEL_GROUP', '', '[{\"app\":\"sentinel-service\",\"clusterConfig\":{\"fallbackToLocalWhenFail\":true,\"sampleCount\":10,\"strategy\":0,\"thresholdType\":0,\"windowIntervalMs\":1000},\"clusterMode\":false,\"controlBehavior\":0,\"count\":11.0,\"gmtCreate\":1627441219751,\"gmtModified\":1627441219751,\"grade\":1,\"id\":1,\"ip\":\"192.168.184.1\",\"limitApp\":\"default\",\"port\":8720,\"resource\":\"test-testA\",\"strategy\":0}]', '1ef3d9c4476ef93a5d96841b35a78dd2', '2021-07-28 11:00:19', '2021-07-28 03:00:20', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (2, 4, 'sentinel-service-flow-rules', 'SENTINEL_GROUP', '', '[{\"app\":\"sentinel-service\",\"clusterConfig\":{\"fallbackToLocalWhenFail\":true,\"sampleCount\":10,\"strategy\":0,\"thresholdType\":0,\"windowIntervalMs\":1000},\"clusterMode\":false,\"controlBehavior\":0,\"count\":11.0,\"gmtCreate\":1627441219751,\"gmtModified\":1627441219751,\"grade\":1,\"id\":1,\"ip\":\"192.168.184.1\",\"limitApp\":\"default\",\"port\":8720,\"resource\":\"test-testA\",\"strategy\":0}]', '1ef3d9c4476ef93a5d96841b35a78dd2', '2021-07-28 11:45:16', '2021-07-28 03:45:17', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (0, 5, 'sentinel-service-flow-rules', 'SENTINEL_GROUP', '', '[{\"app\":\"sentinel-service\",\"clusterConfig\":{\"fallbackToLocalWhenFail\":true,\"sampleCount\":10,\"strategy\":0,\"thresholdType\":0,\"windowIntervalMs\":1000},\"clusterMode\":false,\"controlBehavior\":1,\"count\":12.0,\"gmtCreate\":1627443955583,\"gmtModified\":1627443955583,\"grade\":1,\"id\":1,\"ip\":\"192.168.184.1\",\"limitApp\":\"default\",\"port\":8720,\"resource\":\"test-testA\",\"strategy\":0,\"warmUpPeriodSec\":5}]', '0c45f2410b56b91ff97bc33a8e45fec1', '2021-07-28 11:45:55', '2021-07-28 03:45:56', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (3, 6, 'sentinel-service-flow-rules', 'SENTINEL_GROUP', '', '[{\"app\":\"sentinel-service\",\"clusterConfig\":{\"fallbackToLocalWhenFail\":true,\"sampleCount\":10,\"strategy\":0,\"thresholdType\":0,\"windowIntervalMs\":1000},\"clusterMode\":false,\"controlBehavior\":1,\"count\":12.0,\"gmtCreate\":1627443955583,\"gmtModified\":1627443955583,\"grade\":1,\"id\":1,\"ip\":\"192.168.184.1\",\"limitApp\":\"default\",\"port\":8720,\"resource\":\"test-testA\",\"strategy\":0,\"warmUpPeriodSec\":5}]', '0c45f2410b56b91ff97bc33a8e45fec1', '2021-07-28 11:46:37', '2021-07-28 03:46:37', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (0, 7, 'sentinel-service-degrade-rules', 'SENTINEL_GROUP', '', '[{\"app\":\"sentinel-service\",\"count\":0.3,\"gmtCreate\":1627444014553,\"gmtModified\":1627444014553,\"grade\":1,\"id\":1,\"ip\":\"192.168.184.1\",\"limitApp\":\"default\",\"minRequestAmount\":5,\"port\":8720,\"resource\":\"test-testB\",\"statIntervalMs\":1000,\"timeWindow\":1}]', '2537bcca3df90d42b986d880b27a5acf', '2021-07-28 11:46:54', '2021-07-28 03:46:55', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 8, 'sentinel-service-param-rules', 'SENTINEL_GROUP', '', '[{\"app\":\"sentinel-service\",\"gmtCreate\":1627444063646,\"gmtModified\":1627444063646,\"id\":1,\"ip\":\"192.168.184.1\",\"port\":8720,\"rule\":{\"burstCount\":0,\"clusterConfig\":{\"fallbackToLocalWhenFail\":true,\"sampleCount\":10,\"thresholdType\":0,\"windowIntervalMs\":1000},\"clusterMode\":false,\"controlBehavior\":0,\"count\":10.0,\"durationInSec\":1,\"grade\":1,\"limitApp\":\"default\",\"maxQueueingTimeMs\":0,\"paramFlowItemList\":[],\"paramIdx\":0,\"resource\":\"test-testA\"}}]', '35c7f97858bc779b46bdb961365c792b', '2021-07-28 11:47:43', '2021-07-28 03:47:44', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (6, 9, 'sentinel-service-param-rules', 'SENTINEL_GROUP', '', '[{\"app\":\"sentinel-service\",\"gmtCreate\":1627444063646,\"gmtModified\":1627444063646,\"id\":1,\"ip\":\"192.168.184.1\",\"port\":8720,\"rule\":{\"burstCount\":0,\"clusterConfig\":{\"fallbackToLocalWhenFail\":true,\"sampleCount\":10,\"thresholdType\":0,\"windowIntervalMs\":1000},\"clusterMode\":false,\"controlBehavior\":0,\"count\":10.0,\"durationInSec\":1,\"grade\":1,\"limitApp\":\"default\",\"maxQueueingTimeMs\":0,\"paramFlowItemList\":[],\"paramIdx\":0,\"resource\":\"test-testA\"}}]', '35c7f97858bc779b46bdb961365c792b', '2021-07-28 11:48:04', '2021-07-28 03:48:04', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (0, 10, 'transport.type', 'SEATA_GROUP', '', 'TCP', 'b136ef5f6a01d816991fe3cf7a6ac763', '2021-07-29 10:18:02', '2021-07-29 02:18:02', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 11, 'transport.server', 'SEATA_GROUP', '', 'NIO', 'b6d9dfc0fb54277321cebc0fff55df2f', '2021-07-29 10:18:02', '2021-07-29 02:18:02', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 12, 'transport.heartbeat', 'SEATA_GROUP', '', 'true', 'b326b5062b2f0e69046810717534cb09', '2021-07-29 10:18:02', '2021-07-29 02:18:02', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 13, 'transport.enableClientBatchSendRequest', 'SEATA_GROUP', '', 'false', '68934a3e9455fa72420237eb05902327', '2021-07-29 10:18:02', '2021-07-29 02:18:02', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 14, 'transport.threadFactory.bossThreadPrefix', 'SEATA_GROUP', '', 'NettyBoss', '0f8db59a3b7f2823f38a70c308361836', '2021-07-29 10:18:02', '2021-07-29 02:18:02', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 15, 'transport.threadFactory.workerThreadPrefix', 'SEATA_GROUP', '', 'NettyServerNIOWorker', 'a78ec7ef5d1631754c4e72ae8a3e9205', '2021-07-29 10:18:02', '2021-07-29 02:18:02', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 16, 'transport.threadFactory.serverExecutorThreadPrefix', 'SEATA_GROUP', '', 'NettyServerBizHandler', '11a36309f3d9df84fa8b59cf071fa2da', '2021-07-29 10:18:02', '2021-07-29 02:18:02', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 17, 'transport.threadFactory.shareBossWorker', 'SEATA_GROUP', '', 'false', '68934a3e9455fa72420237eb05902327', '2021-07-29 10:18:02', '2021-07-29 02:18:02', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 18, 'transport.threadFactory.clientSelectorThreadPrefix', 'SEATA_GROUP', '', 'NettyClientSelector', 'cd7ec5a06541e75f5a7913752322c3af', '2021-07-29 10:18:02', '2021-07-29 02:18:02', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 19, 'transport.threadFactory.clientSelectorThreadSize', 'SEATA_GROUP', '', '1', 'c4ca4238a0b923820dcc509a6f75849b', '2021-07-29 10:18:02', '2021-07-29 02:18:02', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 20, 'transport.threadFactory.clientWorkerThreadPrefix', 'SEATA_GROUP', '', 'NettyClientWorkerThread', '61cf4e69a56354cf72f46dc86414a57e', '2021-07-29 10:18:02', '2021-07-29 02:18:03', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 21, 'transport.threadFactory.bossThreadSize', 'SEATA_GROUP', '', '1', 'c4ca4238a0b923820dcc509a6f75849b', '2021-07-29 10:18:02', '2021-07-29 02:18:03', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 22, 'transport.threadFactory.workerThreadSize', 'SEATA_GROUP', '', 'default', 'c21f969b5f03d33d43e04f8f136e7682', '2021-07-29 10:18:02', '2021-07-29 02:18:03', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 23, 'transport.shutdown.wait', 'SEATA_GROUP', '', '3', 'eccbc87e4b5ce2fe28308fd9f2a7baf3', '2021-07-29 10:18:02', '2021-07-29 02:18:03', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 24, 'service.vgroupMapping.my_test_tx_group', 'SEATA_GROUP', '', 'default', 'c21f969b5f03d33d43e04f8f136e7682', '2021-07-29 10:18:02', '2021-07-29 02:18:03', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 25, 'service.default.grouplist', 'SEATA_GROUP', '', '127.0.0.1:8091', 'c32ce0d3e264525dcdada751f98143a3', '2021-07-29 10:18:03', '2021-07-29 02:18:03', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 26, 'service.enableDegrade', 'SEATA_GROUP', '', 'false', '68934a3e9455fa72420237eb05902327', '2021-07-29 10:18:03', '2021-07-29 02:18:03', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 27, 'service.disableGlobalTransaction', 'SEATA_GROUP', '', 'false', '68934a3e9455fa72420237eb05902327', '2021-07-29 10:18:03', '2021-07-29 02:18:03', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 28, 'client.rm.asyncCommitBufferLimit', 'SEATA_GROUP', '', '10000', 'b7a782741f667201b54880c925faec4b', '2021-07-29 10:18:03', '2021-07-29 02:18:03', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 29, 'client.rm.lock.retryInterval', 'SEATA_GROUP', '', '10', 'd3d9446802a44259755d38e6d163e820', '2021-07-29 10:18:03', '2021-07-29 02:18:03', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 30, 'client.rm.lock.retryTimes', 'SEATA_GROUP', '', '30', '34173cb38f07f89ddbebc2ac9128303f', '2021-07-29 10:18:03', '2021-07-29 02:18:03', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 31, 'client.rm.lock.retryPolicyBranchRollbackOnConflict', 'SEATA_GROUP', '', 'true', 'b326b5062b2f0e69046810717534cb09', '2021-07-29 10:18:03', '2021-07-29 02:18:03', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 32, 'client.rm.reportRetryCount', 'SEATA_GROUP', '', '5', 'e4da3b7fbbce2345d7772b0674a318d5', '2021-07-29 10:18:03', '2021-07-29 02:18:03', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 33, 'client.rm.tableMetaCheckEnable', 'SEATA_GROUP', '', 'false', '68934a3e9455fa72420237eb05902327', '2021-07-29 10:18:03', '2021-07-29 02:18:04', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 34, 'client.rm.sqlParserType', 'SEATA_GROUP', '', 'druid', '3d650fb8a5df01600281d48c47c9fa60', '2021-07-29 10:18:03', '2021-07-29 02:18:04', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 35, 'client.rm.reportSuccessEnable', 'SEATA_GROUP', '', 'false', '68934a3e9455fa72420237eb05902327', '2021-07-29 10:18:03', '2021-07-29 02:18:04', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 36, 'client.rm.sagaBranchRegisterEnable', 'SEATA_GROUP', '', 'false', '68934a3e9455fa72420237eb05902327', '2021-07-29 10:18:03', '2021-07-29 02:18:04', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 37, 'client.tm.commitRetryCount', 'SEATA_GROUP', '', '5', 'e4da3b7fbbce2345d7772b0674a318d5', '2021-07-29 10:18:03', '2021-07-29 02:18:04', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 38, 'client.tm.rollbackRetryCount', 'SEATA_GROUP', '', '5', 'e4da3b7fbbce2345d7772b0674a318d5', '2021-07-29 10:18:03', '2021-07-29 02:18:04', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 39, 'client.tm.degradeCheck', 'SEATA_GROUP', '', 'false', '68934a3e9455fa72420237eb05902327', '2021-07-29 10:18:03', '2021-07-29 02:18:04', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 40, 'client.tm.degradeCheckAllowTimes', 'SEATA_GROUP', '', '10', 'd3d9446802a44259755d38e6d163e820', '2021-07-29 10:18:03', '2021-07-29 02:18:04', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 41, 'client.tm.degradeCheckPeriod', 'SEATA_GROUP', '', '2000', '08f90c1a417155361a5c4b8d297e0d78', '2021-07-29 10:18:03', '2021-07-29 02:18:04', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 42, 'store.mode', 'SEATA_GROUP', '', 'db', 'd77d5e503ad1439f585ac494268b351b', '2021-07-29 10:18:04', '2021-07-29 02:18:04', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 43, 'store.file.dir', 'SEATA_GROUP', '', 'file_store/data', '6a8dec07c44c33a8a9247cba5710bbb2', '2021-07-29 10:18:04', '2021-07-29 02:18:04', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 44, 'store.file.maxBranchSessionSize', 'SEATA_GROUP', '', '16384', 'c76fe1d8e08462434d800487585be217', '2021-07-29 10:18:04', '2021-07-29 02:18:04', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 45, 'store.file.maxGlobalSessionSize', 'SEATA_GROUP', '', '512', '10a7cdd970fe135cf4f7bb55c0e3b59f', '2021-07-29 10:18:04', '2021-07-29 02:18:04', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 46, 'store.file.fileWriteBufferCacheSize', 'SEATA_GROUP', '', '16384', 'c76fe1d8e08462434d800487585be217', '2021-07-29 10:18:04', '2021-07-29 02:18:04', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 47, 'store.file.flushDiskMode', 'SEATA_GROUP', '', 'async', '0df93e34273b367bb63bad28c94c78d5', '2021-07-29 10:18:04', '2021-07-29 02:18:04', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 48, 'store.file.sessionReloadReadSize', 'SEATA_GROUP', '', '100', 'f899139df5e1059396431415e770c6dd', '2021-07-29 10:18:04', '2021-07-29 02:18:04', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 49, 'store.db.datasource', 'SEATA_GROUP', '', 'druid', '3d650fb8a5df01600281d48c47c9fa60', '2021-07-29 10:18:04', '2021-07-29 02:18:04', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 50, 'store.db.dbType', 'SEATA_GROUP', '', 'mysql', '81c3b080dad537de7e10e0987a4bf52e', '2021-07-29 10:18:04', '2021-07-29 02:18:05', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 51, 'store.db.driverClassName', 'SEATA_GROUP', '', 'com.mysql.cj.jdbc.Driver', '33763409bb7f4838bde4fae9540433e4', '2021-07-29 10:18:04', '2021-07-29 02:18:05', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 52, 'store.db.url', 'SEATA_GROUP', '', 'jdbc:mysql://127.0.0.1:3306/seata?useUnicode=true', 'cbb3bd573704f125fb4f2489208abaec', '2021-07-29 10:18:04', '2021-07-29 02:18:05', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 53, 'store.db.user', 'SEATA_GROUP', '', 'root', '63a9f0ea7bb98050796b649e85481845', '2021-07-29 10:18:04', '2021-07-29 02:18:05', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 54, 'store.db.password', 'SEATA_GROUP', '', '18420163207', 'd957aaa2e2b7c6f89c1e318b8dcb009d', '2021-07-29 10:18:04', '2021-07-29 02:18:05', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 55, 'store.db.minConn', 'SEATA_GROUP', '', '5', 'e4da3b7fbbce2345d7772b0674a318d5', '2021-07-29 10:18:04', '2021-07-29 02:18:05', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 56, 'store.db.maxConn', 'SEATA_GROUP', '', '30', '34173cb38f07f89ddbebc2ac9128303f', '2021-07-29 10:18:04', '2021-07-29 02:18:05', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 57, 'store.db.globalTable', 'SEATA_GROUP', '', 'global_table', '8b28fb6bb4c4f984df2709381f8eba2b', '2021-07-29 10:18:05', '2021-07-29 02:18:05', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 58, 'store.db.branchTable', 'SEATA_GROUP', '', 'branch_table', '54bcdac38cf62e103fe115bcf46a660c', '2021-07-29 10:18:05', '2021-07-29 02:18:05', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 59, 'store.db.queryLimit', 'SEATA_GROUP', '', '100', 'f899139df5e1059396431415e770c6dd', '2021-07-29 10:18:05', '2021-07-29 02:18:05', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 60, 'store.db.lockTable', 'SEATA_GROUP', '', 'lock_table', '55e0cae3b6dc6696b768db90098b8f2f', '2021-07-29 10:18:05', '2021-07-29 02:18:05', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 61, 'store.db.maxWait', 'SEATA_GROUP', '', '5000', 'a35fe7f7fe8217b4369a0af4244d1fca', '2021-07-29 10:18:05', '2021-07-29 02:18:05', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 62, 'store.redis.host', 'SEATA_GROUP', '', '127.0.0.1', 'f528764d624db129b32c21fbca0cb8d6', '2021-07-29 10:18:05', '2021-07-29 02:18:05', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 63, 'store.redis.port', 'SEATA_GROUP', '', '6379', '92c3b916311a5517d9290576e3ea37ad', '2021-07-29 10:18:05', '2021-07-29 02:18:05', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 64, 'store.redis.maxConn', 'SEATA_GROUP', '', '10', 'd3d9446802a44259755d38e6d163e820', '2021-07-29 10:18:05', '2021-07-29 02:18:05', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 65, 'store.redis.minConn', 'SEATA_GROUP', '', '1', 'c4ca4238a0b923820dcc509a6f75849b', '2021-07-29 10:18:05', '2021-07-29 02:18:05', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 66, 'store.redis.database', 'SEATA_GROUP', '', '0', 'cfcd208495d565ef66e7dff9f98764da', '2021-07-29 10:18:05', '2021-07-29 02:18:06', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 67, 'store.redis.password', 'SEATA_GROUP', '', 'null', '37a6259cc0c1dae299a7866489dff0bd', '2021-07-29 10:18:05', '2021-07-29 02:18:06', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 68, 'store.redis.queryLimit', 'SEATA_GROUP', '', '100', 'f899139df5e1059396431415e770c6dd', '2021-07-29 10:18:05', '2021-07-29 02:18:06', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 69, 'server.recovery.committingRetryPeriod', 'SEATA_GROUP', '', '1000', 'a9b7ba70783b617e9998dc4dd82eb3c5', '2021-07-29 10:18:05', '2021-07-29 02:18:06', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 70, 'server.recovery.asynCommittingRetryPeriod', 'SEATA_GROUP', '', '1000', 'a9b7ba70783b617e9998dc4dd82eb3c5', '2021-07-29 10:18:05', '2021-07-29 02:18:06', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 71, 'server.recovery.rollbackingRetryPeriod', 'SEATA_GROUP', '', '1000', 'a9b7ba70783b617e9998dc4dd82eb3c5', '2021-07-29 10:18:05', '2021-07-29 02:18:06', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 72, 'server.recovery.timeoutRetryPeriod', 'SEATA_GROUP', '', '1000', 'a9b7ba70783b617e9998dc4dd82eb3c5', '2021-07-29 10:18:05', '2021-07-29 02:18:06', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 73, 'server.maxCommitRetryTimeout', 'SEATA_GROUP', '', '-1', '6bb61e3b7bce0931da574d19d1d82c88', '2021-07-29 10:18:05', '2021-07-29 02:18:06', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 74, 'server.maxRollbackRetryTimeout', 'SEATA_GROUP', '', '-1', '6bb61e3b7bce0931da574d19d1d82c88', '2021-07-29 10:18:06', '2021-07-29 02:18:06', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 75, 'server.rollbackRetryTimeoutUnlockEnable', 'SEATA_GROUP', '', 'false', '68934a3e9455fa72420237eb05902327', '2021-07-29 10:18:06', '2021-07-29 02:18:06', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 76, 'client.undo.dataValidation', 'SEATA_GROUP', '', 'true', 'b326b5062b2f0e69046810717534cb09', '2021-07-29 10:18:06', '2021-07-29 02:18:06', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 77, 'client.undo.logSerialization', 'SEATA_GROUP', '', 'jackson', 'b41779690b83f182acc67d6388c7bac9', '2021-07-29 10:18:06', '2021-07-29 02:18:06', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 78, 'client.undo.onlyCareUpdateColumns', 'SEATA_GROUP', '', 'true', 'b326b5062b2f0e69046810717534cb09', '2021-07-29 10:18:06', '2021-07-29 02:18:06', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 79, 'server.undo.logSaveDays', 'SEATA_GROUP', '', '7', '8f14e45fceea167a5a36dedd4bea2543', '2021-07-29 10:18:06', '2021-07-29 02:18:06', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 80, 'server.undo.logDeletePeriod', 'SEATA_GROUP', '', '86400000', 'f4c122804fe9076cb2710f55c3c6e346', '2021-07-29 10:18:06', '2021-07-29 02:18:06', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 81, 'client.undo.logTable', 'SEATA_GROUP', '', 'undo_log', '2842d229c24afe9e61437135e8306614', '2021-07-29 10:18:06', '2021-07-29 02:18:06', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 82, 'client.log.exceptionRate', 'SEATA_GROUP', '', '100', 'f899139df5e1059396431415e770c6dd', '2021-07-29 10:18:06', '2021-07-29 02:18:06', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 83, 'transport.serialization', 'SEATA_GROUP', '', 'seata', 'b943081c423b9a5416a706524ee05d40', '2021-07-29 10:18:06', '2021-07-29 02:18:07', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 84, 'transport.compressor', 'SEATA_GROUP', '', 'none', '334c4a4c42fdb79d7ebc3e73b517e6f8', '2021-07-29 10:18:06', '2021-07-29 02:18:07', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 85, 'metrics.enabled', 'SEATA_GROUP', '', 'false', '68934a3e9455fa72420237eb05902327', '2021-07-29 10:18:06', '2021-07-29 02:18:07', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 86, 'metrics.registryType', 'SEATA_GROUP', '', 'compact', '7cf74ca49c304df8150205fc915cd465', '2021-07-29 10:18:06', '2021-07-29 02:18:07', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 87, 'metrics.exporterList', 'SEATA_GROUP', '', 'prometheus', 'e4f00638b8a10e6994e67af2f832d51c', '2021-07-29 10:18:06', '2021-07-29 02:18:07', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 88, 'metrics.exporterPrometheusPort', 'SEATA_GROUP', '', '9898', '7b9dc501afe4ee11c56a4831e20cee71', '2021-07-29 10:18:06', '2021-07-29 02:18:07', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (8, 89, 'transport.type', 'SEATA_GROUP', '', 'TCP', 'b136ef5f6a01d816991fe3cf7a6ac763', '2021-07-29 10:20:17', '2021-07-29 02:20:18', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (9, 90, 'transport.server', 'SEATA_GROUP', '', 'NIO', 'b6d9dfc0fb54277321cebc0fff55df2f', '2021-07-29 10:20:17', '2021-07-29 02:20:18', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (10, 91, 'transport.heartbeat', 'SEATA_GROUP', '', 'true', 'b326b5062b2f0e69046810717534cb09', '2021-07-29 10:20:17', '2021-07-29 02:20:18', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (0, 92, 'transport.thread-factory.boss-thread-prefix', 'SEATA_GROUP', '', 'NettyBoss', '0f8db59a3b7f2823f38a70c308361836', '2021-07-29 10:20:17', '2021-07-29 02:20:18', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 93, 'transport.thread-factory.worker-thread-prefix', 'SEATA_GROUP', '', 'NettyServerNIOWorker', 'a78ec7ef5d1631754c4e72ae8a3e9205', '2021-07-29 10:20:17', '2021-07-29 02:20:18', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 94, 'transport.thread-factory.server-executor-thread-prefix', 'SEATA_GROUP', '', 'NettyServerBizHandler', '11a36309f3d9df84fa8b59cf071fa2da', '2021-07-29 10:20:17', '2021-07-29 02:20:18', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 95, 'transport.thread-factory.share-boss-worker', 'SEATA_GROUP', '', 'false', '68934a3e9455fa72420237eb05902327', '2021-07-29 10:20:17', '2021-07-29 02:20:18', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 96, 'transport.thread-factory.client-selector-thread-prefix', 'SEATA_GROUP', '', 'NettyClientSelector', 'cd7ec5a06541e75f5a7913752322c3af', '2021-07-29 10:20:18', '2021-07-29 02:20:18', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 97, 'transport.thread-factory.client-selector-thread-size', 'SEATA_GROUP', '', '1', 'c4ca4238a0b923820dcc509a6f75849b', '2021-07-29 10:20:18', '2021-07-29 02:20:18', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 98, 'transport.thread-factory.client-worker-thread-prefix', 'SEATA_GROUP', '', 'NettyClientWorkerThread', '61cf4e69a56354cf72f46dc86414a57e', '2021-07-29 10:20:18', '2021-07-29 02:20:18', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 99, 'transport.thread-factory.boss-thread-size', 'SEATA_GROUP', '', '1', 'c4ca4238a0b923820dcc509a6f75849b', '2021-07-29 10:20:18', '2021-07-29 02:20:18', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 100, 'transport.thread-factory.worker-thread-size', 'SEATA_GROUP', '', '8', 'c9f0f895fb98ab9159f51fd0297e236d', '2021-07-29 10:20:18', '2021-07-29 02:20:18', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (21, 101, 'transport.shutdown.wait', 'SEATA_GROUP', '', '3', 'eccbc87e4b5ce2fe28308fd9f2a7baf3', '2021-07-29 10:20:18', '2021-07-29 02:20:18', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (22, 102, 'service.vgroupMapping.my_test_tx_group', 'SEATA_GROUP', '', 'default', 'c21f969b5f03d33d43e04f8f136e7682', '2021-07-29 10:20:18', '2021-07-29 02:20:18', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (24, 103, 'service.enableDegrade', 'SEATA_GROUP', '', 'false', '68934a3e9455fa72420237eb05902327', '2021-07-29 10:20:18', '2021-07-29 02:20:18', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (0, 104, 'service.disable', 'SEATA_GROUP', '', 'false', '68934a3e9455fa72420237eb05902327', '2021-07-29 10:20:18', '2021-07-29 02:20:18', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 105, 'service.max.commit.retry.timeout', 'SEATA_GROUP', '', '-1', '6bb61e3b7bce0931da574d19d1d82c88', '2021-07-29 10:20:18', '2021-07-29 02:20:18', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 106, 'service.max.rollback.retry.timeout', 'SEATA_GROUP', '', '-1', '6bb61e3b7bce0931da574d19d1d82c88', '2021-07-29 10:20:18', '2021-07-29 02:20:19', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 107, 'client.async.commit.buffer.limit', 'SEATA_GROUP', '', '10000', 'b7a782741f667201b54880c925faec4b', '2021-07-29 10:20:18', '2021-07-29 02:20:19', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 108, 'client.lock.retry.internal', 'SEATA_GROUP', '', '10', 'd3d9446802a44259755d38e6d163e820', '2021-07-29 10:20:18', '2021-07-29 02:20:19', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 109, 'client.lock.retry.times', 'SEATA_GROUP', '', '30', '34173cb38f07f89ddbebc2ac9128303f', '2021-07-29 10:20:18', '2021-07-29 02:20:19', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 110, 'client.lock.retry.policy.branch-rollback-on-conflict', 'SEATA_GROUP', '', 'true', 'b326b5062b2f0e69046810717534cb09', '2021-07-29 10:20:18', '2021-07-29 02:20:19', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 111, 'client.table.meta.check.enable', 'SEATA_GROUP', '', 'true', 'b326b5062b2f0e69046810717534cb09', '2021-07-29 10:20:18', '2021-07-29 02:20:19', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 112, 'client.report.retry.count', 'SEATA_GROUP', '', '5', 'e4da3b7fbbce2345d7772b0674a318d5', '2021-07-29 10:20:18', '2021-07-29 02:20:19', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 113, 'client.tm.commit.retry.count', 'SEATA_GROUP', '', '1', 'c4ca4238a0b923820dcc509a6f75849b', '2021-07-29 10:20:18', '2021-07-29 02:20:19', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 114, 'client.tm.rollback.retry.count', 'SEATA_GROUP', '', '1', 'c4ca4238a0b923820dcc509a6f75849b', '2021-07-29 10:20:18', '2021-07-29 02:20:19', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (40, 115, 'store.mode', 'SEATA_GROUP', '', 'db', 'd77d5e503ad1439f585ac494268b351b', '2021-07-29 10:20:18', '2021-07-29 02:20:19', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (41, 116, 'store.file.dir', 'SEATA_GROUP', '', 'file_store/data', '6a8dec07c44c33a8a9247cba5710bbb2', '2021-07-29 10:20:19', '2021-07-29 02:20:19', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (0, 117, 'store.file.max-branch-session-size', 'SEATA_GROUP', '', '16384', 'c76fe1d8e08462434d800487585be217', '2021-07-29 10:20:19', '2021-07-29 02:20:19', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 118, 'store.file.max-global-session-size', 'SEATA_GROUP', '', '512', '10a7cdd970fe135cf4f7bb55c0e3b59f', '2021-07-29 10:20:19', '2021-07-29 02:20:19', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 119, 'store.file.file-write-buffer-cache-size', 'SEATA_GROUP', '', '16384', 'c76fe1d8e08462434d800487585be217', '2021-07-29 10:20:19', '2021-07-29 02:20:19', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 120, 'store.file.flush-disk-mode', 'SEATA_GROUP', '', 'async', '0df93e34273b367bb63bad28c94c78d5', '2021-07-29 10:20:19', '2021-07-29 02:20:19', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 121, 'store.file.session.reload.read_size', 'SEATA_GROUP', '', '100', 'f899139df5e1059396431415e770c6dd', '2021-07-29 10:20:19', '2021-07-29 02:20:19', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (47, 122, 'store.db.datasource', 'SEATA_GROUP', '', 'druid', '3d650fb8a5df01600281d48c47c9fa60', '2021-07-29 10:20:19', '2021-07-29 02:20:19', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (0, 123, 'store.db.db-type', 'SEATA_GROUP', '', 'mysql', '81c3b080dad537de7e10e0987a4bf52e', '2021-07-29 10:20:19', '2021-07-29 02:20:19', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 124, 'store.db.driver-class-name', 'SEATA_GROUP', '', 'com.mysql.jdbc.Driver', '683cf0c3a5a56cec94dfac94ca16d760', '2021-07-29 10:20:19', '2021-07-29 02:20:19', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (50, 125, 'store.db.url', 'SEATA_GROUP', '', 'jdbc:mysql://127.0.0.1:3306/seata?useUnicode=true', 'cbb3bd573704f125fb4f2489208abaec', '2021-07-29 10:20:19', '2021-07-29 02:20:19', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (51, 126, 'store.db.user', 'SEATA_GROUP', '', 'root', '63a9f0ea7bb98050796b649e85481845', '2021-07-29 10:20:19', '2021-07-29 02:20:20', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (52, 127, 'store.db.password', 'SEATA_GROUP', '', '18420163207', 'd957aaa2e2b7c6f89c1e318b8dcb009d', '2021-07-29 10:20:19', '2021-07-29 02:20:20', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (0, 128, 'store.db.min-conn', 'SEATA_GROUP', '', '1', 'c4ca4238a0b923820dcc509a6f75849b', '2021-07-29 10:20:19', '2021-07-29 02:20:20', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 129, 'store.db.max-conn', 'SEATA_GROUP', '', '3', 'eccbc87e4b5ce2fe28308fd9f2a7baf3', '2021-07-29 10:20:19', '2021-07-29 02:20:20', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 130, 'store.db.global.table', 'SEATA_GROUP', '', 'global_table', '8b28fb6bb4c4f984df2709381f8eba2b', '2021-07-29 10:20:19', '2021-07-29 02:20:20', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 131, 'store.db.branch.table', 'SEATA_GROUP', '', 'branch_table', '54bcdac38cf62e103fe115bcf46a660c', '2021-07-29 10:20:19', '2021-07-29 02:20:20', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 132, 'store.db.query-limit', 'SEATA_GROUP', '', '100', 'f899139df5e1059396431415e770c6dd', '2021-07-29 10:20:19', '2021-07-29 02:20:20', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 133, 'store.db.lock-table', 'SEATA_GROUP', '', 'lock_table', '55e0cae3b6dc6696b768db90098b8f2f', '2021-07-29 10:20:19', '2021-07-29 02:20:20', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 134, 'recovery.committing-retry-period', 'SEATA_GROUP', '', '1000', 'a9b7ba70783b617e9998dc4dd82eb3c5', '2021-07-29 10:20:19', '2021-07-29 02:20:20', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 135, 'recovery.asyn-committing-retry-period', 'SEATA_GROUP', '', '1000', 'a9b7ba70783b617e9998dc4dd82eb3c5', '2021-07-29 10:20:20', '2021-07-29 02:20:20', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 136, 'recovery.rollbacking-retry-period', 'SEATA_GROUP', '', '1000', 'a9b7ba70783b617e9998dc4dd82eb3c5', '2021-07-29 10:20:20', '2021-07-29 02:20:20', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 137, 'recovery.timeout-retry-period', 'SEATA_GROUP', '', '1000', 'a9b7ba70783b617e9998dc4dd82eb3c5', '2021-07-29 10:20:20', '2021-07-29 02:20:20', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 138, 'transaction.undo.data.validation', 'SEATA_GROUP', '', 'true', 'b326b5062b2f0e69046810717534cb09', '2021-07-29 10:20:20', '2021-07-29 02:20:20', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 139, 'transaction.undo.log.serialization', 'SEATA_GROUP', '', 'jackson', 'b41779690b83f182acc67d6388c7bac9', '2021-07-29 10:20:20', '2021-07-29 02:20:20', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 140, 'transaction.undo.log.save.days', 'SEATA_GROUP', '', '7', '8f14e45fceea167a5a36dedd4bea2543', '2021-07-29 10:20:20', '2021-07-29 02:20:20', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 141, 'transaction.undo.log.delete.period', 'SEATA_GROUP', '', '86400000', 'f4c122804fe9076cb2710f55c3c6e346', '2021-07-29 10:20:20', '2021-07-29 02:20:20', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 142, 'transaction.undo.log.table', 'SEATA_GROUP', '', 'undo_log', '2842d229c24afe9e61437135e8306614', '2021-07-29 10:20:20', '2021-07-29 02:20:20', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (81, 143, 'transport.serialization', 'SEATA_GROUP', '', 'seata', 'b943081c423b9a5416a706524ee05d40', '2021-07-29 10:20:20', '2021-07-29 02:20:20', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (82, 144, 'transport.compressor', 'SEATA_GROUP', '', 'none', '334c4a4c42fdb79d7ebc3e73b517e6f8', '2021-07-29 10:20:20', '2021-07-29 02:20:20', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (83, 145, 'metrics.enabled', 'SEATA_GROUP', '', 'false', '68934a3e9455fa72420237eb05902327', '2021-07-29 10:20:20', '2021-07-29 02:20:21', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (0, 146, 'metrics.registry-type', 'SEATA_GROUP', '', 'compact', '7cf74ca49c304df8150205fc915cd465', '2021-07-29 10:20:20', '2021-07-29 02:20:21', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 147, 'metrics.exporter-list', 'SEATA_GROUP', '', 'prometheus', 'e4f00638b8a10e6994e67af2f832d51c', '2021-07-29 10:20:20', '2021-07-29 02:20:21', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 148, 'metrics.exporter-prometheus-port', 'SEATA_GROUP', '', '9898', '7b9dc501afe4ee11c56a4831e20cee71', '2021-07-29 10:20:20', '2021-07-29 02:20:21', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 149, 'support.spring.datasource.autoproxy', 'SEATA_GROUP', '', 'false', '68934a3e9455fa72420237eb05902327', '2021-07-29 10:20:20', '2021-07-29 02:20:21', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (8, 150, 'transport.type', 'SEATA_GROUP', '', 'TCP', 'b136ef5f6a01d816991fe3cf7a6ac763', '2021-07-29 10:21:26', '2021-07-29 02:21:27', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (9, 151, 'transport.server', 'SEATA_GROUP', '', 'NIO', 'b6d9dfc0fb54277321cebc0fff55df2f', '2021-07-29 10:21:26', '2021-07-29 02:21:27', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (10, 152, 'transport.heartbeat', 'SEATA_GROUP', '', 'true', 'b326b5062b2f0e69046810717534cb09', '2021-07-29 10:21:26', '2021-07-29 02:21:27', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (90, 153, 'transport.thread-factory.boss-thread-prefix', 'SEATA_GROUP', '', 'NettyBoss', '0f8db59a3b7f2823f38a70c308361836', '2021-07-29 10:21:27', '2021-07-29 02:21:27', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (91, 154, 'transport.thread-factory.worker-thread-prefix', 'SEATA_GROUP', '', 'NettyServerNIOWorker', 'a78ec7ef5d1631754c4e72ae8a3e9205', '2021-07-29 10:21:27', '2021-07-29 02:21:27', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (92, 155, 'transport.thread-factory.server-executor-thread-prefix', 'SEATA_GROUP', '', 'NettyServerBizHandler', '11a36309f3d9df84fa8b59cf071fa2da', '2021-07-29 10:21:27', '2021-07-29 02:21:27', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (93, 156, 'transport.thread-factory.share-boss-worker', 'SEATA_GROUP', '', 'false', '68934a3e9455fa72420237eb05902327', '2021-07-29 10:21:27', '2021-07-29 02:21:27', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (94, 157, 'transport.thread-factory.client-selector-thread-prefix', 'SEATA_GROUP', '', 'NettyClientSelector', 'cd7ec5a06541e75f5a7913752322c3af', '2021-07-29 10:21:27', '2021-07-29 02:21:27', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (95, 158, 'transport.thread-factory.client-selector-thread-size', 'SEATA_GROUP', '', '1', 'c4ca4238a0b923820dcc509a6f75849b', '2021-07-29 10:21:27', '2021-07-29 02:21:27', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (96, 159, 'transport.thread-factory.client-worker-thread-prefix', 'SEATA_GROUP', '', 'NettyClientWorkerThread', '61cf4e69a56354cf72f46dc86414a57e', '2021-07-29 10:21:27', '2021-07-29 02:21:27', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (97, 160, 'transport.thread-factory.boss-thread-size', 'SEATA_GROUP', '', '1', 'c4ca4238a0b923820dcc509a6f75849b', '2021-07-29 10:21:27', '2021-07-29 02:21:27', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (98, 161, 'transport.thread-factory.worker-thread-size', 'SEATA_GROUP', '', '8', 'c9f0f895fb98ab9159f51fd0297e236d', '2021-07-29 10:21:27', '2021-07-29 02:21:28', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (21, 162, 'transport.shutdown.wait', 'SEATA_GROUP', '', '3', 'eccbc87e4b5ce2fe28308fd9f2a7baf3', '2021-07-29 10:21:27', '2021-07-29 02:21:28', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (22, 163, 'service.vgroupMapping.my_test_tx_group', 'SEATA_GROUP', '', 'default', 'c21f969b5f03d33d43e04f8f136e7682', '2021-07-29 10:21:27', '2021-07-29 02:21:28', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (24, 164, 'service.enableDegrade', 'SEATA_GROUP', '', 'false', '68934a3e9455fa72420237eb05902327', '2021-07-29 10:21:27', '2021-07-29 02:21:28', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (102, 165, 'service.disable', 'SEATA_GROUP', '', 'false', '68934a3e9455fa72420237eb05902327', '2021-07-29 10:21:27', '2021-07-29 02:21:28', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (103, 166, 'service.max.commit.retry.timeout', 'SEATA_GROUP', '', '-1', '6bb61e3b7bce0931da574d19d1d82c88', '2021-07-29 10:21:27', '2021-07-29 02:21:28', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (104, 167, 'service.max.rollback.retry.timeout', 'SEATA_GROUP', '', '-1', '6bb61e3b7bce0931da574d19d1d82c88', '2021-07-29 10:21:27', '2021-07-29 02:21:28', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (105, 168, 'client.async.commit.buffer.limit', 'SEATA_GROUP', '', '10000', 'b7a782741f667201b54880c925faec4b', '2021-07-29 10:21:27', '2021-07-29 02:21:28', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (106, 169, 'client.lock.retry.internal', 'SEATA_GROUP', '', '10', 'd3d9446802a44259755d38e6d163e820', '2021-07-29 10:21:28', '2021-07-29 02:21:28', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (107, 170, 'client.lock.retry.times', 'SEATA_GROUP', '', '30', '34173cb38f07f89ddbebc2ac9128303f', '2021-07-29 10:21:28', '2021-07-29 02:21:28', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (108, 171, 'client.lock.retry.policy.branch-rollback-on-conflict', 'SEATA_GROUP', '', 'true', 'b326b5062b2f0e69046810717534cb09', '2021-07-29 10:21:28', '2021-07-29 02:21:28', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (109, 172, 'client.table.meta.check.enable', 'SEATA_GROUP', '', 'true', 'b326b5062b2f0e69046810717534cb09', '2021-07-29 10:21:28', '2021-07-29 02:21:28', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (110, 173, 'client.report.retry.count', 'SEATA_GROUP', '', '5', 'e4da3b7fbbce2345d7772b0674a318d5', '2021-07-29 10:21:28', '2021-07-29 02:21:28', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (111, 174, 'client.tm.commit.retry.count', 'SEATA_GROUP', '', '1', 'c4ca4238a0b923820dcc509a6f75849b', '2021-07-29 10:21:28', '2021-07-29 02:21:28', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (112, 175, 'client.tm.rollback.retry.count', 'SEATA_GROUP', '', '1', 'c4ca4238a0b923820dcc509a6f75849b', '2021-07-29 10:21:28', '2021-07-29 02:21:28', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (40, 176, 'store.mode', 'SEATA_GROUP', '', 'file', '8c7dd922ad47494fc02c388e12c00eac', '2021-07-29 10:21:28', '2021-07-29 02:21:28', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (41, 177, 'store.file.dir', 'SEATA_GROUP', '', 'file_store/data', '6a8dec07c44c33a8a9247cba5710bbb2', '2021-07-29 10:21:28', '2021-07-29 02:21:28', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (115, 178, 'store.file.max-branch-session-size', 'SEATA_GROUP', '', '16384', 'c76fe1d8e08462434d800487585be217', '2021-07-29 10:21:28', '2021-07-29 02:21:29', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (116, 179, 'store.file.max-global-session-size', 'SEATA_GROUP', '', '512', '10a7cdd970fe135cf4f7bb55c0e3b59f', '2021-07-29 10:21:28', '2021-07-29 02:21:29', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (117, 180, 'store.file.file-write-buffer-cache-size', 'SEATA_GROUP', '', '16384', 'c76fe1d8e08462434d800487585be217', '2021-07-29 10:21:28', '2021-07-29 02:21:29', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (118, 181, 'store.file.flush-disk-mode', 'SEATA_GROUP', '', 'async', '0df93e34273b367bb63bad28c94c78d5', '2021-07-29 10:21:28', '2021-07-29 02:21:29', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (119, 182, 'store.file.session.reload.read_size', 'SEATA_GROUP', '', '100', 'f899139df5e1059396431415e770c6dd', '2021-07-29 10:21:28', '2021-07-29 02:21:29', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (47, 183, 'store.db.datasource', 'SEATA_GROUP', '', 'dbcp', '3a9f384fb40c59fbdc67024ee97d94b1', '2021-07-29 10:21:28', '2021-07-29 02:21:29', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (121, 184, 'store.db.db-type', 'SEATA_GROUP', '', 'mysql', '81c3b080dad537de7e10e0987a4bf52e', '2021-07-29 10:21:28', '2021-07-29 02:21:29', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (122, 185, 'store.db.driver-class-name', 'SEATA_GROUP', '', 'com.mysql.jdbc.Driver', '683cf0c3a5a56cec94dfac94ca16d760', '2021-07-29 10:21:28', '2021-07-29 02:21:29', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (50, 186, 'store.db.url', 'SEATA_GROUP', '', 'jdbc:mysql://127.0.0.1:3306/seata?useUnicode=true', 'cbb3bd573704f125fb4f2489208abaec', '2021-07-29 10:21:28', '2021-07-29 02:21:29', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (51, 187, 'store.db.user', 'SEATA_GROUP', '', 'mysql', '81c3b080dad537de7e10e0987a4bf52e', '2021-07-29 10:21:28', '2021-07-29 02:21:29', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (52, 188, 'store.db.password', 'SEATA_GROUP', '', 'mysql', '81c3b080dad537de7e10e0987a4bf52e', '2021-07-29 10:21:29', '2021-07-29 02:21:29', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (126, 189, 'store.db.min-conn', 'SEATA_GROUP', '', '1', 'c4ca4238a0b923820dcc509a6f75849b', '2021-07-29 10:21:29', '2021-07-29 02:21:29', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (127, 190, 'store.db.max-conn', 'SEATA_GROUP', '', '3', 'eccbc87e4b5ce2fe28308fd9f2a7baf3', '2021-07-29 10:21:29', '2021-07-29 02:21:29', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (128, 191, 'store.db.global.table', 'SEATA_GROUP', '', 'global_table', '8b28fb6bb4c4f984df2709381f8eba2b', '2021-07-29 10:21:29', '2021-07-29 02:21:29', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (129, 192, 'store.db.branch.table', 'SEATA_GROUP', '', 'branch_table', '54bcdac38cf62e103fe115bcf46a660c', '2021-07-29 10:21:29', '2021-07-29 02:21:29', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (130, 193, 'store.db.query-limit', 'SEATA_GROUP', '', '100', 'f899139df5e1059396431415e770c6dd', '2021-07-29 10:21:29', '2021-07-29 02:21:29', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (131, 194, 'store.db.lock-table', 'SEATA_GROUP', '', 'lock_table', '55e0cae3b6dc6696b768db90098b8f2f', '2021-07-29 10:21:29', '2021-07-29 02:21:29', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (132, 195, 'recovery.committing-retry-period', 'SEATA_GROUP', '', '1000', 'a9b7ba70783b617e9998dc4dd82eb3c5', '2021-07-29 10:21:29', '2021-07-29 02:21:29', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (133, 196, 'recovery.asyn-committing-retry-period', 'SEATA_GROUP', '', '1000', 'a9b7ba70783b617e9998dc4dd82eb3c5', '2021-07-29 10:21:29', '2021-07-29 02:21:29', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (134, 197, 'recovery.rollbacking-retry-period', 'SEATA_GROUP', '', '1000', 'a9b7ba70783b617e9998dc4dd82eb3c5', '2021-07-29 10:21:29', '2021-07-29 02:21:29', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (135, 198, 'recovery.timeout-retry-period', 'SEATA_GROUP', '', '1000', 'a9b7ba70783b617e9998dc4dd82eb3c5', '2021-07-29 10:21:29', '2021-07-29 02:21:30', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (136, 199, 'transaction.undo.data.validation', 'SEATA_GROUP', '', 'true', 'b326b5062b2f0e69046810717534cb09', '2021-07-29 10:21:29', '2021-07-29 02:21:30', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (137, 200, 'transaction.undo.log.serialization', 'SEATA_GROUP', '', 'jackson', 'b41779690b83f182acc67d6388c7bac9', '2021-07-29 10:21:29', '2021-07-29 02:21:30', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (138, 201, 'transaction.undo.log.save.days', 'SEATA_GROUP', '', '7', '8f14e45fceea167a5a36dedd4bea2543', '2021-07-29 10:21:29', '2021-07-29 02:21:30', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (139, 202, 'transaction.undo.log.delete.period', 'SEATA_GROUP', '', '86400000', 'f4c122804fe9076cb2710f55c3c6e346', '2021-07-29 10:21:29', '2021-07-29 02:21:30', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (140, 203, 'transaction.undo.log.table', 'SEATA_GROUP', '', 'undo_log', '2842d229c24afe9e61437135e8306614', '2021-07-29 10:21:29', '2021-07-29 02:21:30', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (81, 204, 'transport.serialization', 'SEATA_GROUP', '', 'seata', 'b943081c423b9a5416a706524ee05d40', '2021-07-29 10:21:29', '2021-07-29 02:21:30', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (82, 205, 'transport.compressor', 'SEATA_GROUP', '', 'none', '334c4a4c42fdb79d7ebc3e73b517e6f8', '2021-07-29 10:21:30', '2021-07-29 02:21:30', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (83, 206, 'metrics.enabled', 'SEATA_GROUP', '', 'false', '68934a3e9455fa72420237eb05902327', '2021-07-29 10:21:30', '2021-07-29 02:21:30', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (144, 207, 'metrics.registry-type', 'SEATA_GROUP', '', 'compact', '7cf74ca49c304df8150205fc915cd465', '2021-07-29 10:21:30', '2021-07-29 02:21:30', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (145, 208, 'metrics.exporter-list', 'SEATA_GROUP', '', 'prometheus', 'e4f00638b8a10e6994e67af2f832d51c', '2021-07-29 10:21:30', '2021-07-29 02:21:30', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (146, 209, 'metrics.exporter-prometheus-port', 'SEATA_GROUP', '', '9898', '7b9dc501afe4ee11c56a4831e20cee71', '2021-07-29 10:21:30', '2021-07-29 02:21:30', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (147, 210, 'support.spring.datasource.autoproxy', 'SEATA_GROUP', '', 'false', '68934a3e9455fa72420237eb05902327', '2021-07-29 10:21:30', '2021-07-29 02:21:30', NULL, '127.0.0.1', 'U', '');
INSERT INTO `his_config_info` VALUES (8, 211, 'transport.type', 'SEATA_GROUP', '', 'TCP', 'b136ef5f6a01d816991fe3cf7a6ac763', '2021-07-29 10:22:40', '2021-07-29 02:22:41', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (9, 212, 'transport.server', 'SEATA_GROUP', '', 'NIO', 'b6d9dfc0fb54277321cebc0fff55df2f', '2021-07-29 10:22:40', '2021-07-29 02:22:41', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (10, 213, 'transport.heartbeat', 'SEATA_GROUP', '', 'true', 'b326b5062b2f0e69046810717534cb09', '2021-07-29 10:22:40', '2021-07-29 02:22:41', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (11, 214, 'transport.enableClientBatchSendRequest', 'SEATA_GROUP', '', 'false', '68934a3e9455fa72420237eb05902327', '2021-07-29 10:22:40', '2021-07-29 02:22:41', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (12, 215, 'transport.threadFactory.bossThreadPrefix', 'SEATA_GROUP', '', 'NettyBoss', '0f8db59a3b7f2823f38a70c308361836', '2021-07-29 10:22:40', '2021-07-29 02:22:41', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (13, 216, 'transport.threadFactory.workerThreadPrefix', 'SEATA_GROUP', '', 'NettyServerNIOWorker', 'a78ec7ef5d1631754c4e72ae8a3e9205', '2021-07-29 10:22:40', '2021-07-29 02:22:41', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (14, 217, 'transport.threadFactory.serverExecutorThreadPrefix', 'SEATA_GROUP', '', 'NettyServerBizHandler', '11a36309f3d9df84fa8b59cf071fa2da', '2021-07-29 10:22:40', '2021-07-29 02:22:41', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (22, 218, 'service.vgroupMapping.my_test_tx_group', 'SEATA_GROUP', '', 'default', 'c21f969b5f03d33d43e04f8f136e7682', '2021-07-29 10:22:49', '2021-07-29 02:22:50', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (23, 219, 'service.default.grouplist', 'SEATA_GROUP', '', '127.0.0.1:8091', 'c32ce0d3e264525dcdada751f98143a3', '2021-07-29 10:22:49', '2021-07-29 02:22:50', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (24, 220, 'service.enableDegrade', 'SEATA_GROUP', '', 'false', '68934a3e9455fa72420237eb05902327', '2021-07-29 10:22:49', '2021-07-29 02:22:50', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (25, 221, 'service.disableGlobalTransaction', 'SEATA_GROUP', '', 'false', '68934a3e9455fa72420237eb05902327', '2021-07-29 10:22:49', '2021-07-29 02:22:50', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (26, 222, 'client.rm.asyncCommitBufferLimit', 'SEATA_GROUP', '', '10000', 'b7a782741f667201b54880c925faec4b', '2021-07-29 10:22:49', '2021-07-29 02:22:50', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (27, 223, 'client.rm.lock.retryInterval', 'SEATA_GROUP', '', '10', 'd3d9446802a44259755d38e6d163e820', '2021-07-29 10:22:49', '2021-07-29 02:22:50', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (28, 224, 'client.rm.lock.retryTimes', 'SEATA_GROUP', '', '30', '34173cb38f07f89ddbebc2ac9128303f', '2021-07-29 10:22:49', '2021-07-29 02:22:50', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (29, 225, 'client.rm.lock.retryPolicyBranchRollbackOnConflict', 'SEATA_GROUP', '', 'true', 'b326b5062b2f0e69046810717534cb09', '2021-07-29 10:22:49', '2021-07-29 02:22:50', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (30, 226, 'client.rm.reportRetryCount', 'SEATA_GROUP', '', '5', 'e4da3b7fbbce2345d7772b0674a318d5', '2021-07-29 10:22:49', '2021-07-29 02:22:50', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (31, 227, 'client.rm.tableMetaCheckEnable', 'SEATA_GROUP', '', 'false', '68934a3e9455fa72420237eb05902327', '2021-07-29 10:22:49', '2021-07-29 02:22:50', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (32, 228, 'client.rm.sqlParserType', 'SEATA_GROUP', '', 'druid', '3d650fb8a5df01600281d48c47c9fa60', '2021-07-29 10:22:55', '2021-07-29 02:22:56', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (33, 229, 'client.rm.reportSuccessEnable', 'SEATA_GROUP', '', 'false', '68934a3e9455fa72420237eb05902327', '2021-07-29 10:22:55', '2021-07-29 02:22:56', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (34, 230, 'client.rm.sagaBranchRegisterEnable', 'SEATA_GROUP', '', 'false', '68934a3e9455fa72420237eb05902327', '2021-07-29 10:22:55', '2021-07-29 02:22:56', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (35, 231, 'client.tm.commitRetryCount', 'SEATA_GROUP', '', '5', 'e4da3b7fbbce2345d7772b0674a318d5', '2021-07-29 10:22:55', '2021-07-29 02:22:56', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (36, 232, 'client.tm.rollbackRetryCount', 'SEATA_GROUP', '', '5', 'e4da3b7fbbce2345d7772b0674a318d5', '2021-07-29 10:22:55', '2021-07-29 02:22:56', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (37, 233, 'client.tm.degradeCheck', 'SEATA_GROUP', '', 'false', '68934a3e9455fa72420237eb05902327', '2021-07-29 10:22:55', '2021-07-29 02:22:56', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (38, 234, 'client.tm.degradeCheckAllowTimes', 'SEATA_GROUP', '', '10', 'd3d9446802a44259755d38e6d163e820', '2021-07-29 10:22:55', '2021-07-29 02:22:56', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (39, 235, 'client.tm.degradeCheckPeriod', 'SEATA_GROUP', '', '2000', '08f90c1a417155361a5c4b8d297e0d78', '2021-07-29 10:22:55', '2021-07-29 02:22:56', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (40, 236, 'store.mode', 'SEATA_GROUP', '', 'file', '8c7dd922ad47494fc02c388e12c00eac', '2021-07-29 10:22:55', '2021-07-29 02:22:56', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (41, 237, 'store.file.dir', 'SEATA_GROUP', '', 'file_store/data', '6a8dec07c44c33a8a9247cba5710bbb2', '2021-07-29 10:22:55', '2021-07-29 02:22:56', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (15, 238, 'transport.threadFactory.shareBossWorker', 'SEATA_GROUP', '', 'false', '68934a3e9455fa72420237eb05902327', '2021-07-29 10:23:02', '2021-07-29 02:23:03', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (16, 239, 'transport.threadFactory.clientSelectorThreadPrefix', 'SEATA_GROUP', '', 'NettyClientSelector', 'cd7ec5a06541e75f5a7913752322c3af', '2021-07-29 10:23:02', '2021-07-29 02:23:03', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (17, 240, 'transport.threadFactory.clientSelectorThreadSize', 'SEATA_GROUP', '', '1', 'c4ca4238a0b923820dcc509a6f75849b', '2021-07-29 10:23:02', '2021-07-29 02:23:03', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (18, 241, 'transport.threadFactory.clientWorkerThreadPrefix', 'SEATA_GROUP', '', 'NettyClientWorkerThread', '61cf4e69a56354cf72f46dc86414a57e', '2021-07-29 10:23:02', '2021-07-29 02:23:03', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (19, 242, 'transport.threadFactory.bossThreadSize', 'SEATA_GROUP', '', '1', 'c4ca4238a0b923820dcc509a6f75849b', '2021-07-29 10:23:02', '2021-07-29 02:23:03', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (20, 243, 'transport.threadFactory.workerThreadSize', 'SEATA_GROUP', '', 'default', 'c21f969b5f03d33d43e04f8f136e7682', '2021-07-29 10:23:02', '2021-07-29 02:23:03', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (21, 244, 'transport.shutdown.wait', 'SEATA_GROUP', '', '3', 'eccbc87e4b5ce2fe28308fd9f2a7baf3', '2021-07-29 10:23:02', '2021-07-29 02:23:03', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (144, 245, 'metrics.registry-type', 'SEATA_GROUP', '', 'compact', '7cf74ca49c304df8150205fc915cd465', '2021-07-29 10:23:10', '2021-07-29 02:23:10', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (145, 246, 'metrics.exporter-list', 'SEATA_GROUP', '', 'prometheus', 'e4f00638b8a10e6994e67af2f832d51c', '2021-07-29 10:23:10', '2021-07-29 02:23:10', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (146, 247, 'metrics.exporter-prometheus-port', 'SEATA_GROUP', '', '9898', '7b9dc501afe4ee11c56a4831e20cee71', '2021-07-29 10:23:10', '2021-07-29 02:23:10', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (147, 248, 'support.spring.datasource.autoproxy', 'SEATA_GROUP', '', 'false', '68934a3e9455fa72420237eb05902327', '2021-07-29 10:23:10', '2021-07-29 02:23:10', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (131, 249, 'store.db.lock-table', 'SEATA_GROUP', '', 'lock_table', '55e0cae3b6dc6696b768db90098b8f2f', '2021-07-29 10:23:15', '2021-07-29 02:23:15', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (132, 250, 'recovery.committing-retry-period', 'SEATA_GROUP', '', '1000', 'a9b7ba70783b617e9998dc4dd82eb3c5', '2021-07-29 10:23:15', '2021-07-29 02:23:15', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (133, 251, 'recovery.asyn-committing-retry-period', 'SEATA_GROUP', '', '1000', 'a9b7ba70783b617e9998dc4dd82eb3c5', '2021-07-29 10:23:15', '2021-07-29 02:23:15', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (134, 252, 'recovery.rollbacking-retry-period', 'SEATA_GROUP', '', '1000', 'a9b7ba70783b617e9998dc4dd82eb3c5', '2021-07-29 10:23:15', '2021-07-29 02:23:15', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (135, 253, 'recovery.timeout-retry-period', 'SEATA_GROUP', '', '1000', 'a9b7ba70783b617e9998dc4dd82eb3c5', '2021-07-29 10:23:15', '2021-07-29 02:23:15', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (136, 254, 'transaction.undo.data.validation', 'SEATA_GROUP', '', 'true', 'b326b5062b2f0e69046810717534cb09', '2021-07-29 10:23:15', '2021-07-29 02:23:15', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (137, 255, 'transaction.undo.log.serialization', 'SEATA_GROUP', '', 'jackson', 'b41779690b83f182acc67d6388c7bac9', '2021-07-29 10:23:15', '2021-07-29 02:23:15', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (138, 256, 'transaction.undo.log.save.days', 'SEATA_GROUP', '', '7', '8f14e45fceea167a5a36dedd4bea2543', '2021-07-29 10:23:15', '2021-07-29 02:23:15', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (139, 257, 'transaction.undo.log.delete.period', 'SEATA_GROUP', '', '86400000', 'f4c122804fe9076cb2710f55c3c6e346', '2021-07-29 10:23:15', '2021-07-29 02:23:15', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (140, 258, 'transaction.undo.log.table', 'SEATA_GROUP', '', 'undo_log', '2842d229c24afe9e61437135e8306614', '2021-07-29 10:23:15', '2021-07-29 02:23:15', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (117, 259, 'store.file.file-write-buffer-cache-size', 'SEATA_GROUP', '', '16384', 'c76fe1d8e08462434d800487585be217', '2021-07-29 10:23:19', '2021-07-29 02:23:20', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (118, 260, 'store.file.flush-disk-mode', 'SEATA_GROUP', '', 'async', '0df93e34273b367bb63bad28c94c78d5', '2021-07-29 10:23:19', '2021-07-29 02:23:20', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (119, 261, 'store.file.session.reload.read_size', 'SEATA_GROUP', '', '100', 'f899139df5e1059396431415e770c6dd', '2021-07-29 10:23:19', '2021-07-29 02:23:20', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (121, 262, 'store.db.db-type', 'SEATA_GROUP', '', 'mysql', '81c3b080dad537de7e10e0987a4bf52e', '2021-07-29 10:23:19', '2021-07-29 02:23:20', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (122, 263, 'store.db.driver-class-name', 'SEATA_GROUP', '', 'com.mysql.jdbc.Driver', '683cf0c3a5a56cec94dfac94ca16d760', '2021-07-29 10:23:19', '2021-07-29 02:23:20', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (126, 264, 'store.db.min-conn', 'SEATA_GROUP', '', '1', 'c4ca4238a0b923820dcc509a6f75849b', '2021-07-29 10:23:19', '2021-07-29 02:23:20', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (127, 265, 'store.db.max-conn', 'SEATA_GROUP', '', '3', 'eccbc87e4b5ce2fe28308fd9f2a7baf3', '2021-07-29 10:23:19', '2021-07-29 02:23:20', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (128, 266, 'store.db.global.table', 'SEATA_GROUP', '', 'global_table', '8b28fb6bb4c4f984df2709381f8eba2b', '2021-07-29 10:23:19', '2021-07-29 02:23:20', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (129, 267, 'store.db.branch.table', 'SEATA_GROUP', '', 'branch_table', '54bcdac38cf62e103fe115bcf46a660c', '2021-07-29 10:23:19', '2021-07-29 02:23:20', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (130, 268, 'store.db.query-limit', 'SEATA_GROUP', '', '100', 'f899139df5e1059396431415e770c6dd', '2021-07-29 10:23:19', '2021-07-29 02:23:20', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (105, 269, 'client.async.commit.buffer.limit', 'SEATA_GROUP', '', '10000', 'b7a782741f667201b54880c925faec4b', '2021-07-29 10:23:23', '2021-07-29 02:23:24', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (106, 270, 'client.lock.retry.internal', 'SEATA_GROUP', '', '10', 'd3d9446802a44259755d38e6d163e820', '2021-07-29 10:23:23', '2021-07-29 02:23:24', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (107, 271, 'client.lock.retry.times', 'SEATA_GROUP', '', '30', '34173cb38f07f89ddbebc2ac9128303f', '2021-07-29 10:23:23', '2021-07-29 02:23:24', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (108, 272, 'client.lock.retry.policy.branch-rollback-on-conflict', 'SEATA_GROUP', '', 'true', 'b326b5062b2f0e69046810717534cb09', '2021-07-29 10:23:23', '2021-07-29 02:23:24', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (109, 273, 'client.table.meta.check.enable', 'SEATA_GROUP', '', 'true', 'b326b5062b2f0e69046810717534cb09', '2021-07-29 10:23:23', '2021-07-29 02:23:24', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (110, 274, 'client.report.retry.count', 'SEATA_GROUP', '', '5', 'e4da3b7fbbce2345d7772b0674a318d5', '2021-07-29 10:23:23', '2021-07-29 02:23:24', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (111, 275, 'client.tm.commit.retry.count', 'SEATA_GROUP', '', '1', 'c4ca4238a0b923820dcc509a6f75849b', '2021-07-29 10:23:23', '2021-07-29 02:23:24', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (112, 276, 'client.tm.rollback.retry.count', 'SEATA_GROUP', '', '1', 'c4ca4238a0b923820dcc509a6f75849b', '2021-07-29 10:23:23', '2021-07-29 02:23:24', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (115, 277, 'store.file.max-branch-session-size', 'SEATA_GROUP', '', '16384', 'c76fe1d8e08462434d800487585be217', '2021-07-29 10:23:23', '2021-07-29 02:23:24', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (116, 278, 'store.file.max-global-session-size', 'SEATA_GROUP', '', '512', '10a7cdd970fe135cf4f7bb55c0e3b59f', '2021-07-29 10:23:23', '2021-07-29 02:23:24', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (92, 279, 'transport.thread-factory.server-executor-thread-prefix', 'SEATA_GROUP', '', 'NettyServerBizHandler', '11a36309f3d9df84fa8b59cf071fa2da', '2021-07-29 10:23:27', '2021-07-29 02:23:28', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (93, 280, 'transport.thread-factory.share-boss-worker', 'SEATA_GROUP', '', 'false', '68934a3e9455fa72420237eb05902327', '2021-07-29 10:23:27', '2021-07-29 02:23:28', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (94, 281, 'transport.thread-factory.client-selector-thread-prefix', 'SEATA_GROUP', '', 'NettyClientSelector', 'cd7ec5a06541e75f5a7913752322c3af', '2021-07-29 10:23:27', '2021-07-29 02:23:28', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (95, 282, 'transport.thread-factory.client-selector-thread-size', 'SEATA_GROUP', '', '1', 'c4ca4238a0b923820dcc509a6f75849b', '2021-07-29 10:23:27', '2021-07-29 02:23:28', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (96, 283, 'transport.thread-factory.client-worker-thread-prefix', 'SEATA_GROUP', '', 'NettyClientWorkerThread', '61cf4e69a56354cf72f46dc86414a57e', '2021-07-29 10:23:27', '2021-07-29 02:23:28', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (97, 284, 'transport.thread-factory.boss-thread-size', 'SEATA_GROUP', '', '1', 'c4ca4238a0b923820dcc509a6f75849b', '2021-07-29 10:23:27', '2021-07-29 02:23:28', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (98, 285, 'transport.thread-factory.worker-thread-size', 'SEATA_GROUP', '', '8', 'c9f0f895fb98ab9159f51fd0297e236d', '2021-07-29 10:23:27', '2021-07-29 02:23:28', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (102, 286, 'service.disable', 'SEATA_GROUP', '', 'false', '68934a3e9455fa72420237eb05902327', '2021-07-29 10:23:27', '2021-07-29 02:23:28', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (103, 287, 'service.max.commit.retry.timeout', 'SEATA_GROUP', '', '-1', '6bb61e3b7bce0931da574d19d1d82c88', '2021-07-29 10:23:27', '2021-07-29 02:23:28', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (104, 288, 'service.max.rollback.retry.timeout', 'SEATA_GROUP', '', '-1', '6bb61e3b7bce0931da574d19d1d82c88', '2021-07-29 10:23:27', '2021-07-29 02:23:28', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (79, 289, 'client.undo.logTable', 'SEATA_GROUP', '', 'undo_log', '2842d229c24afe9e61437135e8306614', '2021-07-29 10:23:33', '2021-07-29 02:23:33', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (80, 290, 'client.log.exceptionRate', 'SEATA_GROUP', '', '100', 'f899139df5e1059396431415e770c6dd', '2021-07-29 10:23:33', '2021-07-29 02:23:33', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (81, 291, 'transport.serialization', 'SEATA_GROUP', '', 'seata', 'b943081c423b9a5416a706524ee05d40', '2021-07-29 10:23:33', '2021-07-29 02:23:33', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (82, 292, 'transport.compressor', 'SEATA_GROUP', '', 'none', '334c4a4c42fdb79d7ebc3e73b517e6f8', '2021-07-29 10:23:33', '2021-07-29 02:23:33', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (83, 293, 'metrics.enabled', 'SEATA_GROUP', '', 'false', '68934a3e9455fa72420237eb05902327', '2021-07-29 10:23:33', '2021-07-29 02:23:33', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (84, 294, 'metrics.registryType', 'SEATA_GROUP', '', 'compact', '7cf74ca49c304df8150205fc915cd465', '2021-07-29 10:23:33', '2021-07-29 02:23:33', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (85, 295, 'metrics.exporterList', 'SEATA_GROUP', '', 'prometheus', 'e4f00638b8a10e6994e67af2f832d51c', '2021-07-29 10:23:33', '2021-07-29 02:23:33', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (86, 296, 'metrics.exporterPrometheusPort', 'SEATA_GROUP', '', '9898', '7b9dc501afe4ee11c56a4831e20cee71', '2021-07-29 10:23:33', '2021-07-29 02:23:33', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (90, 297, 'transport.thread-factory.boss-thread-prefix', 'SEATA_GROUP', '', 'NettyBoss', '0f8db59a3b7f2823f38a70c308361836', '2021-07-29 10:23:33', '2021-07-29 02:23:33', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (91, 298, 'transport.thread-factory.worker-thread-prefix', 'SEATA_GROUP', '', 'NettyServerNIOWorker', 'a78ec7ef5d1631754c4e72ae8a3e9205', '2021-07-29 10:23:33', '2021-07-29 02:23:33', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (69, 299, 'server.recovery.rollbackingRetryPeriod', 'SEATA_GROUP', '', '1000', 'a9b7ba70783b617e9998dc4dd82eb3c5', '2021-07-29 10:23:37', '2021-07-29 02:23:37', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (70, 300, 'server.recovery.timeoutRetryPeriod', 'SEATA_GROUP', '', '1000', 'a9b7ba70783b617e9998dc4dd82eb3c5', '2021-07-29 10:23:37', '2021-07-29 02:23:37', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (71, 301, 'server.maxCommitRetryTimeout', 'SEATA_GROUP', '', '-1', '6bb61e3b7bce0931da574d19d1d82c88', '2021-07-29 10:23:37', '2021-07-29 02:23:37', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (72, 302, 'server.maxRollbackRetryTimeout', 'SEATA_GROUP', '', '-1', '6bb61e3b7bce0931da574d19d1d82c88', '2021-07-29 10:23:37', '2021-07-29 02:23:37', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (73, 303, 'server.rollbackRetryTimeoutUnlockEnable', 'SEATA_GROUP', '', 'false', '68934a3e9455fa72420237eb05902327', '2021-07-29 10:23:37', '2021-07-29 02:23:37', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (74, 304, 'client.undo.dataValidation', 'SEATA_GROUP', '', 'true', 'b326b5062b2f0e69046810717534cb09', '2021-07-29 10:23:37', '2021-07-29 02:23:37', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (75, 305, 'client.undo.logSerialization', 'SEATA_GROUP', '', 'jackson', 'b41779690b83f182acc67d6388c7bac9', '2021-07-29 10:23:37', '2021-07-29 02:23:37', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (76, 306, 'client.undo.onlyCareUpdateColumns', 'SEATA_GROUP', '', 'true', 'b326b5062b2f0e69046810717534cb09', '2021-07-29 10:23:37', '2021-07-29 02:23:37', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (77, 307, 'server.undo.logSaveDays', 'SEATA_GROUP', '', '7', '8f14e45fceea167a5a36dedd4bea2543', '2021-07-29 10:23:37', '2021-07-29 02:23:37', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (78, 308, 'server.undo.logDeletePeriod', 'SEATA_GROUP', '', '86400000', 'f4c122804fe9076cb2710f55c3c6e346', '2021-07-29 10:23:37', '2021-07-29 02:23:37', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (59, 309, 'store.db.maxWait', 'SEATA_GROUP', '', '5000', 'a35fe7f7fe8217b4369a0af4244d1fca', '2021-07-29 10:23:41', '2021-07-29 02:23:42', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (60, 310, 'store.redis.host', 'SEATA_GROUP', '', '127.0.0.1', 'f528764d624db129b32c21fbca0cb8d6', '2021-07-29 10:23:41', '2021-07-29 02:23:42', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (61, 311, 'store.redis.port', 'SEATA_GROUP', '', '6379', '92c3b916311a5517d9290576e3ea37ad', '2021-07-29 10:23:41', '2021-07-29 02:23:42', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (62, 312, 'store.redis.maxConn', 'SEATA_GROUP', '', '10', 'd3d9446802a44259755d38e6d163e820', '2021-07-29 10:23:41', '2021-07-29 02:23:42', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (63, 313, 'store.redis.minConn', 'SEATA_GROUP', '', '1', 'c4ca4238a0b923820dcc509a6f75849b', '2021-07-29 10:23:41', '2021-07-29 02:23:42', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (64, 314, 'store.redis.database', 'SEATA_GROUP', '', '0', 'cfcd208495d565ef66e7dff9f98764da', '2021-07-29 10:23:41', '2021-07-29 02:23:42', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (65, 315, 'store.redis.password', 'SEATA_GROUP', '', 'null', '37a6259cc0c1dae299a7866489dff0bd', '2021-07-29 10:23:41', '2021-07-29 02:23:42', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (66, 316, 'store.redis.queryLimit', 'SEATA_GROUP', '', '100', 'f899139df5e1059396431415e770c6dd', '2021-07-29 10:23:41', '2021-07-29 02:23:42', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (67, 317, 'server.recovery.committingRetryPeriod', 'SEATA_GROUP', '', '1000', 'a9b7ba70783b617e9998dc4dd82eb3c5', '2021-07-29 10:23:41', '2021-07-29 02:23:42', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (68, 318, 'server.recovery.asynCommittingRetryPeriod', 'SEATA_GROUP', '', '1000', 'a9b7ba70783b617e9998dc4dd82eb3c5', '2021-07-29 10:23:41', '2021-07-29 02:23:42', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (49, 319, 'store.db.driverClassName', 'SEATA_GROUP', '', 'com.mysql.cj.jdbc.Driver', '33763409bb7f4838bde4fae9540433e4', '2021-07-29 10:23:46', '2021-07-29 02:23:46', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (50, 320, 'store.db.url', 'SEATA_GROUP', '', 'jdbc:mysql://127.0.0.1:3306/seata?useUnicode=true', 'cbb3bd573704f125fb4f2489208abaec', '2021-07-29 10:23:46', '2021-07-29 02:23:46', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (51, 321, 'store.db.user', 'SEATA_GROUP', '', 'mysql', '81c3b080dad537de7e10e0987a4bf52e', '2021-07-29 10:23:46', '2021-07-29 02:23:46', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (52, 322, 'store.db.password', 'SEATA_GROUP', '', 'mysql', '81c3b080dad537de7e10e0987a4bf52e', '2021-07-29 10:23:46', '2021-07-29 02:23:46', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (53, 323, 'store.db.minConn', 'SEATA_GROUP', '', '5', 'e4da3b7fbbce2345d7772b0674a318d5', '2021-07-29 10:23:46', '2021-07-29 02:23:46', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (54, 324, 'store.db.maxConn', 'SEATA_GROUP', '', '30', '34173cb38f07f89ddbebc2ac9128303f', '2021-07-29 10:23:46', '2021-07-29 02:23:46', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (55, 325, 'store.db.globalTable', 'SEATA_GROUP', '', 'global_table', '8b28fb6bb4c4f984df2709381f8eba2b', '2021-07-29 10:23:46', '2021-07-29 02:23:46', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (56, 326, 'store.db.branchTable', 'SEATA_GROUP', '', 'branch_table', '54bcdac38cf62e103fe115bcf46a660c', '2021-07-29 10:23:46', '2021-07-29 02:23:46', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (57, 327, 'store.db.queryLimit', 'SEATA_GROUP', '', '100', 'f899139df5e1059396431415e770c6dd', '2021-07-29 10:23:46', '2021-07-29 02:23:46', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (58, 328, 'store.db.lockTable', 'SEATA_GROUP', '', 'lock_table', '55e0cae3b6dc6696b768db90098b8f2f', '2021-07-29 10:23:46', '2021-07-29 02:23:46', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (42, 329, 'store.file.maxBranchSessionSize', 'SEATA_GROUP', '', '16384', 'c76fe1d8e08462434d800487585be217', '2021-07-29 10:23:52', '2021-07-29 02:23:52', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (43, 330, 'store.file.maxGlobalSessionSize', 'SEATA_GROUP', '', '512', '10a7cdd970fe135cf4f7bb55c0e3b59f', '2021-07-29 10:23:52', '2021-07-29 02:23:52', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (44, 331, 'store.file.fileWriteBufferCacheSize', 'SEATA_GROUP', '', '16384', 'c76fe1d8e08462434d800487585be217', '2021-07-29 10:23:52', '2021-07-29 02:23:52', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (45, 332, 'store.file.flushDiskMode', 'SEATA_GROUP', '', 'async', '0df93e34273b367bb63bad28c94c78d5', '2021-07-29 10:23:52', '2021-07-29 02:23:52', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (46, 333, 'store.file.sessionReloadReadSize', 'SEATA_GROUP', '', '100', 'f899139df5e1059396431415e770c6dd', '2021-07-29 10:23:52', '2021-07-29 02:23:52', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (47, 334, 'store.db.datasource', 'SEATA_GROUP', '', 'dbcp', '3a9f384fb40c59fbdc67024ee97d94b1', '2021-07-29 10:23:52', '2021-07-29 02:23:52', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (48, 335, 'store.db.dbType', 'SEATA_GROUP', '', 'mysql', '81c3b080dad537de7e10e0987a4bf52e', '2021-07-29 10:23:52', '2021-07-29 02:23:52', NULL, '127.0.0.1', 'D', '');
INSERT INTO `his_config_info` VALUES (0, 336, 'transport.type', 'SEATA_GROUP', '', 'TCP', 'b136ef5f6a01d816991fe3cf7a6ac763', '2021-07-29 10:26:34', '2021-07-29 02:26:34', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 337, 'transport.server', 'SEATA_GROUP', '', 'NIO', 'b6d9dfc0fb54277321cebc0fff55df2f', '2021-07-29 10:26:34', '2021-07-29 02:26:34', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 338, 'transport.heartbeat', 'SEATA_GROUP', '', 'true', 'b326b5062b2f0e69046810717534cb09', '2021-07-29 10:26:34', '2021-07-29 02:26:34', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 339, 'transport.thread-factory.boss-thread-prefix', 'SEATA_GROUP', '', 'NettyBoss', '0f8db59a3b7f2823f38a70c308361836', '2021-07-29 10:26:34', '2021-07-29 02:26:34', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 340, 'transport.thread-factory.worker-thread-prefix', 'SEATA_GROUP', '', 'NettyServerNIOWorker', 'a78ec7ef5d1631754c4e72ae8a3e9205', '2021-07-29 10:26:34', '2021-07-29 02:26:34', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 341, 'transport.thread-factory.server-executor-thread-prefix', 'SEATA_GROUP', '', 'NettyServerBizHandler', '11a36309f3d9df84fa8b59cf071fa2da', '2021-07-29 10:26:34', '2021-07-29 02:26:34', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 342, 'transport.thread-factory.share-boss-worker', 'SEATA_GROUP', '', 'false', '68934a3e9455fa72420237eb05902327', '2021-07-29 10:26:34', '2021-07-29 02:26:35', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 343, 'transport.thread-factory.client-selector-thread-prefix', 'SEATA_GROUP', '', 'NettyClientSelector', 'cd7ec5a06541e75f5a7913752322c3af', '2021-07-29 10:26:34', '2021-07-29 02:26:35', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 344, 'transport.thread-factory.client-selector-thread-size', 'SEATA_GROUP', '', '1', 'c4ca4238a0b923820dcc509a6f75849b', '2021-07-29 10:26:34', '2021-07-29 02:26:35', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 345, 'transport.thread-factory.client-worker-thread-prefix', 'SEATA_GROUP', '', 'NettyClientWorkerThread', '61cf4e69a56354cf72f46dc86414a57e', '2021-07-29 10:26:34', '2021-07-29 02:26:35', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 346, 'transport.thread-factory.boss-thread-size', 'SEATA_GROUP', '', '1', 'c4ca4238a0b923820dcc509a6f75849b', '2021-07-29 10:26:34', '2021-07-29 02:26:35', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 347, 'transport.thread-factory.worker-thread-size', 'SEATA_GROUP', '', '8', 'c9f0f895fb98ab9159f51fd0297e236d', '2021-07-29 10:26:34', '2021-07-29 02:26:35', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 348, 'transport.shutdown.wait', 'SEATA_GROUP', '', '3', 'eccbc87e4b5ce2fe28308fd9f2a7baf3', '2021-07-29 10:26:34', '2021-07-29 02:26:35', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 349, 'service.vgroupMapping.my_test_tx_group', 'SEATA_GROUP', '', 'default', 'c21f969b5f03d33d43e04f8f136e7682', '2021-07-29 10:26:34', '2021-07-29 02:26:35', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 350, 'service.enableDegrade', 'SEATA_GROUP', '', 'false', '68934a3e9455fa72420237eb05902327', '2021-07-29 10:26:34', '2021-07-29 02:26:35', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 351, 'service.disable', 'SEATA_GROUP', '', 'false', '68934a3e9455fa72420237eb05902327', '2021-07-29 10:26:34', '2021-07-29 02:26:35', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 352, 'service.max.commit.retry.timeout', 'SEATA_GROUP', '', '-1', '6bb61e3b7bce0931da574d19d1d82c88', '2021-07-29 10:26:34', '2021-07-29 02:26:35', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 353, 'service.max.rollback.retry.timeout', 'SEATA_GROUP', '', '-1', '6bb61e3b7bce0931da574d19d1d82c88', '2021-07-29 10:26:35', '2021-07-29 02:26:35', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 354, 'client.async.commit.buffer.limit', 'SEATA_GROUP', '', '10000', 'b7a782741f667201b54880c925faec4b', '2021-07-29 10:26:35', '2021-07-29 02:26:35', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 355, 'client.lock.retry.internal', 'SEATA_GROUP', '', '10', 'd3d9446802a44259755d38e6d163e820', '2021-07-29 10:26:35', '2021-07-29 02:26:35', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 356, 'client.lock.retry.times', 'SEATA_GROUP', '', '30', '34173cb38f07f89ddbebc2ac9128303f', '2021-07-29 10:26:35', '2021-07-29 02:26:35', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 357, 'client.lock.retry.policy.branch-rollback-on-conflict', 'SEATA_GROUP', '', 'true', 'b326b5062b2f0e69046810717534cb09', '2021-07-29 10:26:35', '2021-07-29 02:26:35', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 358, 'client.table.meta.check.enable', 'SEATA_GROUP', '', 'true', 'b326b5062b2f0e69046810717534cb09', '2021-07-29 10:26:35', '2021-07-29 02:26:35', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 359, 'client.report.retry.count', 'SEATA_GROUP', '', '5', 'e4da3b7fbbce2345d7772b0674a318d5', '2021-07-29 10:26:35', '2021-07-29 02:26:35', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 360, 'client.tm.commit.retry.count', 'SEATA_GROUP', '', '1', 'c4ca4238a0b923820dcc509a6f75849b', '2021-07-29 10:26:35', '2021-07-29 02:26:35', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 361, 'client.tm.rollback.retry.count', 'SEATA_GROUP', '', '1', 'c4ca4238a0b923820dcc509a6f75849b', '2021-07-29 10:26:35', '2021-07-29 02:26:35', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 362, 'store.mode', 'SEATA_GROUP', '', 'file', '8c7dd922ad47494fc02c388e12c00eac', '2021-07-29 10:26:35', '2021-07-29 02:26:36', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 363, 'store.file.dir', 'SEATA_GROUP', '', 'file_store/data', '6a8dec07c44c33a8a9247cba5710bbb2', '2021-07-29 10:26:35', '2021-07-29 02:26:36', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 364, 'store.file.max-branch-session-size', 'SEATA_GROUP', '', '16384', 'c76fe1d8e08462434d800487585be217', '2021-07-29 10:26:35', '2021-07-29 02:26:36', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 365, 'store.file.max-global-session-size', 'SEATA_GROUP', '', '512', '10a7cdd970fe135cf4f7bb55c0e3b59f', '2021-07-29 10:26:35', '2021-07-29 02:26:36', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 366, 'store.file.file-write-buffer-cache-size', 'SEATA_GROUP', '', '16384', 'c76fe1d8e08462434d800487585be217', '2021-07-29 10:26:35', '2021-07-29 02:26:36', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 367, 'store.file.flush-disk-mode', 'SEATA_GROUP', '', 'async', '0df93e34273b367bb63bad28c94c78d5', '2021-07-29 10:26:35', '2021-07-29 02:26:36', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 368, 'store.file.session.reload.read_size', 'SEATA_GROUP', '', '100', 'f899139df5e1059396431415e770c6dd', '2021-07-29 10:26:35', '2021-07-29 02:26:36', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 369, 'store.db.datasource', 'SEATA_GROUP', '', 'dbcp', '3a9f384fb40c59fbdc67024ee97d94b1', '2021-07-29 10:26:35', '2021-07-29 02:26:36', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 370, 'store.db.db-type', 'SEATA_GROUP', '', 'mysql', '81c3b080dad537de7e10e0987a4bf52e', '2021-07-29 10:26:36', '2021-07-29 02:26:36', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 371, 'store.db.driver-class-name', 'SEATA_GROUP', '', 'com.mysql.jdbc.Driver', '683cf0c3a5a56cec94dfac94ca16d760', '2021-07-29 10:26:36', '2021-07-29 02:26:36', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 372, 'store.db.url', 'SEATA_GROUP', '', 'jdbc:mysql://127.0.0.1:3306/seata?useUnicode=true', 'cbb3bd573704f125fb4f2489208abaec', '2021-07-29 10:26:36', '2021-07-29 02:26:36', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 373, 'store.db.user', 'SEATA_GROUP', '', 'mysql', '81c3b080dad537de7e10e0987a4bf52e', '2021-07-29 10:26:36', '2021-07-29 02:26:36', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 374, 'store.db.password', 'SEATA_GROUP', '', 'mysql', '81c3b080dad537de7e10e0987a4bf52e', '2021-07-29 10:26:36', '2021-07-29 02:26:36', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 375, 'store.db.min-conn', 'SEATA_GROUP', '', '1', 'c4ca4238a0b923820dcc509a6f75849b', '2021-07-29 10:26:36', '2021-07-29 02:26:36', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 376, 'store.db.max-conn', 'SEATA_GROUP', '', '3', 'eccbc87e4b5ce2fe28308fd9f2a7baf3', '2021-07-29 10:26:36', '2021-07-29 02:26:36', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 377, 'store.db.global.table', 'SEATA_GROUP', '', 'global_table', '8b28fb6bb4c4f984df2709381f8eba2b', '2021-07-29 10:26:36', '2021-07-29 02:26:36', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 378, 'store.db.branch.table', 'SEATA_GROUP', '', 'branch_table', '54bcdac38cf62e103fe115bcf46a660c', '2021-07-29 10:26:36', '2021-07-29 02:26:36', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 379, 'store.db.query-limit', 'SEATA_GROUP', '', '100', 'f899139df5e1059396431415e770c6dd', '2021-07-29 10:26:36', '2021-07-29 02:26:36', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 380, 'store.db.lock-table', 'SEATA_GROUP', '', 'lock_table', '55e0cae3b6dc6696b768db90098b8f2f', '2021-07-29 10:26:36', '2021-07-29 02:26:37', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 381, 'recovery.committing-retry-period', 'SEATA_GROUP', '', '1000', 'a9b7ba70783b617e9998dc4dd82eb3c5', '2021-07-29 10:26:36', '2021-07-29 02:26:37', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 382, 'recovery.asyn-committing-retry-period', 'SEATA_GROUP', '', '1000', 'a9b7ba70783b617e9998dc4dd82eb3c5', '2021-07-29 10:26:36', '2021-07-29 02:26:37', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 383, 'recovery.rollbacking-retry-period', 'SEATA_GROUP', '', '1000', 'a9b7ba70783b617e9998dc4dd82eb3c5', '2021-07-29 10:26:36', '2021-07-29 02:26:37', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 384, 'recovery.timeout-retry-period', 'SEATA_GROUP', '', '1000', 'a9b7ba70783b617e9998dc4dd82eb3c5', '2021-07-29 10:26:36', '2021-07-29 02:26:37', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 385, 'transaction.undo.data.validation', 'SEATA_GROUP', '', 'true', 'b326b5062b2f0e69046810717534cb09', '2021-07-29 10:26:36', '2021-07-29 02:26:37', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 386, 'transaction.undo.log.serialization', 'SEATA_GROUP', '', 'jackson', 'b41779690b83f182acc67d6388c7bac9', '2021-07-29 10:26:36', '2021-07-29 02:26:37', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 387, 'transaction.undo.log.save.days', 'SEATA_GROUP', '', '7', '8f14e45fceea167a5a36dedd4bea2543', '2021-07-29 10:26:36', '2021-07-29 02:26:37', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 388, 'transaction.undo.log.delete.period', 'SEATA_GROUP', '', '86400000', 'f4c122804fe9076cb2710f55c3c6e346', '2021-07-29 10:26:36', '2021-07-29 02:26:37', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 389, 'transaction.undo.log.table', 'SEATA_GROUP', '', 'undo_log', '2842d229c24afe9e61437135e8306614', '2021-07-29 10:26:36', '2021-07-29 02:26:37', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 390, 'transport.serialization', 'SEATA_GROUP', '', 'seata', 'b943081c423b9a5416a706524ee05d40', '2021-07-29 10:26:37', '2021-07-29 02:26:37', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 391, 'transport.compressor', 'SEATA_GROUP', '', 'none', '334c4a4c42fdb79d7ebc3e73b517e6f8', '2021-07-29 10:26:37', '2021-07-29 02:26:37', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 392, 'metrics.enabled', 'SEATA_GROUP', '', 'false', '68934a3e9455fa72420237eb05902327', '2021-07-29 10:26:37', '2021-07-29 02:26:37', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 393, 'metrics.registry-type', 'SEATA_GROUP', '', 'compact', '7cf74ca49c304df8150205fc915cd465', '2021-07-29 10:26:37', '2021-07-29 02:26:37', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 394, 'metrics.exporter-list', 'SEATA_GROUP', '', 'prometheus', 'e4f00638b8a10e6994e67af2f832d51c', '2021-07-29 10:26:37', '2021-07-29 02:26:37', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 395, 'metrics.exporter-prometheus-port', 'SEATA_GROUP', '', '9898', '7b9dc501afe4ee11c56a4831e20cee71', '2021-07-29 10:26:37', '2021-07-29 02:26:37', NULL, '127.0.0.1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 396, 'support.spring.datasource.autoproxy', 'SEATA_GROUP', '', 'false', '68934a3e9455fa72420237eb05902327', '2021-07-29 10:26:37', '2021-07-29 02:26:37', NULL, '127.0.0.1', 'I', '');

-- ----------------------------
-- Table structure for permissions
-- ----------------------------
DROP TABLE IF EXISTS `permissions`;
CREATE TABLE `permissions`  (
  `role` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `resource` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `action` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  UNIQUE INDEX `uk_role_permission`(`role`, `resource`, `action`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permissions
-- ----------------------------

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles`  (
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  UNIQUE INDEX `idx_user_role`(`username`, `role`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES ('nacos', 'ROLE_ADMIN');

-- ----------------------------
-- Table structure for tenant_capacity
-- ----------------------------
DROP TABLE IF EXISTS `tenant_capacity`;
CREATE TABLE `tenant_capacity`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT 'Tenant ID',
  `quota` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '配额，0表示使用默认值',
  `usage` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '使用量',
  `max_size` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '单个配置大小上限，单位为字节，0表示使用默认值',
  `max_aggr_count` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '聚合子配置最大个数',
  `max_aggr_size` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '单个聚合数据的子配置大小上限，单位为字节，0表示使用默认值',
  `max_history_count` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '最大变更历史数量',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_tenant_id`(`tenant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '租户容量信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tenant_capacity
-- ----------------------------

-- ----------------------------
-- Table structure for tenant_info
-- ----------------------------
DROP TABLE IF EXISTS `tenant_info`;
CREATE TABLE `tenant_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `kp` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'kp',
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT 'tenant_id',
  `tenant_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT 'tenant_name',
  `tenant_desc` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'tenant_desc',
  `create_source` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'create_source',
  `gmt_create` bigint(20) NOT NULL COMMENT '创建时间',
  `gmt_modified` bigint(20) NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_tenant_info_kptenantid`(`kp`, `tenant_id`) USING BTREE,
  INDEX `idx_tenant_id`(`tenant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'tenant_info' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tenant_info
-- ----------------------------

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('nacos', '$2a$10$EuWPZHzz32dJN7jexM34MOeYirDdFAZm2kuWj7VEOJhhZkDrxfvUu', 1);

SET FOREIGN_KEY_CHECKS = 1;
