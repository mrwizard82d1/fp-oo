(ns fp-oo.add-and-make)

(defn Point [x y]
  {;; instance data
   :x x
   :y y
   ;; "metadata"
   :__class_symbol__ 'Point})

(defn x [this] (:x this))

(defn y [this] (:y this))

(defn class-of [this]
  (:__class_symbol__ this))

(defn shift [this x-increment y-increment]
  (print (x this))
  (Point (+ (x this) x-increment)
         (+ (y this) y-increment)))

