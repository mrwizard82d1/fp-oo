(ns fp-oo.class)

(def apply-message-to
  (fn [klass instance message args]
    (let [method (or (message (:__instance-methods__ klass))
                     message)]
      (apply method instance args))))

(def make
  (fn [klass & args]
    (let [seeded {:__class-symbol__ (:__own-symbol__ klass)
                  :__class-map__ klass}]
      (apply-message-to klass seeded :add-instance-values args))))

(def send-to
  (fn [instance message & args]
    (let [klass (eval (:__class-symbol__ instance))]
      (apply-message-to klass instance message args))))

(def Point
  {:__own-symbol__ `Point
   :__instance-methods__
   {:class-name :__class-symbol__
    :class :__class-map__
    :add-instance-values
    (fn [this x y]
      (assoc this :x x :y y))
    :origin
    (fn [this]
      (make Point 0 0))
    :shift
    (fn [this delta-x delta-y]
      (make Point 
            (+ (:x this) delta-x)
            (+ (:y this) delta-y)))}})

(def Holder 
  {:__own-symbol__ `Holder
   :__instance-methods__
   {:class-name :__class-symbol__
    :class :__class-map__
    :add-instance-values
    (fn [this to-be-held]
      (assoc this :held to-be-held))}})
