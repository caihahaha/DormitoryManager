/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : dormitory

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 24/07/2022 18:19:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` bigint(20) NULL DEFAULT NULL,
  `power` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `describe` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'csb', '123456', '蔡树彬', 138138138, '1', '高');
INSERT INTO `admin` VALUES (2, 'zj', '696E25FDACEE8106BC5232AFC69155D6', '张杰', 138138138, '2', '低');
INSERT INTO `admin` VALUES (3, 'zh', '696E25FDACEE8106BC5232AFC69155D6', '张欢', 138138138, '1', '高');
INSERT INTO `admin` VALUES (4, 'zk', '696E25FDACEE8106BC5232AFC69155D6', '赵凯', 138138138, '2', '低');
INSERT INTO `admin` VALUES (5, 'ywj', '696E25FDACEE8106BC5232AFC69155D6', '杨雯雯', 138138138, '1', '高');
INSERT INTO `admin` VALUES (6, 'wh', '696E25FDACEE8106BC5232AFC69155D6', '王皓', 138138138, '1', '高');
INSERT INTO `admin` VALUES (7, 'zw', '696E25FDACEE8106BC5232AFC69155D6', '张伟', 138138138, '2', '低');
INSERT INTO `admin` VALUES (8, 'zj', '696E25FDACEE8106BC5232AFC69155D6', '赵佳', 138138138, '2', '低');
INSERT INTO `admin` VALUES (9, 'wf', '696E25FDACEE8106BC5232AFC69155D6', '王凡', 138138138, '1', '高');
INSERT INTO `admin` VALUES (10, 'zn', '696E25FDACEE8106BC5232AFC69155D6', '张娜', 138138138, '1', '高');
INSERT INTO `admin` VALUES (11, 'jzh', '696E25FDACEE8106BC5232AFC69155D6', '蒋子华', 138138138, '2', '低');
INSERT INTO `admin` VALUES (12, 'xl', '696E25FDACEE8106BC5232AFC69155D6', '薛磊', 138138138, '2', '低');

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` int(11) NOT NULL,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `counsellor` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES (1, 141, '生物', '徐超');
INSERT INTO `class` VALUES (2, 151, '应化', '刘晨');
INSERT INTO `class` VALUES (3, 142, '土木', '孙玲');
INSERT INTO `class` VALUES (4, 161, '物流', '刘阳');
INSERT INTO `class` VALUES (5, 153, '数师', '张宇');
INSERT INTO `class` VALUES (6, 162, '物流', '刘阳');
INSERT INTO `class` VALUES (7, 171, '自动化', '周涵涵');
INSERT INTO `class` VALUES (8, 154, '土木', '孙玲');
INSERT INTO `class` VALUES (9, 151, '纺织', '赵凯');
INSERT INTO `class` VALUES (10, 153, '金融', '刘培');

-- ----------------------------
-- Table structure for dormitory_grade
-- ----------------------------
DROP TABLE IF EXISTS `dormitory_grade`;
CREATE TABLE `dormitory_grade`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dormitory_id` int(11) NOT NULL,
  `grade` int(11) NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dormitory_grade
-- ----------------------------
INSERT INTO `dormitory_grade` VALUES (1, 301, 6, '2019-04-25 10:51:17', '2019-05-12 17:28:38');
INSERT INTO `dormitory_grade` VALUES (2, 302, 7, '2019-05-01 16:36:47', '2019-05-01 16:36:55');
INSERT INTO `dormitory_grade` VALUES (3, 322, 8, '2019-05-04 16:37:42', '2019-05-04 16:37:47');
INSERT INTO `dormitory_grade` VALUES (4, 602, 7, '2019-05-08 16:38:25', '2019-05-08 16:38:30');
INSERT INTO `dormitory_grade` VALUES (5, 112, 7, '2019-05-12 16:38:53', '2019-05-12 16:39:00');
INSERT INTO `dormitory_grade` VALUES (6, 222, 9, '2019-05-09 16:39:37', '2019-05-09 16:39:41');
INSERT INTO `dormitory_grade` VALUES (7, 213, 8, '2019-05-10 16:40:02', '2019-05-10 16:40:08');

-- ----------------------------
-- Table structure for dormitory_info
-- ----------------------------
DROP TABLE IF EXISTS `dormitory_info`;
CREATE TABLE `dormitory_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` int(11) NOT NULL,
  `dormitory_location` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bed_total` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bed_used` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `admin_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dormitory_info
