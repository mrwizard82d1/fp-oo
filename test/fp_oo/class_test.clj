(ns fp-oo.class-test
  (:require [midje.sweet :refer :all]
            [fp-oo [class :as foc]]))

(facts "canary"
       (+ 2 2) => 4)

(facts "Point (meta) class"
       (let [sut foc/Point]
         (set (keys sut)) => #{:__instance_methods__ :__own_symbol__}
         (set (keys (:__instance_methods__ sut))) => #{:add-instance-values :class :shift}
         (fn? (get-in sut [:__instance_methods__ :add-instance-values])) => truthy
         (get-in sut [:__instance_methods__ :class]) => :__class_symbol__
         (fn? (get-in sut [:__instance_methods__ :shift])) => truthy))

(facts "make Point"
       (let [sut (foc/make foc/Point -25 36)]
         (set (keys sut)) => #{:x :y :__class_symbol__}
         (:__class_symbol__ 'Point)
         (:x sut) => -25
         (:y sut) => 36))

(facts "send-to"
       (let [sut (foc/make foc/Point -12 36)
             shifted (foc/send-to sut :shift -5 -26)]
         (set (keys shifted)) => #{:x :y :__class_symbol__}
         (:__class_symbol__ 'Point)
         (:x shifted) => -17
         (:y shifted) => 10))
