(defproject ctg/clocr "4.5.4-alpha"
  :description "Wrapper for tess4j that works on linux as well"
  :url "https://github.com/GuckesRohrkaGbR/clocr"
  :license {:name "MIT"
            :url  "https://todo"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [net.sourceforge.tess4j/tess4j "4.5.4"]
                 [org.slf4j/slf4j-nop "1.7.30"]]
  :min-lein-version "2.9.0"
  :source-paths ["src"]
  :test-paths ["test"]
  :aot [clocr.core]
  :resource-paths ["resources"]
  :dev {:resource-paths ["test-resources"]}
  :deploy-repositories [["clojars" {:sign-releases false :url "https://clojars.org/repo"}]]
  :repl-options {:init-ns clocr.core})
