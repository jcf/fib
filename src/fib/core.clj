(ns fib.core
  "Fast Fibonacci implementation using the fast doubling method.")

(defn fib
  "Returns the nth member of the Fibonacci sequence using the fast doubling
  method."
  [n]
  (letfn [(fib* [n]
            (if (zero? n)
              [0 1]
              (let [[a b] (fib* (quot n 2))
                    c (*' a (-' (*' 2 b) a))
                    d (+' (*' b b) (*' a a))]
                (if (even? n)
                  [c d]
                  [d (+' c d)]))))]
    (first (fib* n))))
