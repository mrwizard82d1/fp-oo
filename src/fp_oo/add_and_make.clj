(ns fp-oo.add-and-make
  (:require [fp-oo.just-enough-clojure :as jec]))

(def make
  (fn [klass & args]
    (let [seeded {:__class-symbol__ (:__own-symbol__ klass)}
          constructor (:__add-instance-values__ (:__instance-methods__ klass))]
      (apply constructor seeded args))))

(def send-to
  (fn [instance message & args]
    (let [klass (eval (:__class-symbol__ instance))
          method (message (:__instance-methods__ klass))]
      (apply method instance args))))

(def apply-message-to
  (fn [klass instance message args]
    (let [method (message (:__instance-methods__ klass))]
      (apply method instance args))))

(def Point
  {:__own-symbol__ 'aam/Point ; meta-data naming the class
   :__instance-methods__ ; map of instance methods
   {:class :__class-symbol__
    :__add-instance-values__ ; constructor similar to Ruby `initialize`
    (fn [this x y]
      (assoc this :x x :y y))
    :x :x
    :y :y
    :shift
    (fn [this delta-x delta-y]
      (make Point (+ (:x this) delta-x) (+ (:y this) delta-y)))}})

(def x :x)

(def y :y)

(def class-of :__class-symbol__)

(def shift
  (fn [this x-inc y-inc]
    (make Point (+ (x this) x-inc) (+ (y this) y-inc))))

(def add
  (fn [this addend]
    (shift this (x addend) (y addend))))

(def Triangle
  {:__own-symbol__ 'aam/Triangle
   :__instance-methods__
   {:class :__class-symbol__
    :__add-instance-values__
    (fn [this v1 v2 v3]
      (assoc this :v1 v1 :v2 v2 :v3 v3))}
   })

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
