-- db-schema.sql
--CREATE TABLE price (
                       -- id INT AUTO_INCREMENT PRIMARY KEY,
                       -- brand_id INT,
                       -- start_date DATE,
                      --  end_date DATE,
                      --  price_list INT,
                     --   product_id INT,
                   --     priority INT,
                 --       price DECIMAL(10, 2),
        --                curr VARCHAR(3)
--);
CREATE TABLE price (
                       PRICE_ID INT AUTO_INCREMENT PRIMARY KEY,
                       BRAND_ID INT NOT NULL,
                       START_DATE DATETIME NOT NULL,
                       END_DATE DATETIME NOT NULL,
                       PRICE_LIST INT NOT NULL,
                       PRODUCT_ID INT NOT NULL,
                       PRIORITY INT NOT NULL,
                       PRICE DECIMAL(10, 2) NOT NULL,
                       CURR VARCHAR(3) NOT NULL
);
commit;
