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

(def duplicate-count
  (fn [coll]
    (- (count coll)
       (count (distinct coll)))))

(def first-n-of
  (fn [first-coll second-coll third-coll]
    (concat (take 1 first-coll)
            (take 2 second-coll)
            (take 3 third-coll))))

(def repeat-eg
  (fn [s]
    (repeat 4 (vector (nth s 2)
                      (nth s 4)))))

(def separate-with-underscores
  (fn [coll]
    (take (dec (* 2 (count coll)))
          (interleave coll
                (repeat '_)))))

(def middle-two-of-even-sequence
  (fn [s]
    (->> s
        (drop (dec (/ (count s) 2)))
        (drop-last (dec (/ (count s) 2))))))

(def add-nested
  (fn [s]
    (apply + (flatten s))))

(def big-endian->little-endian
  (fn [s]
    (->> s
         (partition 2)
         (reverse)
         (flatten))))

(def all-odd?
  (fn [s]
    (every? odd? s)))