-- ----------------------------
INSERT INTO `dormitory_info` VALUES (1, 311, '24号楼', '4', '3', '周荀凯');
INSERT INTO `dormitory_info` VALUES (2, 322, '24号楼', '4', '4', '周荀凯');
INSERT INTO `dormitory_info` VALUES (3, 601, '23号楼', '6', '6', '张杰');
INSERT INTO `dormitory_info` VALUES (4, 602, '23号楼', '6', '5', '张杰');
INSERT INTO `dormitory_info` VALUES (5, 111, '22号楼', '4', '4', '杨雯雯');
INSERT INTO `dormitory_info` VALUES (6, 112, '22号楼', '4', '3', '杨雯雯');
INSERT INTO `dormitory_info` VALUES (7, 222, '27号楼', '6', '6', '张伟');
INSERT INTO `dormitory_info` VALUES (8, 213, '27号楼', '4', '4', '张伟');
INSERT INTO `dormitory_info` VALUES (9, 312, '26号楼', '6', '6', '薛磊');
INSERT INTO `dormitory_info` VALUES (10, 313, '22号楼', '4', '4', '张磊');
INSERT INTO `dormitory_info` VALUES (11, 323, '22号楼', '6', '5', '张磊');
INSERT INTO `dormitory_info` VALUES (12, 301, '24号楼', '6', '6', '周荀凯');
INSERT INTO `dormitory_info` VALUES (13, 302, '24号楼', '6', '6', '周荀凯');
INSERT INTO `dormitory_info` VALUES (14, 423, '29号楼', '4', '3', '郭浩然');

-- ----------------------------
-- Table structure for dormitory_repair
-- ----------------------------
DROP TABLE IF EXISTS `dormitory_repair`;
CREATE TABLE `dormitory_repair`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dormitory_id` int(11) NOT NULL,
  `student_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `reason` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dormitory_repair
-- ----------------------------
INSERT INTO `dormitory_repair` VALUES (1, 301, '王涛', '水池', '2019-05-13 22:39:58', '2019-05-13 22:39:58');
INSERT INTO `dormitory_repair` VALUES (2, 322, '王涛', '灯管', '2019-05-11 16:29:20', '2019-05-14 16:29:35');
INSERT INTO `dormitory_repair` VALUES (3, 601, '冯军', '水龙头', '2019-05-15 16:31:14', '2019-05-14 16:31:20');
INSERT INTO `dormitory_repair` VALUES (4, 601, '冯军', '插孔', '2019-05-15 16:31:56', '2019-05-15 16:32:04');
INSERT INTO `dormitory_repair` VALUES (5, 213, '冯军', '排风扇', '2019-05-18 16:32:54', '2019-05-14 16:33:00');
INSERT INTO `dormitory_repair` VALUES (6, 312, '彭建国', '空调', '2019-05-20 16:33:56', '2019-05-20 16:34:01');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` int(11) NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `phone` bigint(20) NULL DEFAULT NULL,
  `class_id` int(11) NOT NULL,
  `dormitory_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, 1413032001, '张杰', '男', 22, 138138138, 141, 301);
INSERT INTO `student` VALUES (2, 1413032002, '赵凯', '男', 22, 138138138, 141, 301);
INSERT INTO `student` VALUES (3, 1413032003, '许文文', '男', 21, 138138138, 141, 301);
INSERT INTO `student` VALUES (4, 1413032004, '王浩', '男', 22, 138138138, 141, 301);
INSERT INTO `student` VALUES (5, 1413032005, '张伟', '男', 22, 138138138, 141, 301);
INSERT INTO `student` VALUES (6, 1413032006, '郭顶', '男', 21, 138138138, 141, 301);
INSERT INTO `student` VALUES (7, 1513112411, '曹原', '男', 20, 138138138, 151, 112);
INSERT INTO `student` VALUES (8, 1513112412, '赵跃', '男', 21, 138138138, 151, 112);
INSERT INTO `student` VALUES (9, 1513112413, '孙畅', '男', 21, 138138138, 151, 112);
INSERT INTO `student` VALUES (10, 1513122417, '周帆', '男', 21, 138138138, 161, 213);
INSERT INTO `student` VALUES (11, 1513122418, '田野', '男', 21, 138138138, 153, 213);
INSERT INTO `student` VALUES (12, 1513122419, '张嘉佳', '男', 20, 138138138, 153, 213);
INSERT INTO `student` VALUES (13, 1513122420, '陈昊', '男', 21, 138138138, 153, 213);

