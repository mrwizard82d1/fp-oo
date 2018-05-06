(ns fp-oo.class-test
  (:require [midje.sweet :refer :all]
            [fp-oo.class :as foc]))

(facts "make"
  (let [to-test (foc/make foc/Point 743 803)]
    (fact to-test => (contains {:x 743 :y 803}))
    (fact to-test => (contains {:__class-symbol__ `foc/Point}))))

(facts "send-to"
  (let [to-test (foc/make foc/Point 168 273)]
    (fact (foc/send-to to-test :shift -2 -3) => 
          (contains {:x 166 :y 270 :__class-symbol__ `foc/Point}))
    (fact (foc/send-to to-test :class-name) => `foc/Point)
    (fact (foc/send-to to-test :class) => (contains {:__own-symbol__ `foc/Point}))))

(facts "apply-message-to"
  (let [to-test (foc/make foc/Point 0 604)]
    (fact (foc/apply-message-to foc/Point to-test :shift [1 3]) => 
          (contains {:x 1 :y 607 :__class-symbol__ `foc/Point}))))
