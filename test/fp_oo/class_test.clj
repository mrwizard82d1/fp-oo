(ns fp-oo.class-test
  (:require [midje.sweet :refer :all]
            [fp-oo [class :as foc]]))

(facts "canary"
       (+ 2 2) => 4)

(facts "make Point"
       (let [sut (foc/make foc/Point -25 36)]
         (set (keys sut)) => #{:x :y :__class_symbol__}
         (:x sut) => -25
         (:y sut) => 36))
