# maven-r6-generator-plugin-test

A test of the r-jsr223-maven-plugin

This test demonstrates some of the major features of the maven plugin by creating a minimal R plugin from a set of annotated java classes.

?export LD_LIBRARY_PATH="/usr/lib/jvm/oracle-9-java/..../server" required to make this compile

```R
library(devtools)
# assuming you have cloned this repository locally:
load_all("~/Git/r6-generator-maven-plugin-test/r-library")
# OR if not
# install_github("terminolgical/maven-r-jsr223-plugin-test",subdir="r-library")

# a basic smoke test
library(testRapi)
J <- JavaApi$get()

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

