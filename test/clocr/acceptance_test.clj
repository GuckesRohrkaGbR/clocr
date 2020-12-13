(ns clocr.acceptance-test
  (:require [clojure.test :refer :all]
            [clocr.core :as ocr]
            [clojure.java.io :as io]
            [clojure.string :as str]))

(def testfolder "test-resources/testfiles")
(def data-dir (io/as-relative-path "./test-resources/data"))

(deftest recognizes-text-from-pdf
  (let [file (io/file (str testfolder "/german.pdf"))
        fulltext (ocr/all-text file data-dir "deu")]
    (is (not (nil? fulltext)))
    (is (str/includes? fulltext "Test-Text"))
    (is (str/includes? fulltext "größere"))))

(deftest recognizes-text-from-png
  (let [file (io/file (str testfolder "/german.png"))
        fulltext (ocr/all-text file data-dir "deu")]
    (is (not (nil? fulltext)))
    (is (str/includes? fulltext "Test-Text"))
    (is (str/includes? fulltext "größere"))))

(deftest recognizes-text-in-area
  (let [file (io/file (str testfolder "/german.pdf"))
        text-in-area (ocr/text-in-area file data-dir "deu" {:x      420
                                                            :y      1240
                                                            :width  400
                                                            :height 120})]
    (is (not (nil? text-in-area)))
    (is (not (str/includes? text-in-area "Test-Text")))
    (is (str/includes? text-in-area "größere"))))