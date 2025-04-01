# Date_class

## Project Overview
This project focused on Date Handling in Java. It demonstrates date validation, manipulation, and sorting using Java. And includes functionalities for:
- Validating the correctness of a given date, including leap year checks.
- Printing the day of the week for a given date.
- Calculating the difference in days between two dates.
- Updating a date with user input.
- Printing the date in a formatted way.
- Sorting a list of dates in ascending order.

## Compilation and Execution
To run the program, you will need: 
1. Java Development Kit (JDK) installed on your system.
2. Save the code as `Main.java`
3. Compile code using the command:
```bash
javac Main.java
```
4. Start the program, and you will be prompted to enter the initial date.

## Example Outputs
### Example 1: 
```
Enter a date in format dd mm yyyy:
12 12 2012
Is this date valid? true
Day of the week: Wednesday
December 12, 2012
Enter another date to calculate difference:
01 01 1999
Difference between dates is 5093 days
Would you like to update the first date? (yes/no)
no
Sorted dates:
January 1, 1999
December 12, 2012
```
![image](https://github.com/user-attachments/assets/ff798014-5e58-43fa-bac0-e710b1eec708)
### Example 2:
```
Enter a date in format dd mm yyyy:
20 03 2006
Is this date valid? true
Day of the week: Monday 
March 20, 2006
Enter another date to calculate difference:
14 09 2025
Difference between dates is 7118 days
Would you like to update the first date? (yes/no)
yes
Enter new date in format dd mm yyyy:
21 03 2006
Date updated to: 21.3.2006
Sorted dates:
March 21, 2006
September 14, 2025
```
![image](https://github.com/user-attachments/assets/d6d87b88-41e0-41ba-8ce2-4f4d047a7882)
### Example 3 (of invalid date):
```
Enter a date in format dd mm yyyy:
20 20 2020
Invalid date! Please enter again. 
Enter a date in format dd mm yyyy:
20 02 2020
Is this date valid? true
```
![image](https://github.com/user-attachments/assets/59ff3d14-720c-4846-8c3d-e0f7d71b4dfb)

## Additional Notes
* The program enforces a strict dd mm yyyy input format.
* If an invalid date is entered, the user is prompted to enter a valid one.
* Leap year logic is correctly handled.
* Sorting is implemented using Comparable for natural ordering.
  
## Challenges Faced
-Implementing an efficient date validation system.
-Handling incorrect user inputs gracefully.
-Ensuring correct calculations for leap years and different month lengths.
