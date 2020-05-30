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
