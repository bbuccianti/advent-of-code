(defproject advent-of-code "0.1.0"
  :description "Advent of Code"
  :license "MIT"
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [criterium "0.4.5"]]
  :target-path "target/%s"
  :global-vars {*warn-on-reflection* true
                *unchecked-math* :warn-on-boxed}
  :profiles {:uberjar {:aot :all}
             :dev {:plugins [[com.jakemccrary/lein-test-refresh "0.24.1"]]
                   :test-refresh {:quiet true
                                  :changes-only true}}})
