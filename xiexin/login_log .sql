CREATE TABLE login_log (
                           user_id INT NOT NULL,               -- user_id 用于和user表关联
                           username VARCHAR(50) NOT NULL,      -- 用户名
                           ip VARCHAR(45) NOT NULL,            -- 登录IP
                           timestamp DATETIME NOT NULL,        -- 登录时间
                           status VARCHAR(10) NOT NULL,        -- 登录状态
                           address VARCHAR(255),               -- 用户地址，直接保存汉字地址
                           PRIMARY KEY (user_id)               -- user_id作为主键
);
