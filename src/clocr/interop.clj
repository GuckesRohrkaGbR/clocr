(ns clocr.interop
  (:require [clocr.util :as utl]
            [clojure.java.io :as io])
  (:import (net.sourceforge.tess4j.util LoadLibs)
           (java.nio.file Paths)
           (net.sourceforge.tess4j Tesseract)
           (java.io File)))

(defn os-dependent-resources []
  (case (utl/operating-system)
    :windows (LoadLibs/extractTessResources "win32-x86-64")
    :linux (LoadLibs/extractTessResources "linux-x86-64")))

(defn add-library-to-path! [^File tmp-folder]
  (System/setProperty "java.library.path" (.getPath tmp-folder))
  (System/load (str (.getPath tmp-folder) "/libz.so.1"))
  (System/load (str (.getPath tmp-folder) "/libwebp.so.6"))
  (System/load (str (.getPath tmp-folder) "/libwebp.so.7"))
  (System/load (str (.getPath tmp-folder) "/libjpeg.so.62"))
  (System/load (str (.getPath tmp-folder) "/libpng16.so.16"))
  (System/load (str (.getPath tmp-folder) "/libtiff.so.5"))
  (System/load (str (.getPath tmp-folder) "/libwebpmux.so.3"))
  (System/load (str (.getPath tmp-folder) "/libopenjp2.so.7"))
  (System/load (str (.getPath tmp-folder) "/liblept.so.5"))
  (System/load (str (.getPath tmp-folder) "/libtesseract.so")))

(defn setup-tesseract [data-path
                       language]
  (let [tmp-folder (os-dependent-resources)
        data-dir (Paths/get (-> data-path
                                (io/resource)
                                (.toURI)))]
    (add-library-to-path! tmp-folder)
    (doto (Tesseract.)
      (.setLanguage language)
      (.setOcrEngineMode 1)
      (.setDatapath (.toString data-dir)))))
