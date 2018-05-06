(ns fp-oo.class)

(def make
  (fn [klass & args]
    (let [seeded {:__class-symbol__ (:__own-symbol__ klass)}
          constructor (:add-instance-values (:__instance-methods__ klass))]
      (apply constructor seeded args))))

(def send-to
  (fn [instance message & args]
    (let [klass (eval (:__class-symbol__ instance))
          method (message (:__instance-methods__ klass))]
      (apply method instance args))))

(def Point
  {:__own-symbol__ `Point
   :__instance-methods__
   {:class :__class-symbol__
    :add-instance-values
    (fn [this x y]
      (assoc this :x x :y y))
    :shift
    (fn [this delta-x delta-y]
      (make Point 
            (+ (:x this) delta-x)
            (+ (:y this) delta-y)))}})
