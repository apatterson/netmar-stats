(use '(incanter core stats charts datasets))

(doto (box-plot [1 1 3 4 4 5 5 5 5 5 5 5]
                :title "Importance"
                :y-label "Response"
                :legend true
                :series-label "Search for specific information")
  (add-box-plot [4 4 4 4 5 5 5 5 5 5 5 5] :series-label "Display a combination of data from different providers")
  (add-box-plot [3 4 4 4 4 5 5 5 5 5 5] :series-label "Display a combination of different types of data")
  (add-box-plot [1 3 3 3 3 3 3 4 5] :series-label "Build customised workflows to process data")
  (add-box-plot [1 3 3 3 3 4 4 5 5 5] :series-label "Gaining knowledge of data quality")
  (add-box-plot [1 3 3 3 4 4 4 4 5 5 5 5] :series-label "Downloading data")
  (add-box-plot [1 1 1 2 2 2 2 2 3 5 5 5] :series-label "Support for your native language")
  (add-box-plot [1 1 1 1 1 1 1 2 2 4 5] :series-label "Support for multiple languages")
  (save "Importance.png" :height 600 :width 800))

(let [qs (reduce #(into %1 (repeat 5 %2)) [] (range 1 9))
      scores (reduce #(do %2 (into %1 (range 1 6))) [] (range 1 9))
      as [2 0 1 2 7
          0 0 0 4 8
          0 0 1 4 6
          1 0 6 1 1
          1 0 4 2 3
          1 0 3 4 4
          3 5 1 0 2
          7 2 0 1 1]]
  (doto (bar-chart qs as
                   :group-by scores
                   :legend true
                   :x-label "score"
                   :y-label "# responses")
    (save "bar.png" :height 600 :width 800)
    view))

(doto (box-plot [1 2 2 2 3 4 4]
                :title "Satisfaction"
                :y-label "Response"
                :legend true
                :series-label "Search for specific information")
  (add-box-plot [1 1 1 1 2 2 3 4 4] :series-label "Display a combination of data from different providers")
  (add-box-plot [1 1 1 2 3 3 3 4 4 4] :series-label "Display a combination of different types of data")
  (add-box-plot [1 1 1 1 3 4] :series-label "Build customised workflows to process data")
  (add-box-plot [1 2 2 2 3 3 3 4 4] :series-label "Gaining knowledge of data quality")
  (add-box-plot [1 1 1 1 1 1 2 4] :series-label "Downloading data")
  (add-box-plot [1 1 1 3 3 3 5] :series-label "Support for your native language")
  (add-box-plot [1 1 2 5] :series-label "Support for multiple languages")
  (save "Satisfaction.png" :height 600 :width 800))

(doto (box-plot [3 3 3 4 4 4 4 5 5 5]
                :title "Summary"
                :y-label "Response"
                :legend true
                :series-label "4.2 Is the provided information relevant for your needs?")
  (add-box-plot [2 2 2 2 2 2 3 3 4 4] :series-label "4.3 Is the provided information sufficient for your needs?")
  (add-box-plot [2 2 2 2 3 3 3 4 5] :series-label "4.4 Is the provided data quality information sufficient for your needs?")
  (add-box-plot [1 2 2 2 3 3 4 4 4 4 4] :series-label "5.1. Is the portal user-friendly?")
  (add-box-plot [2 2 2 2 3 3 3 4 4 4 4] :series-label "5.2. Is the portal well-structured?")
  (add-box-plot [2 2 2 3 3 4 4 4 4 4] :series-label "5.3. Is the portal useful for accomplishing your tasks specified above (3.1.)?")
  (save "Summary.png" :height 600 :width 800))


(import '(org.jfree.chart StandardChartTheme)
        '(org.jfree.chart.plot DefaultDrawingSupplier)
        '(java.awt Color))

(def all-red-theme
  (doto
      (StandardChartTheme/createJFreeTheme)
    (.setDrawingSupplier
     (proxy [DefaultDrawingSupplier] []
       (getNextPaint [] Color/red)))))
