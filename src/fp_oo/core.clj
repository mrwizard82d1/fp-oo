(ns fp-oo.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(defn second [l]
  (first (rest l)))

(defn third [l]
  (first (rest (rest l))))

(defn add-squares [& args]
  (reduce + (map #(* % %) args)))

(defn factorial [n]
  (apply * (range 1 (inc n))))


;; Take the first n eleemnts of a seq.
(take 2 (range 5))
;; (0 1)

;; Eliminate duplicates in a seq.
(distinct [1 2 3 1])
;; (1 2 3)

;; Concatenate two sequences
(concat (range 3) (range 3 5))
;; (0 1 2 3 4)

;; return a seq that contains n copies of v
(repeat 3 2)
;; (2 2 2)

;; return a seq with each element taken from each source seqs
(interleave  [0 2 4] [1 3 5])
;; (0 1 2 3 4 5)

;; drop the first n items
(drop 3 (range 6))
;; (3 4 5)

;; drop the last n items
(drop-last 3 (range 6))
;; (0 1 2)

;; flatten a nested seq
(flatten [1 2 '(3 [4] 5)])
;; (1 2 3 4 5)

;; partition a seq into chunks on n
(partition 2 [0 1 2 3 4 5])
;; ((0 1) (2 3) (4 5))

;; verify that a condition is true for every item in a seq
(every? even? [0 2 4])
;; true
(every? even? [0 2 4 5])
;; false

;; remove all items that fulfill cond in seq
(remove odd? (range 6))
;; (0 2 4)
