# FineGrainedAFL
<Statement Types and Error Rates: How Are They Related and How Could They Boost Fault Localization>


Our paper involves two experiments: boosting SBFL and boosting MBFL.
  
Boosting MBFL:

The MBFL approach to be boosted in our experiment is MUSE form paper .
To avoid randomness caused by mutation, we directly utilized the suspicious score calculated in paper . Such MBFL suspicious scores are recorded in json file.

To evaluate our boosting performance, you only need to execute the main function of experiment.java

"MBFL" document: The source code of our experiment. You could directly execute the main function of experiment.java.

"llpjason" document: It contains the data of the suspicious scores calculated by MBFL approach and the statement type information.

"MBFLresult" document: It is the execution result of our experiment.
