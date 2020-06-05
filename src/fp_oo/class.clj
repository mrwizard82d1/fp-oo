(ns fp-oo.class)

(defn make [class-map & args]
  (let [allocated-instance {}
        seeded-instance (assoc allocated-instance :__class_symbol__ (:__own_symbol__ class-map))
        constructor (get-in class-map [:__instance_methods__ :add-instance-values])
        initialized-instance (apply constructor seeded-instance args)]
    initialized-instance))

(def Point {:__own_symbol__ 'Point
            :__instance_methods__ {:add-instance-values (fn [this x y]
                                                          (assoc this :x x :y y))
                                   :shift (fn [this x-increment y-increment]
                                            (make Point
                                                  (+ (:x this) x-increment)
                                                  (+ (:y this) y-increment)))}})
