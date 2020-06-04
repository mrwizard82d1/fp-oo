(ns fp-oo.embedded-functions)

(defn make [class-fn & args]
  (apply class-fn args))

(defn Point [x y]
  {;; Instance data
   :x x
   :y y
   ;; Metadata
   :__class_symbol__ 'Point
   :methods {:class :__class_symbol__
             :shift (fn [this x-increment y-increment]
                      (make 'Point
                            (+ (:x this) x-increment)
                            (+ (:y this) y-increment)))}})

