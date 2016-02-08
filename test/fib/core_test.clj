(ns fib.core-test
  (:require [clojure.java.io :as io]
            [clojure.test :refer :all]
            [fib.core :refer :all]))

(defn- fib-seq
  []
  (for [i (range)] (-> i inc fib)))

(deftest t-fib-seq
  (is (= (take 100 (fib-seq))
         (->> "fib.edn" io/resource slurp read-string (take 100)))))
