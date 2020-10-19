options(tinytex.engine_args = '-shell-escape')
codeSnip = function(type,filename,starts=0,ends=Inf,sep="\n...\n") {
  
  lines = readLines(filename)
  
  if (isTRUE(getOption("knitr.in.progress")) && knitr::opts_knit$get('rmarkdown.pandoc.to')=="html") {
    cat(
      paste0(
        "~~~ {.",type," .number-lines}\n",
        paste0(
          lapply(1:length(starts),function(i) paste0(lines[min(starts[[i]],length(lines)):min(ends[[i]],length(lines))],collapse = "\n")),
          collapse=sep),
        "\n~~~"
      ),
      sep="")
  } else {
    cat(
      paste0(
        "\\begin{minted}[linenos]{",type,"}\n",
        paste0(
          lapply(1:length(starts),function(i) paste0(lines[min(starts[[i]],length(lines)):min(ends[[i]],length(lines))],collapse = "\n")),
          collapse=sep),
        "\n\\end{minted}"
      ),
      sep="")
  }
}