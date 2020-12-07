(ns clocr.core-test
  (:require [clojure.test :refer :all]
            [clocr.core :refer :all]))

(deftest init-works
  (is (not (nil? (init "deu")))))
