(require '[babashka.cli :as cli])

(def template "Title: TODO
Date: %s
Category: frontpage
Tags: a,b,c
Slug: %s

### Kết luận



Hết.

HVN at <https://pymi.vn> and <https://www.familug.org>.

[Ủng hộ tác giả 🍺](https://www.familug.org/p/ung-ho.html)
")

(defn get-date-today []
(def f (java.text.SimpleDateFormat/new "YYYY-MM-dd"))
(.format f (java.util.Date/new))
)

(let [slug (first *command-line-args*)
	rendered (format template (get-date-today) slug)
	filename (str "content/" slug ".md")
	]

(println rendered)
(spit filename rendered)
(println "wrote to" filename)
)
