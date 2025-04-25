CREATE DATABASE Cosmetic;

CREATE TABLE IF NOT EXISTS "Cosmetic".cosmetic
(
    cosmetic_id bigint NOT NULL,
    name text COLLATE pg_catalog."default",
    description text COLLATE pg_catalog."default",
    brand text COLLATE pg_catalog."default",
    price double precision,
    CONSTRAINT cosmetic_pkey PRIMARY KEY (cosmetic_id)
)

CREATE TABLE IF NOT EXISTS "Cart".cosmetic
(
    cart_id bigint NOT NULL,
    cosmetic_id bigint NOT NULL,
    quantity bigint,
    price double precision,
    CONSTRAINT cosmetic_pkey PRIMARY KEY (cart_id),
    FOREIGN KEY(cosmetic_id) REFERENCES Cosmetic(cosmetic_id)	
)

CREATE TABLE IF NOT EXISTS "Order".cosmetic
(
    order_id bigint NOT NULL,
    cart_id bigint NOT NULL,
    total_price double precision,
    CONSTRAINT cosmetic_pkey PRIMARY KEY (order_id),
    FOREIGN KEY(cart_id) REFERENCES Cosmetic(cart_id)	
)


CREATE TABLE IF NOT EXISTS "PaymentInfo".cosmetic
(
    paymentinfo_id bigint NOT NULL,
    card_number text COLLATE pg_catalog."default",
    cvc text COLLATE pg_catalog."default",
    CONSTRAINT cosmetic_pkey PRIMARY KEY (paymentinfo_id)
)

CREATE TABLE IF NOT EXISTS "ShippingInfo".cosmetic
(
    shippinginfo_id bigint NOT NULL,
    name text COLLATE pg_catalog."default",
    address text COLLATE pg_catalog."default",
    zipcode text COLLATE pg_catalog."default",
    country text COLLATE pg_catalog."default",
    city text COLLATE pg_catalog."default",
    phone text COLLATE pg_catalog."default",
    CONSTRAINT cosmetic_pkey PRIMARY KEY (shippinginfo_id)
)