
-- Table: shops
CREATE TABLE shops ( 
    name                 TEXT    NOT NULL,
    street               TEXT,
    city                 TEXT,
    post_code            TEXT,
    latitude             REAL,
    longitude            REAL,
    can_receive_products INTEGER,
    schedules            TEXT,
    phone                TEXT,
    fax                  TEXT,
    informations         TEXT,
    shop_id              TEXT,
    updated_at           TEXT,
    _id                  INTEGER,
    distance             INTEGER 
);


-- Table: catalogs
CREATE TABLE catalogs ( 
    _id        INTEGER PRIMARY KEY AUTOINCREMENT
                       NOT NULL,
    name       TEXT,
    file       TEXT,
    start_date TEXT,
    end_date   TEXT,
    url        TEXT 
);


-- Table: mappings
CREATE TABLE mappings ( 
    _id        INTEGER PRIMARY KEY AUTOINCREMENT,
    catalog_id INTEGER,
    image_code TEXT,
    products   TEXT 
);


-- Table: customer
CREATE TABLE customer ( 
    _id             INTEGER PRIMARY KEY AUTOINCREMENT,
    email           TEXT,
    civility        TEXT,
    first_name      TEXT,
    last_name       TEXT,
    address_1       TEXT,
    address_2       TEXT,
    address_3       TEXT,
    post_code       TEXT,
    city            TEXT,
    phone           TEXT,
    mobile          TEXT,
    fid_card_id     TEXT,
    favorite_shop   TEXT,
    customer_status TEXT,
    company         TEXT 
);


-- Table: catalog_products
CREATE TABLE catalog_products ( 
    _id       INTEGER PRIMARY KEY,
    ean       TEXT,
    anpf      TEXT,
    title     TEXT,
    price     REAL,
    price_old REAL,
    brand     TEXT,
    url_image TEXT 
);


-- Table: extended_products
CREATE TABLE extended_products ( 
    _id                          INTEGER PRIMARY KEY ASC,
    ean                          TEXT,
    anpf                         TEXT,
    name                         TEXT,
    price                        REAL,
    price_old                    REAL,
    brand                        TEXT,
    url_image                    TEXT,
    url_image_downloaded         TEXT,
    description                  TEXT,
    can_ship_at_home             INTETER,
    can_ship_at_shop             INTEGER,
    is_in_shop                   INTEGER,
    shipping_home_time           TEXT,
    shipping_shop_time           TEXT,
    shipping_time_code           INTEGER,
    shipping_cost                REAL,
    attributes                   TEXT,
    configurable_attribute_label TEXT,
    configurable_attribute_value TEXT,
    configurable                 INTEGER,
    anpf_childs                  TEXT,
    catalog_id                   INT,
    parent_id                    INTEGER 
);


-- Table: url_image_downloaded
CREATE TABLE url_image_downloaded ( 
    _id        INTEGER PRIMARY KEY,
    product_id INTEGER,
    url_image  TEXT 
);


-- Table: url_image_csv
CREATE TABLE url_image_csv ( 
    _id        INTEGER PRIMARY KEY,
    product_id INTEGER,
    url_image  TEXT 
);


-- Table: cart_items
CREATE TABLE cart_items ( 
    _id           INTEGER PRIMARY KEY,
    product_id    INTEGER,
    quantity      INTEGER,
    shipping_type TEXT 
);

