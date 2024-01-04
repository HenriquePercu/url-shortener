CREATE TABLE URL
(
    id SERIAL PRIMARY KEY,
    key VARCHAR(500),
    long_url VARCHAR(500),
    short_url VARCHAR(500),
    created_at timestamp,
    updated_at timestamp
);