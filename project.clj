(defproject clocr "1.0.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "MIT"
            :url  "https://todo"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [net.sourceforge.tess4j/tess4j "4.5.4"]
                 [org.slf4j/slf4j-nop "1.7.30"]]
  :min-lein-version "2.9.0"
  :source-paths ["src"]
  :test-paths ["test"]
  :resource-paths ["resources"]
  :dev {:resource-paths ["test-resources"]}
  :repl-options {:init-ns clocr.core})
