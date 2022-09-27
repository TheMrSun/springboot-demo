/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : mybatis

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 27/09/2022 16:08:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名称',
  `user_password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `user_email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `user_info` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '简介',
  `head_img` blob NULL COMMENT '头像',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '123456', 'admin@qq.com', '管理员', NULL, '2022-09-23 00:00:00');
INSERT INTO `sys_user` VALUES (2, 'test', '123', 'test@qq.com', '测试用户', NULL, '2022-09-23 00:00:00');
INSERT INTO `sys_user` VALUES (10, 'test001', '123456', 'test001@mybatis.com', 'test001.info', 0x010203, '2022-09-26 10:06:55');
INSERT INTO `sys_user` VALUES (12, 'test001', '123456', 'test001@mybatis.com', 'test001.info', 0x010203, '2022-09-27 11:03:46');
INSERT INTO `sys_user` VALUES (14, 'test001', '123456', 'test001@mybatis.com', 'test001.info', 0x010203, '2022-09-27 11:04:15');
INSERT INTO `sys_user` VALUES (16, 'test001', '123456', 'test001@mybatis.com', 'test001.info', 0x010203, '2022-09-27 11:13:57');
INSERT INTO `sys_user` VALUES (18, 'test001', '123456', 'test001@mybatis.com', 'test001.info', 0x010203, '2022-09-27 11:15:52');

SET FOREIGN_KEY_CHECKS = 1;
