(ns advent-of-code.2015.5
  (:require
   [clojure.java.io :as io]
   [clojure.string :refer [split-lines blank?]]))

(defn analyze [s]
  (cond
    (re-matches #".*(xy|ab|pq|cd).*" s)
    :naughty

    (and (re-matches #".*(\w)\1.*" s)
         (re-matches #".*[aeiou].*[aeiou].*[aeiou].*" s))
    :nice

    :else :naughty))

(defn analyze-two [s]
  (if (and (re-matches #".*(\w)(\w).*\1\2.*" s)
           (re-matches #".*(\w).\1.*" s))
    :nice
    :naughty))

(defn from-file [f]
  (reduce
   (fn [c s]
     (if (and (not (blank? s)) (= :nice (f s)))
       (inc c)
       c))
   0
   (split-lines (slurp (io/file (io/resource "2015/5/input"))))))
