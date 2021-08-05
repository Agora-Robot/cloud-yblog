/*
 Navicat Premium Data Transfer

 Source Server         : demo-01
 Source Server Type    : MySQL
 Source Server Version : 50711
 Source Host           : localhost:3306
 Source Schema         : cloud_yblog_log

 Target Server Type    : MySQL
 Target Server Version : 50711
 File Encoding         : 65001

 Date: 04/08/2021 22:47:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_intercept
-- ----------------------------
DROP TABLE IF EXISTS `t_intercept`;
CREATE TABLE `t_intercept`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `intercept_ip` varchar(155) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '拦截ip',
  `intercept_address` varchar(155) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '拦截ip所在地址',
  `intercept_browser` varchar(155) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '拦截ip的人使用的浏览器',
  `intercept_os` varchar(155) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '拦截ip的人使用的操作系统',
  `intercept_time` datetime(0) NOT NULL COMMENT '拦截时间',
  `desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_intercept
-- ----------------------------

-- ----------------------------
-- Table structure for t_loginlog
-- ----------------------------
DROP TABLE IF EXISTS `t_loginlog`;
CREATE TABLE `t_loginlog`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lg_username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录的用户名',
  `lg_ip` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录的ip',
  `lg_address` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录ip的地址',
  `lg_browser` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户使用的浏览器',
  `lg_os` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户使用的操作系统',
  `lg_time` datetime(0) NOT NULL COMMENT '登录时间',
  `lg_type` tinyint(2) NOT NULL COMMENT '登录类型:比如正常登录和记住我自动登录',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_loginlog
-- ----------------------------
INSERT INTO `t_loginlog` VALUES (1, 'admin', '192.168.184.1', '暂未检测到所在地址', 'Firefox 9', 'Windows 10', '2021-08-04 13:06:50', 1);
INSERT INTO `t_loginlog` VALUES (2, 'admin', '192.168.184.1', '暂未检测到所在地址', 'Firefox 9', 'Windows 10', '2021-08-04 13:08:57', 1);
INSERT INTO `t_loginlog` VALUES (3, 'admin', '192.168.184.1', '暂未检测到所在地址', 'Firefox 9', 'Windows 10', '2021-08-04 13:27:39', 1);

-- ----------------------------
-- Table structure for t_operationlog
-- ----------------------------
DROP TABLE IF EXISTS `t_operationlog`;
CREATE TABLE `t_operationlog`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `op_username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `op_ip` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `op_uri` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `op_address` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `op_browser` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `op_os` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `op_time` datetime(0) NOT NULL,
  `op_type` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'Operation注解的值，也就是访问的接口的作用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_operationlog
-- ----------------------------

-- ----------------------------
-- Table structure for t_timecalc
-- ----------------------------
DROP TABLE IF EXISTS `t_timecalc`;
CREATE TABLE `t_timecalc`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uri` varchar(130) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '接口uri',
  `calc` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '接口耗时',
  `time` datetime(0) NOT NULL COMMENT '访问接口时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7492 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_timecalc
-- ----------------------------

-- ----------------------------
-- Table structure for t_visitor
-- ----------------------------
DROP TABLE IF EXISTS `t_visitor`;
CREATE TABLE `t_visitor`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `visit_ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '访客IP',
  `visit_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '访客地址',
  `browser` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '访客使用的浏览器',
  `os` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '访客使用的设备系统',
  `visit_time` datetime(0) NOT NULL COMMENT '访问时间',
  `visit_describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '访问描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_visitor
-- ----------------------------

-- ----------------------------
-- Table structure for undo_log
-- ----------------------------
DROP TABLE IF EXISTS `undo_log`;
CREATE TABLE `undo_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `branch_id` bigint(20) NOT NULL,
  `xid` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `context` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `rollback_info` longblob NOT NULL,
  `log_status` int(11) NOT NULL,
  `log_created` datetime(0) NOT NULL,
  `log_modified` datetime(0) NOT NULL,
  `ext` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `ux_undo_log`(`xid`, `branch_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of undo_log
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
