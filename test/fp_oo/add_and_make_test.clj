(ns fp-oo.add-and-make-test
  (:use midje.sweet)
  (:require fp-oo.add-and-make))

(fact "construct Point"
      (fp-oo.add-and-make/x (fp-oo.add-and-make/Point 62 81)) => 62
      (fp-oo.add-and-make/y (fp-oo.add-and-make/Point 62 81)) => 81
      (fp-oo.add-and-make/class-of (fp-oo.add-and-make/Point 62 81)) => 'Point
      (-> (fp-oo.add-and-make/Point 62 81)
          (fp-oo.add-and-make/shift 5 8)
          (fp-oo.add-and-make/x)) => 67
      (-> (fp-oo.add-and-make/Point 62 81)
          (fp-oo.add-and-make/shift 5 8)
          (fp-oo.add-and-make/y)) => 89)

(fact "add two Points"
      (fp-oo.add-and-make/x (fp-oo.add-and-make/add (fp-oo.add-and-make/Point 4 12)
                                                    (fp-oo.add-and-make/Point 46 19))) => 50
      (fp-oo.add-and-make/y (fp-oo.add-and-make/add (fp-oo.add-and-make/Point 4 12)
                                                    (fp-oo.add-and-make/Point 46 19))) => 31
      (fp-oo.add-and-make/x (fp-oo.add-and-make/alt-add (fp-oo.add-and-make/Point 4 12)
                                                        (fp-oo.add-and-make/Point 46 19))) => 50
      (fp-oo.add-and-make/y (fp-oo.add-and-make/alt-add (fp-oo.add-and-make/Point 4 12)
                                                        (fp-oo.add-and-make/Point 46 19))) => 31)

(fact "Point 'constructor' (make)"
      (fp-oo.add-and-make/x (fp-oo.add-and-make/make fp-oo.add-and-make/Point -98 -19)) => -98
      (fp-oo.add-and-make/y (fp-oo.add-and-make/make fp-oo.add-and-make/Point -98 -19)) => -19)

(fact "Triangle 'constructor' (also make)"
      (let [to-test (fp-oo.add-and-make/vertices
                      (fp-oo.add-and-make/make fp-oo.add-and-make/Triangle
                                               (fp-oo.add-and-make/Point 1 2)
                                               (fp-oo.add-and-make/Point 1 3)
                                               (fp-oo.add-and-make/Point 3 1)))]
        (get-in to-test [0 :x]) => 1
        (get-in to-test [0 :y]) => 2
        (get-in to-test [1 :x]) => 1
        (get-in to-test [1 :y]) => 3
        (get-in to-test [2 :x]) => 3
        (get-in to-test [2 :y]) => 1))

(fact "equal-triangles?"
      (fp-oo.add-and-make/equal-triangles? fp-oo.add-and-make/right-triangle
                                           fp-oo.add-and-make/right-triangle) => truthy
      (fp-oo.add-and-make/equal-triangles? fp-oo.add-and-make/right-triangle
                                           fp-oo.add-and-make/equal-right-triangle) => truthy
      (fp-oo.add-and-make/equal-triangles? fp-oo.add-and-make/right-triangle
                                           fp-oo.add-and-make/different-right-triangle) => falsey)

(fact "valid-triangles?"
      (fp-oo.add-and-make/valid-triangle? (fp-oo.add-and-make/make fp-oo.add-and-make/Point 16 -37)
                                          (fp-oo.add-and-make/make fp-oo.add-and-make/Point 25 -2)
                                          (fp-oo.add-and-make/make fp-oo.add-and-make/Point 2 -44)) => truthy
      (fp-oo.add-and-make/valid-triangle? (fp-oo.add-and-make/make fp-oo.add-and-make/Point 16 -37)
                                          (fp-oo.add-and-make/make fp-oo.add-and-make/Point 25 -2)
                                          (fp-oo.add-and-make/make fp-oo.add-and-make/Point 16 -37)) => falsey)
