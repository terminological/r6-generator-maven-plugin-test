# Generated by r6-generator-maven-plugin: do not edit by hand

# This runs when the library is loaded.
# The precise result of this is a little uncertain as it depends on whether rJava has already been
# initialised and what other libraries are using it.
.onLoad <- function(libname, pkgname) {
	
		# add in specific java options from the maven file
	jOpts = getOption("java.parameters")[!grepl(x = getOption("java.parameters"),pattern = "-Xmx.*")]
	options(java.parameters = c("-Xmx256M",jOpts))
	
	# locate the jar file and check it is installed locally.
	# for some reason libname does not contain the correct path of the root of the package
	# when building as a pkgdown package, so we have to find the location manually.
	libpath = find.package("testRapi")
	
	# files get moved during  
	jarLoc = paste0(libpath,"/java/r6-generator-maven-plugin-test-master-SNAPSHOT-jar-with-dependencies.jar")
	
	if (!file.exists(jarLoc)) {
		
		jarLoc = paste0(libpath,"/inst/java/r6-generator-maven-plugin-test-master-SNAPSHOT-jar-with-dependencies.jar")
		
		if (!file.exists(jarLoc)) {
		
			# It the jar file is not present (e.g. it was not deployed to github or too large for CRAN) then
			# we will need to compile it with the maven wrapper during first library load.
			# This is achieved by using maven to compile and package the project.
			# to ensure this is possible we use a maven wrapper script which is installed into the library.
			
			packageStartupMessage("The Java component of this library was not distributed with the package and must be compiled on first use. This may take some time and may require an internet connection.")
			packageStartupMessage("To do this the current user must be able to write to: ",jarLoc)
			# TODO: 
			
			pomLoc = fs::path_norm(
				fs::path_join(c(libpath,".."))
			)
			
			if (!file.exists(pomLoc)) stop("neither the Jar files nor the Java sources for this library can be located.")
			
			setwd(pomLoc)
			
			# mvn package
			# package lifecycle includes the compile-r-library component
			if(.Platform$OS.type == "windows") {
			  	system2(paste0(pomLoc,"/mvnw.cmd"), args = c("package","-Dmaven.test.skip=true"))
			} else {
				cat("./mvnw package")
				system2(paste0(pomLoc,"/mvnw"), args = c("package","-Dmaven.test.skip=true"))
			}
			
			# this will potentially put the fat jac in the wrong location?
			# if seems to depend on what context we are in. e.g installed package vs devtools
			# this copies it into both possible locations.
			fs::dir_create(paste0(libpath,"/java"))
			fs::file_copy(jarLoc, paste0(libpath,"/java/r6-generator-maven-plugin-test-master-SNAPSHOT-jar-with-dependencies.jar"))
		}
	}
	
	# N.B. Jar files are actually lazily loaded on first use of the library.
	
}
