(ns functional_algorithms.sorting_algorithms.sort_test
  (:require [clojure.test :refer :all]
            [functional_algorithms.sorting_algorithms.simple_sort :as simple]))

(deftest sort
  (let [test-data (repeatedly 10 #(rand-int 100))
        expected (clojure.core/sort test-data)]
    (is (= expected (simple/sort test-data)))))
