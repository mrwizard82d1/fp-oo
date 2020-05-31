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

;; Exercises 5.3: Combines all first elements of a sequences of lists
(defn all-firsts [& seqs]
  (concat (map first seqs)))

;; Exercises 5.4: Given two lists, A and B, create a third list
;; consisting of 5 repetitions of the 3rd item of A and the 5th
;; item of B.
(defn repeat-3-5 [a b]
  (if (and (>= (count a) 3)
           (>= (count b) 5))
    ;; nth is by **index**, not ordinal
    (repeat 5 [(nth a (dec 3)) (nth b (dec 5))])
    []))

;; Exercise 5.5: Put a comma in between each element of a list
(defn make-comma-separated [xs]
  (concat (interleave xs
                      (repeat (dec (count xs)) ","))
          (list (last xs))))

;; Exercise 5.6: Calculate median element of sequence of numbers
(defn median [ns]
  (if (not (empty? ns))
    (if (odd? (count ns))
      (first (drop (/ (dec (count ns)) 2) ns))
      (/ (apply + (take 2 (drop (dec (/ (count ns) 2)) ns))) 2))
    ns))

; Exercise 5.7: Create error message from parse tree
(defn make-space-separated [xs]
  (concat (interleave xs
                      (repeat (dec (count xs)) " "))
          (list (last xs))))

(defn create-syntax-error [parse-tree]
  (if (not (empty? parse-tree))
    (make-space-separated (flatten parse-tree))
    ""))

; Exercise 5.8: Split data into time-text pairs
(defn time-text-pairs [ts]
  (partition 2 ts))

; Exercise 5.9: All subsequences where all elements in subsequence are even
(defn all-evens [& seqs]
  (filter (fn [s] (every? even? s)) seqs))

; Exercise 5.10: First 3 even numbers in sequence (without using even?)
(defn first-3-even [xs]
  (take 3 (remove (fn [x] (odd? x)) xs)))
