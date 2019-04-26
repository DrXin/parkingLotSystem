/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : parkinglotsystem

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 26/04/2019 09:40:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for car
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car`  (
  `carId` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `color` varchar(20) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `licenseNum` varchar(20) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `driverId` int(11) NOT NULL,
  `formulaId` int(11) NOT NULL,
  `brand` varchar(20) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  PRIMARY KEY (`carId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 57 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for driver
-- ----------------------------
DROP TABLE IF EXISTS `driver`;
CREATE TABLE `driver`  (
  `driverId` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `driverName` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gender` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `idCardNum` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`driverId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for fare
-- ----------------------------
DROP TABLE IF EXISTS `fare`;
CREATE TABLE `fare`  (
  `fareId` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `carId` int(11) NOT NULL,
  `total` float NOT NULL,
  `timeId` int(11) NOT NULL,
  `paid` int(2) NOT NULL COMMENT '0表示没有1表示已支付',
  PRIMARY KEY (`fareId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for formula
-- ----------------------------
DROP TABLE IF EXISTS `formula`;
CREATE TABLE `formula`  (
  `formulaId` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `formulaName` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`formulaId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for parking
-- ----------------------------
DROP TABLE IF EXISTS `parking`;
CREATE TABLE `parking`  (
  `pId` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `occupied` int(2) NULL DEFAULT NULL COMMENT '0表示未占用1表示占用',
  PRIMARY KEY (`pId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 101 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for parkingtime
-- ----------------------------
DROP TABLE IF EXISTS `parkingtime`;
CREATE TABLE `parkingtime`  (
  `timeId` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `beginTime` datetime(0) NULL DEFAULT NULL,
  `endTime` datetime(0) NULL DEFAULT NULL,
  `totalTime` int(11) NULL DEFAULT NULL,
  `carId` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`timeId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for token
-- ----------------------------
DROP TABLE IF EXISTS `token`;
CREATE TABLE `token`  (
  `tokenId` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `tokenNum` bigint(20) NOT NULL,
  `beginTime` date NOT NULL,
  `endTime` date NOT NULL,
  `carId` int(11) NOT NULL,
  PRIMARY KEY (`tokenId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `userId` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `password` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `authority` int(2) NOT NULL,
  `driverId` int(10) NOT NULL,
  PRIMARY KEY (`userId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
