(ns fp-oo.embedded-functions
  (:require [fp-oo.just-enough-clojure :as jec]))

(def make
  (fn [ctor & args]
    (apply ctor args)))

(def Point
  (fn [x y]
    {:x x
     :y y
     :__class-symbol__ 'Point
     :methods
     {:class :__class-symbol__
      :shift
      (fn [this delta-x delta-y]
        (make Point 
              (+ (:x this) delta-x)
              (+ (:y this) delta-y)))}}))