-- ----------------------------
-- Table structure for student_grade
-- ----------------------------
DROP TABLE IF EXISTS `student_grade`;
CREATE TABLE `student_grade`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) NOT NULL,
  `grade` int(11) NULL DEFAULT NULL,
  `class_id` int(11) NULL DEFAULT NULL,
  `dormitory_id` int(11) NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student_grade
-- ----------------------------
INSERT INTO `student_grade` VALUES (1, 1413032001, 6, 141, 301, '2019-04-26 09:56:51', '2019-04-26 11:02:13');
INSERT INTO `student_grade` VALUES (2, 1413032002, 7, 141, 301, '2019-05-01 17:00:05', '2019-05-01 17:00:13');
INSERT INTO `student_grade` VALUES (3, 1413032003, 6, 141, 301, '2019-05-06 17:00:54', '2019-05-06 17:01:01');
INSERT INTO `student_grade` VALUES (4, 1413032003, 7, 141, 301, '2019-05-16 17:01:33', '2019-05-16 17:02:15');
INSERT INTO `student_grade` VALUES (5, 1413032004, 7, 141, 301, '2019-05-10 17:03:03', '2019-05-10 17:03:09');
INSERT INTO `student_grade` VALUES (6, 1413032005, 8, 141, 301, '2019-05-14 17:03:53', '2019-05-14 17:03:56');
INSERT INTO `student_grade` VALUES (7, 1513112412, 9, 151, 112, '2019-05-08 17:05:04', '2019-05-08 17:05:07');
INSERT INTO `student_grade` VALUES (8, 1513112412, 9, 151, 112, '2019-05-17 17:05:34', '2019-05-17 17:05:39');
INSERT INTO `student_grade` VALUES (9, 1513122418, 8, 151, 213, '2019-05-15 17:06:28', '2019-05-15 17:06:35');
INSERT INTO `student_grade` VALUES (10, 1513122419, 8, 151, 213, '2019-05-15 17:07:09', '2019-05-15 17:07:13');

-- ----------------------------
-- Table structure for visitor
-- ----------------------------
DROP TABLE IF EXISTS `visitor`;
CREATE TABLE `visitor`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` bigint(20) NULL DEFAULT NULL,
  `dormitory_code` int(11) NULL DEFAULT NULL,
  `dormitory_location` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of visitor
-- ----------------------------
INSERT INTO `visitor` VALUES (1, '郑杰', 138138138, 301, '24号楼', '2019-05-14 13:26:13');
INSERT INTO `visitor` VALUES (2, '李博', 138138138, 322, '24号楼', '2019-05-12 19:36:23');
INSERT INTO `visitor` VALUES (3, '张盈盈', 138138138, 601, '23号楼', '2019-05-13 19:37:11');
INSERT INTO `visitor` VALUES (4, '王涛', 138138138, 111, '22号楼', '2019-05-15 19:37:46');
INSERT INTO `visitor` VALUES (5, '胡浩', 138138138, 222, '27号楼', '2019-05-16 19:38:27');
INSERT INTO `visitor` VALUES (6, '陈昊', 138138138, 213, '27号楼', '2019-05-18 19:39:03');
INSERT INTO `visitor` VALUES (7, '刘军', 138138138, 213, '27号楼', '2019-05-20 19:39:42');
INSERT INTO `visitor` VALUES (8, '黄智', 138138138, 312, '26号楼', '2019-05-22 19:46:38');
INSERT INTO `visitor` VALUES (9, '郑杰', 123123123, 311, '24号楼', '2019-05-16 16:59:06');

SET FOREIGN_KEY_CHECKS = 1;
