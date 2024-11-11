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

 Date: 21/09/2023 13:54:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for submodel
-- ----------------------------
DROP TABLE IF EXISTS `submodel`;
CREATE TABLE `submodel`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `label` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `attr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `checkedData` int(11) NULL DEFAULT 0,
  `parent_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of submodel
-- ----------------------------
INSERT INTO `submodel` VALUES (1, '序号', 'id', 1, 1);
INSERT INTO `submodel` VALUES (2, '测点', 'sitename', 1, 1);
INSERT INTO `submodel` VALUES (3, '描述', 'describe', 1, 1);
INSERT INTO `submodel` VALUES (4, '报警类型', 'type', 0, 1);
INSERT INTO `submodel` VALUES (5, '实时值', 'realTime', 0, 1);
INSERT INTO `submodel` VALUES (6, '报警内容', 'alarm_info', 0, 1);
INSERT INTO `submodel` VALUES (7, '开始时间', 'start_time', 0, 1);
INSERT INTO `submodel` VALUES (8, '持续时间', 'during_time', 0, 1);

SET FOREIGN_KEY_CHECKS = 1;
