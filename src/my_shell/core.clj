(ns my-shell.core
  (:require [clojure.java.shell :as shell]))

(defn sh [& c-strs]
  (let [command (apply str (flatten c-strs))]
    (shell/sh "bash" "-c" command)))

(defn sh-str [& c-strs]
  (let [out-str (:out (sh-do c-strs))]
    (str/replace out-str #"\r?\n$" "")))

(defn sh-strs [& c-strs]
  (let [out-str (:out (sh-do c-strs))]
    (str/split out-str #"\r?\n")))
