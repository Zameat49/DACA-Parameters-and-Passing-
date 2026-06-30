 # Lab 07 - DACA + Parameters and Passing

_Learning Objectives: Demonstrate an understanding of how to create static methods. Demonstrate an understanding of how to use static methods with parameters and return types._

**Lab Prompt**

In previous labs you worked with the Employment Authorization Card to create appropriate variables and format output. Now you get to significantly improve your program by creating static methods and variables.

Before you start writing your code for a method, take a moment to think about this: without clear and concise documentation, we have only the java code itself. Since we want both programmers and colleagues who do not program to be able to use our software, we need to _document our code_. This means including special comments that describe what the program and methods do. Each method you write should have a description and other useful information on how to use it just above the method header.

_Note:_ There are additional files in this lab.  **Only write code in the [Main.java](./Main.java) file.** You can ignore [UtilityBelt.java](./UtilityBelt.java) until you reach Part 2

## Lab Instructions: Part 1 ##

1. Write the static method `formatCard`

   A previous intern has given you the most recent version of the program.
   1. make all the `final` variables `static` 
   2. move them to the correct place in the code based on the OLI topic reading. 
   3. Write a method that returns a `String` with the Employment Authorization Card, formatting all data correctly. Be careful to use the following method header here so the tests run correctly.

	```java
    public static String formatCard(String surname, String givenName,
        String category, String cardNum, String birthCountry, 
        String termsAndConditions, char sex, String uscisNum, 
        String dateOfBirth, String validDate, String expireDate)
    ```
    **Copy from the provided code, no need to rewrite everything!**


2. Write the static method `formatDate`
    
    Notice that `validDate` and `expireDate` have the same formatting! Instead of writing the same code twice, create a method with parameters that will return a `String` of the formatted date. 

	```java
    public static String formatDate(int month, int day, int year)
    ```

3.  Call the methods in `main` and run to test your work. You should get the same output as *Lab 5 - DACA + Formatted Output*.


4. Unit Tests

    After you finish debugging, it's time to run tests. 
    
    The tests provided are different than in prior labs and the error messages are more difficult to understand.  If you need help interpretting the console messages, raise your hand or call over an instructor/TA.

## Lab Instructions: Part 2 ##

Now it really gets interesting!  A class called [`UtilityBelt`](./UtilityBelt.java) is provided to you for getting console input. This will really test your ability to call methods! The code inside each method is far beyond what we've covered in class, we're actually going to build it in the second to last topic of the semester!

For each variable in your `main` method, invoke the appropriate method from `UtilityBelt` to get user input. The method headers from `UtilityBelt` are listed below, and the file provides documentation on what each parameter and return means.

```java
	public static int readInt(String prompt, int lower, int upper)
	public static double readDouble(String prompt, double lower, double upper)
	public static char readChar(String prompt, String validChars)
	public static String readString(String prompt, int lower, int upper)
```

### UML Class Diagram
| UtilityBelt |
|-------------|
| - private static Scanner keyboard |
|  - public static int readInt(String prompt, int lower, int upper)<br> - public static double readDouble(String prompt, double lower, double upper)<br> - public static char readChar(String prompt, String validChars)<br> - public static String readString(String prompt, int lower, int upper) |