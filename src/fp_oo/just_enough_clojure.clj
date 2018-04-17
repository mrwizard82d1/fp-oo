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
