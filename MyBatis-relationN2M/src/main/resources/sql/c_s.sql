/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80032 (8.0.32)
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80032 (8.0.32)
 File Encoding         : 65001

 Date: 13/11/2023 21:15:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for c_s
-- ----------------------------
DROP TABLE IF EXISTS `c_s`;
CREATE TABLE `c_s`  (
  `id` int NOT NULL,
  `s_id` int NULL DEFAULT NULL,
  `c_id` int NULL DEFAULT NULL,
  INDEX `s_id`(`s_id` ASC) USING BTREE,
  INDEX `c_id`(`c_id` ASC) USING BTREE,
  CONSTRAINT `c_id` FOREIGN KEY (`c_id`) REFERENCES `course` (`c_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `s_id` FOREIGN KEY (`s_id`) REFERENCES `student` (`s_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of c_s
-- ----------------------------
INSERT INTO `c_s` VALUES (0, 1, 1);
INSERT INTO `c_s` VALUES (0, 1, 2);
INSERT INTO `c_s` VALUES (0, 2, 1);

SET FOREIGN_KEY_CHECKS = 1;
