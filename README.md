# r6-generator-maven-plugin-test

[![R-CMD-check](https://github.com/terminological/r6-generator-maven-plugin-test/workflows/R-CMD-check/badge.svg)](https://github.com/terminological/r6-generator-maven-plugin-test/actions)

[![DOI](https://zenodo.org/badge/304669809.svg)](https://zenodo.org/badge/latestdoi/304669809)

This test demonstrates some of the major features of the maven plugin by creating a minimal R plugin from a set of annotated java classes.

```R
library(devtools)
# assuming you have cloned this repository locally:
load_all("~/Git/r6-generator-maven-plugin-test/r-library")

# install_github("terminological/r6-generator-maven-plugin-test",subdir="r-library")

# a basic smoke test
J <- testRapi::JavaApi$get()

# exploring the API using autocomplete in RStudio
# is a matter of typing J$<ctrl-space> 

tmp = J$FeatureTest$new()
tmp$doHelloWorld()

# generated documentation available

?testRapi-package
?testRapi::JavaApi
?testRapi::MinimalExample
?testRapi::FeatureTest
?testRapi::MoreFeatureTest
?testRapi::BounceTest
?testRapi::FactoryTest

```

Checkout the [features](https://terminological.github.io/r6-generator-maven-plugin-test/r-library/docs/articles/R6-generator-features.html)

see the [full docs](https://terminological.github.io/r6-generator-maven-plugin-test/)

see the [r package](https://terminological.github.io/r6-generator-maven-plugin-test/r-library/docs/)

see the [javadoc](https://terminological.github.io/r6-generator-maven-plugin-test/r-library/docs/javadoc/)

