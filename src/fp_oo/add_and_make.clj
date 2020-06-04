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
  (Point (+ (x this) x-increment)
         (+ (y this) y-increment)))

(defn add [this addend]
  (Point (+ (x this) (x addend))
         (+ (y this) (y addend))))

(defn alt-add [this addend]
  (shift this (x addend) (y addend)))

(defn make [class-fn & args]
  (apply class-fn args))

(defn Triangle [vertex-1 vertex-2 vertex-3]
  {:vertices [vertex-1 vertex-2 vertex-3]
   :__class_symbol__ 'Triangle})

(defn vertices [this]
  (:vertices this))
