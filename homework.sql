/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : homework

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 28/09/2021 20:47:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for administrator
-- ----------------------------
DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of administrator
-- ----------------------------
INSERT INTO `administrator` VALUES (1, 'admin', 'admin');

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `Bno` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Bname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Bauthor` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Bprice` double(5, 2) NULL DEFAULT NULL,
  `Bnum` int(0) NULL DEFAULT NULL,
  `Bshelf` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Bremark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `Bshelf`(`Bshelf`) USING BTREE,
  INDEX `Bno`(`Bno`) USING BTREE,
  CONSTRAINT `Bshelf` FOREIGN KEY (`Bshelf`) REFERENCES `bookshelf` (`no`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1, '1001', '高等数学', '同济大学', 100.50, 0, 'x101', '由同济大学数学系编写、高等教育出版社出版的“十二五”普通高等教育本科国家级规划教材');
INSERT INTO `book` VALUES (2, '1002', '线性代数', '同济大学', 124.00, 1, 'x101', '由同济大学数学系编著、高等教育出版社出版社的“十二五”普通高等教育本科国家级规划教材');
INSERT INTO `book` VALUES (4, '1003', '骆驼祥子', '老舍', 55.00, 3, 'x102', '老舍（舒庆春，1899-1966）所著的长篇小说，描述了20世纪20年代军阀混战时期人力车夫的悲惨命运');
INSERT INTO `book` VALUES (5, '1004', '都柏林人', '詹姆斯·乔伊斯', 56.00, 5, 'x102', '爱尔兰作家詹姆斯·乔伊斯久负盛名的短篇小说集，总是在最细微的日常现实中发现人生的深意');
INSERT INTO `book` VALUES (6, '1005', '卡夫卡短篇小说集', '弗兰茨·卡夫卡', 42.00, 0, 'x102', '奥地利小说家弗兰茨·卡夫卡的经典短篇小说集，揭示着生命及周围世界的真相，展现了现代人生活的虚无、荒谬和孤独');
INSERT INTO `book` VALUES (7, '1006', '莫泊桑短篇小说集', '莫泊桑', 33.00, 3, 'x102', '法国作家、“短篇小说之王”莫泊桑的短篇小说集，展现了作者对不同人物及社会现实的理解和思考');
INSERT INTO `book` VALUES (8, '1007', '梦的解析', '弗洛伊德', 56.50, 0, 'x103', '本书主要就是通过对人们梦境的分析，了解人们内心深处的潜意识和真正的想法');
INSERT INTO `book` VALUES (9, '1008', '幻想即现实', '曾奇峰', 39.00, 0, 'x103', '专门研究精神分析，本书不仅有一定的科学依据，并且文字感染力比较强，读起来风趣幽默');
INSERT INTO `book` VALUES (10, '1009', '中国哲学史', '冯友兰', 45.00, 2, 'x104', '第一部完整的具有现代意义的中国哲学史');
INSERT INTO `book` VALUES (11, '1010', '纯粹理性批判', '康德', 56.30, 2, 'x104', '康德的三大批判著作之一，改变了西方哲学前进发展的方向和进程');
INSERT INTO `book` VALUES (12, '1011', '理想国', '柏拉图', 35.50, 3, 'x104', '柏拉图已苏格拉底之口通过与他人对话设计了一个真善美统一的整体，既可以达到公正的理想国');
INSERT INTO `book` VALUES (13, '1012', '形而上学', '亚里士多德', 46.00, 0, 'x104', '叙述了亚里士多德自己的哲学体系，成为许多西方哲学家获取灵感的源泉之一');
INSERT INTO `book` VALUES (14, '1013', '人性论', '休谟', 36.00, 0, 'x104', '休谟一生中最重要的著作，对于人类思想史具有独创性的理论贡献');
INSERT INTO `book` VALUES (15, '1014', '都柏林人', '詹姆斯·乔伊斯', 56.00, 6, 'x102', '爱尔兰作家詹姆斯·乔伊斯久负盛名的短篇小说集，总是在最细微的日常现实中发现人生的深意');
INSERT INTO `book` VALUES (16, '1015', '领导力21法则', '麦克斯维尔', 74.00, 5, 'x1008', '以21条清晰的法则，有效讲透了提升领导力的方方面面，将抽象的领导力概念以具象的方式呈现');
INSERT INTO `book` VALUES (17, '1016', '从优秀到卓越', '柯林斯', 89.00, 4, 'x1008', '描绘了优秀公司实现向卓越公司跨越的宏伟蓝图');
INSERT INTO `book` VALUES (18, '1017', '有效的管理者', '彼得·德鲁克', 46.60, 8, 'x1008', '1967年出版。集中论述了一个管理者如何才能做到卓有成效');
INSERT INTO `book` VALUES (19, '1018', '竞争战略', '迈克尔·波特', 98.00, 1, 'x1008', '此书中提出了行业结构分析模型，即\"五种竞争力模型\"');
INSERT INTO `book` VALUES (20, '1019', '卓有成效的管理者', '彼得·德鲁克', 78.00, 1, 'x1008', '如何卓有成效？记录并分析时间的使用情况，把眼光集中在贡献上，充分发挥人的长处，要事优先，有效决策');

