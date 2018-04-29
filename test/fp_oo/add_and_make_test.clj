(ns fp-oo.add-and-make-test
  (:require [midje.sweet :refer :all]
            [fp-oo.add-and-make :as aam]))

(facts "Minimal constructor"
  (fact (aam/make aam/Point 525 715) => (contains {:x 525,
                                                   :y 715,
                                                   :__class-symbol__ 'aam/Point}))
       (let [v1 (aam/make aam/Point 443 727)
             v2 (aam/make aam/Point 29 105)
             v3 (aam/make aam/Point 218 710)]
         (fact (aam/make aam/Triangle v1 v2 v3) => (contains {:v1 v1
                                                              :v2 v2
                                                              :v3 v3
                                                              :__class-symbol__ 'aam/Triangle}))))

(facts "Accessors"
       (fact (aam/x {:x 763 :y 465}) => 763)
       (fact (aam/y {:x 763 :y 465}) => 465))

(facts "Class meta-data"
       (let [to-test (aam/make aam/Point 756 467)]
         (fact (aam/class-of to-test) => 'aam/Point)))

(facts "shift"
       (let [to-test (aam/make aam/Point 990 949)
             shifted-point (aam/shift to-test 275 193)
             other-shifted (aam/shift to-test -275 -193)]
         (fact (aam/x shifted-point) => 1265)
         (fact (aam/y shifted-point) => 1142)
         (fact (aam/x other-shifted) => 715)
         (fact (aam/y other-shifted) => 756)))

(facts "add"
       (let [to-test (aam/make aam/Point 997 84)
             addend (aam/make aam/Point 90 92)
             sum (aam/add to-test addend)]
         (fact (aam/x sum) => 1087)
         (fact (aam/y sum) => 176)))

(facts "make"
       (let [x 763 y 264]
         (fact (aam/make aam/Point x y) => (contains {:x x :y y})))
       (let [v1 (aam/make aam/Point 809 360)
             v2 (aam/make aam/Point 653 400)
             v3 (aam/make aam/Point 359 786)]
         (fact (aam/make aam/Triangle v1 v2 v3) => (contains {:v1 v1 :v2 v2 :v3 v3}))))

(facts "equal-triangles?"
       (fact (aam/equal-triangles? aam/right-triangle aam/right-triangle) => truthy)
       (fact (aam/equal-triangles? aam/right-triangle aam/different-right-triangle) => falsey)
       (fact (aam/equal-triangles?
              aam/right-triangle
              aam/equal-right-triangle
              (aam/make aam/Triangle 
                        (aam/make aam/Point 0 0) (aam/make aam/Point 1 0) (aam/make aam/Point 1 1))) => truthy)
       (fact (aam/equal-triangles?
               aam/right-triangle
               aam/equal-right-triangle
               aam/different-right-triangle) => falsey))

(facts "valid-triangles?"
       (let [v1 (aam/make aam/Point 15 156)
             v2 (aam/make aam/Point 866 485)
             v3 (aam/make aam/Point 390 667)
             valid-triangle (aam/make aam/Triangle v1 v2 v3)
             invalid-triangle (aam/make aam/Triangle v1 v2 v1)]
         (fact (aam/valid-triangle? valid-triangle) => truthy)
         (fact (aam/valid-triangle? invalid-triangle) => falsey)))

(facts "send-to"
       (let [point (aam/make aam/Point 781 418)]
         (fact (aam/send-to point :shift -2 -3) => (contains {:x 779 :y 415}))
         (fact (aam/send-to point :x) => 781)
         (fact (aam/send-to point :y) => 418)))

(facts "apply-message-to"
  (let [a-point (aam/make aam/Point 359 208)]
    (fact (aam/apply-message-to aam/Point a-point :shift [1 3]) => (contains {:x 360 :y 211}))))
