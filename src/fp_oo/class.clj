(ns fp-oo.class)

(def make
  (fn [klass & args]
    (let [allocated {}
          seeded (assoc allocated :__class-symbol__ (:__own-symbol__ klass))
          constructor (:add-instance-values (:__instance-methods__ klass))]
      (apply constructor seeded args))))

(def Point
  {:__own-symbol__ 'Point
   :__instance-methods__
   {:class :__class-symbol__
    :add-instance-values
    (fn [this x y]
      (assoc this :x x :y y))
    :shift
    (fn [this delta-x delta-y]
      (make Point 
            (+ (:x this) delta-x)
            (+ (:y this) delta-y)))
    }
   })
