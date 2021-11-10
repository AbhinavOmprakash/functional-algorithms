(ns search-algorithms.binary-search-test
  (:require [clojure.test :refer :all]
            [search-algorithms.binary-search :as b]))

(deftest bin-search
  (is (= 1 (b/search [1 2 3] 1)))
  (is (= 2 (b/search [1 2 3] 2)))
  (is (= 3 (b/search [1 2 3] 3)))
  (is (= nil (b/search [1 2 3] 4)))
  (is (= nil (b/search [] 4)))
  (is (= nil (b/search [3 2 1] 4))))
