(ns fib.core-test
  (:require [clojure.test :refer :all]
            [clojure.test.check
             [clojure-test :refer [defspec]]
             [generators :as gen]
             [properties :as prop]]
            [fib.core :refer :all]))

(defspec fibs-monotonic
  (prop/for-all [^long n gen/pos-int
                 ^long x gen/pos-int]
    (<= (fib n) (fib (+ n x)))))

(defspec fibs-sum-of-previous
  1000
  (prop/for-all [^long n gen/pos-int]
    (let [[a b c] (map fib (range n (+ 3 n)))]
      (= c (+' a b)))))

;; -----------------------------------------------------------------------------
;; Sequences

(deftest fibs-xform
  (is (= #{10284720757613717413913N
           114059301025943970552219N
           1264937032042997393488322N
           1500520536206896083277N
           16641027750620563662096N
           184551825793033096366333N
           2046711111473984623691759N
           2427893228399975082453N
           26925748508234281076009N
           298611126818977066918552N
           3311648143516982017180081N
           354224848179261915075N
           3928413764606871165730N
           43566776258854844738105N
           483162952612010163284885N
           573147844013817084101N
           6356306993006846248183N
           70492524767089125814114N
           781774079430987230203437N
           927372692193078999176N}
         (into #{} (map fib) (range 100 120)))))

(defspec fibs-lazy-seq
  10000
  (prop/for-all [^long drop* gen/pos-int
                 ^long take* gen/pos-int]
    (every? (fn [[a b c]] (= c (+' a b)))
            (->> (range)
                 (map fib)
                 (drop drop*)
                 (take take*)
                 (partition 3 1)))))
