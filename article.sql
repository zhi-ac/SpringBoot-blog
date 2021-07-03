/*
Navicat MySQL Data Transfer

Source Server         : laochou
Source Server Version : 80015
Source Host           : localhost:3306
Source Database       : markdown

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2020-11-25 19:28:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `author` varchar(255) NOT NULL,
  `content` longtext NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', '双非如何拿到阿里，腾讯的Offer', 'Laochou', '#Hello\r\n![](/upload/4a31b9c2-a817-4804-9bef-4f137e218316.jpg)');
INSERT INTO `article` VALUES ('2', '双非如何拿到阿里，腾讯的Offer', 'Laochou', '>个人背景\r\n\r\n名字：Laochou（2021届毕业生）  \r\n学历：一本院校，二本专业（软件工程）  \r\n大学之前是否有编程经验：可算有，也可算无。因为是开学前15天开始学习C语言  \r\n主修编程语言：Java  \r\n秋招成绩：阿里、腾讯、58、Shopee、吉比特等Offer \r\n求职岗位：Java研发工程师、后端研发工程师（Go语言也可）\r\n\r\n>鄙人学习方法\r\n​\r\n在互联网行业，我认为学习方法就是<font color=\"red\">持之以恒</font>，量变而引起质变。很多知识点，如果不通过实操来理解的，只会停留在表面，这种“你懂了”的假象会在你实际使用的时候体现出来。我在大一阶段的代码量应该就达到了<font color=\"red\">几万行</font>吧。  \r\n​\r\n鄙人的学习方法就用一下几点来表达吧。  \r\n1. 学以致用 \r\n2. 温故而知新  \r\n3. 举一反三  \r\n4. 触类旁通  \r\n5. 目前实在解决不了的问题，就交给时间来解决  ');
