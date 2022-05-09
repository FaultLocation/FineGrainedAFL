# Replication Package

<Statement Types and Error Rates: How Are They Related and How Could They Boost Fault Localization>

This is the replication package for the empirical study. It is composed of 3 folders:
  
  
  
\RQ1Package: The replication package for the investigation in RQ1. 
  
\BoostingMBFLpackage: The replication package for the study on MBFL in RQ2. 
  
\BoostingSBFLpackage: The replication package for the study on SBFL in RQ2.
  
  
  
  
  

##
 \Data of RQ1:
In RQ1, we count the number of various types of statements as well as buggy statements in Defects4J projects. We illustrate the results in "RQ1" Document. 
The code parsing is implemented with the API of Eclipse-JDT. You could write new code to parse your java file. 
If you want to reuse our code to parse java programs, please refer to the file "CumulateType.java" in "BoostingSBFLPackage/HybridAFLSourceCode" and execute the function "runCumulateExperiment". Please note that the line 1185 and line 1187 are used for count the number of buggy statements and all statements respectively. You need to disable one of the two lines each time.
  
D4jType Document: The number of various type of buggy statements involved in our experiment in each D4j project.
  
D4jTypeStatic document : The number of different types of statements in each D4j Project.
  
  
  
  
  
 
  
  
## Boosting MBFL:

The MBFL approach to be boosted in our experiment is MUSE form paper .
To avoid randomness caused by mutation, we directly utilized the suspicious score calculated in paper . Such MBFL suspicious scores are recorded in json file.

To evaluate our boosting performance, you only need to execute the main function of experiment.java

"MBFL" document: The source code of our experiment. You could directly execute the main function of experiment.java.

 "llpjason" document: It contains the data of the suspicious scores calculated by MBFL approach and the statement type information.

"MBFLresult" document: It is the execution result of our experiment.
  
  
  
  
  
  
##  Boosting SBFL:
  
Our statement type based boosting method could be utilized for boosting SBFL. To implement our boosting method, you need to parse the source code of faulty program and get the statement types. We have completed this work for the involved buggy programs from D4j. The types of statements executed by each test suite are recorded in document “D4jTypeList”. You also need to acquire the position of faulty statements in bug history repositories and the total number of different types of statements in each project in these repositories. We record such information of the involved faulty programs in D4j in “groundtruth” and “D4jTypeStatic”, respectively.

Our hybrid booting method is to adjust the suspicious score calculated by off-the-shelf AFL approach. We record the suspicious score of each statement in each involved bug in our experiment in “location”.

The source code of our experiment is included in “HybridAFLSourceCode”. To evaluate the performance of our method, you only need to execute the main function of the file “experiment”. But please remember to configure the file paths first.

Our experiment tries to boost four SBFL algorithms, i.e., Ochiai, Jaccard, Dstar and Barinel. You could select which one you want to boost in lines 29-32 in “experiment.java”

D4jTypeList document: The statement type of each executed statement in each bug.

groundtruth document: The position of faulty statements in each bug.

location document: Suspicious scores calcualted by SBFL

HybridAFLSourceCode: The source code of our experiment. Please execute the main function of experiment.java
  
  
