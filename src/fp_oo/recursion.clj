(ns fp-oo.recursion)

(def factorial-first
  (fn [n]
    (if (or (= n 1) (= n 0)) 
      1
      (* n (factorial-first (dec n))))))

(def factorial-1
  (fn [n so-far]
    (if (zero? n)
      so-far
      (factorial-1 (dec n) (* n so-far)))))

(def factorial-second
  (fn [n]
    (factorial-1 n 1)))
