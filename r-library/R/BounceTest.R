# Generated by r6-geenrator-maven-plugin: do not edit by hand
# This is a class of the testRapi generated R library.
#
# A test library
# Version: 0.01
# Generated: 2020-11-25T09:46:10.345
# Contact: rc538@exeter.ac.uk
BounceTest = R6::R6Class("BounceTest", public=list(
	.api = NULL,
	.jobj = NULL,
	initialize = function(jobj,api){
		self$.jobj = jobj;
		self$.api = api;
	},
	
	bounceNull = function(x) {
		# copy parameters
		tmp_x = self$.api$.toJava$RNull(x);
		#execute method call
		tmp_out = .jcall(self$.jobj, returnSig = "Luk/co/terminological/rjava/types/RNull;", method="bounceNull" , tmp_x); 
		# convert java object back to R
		out = self$.api$.fromJava$RNull(tmp_out);
		self$.api$printMessages()
		if(is.null(out)) return(invisible(out))
		return(out);
	},
	bounceVoid = function() {
		# copy parameters
		#execute method call
		tmp_out = .jcall(self$.jobj, returnSig = "V", method="bounceVoid" ); 
		# convert java object back to R
		out = self$.api$.fromJava$void(tmp_out);
		self$.api$printMessages()
		if(is.null(out)) return(invisible(out))
		return(out);
	},
	bounceString = function(x) {
		# copy parameters
		tmp_x = self$.api$.toJava$String(x);
		#execute method call
		tmp_out = .jcall(self$.jobj, returnSig = "Ljava/lang/String;", method="bounceString" , tmp_x); 
		# convert java object back to R
		out = self$.api$.fromJava$String(tmp_out);
		self$.api$printMessages()
		if(is.null(out)) return(invisible(out))
		return(out);
	},
	bounceCharacter = function(x) {
		# copy parameters
		tmp_x = self$.api$.toJava$RCharacter(x);
		#execute method call
		tmp_out = .jcall(self$.jobj, returnSig = "Luk/co/terminological/rjava/types/RCharacter;", method="bounceCharacter" , tmp_x); 
		# convert java object back to R
		out = self$.api$.fromJava$RCharacter(tmp_out);
		self$.api$printMessages()
		if(is.null(out)) return(invisible(out))
		return(out);
	},
	bounceCharacterVector = function(x) {
		# copy parameters
		tmp_x = self$.api$.toJava$RCharacterVector(x);
		#execute method call
		tmp_out = .jcall(self$.jobj, returnSig = "Luk/co/terminological/rjava/types/RCharacterVector;", method="bounceCharacterVector" , tmp_x); 
		# convert java object back to R
		out = self$.api$.fromJava$RCharacterVector(tmp_out);
		self$.api$printMessages()
		if(is.null(out)) return(invisible(out))
		return(out);
	},
	bounceDouble = function(x) {
		# copy parameters
		tmp_x = self$.api$.toJava$double(x);
		#execute method call
		tmp_out = .jcall(self$.jobj, returnSig = "D", method="bounceDouble" , tmp_x); 
		# convert java object back to R
		out = self$.api$.fromJava$double(tmp_out);
		self$.api$printMessages()
		if(is.null(out)) return(invisible(out))
		return(out);
	},
	bounceNumeric = function(x) {
		# copy parameters
		tmp_x = self$.api$.toJava$RNumeric(x);
		#execute method call
		tmp_out = .jcall(self$.jobj, returnSig = "Luk/co/terminological/rjava/types/RNumeric;", method="bounceNumeric" , tmp_x); 
		# convert java object back to R
		out = self$.api$.fromJava$RNumeric(tmp_out);
		self$.api$printMessages()
		if(is.null(out)) return(invisible(out))
		return(out);
	},
	bounceNumericVector = function(x) {
		# copy parameters
		tmp_x = self$.api$.toJava$RNumericVector(x);
		#execute method call
		tmp_out = .jcall(self$.jobj, returnSig = "Luk/co/terminological/rjava/types/RNumericVector;", method="bounceNumericVector" , tmp_x); 
		# convert java object back to R
		out = self$.api$.fromJava$RNumericVector(tmp_out);
		self$.api$printMessages()
		if(is.null(out)) return(invisible(out))
		return(out);
	},
	bounceInt = function(x) {
		# copy parameters
		tmp_x = self$.api$.toJava$int(x);
		#execute method call
		tmp_out = .jcall(self$.jobj, returnSig = "I", method="bounceInt" , tmp_x); 
		# convert java object back to R
		out = self$.api$.fromJava$int(tmp_out);
		self$.api$printMessages()
		if(is.null(out)) return(invisible(out))
		return(out);
	},
	bounceInteger = function(x) {
		# copy parameters
		tmp_x = self$.api$.toJava$RInteger(x);
		#execute method call
		tmp_out = .jcall(self$.jobj, returnSig = "Luk/co/terminological/rjava/types/RInteger;", method="bounceInteger" , tmp_x); 
		# convert java object back to R
		out = self$.api$.fromJava$RInteger(tmp_out);
		self$.api$printMessages()
		if(is.null(out)) return(invisible(out))
		return(out);
	},
	bounceIntegerVector = function(x) {
		# copy parameters
		tmp_x = self$.api$.toJava$RIntegerVector(x);
		#execute method call
		tmp_out = .jcall(self$.jobj, returnSig = "Luk/co/terminological/rjava/types/RIntegerVector;", method="bounceIntegerVector" , tmp_x); 
		# convert java object back to R
		out = self$.api$.fromJava$RIntegerVector(tmp_out);
		self$.api$printMessages()
		if(is.null(out)) return(invisible(out))
		return(out);
	},
	bounceFactor = function(x) {
		# copy parameters
		tmp_x = self$.api$.toJava$RFactor(x);
		#execute method call
		tmp_out = .jcall(self$.jobj, returnSig = "Luk/co/terminological/rjava/types/RFactor;", method="bounceFactor" , tmp_x); 
		# convert java object back to R
		out = self$.api$.fromJava$RFactor(tmp_out);
		self$.api$printMessages()
		if(is.null(out)) return(invisible(out))
		return(out);
	},
	bounceFactorVector = function(x) {
		# copy parameters
		tmp_x = self$.api$.toJava$RFactorVector(x);
		#execute method call
		tmp_out = .jcall(self$.jobj, returnSig = "Luk/co/terminological/rjava/types/RFactorVector;", method="bounceFactorVector" , tmp_x); 
		# convert java object back to R
		out = self$.api$.fromJava$RFactorVector(tmp_out);
		self$.api$printMessages()
		if(is.null(out)) return(invisible(out))
		return(out);
	},
	bounceDate = function(x) {
		# copy parameters
		tmp_x = self$.api$.toJava$RDate(x);
		#execute method call
		tmp_out = .jcall(self$.jobj, returnSig = "Luk/co/terminological/rjava/types/RDate;", method="bounceDate" , tmp_x); 
		# convert java object back to R
		out = self$.api$.fromJava$RDate(tmp_out);
		self$.api$printMessages()
		if(is.null(out)) return(invisible(out))
		return(out);
	},
	bounceDateVector = function(x) {
		# copy parameters
		tmp_x = self$.api$.toJava$RDateVector(x);
		#execute method call
		tmp_out = .jcall(self$.jobj, returnSig = "Luk/co/terminological/rjava/types/RDateVector;", method="bounceDateVector" , tmp_x); 
		# convert java object back to R
		out = self$.api$.fromJava$RDateVector(tmp_out);
		self$.api$printMessages()
		if(is.null(out)) return(invisible(out))
		return(out);
	},
	bounceLogical = function(x) {
		# copy parameters
		tmp_x = self$.api$.toJava$RLogical(x);
		#execute method call
		tmp_out = .jcall(self$.jobj, returnSig = "Luk/co/terminological/rjava/types/RLogical;", method="bounceLogical" , tmp_x); 
		# convert java object back to R
		out = self$.api$.fromJava$RLogical(tmp_out);
		self$.api$printMessages()
		if(is.null(out)) return(invisible(out))
		return(out);
	},
	bounceLogicalVector = function(x) {
		# copy parameters
		tmp_x = self$.api$.toJava$RLogicalVector(x);
		#execute method call
		tmp_out = .jcall(self$.jobj, returnSig = "Luk/co/terminological/rjava/types/RLogicalVector;", method="bounceLogicalVector" , tmp_x); 
		# convert java object back to R
		out = self$.api$.fromJava$RLogicalVector(tmp_out);
		self$.api$printMessages()
		if(is.null(out)) return(invisible(out))
		return(out);
	},
	bounceDataframe = function(x) {
		# copy parameters
		tmp_x = self$.api$.toJava$RDataframe(x);
		#execute method call
		tmp_out = .jcall(self$.jobj, returnSig = "Luk/co/terminological/rjava/types/RDataframe;", method="bounceDataframe" , tmp_x); 
		# convert java object back to R
		out = self$.api$.fromJava$RDataframe(tmp_out);
		self$.api$printMessages()
		if(is.null(out)) return(invisible(out))
		return(out);
	},
	bounceList = function(x) {
		# copy parameters
		tmp_x = self$.api$.toJava$RList(x);
		#execute method call
		tmp_out = .jcall(self$.jobj, returnSig = "Luk/co/terminological/rjava/types/RList;", method="bounceList" , tmp_x); 
		# convert java object back to R
		out = self$.api$.fromJava$RList(tmp_out);
		self$.api$printMessages()
		if(is.null(out)) return(invisible(out))
		return(out);
	},
	bounceNamedList = function(x) {
		# copy parameters
		tmp_x = self$.api$.toJava$RNamedList(x);
		#execute method call
		tmp_out = .jcall(self$.jobj, returnSig = "Luk/co/terminological/rjava/types/RNamedList;", method="bounceNamedList" , tmp_x); 
		# convert java object back to R
		out = self$.api$.fromJava$RNamedList(tmp_out);
		self$.api$printMessages()
		if(is.null(out)) return(invisible(out))
		return(out);
	},
	bounceArray = function(x) {
		# copy parameters
		tmp_x = self$.api$.toJava$RNumericArray(x);
		#execute method call
		tmp_out = .jcall(self$.jobj, returnSig = "Luk/co/terminological/rjava/types/RNumericArray;", method="bounceArray" , tmp_x); 
		# convert java object back to R
		out = self$.api$.fromJava$RNumericArray(tmp_out);
		self$.api$printMessages()
		if(is.null(out)) return(invisible(out))
		return(out);
	},
	
	print = function() {
		tmp_out = .jcall(self$.jobj, returnSig = "Ljava/lang/String;", method="toString");
		self$.api$printMessages()
		print(tmp_out)
		invisible(self)
	},
	
	equals = function(object) {
		if (is.null(object$.jobj)) return(FALSE)
		return(self$.jobj$equals(object$.jobj))
	}
))
