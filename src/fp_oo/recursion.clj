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

(def my-sum-1
  (fn [s so-far]
    (if (empty? s)
      so-far
      (my-sum-1 (rest s) (+ so-far (first s))))))

(def my-sum
  (fn [s]
    (my-sum-1 s 0)))

(def silly-combiner
  (fn [so-far e]
    (assoc so-far e 0)))

(def silly-1
  (fn [s so-far]
    (if (empty? s)
      so-far
      (silly-1 (rest s) (silly-combiner so-far (first s))))))

(def silly
  (fn [s]
    (silly-1 s {})))
