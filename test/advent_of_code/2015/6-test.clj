(ns advent-of-code.2015.6-test
  (:require [clojure.test :refer :all]
            [advent-of-code.2015.6 :refer [toggle turn]]
            [clojure.pprint :refer [pprint]])
  (:import [java.util Arrays]))

(comment
  (into-array (repeat 3 (boolean-array 3 true))) ;; make array
)

(deftest toggling-ranges
  (is (Arrays/deepEquals
       (into-array (for [i (range 3)] (boolean-array 3 true)))
       (toggle (into-array (for [i (range 3)] (boolean-array 3 false)))
               0 0 2 2)))

  (is (Arrays/deepEquals
       (let [grid (into-array (for [i (range 3)] (boolean-array 3 true)))]
         (aset-boolean grid 0 0 false)
         (aset-boolean grid 0 1 false)
         (aset-boolean grid 1 0 false)
         (aset-boolean grid 1 1 false)
         grid)
       (toggle (into-array (for [i (range 3)] (boolean-array 3 true)))
               0 0 1 1))))

