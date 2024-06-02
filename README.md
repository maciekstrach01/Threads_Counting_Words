
#  Threads Counting Words

https://github.com/maciekstrach01/Threads_Counting_Words/assets/146733279/fc5f383e-7086-4772-8f6e-e1c0ab7950bd

WordCount is a program written in Java that is used to count words in a text file in parallel. The program enables efficient processing of large text files by taking advantage of multithreading. The user can specify the number of threads to be used when processing the file, allowing performance to be scaled depending on system resources.The program is configured with a pom.xml file that defines dependencies and compilation settings for the Maven tool. To build the project, run the mvn clean install command in the project's root directory.WordCount is an effective tool for processing large text files, which significantly reduces the time required for word counts by using multi-threading.
## Project structure

ParseError class from the org.example.enums package

![d](https://github.com/maciekstrach01/Threads_Counting_Words/assets/146733279/d56a8bb1-18a4-4016-8bb0-9cd3d83c1831)

An enumeration (enum) class containing error messages related to input arguments.

ArgumentParser class from the org.example package

![e](https://github.com/maciekstrach01/Threads_Counting_Words/assets/146733279/9d7adfcc-3cb7-458d-9f02-bad540b94b2d)

A class responsible for validating and processing input arguments.

ParallelCounter class from the org.example package

![f](https://github.com/maciekstrach01/Threads_Counting_Words/assets/146733279/e7f4360d-ca8b-4fbe-a69b-dec9d04cc9b8)

The class responsible for parallel processing of the file and word count.

ThreadsInvokeCounter class from the org.example package

![g](https://github.com/maciekstrach01/Threads_Counting_Words/assets/146733279/f3d79da7-786c-4173-8549-d3a1ff512444)

This class is used to track the number of thread calls in a program.

WordCount class from the org.example package
![h](https://github.com/maciekstrach01/Threads_Counting_Words/assets/146733279/9159d27d-9c2e-49f1-bbf0-e27869bd1741)

The main class of the program, responsible for initializing and starting the word count process.

The pom.xml file
![i](https://github.com/maciekstrach01/Threads_Counting_Words/assets/146733279/a641482d-166c-4207-a139-1a6cd12690f9)

Maven tool configuration file. It is in it that you will find all the instructions on how the final
be built the final .jar executable file.
## Features of the program

Parallel word counting: The program splits the processing of a text file into multiple threads, which speeds up the word count operation.

Validation of input arguments: The program checks whether the given arguments (thread count and file name) are correct, and displays appropriate error messages in case of invalid data.

Exception handling: The program manages exceptions that may occur during the processing of the file, ensuring the stability of operation.

Result reporting: When processing is complete, the program displays the number of occurrences of each word and statistics on thread usage.
## 🛠 Skills
Programming language: Java

Construction Management: Maven

Multithreading: Java ThreadPoolExecutor

Exception handling: Custom exceptions and argument validation


## Running Tests



1. Clone the repository from Github:

```
git clone https://github.com/maciekstrach01/Threads_Counting_Words
```

2. After downloading the code in the program's main folder, in your terminal, use the command 

```
mvn clean install

```
For example, this is what it looks like in my application

![a](https://github.com/maciekstrach01/Threads_Counting_Words/assets/146733279/ee13666a-8d6f-45d9-af42-55893ce5fb54)
3. Then navigate to the created target folder

```
cd target

```

4. Open terminal and run commands:

```
java -jar WordCount.jar <NUMBER_OF_THREADS> <FILE_NAME>

```
For example, if you want to use 5 threads and the file is named test.txt, the command would be:
```
java -jar WordCount.jar 5 ../src/test/java/test.txt

```

5. After these commands in terminal, it should look to you like the following

![b](https://github.com/maciekstrach01/Threads_Counting_Words/assets/146733279/46b188a9-57a2-46dd-8026-4264d54975f6)

