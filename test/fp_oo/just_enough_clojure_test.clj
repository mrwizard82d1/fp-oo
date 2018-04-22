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

(facts "distinct - number of duplicates"
       (fact (jec/duplicate-count []) => 0)
       (fact (jec/duplicate-count [3]) => 0)
       (fact (jec/duplicate-count [3 1]) => 0)
       (fact (jec/duplicate-count [3 1 4 1]) => 1)
       (fact (jec/duplicate-count [3 3]) => 1)
       (fact (jec/duplicate-count [3 3 3]) => 2))

(facts "concat - first, first two, first three"
       (fact (jec/first-n-of [3 1 4] [2 7 1] [1 4 1]) => [3 2 7 1 4 1]))

(facts "repeat - repeat list of 3re and 5th elements of collection"
       (fact (jec/repeat-eg '(_ _ A _ B _ _)) => [['A 'B] ['A 'B] ['A 'B] ['A 'B]]))

(facts "interleave - separate collection of numbers with underscores"
       (fact (jec/separate-with-underscores [3 1 4 1 5 9]) =>
             [3 '_ 1 '_ 4 '_ 1 '_ 5 '_ 9]))
