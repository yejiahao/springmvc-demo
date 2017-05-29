/*
Navicat MySQL Data Transfer

Source Server         : Local
Source Server Version : 50156
Source Host           : 127.0.0.1:3306
Source Database       : springmvcdemo

Target Server Type    : MYSQL
Target Server Version : 50156
File Encoding         : 65001

Date: 2017-05-30 02:22:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for course_info
-- ----------------------------
DROP TABLE IF EXISTS `course_info`;
CREATE TABLE `course_info` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(255) DEFAULT NULL,
  `caddress` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_info
-- ----------------------------

-- ----------------------------
-- Table structure for course_stud_info
-- ----------------------------
DROP TABLE IF EXISTS `course_stud_info`;
CREATE TABLE `course_stud_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sid` int(11) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_stud_info
-- ----------------------------

-- ----------------------------
-- Table structure for stud_info
-- ----------------------------
DROP TABLE IF EXISTS `stud_info`;
CREATE TABLE `stud_info` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `sname` varchar(255) DEFAULT NULL,
  `snumber` int(11) DEFAULT NULL,
  `sregister_time` datetime DEFAULT NULL,
  PRIMARY KEY (`sid`),
  KEY `id_sname_snumber` (`sid`,`sname`,`snumber`),
  KEY `id_sname` (`sid`,`sname`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stud_info
-- ----------------------------
INSERT INTO `stud_info` VALUES ('1', '叶嘉豪', '3457', '2017-01-01 13:59:09');
INSERT INTO `stud_info` VALUES ('2', '郭梦凡', '8017', '2017-04-10 12:12:12');
INSERT INTO `stud_info` VALUES ('3', '邓立光', '3458', '2011-08-28 11:10:20');
INSERT INTO `stud_info` VALUES ('4', '庄思贵', '3459', '2012-07-13 23:22:24');
INSERT INTO `stud_info` VALUES ('5', '朱远飞', '3460', '2013-03-19 09:20:30');
INSERT INTO `stud_info` VALUES ('6', '李志坚', '5270', '2011-09-12 12:30:25');
INSERT INTO `stud_info` VALUES ('7', '黄伟强', '5271', '2005-07-23 21:33:59');
INSERT INTO `stud_info` VALUES ('8', '王军', '9754', '2014-10-06 09:38:00');
