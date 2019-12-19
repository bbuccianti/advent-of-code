(ns advent-of-code.2015.4
  (:import
   [java.security MessageDigest]
   [java.math BigInteger]))

(defn md5 [^String s]
  (->> s
       .getBytes
       (.digest (MessageDigest/getInstance "MD5"))
       (BigInteger. 1)
       (format "%032x")))

(defn n-zeros? [flag s]
  (= (if flag "000000" "00000") (subs s 0 (if flag 6 5))))

(defn find-zeros [six?]
  "With a true parameter it search six zeros, otherwise five."
  (reduce
   (fn [_ n]
     (if (n-zeros? six? (md5 (str "iwrupvqb" n)))
       (reduced n)))
   0 (range)))
