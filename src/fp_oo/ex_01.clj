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

;; Exercise 5.1: First 3 odd numbers in a sequence
(defn first-3-odd [xs]
  (take 3 (filter odd? xs)))

;; Exercise 5.2: Count duplicates in a sequence
(defn count-duplicates [xs]
  (- (count xs) (count (distinct xs))))
