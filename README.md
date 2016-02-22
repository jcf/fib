# fib [![Circle CI](https://circleci.com/gh/jcf/fib.svg?style=svg)](https://circleci.com/gh/jcf/fib)

Fast computation of Fibonacci numbers using the fast doubling method. This will
calculate a Fibonacci number in O(1) space and O(log n) operations, with the
fast doubling method being a constant factor faster than matrix exponentiation.

## Usage

``` clj
(require '[fib.core :refer [fib]])

(fib 20) ;; => 6765
(fib 2000) ;; => 4224696333392304878706725602341482782579852840250681098010280137314308584370130707224123599639141511088446087538909603607640194711643596029271983312598737326253555802606991585915229492453904998722256795316982874482472992263901833716778060607011615497886719879858311468870876264597369086722884023654422295243347964480139515349562972087652656069529806499841977448720155612802665404554171717881930324025204312082516817125N
```

## Memoisation

Using the `fib` function you can easily build a memoised version to trade some
memory for performance.

``` clj
(def fib-memo
  (memoize fib))

(time (fib-memo 20))
"Elapsed time: 0.07062 msecs"
6765

(time (fib-memo 20))
"Elapsed time: 0.04819 msecs"
6765

(time (fib-memo 20))
"Elapsed time: 0.045732 msecs"
6765
```

For small values this is pretty pointless, but for the ten millionth Fibonacci
number…

## A lazy sequence

You can also create a lazy sequence on top of `fib`.

```
(defn fib-seq
  []
  (for [i (range)] (-> i inc fib)))

(take 10 (drop 10 (fib-seq)))
;; => (89 144 233 377 610 987 1597 2584 4181 6765)
```

## Further Reading

- https://en.wikipedia.org/wiki/Fibonacci_number
- https://www.nayuki.io/page/fast-fibonacci-algorithms

## License

Copyright © 2016 James Conroy-Finn

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
