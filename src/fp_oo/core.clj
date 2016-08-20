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

;; determine equality of two items
(= 3 3.0)
;; true
(= 3 3.000001)
;; 3.000001

;; count the items in a seq
(count [0 1 2])
;; 3

;; Calculate Boolean expressions
(and false true)
;; false
(and true false)
;; false
(and true true true)
;; true
(or false true)
;; true
(or true false)
;; true
(or false false)
;; false
(not true)
;; false
(not false)
;; true

;; construct a new sequence
(cons 1 [2 3 4])
;; (1 2 3 4)

;; Increment and decrement arguments
(inc Math/PI)
;; 4.14159...
(dec Math/PI)
;; 2.14159...

;; Detect an empty sequence
(empty? [])
;; true
(empty? nil)
;; nil
(empty? [1])
;; false

;; Return the item in a seq based on its index
(nth [0 1 2 3 4] 4)
;; 4

;; Return the last item in a seq
(last [0 1 2 3])
;; 3

;; Reverse a seq
(reverse [0 1 2 3])
;; (3 2 1 0)

;; print (with no newline)
(print [0 1 2])
;; Prints its arguments (and returns nil)

;; print with a newline
(println [0 1 2])
;; Prints its arguments followed by a newline (and returns nil)

;; print in "reader format")
(prn "prn")
;; Prints '"prn"' (including double quotes) and returns nil
(prn [0 1 2])
;; Prints the vector (and returns nil)

;; Print an expression in a "pretty" way
(pprint [0 1 [2 [3 4]]])
;; Throws exception when printed from this buffer but prints

(defn prefix-of? [prefix sequence]
  (= prefix (take (count prefix) sequence)))

(defn tails [seq]
  (map #(drop % seq) (range (count seq))))

;; a broken function
(def puzzle 
  (fn [list] (list list)))
