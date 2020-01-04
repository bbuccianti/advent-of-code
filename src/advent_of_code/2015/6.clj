(ns advent-of-code.2015.6
  (:require
   [clojure.pprint :refer [pprint]]
   [clojure.java.io :as io]
   [clojure.string :refer [split-lines split blank?]]))

(defn toggle [^ints grid [x1 y1 x2 y2]]
  (doseq [i (range x1 (inc x2))
          k (range (+ y1 (* i 1000)) (+ y2 (* i 1000) 1))]
    (aset-int grid k (- 1 (aget grid k)))))

(defn toggle-brightness [^ints grid [x1 y1 x2 y2]]
  (doseq [i (range x1 (inc x2))
          k (range (+ y1 (* i 1000)) (+ y2 (* i 1000) 1))]
    (aset-int grid k (+ 2 (aget grid k)))))

(defn turn [^ints grid val [x1 y1 x2 y2]]
  (doseq [i (range x1 (inc x2))
          k (range (+ y1 (* i 1000)) (+ y2 (* i 1000) 1))]
    (aset-int grid k val)))

(defn turn-brightness [^ints grid val [x1 y1 x2 y2]]
  (doseq [i (range x1 (inc x2))
          k (range (+ y1 (* i 1000)) (+ y2 (* i 1000) 1))]
    (let [last-value (aget grid k)
          new-value (+ last-value val)]
      (if (>= new-value 0)
        (aset-int grid k new-value)
        (aset-int grid k 0)))))

(defn count-grid [^ints grid]
  (areduce grid i cnt 0 (+ cnt (aget grid i))))

(defn main []
  (let [grid (int-array (* 1000 1000))]
    (doseq [^String line (split-lines (slurp (io/file (io/resource "2015/6/input"))))]
      (let [v (map #(Integer/parseInt %) (re-seq #"[0-9]+" line))]
        (cond
          (.startsWith line "turn on") (turn grid 1 v)
          (.startsWith line "turn off") (turn grid 0 v)
          (.startsWith line "toggle") (toggle grid v))))
    (count-grid grid)))

(defn main-brightness []
  (let [grid (int-array (* 1000 1000))]
    (doseq [^String line (split-lines (slurp (io/file (io/resource "2015/6/input"))))]
      (let [v (map #(Integer/parseInt %) (re-seq #"[0-9]+" line))]
        (cond
          (.startsWith line "turn on") (turn-brightness grid 1 v)
          (.startsWith line "turn off") (turn-brightness grid -1 v)
          (.startsWith line "toggle") (toggle-brightness grid v))))
    (count-grid grid)))
