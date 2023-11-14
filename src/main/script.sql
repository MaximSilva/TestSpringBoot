CREATE TABLE order_model (
                             order_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
                             price DOUBLE PRECISION,
                             quantity INTEGER,
                             item VARCHAR(255)
);

DROP TABLE order_model;

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

INSERT INTO order_model (price, quantity, item) VALUES (10.99, 3, 'Product A');

SELECT * FROM order_model WHERE item = 'Product A';

DELETE FROM order_model WHERE order_id = '238f7f24-de2c-4fe3-b219-997be02714b8';