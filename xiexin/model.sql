/*
 Navicat Premium Data Transfer

 Source Server         : zyz01
 Source Server Type    : MySQL
 Source Server Version : 50743
 Source Host           : localhost:3306
 Source Schema         : xiexin

 Target Server Type    : MySQL
 Target Server Version : 50743
 File Encoding         : 65001

 Date: 21/09/2023 13:54:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for model
-- ----------------------------
DROP TABLE IF EXISTS `model`;
CREATE TABLE `model`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of model
-- ----------------------------
INSERT INTO `model` VALUES (1, '净化工段');
INSERT INTO `model` VALUES (2, '氢化工段');
INSERT INTO `model` VALUES (3, '渣浆高沸工段');
INSERT INTO `model` VALUES (4, '还原工段');
INSERT INTO `model` VALUES (5, '公用工程工段');
INSERT INTO `model` VALUES (6, 'xxx工段');

SET FOREIGN_KEY_CHECKS = 1;
