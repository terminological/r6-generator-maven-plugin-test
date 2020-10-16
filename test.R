remove.packages("testRapi")

devtools::install("~/Git/r-jsr223-maven-plugin-test/r-library/")
library(testRapi)

# 
J = testRapi::JavaApi$new()
test1 = J$TestRApi$new()
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


# datatype testing
b = J$BounceTest$new()
b$bounceCharacter("Hello")
b$bounceCharacterVector(c("Hello","World"))

b$bounceDate(as.Date("2001-02-03"))
class(b$bounceDate(as.Date("2001-02-03")))
b$bounceDateVector(as.Date(c("2001-02-03","2001-02-04","2001-02-05")))
b$bounceDateVector(as.Date(c("2001-02-03",NA,"2001-02-05")))
b$bounceDouble(1.23)
factorVec = as.factor(c("a","b","c","b","a"))
b$bounceFactor(as.factor(factorVec[[1]]))
b$bounceFactorVector(factorVec) # fail
b$bounceInt(1)
b$bounceInteger(3)
b$bounceIntegerVector(c(2L,3L,4L))
b$bounceIntegerVector(c(2,3,4))
b$bounceIntegerVector(c(2L,NA,4L))
b$bounceLogical(TRUE)
b$bounceLogicalVector(c(TRUE,TRUE,FALSE))
b$bounceLogicalVector(c(TRUE,NA,FALSE))
b$bounceNull(NULL)
b$bounceNumeric(4.6)
b$bounceNumeric(NA_real_)
b$bounceNumeric(Inf)
b$bounceNumeric(-Inf)
b$bounceNumeric(0/0)

b$bounceNumericVector(c(2.3,4.6,34))
b$bounceNumericVector(c(2.3,4.6,NA_real_,34,NaN,Inf,-Inf))
b$bounceString("Hello")
b$bounceVoid()

b$bounceDataframe(tibble::tibble(
  x=c(0,1,2),
  y=c(3L,2L,1L)
))

b$bounceDataframe(tibble::tibble(
  u=factorVec[1:3],
  v=c(TRUE,NA,FALSE),
  w=c("alpha",NA,"gamma"),
  x=c(0,1,2),
  y=c(3L,2L,1L),
  z=as.Date(c("2001-02-03",NA,"2001-02-05"))
))

b$bounceList(list("a","b","c",c(1,2,3)))

input = list("a",list("b",1,"z"),"c",c(1,2,3))
output = b$bounceList(input)
if (!identical(input,output)) stop("FAIL")


b$bounceNamedList(list(x="a",b=c("a",NA,"c"),c=1))


g = J$FactoryTest$new()
g$generateCharacter()
g$generateCharacterVec()
g$generateDataframe()
g$generateFactor()
g$generateFactorVec()
g$generateInteger()
g$generateIntegerVec() 
g$generateList()
g$generateLogical()
g$generateLogicalVec()
g$generateNamedList()
g$generateNumeric()
g$generateNumericVec()
