(defproject jcf/fib "0.1.0-SNAPSHOT"
  :description "Fast Fibonacci implementation using the fast doubling method."
  :url "https://github.com/jcf/fib"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.10.1"]]
  :profiles {:dev {:dependencies [[org.clojure/test.check "0.9.0"]]}})
