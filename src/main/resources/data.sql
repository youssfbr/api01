INSERT INTO TB_PRODUCT (name, price, moment, active) VALUES ('MacBook', 8000.0, NOW(), true);

INSERT INTO tb_client (name, phone, birth_date, email, cpf_or_cnpj, note, moment, active) VALUES ('Alisson Youssf', '(99)9.9999.9999', '1977-04-20', 'youssfbr@gmail.com', '999.999.999-99', 'A good person.', now(), 1);

INSERT INTO TB_PHONE (phone_type, ddd, number) VALUES (0, '85', '9.8705.9184');
INSERT INTO TB_PHONE (phone_type, ddd, number) VALUES (1, '85', '9.8705.9999');
INSERT INTO tb_client_phones VALUES (1, 1);
INSERT INTO tb_client_phones VALUES (1, 2);

INSERT INTO tb_brand (name, moment) VALUES ('Dell', now());
INSERT INTO tb_brand (name, moment) VALUES ('Samsung', now());
INSERT INTO tb_brand (name, moment) VALUES ('Lenovo', now());

INSERT INTO tb_device (device_type, moment, brand_id, model, client_id) VALUES (0, now(), 1, 'Latitude E7440', 1);
INSERT INTO tb_client_devices VALUES (1, 1);


