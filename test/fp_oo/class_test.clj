(ns fp-oo.class-test
  (:require [midje.sweet :refer :all]
            [fp-oo.class :as foc]))

(facts "make"
  (let [to-test (foc/make foc/Point 743 803)]
    (fact to-test => (contains {:x 743 :y 803}))
    (fact to-test => (contains {:__class-symbol__ 'Point}))))
