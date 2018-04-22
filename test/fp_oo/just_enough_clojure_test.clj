(ns fp-oo.just-enough-clojure-test
  (:require [midje.sweet :refer :all]
            [fp-oo.just-enough-clojure :as jec]))

(facts "second"
       (fact (jec/my-second []) => empty?)
       (fact (jec/my-second [:a]) => empty?)
       (fact (jec/my-second [:a :b]) => :b))

(facts "third"
       (fact (jec/third-a []) => empty?)
       (fact (jec/third-a [:a]) => empty?)
       (fact (jec/third-a [:a :b]) => empty?)
       (fact (jec/third-a [:a :b :c]) => :c)
       (fact (jec/third-b []) => empty?)
       (fact (jec/third-b [:a]) => empty?)
       (fact (jec/third-b [:a :b]) => empty?)
       (fact (jec/third-b [:a :b :c]) => :c))

(facts "add-squares"
       (fact (jec/add-squares) => 0)
       (fact (jec/add-squares 1) => 1)
       (fact (jec/add-squares 1 2 5) => 30))

(facts "factorial"
       (fact (jec/factorial 0) => 1)
       (fact (jec/factorial 1) => 1)
       (fact (jec/factorial 5) => 120))

(facts "take - first 3 even numbers"
       (fact (jec/take-eg) => [0 2 4]))
