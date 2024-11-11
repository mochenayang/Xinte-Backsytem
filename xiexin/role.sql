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

 Date: 21/09/2023 13:54:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `descript` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `menuroles` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `last_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `role_id`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'commom', 'commom', '普通', '1,2,3', '2023-09-12 10:24:38', '2023-09-19 10:24:44');
INSERT INTO `role` VALUES (2, 'admin', 'admin', '管理员', '1,2,3', '2023-09-12 10:24:41', '2023-09-19 10:24:47');
INSERT INTO `role` VALUES (3, '111', '111', '测试', '1,2,3', '2023-09-19 15:12:37', '2023-09-19 15:13:34');

SET FOREIGN_KEY_CHECKS = 1;
