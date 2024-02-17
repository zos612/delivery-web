-- DROP TABLE account IF EXISTS;
DROP TABLE users IF EXISTS;
DROP TABLE stores IF EXISTS;
DROP TABLE menus IF EXISTS;
DROP TABLE orders IF EXISTS;
DROP TABLE reviews IF EXISTS;
DROP TABLE comments IF EXISTS;
DROP TABLE likes IF EXISTS;


CREATE TABLE users (
                       id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       phone_number VARCHAR(20) NOT NULL,
                       email VARCHAR(255) NOT NULL UNIQUE,
                       address VARCHAR(255) NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       fcm_token VARCHAR(255),
                       grade INT,
                       profile_image VARCHAR(255)
);


CREATE TABLE stores (
                        id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
                        name VARCHAR(255) NOT NULL,
                        category VARCHAR(255) NOT NULL,
                        location VARCHAR(255) NOT NULL,
                        business_hours VARCHAR(255) NOT NULL,
                        day_off VARCHAR(255) NOT NULL,
                        delivery_fee INT NOT NULL,
                        minimum_order_amount INT NOT NULL,
                        average_rating DECIMAL(2,1)
--                         review_count INT NOT NULL,
--                         main_menu VARCHAR(255) NOT NULL,
--                         logo_image VARCHAR(255)
);

CREATE TABLE menus (
                       id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
                       store_id INT NOT NULL,
                       name VARCHAR(255) NOT NULL,
                       price INT NOT NULL,
                       description VARCHAR(255),
                       options VARCHAR(255),
                       image VARCHAR(255),
                       FOREIGN KEY (store_id) REFERENCES stores(id)
);


CREATE TABLE orders (
                        id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
                        user_id INT NOT NULL,
                        store_id INT NOT NULL,
                        ordered_menus VARCHAR(255) NOT NULL,
                        order_time TIMESTAMP NOT NULL,
                        order_status VARCHAR(255) NOT NULL,
                        payment_method VARCHAR(255) NOT NULL,
                        payment_amount INT NOT NULL,
                        delivery_address VARCHAR(255) NOT NULL,
                        delivery_request_time TIMESTAMP,
                        delivery_completed_time TIMESTAMP,
                        FOREIGN KEY (user_id) REFERENCES users(id),
                        FOREIGN KEY (store_id) REFERENCES stores(id)
);

CREATE TABLE reviews (
                         id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
                         user_id INT NOT NULL,
                         store_id INT NOT NULL,
                         rating INT NOT NULL,
                         content VARCHAR(255) NOT NULL,
                         images VARCHAR(255),
                         created_at TIMESTAMP NOT NULL,
                         FOREIGN KEY (user_id) REFERENCES users(id),
                         FOREIGN KEY (store_id) REFERENCES stores(id)
);

CREATE TABLE comments (
                          id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
                          review_id INT NOT NULL,
                          user_id INT NOT NULL,
                          content VARCHAR(255) NOT NULL,
                          created_at TIMESTAMP NOT NULL,
                          FOREIGN KEY (review_id) REFERENCES reviews(id),
                          FOREIGN KEY (user_id) REFERENCES users(id)
);


CREATE TABLE likes (
                       id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
                       review_id INT NOT NULL,
                       user_id INT NOT NULL,
                       FOREIGN KEY (review_id) REFERENCES reviews(id),
                       FOREIGN KEY (user_id) REFERENCES users(id)
);
