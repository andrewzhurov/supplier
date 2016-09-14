(ns supplier.core
  (:use hickory.zip))

(def parsed-doc (parse (slurp "http://www.glozman.com/textpages.html")))

(def links (->> (as-hiccup parsed-doc) flatten (filter #(:href %)) (map #(str "http://www.glozman.com/" (:href %)))))

(def good-links (map #(clojure.string/replace % " " "%20") links))
