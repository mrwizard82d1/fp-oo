(ns fp-oo.class)

(defn make [klass & args]
  (let [seeded-instance {:__class_symbol__ (:__own_symbol__ klass)}
        constructor (get-in klass [:__instance_methods__ :add-instance-values])]
    (apply constructor seeded-instance args)))

(defn local-eval [x]
  (binding [*ns* (find-ns 'fp-oo.class)]
    (eval x)))

(defn send-to [this message & args]
  (let [klass (local-eval (:__class_symbol__ this))
        method (get-in klass [:__instance_methods__ message])]
    (apply method this args)))

(def Point {:__own_symbol__ 'Point
            :__instance_methods__ {:add-instance-values (fn [this x y]
                                                          (assoc this :x x :y y))
                                   :class :__class_symbol__
                                   :shift (fn [this x-increment y-increment]
                                            (make Point
                                                  (+ (:x this) x-increment)
                                                  (+ (:y this) y-increment)))}})
