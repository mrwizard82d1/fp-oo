(ns fp-oo.add-and-make)

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
