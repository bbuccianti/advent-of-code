(ns advent-of-code.2015.2
  (:require
   [clojure.java.io :as io]
   [clojure.string :refer [split split-lines]]))

(defn extract-values [s]
  (let [splited (split s #"x")
        l (first splited)
        w (second splited)
        h (last splited)]
    {:length (Integer. l)
     :width (Integer. w)
     :height (Integer. h)}))

(defn to-wrapping [input-map]
  (let [lw (* (:length input-map) (:width input-map))
        wh (* (:width input-map) (:height input-map))
        hl (* (:height input-map) (:length input-map))]
    (+ (* lw 2) (* wh 2) (* hl 2) (min lw wh hl))))

(defn to-ribbon [input-map]
  (let [sorted (sort (vals input-map))
        ff (* 2 (first sorted))
        ss (* 2 (second sorted))
        bow (* (:length input-map) (:width input-map) (:height input-map))]
    (+ ff ss bow)))

(defn calc-from-file [f]
  (let [lines (split-lines (slurp (io/file (io/resource "2015/2/input"))))]
    (->> lines
         (map extract-values)
         (map f)
         (reduce +))))