-- ----------------------------
-- Table structure for book_appointment_relation
-- ----------------------------
DROP TABLE IF EXISTS `book_appointment_relation`;
CREATE TABLE `book_appointment_relation`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `Sno` int(0) NULL DEFAULT NULL,
  `Bno` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `student_appointment_Sno`(`Sno`) USING BTREE,
  INDEX `student_appointment_Bno`(`Bno`) USING BTREE,
  CONSTRAINT `student_appointment_Bno` FOREIGN KEY (`Bno`) REFERENCES `book` (`Bno`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `student_appointment_Sno` FOREIGN KEY (`Sno`) REFERENCES `student` (`Sno`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book_appointment_relation
-- ----------------------------
INSERT INTO `book_appointment_relation` VALUES (16, 2018212534, '1013');
INSERT INTO `book_appointment_relation` VALUES (17, 2018212534, '1012');
INSERT INTO `book_appointment_relation` VALUES (19, 2018212534, '1007');
INSERT INTO `book_appointment_relation` VALUES (21, 2018212564, '1007');

-- ----------------------------
-- Table structure for bookshelf
-- ----------------------------
DROP TABLE IF EXISTS `bookshelf`;
CREATE TABLE `bookshelf`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `no` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `area` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `location` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `no`(`no`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bookshelf
-- ----------------------------
INSERT INTO `bookshelf` VALUES (1, 'x101', '100', '二楼西北角第一排', '数学专业', '数学资料');
INSERT INTO `bookshelf` VALUES (2, 'x102', '100', '二楼西北角第二排', '短篇小说', '短篇小说');
INSERT INTO `bookshelf` VALUES (3, 'x103', '121', '一楼东南角第二排', '心理学', '心理学');
INSERT INTO `bookshelf` VALUES (5, 'x104', '122', '一楼东南角第一排', '哲学理论', '哲学');
INSERT INTO `bookshelf` VALUES (6, 'x1008', '165', '三楼西北角第二排', '管理学', '管理学');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `Dno` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Dname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `Dname`(`Dname`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (1, '101', '信息科学与工程学院');
INSERT INTO `department` VALUES (2, '102', '农学院');
INSERT INTO `department` VALUES (3, '103', '机械与电子工程学院');
INSERT INTO `department` VALUES (4, '104', '外国语学院');
INSERT INTO `department` VALUES (5, '105', '经济管理学院');

-- ----------------------------
-- Table structure for major
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `Mno` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Mname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Mdept` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `Mname`(`Mname`) USING BTREE,
  INDEX `Mdept`(`Mdept`) USING BTREE,
  CONSTRAINT `Mdept` FOREIGN KEY (`Mdept`) REFERENCES `department` (`Dname`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of major
-- ----------------------------
INSERT INTO `major` VALUES (1, '1', '计算机科学与技术', '信息科学与工程学院');
INSERT INTO `major` VALUES (2, '2', '软件工程', '信息科学与工程学院');
INSERT INTO `major` VALUES (3, '3', '公共数学', '信息科学与工程学院');
INSERT INTO `major` VALUES (4, '4', '测绘科学与工程', '信息科学与工程学院');
INSERT INTO `major` VALUES (5, '5', '应用物理', '信息科学与工程学院');
INSERT INTO `major` VALUES (6, '6', '机械电子工程', '信息科学与工程学院');
INSERT INTO `major` VALUES (7, '7', '英语', '外国语学院');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `sender` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `receiver` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 67 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES (52, '2018212534', 'admin', '管理员你们好', '2020-06-29');
INSERT INTO `notice` VALUES (58, '2018212564', 'admin', '管你元你，我是李', '2020-06-29');
INSERT INTO `notice` VALUES (64, 'admin', '2018212564', '所有人都是啥B', '2020-06-29');
INSERT INTO `notice` VALUES (65, 'admin', '2018212599', '所有人都是啥B', '2020-06-29');
INSERT INTO `notice` VALUES (66, 'admin', '2018212534', '所有人都是啥B', '2020-06-29');
INSERT INTO `notice` VALUES (67, '2018212564', 'admin', '狗管理我可以晚一点还钱吗，我是计算机八班的李子鬼', '2020-06-29');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `Sno` int(0) NOT NULL,
  `Sname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Sage` int(0) NULL DEFAULT NULL,
  `Ssex` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Stel` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Smajor` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `Smajor`(`Smajor`) USING BTREE,
  INDEX `Sno`(`Sno`) USING BTREE,
  CONSTRAINT `Smajor` FOREIGN KEY (`Smajor`) REFERENCES `major` (`Mname`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (2, 2018212564, '小李子', 77, '女', '17866703601', '计算机科学与技术');
INSERT INTO `student` VALUES (3, 2018212501, '张伟', 19, '女', '17866703601', '英语');
INSERT INTO `student` VALUES (5, 2018212599, '许仙', 55, '男', '17866889933', '公共数学');
INSERT INTO `student` VALUES (6, 2018212534, '李富贵', 19, '男', '17866703622', '计算机科学与技术');

-- ----------------------------
-- Table structure for student_book_relation
-- ----------------------------
DROP TABLE IF EXISTS `student_book_relation`;
CREATE TABLE `student_book_relation`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `Sno` int(0) NULL DEFAULT NULL,
  `Bno` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `renew` tinyint(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `student_book_Sno`(`Sno`) USING BTREE,
  INDEX `student_book_Bno`(`Bno`) USING BTREE,
  CONSTRAINT `student_book_Bno` FOREIGN KEY (`Bno`) REFERENCES `book` (`Bno`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `student_book_Sno` FOREIGN KEY (`Sno`) REFERENCES `student` (`Sno`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 154 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student_book_relation
-- ----------------------------
INSERT INTO `student_book_relation` VALUES (140, 2018212534, '1001', '2020-06-29', 0);
INSERT INTO `student_book_relation` VALUES (148, 2018212564, '1001', '2020-06-30', 0);
INSERT INTO `student_book_relation` VALUES (149, 2018212564, '1003', '2020-06-30', 0);
INSERT INTO `student_book_relation` VALUES (150, 2018212564, '1004', '2020-06-30', 0);
INSERT INTO `student_book_relation` VALUES (151, 2018212564, '1006', '2020-06-30', 0);
INSERT INTO `student_book_relation` VALUES (152, 2018212564, '1011', '2020-06-30', 0);
INSERT INTO `student_book_relation` VALUES (153, 2018212564, '1017', '2020-06-30', 1);
INSERT INTO `student_book_relation` VALUES (154, 2018212564, '1018', '2020-06-30', 0);

-- ----------------------------
-- Table structure for student_borrow_relation
-- ----------------------------
DROP TABLE IF EXISTS `student_borrow_relation`;
CREATE TABLE `student_borrow_relation`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `Sno` int(0) NULL DEFAULT NULL,
  `num` int(0) NULL DEFAULT NULL,
  `state` tinyint(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `student_borrow_relation`(`Sno`) USING BTREE,
  CONSTRAINT `student_borrow_relation` FOREIGN KEY (`Sno`) REFERENCES `student` (`Sno`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student_borrow_relation
-- ----------------------------
INSERT INTO `student_borrow_relation` VALUES (1, 2018212564, 7, 1);
INSERT INTO `student_borrow_relation` VALUES (3, 2018212534, 1, 1);
INSERT INTO `student_borrow_relation` VALUES (4, 2018212599, 0, 1);

-- ----------------------------
-- Table structure for student_fine_relation
-- ----------------------------
DROP TABLE IF EXISTS `student_fine_relation`;
CREATE TABLE `student_fine_relation`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `Sno` int(0) NULL DEFAULT NULL,
  `money` double(5, 1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `student_fine_Sno`(`Sno`) USING BTREE,
  CONSTRAINT `student_fine_Sno` FOREIGN KEY (`Sno`) REFERENCES `student` (`Sno`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student_fine_relation
-- ----------------------------
INSERT INTO `student_fine_relation` VALUES (2, 2018212564, 99.0);
INSERT INTO `student_fine_relation` VALUES (3, 2018212534, 0.0);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `Sno` int(0) NULL DEFAULT NULL,
  `username` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `Sno`(`Sno`) USING BTREE,
  CONSTRAINT `Sno` FOREIGN KEY (`Sno`) REFERENCES `student` (`Sno`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (2, 2018212564, 'ghost', 'ghost');
INSERT INTO `user` VALUES (6, 2018212534, 'rich', '123456');
INSERT INTO `user` VALUES (7, 2018212599, 'xiao', '123456');

SET FOREIGN_KEY_CHECKS = 1;
