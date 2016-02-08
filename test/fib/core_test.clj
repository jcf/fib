(ns fib.core-test
  (:require [clojure.java.io :as io]
            [clojure.test :refer :all]
            [fib.core :refer :all]))

(defn- fib-seq
  []
  (map fib (range)))

(deftest t-fib-seq
  (doseq [[a b x] (->> (fib-seq)
                       (partition-all 3 1)
                       (take 10000))]
    (is (= x (+' a b)))))
