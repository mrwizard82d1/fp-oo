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

(facts "shift"
       (let [to-test (aam/Point 990 949)
             shifted-point (aam/shift to-test 275 193)
             other-shifted (aam/shift to-test -275 -193)]
         (fact (aam/x shifted-point) => 1265)
         (fact (aam/y shifted-point) => 1142)
         (fact (aam/x other-shifted) => 715)
         (fact (aam/y other-shifted) => 756)))

(facts "add"
       (let [to-test (aam/Point 997 84)
             addend (aam/Point 90 92)
             sum (aam/add to-test addend)]
         (fact (aam/x sum) => 1087)
         (fact (aam/y sum) => 176)))
