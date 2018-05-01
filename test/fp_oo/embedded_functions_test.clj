(ns fp-oo.embedded-functions-test
  (:require [midje.sweet :refer :all]
            [fp-oo.embedded-functions :as foef]))

(facts "Minimal constructor"
       (fact (foef/Point 525 715) => {:x 525,
                                     :y 715,
                                     :__class-symbol__ 'Point})
       (let [v1 (foef/Point 443 727)
             v2 (foef/Point 29 105)
             v3 (foef/Point 218 710)]
         (fact (foef/Triangle v1 v2 v3) => {:v1 v1
                                           :v2 v2
                                           :v3 v3
                                           :__class-symbol__ 'Triangle})))

(facts "Accessors"
       (fact (foef/x {:x 763 :y 465}) => 763)
       (fact (foef/y {:x 763 :y 465}) => 465))

(facts "Class meta-data"
       (let [to-test (foef/Point 756 467)]
         (fact (foef/class-of to-test) => 'Point)))

(facts "shift"
       (let [to-test (foef/Point 990 949)
             shifted-point (foef/shift to-test 275 193)
             other-shifted (foef/shift to-test -275 -193)]
         (fact (foef/x shifted-point) => 1265)
         (fact (foef/y shifted-point) => 1142)
         (fact (foef/x other-shifted) => 715)
         (fact (foef/y other-shifted) => 756)))

(facts "add"
       (let [to-test (foef/Point 997 84)
             addend (foef/Point 90 92)
             sum (foef/add to-test addend)]
         (fact (foef/x sum) => 1087)
         (fact (foef/y sum) => 176)))

(facts "make"
       (let [x 763 y 264]
         (fact (foef/make foef/Point x y) => (contains {:x x :y y})))
       (let [v1 (foef/Point 809 360)
             v2 (foef/Point 653 400)
             v3 (foef/Point 359 786)]
         (fact (foef/make foef/Triangle v1 v2 v3) => (contains {:v1 v1 :v2 v2 :v3 v3}))))

(facts "equal-triangles?"
       (fact (foef/equal-triangles? foef/right-triangle foef/right-triangle) => truthy)
       (fact (foef/equal-triangles? foef/right-triangle foef/equal-right-triangle) => truthy)
       (fact (foef/equal-triangles? foef/right-triangle foef/different-right-triangle) => falsey)
       (fact (foef/equal-triangles? foef/right-triangle foef/equal-right-triangle foef/right-triangle) => truthy)
       (fact (foef/equal-triangles? foef/right-triangle 
                                   foef/equal-right-triangle
                                   foef/different-right-triangle) => falsey))

(facts "valid-triangle?"
  (let [v1 (foef/Point 793 615)
        v2 (foef/Point 69 145)
        v3 (foef/Point 277 899)]
    (fact (foef/valid-triangle? v1 v2 v3) => truthy)
    (fact (foef/valid-triangle? v1 v2 v1) => falsey)))

