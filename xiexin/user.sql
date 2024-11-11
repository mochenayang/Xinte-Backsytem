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

 Date: 21/09/2023 13:54:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role_id` int(255) NULL DEFAULT 1,
  `dept` int(11) NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phonenumber` varbinary(255) NULL DEFAULT NULL,
  `position` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(3) NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `edit_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'zyz', '章宇泽', '123456', 1, 19, 'test@163.com', 0x3137333637383831313232, 'A', '男', 22, '上海', '2023-09-12 10:17:59', '2023-09-19 10:18:02');
INSERT INTO `user` VALUES (2, 'xwh', '肖伟豪', '123456', 1, 18, '253792936@qq.com', 0x3137333637383831313232, 'A', '男', 22, '上海', '2023-09-12 10:17:54', '2023-09-19 10:17:57');
INSERT INTO `user` VALUES (3, 'ls', '李四', '123456', 1, 20, NULL, 0x3137333637383831313232, 'A', '男', 22, '上海', '2023-09-12 10:18:04', '2023-09-19 10:18:07');
INSERT INTO `user` VALUES (4, 'ww', '王五', '123456', 1, 21, NULL, 0x3137333637383831313232, 'A', '男', 22, '上海', '2023-09-12 10:18:09', '2023-09-19 10:18:11');
INSERT INTO `user` VALUES (5, 'zhao6', '赵六', '123456', 1, 12, '564656@qq.com', 0x3133353135363436353436, 'A', '男', 22, '上海', '2023-09-12 10:18:13', '2023-09-19 10:18:16');
INSERT INTO `user` VALUES (8, 'zs', 'ZHe', '123456', 1, 1, 'xxxx@qq.com', 0x31323331333231323331, NULL, NULL, NULL, NULL, '2023-09-19 15:50:44', '2023-09-19 15:50:44');

SET FOREIGN_KEY_CHECKS = 1;
