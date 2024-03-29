# create test datasets in Java from R

try(detach("package:testRapi", unload = TRUE),silent = TRUE)
remove.packages("testRapi")

# locally compiled
devtools::install("~/Git/r6-generator-maven-plugin-test/r-library/", upgrade = "never")
here::i_am("vignettes/UpdateDatasets.R")

J = testRapi::JavaApi$get(logLevel = "WARN")
J$Serialiser$serialiseDataframe(dataframe = ggplot2::diamonds, filename = here::here("../src/main/resources/diamonds.ser"))
