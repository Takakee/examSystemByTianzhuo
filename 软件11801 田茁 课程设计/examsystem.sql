/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1_3306
Source Server Version : 80017
Source Host           : 127.0.0.1:3306
Source Database       : examsystem

Target Server Type    : MYSQL
Target Server Version : 80017
File Encoding         : 65001

Date: 2020-06-19 18:18:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `id` int(11) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `answer` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES ('1', '中国最长的河流是什么河流？ A.亚马逊河 B.扬子江 C.黑龙江 D.长江', 'D');
INSERT INTO `question` VALUES ('2', '下列哪一项不是四大名著？ A.红楼梦 B.西游记 C.数据结构 D.三国演义', 'C');
INSERT INTO `question` VALUES ('3', '湖北的省会城市是什么？ A.黄陂 B.武汉 C.襄阳 D.孝感', 'B');
INSERT INTO `question` VALUES ('4', '海南一年四季都是寒冷的？ A.对 B.错', 'B');
INSERT INTO `question` VALUES ('5', '热干面是武汉的特产吗？ A.对 B.错', 'A');
INSERT INTO `question` VALUES ('6', '中国有多少个民族？ A.30 B.24 C.56 D.66', 'C');
INSERT INTO `question` VALUES ('7', '中国哪个民族人数最多？ A.高山族 B.水族 C.维吾尔族 D.汉族', 'D');
INSERT INTO `question` VALUES ('8', '哪个民族高考不能享受少数民族加分？ A.水族 B.维吾尔族 C.汉族 D.高山族', 'C');
INSERT INTO `question` VALUES ('9', '中国男性法定结婚年龄为多少岁？ A.22 B.16 C.18 D.25', 'A');
INSERT INTO `question` VALUES ('10', '中国女性法定结婚年龄为多少岁？ A.22 B.20 C.56 D.55', 'B');
INSERT INTO `question` VALUES ('11', '中国初次拿驾照多久实习期？ A.10个月 B.5个月 C.3个月 D.12个月', 'D');
INSERT INTO `question` VALUES ('12', '修改第12题内容', 'B');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `stuName` varchar(255) NOT NULL,
  `score` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`stuName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('周瑜', '92');
INSERT INTO `student` VALUES ('张三', '66');
INSERT INTO `student` VALUES ('王五', '70');
INSERT INTO `student` VALUES ('诸葛亮', '90');
INSERT INTO `student` VALUES ('韩信', '100');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `teacherName` varchar(255) NOT NULL,
  `numberOfquestion` int(11) NOT NULL,
  PRIMARY KEY (`teacherName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('田茁', '2');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('张三', 'abc', 'student');
INSERT INTO `user` VALUES ('田茁', '123', 'teacher');
INSERT INTO `user` VALUES ('韩信', 'abc', 'student');
