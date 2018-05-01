(ns fp-oo.embedded-functions-test
  (:require [midje.sweet :refer :all]
            [fp-oo.embedded-functions :as foef]))

(facts "Getters"
  (let [to-test (foef/make foef/Point 525 715)]
    (fact (:x to-test) => 525)
    (fact (:y to-test) => 715)
    (fact (:__class-symbol__ to-test) => 'Point)))

(facts "Method invocation"
  (let [to-test (foef/make foef/Point 193 498)]
    (fact ((:shift (:methods to-test)) to-test -2 -3) => (contains {:x 191 :y 495 :__class-symbol__ 'Point}))
    (fact ((:class (:methods to-test)) to-test) => 'Point)))

(facts "send-to"
  (let [to-test (foef/make foef/Point 291 262)]
    (fact (foef/send-to to-test :shift -2 -3) => (contains {:x 289 :y 259 :__class-symbol__ 'Point}))
    (fact (foef/send-to to-test :class) => 'Point)))

