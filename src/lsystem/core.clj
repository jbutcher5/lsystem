(ns lsystem.core
  (:gen-class))

(def rules
  {'A '(A B A)
   'B '(A A B)})

(defn- progress
  [rules expr]
  (reduce (fn [acc x] (concat acc (get rules x))) nil expr))

(defn run
  [rules axiom n & {:keys [x] :or {x 0}}]
  (if (< x n)
    (run rules (progress rules axiom) n :x (+ x 1))
    axiom))
  
(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (run rules '(A B A) 5))
