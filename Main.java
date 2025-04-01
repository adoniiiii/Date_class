import java.util.*;

class Date implements Comparable<Date> {
    int day, month, year;
    String months[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    String days[] = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public boolean isValidDate() {
        if (day < 1 || day > 31 || month < 1 || month > 12 || year < 1) {
            return false;
        }
        if (month == 2) {
            if (day > 29) {
                return false;
            }
            if (day == 29 && !(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))) {
                return false;
            }
        }
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            if (day > 30) {
                return false;
            }
        }
        return true;
    }

    public void updateDate(int d, int m, int y) {
        Date temp = new Date(d, m, y);
        if (temp.isValidDate()) {
            this.day = d;
            this.month = m;
            this.year = y;
            System.out.println("Date updated to: " + this);
        } else {
            System.out.println("Invalid date update request!");
        }
    }

    public void getDayOfWeek() {
        if (isValidDate()) {
            int monthDays[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
                monthDays[2] = 29;
            }
            int totalDays = day;
            for (int i = 1; i < month; i++) {
                totalDays += monthDays[i];
            }
            totalDays += (year - 1) * 365 + (year - 1) / 4 - (year - 1) / 100 + (year - 1) / 400;
            System.out.println("Day of the week: " + days[totalDays % 7]);
        } else {
            System.out.println("Invalid date");
        }
    }

    public void calculateDifference(Date other) {
        if (this.isValidDate() && other.isValidDate()) {
            Calendar cal1 = Calendar.getInstance();
            cal1.set(this.year, this.month - 1, this.day);
            Calendar cal2 = Calendar.getInstance();
            cal2.set(other.year, other.month - 1, other.day);

            long millisDiff = Math.abs(cal1.getTimeInMillis() - cal2.getTimeInMillis());
            long daysDiff = millisDiff / (24 * 60 * 60 * 1000);
            System.out.println("Difference between dates is " + daysDiff + " days");
        } else {
            System.out.println("One or both dates are invalid");
        }
    }

    public void printDate() {
        if (isValidDate()) {
            System.out.println(months[month - 1] + " " + day + ", " + year);
        } else {
            System.out.println("Invalid date");
        }
    }

    @Override
    public int compareTo(Date other) {
        if (this.year != other.year) {
            return this.year - other.year;
        }
        if (this.month != other.month) {
            return this.month - other.month;
        }
        return this.day - other.day;
    }

    public static void sortDates(List<Date> dates) {
        Collections.sort(dates);
    }

    @Override
    public String toString() {
        return day + "." + month + "." + year;
    }
}

public class DateStructure2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Date> dates = new ArrayList<>();
        
        while (true) {
            System.out.println("Enter a date in format dd mm yyyy:");
            int day = input.nextInt();
            int month = input.nextInt();
            int year = input.nextInt();
            
            Date date = new Date(day, month, year);
            if (!date.isValidDate()) {
                System.out.println("Invalid date! Please enter again.");
                continue;
            }
            
            System.out.println("Is this date valid? " + date.isValidDate());
            date.getDayOfWeek();
            date.printDate();
            
            System.out.println("Enter another date to calculate difference:");
            int d2 = input.nextInt();
            int m2 = input.nextInt();
            int y2 = input.nextInt();
            
            Date date2 = new Date(d2, m2, y2);
            if (!date2.isValidDate()) {
                System.out.println("Invalid second date!");
                continue;
            }
            date.calculateDifference(date2);
            
            dates.add(date);
            dates.add(date2);
            
            System.out.println("Would you like to update the first date? (yes/no)");
            String updateChoice = input.next();
            if (updateChoice.equalsIgnoreCase("yes")) {
                System.out.println("Enter new date in format dd mm yyyy:");
                int newDay = input.nextInt();
                int newMonth = input.nextInt();
                int newYear = input.nextInt();
                date.updateDate(newDay, newMonth, newYear);
            }
            
            System.out.println("Sorted dates:");
            Date.sortDates(dates);
            for (Date d : dates) {
                d.printDate();
            }
            
            break;
        }
        input.close();
    }
}