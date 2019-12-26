/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : edu

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-12-24 12:04:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `chapter`
-- ----------------------------
DROP TABLE IF EXISTS `chapter`;
CREATE TABLE `chapter` (
  `course_cha_id` int(255) DEFAULT NULL,
  `cha_id` int(32) NOT NULL AUTO_INCREMENT,
  `video` varchar(255) DEFAULT NULL,
  `cha_sum` int(64) DEFAULT NULL,
  `cha_date` varchar(255) DEFAULT NULL,
  `cha_name` varchar(32) DEFAULT NULL,
  `data` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cha_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of chapter
-- ----------------------------
INSERT INTO `chapter` VALUES ('2019121102', '2', '01.mp4', null, '2019-12-11', 'Java基础-1-a', '基本字符串');
INSERT INTO `chapter` VALUES ('2019121102', '3', '02.mp4', null, '2019-12-11', 'Java基础-2', 'Java语法');
INSERT INTO `chapter` VALUES ('2019121107', '7', '03.mp4', null, '2019-12-12', 'Linux-1', 'Linux01教程');
INSERT INTO `chapter` VALUES ('2019121107', '8', '04.mp4', null, '2019-12-12', 'Linux-2', 'Linux02教程');
INSERT INTO `chapter` VALUES ('2019121104', '9', '05.mp4', null, '2019-12-12', 'Mysql-1', 'myqsl查表教程');
INSERT INTO `chapter` VALUES ('2019121104', '10', '06.mp4', null, '2019-12-12', 'Mysql-03', 'myqsl多表查询教程');
INSERT INTO `chapter` VALUES ('2019121102', '11', '01.mp4', null, '2019-12-17', 'Java基础-4', '多线3');
INSERT INTO `chapter` VALUES ('2019121102', '15', '02.mp4', null, '2019-12-23', 'Java基础-44444', '555555555555');

-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `course_id` int(32) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(64) DEFAULT NULL,
  `c_chapter_id` int(32) DEFAULT NULL,
  `img` varchar(256) DEFAULT NULL,
  `class_id` int(32) DEFAULT NULL,
  `sum` int(32) DEFAULT NULL,
  `num` int(32) DEFAULT NULL,
  `grade` varchar(32) DEFAULT NULL,
  `price` int(32) DEFAULT NULL,
  `course_date` varchar(255) DEFAULT NULL,
  `sumtime` varchar(64) DEFAULT NULL,
  `c_user_id` int(128) DEFAULT NULL,
  `author` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('81', 'Java0基础教程', '2019121102', 'cda8ce54c0a9426d8fb0f9225c1d0ccf.jpg', '1', null, null, '初级', null, '2019-12-11', '120H', '1', '五六七');
INSERT INTO `course` VALUES ('90', 'Mysql基础0', '2019121104', 'bc6645b8ca264edbb42742c615885d53.jpg', '3', null, null, '初级', null, '2019-12-12', '20H', '1', 'Mr.M');
INSERT INTO `course` VALUES ('92', 'Mysql基础-1', '2019121105', 'bc6645b8ca264edbb42742c615885d53.jpg', '3', null, null, '初级', null, '2019-12-12', '20H', '1', 'Mr.M');
INSERT INTO `course` VALUES ('97', 'Mysql基础-2', '2019121106', 'b5631bcce28246d6bb8d9ad075273d3a.jpg', '3', null, null, '初级', null, '2019-12-12', '20H', '1', 'Mr.M');
INSERT INTO `course` VALUES ('98', 'Linux0', '2019121107', '79ef11c3db634bbda540c5ac8b2ce942.jpg', '2', null, null, '初级', null, '2019-12-12', '60H', '1', 'MR.linux');
INSERT INTO `course` VALUES ('99', 'Mysql基础-3', '2019121108', 'bc6645b8ca264edbb42742c615885d53.jpg', '3', null, null, '初级', null, '2019-12-12', '20H', '1', 'Mr.M');
INSERT INTO `course` VALUES ('100', 'Linux-1', '2019121109', '79ef11c3db634bbda540c5ac8b2ce942.jpg', '2', null, null, '初级', null, '2019-12-12', '60H', '1', 'MR.linux');
INSERT INTO `course` VALUES ('101', 'Linux-2', '2019121110', '79ef11c3db634bbda540c5ac8b2ce942.jpg', '2', null, null, '初级', null, '2019-12-12', '60H', '1', 'MR.linux');
INSERT INTO `course` VALUES ('104', 'Mysql基础-4', '2019121113', 'bc6645b8ca264edbb42742c615885d53.jpg', '3', null, null, '初级', null, '2019-12-12', '20H', '1', 'Mr.M');
INSERT INTO `course` VALUES ('105', 'Mysql基础-5', '2019121114', 'bc6645b8ca264edbb42742c615885d53.jpg', '3', null, null, '初级', null, '2019-12-12', '20H', '1', 'Mr.M');
INSERT INTO `course` VALUES ('106', 'Java8基础教程-3', '2019121115', '7e431314b33c4293816c67d90d2de534.jpg', '1', null, null, '初级', null, '2019-12-11', '120H', '1', '五六七');
INSERT INTO `course` VALUES ('107', 'Java8基础教程-4', '2019121116', '7e431314b33c4293816c67d90d2de534.jpg', '1', null, null, '初级', null, '2019-12-11', '120H', '1', '五六七');
INSERT INTO `course` VALUES ('108', 'Java8基础教程-5', '2019121117', '7e431314b33c4293816c67d90d2de534.jpg', '1', null, null, '初级', null, '2019-12-11', '120H', '1', '五六七');
INSERT INTO `course` VALUES ('109', 'Java8基础教程-6', '2019121118', '7e431314b33c4293816c67d90d2de534.jpg', '1', null, null, '初级', null, '2019-12-11', '120H', '1', '五六七');
INSERT INTO `course` VALUES ('110', 'Linux-3', '2019121119', '79ef11c3db634bbda540c5ac8b2ce942.jpg', '2', null, null, '初级', null, '2019-12-12', '60H', '1', 'MR.linux');
INSERT INTO `course` VALUES ('111', 'Linux-4', '2019121120', '79ef11c3db634bbda540c5ac8b2ce942.jpg', '2', null, null, '初级', null, '2019-12-12', '60H', '1', 'MR.linux');
INSERT INTO `course` VALUES ('112', 'Java8基础教程-7', '2019121121', '7e431314b33c4293816c67d90d2de534.jpg', '1', null, null, '初级', null, '2019-12-11', '120H', '1', '五六七');
INSERT INTO `course` VALUES ('113', 'Java8基础教程-8', '2019121122', '7e431314b33c4293816c67d90d2de534.jpg', '1', null, null, '初级', null, '2019-12-11', '120H', '1', '五六七');
INSERT INTO `course` VALUES ('114', 'Mysql基础-6', '2019121123', 'bc6645b8ca264edbb42742c615885d53.jpg', '3', null, null, '初级', null, '2019-12-12', '20H', '1', 'Mr.M');
INSERT INTO `course` VALUES ('115', 'Mysql基础', '2019121124', 'bc6645b8ca264edbb42742c615885d53.jpg', '3', null, null, '初级', null, '2019-12-12', '20H', '1', 'Mr.M');
INSERT INTO `course` VALUES ('116', 'Java8基础教程-9', '2019121125', '7e431314b33c4293816c67d90d2de534.jpg', '1', null, null, '初级', null, '2019-12-11', '120H', '1', '五六七');
INSERT INTO `course` VALUES ('117', 'Linux-5', '2019121126', '79ef11c3db634bbda540c5ac8b2ce942.jpg', '2', null, null, '初级', null, '2019-12-12', '60H', '1', 'MR.linux');
INSERT INTO `course` VALUES ('118', 'Linux-6', '2019121127', '79ef11c3db634bbda540c5ac8b2ce942.jpg', '2', null, null, '初级', null, '2019-12-12', '60H', '1', 'MR.linux');
INSERT INTO `course` VALUES ('119', 'Java8基础教程-10', '2019121128', '7e431314b33c4293816c67d90d2de534.jpg', '1', null, null, '初级', null, '2019-12-11', '120H', '1', '五六七');
INSERT INTO `course` VALUES ('120', 'Linux-7', '2019121129', 'b2f04a294cdf4064add9eba69d68910a.jpg', '2', null, null, '初级', null, '2019-12-12', '60H', '1', 'MR.linux');

-- ----------------------------
-- Table structure for `dict`
-- ----------------------------
DROP TABLE IF EXISTS `dict`;
CREATE TABLE `dict` (
  `dict_id` int(32) NOT NULL AUTO_INCREMENT,
  `course_class` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`dict_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dict
-- ----------------------------
INSERT INTO `dict` VALUES ('1', 'Java');
INSERT INTO `dict` VALUES ('2', 'Linux');
INSERT INTO `dict` VALUES ('3', '数据库');

-- ----------------------------
-- Table structure for `mycourse`
-- ----------------------------
DROP TABLE IF EXISTS `mycourse`;
CREATE TABLE `mycourse` (
  `u_id` int(32) DEFAULT NULL,
  `c_chapter_id` int(255) DEFAULT NULL,
  `m_name` varchar(32) DEFAULT NULL,
  `m_plan` varchar(32) DEFAULT NULL,
  `m_price` int(32) DEFAULT NULL,
  `m_date` varchar(128) DEFAULT NULL,
  `m_id` int(32) NOT NULL AUTO_INCREMENT,
  `m_img` varchar(255) DEFAULT NULL,
  `m_author` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`m_id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mycourse
-- ----------------------------
INSERT INTO `mycourse` VALUES ('15', '2019121104', 'Mysql基础0', '0', '0', '2019-12-18', '36', 'bc6645b8ca264edbb42742c615885d53.jpg', 'Mr.M');
INSERT INTO `mycourse` VALUES ('15', '2019121102', 'Java0基础教程', '0', '0', '2019-12-18', '37', 'cda8ce54c0a9426d8fb0f9225c1d0ccf.jpg', '五六七');
INSERT INTO `mycourse` VALUES ('16', '2019121102', 'Java0基础教程', '0', '0', '2019-12-19', '42', 'cda8ce54c0a9426d8fb0f9225c1d0ccf.jpg', '五六七');
INSERT INTO `mycourse` VALUES ('16', '2019121104', 'Mysql基础0', '0', '0', '2019-12-19', '43', 'bc6645b8ca264edbb42742c615885d53.jpg', 'Mr.M');
INSERT INTO `mycourse` VALUES ('17', '2019121102', 'Java0基础教程', '0', '0', '2019-12-19', '44', 'cda8ce54c0a9426d8fb0f9225c1d0ccf.jpg', '五六七');
INSERT INTO `mycourse` VALUES ('17', '2019121104', 'Mysql基础0', '0', '0', '2019-12-19', '45', 'bc6645b8ca264edbb42742c615885d53.jpg', 'Mr.M');
INSERT INTO `mycourse` VALUES ('18', '2019121102', 'Java0基础教程', '0', '0', '2019-12-20', '47', 'cda8ce54c0a9426d8fb0f9225c1d0ccf.jpg', '五六七');
INSERT INTO `mycourse` VALUES ('18', '2019121105', 'Mysql基础-1', '0', '0', '2019-12-20', '48', 'bc6645b8ca264edbb42742c615885d53.jpg', 'Mr.M');
INSERT INTO `mycourse` VALUES ('13', '2019121102', 'Java0基础教程', '73', '0', '2019-12-22', '53', 'cda8ce54c0a9426d8fb0f9225c1d0ccf.jpg', '五六七');
INSERT INTO `mycourse` VALUES ('1', '2019121102', 'Java0基础教程', '37', '0', '2019-12-22', '54', 'cda8ce54c0a9426d8fb0f9225c1d0ccf.jpg', '五六七');
INSERT INTO `mycourse` VALUES ('1', '2019121104', 'Mysql基础0', '0', '0', '2019-12-22', '55', 'bc6645b8ca264edbb42742c615885d53.jpg', 'Mr.M');
INSERT INTO `mycourse` VALUES ('19', '2019121104', 'Mysql基础0', '100', '0', '2019-12-23', '57', 'bc6645b8ca264edbb42742c615885d53.jpg', 'Mr.M');
INSERT INTO `mycourse` VALUES ('19', '2019121102', 'Java0基础教程', '42', '0', '2019-12-23', '58', 'cda8ce54c0a9426d8fb0f9225c1d0ccf.jpg', '五六七');
INSERT INTO `mycourse` VALUES ('20', '2019121102', 'Java0基础教程', '43', '0', '2019-12-23', '59', 'cda8ce54c0a9426d8fb0f9225c1d0ccf.jpg', '五六七');
INSERT INTO `mycourse` VALUES ('20', '2019121104', 'Mysql基础0', '0', '0', '2019-12-23', '60', 'bc6645b8ca264edbb42742c615885d53.jpg', 'Mr.M');

-- ----------------------------
-- Table structure for `my_plan`
-- ----------------------------
DROP TABLE IF EXISTS `my_plan`;
CREATE TABLE `my_plan` (
  `p_id` int(32) NOT NULL AUTO_INCREMENT,
  `p_cha_id` int(32) DEFAULT NULL,
  `p_plan` int(32) DEFAULT NULL,
  `p_course_id` int(32) DEFAULT NULL,
  `u_id` int(32) DEFAULT NULL,
  `m_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of my_plan
-- ----------------------------
INSERT INTO `my_plan` VALUES ('29', '9', '100', '2019121104', '15', null);
INSERT INTO `my_plan` VALUES ('30', '10', '25', '2019121104', '15', null);
INSERT INTO `my_plan` VALUES ('31', '2', '48', '2019121102', '15', null);
INSERT INTO `my_plan` VALUES ('32', '3', '50', '2019121102', '15', null);
INSERT INTO `my_plan` VALUES ('33', '11', '24', '2019121102', '15', null);
INSERT INTO `my_plan` VALUES ('34', '12', '0', '2019121102', '15', null);
INSERT INTO `my_plan` VALUES ('49', '2', '48', '2019121102', '16', null);
INSERT INTO `my_plan` VALUES ('50', '3', '50', '2019121102', '16', null);
INSERT INTO `my_plan` VALUES ('51', '11', '24', '2019121102', '16', null);
INSERT INTO `my_plan` VALUES ('52', '12', '0', '2019121102', '16', null);
INSERT INTO `my_plan` VALUES ('53', '9', '100', '2019121104', '16', null);
INSERT INTO `my_plan` VALUES ('54', '10', '0', '2019121104', '16', null);
INSERT INTO `my_plan` VALUES ('55', '2', '48', '2019121102', '17', null);
INSERT INTO `my_plan` VALUES ('56', '3', '50', '2019121102', '17', null);
INSERT INTO `my_plan` VALUES ('57', '11', '24', '2019121102', '17', null);
INSERT INTO `my_plan` VALUES ('58', '12', '0', '2019121102', '17', null);
INSERT INTO `my_plan` VALUES ('59', '9', '100', '2019121104', '17', null);
INSERT INTO `my_plan` VALUES ('60', '10', '0', '2019121104', '17', null);
INSERT INTO `my_plan` VALUES ('61', '2', '48', '2019121102', '18', null);
INSERT INTO `my_plan` VALUES ('62', '3', '50', '2019121102', '18', null);
INSERT INTO `my_plan` VALUES ('63', '11', '24', '2019121102', '18', null);
INSERT INTO `my_plan` VALUES ('74', '2', '95', '2019121102', '13', null);
INSERT INTO `my_plan` VALUES ('75', '3', '100', '2019121102', '13', null);
INSERT INTO `my_plan` VALUES ('76', '11', '24', '2019121102', '13', null);
INSERT INTO `my_plan` VALUES ('77', '2', '46', '2019121102', '1', null);
INSERT INTO `my_plan` VALUES ('78', '3', '35', '2019121102', '1', null);
INSERT INTO `my_plan` VALUES ('79', '11', '31', '2019121102', '1', null);
INSERT INTO `my_plan` VALUES ('80', '9', '0', '2019121104', '1', null);
INSERT INTO `my_plan` VALUES ('81', '10', '0', '2019121104', '1', null);
INSERT INTO `my_plan` VALUES ('85', '9', '100', '2019121104', '19', null);
INSERT INTO `my_plan` VALUES ('86', '10', '100', '2019121104', '19', null);
INSERT INTO `my_plan` VALUES ('87', '2', '92', '2019121102', '19', null);
INSERT INTO `my_plan` VALUES ('88', '3', '36', '2019121102', '19', null);
INSERT INTO `my_plan` VALUES ('89', '11', '0', '2019121102', '19', null);
INSERT INTO `my_plan` VALUES ('90', '2', '39', '2019121102', '20', null);
INSERT INTO `my_plan` VALUES ('91', '3', '100', '2019121102', '20', null);
INSERT INTO `my_plan` VALUES ('92', '11', '36', '2019121102', '20', null);
INSERT INTO `my_plan` VALUES ('93', '12', '0', '2019121102', '20', null);
INSERT INTO `my_plan` VALUES ('94', '9', '0', '2019121104', '20', null);
INSERT INTO `my_plan` VALUES ('95', '10', '0', '2019121104', '20', null);

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(32) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(128) DEFAULT NULL,
  `password` varchar(128) DEFAULT NULL,
  `username` varchar(128) DEFAULT NULL,
  `r_id` int(32) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '管理员', '4fd529144d4e2da8e5b59ec60f0f17c6', 'admin', '1');
INSERT INTO `user` VALUES ('13', '用户aa', '8410e821a87165b05bdf0ca0d214d78c', 'aa', '0');
INSERT INTO `user` VALUES ('14', '用户cc', 'fdbd56c0fc568fa7d42df1b70f7cf30d', 'cc', '0');
INSERT INTO `user` VALUES ('15', '用户dd', '74676f428c64c4d5fd70d4810ce072de', 'dd', '0');
INSERT INTO `user` VALUES ('16', '用户bb', 'dd120d6a2e527db07cd99cfea39bb3dc', 'bb', '0');
INSERT INTO `user` VALUES ('17', '用户aaa', 'edf711bd9d51c5761afde09a856784ae', 'aaa', '0');
INSERT INTO `user` VALUES ('19', 'qq', 'a6617cbcfede0c4e0f226a0f595a041a', 'qq', '0');
INSERT INTO `user` VALUES ('20', 'qqq', '8e46c77238a5161c772763a36277bd3d', 'qqq', '0');

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `authority` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', 'user:admin');
