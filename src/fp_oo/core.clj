(ns fp-oo.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(defn second [l]
  (first (rest l)))


