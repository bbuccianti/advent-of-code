(defproject advent-of-code "0.1.0-SNAPSHOT"
  :description "Advent of Code"
  :url ""
  :license "MIT"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [criterium "0.4.5"]]
  :main ^:skip-aot advent-of-code.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}}
  :global-vars {*warn-on-reflection* true
                *unchecked-math* :warn-on-boxed})
