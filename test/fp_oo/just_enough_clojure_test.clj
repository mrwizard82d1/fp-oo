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
