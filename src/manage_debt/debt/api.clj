(ns manage-debt.debt.api
  (:require
    [reitit.core :as reitit]
    [reitit.ring :as ring]
    [mount.core :as mount]
    ))

(defn start-connection [] (str "I have conn :)"))


(defn handler [_]
  {:status 200, :body "ok"})

(defn handle-client-debt-details
  "Accepts client debt details and stores them"
  [{{{:keys [x y]} :body} :parameters}]
  {:status 200, :body "Accepts client debt details and stores them" x y}
  )

(def app
  (ring/ring-handler
    (ring/router
      [
       ["/debt-assessment"
        {:post {:handler handle-client-debt-details
                :parameters {:body {:x int?, :y int?}}
                }}]
       ])
    )
  )
