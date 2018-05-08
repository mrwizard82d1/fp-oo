(ns fp-oo.java)

(def make
  (fn [klass & args]
    (let [seeded {:__class-symbol__ (:__own-symbol__ klass)}
          constructor (:add-instance-values (:__instance-methods__ klass))]
      (apply constructor seeded args))))

(def Point 
  {:__own-symbol__ `Point
   :__instance-methods__ 
   {:add-instance-values
    (fn [this x y]
      (assoc this :x x :y y))}})

