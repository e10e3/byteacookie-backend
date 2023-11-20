CREATE TABLE users
(
    id       bigserial PRIMARY KEY,
    name     text   NOT NULL,
    email    text   NOT NULL UNIQUE,
    image_id bigint NULL REFERENCES images,
    password bytea  NOT NULL,

    CONSTRAINT username_is_non_empty CHECK (length(name) > 0),
    CONSTRAINT email_is_non_empty CHECK (length(email) > 0),
    CONSTRAINT email_is_lowercase CHECK (email = lower(email)),
    CONSTRAINT email_has_at_symbol CHECK (email ~ '^.+@\S+$'),
    CONSTRAINT password_is_non_empty CHECK (octet_length(password) > 0)
);

CREATE TABLE images
(
    id      bigserial PRIMARY KEY,
    content bytea NOT NULL,

    CONSTRAINT content_is_non_empty CHECK (octet_length(content) > 0)
);

CREATE TYPE difficulty AS ENUM ( 'EASY', 'MEDIUM', 'HARD' );

CREATE TABLE recipes
(
    id          bigserial PRIMARY KEY,
    name        text                     NOT NULL,
    image_id    bigint                   NULL REFERENCES images,
    description text                     NOT NULL,
    difficulty  difficulty               NOT NULL,
    time        interval HOUR TO MINUTE  NOT NULL,
    author_id   bigint                   NOT NULL REFERENCES users ON DELETE CASCADE,
    date        timestamp with time zone NOT NULL,

    CONSTRAINT title_is_non_empty CHECK (length(name) > 0),
    CONSTRAINT description_is_non_empty CHECK (length(description) > 0),
    CONSTRAINT time_interval_is_positive CHECK (time > make_interval()),
    CONSTRAINT time_interval_is_less_than_year CHECK (time < make_interval(years := 1)),
    CONSTRAINT date_after_millennium CHECK (date > make_date(1999, 12, 31))
);

CREATE TYPE ingredient_type AS ENUM ( 'DISCREET', 'MASS', 'VOLUME' );

CREATE TABLE ingredients
(
    id       bigserial PRIMARY KEY,
    name     text            NOT NULL,
    image_id bigint          NULL REFERENCES images,
    type     ingredient_type NOT NULL,

    CONSTRAINT name_is_non_empty CHECK (length(name) > 0)
);

CREATE TABLE ingredient_recipe
(
    id            bigserial PRIMARY KEY,
    recipe_id     bigint NOT NULL REFERENCES recipes ON DELETE CASCADE,
    ingredient_id bigint NOT NULL REFERENCES ingredients ON DELETE RESTRICT,
    quantity      real   NOT NULL,

    CONSTRAINT quantity_is_positive CHECK (quantity > 0.0),
    CONSTRAINT quantity_is_reasonable CHECK (quantity < 1000000.0)
);

CREATE TABLE comments
(
    id        bigserial PRIMARY KEY,
    author_id bigint                   NOT NULL REFERENCES users ON DELETE CASCADE,
    recipe_id bigint                   NOT NULL REFERENCES recipes ON DELETE CASCADE,
    rating    integer                  NOT NULL,
    body      text                     NULL,
    date      timestamp with time zone NOT NULL,

    CONSTRAINT rating_in_range CHECK ((rating >= 0) AND (rating <= 10)),
    CONSTRAINT body_is_empty_or_null CHECK ((body IS NULL) OR (length(body) > 0)),
    CONSTRAINT date_after_millennium CHECK (date > make_date(1999, 12, 31))
);
