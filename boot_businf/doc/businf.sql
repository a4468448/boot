/*
Navicat MySQL Data Transfer

Source Server         : localhost_mysql
Source Server Version : 50505
Source Host           : 127.0.0.1:3307
Source Database       : demo

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2017-07-11 09:25:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for girl
-- ----------------------------
DROP TABLE IF EXISTS `girl`;
CREATE TABLE `girl` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cupSize` varchar(20) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of girl
-- ----------------------------
INSERT INTO `girl` VALUES ('1', '11', '17', '11');
INSERT INTO `girl` VALUES ('2', '22', '33', '22');

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL COMMENT '用户名-暂不用',
  `operation` varchar(50) DEFAULT NULL COMMENT '用户操作',
  `method` varchar(200) DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) DEFAULT NULL COMMENT '请求参数',
  `ip` varchar(64) DEFAULT NULL COMMENT 'IP地址',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='系统日志';

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES ('10', null, '查询girl', 'com.bus.inf.controller.GirlController.query()', '1', '0:0:0:0:0:0:0:1', '2017-07-11 09:20:41');
INSERT INTO `sys_log` VALUES ('11', null, '查询girl', 'com.bus.inf.controller.GirlController.query()', '1', '0:0:0:0:0:0:0:1', '2017-07-11 09:21:44');
INSERT INTO `sys_log` VALUES ('12', null, '查询girl', 'com.bus.inf.controller.GirlController.query()', '1', '0:0:0:0:0:0:0:1', '2017-07-11 09:22:31');
