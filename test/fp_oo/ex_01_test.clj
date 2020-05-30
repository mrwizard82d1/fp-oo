(ns fp-oo.ex-01-test
      (:use midje.sweet)
      (:require fp-oo.ex-01))

(fact "my-second"
      (fp-oo.ex-01/my-second [1 2 3]) => 2
      (fp-oo.ex-01/my-second [1 2]) => 2
      (fp-oo.ex-01/my-second [1]) => nil
      (fp-oo.ex-01/my-second []) => nil)

(fact "my-third-1"
      (fp-oo.ex-01/my-third-1 [1 2 3 4]) => 3
      (fp-oo.ex-01/my-third-1 [1 2 3]) => 3
      (fp-oo.ex-01/my-third-1 [1 2]) => nil
      (fp-oo.ex-01/my-third-1 [1]) => nil
      (fp-oo.ex-01/my-third-1 []) => nil)

(fact "my-third-2"
      (fp-oo.ex-01/my-third-2 [1 2 3 4]) => 3
      (fp-oo.ex-01/my-third-2 [1 2 3]) => 3
      (fp-oo.ex-01/my-third-2 [1 2]) => nil
      (fp-oo.ex-01/my-third-2 [1]) => nil
      (fp-oo.ex-01/my-third-2 []) => nil)

(fact "add-squares"
      (fp-oo.ex-01/add-squares) => 0
      (fp-oo.ex-01/add-squares 1) => 1
      (fp-oo.ex-01/add-squares 1 2) => 5
      (fp-oo.ex-01/add-squares 1 2 5) => 30)

(fact "factorial"
      (fp-oo.ex-01/factorial 0) => 1
      (fp-oo.ex-01/factorial 1) => 1
      (fp-oo.ex-01/factorial 2) => 2
      (fp-oo.ex-01/factorial 3) => 6
      (fp-oo.ex-01/factorial 4) => 24
      (fp-oo.ex-01/factorial 5) => 120)
