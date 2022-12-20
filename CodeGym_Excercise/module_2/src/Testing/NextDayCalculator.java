package Testing;

public class NextDayCalculator {
    public static boolean isLeapYear(int year){
        if(year % 4 == 0){
            if(year % 100 == 0){
                return year % 400 == 0;
            }else return true;
        }else return false;
    }
    public static int[] NextDay(int day, int month, int year){
        int[] dayInYear = new int[3];
        int lastDay = 0;
        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                lastDay = 31;
                break;
            case 2:
                if (NextDayCalculator.isLeapYear(year)){
                    lastDay =29;
                    break;
                }else
                    lastDay = 28;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                    lastDay = 30;
                    break;
        }
        if (day == lastDay) {
            dayInYear[0] = 1;
            if (month == 12){
                dayInYear[1] = 1;
                dayInYear[2] = year +1;
            }else{
                dayInYear[1] = month + 1;
                dayInYear[2] = year;
            }
        }else{
            dayInYear[0] = day + 1;
            dayInYear[1] = month;
            dayInYear[2] = year;
        }
        return dayInYear;
    }
}
