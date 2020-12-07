(ns clocr.core-test
  (:require [clojure.test :refer :all]
            [clocr.interop :as iop]))

(deftest can-load-library
  (is (nil?
        (iop/add-library-to-path!
          (iop/os-dependent-resources)))))