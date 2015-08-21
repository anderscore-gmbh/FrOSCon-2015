# anderscore-froscon-2015-spring-batch

OPEN SPRING-BATCH-EXAMPLE.PPT for froscon presentastion slides.

Run MAVEN with Goal INSTALL to build project.

To run the example job:

go to project target folder in eclipse workspace (for example --> C:\Users\rbommersbach\workspace-froscon2015\spring-batch-example\target)
and then execute the following command:

# on Windows:
java -cp spring-batch-example.jar;./lib/* org.springframework.batch.core.launch.support.CommandLineJobRunner classpath:/jobs/file-import-job.xml simpleFileImportJob inputFile=classes/input/sample.csv

# On Unix/Linux:
java -cp spring-batch-example.jar:./lib/* org.springframework.batch.core.launch.support.CommandLineJobRunner classpath:/jobs/file-import-job.xml simpleFileImportJob inputFile=classes/input/sample.csv
