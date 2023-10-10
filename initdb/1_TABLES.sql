CREATE TABLE users (
    id bigserial PRIMARY KEY,
    name text NOT NULL,
    email text NOT NULL,
    password text NOT NULL
);

CREATE TYPE difficulty AS ENUM ( 'easy', 'medium', 'hard' );

CREATE TABLE recipes (
    id bigserial PRIMARY KEY,
    name text NOT NULL,
    image bytea,
    description text NOT NULL,
    difficulty difficulty NOT NULL,
    time interval HOUR TO MINUTE NOT NULL,
    author_id integer REFERENCES users ON DELETE CASCADE,
    date timestamp with time zone NOT NULL
);

CREATE TYPE ingredient_type AS ENUM ( 'discreet', 'mass', 'volume' );

CREATE TABLE ingredients (
    id bigserial PRIMARY KEY,
    name text NOT NULL,
    image bytea,
    type ingredient_type NOT NULL
);

CREATE TABLE ingredient_recipe (
    id bigserial PRIMARY KEY,
    recipe_id integer REFERENCES recipes ON DELETE CASCADE,
    ingredient_id integer REFERENCES ingredients ON DELETE RESTRICT ,
    quantity real NOT NULL
);

CREATE TABLE comments (
    id bigserial PRIMARY KEY,
    author_id integer REFERENCES users ON DELETE CASCADE,
    recipe_id integer REFERENCES recipes ON DELETE CASCADE,
    rating integer CHECK (rating >= 0 and rating <= 10) NOT NULL,
    body text NULL,
    date timestamp with time zone NOT NULL
);