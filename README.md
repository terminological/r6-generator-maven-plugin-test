# maven-r-jsr223-plugin-test

A test of the r-jsr223-maven-plugin

This test demonstrates some of the major features of the maven plugin by creating a minimal
R plugin from a set of annotated java classes.

```R
library(devtools)
# assuming you have cloned this repository locally:
load_all("~/Git/r-jsr223-maven-plugin-test/r-library")
# OR if not
# install_github("terminolgical/maven-r-jsr223-plugin-test",subdir="r-library")

# a basic smoke test
library(testRapi)
J <- JavaApi$new()
tmp = J$TestRApi$new()
tmp$generateColMajorDataFrame()

# documentation available
?JavaApi
?TestRApi
?AnotherTestRApi
```


