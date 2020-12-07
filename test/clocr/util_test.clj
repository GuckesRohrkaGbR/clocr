(ns clocr.util-test
  (:require [clojure.test :refer :all]
            [clojure.string :as str]
            [clocr.util :as utl]))

(deftest detects-one-operating-system
  (let [os (utl/operating-system)]
    (is (or (= :windows os)
            (= :linux os)))))