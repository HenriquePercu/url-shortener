CREATE TABLE URL
(
    id SERIAL PRIMARY KEY,
    key VARCHAR(500),
    long_url VARCHAR(500),
    short_url VARCHAR(500),
    created_at timestamp,
    updated_at timestamp
);

create sequence URL_SEQ start with 1 increment by 50; -- TODO we shouldn't need this, fix on the mapping