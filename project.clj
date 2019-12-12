(defproject advent-of-code "0.1.0-SNAPSHOT"
  :description "Advent of Code"
  :url ""
  :license "MIT"
  :dependencies [[org.clojure/clojure "1.10.0"]]
  :main ^:skip-aot advent-of-code.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
