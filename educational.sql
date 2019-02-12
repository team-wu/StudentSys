/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50627
Source Host           : localhost:3306
Source Database       : student

Target Server Type    : MYSQL
Target Server Version : 50627
File Encoding         : 65001

Date: 2019-01-14 14:52:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `academy`
-- ----------------------------
DROP TABLE IF EXISTS `academy`;
CREATE TABLE `academy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of academy
-- ----------------------------
INSERT INTO `academy` VALUES ('1', '计算机工程学院');
INSERT INTO `academy` VALUES ('9', '机电学院');
INSERT INTO `academy` VALUES ('10', '文新学院');
INSERT INTO `academy` VALUES ('12', '2');
INSERT INTO `academy` VALUES ('13', 'wen是');

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('2', 'admin', '123456');

-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `credit` varchar(255) DEFAULT NULL,
  `time` int(11) DEFAULT NULL,
  `desc` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `academy_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `academy_id` (`academy_id`),
  CONSTRAINT `course_ibfk_1` FOREIGN KEY (`academy_id`) REFERENCES `academy` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('11', '大幅度', '5', '5', '555', '1', '1');
INSERT INTO `course` VALUES ('12', '地方', '8', '5', '4', '787', '9');
INSERT INTO `course` VALUES ('13', '432', '21', '22', '32', '2', '1');

-- ----------------------------
-- Table structure for `major`
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `desc` varchar(255) DEFAULT NULL,
  `academy_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `academy_id` (`academy_id`),
  CONSTRAINT `major_ibfk_1` FOREIGN KEY (`academy_id`) REFERENCES `academy` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of major
-- ----------------------------
INSERT INTO `major` VALUES ('58', '软件工程', '很好', '1');
INSERT INTO `major` VALUES ('59', '计算机与技术', '很棒', '1');
INSERT INTO `major` VALUES ('60', '3', '43', '10');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `birthday` varchar(255) DEFAULT NULL,
  `tellphone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `school_term` int(11) DEFAULT NULL,
  `school_year` int(11) DEFAULT NULL,
  `major_id` int(11) DEFAULT NULL,
  `major_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `major_id` (`major_id`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`major_id`) REFERENCES `major` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('8', '谈一谈244', '2', '2018-10-22', '123456789122', '232', '546', '32', '32', '60', null);
INSERT INTO `student` VALUES ('9', '牛哥', '2', '2018-10-09', '12345335422', '32322', '32', '21', '21', '59', null);
INSERT INTO `student` VALUES ('10', '赵六', '1', '2018-10-25', '12343223456', '32132@qq.com', '3232', '212', '212', '59', null);
INSERT INTO `student` VALUES ('12', '21', '1', '2018-10-25', '12345665432', '32@qq.com', 'da', '32', '32', '58', null);
