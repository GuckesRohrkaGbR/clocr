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
  (System/setProperty "java.library.path" (.getPath tmp-folder)))

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
