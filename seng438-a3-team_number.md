**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report #3 – Code Coverage, Adequacy Criteria and Test Case Correlation**

| Group \#:      |    19    |
| -------------- | -------- |
| Student Names: |          |
| Andrew Duong   | 30139573 |
| Ethan Bensler  | 30140326 |
| Joseph Duong   | 30145210 |
| Liam Brennan   | 30142832 |

(Note that some labs require individual reports while others require one report
for each group. Please see each lab document for details.)

# 1 Introduction

This assignment aims to familiarize students with the assessment of white-box test suite adequacy through code coverage. White-box testing evaluates test suite effectiveness by the extent of code exercised. Various coverage criteria such as statement, decision, condition, path, and data-flow coverage are explored. By completing the assignment, students will learn to utilize code coverage tools, enhance code coverage through test case design, grasp the advantages and limitations of code coverage assessment, and comprehend data-flow coverage principles, including manual calculation techniques.

# 2 Manual data-flow coverage calculations for X and Y methods

Below is the Data Flow Diagram for the getUpperBound method of the Range class:

![RangeDFG-SENG-401 drawio (1)](https://github.com/seng438-winter-2024/seng438-a3-Ruvaakaan/assets/95046408/59f4b231-18f5-4bd2-9866-5d255f8f6376)

def-use sets per statement:

|   statement    |    definition    |    use    |
| -------------- | -------- | -------- |
| public double getLowerBound() | lower, upper | none |
| if (lower > upper)   | none | lower, upper |
| String msg = "Range(double, double): require lower (" + lower+ ") <= upper (" + upper + ")." | msg | lower, upper |
| return this.lower | none | lower |

du-pairs per variable:

|   variable   |    du-pairs    |
| -------------- | -------- | 
| lower | (1,2), (1,3), (1,4) |
| upper   | (1,2), (1,3) |
| msg | (3,_) |

du-pairs covered per test-case:

|   test-case   |      lower | upper | msg | 
| -------------- | -------- | ---- | ----- |
| testLowerBoundJustBelowMaximum() | (1,2), (1,4) | (1,2) | none | 
| testLowerBoundAtMinimum()   | (1,2), (1,4) | (1,2) | none | 
| testInvalidLowerBoundNaN() | (1,2), (1,4) | (1,2) | none | 
| testLowerBoundJustAboveMinimum() | (1,2), (1,4) | (1,2) | none | 
| testValidLowerBound() | (1,2), (1,4) | (1,2) | none | 


du-pair coverage:

total number of unique du-pairs: 4 
number of covered du-pairs: 2 
du-pair coverage: ( 2 / 4 ) * 100% = 50%

|   total number of unique du-pairs   |      number of covered du-pairs |du-pair coverage | 
| -------------- | -------- | ---- | 
| 4 | 2 | ( 2 / 4 ) * 100% = 50% | 


# 3 A detailed description of the testing strategy for the new unit test

Text…

# 4 A high level description of five selected test cases you have designed using coverage information, and how they have increased code coverage

Text…

# 5 A detailed report of the coverage achieved of each class and method (a screen shot from the code cover results in green and red color would suffice)

Text…

# 6 Pros and Cons of coverage tools used and Metrics you report

We employed two code coverage tools: EclEmma and CodeCover. Initially, we intended to utilize CodeCover specifically for condition coverage analysis. However, CodeCover failed to provide condition coverage. Therefore, we opted to rely solely on EclEmma for reporting line coverage, branch coverage, and method coverage, substituting condition coverage with method coverage. 

# 7 A comparison on the advantages and disadvantages of requirements-based test generation and coverage-based test generation.

Requirements-based testing is centered on verifying that the project satisfies defined requirements and functions as intended. Although, it runs the risk of neglecting the system's internal structure or implementation specifics, potentially resulting in significant defects remaining undetected within the code. Conversely, coverage-based testing scrutinizes the code at a smaller level, enabling the detection of critical defects embedded within it. However, it may falter in testing system requirements comprehensively. This is why a combined approach, leveraging both techniques, is typically adopted to ensure thorough testing coverage.

# 8 A discussion on how the team work/effort was divided and managed

Similar to the previous project, Andrew and Joseph were responsible for anything related to the DataUtilities class, while Ethan and Liam were assigned tasks related to the Range class. All team members participated in testing the code coverage tools mentioned earlier and we all communicated with one another throughout the project. 

# 9 Any difficulties encountered, challenges overcome, and lessons learned from performing the lab

We encountered difficulties navigating the usage of the code coverage tools due to the lack of recent documentation for either testing tool. Additionally, locating the source code of the projects proved challenging initially, causing confusion. A significant obstacle arose from the fact that, for the previous assignment, our tests were organized into individual files. However, for this project, we needed to assess the total coverage for two separate classes. Therefore, we had to combine of all our test files into two distinct classes, which consumed considerable time and effort.

# 10 Comments/feedback on the lab itself

The lab provided valuable learning opportunities as outlined in the lab handout. Nonetheless, there is room for improvement, particularly in utilizing more up-to-date Integrated Development Environments (IDEs) and testing tools. Upgrading to newer IDEs and testing tools would enhance our workflow and productivity, ensuring a smoother and more efficient development process.
