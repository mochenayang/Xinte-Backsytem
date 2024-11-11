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

 Date: 21/09/2023 13:53:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `parent_id` int(11) NULL DEFAULT NULL,
  `parents_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES (1, '新疆协鑫新能源材料科技有限公司', -1, '-1');
INSERT INTO `dept` VALUES (2, '安全管理部', 1, '1');
INSERT INTO `dept` VALUES (3, '整理工段', 1, '1');
INSERT INTO `dept` VALUES (4, '整理工段A', 3, '1,3');
INSERT INTO `dept` VALUES (5, '整理工段B', 3, '1,3');
INSERT INTO `dept` VALUES (6, '还原工段', 1, '1');
INSERT INTO `dept` VALUES (7, '还原A区', 6, '1,6');
INSERT INTO `dept` VALUES (8, '还原B区', 6, '1,6');
INSERT INTO `dept` VALUES (9, '还原C区', 6, '1,6');
INSERT INTO `dept` VALUES (10, '还原D区', 6, '1,6');
INSERT INTO `dept` VALUES (11, '净化工段', 1, '1');
INSERT INTO `dept` VALUES (12, '氢化工段', 1, '1');
INSERT INTO `dept` VALUES (13, '氢化111A', 12, '1,12');
INSERT INTO `dept` VALUES (14, '氢化111B', 12, '1,12');
INSERT INTO `dept` VALUES (15, '氢化111C', 12, '1,12');
INSERT INTO `dept` VALUES (16, '氢化111D', 12, '1,12');
INSERT INTO `dept` VALUES (17, '氢化111E', 12, '1,12');
INSERT INTO `dept` VALUES (18, '渣浆高沸工段', 1, '1');
INSERT INTO `dept` VALUES (19, '公用工程工段', 1, '1');
INSERT INTO `dept` VALUES (20, '检维护工段', 1, '1');
INSERT INTO `dept` VALUES (21, '电气工段', 1, '1');
INSERT INTO `dept` VALUES (22, '质检中心', 1, '1');
INSERT INTO `dept` VALUES (23, '综合管理部', 1, '1');
INSERT INTO `dept` VALUES (24, '物资部', 1, '1');

SET FOREIGN_KEY_CHECKS = 1;
