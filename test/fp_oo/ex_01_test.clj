(ns fp-oo.ex-01-test
      (:use midje.sweet)
      (:require fp-oo.ex-01))

(fact "my-second"
      (fp-oo.ex-01/my-second [1 2 3]) => 2
      (fp-oo.ex-01/my-second [1 2]) => 2
      (fp-oo.ex-01/my-second [1]) => nil
      (fp-oo.ex-01/my-second []) => nil)

(fact "my-third-1"
      (fp-oo.ex-01/my-third-1 [1 2 3 4]) => 3
      (fp-oo.ex-01/my-third-1 [1 2 3]) => 3
      (fp-oo.ex-01/my-third-1 [1 2]) => nil
      (fp-oo.ex-01/my-third-1 [1]) => nil
      (fp-oo.ex-01/my-third-1 []) => nil)

(fact "my-third-2"
      (fp-oo.ex-01/my-third-2 [1 2 3 4]) => 3
      (fp-oo.ex-01/my-third-2 [1 2 3]) => 3
      (fp-oo.ex-01/my-third-2 [1 2]) => nil
      (fp-oo.ex-01/my-third-2 [1]) => nil
      (fp-oo.ex-01/my-third-2 []) => nil)

(fact "add-squares"
      (fp-oo.ex-01/add-squares) => 0
      (fp-oo.ex-01/add-squares 1) => 1
      (fp-oo.ex-01/add-squares 1 2) => 5
      (fp-oo.ex-01/add-squares 1 2 5) => 30)

(fact "factorial"
      (fp-oo.ex-01/factorial 0) => 1
      (fp-oo.ex-01/factorial 1) => 1
      (fp-oo.ex-01/factorial 2) => 2
      (fp-oo.ex-01/factorial 3) => 6
      (fp-oo.ex-01/factorial 4) => 24
      (fp-oo.ex-01/factorial 5) => 120)

(fact "first 3 odd in sequence"
      (fp-oo.ex-01/first-3-odd []) => []
      (fp-oo.ex-01/first-3-odd [3]) => [3]
      (fp-oo.ex-01/first-3-odd [3 1]) => [3 1]
      (fp-oo.ex-01/first-3-odd [3 1 4]) => [3 1]
      (fp-oo.ex-01/first-3-odd [3 1 4 1]) => [3 1 1]
      (fp-oo.ex-01/first-3-odd [1 4 1 4 2 1]) => [1 1 1])

(fact "count duplicates in sequence"
      (fp-oo.ex-01/count-duplicates []) => 0
      (fp-oo.ex-01/count-duplicates [1]) => 0
      (fp-oo.ex-01/count-duplicates [1 4]) => 0
      (fp-oo.ex-01/count-duplicates [1 4 1]) => 1
      (fp-oo.ex-01/count-duplicates [1 4 1 4 2 1]) => 3)

(fact "all-firsts"
      (fp-oo.ex-01/all-firsts) => []
      ;; I do not understand the reason for the following test. The expression,
      ;; `(concat (map first []))` run in the repl returns an empty seq. I think
      ;; it occurs because of map invokes `seq` on an empty seq, but I do not know..
      (fp-oo.ex-01/all-firsts []) => [nil]
      (fp-oo.ex-01/all-firsts [3 1 4]) => [3]
      (fp-oo.ex-01/all-firsts [3 1 4] [2 7 1]) => [3 2]
      (fp-oo.ex-01/all-firsts [3 1 4] [2 7 1] [1 4 1]) => [3 2 1])
