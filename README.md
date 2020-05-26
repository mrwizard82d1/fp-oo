# fp-oo

Code from the book, "Functional Programming for OO Programmers."

## Usage

The project uses [Midje](https://github.com/marick/Midje/).

### How to run the tests

`lein midje` will run all tests.

`lein midje namespace.*` will run only tests beginning with "namespace.".

`lein midje :autotest` will run all the tests indefinitely. It sets up a
watcher on the code files. If they change, only the relevant tests will be
run again.

## License

Copyright © 2016 Larry Jones

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
