(ns aoc-1.core
  (:gen-class))

(defn read-input
  "Reads the input file, returns a list of numbers"
  []
  (println "Reading input file...")
  (map read-string (clojure.string/split (slurp "resources/input.txt") #"\n")))

(defn find-first-duplicate-frequency
  [input]
  (loop [numbers input
         frequencies [0]
         sum 0]
    (if (empty? numbers)
      (recur input frequencies sum)
      (let [[number & remaining] numbers]
        (let [newSum (+ sum number)]
          (if (.contains frequencies newSum)
            (println "First duplicate frequency: " newSum)
            (recur remaining (conj frequencies newSum) newSum)))))))

(defn -main
  [& args]
  (def input (read-input))
  (println "sum is: " (str (reduce + input)))
  (find-first-duplicate-frequency input))
