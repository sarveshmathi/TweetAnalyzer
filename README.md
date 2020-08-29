# TweetAnalyzer

In this assignment, we applied the design principles and design patterns that we recently 
covered in class to develop a Java application to read text files as input and perform some analysis.

Learning objectives:
* Design a software system using an N-tier architecture
* Design software using the principles of modularity, functional independence, and
abstraction
* Apply the Singleton design pattern
* Use a Java library to read data stored in a JSON file

Full details of the project and functionaility of the program can be found in **Module-11-Programming-Assignment.pdf**.

**Summary**: 

Government agencies such as the Centers for Disease Control can use social media information to 
get an understanding of the spread of infectious disease. By analyzing the use of words and expressions 
that appear over time on platforms such as Twitter, Facebook, etc., it is possible to estimate where 
the disease is affecting people and whether it is spreading or appears to be contained.

In this assignment, we designed and developed an application that analyzes a small set of Twitter data to look 
for tweets regarding occurrences of the flu and determines the US states in which these tweets occur.

**Runtime arguments**: 

The runtime arguments to the program should specify, in this order:
* the format of the tweets input file
* the name of the tweets input file
* the name of the states input file
* the name of the log file (for logging debug information)

When the program finishes looking for “flu tweets” and determining their locations, it will print the number of “flu tweets” per state to the console.
