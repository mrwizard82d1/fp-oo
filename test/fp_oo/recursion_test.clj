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

(facts "my-sum - second pattern"
  (fact (recursion/my-sum [0]) => 0)
  (fact (recursion/my-sum [0 3]) => 3)
  (fact (recursion/my-sum [0 3 1]) => 4)
  (fact (recursion/my-sum [0 3 1 2]) => 6)
  (fact (recursion/my-sum [0 3 1 2 4]) => 10))

(facts "silly"
  (fact (recursion/silly []) => {})
  (fact (recursion/silly [:a :b :c]) => {:a 0 :b 0 :c 0}))
