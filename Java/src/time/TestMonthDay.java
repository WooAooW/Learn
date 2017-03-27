package time;

import java.time.MonthDay;

public class TestMonthDay {

    public static void main(String[] args) {
        MonthDay day = MonthDay.now();
        System.out.println(day);
        System.out.println(day.getDayOfMonth());
    }
}
