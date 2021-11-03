(ns sorting_algorithms.sort_test
  (:require [clojure.test :refer :all]
            [sorting_algorithms.selection_sort :as selection]
            [sorting_algorithms.insertion_sort :as insertion]))

(deftest sort
  (let [test-data (repeatedly 10 #(rand-int 100))
        expected (clojure.core/sort test-data)]
    (is (= expected (selection/sort test-data)))
    (is (= expected (insertion/sort test-data)))))
