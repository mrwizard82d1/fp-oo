(ns fp-oo.add-and-make-test
  (:require [midje.sweet :refer :all]
            [fp-oo.add-and-make :as aam]))

(facts "Minimal constructor"
       (fact (aam/Point 525 715) => {:x 525,
                                     :y 715,
                                     :__class-symbol__ 'Point})
       (let [v1 (aam/Point 443 727)
             v2 (aam/Point 29 105)
             v3 (aam/Point 218 710)]
         (fact (aam/Triangle v1 v2 v3) => {:v1 v1
                                           :v2 v2
                                           :v3 v3
                                           :__class-symbol__ 'Triangle})))

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

(facts "make"
       (let [x 763 y 264]
         (fact (aam/make aam/Point x y) => (contains {:x x :y y})))
       (let [v1 (aam/Point 809 360)
             v2 (aam/Point 653 400)
             v3 (aam/Point 359 786)]
         (fact (aam/make aam/Triangle v1 v2 v3) => (contains {:v1 v1 :v2 v2 :v3 v3}))))

(facts "equal-triangles?"
       (fact (aam/equal-triangles? aam/right-triangle aam/right-triangle) => truthy)
       (fact (aam/equal-triangles? aam/right-triangle aam/equal-right-triangle) => truthy)
       (fact (aam/equal-triangles? aam/right-triangle aam/different-right-triangle) => falsey)
       (fact (aam/equal-triangles? aam/right-triangle aam/equal-right-triangle aam/right-triangle) => truthy)
       (fact (aam/equal-triangles? aam/right-triangle 
                                   aam/equal-right-triangle
                                   aam/different-right-triangle) => falsey))

