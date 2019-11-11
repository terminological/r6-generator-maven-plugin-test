# returns a reference to a jsr223 engine
javaTestRApi <- function() {
	class.path <- c("./inst/java/maven-r-jsr223-plugin-test-1.0-SNAPSHOT-jar-with-dependencies.jar")
	api <- jsr223::ScriptEngine$new("groovy", class.path)
	api %@% '
		import uk.co.terminological.mavenrjsr233plugintest.TestRApi;
		TestRApi x = new TestRApi();
	'
	return(api)
}

# method: doHelloWorld
# returns: java.lang.String
doHelloWorld <- function(api) {
	return(api$invokeMethod("x", "doHelloWorld"))
}
# method: fluentSetMessage
# returns: uk.co.terminological.mavenrjsr233plugintest.TestRApi
fluentSetMessage <- function(api, message) {
	api %@% 'x = x.fluentSetMessage(message);'
}
# method: getMessage
# returns: java.lang.String
getMessage <- function(api) {
	return(api$invokeMethod("x", "getMessage"))
}
# method: doSum
# returns: int
doSum <- function(api, a, b) {
	return(api$invokeMethod("x", "doSum", a, b))
}

