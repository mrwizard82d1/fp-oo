(ns fp-oo.embedded-functions-test
  (:require [midje.sweet :refer :all]
            [fp-oo [embedded-functions :as ef]]))

(facts "canary"
  (+ 2 2) => 4)

(facts "constructor"
  (let [to-test (ef/make ef/Point 43 -21)]
    (keys to-test) => [:x :y :__class_symbol__ :methods]
    (keys (:methods to-test)) => [:class :x :y :shift :add]
    (fn? (get-in to-test [:methods :shift]))
    (:x to-test) => 43
    (:y to-test) => -21
    (:__class_symbol__ to-test) => 'Point
    (get-in to-test [:methods :class]) => :__class_symbol__
    (fn? (get-in to-test [:methods :shift])) => truthy))

(facts "send-to"
       (let [to-test (ef/make ef/Point -29 2)
             actual (ef/send-to to-test :shift 24 -30)]
         (keys actual) => [:x :y :__class_symbol__ :methods]
         (:x actual) => -5
         (:y actual) => -28))

(facts "getters"
       (let [to-test (ef/make ef/Point 44 30)]
         (ef/send-to to-test :x) => 44
         (ef/send-to to-test :y) => 30))

(facts "add"
       (let [to-test (ef/make ef/Point 21 -20)
             addend (ef/make ef/Point 31 7)
             result (ef/send-to to-test :add addend)]
         (ef/send-to result :x) => 52
         (ef/send-to result :y) => -13))

