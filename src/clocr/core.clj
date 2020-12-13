(ns clocr.core
  (:require [clocr.interop :as iop])
  (:import (java.io File)
           (java.awt Rectangle)
           (java.nio.file Path)))

(defn all-text
  "Reads all text from the specified file"
  [^File file
   ^Path data-dir
   language]
  (let [tesseract (iop/setup-tesseract data-dir language)]
    (.doOCR tesseract file)))

(defn text-in-area
  "Reads text in a specific area"
  [^File file
   ^Path data-dir
   language
   options]
  (let [{x      :x
         y      :y
         width  :width
         height :height} options
        tesseract (iop/setup-tesseract data-dir language)
        rectangle (Rectangle. x y width height)]
    (.doOCR tesseract file rectangle)))