# Byte A Cookie's back-end

This is the back-end for the _Byte a Cookie_ app.

It hosts the logic needed to write down and share recipes in the web
application.

## Technology

This back-end is written in Java. It exposes a REST API for the
front-end(s) to communicate with it.

The technology stack is:

- Spring (for the general framework)
- Hibernate (for the ORM)
- PostgreSQL (for the database)

## Architecture

The app manages four types of objects: the users, the recipes, the
ingredients and the comments.

A user can create and read recipes and post review on them. A recipe
is made of items and can receive reviews.

## How to use it

The database's credentials are configured in a `.env` file. You can use the
template provided in `.env.sample` to help write it:
```shell
cp .env.sample .env
$EDITOR .env
```

Once this is done, start the database server (we use a Docker container for
convenience):
```shell
sudo docker compose up
```

Then start the Java application. You can use Maven for this:
```shell
mvn spring-boot:run
```

(Starting it from an IDE works fine too.)

The app will start a web server on port [8080](http://localhost:8080).

_Et voilà !_

## Documentation

An OpenAPI documentation is automatically generated for the endpoints.
Once the server is started, you can access the human-readable version
(Swagger UI) at http://localhost:8080/swagger-ui/index.html.