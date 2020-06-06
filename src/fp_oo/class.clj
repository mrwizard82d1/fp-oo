(ns fp-oo.class)

(defn apply-message-to [klass instance message args]
  (let [method (get-in klass [:__instance_methods__ message])]
    (apply method instance args)))

(defn make [klass & args]
  (let [seeded-instance {:__class_symbol__ (:__own_symbol__ klass)}]
    (apply-message-to klass seeded-instance :add-instance-values args)))

(defn local-eval [x]
  (binding [*ns* (find-ns 'fp-oo.class)]
    (eval x)))

(defn send-to [this message & args]
  (let [klass (local-eval (:__class_symbol__ this))]
    (apply-message-to klass this message args)))

(def Point {:__own_symbol__ 'Point
            :__instance_methods__ {:add-instance-values (fn [this x y]
                                                          (assoc this :x x :y y))
                                   :class :__class_symbol__
                                   :shift (fn [this x-increment y-increment]
                                            (make Point
                                                  (+ (:x this) x-increment)
                                                  (+ (:y this) y-increment)))}})
