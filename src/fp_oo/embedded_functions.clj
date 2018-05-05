(ns fp-oo.embedded-functions
  (:require [fp-oo.just-enough-clojure :as jec]))

(def make
  (fn [ctor & args]
    (apply ctor args)))

(def send-to
  (fn [this message & args]
    (apply (message (:methods this)) this args)))

(def Point
  (fn [x y]
    {:x x
     :y y
     :__class-symbol__ 'Point
     :methods
     {:class :__class-symbol__
      :x :x
      :y :y
      :shift
      (fn [this delta-x delta-y]
        (make Point 
              (+ (send-to this :x) delta-x)
              (+ (send-to this :y) delta-y)))
      :add
      (fn [this addend]
        (send-to this :shift (send-to addend :x) (send-to addend :y)))}}))

