(ns advent-of-code.2015.7-test
  (:require [clojure.test :refer :all]
            [advent-of-code.2015.7 :refer :all]))

(deftest parsing
  (are [exp act] (= exp act)
    {:op "->" :deps ["123"] :out "x"}
    (parse-line "123 -> x")

    {:op "->" :deps ["lx"] :out "y"}
    (parse-line "lx -> y")

    {:op "NOT" :deps ["x"] :out "y"}
    (parse-line "NOT x -> y")

    {:op "AND" :deps ["x" "y"] :out "z"}
    (parse-line "x AND y -> z")

    {:op "OR" :deps ["x" "y"] :out "z"}
    (parse-line "x OR y -> z")

    {:op "RSHIFT" :deps ["x" "2"] :out "y"}
    (parse-line "x RSHIFT 2 -> y")

    {:op "LSHIFT" :deps ["t" "3"] :out "z"}
    (parse-line "t LSHIFT 3 -> z")))

(deftest conflictive
  (are [exp act] (= exp act)
    65079
    (let [machine (parse "x OR y -> e\nNOT x -> h\n123 -> x\nx AND y -> d\nNOT y -> i\ny RSHIFT 2 -> g\n456 -> y\nx LSHIFT 2 -> f")]
      (evaluate machine "i"))))
