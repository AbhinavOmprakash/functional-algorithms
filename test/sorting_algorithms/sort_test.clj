(ns sorting_algorithms.sort_test
  (:require [clojure.test :refer :all]
            [sorting-algorithms.selection-sort :as selection]
            [sorting-algorithms.insertion-sort :as insertion]
            [sorting-algorithms.quick-sort :as quick]
            [sorting-algorithms.merge-sort :as merge]))

(deftest sort
  (let [test-data (repeatedly 10 #(rand-int 100))
        expected (clojure.core/sort test-data)]
    (is (= expected (selection/sort test-data)))
    (is (= expected (insertion/sort test-data)))
    (is (= expected (quick/sort test-data)))
    (is (= expected (merge/sort test-data)))))
