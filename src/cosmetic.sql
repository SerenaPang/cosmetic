CREATE DATABASE Cosmetic;

CREATE TABLE Cosmetic
(
    cosmetic_id bigint NOT NULL,
    name text COLLATE pg_catalog."default",
    description text COLLATE pg_catalog."default",
    brand text COLLATE pg_catalog."default",
    price double precision,
    CONSTRAINT cosmetic_pkey PRIMARY KEY (cosmetic_id)
)

-- Cosmetic

INSERT INTO Cosmetic VALUES(1, 'EyeShadow', 'Flower Knows eyeshadow','Flower Knows','7.99');
INSERT INTO Cosmetic VALUES(2, 'Eyebrown Pencil', 'Shade Eyebrown Pencil ','Shade','4.88');
INSERT INTO Cosmetic VALUES(3, 'Eye Lahes', 'Kiki false eye Lahes ','Kiki','3.99');
INSERT INTO Cosmetic VALUES(4, 'EyeLiner', 'Kiki black eyeLiner','Kiki','3.99');
INSERT INTO Cosmetic VALUES(5, 'Lipstick', 'Dior 999 Red','Christian Dior','19.99');
INSERT INTO Cosmetic VALUES(6, 'Setting Powder', 'Ming Powder','Ming','20.99');
INSERT INTO Cosmetic VALUES(7, 'Highlighter', 'Fire highlighter glitter','Fire','18.99');
INSERT INTO Cosmetic VALUES(8, 'Flush', 'CC Beauty Flush','CC Beauty','6.99');

select * from cosmetic;

CREATE TABLE Cart
(
    cart_id bigint NOT NULL,
    cosmetic_id bigint NOT NULL,
    quantity bigint,
    price double precision,
    PRIMARY KEY (cart_id),
    FOREIGN KEY(cosmetic_id) REFERENCES Cosmetic(cosmetic_id)	
)

CREATE TABLE OrderInfo
(
	order_id bigint NOT NULL,
    cart_id bigint NOT NULL,
    total_price double precision,
    PRIMARY KEY (order_id),
    FOREIGN KEY(cart_id) REFERENCES Cart(cart_id)
)

CREATE TABLE PaymentInfo
(
    paymentinfo_id bigint NOT NULL,
    card_number text COLLATE pg_catalog."default",
    cvc text COLLATE pg_catalog."default",
    PRIMARY KEY (paymentinfo_id)
)

CREATE TABLE ShippingInfo
(
    shippinginfo_id bigint NOT NULL,
    name text COLLATE pg_catalog."default",
    address text COLLATE pg_catalog."default",
    zipcode text COLLATE pg_catalog."default",
    country text COLLATE pg_catalog."default",
    city text COLLATE pg_catalog."default",
    phone text COLLATE pg_catalog."default",
    PRIMARY KEY (shippinginfo_id)
)