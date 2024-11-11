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

 Date: 21/09/2023 13:54:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for menulist
-- ----------------------------
DROP TABLE IF EXISTS `menulist`;
CREATE TABLE `menulist`  (
  `menuId` int(11) NOT NULL AUTO_INCREMENT,
  `menuName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `menu_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `file_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `roles` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `link_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `out_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `last_time` datetime NULL DEFAULT NULL,
  `parent_id` int(11) NULL DEFAULT NULL,
  `parents_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `children_ids` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `proposer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `propose_time` datetime NULL DEFAULT NULL,
  `approver` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `approve_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`menuId`) USING BTREE,
  UNIQUE INDEX `munuId`(`menuId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menulist
-- ----------------------------
INSERT INTO `menulist` VALUES (1, '质量域', '', '目录', '', '', '', '', '', '2023-07-24 11:18:46', '2023-07-24 11:18:46', -1, '-1', '上架申请通过', NULL, '同意', NULL, NULL, 'common', '2023-09-20 16:58:41');
INSERT INTO `menulist` VALUES (2, 'LIMS', '', '目录', '', '', '', '', '', '2023-07-24 11:18:46', '2023-07-24 11:18:46', 1, '1', '', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `menulist` VALUES (3, '杂志组分趋势图', '', '菜单', '', '', '', '', '', '2023-07-24 11:18:46', '2023-07-24 11:18:46', 2, '1,2', '上架申请通过', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `menulist` VALUES (4, '生产域', '', '目录', '', '', '', '', '', '2023-07-24 11:18:46', '2023-07-24 11:18:46', -1, '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `menulist` VALUES (5, '报警管理', '', '目录', '', '', '', '', '', '2023-07-24 11:18:46', '2023-07-24 11:18:46', 4, '4', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `menulist` VALUES (6, '报警数据', '', '菜单', '', '', '', '', '', '2023-07-24 11:18:46', '2023-07-24 11:18:46', 5, '4,5', '上架申请驳回', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `menulist` VALUES (7, '罐区管理', '', '菜单', '', '', '', '', '', '2023-07-24 11:18:46', '2023-07-24 11:18:46', 5, '4,5', '上架申请待审批', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `menulist` VALUES (8, '设备域', '', '目录', '', '', '', '', '', '2023-07-24 11:18:46', '2023-07-24 11:18:46', -1, '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `menulist` VALUES (9, '设备基础资料', '', '目录', '', '', '', '', '', '2023-07-24 11:18:46', '2023-07-24 11:18:46', 8, '8', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `menulist` VALUES (10, '设备台账', '', '菜单', '', '', '', '', '', '2023-07-24 11:18:46', '2023-07-24 11:18:46', 9, '8,9', '上架申请通过', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `menulist` VALUES (11, '安防域', '', '目录', '', '', '', '', '', '2023-07-24 11:18:46', '2023-07-24 11:18:46', -1, '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `menulist` VALUES (12, '驾驶舱', '', '目录', '', '', '', '', '', '2023-07-24 11:18:46', '2023-07-24 11:18:46', -1, '-1', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `menulist` VALUES (13, '驾驶舱-安全管理', '', '菜单', 'http://192.168.1.100:8080/#/HomePage/SecurityDetection', '', '', '外链', '内嵌页打开', '2023-07-24 11:18:46', '2023-07-24 11:18:46', 12, '12', '上架申请待审批', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `menulist` VALUES (14, '驾驶舱主页', '', '菜单', 'http://192.168.1.100:8080/#/', '', '', '外链', '新窗口打开', '2023-07-24 11:18:46', '2023-07-24 11:18:46', 12, '12', '上架申请待审批', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `menulist` VALUES (15, '驾驶舱3', '', '菜单', 'http://172.20.138.148:82/#/HomePage/SecurityDetection', '', '', '外链', '内嵌页打开', '2023-07-24 11:18:46', '2023-09-21 10:55:20', 12, '12', '上架申请待审批', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `menulist` VALUES (18, '模型Test', '', '菜单', '/modeltest', 'views/Test.vue', '', '内嵌', '', '2023-07-24 11:18:46', '2023-09-21 10:51:31', -1, '', '上架申请通过', '1,2,3,4,5', NULL, NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
