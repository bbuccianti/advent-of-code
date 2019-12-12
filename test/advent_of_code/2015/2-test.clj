(ns advent-of-code.2015.2-test
  (:require [clojure.test :refer :all]
            [advent-of-code.2015.2 :refer :all]))

(deftest extracting-values
  (is (= (extract-values "2x3x6") {:length 2 :width 3 :height 6})))

(deftest wrapping-paper
  (is (= 58 (to-wrapping (extract-values "2x3x4")))))

(deftest feets-of-ribbon
  (is (= 34 (to-ribbon (extract-values "2x3x4"))))
  (is (= 14 (to-ribbon (extract-values "1x1x10"))))
  (is (= 34 (to-ribbon (extract-values "4x3x2")))))


