(ns fp-oo.recursion-test
  (:require [midje.sweet :refer :all]
            [fp-oo.recursion :as recursion]))

(facts "factorial - first pattern"
  (fact (recursion/factorial-first 5) => 120)
  (fact (recursion/factorial-first 0) => 1)
  (fact (recursion/factorial-first 1) => 1)
  (fact (recursion/factorial-first 2) => 2)
  (fact (recursion/factorial-first 3) => 6)
  (fact (recursion/factorial-first 4) => 24))

(facts "factorial - second pattern"
  (fact (recursion/factorial-second 0) => 1)
  (fact (recursion/factorial-second 1) => 1)
  (fact (recursion/factorial-second 2) => 2)
  (fact (recursion/factorial-second 3) => 6)
  (fact (recursion/factorial-second 4) => 24)
  (fact (recursion/factorial-second 5) => 120))
