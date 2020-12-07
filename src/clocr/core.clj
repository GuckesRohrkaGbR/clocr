(ns clocr.core
  (:require [clocr.interop :as iop])
  (:import (java.io File)
           (java.awt Rectangle)))

(defn all-text
  "Reads all text from the specified file"
  [^File file language]
  (let [tesseract (iop/setup-tesseract "data" language)]
    (.doOCR tesseract file)))

(defn text-in-area
  "Reads text in a specific area"
  [^File file language options]
  (let [{x      :x
         y      :y
         width  :width
         height :height} options
        tesseract (iop/setup-tesseract "data" language)
        rectangle (Rectangle. x y width height)]
    (.doOCR tesseract file rectangle)))