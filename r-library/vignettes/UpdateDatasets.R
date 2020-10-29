# create test datasets in Java from R

try(detach("package:testRapi", unload = TRUE),silent = TRUE)
remove.packages("testRapi")

# locally compiled
devtools::install("~/Git/r6-generator-maven-plugin-test/r-library/", upgrade = "never")
J = testRapi::JavaApi$get(logLevel = "WARN")
J$Serialiser$serialiseDataframe(dataframe = ggplot2::diamonds, filename = "/home/terminological/Git/r6-generator-maven-plugin-test/src/main/resources/diamonds.ser")