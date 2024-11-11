CREATE TABLE operation_log (
                               id INT AUTO_INCREMENT PRIMARY KEY,
                               operator VARCHAR(100) NOT NULL,
                               platform VARCHAR(50) NOT NULL,
                               module VARCHAR(50) NOT NULL,
                               timestamp DATETIME NOT NULL,
                               result VARCHAR(50) NOT NULL,
                               content TEXT NOT NULL
);
