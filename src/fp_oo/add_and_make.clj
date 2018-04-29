(ns fp-oo.add-and-make
  (:require [fp-oo.just-enough-clojure :as jec]))

(def Point
  (fn [x y]
    {:x x
     :y y
     :__class-symbol__ 'Point}))

(def x :x)

(def y :y)

(def class-of :__class-symbol__)

(def shift
  (fn [this x-inc y-inc]
    (Point (+ (x this) x-inc)
           (+ (y this) y-inc))))

(def add
  (fn [this addend]
    (shift this (x addend) (y addend))))

(def Triangle
  (fn [v1 v2 v3]
    {:v1 v1
     :v2 v2
     :v3 v3
     :__class-symbol__ 'Triangle}))

(def make
  (fn [ctor & args]
    (apply ctor args)))

(def equal-triangles? =)

(def right-triangle
  (make Triangle (make Point 0 0) (make Point 1 0) (make Point 1 1)))

(def equal-right-triangle
  (make Triangle (make Point 0 0) (make Point 1 0) (make Point 1 1)))

(def different-right-triangle
  (make Triangle (make Point 0 0) (make Point 1 0) (make Point 1 2)))

(def v1 :v1)
(def v2 :v2)
(def v3 :v3)

(def valid-triangle?
  (fn [triangle]
    (let [vertices (map #(% triangle) [v1 v2 v3])]
      (zero? (jec/duplicate-count vertices)))))
