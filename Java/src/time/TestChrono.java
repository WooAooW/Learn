package time;

import java.time.chrono.HijrahDate;
import java.time.chrono.JapaneseDate;
import java.time.chrono.MinguoDate;
import java.time.chrono.ThaiBuddhistDate;

public class TestChrono {

    public static void main(String[] args) {
        MinguoDate minguoDate = MinguoDate.now();
        System.out.println(minguoDate);
        
        JapaneseDate japaneseDate = JapaneseDate.now();
        System.out.println(japaneseDate);
        
        HijrahDate hijrahDate = HijrahDate.now();
        System.out.println(hijrahDate);
        
        ThaiBuddhistDate thaiBuddhistDate = ThaiBuddhistDate.now();
        System.out.println(thaiBuddhistDate);
    }
}
