This example shows EasyText as a single module.


➜  easytext-singlemodule git:(main) ✗ echo "Hello kiddo" >> input.txt
➜  easytext-singlemodule git:(main) ✗ cat run.sh                                       
mkdir -p out

$JAVA_HOME/bin/javac -d out --module-source-path src -m easytext
$JAVA_HOME/bin/java --module-path out -m easytext/javamodularity.easytext.Main
➜  easytext-singlemodule git:(main) ✗ java --module-path out -m easytext/javamodularity.easytext.Main input.txt 

