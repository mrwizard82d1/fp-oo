(ns fp-oo.recursion)

(def factorial-first
  (fn [n]
    (if (or (= n 1) (= n 0)) 
      1
      (* n (factorial-first (dec n))))))

