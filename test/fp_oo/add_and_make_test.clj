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
