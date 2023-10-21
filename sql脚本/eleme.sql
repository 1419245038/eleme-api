/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80100 (8.1.0)
 Source Host           : localhost:3306
 Source Schema         : eleme

 Target Server Type    : MySQL
 Target Server Version : 80100 (8.1.0)
 File Encoding         : 65001

 Date: 21/10/2023 20:19:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for business
-- ----------------------------
DROP TABLE IF EXISTS `business`;
CREATE TABLE `business` (
  `business_id` bigint NOT NULL AUTO_INCREMENT COMMENT '商家编号',
  `business_name` varchar(40) DEFAULT NULL COMMENT '商家名称',
  `business_logo` varchar(128) DEFAULT NULL COMMENT '商家Logo图',
  `business_address` varchar(40) DEFAULT NULL COMMENT '商家地址',
  `business_delivery_price` decimal(10,2) DEFAULT NULL COMMENT '配送费',
  `business_start_price` decimal(10,2) DEFAULT NULL COMMENT '起送费',
  `business_desc` varchar(40) DEFAULT NULL COMMENT '商家描述(经营范围)',
  `business_type` varchar(255) DEFAULT NULL COMMENT '商家类型',
  PRIMARY KEY (`business_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of business
-- ----------------------------
BEGIN;
INSERT INTO `business` (`business_id`, `business_name`, `business_logo`, `business_address`, `business_delivery_price`, `business_start_price`, `business_desc`, `business_type`) VALUES (1, '万家饺子', 'business/jiaozi.jpg', '软件园E18店', 3.00, 15.00, '各种饺子炒菜', '美食');
INSERT INTO `business` (`business_id`, `business_name`, `business_logo`, `business_address`, `business_delivery_price`, `business_start_price`, `business_desc`, `business_type`) VALUES (2, '卤肉饭.广东肠粉', 'business/luroufan.jpg', '芳霖园店', 0.50, 10.00, '特色美食', '美食');
INSERT INTO `business` (`business_id`, `business_name`, `business_logo`, `business_address`, `business_delivery_price`, `business_start_price`, `business_desc`, `business_type`) VALUES (3, '申记串道', 'business/shengjichuandao.jpg', '中海康城店', 3.00, 15.00, '烤串炸串', '美食');
INSERT INTO `business` (`business_id`, `business_name`, `business_logo`, `business_address`, `business_delivery_price`, `business_start_price`, `business_desc`, `business_type`) VALUES (4, '正宗安徽牛肉板面', 'business/banmian.jpg', '北区店', 0.50, 7.00, '特色美食', '美食');
INSERT INTO `business` (`business_id`, `business_name`, `business_logo`, `business_address`, `business_delivery_price`, `business_start_price`, `business_desc`, `business_type`) VALUES (5, '暴脾气功夫鸡排', 'business/gongfujipai.jpg', '沈师北区店', 0.50, 10.00, '炸鸡快餐', '美食');
COMMIT;

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `cart_id` bigint NOT NULL AUTO_INCREMENT COMMENT '购物车编号',
  `business_id` bigint NOT NULL COMMENT '商家编号',
  `food_id` bigint NOT NULL COMMENT '食品编号',
  `user_id` bigint NOT NULL COMMENT '用户编号',
  `food_num` int DEFAULT NULL COMMENT '用户选购食品数量',
  `date` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`cart_id`) USING BTREE,
  KEY `food_id` (`food_id`),
  KEY `user_id` (`user_id`),
  KEY `business_id` (`business_id`),
  CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`food_id`) REFERENCES `food` (`food_id`),
  CONSTRAINT `cart_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `cart_ibfk_3` FOREIGN KEY (`business_id`) REFERENCES `business` (`business_id`)
) ENGINE=InnoDB AUTO_INCREMENT=262 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of cart
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for deliveryaddress
-- ----------------------------
DROP TABLE IF EXISTS `deliveryaddress`;
CREATE TABLE `deliveryaddress` (
  `deliveryaddress_id` bigint NOT NULL AUTO_INCREMENT COMMENT '送货地址编号',
  `contacts_name` varchar(40) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '联系人姓名',
  `contacts_phone_num` varchar(11) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '联系人电话号码',
  `deliveryaddress` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '送货地址',
  `user_id` bigint NOT NULL COMMENT '送货地址所属用户编号',
  `commonly_used` int NOT NULL DEFAULT '0' COMMENT '常用地址标识1-常用，0-备选',
  `contacts_sex` int DEFAULT NULL COMMENT '联系人性别',
  PRIMARY KEY (`deliveryaddress_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `deliveryaddress_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of deliveryaddress
-- ----------------------------
BEGIN;
INSERT INTO `deliveryaddress` (`deliveryaddress_id`, `contacts_name`, `contacts_phone_num`, `deliveryaddress`, `user_id`, `commonly_used`, `contacts_sex`) VALUES (47, '年少无为不自卑', '13888888888', '辽宁省沈阳市沈北新区', 17, 1, 0);
COMMIT;

-- ----------------------------
-- Table structure for food
-- ----------------------------
DROP TABLE IF EXISTS `food`;
CREATE TABLE `food` (
  `food_id` bigint NOT NULL AUTO_INCREMENT COMMENT '食品编号',
  `food_name` varchar(40) DEFAULT NULL COMMENT '食品名称',
  `food_pic` varchar(128) DEFAULT NULL COMMENT '食品图片',
  `food_type` varchar(40) DEFAULT NULL COMMENT '食品类别',
  `food_price` decimal(10,2) DEFAULT NULL COMMENT '食品价格',
  `food_desc` varchar(40) DEFAULT NULL COMMENT '食品描述',
  `business_id` bigint DEFAULT NULL COMMENT '食品所属商家编号',
  PRIMARY KEY (`food_id`),
  KEY `business_id` (`business_id`),
  CONSTRAINT `food_ibfk_1` FOREIGN KEY (`business_id`) REFERENCES `business` (`business_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of food
-- ----------------------------
BEGIN;
INSERT INTO `food` (`food_id`, `food_name`, `food_pic`, `food_type`, `food_price`, `food_desc`, `business_id`) VALUES (1, '纯肉鲜肉', 'jiaozi/jiaozi1.jpg', '水饺', 15.00, '新鲜猪肉', 1);
INSERT INTO `food` (`food_id`, `food_name`, `food_pic`, `food_type`, `food_price`, `food_desc`, `business_id`) VALUES (2, '玉米鲜肉', 'jiaozi/jiaozi2.jpg', '水饺', 16.00, '新鲜玉米', 1);
INSERT INTO `food` (`food_id`, `food_name`, `food_pic`, `food_type`, `food_price`, `food_desc`, `business_id`) VALUES (3, '素三鲜', 'jiaozi/jiaozi3.jpg', '蒸饺', 14.00, '素三鲜', 1);
INSERT INTO `food` (`food_id`, `food_name`, `food_pic`, `food_type`, `food_price`, `food_desc`, `business_id`) VALUES (4, '肉沫肠粉', 'changfen/changfen2.jpg', '肠粉', 11.98, '鸡蛋+生菜+肉沫+米浆', 2);
INSERT INTO `food` (`food_id`, `food_name`, `food_pic`, `food_type`, `food_price`, `food_desc`, `business_id`) VALUES (5, '鲜虾肠粉', 'changfen/changfen1.jpg', '肠粉', 13.95, '米粉、生菜、鸡蛋、虾仁', 2);
INSERT INTO `food` (`food_id`, `food_name`, `food_pic`, `food_type`, `food_price`, `food_desc`, `business_id`) VALUES (6, '腊汁卤肉饭', 'changfen/changfen3.jpg', '卤肉饭', 14.96, '原料五花肉，卤煮一小时以上', 2);
INSERT INTO `food` (`food_id`, `food_name`, `food_pic`, `food_type`, `food_price`, `food_desc`, `business_id`) VALUES (7, '牛肉串', 'chuan/chuan2.jpg', '烤串', 3.50, '牛肉', 3);
INSERT INTO `food` (`food_id`, `food_name`, `food_pic`, `food_type`, `food_price`, `food_desc`, `business_id`) VALUES (8, '烤熟筋', 'chuan/chuan5.jpg', '烤串', 3.50, '熟筋', 3);
INSERT INTO `food` (`food_id`, `food_name`, `food_pic`, `food_type`, `food_price`, `food_desc`, `business_id`) VALUES (9, '烤板筋', 'chuan/chuan3.jpg', '烤串', 3.50, '板筋', 3);
INSERT INTO `food` (`food_id`, `food_name`, `food_pic`, `food_type`, `food_price`, `food_desc`, `business_id`) VALUES (10, '风干肠', 'chuan/chuan4.jpg', '烤串', 3.50, '风干肠', 3);
INSERT INTO `food` (`food_id`, `food_name`, `food_pic`, `food_type`, `food_price`, `food_desc`, `business_id`) VALUES (11, '烤蝉蛹', 'chuan/chuan1.jpg', '烤串', 3.50, '蚕蛹', 3);
INSERT INTO `food` (`food_id`, `food_name`, `food_pic`, `food_type`, `food_price`, `food_desc`, `business_id`) VALUES (12, '牛肉面', 'banmina/banmian1.jpg', '汤面', 11.50, '牛肉', 4);
INSERT INTO `food` (`food_id`, `food_name`, `food_pic`, `food_type`, `food_price`, `food_desc`, `business_id`) VALUES (13, '竹笋鸡丝拌面', 'banmina/banmian2.jpg', '拌面', 10.50, '竹笋、鸡丝', 4);
INSERT INTO `food` (`food_id`, `food_name`, `food_pic`, `food_type`, `food_price`, `food_desc`, `business_id`) VALUES (14, '牛肉拌面', 'banmina/banmian4.jpg', '拌面', 11.50, '牛肉', 4);
INSERT INTO `food` (`food_id`, `food_name`, `food_pic`, `food_type`, `food_price`, `food_desc`, `business_id`) VALUES (15, '早餐面', 'banmina/banmian3.jpg', '汤面', 5.00, '青菜、面条', 4);
INSERT INTO `food` (`food_id`, `food_name`, `food_pic`, `food_type`, `food_price`, `food_desc`, `business_id`) VALUES (16, '甘梅味功夫鸡排', 'jipai/jipai1.jpg', '鸡排', 10.00, '鸡肉', 5);
INSERT INTO `food` (`food_id`, `food_name`, `food_pic`, `food_type`, `food_price`, `food_desc`, `business_id`) VALUES (17, '孜然鸡排', 'jipai/jipai3.jpg', '鸡排', 10.00, '鸡肉', 5);
INSERT INTO `food` (`food_id`, `food_name`, `food_pic`, `food_type`, `food_price`, `food_desc`, `business_id`) VALUES (18, '乐滋韩式炸鸡', 'jipai/jipai2.jpg', '炸鸡', 12.90, '鸡肉', 5);
INSERT INTO `food` (`food_id`, `food_name`, `food_pic`, `food_type`, `food_price`, `food_desc`, `business_id`) VALUES (19, '鸡腿堡+薯条+可乐', 'jipai/jipai4.jpg', '汉堡套餐', 16.00, '鸡肉', 5);
COMMIT;

-- ----------------------------
-- Table structure for orderdetail
-- ----------------------------
DROP TABLE IF EXISTS `orderdetail`;
CREATE TABLE `orderdetail` (
  `orderdetail_id` bigint NOT NULL AUTO_INCREMENT COMMENT '详细订单编号',
  `order_id` bigint NOT NULL COMMENT '详细订单所属的基本订单编号',
  `food_id` bigint NOT NULL COMMENT '食品编号',
  `food_name` varchar(40) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '食品名称',
  `food_type` varchar(40) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '食品类型',
  `food_total_price` decimal(10,2) NOT NULL COMMENT '食品价格',
  `food_num` int NOT NULL COMMENT '食品数量',
  PRIMARY KEY (`orderdetail_id`) USING BTREE,
  KEY `order_id` (`order_id`),
  KEY `food_id` (`food_id`),
  CONSTRAINT `orderdetail_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`),
  CONSTRAINT `orderdetail_ibfk_2` FOREIGN KEY (`food_id`) REFERENCES `food` (`food_id`)
) ENGINE=InnoDB AUTO_INCREMENT=132 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of orderdetail
-- ----------------------------
BEGIN;
INSERT INTO `orderdetail` (`orderdetail_id`, `order_id`, `food_id`, `food_name`, `food_type`, `food_total_price`, `food_num`) VALUES (121, 62, 8, '烤熟筋', '烤串', 3.50, 1);
INSERT INTO `orderdetail` (`orderdetail_id`, `order_id`, `food_id`, `food_name`, `food_type`, `food_total_price`, `food_num`) VALUES (122, 62, 7, '牛肉串', '烤串', 3.50, 1);
INSERT INTO `orderdetail` (`orderdetail_id`, `order_id`, `food_id`, `food_name`, `food_type`, `food_total_price`, `food_num`) VALUES (123, 62, 9, '烤板筋', '烤串', 7.00, 2);
INSERT INTO `orderdetail` (`orderdetail_id`, `order_id`, `food_id`, `food_name`, `food_type`, `food_total_price`, `food_num`) VALUES (124, 62, 10, '风干肠', '烤串', 3.50, 1);
INSERT INTO `orderdetail` (`orderdetail_id`, `order_id`, `food_id`, `food_name`, `food_type`, `food_total_price`, `food_num`) VALUES (125, 63, 13, '竹笋鸡丝拌面', '拌面', 10.50, 1);
INSERT INTO `orderdetail` (`orderdetail_id`, `order_id`, `food_id`, `food_name`, `food_type`, `food_total_price`, `food_num`) VALUES (126, 63, 12, '牛肉面', '汤面', 11.50, 1);
INSERT INTO `orderdetail` (`orderdetail_id`, `order_id`, `food_id`, `food_name`, `food_type`, `food_total_price`, `food_num`) VALUES (127, 63, 14, '牛肉拌面', '拌面', 11.50, 1);
INSERT INTO `orderdetail` (`orderdetail_id`, `order_id`, `food_id`, `food_name`, `food_type`, `food_total_price`, `food_num`) VALUES (128, 64, 2, '玉米鲜肉', '水饺', 16.00, 1);
INSERT INTO `orderdetail` (`orderdetail_id`, `order_id`, `food_id`, `food_name`, `food_type`, `food_total_price`, `food_num`) VALUES (129, 64, 1, '纯肉鲜肉', '水饺', 30.00, 2);
INSERT INTO `orderdetail` (`orderdetail_id`, `order_id`, `food_id`, `food_name`, `food_type`, `food_total_price`, `food_num`) VALUES (130, 64, 1, '纯肉鲜肉', '水饺', 30.00, 2);
INSERT INTO `orderdetail` (`orderdetail_id`, `order_id`, `food_id`, `food_name`, `food_type`, `food_total_price`, `food_num`) VALUES (131, 64, 2, '玉米鲜肉', '水饺', 16.00, 1);
COMMIT;

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `order_id` bigint NOT NULL AUTO_INCREMENT COMMENT '订单编号',
  `user_id` bigint NOT NULL COMMENT '订单所属用户编号',
  `business_id` bigint NOT NULL COMMENT '订单所属商家编号',
  `deliveryaddress_id` bigint NOT NULL COMMENT '订单所属送货地址编号',
  `order_total_price` decimal(10,2) NOT NULL COMMENT '订单总价',
  `delivery_price` decimal(10,2) NOT NULL COMMENT '配送费',
  `order_stats` int NOT NULL COMMENT '详细订单状态：0-未支付，1-已支付',
  `date` datetime NOT NULL COMMENT '创建日期',
  PRIMARY KEY (`order_id`) USING BTREE,
  KEY `user_id` (`user_id`),
  KEY `deliveryaddress_id` (`deliveryaddress_id`),
  KEY `business_id` (`business_id`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`deliveryaddress_id`) REFERENCES `deliveryaddress` (`deliveryaddress_id`),
  CONSTRAINT `orders_ibfk_3` FOREIGN KEY (`business_id`) REFERENCES `business` (`business_id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of orders
-- ----------------------------
BEGIN;
INSERT INTO `orders` (`order_id`, `user_id`, `business_id`, `deliveryaddress_id`, `order_total_price`, `delivery_price`, `order_stats`, `date`) VALUES (62, 17, 3, 47, 20.50, 3.00, 1, '2022-04-30 01:34:26');
INSERT INTO `orders` (`order_id`, `user_id`, `business_id`, `deliveryaddress_id`, `order_total_price`, `delivery_price`, `order_stats`, `date`) VALUES (63, 17, 4, 47, 34.00, 0.50, 1, '2022-04-30 01:37:37');
INSERT INTO `orders` (`order_id`, `user_id`, `business_id`, `deliveryaddress_id`, `order_total_price`, `delivery_price`, `order_stats`, `date`) VALUES (64, 17, 1, 47, 49.00, 3.00, 0, '2023-10-21 12:16:01');
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `username` varchar(40) NOT NULL COMMENT '用户名',
  `password` varchar(40) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '密码',
  `user_header_pic` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '用户头像',
  `sex` int DEFAULT '0' COMMENT '用户性别：0-男，1-女',
  `date` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` (`user_id`, `username`, `password`, `user_header_pic`, `sex`, `date`) VALUES (17, '13888888888', 'test123', 'head_pic.jpg', 0, '2022-04-30 01:28:32');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
