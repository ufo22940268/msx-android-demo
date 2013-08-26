.PHONY : main
main: 
	mvn -Dmaven.test.skip=true install android:redeploy  android:run -q

.DEFAULT_GOAL := main
