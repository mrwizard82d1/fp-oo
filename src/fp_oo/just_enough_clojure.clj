(ns fp-oo.just-enough-clojure)

(def my-second
  (fn [l]
    (first (rest l))))

(def third-a
  (fn [l]
    (first (rest (rest l)))))

(def third-b
  (fn [l]
    (nth l 2 nil)))

(def add-squares
  (fn [& args]
    (apply + (map (fn [x] (* x x)) args))))

(def factorial
  (fn [n]
    (if (= n 0)
      1
      (apply * (range 1 (inc n))))))

(def take-eg
  (fn []
    (take 3 (filter even? (iterate (fn [x] (+ 2 x)) 0)))))