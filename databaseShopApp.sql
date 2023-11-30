Use shopapp;

-- khách hàng muốn mua hàng -> đăng ký tài khoản -> users

CREATE TABLE users(
	id varchar(100) PRIMARY KEY not null,
    fullname VARCHAR(100) DEFAULT '',
    phone_number VARCHAR(10) NOT NULL,
    address VARCHAR(200) DEFAULT '',
    password VARCHAR(100) NOT NULL, -- mật khẩu đã mã hóa
    created_at DATETIME,
    updated_at DATETIME,
    is_active TINYINT(1) DEFAULT 1,
    date_of_birth DATE,
    facebook_account_id INT DEFAULT 0,
    google_account_id INT DEFAULT 0
);

create table tokens(
	id varchar(100) PRIMARY KEY not null,
    token VARCHAR(255) UNIQUE NOT NULL,
    token_type VARCHAR(50) NOT NULL,
    expiration_date DATETIME,
    revoked TINYINT NOT NULL,
    expired TINYINT NOT NULL,
    user_id varchar(100),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- hổ trợ đăng nhập facebook và google

create table social_accounts(
  id varchar(100) PRIMARY KEY not null,
  provider varchar(20) COLLATE utf8mb4_general_ci NOT NULL COMMENT 'Tên nhà social network',
  provider_id varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  email varchar(150) COLLATE utf8mb4_general_ci NOT NULL COMMENT 'Email tài khoản',
  name varchar(100) COLLATE utf8mb4_general_ci NOT NULL COMMENT 'Tên người dùng',
  user_id varchar(100) DEFAULT NULL,
  FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE categories (
  id varchar(100) PRIMARY KEY not null,
  name varchar(100) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT 'Tên danh mục, vd: đồ điện tử'
);

CREATE TABLE products (
  id varchar(100) PRIMARY KEY not null,
  name varchar(350) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'Tên sản phẩm',
  price float NOT NULL CHECK (price >= 0),
  thumbnail varchar(300) COLLATE utf8mb4_general_ci DEFAULT '',
  description longtext COLLATE utf8mb4_general_ci,
  created_at datetime DEFAULT NULL,
  updated_at datetime DEFAULT NULL,
  category_id varchar(100) DEFAULT NULL,
  FOREIGN KEY (category_id) REFERENCES categories(id)
);

alter table users add column role_id varchar(100) ;
CREATE TABLE roles (
  id varchar(100) PRIMARY KEY not null,
  name varchar(20) COLLATE utf8mb4_general_ci NOT NULL
);

alter table users add foreign key (role_id) REFERENCES roles(id);

CREATE TABLE orders (
  id varchar(100) PRIMARY KEY not null,
  user_id varchar(100) DEFAULT NULL,
  fullname varchar(100) COLLATE utf8mb4_general_ci DEFAULT '',
  email varchar(100) COLLATE utf8mb4_general_ci DEFAULT '',
  phone_number varchar(20) COLLATE utf8mb4_general_ci NOT NULL,
  address varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
  note varchar(100) COLLATE utf8mb4_general_ci DEFAULT '',
  order_date datetime DEFAULT CURRENT_TIMESTAMP,
  status enum('pending','processing','shipped','delivered','cancelled') COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'Trạng thái đơn hàng',
  total_money float DEFAULT NULL CHECK (total_money >=0),
  shipping_method varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  shipping_address varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL,
  shipping_date date DEFAULT NULL,
  tracking_number varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  payment_method varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  active tinyint(1) DEFAULT NULL
) ;

CREATE TABLE order_details (
  id varchar(100) PRIMARY KEY NOT NULL,
  order_id varchar(100) DEFAULT NULL,
  foreign key (order_id) references orders(id),
  product_id varchar(100) DEFAULT NULL,
  foreign key (product_id) references products(id),
  price float DEFAULT NULL check (price >= 0),
  number_of_products int DEFAULT NULL check (number_of_products>0),
  total_money float DEFAULT NULL check (total_money>=0),
  color varchar(20) COLLATE utf8mb4_general_ci DEFAULT ''
) ;
