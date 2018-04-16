(ns fp-oo.just-enough-clojure)

(def second
  (fn [l]
    (first (rest l))))
