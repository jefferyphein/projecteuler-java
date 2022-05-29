# Project Euler (Java)

This project was created to learn some of the basics of Java programming.

## Basic Usage

This repository is structured so that you can clone it and immediately build
and run it with Maven. For example, to build and run the unit tests:

    podman run --rm -v "$PWD":/usr/src/euler:Z -w /usr/src/euler maven:latest mvn test

To run the first six Project Euler problems in an interactive shell:

    podman run -it -v "$PWD":/usr/src/euler:Z -w /usr/src/euler maven:latest /bin/bash
    mvn clean compile assembly:single
    java -jar target/projecteuler-1.0-SNAPSHOT-jar-with-dependencies.jar 1 2 3..6

**NOTE**: I personally use `podman`, but all commands above should also work by
replacing `podman` with `docker`. I'm not sure if the `:Z` suffix to the `-v`
volume binding works with `docker`, however.

## Repository Layout

The general layout of this project is as follows:

```
projecteuler-java
│   .gitignore      # Ignore project build and development artifacts.
│   README.md       # This file.
│   pom.xml         # Project Object Model file for this project.
│
└───src
    └───main
    │   └───java
    │       └───projecteuler
    │           └───app
    │               │   App.java        # The runtime application.
    │               │   Euler.java      # Problem interface class.
    │               │   Euler001.java   # Solution to Problem #1.
    │               │   ...             # ...additional solutions.
    │               │   Lib.java        # Common use library.
    │
    └───test
        └───java
            └───projecteuler
                └───app
                    │   AppTest.java    # Unit tests for problem solutions.
                    │   LibTest.java    # Unit tests for libraries.
```
