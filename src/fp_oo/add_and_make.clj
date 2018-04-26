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
    (Point (+ (x this) (x addend))
           (+ (y this) (y addend)))))
