/*
Navicat MySQL Data Transfer

Source Server         : Local
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : springmvcdemo

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2017-08-16 00:58:46
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
-- Table structure for stud_info
-- ----------------------------
DROP TABLE IF EXISTS `stud_info`;
CREATE TABLE `stud_info` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `sname` varchar(255) DEFAULT NULL,
  `snumber` int(11) DEFAULT NULL,
  `sregister_time` datetime DEFAULT NULL,
  `age` int(11) NOT NULL,
  `gender` int(11) NOT NULL,
  `grade` int(11) DEFAULT NULL,
  `professional` varchar(50) DEFAULT NULL,
  `province_postcode` varchar(32) DEFAULT NULL,
  `province_name` varchar(64) DEFAULT NULL,
  `city_postcode` varchar(32) DEFAULT NULL,
  `city_name` varchar(64) DEFAULT NULL,
  `area_postcode` varchar(32) DEFAULT NULL,
  `area_name` varchar(64) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`sid`),
  KEY `id_sname_snumber` (`sid`,`sname`,`snumber`),
  KEY `id_sname` (`sid`,`sname`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `account` varchar(64) NOT NULL,
  `username` varchar(64) NOT NULL,
  `password` varchar(36) NOT NULL,
  `gender` int(1) NOT NULL,
  `role` int(1) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`uid`),
  UNIQUE KEY `account` (`account`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
