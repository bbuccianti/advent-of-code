(ns advent-of-code.2015.5-test
  (:require [clojure.test :refer :all]
            [advent-of-code.2015.5 :refer :all]))

(deftest nice
  (is (= :nice (analyze "ugknbfddgicrmopn")))
  (is (= :nice (analyze "aaa"))))

(deftest naughty
  (is (= :naughty (analyze "jchzalrnumimnmhp")))
  (is (= :naughty (analyze "haegwjzuvuyypxyu")))
  (is (= :naughty (analyze "dvszwmarrgswjxmb"))))

(deftest nice2
  (is (= :nice (analyze-two "qjhvhtzxzqqjkmpb")))
  (is (= :nice (analyze-two "xxyxx"))))

(deftest naughty2
  (is (= :naughty (analyze-two "uurcxstgmygtbstg")))
  (is (= :naughty (analyze-two "ieodomkazucvgmuy"))))

