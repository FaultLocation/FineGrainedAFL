Our statement type based boosting method could be utilized for boosting SBFL. 
To implement our boosting method, you need to parse the source code of faulty program and get the statement types. 
We have completed this work for the involved buggy programs from D4j. 
The types of statements executed by each test suite are recorded in document “D4jTypeList”. 
You also need to acquire the position  of faulty statements in bug history repositories and the total number of different types of statements in each project in these repositories. 
We record such information of the involved faulty programs in D4j in “groundtruth” and “D4jTypeStatic”, respectively.

Our hybrid booting method is to adjust the suspicious score calculated by off-the-shelf AFL approach.
We record the suspicious score of each statement in each involved bug in our experiment in “location”.

The source code of our experiment is included in “HybridAFLSourceCode”. To evaluate the performance of our method, you only need to execute the main function of the file “experiment”. 
But please remember to configure the file paths first.

Our experiment tries to boost four SBFL algorithms, i.e., Ochiai, Jaccard, Dstar and Barinel. 
You could select which one you want to boost in lines 29-32 in “experiment.java”



D4jTypeList document: The statement type of each executed statement in each bug.

D4jTypeStatic document : The number of different types of statements in each D4j Project.

groundtruth document: The position of faulty statements in each bug.

location document: Suspicious scores calcualted by SBFL

HybridAFLSourceCode: The source code of our experiment. Please execute the main function of experiment.java