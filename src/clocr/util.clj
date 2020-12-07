(ns clocr.util
  (:require [clojure.string :as str]))

(defn operating-system []
  (let [osname (System/getProperty "os.name")]
    (cond
      (str/includes? osname "Windows") :windows
      (str/includes? osname "Linux") :linux
      :else (throw (ex-info "Unsupported operating system"
                            {:os-name osname})))))
