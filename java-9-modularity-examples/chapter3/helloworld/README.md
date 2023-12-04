➜  helloworld git:(main) ✗ javac -d out/helloworld \                                                                
src/helloworld/com/javamodularity/helloworld/HelloWorld.java src/helloworld/module-info.java
➜  helloworld git:(main) ✗ java --module-path out --module helloworld/com.javamodularity.helloworld.HelloWorld           
Hello Modular World!

➜  helloworld git:(main) ✗ mkdir mods
➜  helloworld git:(main) ✗ jar cfe mods/helloworld.jar com.javamodularity.helloworld.HelloWorld -C out/helloworld .
➜  helloworld git:(main) ✗

➜  helloworld git:(main) ✗ jlink --module-path mods/:${JAVA_HOME}/jmods --add-modules helloworld --launcher hello=helloworld \
--output helloworld-image
➜  helloworld git:(main) ✗ 


