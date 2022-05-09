In RQ1, we count the number of various types of statements as well as buggy statements in Defects4J projects. We illustrate the results in "RQ1" document. The code parsing is implemented with the API of Eclipse-JDT. You could write new code to parse your java file. If you want to reuse our code to parse java programs, please refer to the file "CumulateType.java" in "BoostingSBFLPackage/HybridAFLSourceCode" and execute the function "runCumulateExperiment". Please note that the line 1185 and line 1187 are used for counting the number of buggy statements and all statements respectively. You need to disable one of the two lines each time.

D4jType Document: The number of various type of buggy statements involved in our experiment in each D4j project.

D4jTypeStatic document : The number of different types of statements in each D4j Project.
