remove.packages("testRapi")

devtools::install("~/Git/r6-generator-maven-plugin-test/r-library/")
library(testRapi)

# 
J = testRapi::JavaApi$new()
test1 = J$FeatureTest$new()
test1$doHelloWorld()

# just consume a dataframe
test1$doSomethingWithDataFrame(dataframe = tibble(x=c(0,1,2),y=c(3,2,1)))

#execute methods with numerics
test1$doSum(a=1.5, b=2.3)

#execute methods with ints (implicit conversion from numeric)
test1$doSum2(a=1, b=2)

# dataframe methods
test1$generateDataFrame()
test1$generateStreamDataFrame()


# fluent method
test1$getMessage()
sameTest1 = test1$fluentSetMessage("New message")
if(!identical(sameTest1, test1)) stop("should be the same object")
test1$getMessage()
sameTest1$getMessage()

# create an AnotherTestRApi class
test2a = test1$factoryMethod(a="hello", b="world")
test2a$printMessage()

# static factory method
test2b = J$AnotherTestRApi$create(message1 = "bonjour", message2 = "world")
test2b$printMessage()

# pure static method
J$AnotherTestRApi$concat(message1 = "ola", message2 = "el mundo")

# pass object as parameter
test1$objectAsParameter(test2)





