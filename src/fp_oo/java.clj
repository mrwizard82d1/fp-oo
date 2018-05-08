(ns fp-oo.java)

(def make
  (fn [klass & args]
    (let [seeded {:__class-symbol__ (:__own-symbol__ klass)}
          constructor (:add-instance-values (:__instance-methods__ klass))]
      (apply constructor seeded args))))

(def send-to
  (fn [this message & args]
    (let [method (message (:__instance-methods__ (eval (:__class-symbol__ this))))]
      (apply method this args))))

(def Point 
  {:__own-symbol__ `Point
   :__instance-methods__ 
   {:add-instance-values
    (fn [this x y]
      (assoc this :x x :y y))
    :add
    (fn [this addend]
      (send-to this :shift (:x addend) (:y addend)))
    :shift
    (fn [this delta-x delta-y]
      (make Point 
            (+ (:x this) delta-x)
            (+ (:y this) delta-y)))}})

