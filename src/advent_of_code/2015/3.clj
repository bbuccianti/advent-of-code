(ns advent-of-code.2015.3
  (:require [clojure.java.io :as io]))

(defn move [location step]
  (when step
    (cond
      (= step \>) (update location :x inc)
      (= step \<) (update location :x dec)
      (= step \^) (update location :y inc)
      (= step \v) (update location :y dec))))

(defn key-from [location]
  (keyword (str "x" (:x location) "y" (:y location))))

(defn reduce-santa []
  (reduce
   (fn [state step]
     (let [after (move (:location state) step)]
       (-> state
           (assoc :location after)
           (update-in [:freqs (key-from after)] (fnil inc 1)))))
   {:location {:x 0 :y 0} :freqs {:x0y0 1}}
   (slurp (io/file (io/resource "2015/3/input")))))

(defn get-count [{:keys [freqs]}]
  (count (vals freqs)))

(defn reduce-robo-santa []
  (reduce
   (fn [state steps]
     (let [santa (first steps)
           robo (second steps)
           after-santa (move (:santa state) santa)
           after-robo (move (:robo state) robo)]
       (-> state
           (assoc :santa after-santa)
           (assoc :robo after-robo)
           (update-in [:freqs (key-from after-santa)] (fnil inc 1))
           (update-in [:freqs (key-from after-robo)] (fnil inc 1)))))
   {:santa {:x 0 :y 0} :robo {:x 0 :y 0} :freqs {:x0y0 2}}
   (partition 2 (slurp (io/file (io/resource "2015/3/input"))))))
