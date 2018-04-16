(ns fp-oo.just-enough-clojure-test
  (:require [midje.sweet :refer :all]
            [fp-oo.just-enough-clojure :as jec]))

(facts "second"
       (fact (jec/second []) => empty?)
       (fact (jec/second [:a]) => empty?)
       (fact (jec/second [:a :b]) => :b))
