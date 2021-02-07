/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50553
 Source Host           : localhost:3306
 Source Schema         : distribute

 Target Server Type    : MySQL
 Target Server Version : 50553
 File Encoding         : 65001

 Date: 07/02/2021 23:19:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `account` bigint(255) NULL DEFAULT NULL COMMENT '余额(单位：分)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES (1, '张三', 100000);
INSERT INTO `account` VALUES (2, '李四', 100000);
INSERT INTO `account` VALUES (3, '王五', 100000);

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `order_id` int(11) NOT NULL DEFAULT 0 COMMENT '订单id',
  `order_state` int(11) NULL DEFAULT NULL COMMENT '订单状态，0是未被抢，1是已被抢',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (1, 0);

SET FOREIGN_KEY_CHECKS = 1;
