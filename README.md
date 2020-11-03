# maven-r6-generator-plugin-test

A test of the r-jsr223-maven-plugin

This test demonstrates some of the major features of the maven plugin by creating a minimal R plugin from a set of annotated java classes.

```R
library(devtools)
# assuming you have cloned this repository locally:
load_all("~/Git/r6-generator-maven-plugin-test/r-library")
# OR if not
# install_github("terminolgical/maven-r-jsr223-plugin-test",subdir="r-library")

# a basic smoke test
library(testRapi)
J <- JavaApi$new()

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

see the [full docs](./r-library/docs)
