(ns advent-of-code.2015.7
  (:require
   [clojure.java.io :as io]
   [clojure.string :refer [split-lines split blank?]]))

(defonce bit-not-16 (partial bit-and-not 16rFFFF))

(defn get-op [[i0 i1 & args]]
  (cond
    (= i1 "->") "->"
    (= i0 "NOT") "NOT"
    :else i1))

(defn extract-deps [deps op]
  (case op
    "->"     [(first deps)]
    "NOT"    [(second deps)]
    "AND"    ((juxt first last) deps)
    "OR"     ((juxt first last) deps)
    "RSHIFT" [(first deps) (last deps)]
    "LSHIFT" [(first deps) (last deps)]))

(defn parse-line [line]
  (let [splt (split line #" ")
        op (get-op splt)]
    {:out (last splt) :op op :deps (extract-deps (take 3 splt) op)}))

(defn parse [s]
  (reduce (fn [acc nxt]
            (let [{:keys [op out deps]} (parse-line nxt)]
              (merge acc {out [op deps]})))
          {}
          (split-lines s)))

(declare evaluate)

(defn run [m w]
  (let [[op [x1 x2]] (get m w)]
    (case op
      "->"     (evaluate m x1)
      "NOT"    (bit-not-16 (evaluate m x1))
      "AND"    (bit-and (evaluate m x1) (evaluate m x2))
      "OR"     (bit-or (evaluate m x1) (evaluate m x2))
      "RSHIFT" (bit-shift-right (evaluate m x1) (evaluate m x2))
      "LSHIFT" (bit-shift-left (evaluate m x1) (evaluate m x2))
      nil)))

(def memo-run (memoize run))

(defn evaluate [m w]
  (try
    (Integer/parseInt w)
    (catch Exception e (memo-run m w))))

(comment
  (let [input (->> "2015/7/input" io/resource io/file slurp)
        machine (parse input)]
    (evaluate! machine "a"))  ;; first = 956

  (let [input (->> "2015/7/input" io/resource io/file slurp)
        p (parse input)
        machine (assoc p "b" ["->" ["956"]])]
    (evaluate! machine "a"))  ;; second = 40149
)
