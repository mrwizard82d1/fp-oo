(ns fp-oo.embedded-functions-test
  (:require [midje.sweet :refer :all]
            [fp-oo [embedded-functions :as ef]]))

(facts "canary"
  (+ 2 2) => 4)

(facts "constructor"
  (let [to-test (ef/make ef/Point 43 -21)]
    (keys to-test) => [:x :y :__class_symbol__ :methods]
    (keys (:methods to-test)) => [:class :shift]
    (fn? (get-in to-test [:methods :shift]))
    (:x to-test) => 43
    (:y to-test) => -21
    (:__class_symbol__ to-test) => 'Point
    (get-in to-test [:methods :class]) => :__class_symbol__
    (fn? (get-in to-test [:methods :shift])) => truthy))

         
