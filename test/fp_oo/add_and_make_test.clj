(ns fp-oo.add-and-make-test
  (:require [midje.sweet :refer :all]
            [fp-oo.add-and-make :as aam]))

(facts "Minimal constructor"
       (fact (aam/Point 525 715) => {:x 525 :y 715}))

(facts "Accessors"
       (fact (aam/x {:x 763 :y 465}) => 763)
       (fact (aam/y {:x 763 :y 465}) => 465))
