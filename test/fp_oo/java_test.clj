(ns fp-oo.java-test
  (:require [midje.sweet :refer :all]
            [fp-oo.java :as java]))

(facts "Point"
  (fact java/Point => contains {:__own-symbol__ 'java/Point})
  (fact (contains? (:__instance-methods__ java/Point) :add-instance-values) => truthy))

(facts "make"
  (let [to-test (java/make java/Point 885 757)
        another (java/make java/Point 347 84)]
    (fact to-test => (contains {:x 885 :y 757}))
    (fact another => (contains {:x 347 :y 84}))
    (fact to-test => (contains {:__class-symbol__ `java/Point}))))

(facts "send-to"
  (let [to-test (java/make java/Point 511 631)
        addend (java/make java/Point 659 783)]
    (fact (java/send-to to-test :shift -2 -3) => (contains {:x 509 :y 628}))
    (fact (java/send-to to-test :add addend) => (contains {:x 1170 :y 1414}))))
