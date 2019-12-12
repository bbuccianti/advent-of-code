(ns advent-of-code.2015.1-test
  (:require [clojure.test :refer :all]
            [advent-of-code.2015.1 :refer :all]))

(deftest what-floor
  (is (= 1 (calc-floor "(")))
  (is (= -1 (calc-floor ")")))
  (is (= 0 (calc-floor "(())"))))

(deftest what-char
  (is (= 1 (calc-basement ")"))))


