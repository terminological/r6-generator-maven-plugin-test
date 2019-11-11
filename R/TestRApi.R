# returns a reference to a jsr223 engine
javaTestRApi <- function() {
	class.path <- c(
	  system.file("java", "groovy-all-2.4.17.jar", package="apitest"),
	  system.file("java", "maven-r-jsr223-plugin-test-1.0-SNAPSHOT-jar-with-dependencies.jar", package="apitest")
	)	
	api <- jsr223::ScriptEngine$new("groovy", class.path)
	api %@% '
		import uk.co.terminological.mavenrjsr233plugintest.TestRApi;
		x = new TestRApi();
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
	api$tmp_message = message;
	api %@% 'x = x.fluentSetMessage(tmp_message);';
	api$remove("tmp_message")
	return(api);
}
# method: getMessage
# returns: java.lang.String
getMessage <- function(api) {
	return(api$invokeMethod("x", "getMessage"))
}
# method: doSum
# returns: java.lang.Double
doSum <- function(api, a, b) {
	return(api$invokeMethod("x", "doSum", a, b))
}

