(ns advent-of-code.2015.1
  (:require [clojure.java.io :as io]))

(defn calc-floor [input-string]
  (let [freqs (frequencies input-string)]
    (- (or (get freqs \() 0)
       (or (get freqs \) 0)))))

(defn calc-basement
  ([in] (calc-basement in 0 0))
  ([in basement c]
   (let [s (first in)]
     (cond
       (= -1 basement) c
       (= \( s) (calc-basement (next in) (inc basement) (inc c))
       (= \) s) (calc-basement (next in) (dec basement) (inc c))))))

(comment

  ;; read input file
  (slurp (io/file (io/resource "2015/1/input")))

)
