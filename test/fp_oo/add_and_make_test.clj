(ns fp-oo.add-and-make-test
  (:require [midje.sweet :refer :all]
            [fp-oo.add-and-make :as aam]))

(facts "Minimal constructor"
       (fact (aam/Point 525 715) => {:x 525,
                                     :y 715,
                                     :__class-symbol__ 'Point}))

(facts "Accessors"
       (fact (aam/x {:x 763 :y 465}) => 763)
       (fact (aam/y {:x 763 :y 465}) => 465))

(facts "Class meta-data"
       (let [to-test (aam/Point 756 467)]
         (fact (aam/class-of to-test) => 'Point)))