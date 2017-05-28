/*
Navicat MySQL Data Transfer

Source Server         : Local
Source Server Version : 50156
Source Host           : localhost:3306
Source Database       : springmvcdemo

Target Server Type    : MYSQL
Target Server Version : 50156
File Encoding         : 65001

Date: 2017-04-11 14:33:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for course_info
-- ----------------------------
DROP TABLE IF EXISTS `course_info`;
CREATE TABLE `course_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(255) DEFAULT NULL,
  `caddress` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_info
-- ----------------------------

-- ----------------------------
-- Table structure for course_user_info
-- ----------------------------
DROP TABLE IF EXISTS `course_user_info`;
CREATE TABLE `course_user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_user_info
-- ----------------------------

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(255) DEFAULT NULL,
  `unumber` int(11) DEFAULT NULL,
  `uregister_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_uname_unumber` (`id`,`uname`,`unumber`),
  KEY `id_uname` (`id`,`uname`)
) ENGINE=MyISAM AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', '叶嘉豪', '3457', '2017-01-09 13:59:09');
INSERT INTO `user_info` VALUES ('2', '邓立光', '3458', '2011-08-28 11:10:20');
INSERT INTO `user_info` VALUES ('3', '庄思贵', '3459', '2017-01-10 23:22:24');
INSERT INTO `user_info` VALUES ('4', '朱远飞', '3460', '2013-03-19 09:20:30');
INSERT INTO `user_info` VALUES ('5', '郭梦凡', '100', '2017-01-11 11:38:59');
INSERT INTO `user_info` VALUES ('42', '郭梦凡', '100', '2017-03-31 18:04:33');
INSERT INTO `user_info` VALUES ('41', '郭梦凡', '100', '2017-03-30 19:38:00');
INSERT INTO `user_info` VALUES ('40', '郭梦凡', '100', '2017-03-27 18:14:00');
INSERT INTO `user_info` VALUES ('39', '郭梦凡', '100', '2017-03-27 15:28:58');
INSERT INTO `user_info` VALUES ('38', '郭梦凡', '100', '2017-03-25 15:17:18');
INSERT INTO `user_info` VALUES ('37', '郭梦凡', '100', '2017-03-25 15:08:51');
INSERT INTO `user_info` VALUES ('36', '郭梦凡', '100', '2017-03-25 15:07:18');
INSERT INTO `user_info` VALUES ('35', '郭梦凡', '100', '2017-03-22 18:03:18');
INSERT INTO `user_info` VALUES ('34', '郭梦凡', '100', '2017-03-22 17:48:28');
INSERT INTO `user_info` VALUES ('33', '郭梦凡', '100', '2017-03-22 17:39:30');
INSERT INTO `user_info` VALUES ('32', '郭梦凡', '100', '2017-03-22 17:34:31');
INSERT INTO `user_info` VALUES ('31', '郭梦凡', '100', '2017-03-21 19:48:22');
INSERT INTO `user_info` VALUES ('30', '郭梦凡', '100', '2017-03-21 15:50:13');
INSERT INTO `user_info` VALUES ('29', '郭梦凡', '100', '2017-03-21 15:42:09');
INSERT INTO `user_info` VALUES ('28', '郭梦凡', '100', '2017-03-20 17:46:49');
