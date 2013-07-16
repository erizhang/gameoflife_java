#!/usr/bin/env sh
#!/usr/bin/env ruby
#!/usr/bin/env python
export CLASSPATH=$CLASSPATH:./lib/junit-4.10.jar
javac -sourcepath ./tst:./src ./tst/*.java
java -classpath $CLASSPATH:./src:./tst TestRunner
rm ./src/*.class ./tst/*.class -f
