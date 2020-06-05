(ns fp-oo.embedded-functions)

(defn make [class-fn & args]
  (apply class-fn args))

(defn send-to [instance message & args]
  (apply (message (:methods instance)) instance args))

(defn Point [x y]
  {;; Instance data
   :x x
   :y y
   ;; Metadata
   :__class_symbol__ 'Point
   :methods {:class :__class_symbol__
             :x :x
             :y :y
             :shift (fn [this x-increment y-increment]
                      (make Point
                            (+ (send-to this :x) x-increment)
                            (+ (send-to this :y) y-increment)))
             :add (fn [this addend]
                    (send-to this :shift (send-to addend :x) (send-to addend :y)))}})
