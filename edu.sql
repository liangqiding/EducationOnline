/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : edu

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2020-05-03 17:14:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for chapter
-- ----------------------------
DROP TABLE IF EXISTS `chapter`;
CREATE TABLE `chapter` (
  `cha_id` int(32) NOT NULL AUTO_INCREMENT,
  `course_id` int(255) DEFAULT NULL,
  `video` varchar(255) DEFAULT NULL,
  `cha_sum` int(64) DEFAULT NULL,
  `cha_date` varchar(255) DEFAULT NULL,
  `cha_name` varchar(32) DEFAULT NULL,
  `data` varchar(255) DEFAULT NULL,
  `images` varchar(255) DEFAULT NULL,
  `cha_like` int(64) DEFAULT NULL,
  PRIMARY KEY (`cha_id`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of chapter
-- ----------------------------
INSERT INTO `chapter` VALUES ('49', '184', '1/184/bba7bc1e61ad47f4890f7ac479eafe4f.mp4', null, '2020-04-12', 'Java基础-1-a', null, '13/b16cf804cf524a7bbacbdd5a05db36e2.jpg', null);
INSERT INTO `chapter` VALUES ('50', '185', '15/185/f784eefa2a5f4cddb10f10b42df1a44c.mp4', null, '2020-04-12', 'Linux 基础知识-1', null, '15/ec1afbba3bc2430a99bf3fe099f1c8a9.jpg', null);
INSERT INTO `chapter` VALUES ('51', '186', '1/186/42d957b331a64014b55f31ebadebf92f.mp4', null, '2020-04-12', 'CSS核心基础-1', null, '16/e46d12c6a813418885fd83a77c68bea0.jpg', null);
INSERT INTO `chapter` VALUES ('52', '187', '14/187/5ad404594db143b1ab8ad4b863a5627f.mp4', null, '2020-04-12', '大数据-1', null, '14/cac107f81e764a8eb439794c1c01a1c5.jpg', null);
INSERT INTO `chapter` VALUES ('53', '188', '1/188/24254030c5554073974c73e1a875792e.mp4', null, '2020-04-12', 'C语言核心技术', null, '1/58905b177f4a48868f61652674280368.jpg', null);
INSERT INTO `chapter` VALUES ('54', '189', '1/189/69ba2ca3b0824f8db69b8e7a718e1341.mp4', null, '2020-04-12', 'Java基础实战_Bank项目-1', null, '1/8598eaae209a4deab0c44c121bfda761.jpg', null);
INSERT INTO `chapter` VALUES ('55', '190', '1/190/7219c61ff70643f78300ccd597262f27.mp4', null, '2020-04-12', 'Java12＆13新特性', null, '1/5cb2f6fe2e454721b2bb8c6642643591.jpg', null);
INSERT INTO `chapter` VALUES ('56', '191', '1/191/2478da09f0db42f1a57a78a86939e75c.mp4', null, '2020-04-12', 'Java11新特性', null, '1/62f7fc9d443d40528175c15b1f302276.jpg', null);
INSERT INTO `chapter` VALUES ('57', '192', '1/192/992c60d3347f4b7fb1d28da96aff1cd6.mp4', null, '2020-04-12', 'Java9新特性', null, '1/a9d410dbf21746c8bac887885ad2ceb4.jpg', null);
INSERT INTO `chapter` VALUES ('58', '193', '1/193/5e9d8c1bcb49414cba5069cb59d2382f.mp4', null, '2020-04-12', 'SpringCloud（2020新版）-1', null, '1/6a95485323dc4846bf058e944762dd58.jpg', null);
INSERT INTO `chapter` VALUES ('59', '194', '1/194/c24165ae31804e1ab252357458dcd9d5.mp4', null, '2020-04-12', ' 点击试看 Linux系统管理教程-1', null, '13/1a5da45eab954de9aceea17592644517.jpg', null);
INSERT INTO `chapter` VALUES ('60', '195', '1/195/d778a477a3cd4c2d9bad65cf851a77c8.mp4', null, '2020-04-12', 'Linux系统管理教程', null, '13/57a51408d9db4f5db4f7f66b673ae20b.jpg', null);
INSERT INTO `chapter` VALUES ('61', '196', '1/196/3b3fe77146af4ba4bf20cad36d789e90.mp4', null, '2020-04-12', 'Linux进程管理教程-1', null, '13/c6fd85de9ab54dc1b1c373c4f00e1cb4.jpg', null);
INSERT INTO `chapter` VALUES ('62', '197', '13/197/dad9b1601b2a44359b659a8445e8bfaf.mp4', null, '2020-04-12', 'Linux集群教程', null, '13/a83b830050ee43f48b6359ba1ef6abab.jpg', null);
INSERT INTO `chapter` VALUES ('63', '198', '16/198/0cf0ce460cff4ccba4965a105cf60149.mp4', null, '2020-04-12', 'Bootstrap视频教程', null, '16/ac754f9cab3f44ff975b5bc662c70226.jpg', null);
INSERT INTO `chapter` VALUES ('64', '199', '16/199/d93e15023ae24b2b94126f32b8df7814.mp4', null, '2020-04-12', 'js核心', null, '16/d863600063544bd5ba48c318ee82ea45.jpg', null);
INSERT INTO `chapter` VALUES ('65', '200', '16/200/1fca945b11c044228f3562dc46a57a80.mp4', null, '2020-04-12', ' 点击试看 jQuery视频教程', null, '16/9fe5e1218ddb453b96e21f208ea95616.jpg', null);
INSERT INTO `chapter` VALUES ('66', '201', '14/201/1653779cd2ab4f4bacfc2d16cb88a3d6.mp4', null, '2020-04-12', 'MySQL核心技术-1', null, '14/8fe0298ad778427a84fed6a7c77be134.jpg', null);
INSERT INTO `chapter` VALUES ('67', '202', '14/202/4f3f51969e1540778006338b79b2d0e6.mp4', null, '2020-04-12', 'SSM（大数据定制版）-1', null, '14/2b1c2094d31148d6ad27724878d4aa03.jpg', null);
INSERT INTO `chapter` VALUES ('68', '203', '14/203/303dea3d98d149e9b2b6798519ef3898.mp4', null, '2020-04-12', 'Spring（大数据定制版）-1', null, '14/ced68574828a43d19e3f7ffe3691fd5d.jpg', null);
INSERT INTO `chapter` VALUES ('69', '204', '14/204/e02b27e55e744eb69eb324f697d31223.mp4', null, '2020-04-12', 'Docker核心技术-1', null, '14/c74790297cf14a359ca3d69c9b5552f9.jpg', null);
INSERT INTO `chapter` VALUES ('70', '184', '13/184/7cb9445c4c934843bb6b52bdc983c1ea.mp4', null, '2020-05-01', 'Java基础-1-b', null, '13/e12a479637f44bb383e02815a187054b.mp4', null);
INSERT INTO `chapter` VALUES ('71', '184', '13/184/de5f076d5e394c1a96286cdd51d97eed.mp4', null, '2020-05-01', 'Java基础-1-c', null, '13/77174ea5977c4afc94066a068d8481d5.jpg', null);
INSERT INTO `chapter` VALUES ('72', '184', '13/184/db808af79b11475d9a0f568472cedc62.mp4', null, '2020-05-01', 'Java基础-1-d', null, '13/e200393abf344b2d806f1c392cf6a7b0.jpg', null);
INSERT INTO `chapter` VALUES ('73', '205', '1/205/ee5c197bf527440a9fec0e33eb9dc57e.mp4', null, '2020-05-03', 'Java基础-1-a', null, '1/aa0547729d634049afe4dc74633cf978.jpg', null);
INSERT INTO `chapter` VALUES ('74', '206', '27/206/c7445e18ba374836905537625a4789ab.mp4', null, '2020-05-03', 'LINUX_1111', null, '27/35c05a31c6d34ffd85e6ffb5a4fd2564.jpg', null);
INSERT INTO `chapter` VALUES ('75', '207', '30/207/5425783c27cc46579cb7879b16b85d45.mp4', null, '2020-05-03', 'Java基础-XXXAAAA111', null, '30/81e4416c2ab249b6812338dd3df907b9.jpg', null);

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `course_id` int(32) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(64) DEFAULT NULL,
  `state` varchar(32) DEFAULT NULL,
  `img` varchar(256) DEFAULT NULL,
  `class_id` int(32) DEFAULT NULL,
  `view` int(32) DEFAULT NULL,
  `like` int(32) DEFAULT NULL,
  `grade` varchar(32) DEFAULT NULL,
  `price` int(32) DEFAULT NULL,
  `course_date` varchar(255) DEFAULT NULL,
  `class_hour` varchar(64) DEFAULT NULL,
  `u_id` int(128) DEFAULT NULL,
  `author` varchar(32) DEFAULT NULL,
  `introduction` varchar(255) DEFAULT NULL,
  `uuid` varchar(255) DEFAULT NULL,
  `good` int(64) DEFAULT NULL,
  `vip` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=208 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('184', 'Java核心基础30天', '通过', '13/ea494bba805a4a8dad4e7ea27797b6b6.jpg', '1', '13', '7', '初级', '0', '2020-04-12', '720', '13', null, '2019版—30天搞定Java核心技术', '9f648d4b56744c7f8a228cbe0a915afd', '5', '1');
INSERT INTO `course` VALUES ('185', 'Linux  基础知识', '通过', '15/1cf4c1869e2a400b9e3ea86e4c66500f.jpg', '2', '5', '0', '初级', '0', '2020-04-12', '80', '15', null, 'Linux  基础知识Linux  基础知识Linux  基础知识Linux  基础知识Linux  基础知识', 'e21f20fb72994a9494d156ac47e9438d', '0', '1');
INSERT INTO `course` VALUES ('186', 'HTML&CSS核心基础', '通过', '16/08905d24b04245bcaf61999b73cc9a98.jpg', '3', '2', '1', '初级', '0', '2020-04-12', '120', '16', null, '本套视频适合零基础并且对前端知识感兴趣的同学。内容涵盖HTML基础、标签、CSS 选择器、盒子模型、浮动、定位、图片整合、PS 切图等页面相关常用技术。 ', '7375840831ff4a7a802337bca05a4477', '1', '1');
INSERT INTO `course` VALUES ('187', 'JavaWEB（大数据定制版）', '通过', '14/7c9782c2f1a1457eb0c2517f701e7438.jpg', '4', '0', '0', '初级', '0', '2020-04-12', '120', '14', null, '本JavaWEB视频教程是专为大数据方向的学员量身打造，涵盖JavaWEB 企业级开发所用到的HTML、CSS、JavaScript、jQuery、Ajax、JSON、XML、XML 解析、Servlet、JSP、MVC 设计模式、EL 表达式 、Cookie、HttpSession', '3909235bd58e4f3f8eee38cef9c941bd', '0', '1');
INSERT INTO `course` VALUES ('188', '人工智能', '通过', '1/08c6da5a4160412985f60b6f67c1fa6b.jpg', '5', '2', '0', '初级', '0', '2020-04-12', '100', '1', null, 'C语言核心技术C语言核心技术C语言核心技术C语言核心技术C语言核心技术', '382b5afc798f4d32afcb6706ea4c7f21', '0', '1');
INSERT INTO `course` VALUES ('189', 'Java基础实战_Bank项目', '通过', '1/5fdba6d649344338a768261545d2968a.jpg', '1', '2', '0', '高级', '0', '2020-04-12', '120', '1', null, 'Java基础实战_Bank项目Java基础实战_Bank项目Java基础实战_Bank项目Java基础实战_Bank项目Java基础实战_Bank项目', 'd1a36fcb643248d3bded7f3d358a7c20', '0', '0');
INSERT INTO `course` VALUES ('190', 'Java12＆13新特性', '通过', '1/8d978fce61fa4a879badd65becb2e89f.jpg', '1', '0', '0', '中级', '0', '2020-04-12', '60', '1', null, 'Java12＆13新特性Java12＆13新特性Java12＆13新特性', '51c9447af2ed48b196bb89f00df071a0', '0', '0');
INSERT INTO `course` VALUES ('191', 'Java11新特性', '通过', '1/82a9264cea0a4648a7004ac0340c7850.jpg', '1', '0', '0', '中级', '0', '2020-04-12', '111', '1', null, 'Java11新特性Java11新特性Java11新特性Java11新特性', 'd31713f0dab746e68aa221a4f5bce7f7', '0', '0');
INSERT INTO `course` VALUES ('192', 'Java9新特性', '通过', '1/ed195df47c2f443c9ca3727de4e9aa08.jpg', '1', '0', '0', '中级', '0', '2020-04-12', '10', '1', null, 'Java9新特性Java9新特性Java9新特性Java9新特性Java9新特性Java9新特性Java9新特性', '4c4727cc741c4e5baa32927ca4d2f382', '0', '0');
INSERT INTO `course` VALUES ('193', 'SpringCloud（2020新版）', '通过', '1/76c6fde9caf04fa89a1f36a0952756e1.jpg', '1', '0', '0', '高级', '0', '2020-04-12', '360', '1', null, 'SpringCloud（2020新版）SpringCloud（2020新版）SpringCloud（2020新版）SpringCloud（2020新版）SpringCloud（2020新版）', '089ec0197edf4ec6839251a5ff814139', '0', '0');
INSERT INTO `course` VALUES ('194', ' 点击试看 Linux系统管理教程', '通过', '13/ff14aa9dacf541b7aa14ef6262c7f6c8.jpg', '2', '2', '0', '初级', '0', '2020-04-12', '79', '13', null, ' 点击试看 Linux系统管理教程 点击试看 Linux系统管理教程', 'b0206b365c224b5aa6bcf15fbcd5014d', '0', '0');
INSERT INTO `course` VALUES ('195', 'Linux系统管理教程', '通过', '13/9925d0ca47034e55a2eb270e49944e36.jpg', '2', '1', '0', '中级', '0', '2020-04-12', '111', '13', null, 'Linux系统管理教程Linux系统管理教程', 'a13dead08e20431b82dc26b473cd8bff', '0', '0');
INSERT INTO `course` VALUES ('196', 'Linux进程管理教程', '通过', '13/5a621a465b2d4ec3b97938e449d6530f.jpg', '2', '1', '0', '高级', '0', '2020-04-12', '111', '13', null, 'Linux进程管理教程Linux进程管理教程Linux进程管理教程Linux进程管理教程Linux进程管理教程Linux进程管理教程', '85937add09df4877ae246dc2c7b96a0e', '0', '0');
INSERT INTO `course` VALUES ('197', 'Linux集群教程', '通过', '13/6f6a47398bb74468b1ded9cf78b11a5f.jpg', '2', '2', '0', '高级', '0', '2020-04-12', '250', '13', null, 'Linux集群教程Linux集群教程Linux集群教程Linux集群教程', 'bf66d269d66848978831885312320768', '0', '0');
INSERT INTO `course` VALUES ('198', 'Bootstrap视频教程', '通过', '16/b862d85cf0414127a702b2c49982632a.jpg', '3', '0', '0', '初级', '0', '2020-04-12', '111', '16', null, 'Bootstrap视频教程Bootstrap视频教程Bootstrap视频教程', '0fbdea1f1f814633925b5213eb1245e7', '0', '0');
INSERT INTO `course` VALUES ('199', 'JS', '通过', '16/730506e0022d4beebba768940cceb558.jpg', '3', '0', '0', '中级', '0', '2020-04-12', '111', '16', null, 'JS ', 'ca19b8905b7e4f22a83cedfbb28af19c', '0', '0');
INSERT INTO `course` VALUES ('200', ' 点击试看 jQuery视频教程', '通过', '16/8cfad1b20b724ea1885e2e99edb8c007.jpg', '3', '0', '0', '初级', '0', '2020-04-12', '111', '16', null, ' 点击试看 jQuery视频教程 点击试看 jQuery视频教程 点击试看 jQuery视频教程', 'fbfb2d1eff954b9f95c6520a409bdb8a', '0', '0');
INSERT INTO `course` VALUES ('201', 'MySQL核心技术', '通过', '14/330bcd90bca24f79b8edc6520cbb6323.jpg', '4', '0', '0', '中级', '0', '2020-04-12', '111', '14', null, ' 点击试看 MySQL核心技术', '35b7b5c10ab7411c9e5766db6df90ab4', '0', '0');
INSERT INTO `course` VALUES ('202', 'SSM（大数据定制版）', '通过', '14/916697984ebb48d08cac28bc68b21733.jpg', '4', '0', '0', '高级', '0', '2020-04-12', '250', '14', null, 'SSM（大数据定制版）', '9ae05a70523e4922a47633c7dd4fb7b8', '0', '0');
INSERT INTO `course` VALUES ('203', 'Spring（大数据定制版）', '通过', '14/6be789845e1844e6b69cf3c181599be4.jpg', '4', '0', '0', '高级', '0', '2020-04-12', '60', '14', null, 'Spring（大数据定制版）', 'ea9cb5cd39584db7ad2b465d150e8aad', '0', '0');
INSERT INTO `course` VALUES ('204', 'Docker核心技术', '通过', '14/24f037e5e6464af0848ba5a7a47b608b.jpg', '4', '0', '0', '高级', '0', '2020-04-12', '120', '14', null, 'Docker核心技术Docker核心技术Docker核心技术Docker核心技术', '6f890762162b4e5cb5ce1df90aa30e18', '0', '0');
INSERT INTO `course` VALUES ('205', 'JavaAAAAAAAA', '通过', '1/6765cdb535b14c38be672cb90e370da7.jpg', '1', '1', '0', '初级', '0', '2020-05-03', '2222', '1', null, '2222', '9c6db2b6feec41b6863634618ba568a0', '0', '0');
INSERT INTO `course` VALUES ('206', 'Linux_XXXX', '通过', '27/1c62842f229442588b4038151250cd13.jpg', '2', '0', '0', '初级', '0', '2020-05-03', '2222', '27', null, '111111', 'd16974e97aa04cbba9a0050044b18b29', '0', '0');
INSERT INTO `course` VALUES ('207', 'JAVA_XXXXXXXXXXXX', '通过', '30/c7da1e80d0f84efdb131fbb598b6dce2.jpg', '1', '0', '0', '中级', '0', '2020-05-03', '2222', '30', null, '2222', '679b3da06427417fb84a6178e58785d7', '0', '0');

-- ----------------------------
-- Table structure for dict
-- ----------------------------
DROP TABLE IF EXISTS `dict`;
CREATE TABLE `dict` (
  `dict_id` int(32) NOT NULL AUTO_INCREMENT,
  `course_class` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`dict_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dict
-- ----------------------------
INSERT INTO `dict` VALUES ('1', 'Java');
INSERT INTO `dict` VALUES ('2', 'Linux');
INSERT INTO `dict` VALUES ('3', 'H5前端');
INSERT INTO `dict` VALUES ('4', '大数据');
INSERT INTO `dict` VALUES ('5', 'C/Python');

-- ----------------------------
-- Table structure for like
-- ----------------------------
DROP TABLE IF EXISTS `like`;
CREATE TABLE `like` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` int(32) DEFAULT NULL,
  `u_id` int(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of like
-- ----------------------------
INSERT INTO `like` VALUES ('20', '81', '19');
INSERT INTO `like` VALUES ('21', '115', '19');
INSERT INTO `like` VALUES ('23', '186', '25');
INSERT INTO `like` VALUES ('24', '184', '13');
INSERT INTO `like` VALUES ('26', '184', '1');
INSERT INTO `like` VALUES ('27', '184', '26');
INSERT INTO `like` VALUES ('28', '184', '27');
INSERT INTO `like` VALUES ('29', '184', '28');
INSERT INTO `like` VALUES ('30', '184', '30');

-- ----------------------------
-- Table structure for mycourse
-- ----------------------------
DROP TABLE IF EXISTS `mycourse`;
CREATE TABLE `mycourse` (
  `m_id` int(32) NOT NULL AUTO_INCREMENT,
  `u_id` int(32) DEFAULT NULL,
  `cha_id` int(255) DEFAULT NULL,
  `m_plan` varchar(32) DEFAULT NULL,
  `m_price` int(32) DEFAULT NULL,
  `m_date` varchar(128) DEFAULT NULL,
  `last_date` varchar(128) DEFAULT NULL,
  `p_id` int(64) DEFAULT NULL,
  `course_id` int(64) DEFAULT NULL,
  `footmark` int(64) DEFAULT NULL,
  PRIMARY KEY (`m_id`)
) ENGINE=InnoDB AUTO_INCREMENT=108 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mycourse
-- ----------------------------
INSERT INTO `mycourse` VALUES ('61', '19', '10', null, null, '2020-03-06', '2020-03-19', null, '81', '60');
INSERT INTO `mycourse` VALUES ('64', '0', '2', null, null, '2020-03-09', null, null, '81', null);
INSERT INTO `mycourse` VALUES ('65', '20', '2', null, null, '2020-03-09', '2020-03-09', null, '81', '0');
INSERT INTO `mycourse` VALUES ('66', '19', '16', null, null, '2020-03-09', '2020-03-19', null, '111', '0');
INSERT INTO `mycourse` VALUES ('67', '0', '16', null, null, '2020-03-09', null, null, '111', null);
INSERT INTO `mycourse` VALUES ('68', '1', '9', null, null, '2020-03-12', '2020-03-25', null, '81', '26');
INSERT INTO `mycourse` VALUES ('69', '1', '18', null, null, '2020-03-17', '2020-03-17', null, '116', '32');
INSERT INTO `mycourse` VALUES ('70', '1', '19', null, null, '2020-03-17', '2020-03-17', null, '164', '0');
INSERT INTO `mycourse` VALUES ('71', '1', '16', null, null, '2020-03-19', '2020-03-19', null, '111', '0');
INSERT INTO `mycourse` VALUES ('72', '22', '3', null, null, '2020-03-20', '2020-03-20', null, '81', '20');
INSERT INTO `mycourse` VALUES ('73', '1', '40', null, null, '2020-03-20', null, null, '180', null);
INSERT INTO `mycourse` VALUES ('74', '1', '39', null, null, '2020-03-20', null, null, '179', null);
INSERT INTO `mycourse` VALUES ('75', '22', '16', null, null, '2020-03-20', '2020-03-20', null, '111', '0');
INSERT INTO `mycourse` VALUES ('76', '22', '44', null, null, '2020-03-20', '2020-03-20', null, '114', '48');
INSERT INTO `mycourse` VALUES ('77', '1', '44', null, null, '2020-03-20', '2020-03-20', null, '114', '26');
INSERT INTO `mycourse` VALUES ('78', '13', '2', null, null, '2020-03-20', '2020-03-20', null, '81', '22');
INSERT INTO `mycourse` VALUES ('79', '16', '2', null, null, '2020-03-20', '2020-03-21', null, '81', '21');
INSERT INTO `mycourse` VALUES ('80', '23', '2', null, null, '2020-03-25', '2020-03-25', null, '81', '20');
INSERT INTO `mycourse` VALUES ('81', '1', '71', null, null, '2020-04-12', '2020-05-03', null, '184', '1');
INSERT INTO `mycourse` VALUES ('82', '16', '50', null, null, '2020-04-12', '2020-04-12', null, '185', '0');
INSERT INTO `mycourse` VALUES ('83', '13', '49', null, null, '2020-04-12', '2020-05-01', null, '184', '5');
INSERT INTO `mycourse` VALUES ('84', '14', '50', null, null, '2020-04-12', '2020-04-12', null, '185', '0');
INSERT INTO `mycourse` VALUES ('85', '14', '49', null, null, '2020-04-12', '2020-04-12', null, '184', '0');
INSERT INTO `mycourse` VALUES ('86', '14', '51', null, null, '2020-04-12', '2020-04-12', null, '186', '0');
INSERT INTO `mycourse` VALUES ('87', '25', '49', null, null, '2020-05-01', '2020-05-01', null, '184', '86');
INSERT INTO `mycourse` VALUES ('88', '25', '50', null, null, '2020-05-01', '2020-05-01', null, '185', '1');
INSERT INTO `mycourse` VALUES ('89', '25', '51', null, null, '2020-05-01', '2020-05-01', null, '186', '87');
INSERT INTO `mycourse` VALUES ('90', '25', '54', null, null, '2020-05-01', '2020-05-01', null, '189', '2');
INSERT INTO `mycourse` VALUES ('91', '25', '53', null, null, '2020-05-01', '2020-05-01', null, '188', '0');
INSERT INTO `mycourse` VALUES ('92', '1', '59', null, null, '2020-05-03', '2020-05-03', null, '194', '0');
INSERT INTO `mycourse` VALUES ('93', '1', '60', null, null, '2020-05-03', '2020-05-03', null, '195', '0');
INSERT INTO `mycourse` VALUES ('94', '1', '61', null, null, '2020-05-03', '2020-05-03', null, '196', '0');
INSERT INTO `mycourse` VALUES ('95', '1', '73', null, null, '2020-05-03', '2020-05-03', null, '205', '0');
INSERT INTO `mycourse` VALUES ('96', '1', '50', null, null, '2020-05-03', '2020-05-03', null, '185', '0');
INSERT INTO `mycourse` VALUES ('97', '26', '70', null, null, '2020-05-03', '2020-05-03', null, '184', '9');
INSERT INTO `mycourse` VALUES ('98', '26', '62', null, null, '2020-05-03', '2020-05-03', null, '197', '0');
INSERT INTO `mycourse` VALUES ('99', '27', '72', null, null, '2020-05-03', '2020-05-03', null, '184', '16');
INSERT INTO `mycourse` VALUES ('100', '27', '59', null, null, '2020-05-03', '2020-05-03', null, '194', '0');
INSERT INTO `mycourse` VALUES ('101', '1', '54', null, null, '2020-05-03', '2020-05-03', null, '189', '8');
INSERT INTO `mycourse` VALUES ('102', '28', '72', null, null, '2020-05-03', '2020-05-03', null, '184', '24');
INSERT INTO `mycourse` VALUES ('103', '28', '50', null, null, '2020-05-03', '2020-05-03', null, '185', '0');
INSERT INTO `mycourse` VALUES ('104', '29', '49', null, null, '2020-05-03', '2020-05-03', null, '184', '12');
INSERT INTO `mycourse` VALUES ('105', '30', '72', null, null, '2020-05-03', '2020-05-03', null, '184', '12');
INSERT INTO `mycourse` VALUES ('106', '30', '62', null, null, '2020-05-03', '2020-05-03', null, '197', '0');
INSERT INTO `mycourse` VALUES ('107', '1', '53', null, null, '2020-05-03', '2020-05-03', null, '188', '6');

-- ----------------------------
-- Table structure for my_plan
-- ----------------------------
DROP TABLE IF EXISTS `my_plan`;
CREATE TABLE `my_plan` (
  `p_id` int(32) NOT NULL AUTO_INCREMENT,
  `cha_id` int(32) DEFAULT NULL,
  `p_plan` int(32) DEFAULT NULL,
  `course_id` int(32) DEFAULT NULL,
  `u_id` int(32) DEFAULT NULL,
  `m_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB AUTO_INCREMENT=470 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of my_plan
-- ----------------------------
INSERT INTO `my_plan` VALUES ('390', '8', '80', '81', '19', null);
INSERT INTO `my_plan` VALUES ('391', '3', '41', '81', '19', null);
INSERT INTO `my_plan` VALUES ('392', '9', '52', '81', '19', null);
INSERT INTO `my_plan` VALUES ('393', '10', '60', '81', '19', null);
INSERT INTO `my_plan` VALUES ('395', '16', '25', '111', '19', null);
INSERT INTO `my_plan` VALUES ('396', '2', '0', '81', '20', null);
INSERT INTO `my_plan` VALUES ('397', '2', '30', '81', '1', null);
INSERT INTO `my_plan` VALUES ('398', '10', '100', '81', '1', null);
INSERT INTO `my_plan` VALUES ('399', '9', '42', '81', '1', null);
INSERT INTO `my_plan` VALUES ('400', '8', '51', '81', '1', null);
INSERT INTO `my_plan` VALUES ('401', '3', '51', '81', '1', null);
INSERT INTO `my_plan` VALUES ('402', '17', '16', '116', '1', null);
INSERT INTO `my_plan` VALUES ('403', '18', '32', '116', '1', null);
INSERT INTO `my_plan` VALUES ('404', '19', '0', '164', '1', null);
INSERT INTO `my_plan` VALUES ('405', '16', '0', '111', '1', null);
INSERT INTO `my_plan` VALUES ('406', '2', '97', '81', '22', null);
INSERT INTO `my_plan` VALUES ('407', null, '0', '81', '22', null);
INSERT INTO `my_plan` VALUES ('408', null, '0', '81', '22', null);
INSERT INTO `my_plan` VALUES ('409', null, '0', '81', '22', null);
INSERT INTO `my_plan` VALUES ('410', null, '0', '81', '22', null);
INSERT INTO `my_plan` VALUES ('411', null, '0', '81', '22', null);
INSERT INTO `my_plan` VALUES ('412', null, '0', '81', '22', null);
INSERT INTO `my_plan` VALUES ('413', null, '0', '81', '22', null);
INSERT INTO `my_plan` VALUES ('414', null, '0', '81', '22', null);
INSERT INTO `my_plan` VALUES ('415', null, '0', '81', '22', null);
INSERT INTO `my_plan` VALUES ('416', null, '0', '81', '22', null);
INSERT INTO `my_plan` VALUES ('417', null, '0', '81', '22', null);
INSERT INTO `my_plan` VALUES ('418', null, '0', '81', '22', null);
INSERT INTO `my_plan` VALUES ('419', null, '0', '81', '22', null);
INSERT INTO `my_plan` VALUES ('420', null, '0', '81', '22', null);
INSERT INTO `my_plan` VALUES ('421', null, '0', '81', '22', null);
INSERT INTO `my_plan` VALUES ('422', null, '0', '81', '22', null);
INSERT INTO `my_plan` VALUES ('423', null, '0', '81', '22', null);
INSERT INTO `my_plan` VALUES ('424', null, '0', '81', '22', null);
INSERT INTO `my_plan` VALUES ('425', null, '0', '81', '22', null);
INSERT INTO `my_plan` VALUES ('426', '3', '20', '81', '22', null);
INSERT INTO `my_plan` VALUES ('427', null, '0', '81', '22', null);
INSERT INTO `my_plan` VALUES ('428', null, '0', '81', '22', null);
INSERT INTO `my_plan` VALUES ('429', null, '0', '81', '22', null);
INSERT INTO `my_plan` VALUES ('430', '16', '0', '111', '22', null);
INSERT INTO `my_plan` VALUES ('431', '44', '48', '114', '22', null);
INSERT INTO `my_plan` VALUES ('432', '44', '26', '114', '1', null);
INSERT INTO `my_plan` VALUES ('433', '2', '22', '81', '13', null);
INSERT INTO `my_plan` VALUES ('434', '2', '21', '81', '16', null);
INSERT INTO `my_plan` VALUES ('435', '2', '20', '81', '23', null);
INSERT INTO `my_plan` VALUES ('436', '49', '9', '184', '1', null);
INSERT INTO `my_plan` VALUES ('437', '50', '0', '185', '16', null);
INSERT INTO `my_plan` VALUES ('438', '49', '6', '184', '13', null);
INSERT INTO `my_plan` VALUES ('439', '50', '0', '185', '14', null);
INSERT INTO `my_plan` VALUES ('440', '49', '0', '184', '14', null);
INSERT INTO `my_plan` VALUES ('441', '51', '0', '186', '14', null);
INSERT INTO `my_plan` VALUES ('442', '49', '96', '184', '25', null);
INSERT INTO `my_plan` VALUES ('443', '50', '42', '185', '25', null);
INSERT INTO `my_plan` VALUES ('444', '51', '87', '186', '25', null);
INSERT INTO `my_plan` VALUES ('445', '54', '77', '189', '25', null);
INSERT INTO `my_plan` VALUES ('446', '53', '0', '188', '25', null);
INSERT INTO `my_plan` VALUES ('447', '70', '0', '184', '1', null);
INSERT INTO `my_plan` VALUES ('448', '71', '1', '184', '1', null);
INSERT INTO `my_plan` VALUES ('449', '72', '14', '184', '1', null);
INSERT INTO `my_plan` VALUES ('450', '59', '0', '194', '1', null);
INSERT INTO `my_plan` VALUES ('451', '60', '0', '195', '1', null);
INSERT INTO `my_plan` VALUES ('452', '61', '0', '196', '1', null);
INSERT INTO `my_plan` VALUES ('453', '73', '0', '205', '1', null);
INSERT INTO `my_plan` VALUES ('454', '50', '0', '185', '1', null);
INSERT INTO `my_plan` VALUES ('455', '49', '14', '184', '26', null);
INSERT INTO `my_plan` VALUES ('456', '70', '22', '184', '26', null);
INSERT INTO `my_plan` VALUES ('457', '62', '0', '197', '26', null);
INSERT INTO `my_plan` VALUES ('458', '49', '13', '184', '27', null);
INSERT INTO `my_plan` VALUES ('459', '72', '16', '184', '27', null);
INSERT INTO `my_plan` VALUES ('460', '59', '0', '194', '27', null);
INSERT INTO `my_plan` VALUES ('461', '54', '8', '189', '1', null);
INSERT INTO `my_plan` VALUES ('462', '49', '13', '184', '28', null);
INSERT INTO `my_plan` VALUES ('463', '72', '24', '184', '28', null);
INSERT INTO `my_plan` VALUES ('464', '50', '0', '185', '28', null);
INSERT INTO `my_plan` VALUES ('465', '49', '12', '184', '29', null);
INSERT INTO `my_plan` VALUES ('466', '49', '13', '184', '30', null);
INSERT INTO `my_plan` VALUES ('467', '72', '13', '184', '30', null);
INSERT INTO `my_plan` VALUES ('468', '62', '0', '197', '30', null);
INSERT INTO `my_plan` VALUES ('469', '53', '6', '188', '1', null);

-- ----------------------------
-- Table structure for rate
-- ----------------------------
DROP TABLE IF EXISTS `rate`;
CREATE TABLE `rate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `u_id` int(11) DEFAULT NULL,
  `sum` int(128) DEFAULT NULL,
  `date` int(128) DEFAULT NULL,
  `state` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rate
-- ----------------------------
INSERT INTO `rate` VALUES ('1', null, '120', '201910', null);
INSERT INTO `rate` VALUES ('2', null, '110', '201911', null);
INSERT INTO `rate` VALUES ('3', null, '135', '201912', null);
INSERT INTO `rate` VALUES ('4', null, '90', '202001', null);
INSERT INTO `rate` VALUES ('5', null, '155', '200202', null);
INSERT INTO `rate` VALUES ('6', null, '98', '202003', null);
INSERT INTO `rate` VALUES ('7', null, '7', '202004', null);
INSERT INTO `rate` VALUES ('8', null, '25', '202005', null);

-- ----------------------------
-- Table structure for subscribe
-- ----------------------------
DROP TABLE IF EXISTS `subscribe`;
CREATE TABLE `subscribe` (
  `s_id` int(11) NOT NULL AUTO_INCREMENT,
  `u_id` int(11) DEFAULT NULL,
  `my_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of subscribe
-- ----------------------------
INSERT INTO `subscribe` VALUES ('5', '19', '1');
INSERT INTO `subscribe` VALUES ('8', '1', '1');
INSERT INTO `subscribe` VALUES ('9', '13', '25');
INSERT INTO `subscribe` VALUES ('10', '13', '26');
INSERT INTO `subscribe` VALUES ('11', '13', '27');
INSERT INTO `subscribe` VALUES ('12', '13', '28');
INSERT INTO `subscribe` VALUES ('13', '15', '28');
INSERT INTO `subscribe` VALUES ('14', '13', '30');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `u_id` int(32) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(128) DEFAULT NULL,
  `password` varchar(128) DEFAULT NULL,
  `username` varchar(128) DEFAULT NULL,
  `r_id` int(32) DEFAULT NULL,
  `email` varchar(64) DEFAULT NULL,
  `major` varchar(32) DEFAULT NULL,
  `introduce` varchar(255) DEFAULT NULL,
  `age` int(16) DEFAULT NULL,
  `sex` varchar(8) DEFAULT NULL,
  `date` varchar(128) DEFAULT NULL,
  `images` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '超级管理员', '4fd529144d4e2da8e5b59ec60f0f17c6', 'admin', '1', 'aaa.com', 'Java', 'AAAAAAAAAAAAAAAAAAAAAAAAAAA', '21', '男', '2019-11-11', '1/b18889c58f514715bdedc264c1ff392f.jpg');
INSERT INTO `user` VALUES ('13', 'MR.AA', '8410e821a87165b05bdf0ca0d214d78c', 'aa', '0', '111@qq.com', 'java', '11', '15', '女', '2020-02-11', '13/39fcb2ab75704e95bb48650365c28f9c.jpg');
INSERT INTO `user` VALUES ('14', 'Mr.CCCC', 'fdbd56c0fc568fa7d42df1b70f7cf30d', 'cc', '0', null, null, null, null, null, '2020-03-11', '14/4e00ae95c7fc400cbf339a04f81ff25e.jpg');
INSERT INTO `user` VALUES ('15', 'Mr.DDD', '74676f428c64c4d5fd70d4810ce072de', 'dd', '0', null, null, null, null, null, '2020-03-11', '15/3836e0545ebc46d680c8239c38b34db1.jpg');
INSERT INTO `user` VALUES ('16', 'Mr.BBB', 'dd120d6a2e527db07cd99cfea39bb3dc', 'bb', '0', null, null, null, null, null, '2020-03-11', '16/5812379f53ac468d94c393001d7ccfae.jpg');
INSERT INTO `user` VALUES ('17', '用户aaa', 'edf711bd9d51c5761afde09a856784ae', 'aaa', '0', null, null, null, null, null, '2020-03-11', null);
INSERT INTO `user` VALUES ('19', 'QQQQ', 'a6617cbcfede0c4e0f226a0f595a041a', 'qq', '0', 'aaa.com', 'JAVA', 'AAAAAAAAAAAAAAAAAAAAAAAAA', '20', '男', '2020-03-11', '8a0e939cda1c4571ac41b01c37c56cb0.png');
INSERT INTO `user` VALUES ('20', '11', '10d3e42b2d2cb7b6562375ece0a12c8a', '11', '0', null, null, null, null, null, '2020-03-11', null);
INSERT INTO `user` VALUES ('22', 'aaaaa', '3c025785a2f8af55a4969eac5e7eabc4', 'aaaa', '0', 'aaa@qq.com', 'JAVA', 'aaaaaaaaaaaaaaaa', null, null, '2020-03-19', null);
INSERT INTO `user` VALUES ('23', '1', '9f1631855f06f2d06c8cec678ad964b3', '1', '0', null, null, null, null, null, '2020-03-25', null);
INSERT INTO `user` VALUES ('24', '22', '5cd9900a542b41dff2b7a0f0b8489694', '22', '0', null, null, null, null, null, '2020-04-12', null);
INSERT INTO `user` VALUES ('25', 'tt', '25788aaaa41b95ad4784f2e665c52bc6', 'tt', '0', null, null, null, null, null, '2020-05-01', null);
INSERT INTO `user` VALUES ('26', 'ttt', 'cacdb5d28dcdd55abb4c33e4644dcd23', 'ttt', '0', null, null, null, null, null, '2020-05-03', null);
INSERT INTO `user` VALUES ('27', 'aaa', '36f2868fc3aed6b96d30e50616f27355', 'test', '0', null, null, null, null, null, '2020-05-03', '27/cc7168fb2c734f958ac1cd67f70e6d2e.jpg');
INSERT INTO `user` VALUES ('28', 'aa', '51c3de6484851d51df890a1a69431dba', 'test1', '0', null, null, null, null, null, '2020-05-03', '28/3a443aca0b7448a88ca1e9fab5332b4c.jpg');
INSERT INTO `user` VALUES ('29', 't1', '4220be481e9a87d91eea3faaceea0e21', 't1', '0', null, null, null, null, null, '2020-05-03', null);
INSERT INTO `user` VALUES ('30', 'tttt2', 'aa54c3e09932527345a24d205ec2a68e', 'tttt', '0', null, null, null, null, null, '2020-05-03', '30/734ff10590af4b5eb295fa375e21d4da.jpg');

-- ----------------------------
-- Table structure for user_role
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

-- ----------------------------
-- Table structure for vip
-- ----------------------------
DROP TABLE IF EXISTS `vip`;
CREATE TABLE `vip` (
  `v_id` int(32) NOT NULL AUTO_INCREMENT,
  `startdate` varchar(128) DEFAULT NULL,
  `longtime` bigint(20) DEFAULT NULL,
  `u_id` int(32) DEFAULT NULL,
  `grade` varchar(32) DEFAULT NULL,
  `year` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`v_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vip
-- ----------------------------
INSERT INTO `vip` VALUES ('8', '20200503', '633', '1', 'VIP', 'VIP');
INSERT INTO `vip` VALUES ('9', '20200319', '30', '19', 'VIP', 'VIP');
INSERT INTO `vip` VALUES ('10', '20200320', '60', '13', 'VIP', 'VIP');
INSERT INTO `vip` VALUES ('11', '20200321', '30', '16', 'VIP', 'VIP');
INSERT INTO `vip` VALUES ('12', '20200501', '30', '25', 'VIP', 'VIP');
INSERT INTO `vip` VALUES ('13', '20200503', '365', '20', 'VIP', '年费VIP');
INSERT INTO `vip` VALUES ('14', '20200503', '30', '26', 'VIP', 'VIP');
INSERT INTO `vip` VALUES ('15', '20200503', '395', '27', 'VIP', '年费VIP');
INSERT INTO `vip` VALUES ('16', '20200503', '60', '28', 'VIP', 'VIP');
INSERT INTO `vip` VALUES ('17', '20200503', '60', '29', 'VIP', 'VIP');
INSERT INTO `vip` VALUES ('18', '20200503', '30', '30', 'VIP', 'VIP');

-- ----------------------------
-- Table structure for vip_order
-- ----------------------------
DROP TABLE IF EXISTS `vip_order`;
CREATE TABLE `vip_order` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `order_id` varchar(256) DEFAULT NULL,
  `u_id` varchar(32) DEFAULT NULL,
  `date` varchar(128) DEFAULT NULL,
  `longtime` bigint(64) DEFAULT NULL,
  `price` double(64,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vip_order
-- ----------------------------
INSERT INTO `vip_order` VALUES ('2', '9ad8cbb5eb254d6ebf7752f0169aba48', '1', '20200211', '30', '99');
INSERT INTO `vip_order` VALUES ('3', '6923eb365df0431ead0cf3f261e1130b', '1', '20200211', '30', '30');
INSERT INTO `vip_order` VALUES ('4', 'facf4d600e9144edb9372f28b99ca084', '1', '20200311', '365', '99');
INSERT INTO `vip_order` VALUES ('5', 'c37a60b986b64498a71e42c5c6ab21f9', '1', '20200311', '365', '99');
INSERT INTO `vip_order` VALUES ('6', 'bbd7c80daa4041bcae282efd2e2a56b0', '1', '20200312', '365', '99');
INSERT INTO `vip_order` VALUES ('7', 'ffa706ea04e4491aaed6223c41c9c20b', '1', '20200313', '365', '99');
INSERT INTO `vip_order` VALUES ('8', 'f41c3ce91c9d489d934f50c0f1c39478', '1', '20200316', '30', '30');
INSERT INTO `vip_order` VALUES ('9', 'c5e2457a1e1e4f0595b67a9cee83f4f1', '1', '20200316', '365', '99');
INSERT INTO `vip_order` VALUES ('10', '480c7d9daaae4ef0847713eb8cbc4381', '1', '20200316', '30', '12');
INSERT INTO `vip_order` VALUES ('11', '4441d7a260ab4fb6a02a65512836155c', '19', '20200316', '30', '30');
INSERT INTO `vip_order` VALUES ('12', 'c25bd9b7f3fe47bdb6082af4202c6760', '1', '20200318', '365', '99');
INSERT INTO `vip_order` VALUES ('13', '9a64fc41441140998cb89c1e82eac3a7', '1', '20200319', '30', '12');
INSERT INTO `vip_order` VALUES ('14', 'a3b72edcb7154e78a72fda19800126a5', '19', '20200319', '30', '12');
INSERT INTO `vip_order` VALUES ('15', 'c5b00deda18244b09e32b88e3d83bd4f', '1', '20200319', '365', '99');
INSERT INTO `vip_order` VALUES ('16', 'be36a8faa86e40d99860d8f54a7bda03', '13', '20200320', '30', '12');
INSERT INTO `vip_order` VALUES ('17', 'a45e1e81d3364ac295cc6bc36d39e57c', '13', '20200320', '30', '12');
INSERT INTO `vip_order` VALUES ('18', 'ae57cb3c637340b48f8e96707e721918', '16', '20200321', '30', '12');
INSERT INTO `vip_order` VALUES ('19', '1868761eceb14e4d8a74401b620a5384', '25', '20200501', '30', '12');
INSERT INTO `vip_order` VALUES ('20', 'c2f74d163e9a480385d503fbb17b7c2c', '1', '20200503', '30', '12');
INSERT INTO `vip_order` VALUES ('21', 'afd645293f554e61b42b645b5f19b6d2', '20', '20200503', '365', '99');
INSERT INTO `vip_order` VALUES ('22', 'cf56c8fb6d33408d957d5ef3ba56140b', '26', '20200503', '30', '12');
INSERT INTO `vip_order` VALUES ('23', 'e574b66f588e4673bb107721dc9cdf69', '27', '20200503', '30', '12');
INSERT INTO `vip_order` VALUES ('24', '61b8cb0563574689bf0b574b281fe0a0', '27', '20200503', '365', '99');
INSERT INTO `vip_order` VALUES ('25', '385e81e606774892a26a1c1821ba4ef6', '28', '20200503', '30', '12');
INSERT INTO `vip_order` VALUES ('26', 'e449a1b64b77482bac72ce8d4159607c', '28', '20200503', '30', '12');
INSERT INTO `vip_order` VALUES ('27', 'eb5f5a22b1ea4b299128da6b538b3cc4', '29', '20200503', '30', '30');
INSERT INTO `vip_order` VALUES ('28', '71fb29a7272746d681a5b5f473bb4ba2', '29', '20200503', '30', '30');
INSERT INTO `vip_order` VALUES ('29', '3ababc9f21064cb9af6af3e73b1602ba', '30', '20200503', '30', '12');
