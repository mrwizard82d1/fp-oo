(ns fp-oo.add-and-make-test
  (:use midje.sweet)
  (:require fp-oo.add-and-make))

(fact "construct Point"
      (fp-oo.add-and-make/Point 62 81) => {:x 62 :y 81})
