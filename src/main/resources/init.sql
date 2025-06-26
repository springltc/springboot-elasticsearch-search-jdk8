CREATE TABLE `product` (
                           `id` BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '商品ID',
                           `name` VARCHAR(255) NOT NULL COMMENT '商品名称',
                           `brand` VARCHAR(100) COMMENT '品牌',
                           `category` VARCHAR(100) COMMENT '分类',
                           `price` DOUBLE NOT NULL COMMENT '价格',
                           `stock` INT DEFAULT 0 COMMENT '库存',
                           `description` TEXT COMMENT '描述'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品信息表';


INSERT INTO `product` (`name`, `brand`, `category`, `price`, `stock`, `description`) VALUES
                                                                                         ('iPhone 15 Pro', 'Apple', '手机', 8999.00, 100, '最新一代苹果手机'),
                                                                                         ('小米14', 'Xiaomi', '手机', 4299.00, 200, '轻薄强悍的旗舰手机'),
                                                                                         ('ThinkPad X1 Carbon', 'Lenovo', '笔记本电脑', 12999.00, 50, '商用高端笔记本电脑'),
                                                                                         ('MacBook Air M2', 'Apple', '笔记本电脑', 8999.00, 30, '苹果轻薄本'),
                                                                                         ('华为 MatePad 11', 'Huawei', '平板电脑', 2699.00, 150, '适合办公娱乐的平板'),
                                                                                         ('三星 Galaxy Tab S9', 'Samsung', '平板电脑', 5999.00, 80, '高端安卓平板');


