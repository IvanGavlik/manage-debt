(defproject manage-debt "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [ring/ring-jetty-adapter "1.12.1"]
                 [metosin/reitit "0.8.0-alpha1"]
                 [mount "0.1.16"]]
  :main ^:skip-aot manage-debt.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
