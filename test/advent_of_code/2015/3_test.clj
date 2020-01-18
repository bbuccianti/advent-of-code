(ns advent-of-code.2015.3-test
  (:require [clojure.test :refer :all]
            [advent-of-code.2015.3 :refer :all]))

(def start {:x 0 :y 0})

(deftest moving
  (is (= {:x 1 :y 0} (move start \>)))
  (is (= {:x -1 :y 0} (move start \<)))
  (is (= {:x 0 :y 1} (move start \^)))
  (is (= {:x 0 :y -1} (move start \v))))

