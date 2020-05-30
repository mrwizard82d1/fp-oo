(ns fp-oo.ex-01)

(defn my-second [xs] 
  (first (rest xs)))

(defn my-third-1 [xs]
  (first (rest (rest xs))))

(defn my-third-2 [xs]
  (my-second (rest xs)))

(defn add-squares [& xs]
  (apply + (map (fn [n] (* n n)) xs)))

(defn factorial [n]
  (apply * (range 1 (inc n))))
