(ns fp-oo.add-and-make)

(def Point
  (fn [x y]
    {:x x
     :y y
     :__class-symbol__ 'Point}))

(def x :x)

(def y :y)

(def class-of :__class-symbol__)
