package org.xron.formatters;

/**
 *
 * @author ben
 */
public class TimeFormatter {

    public static void main(String[] args) {
        testFormatToHHMMSS();
    }

    public static String formatToHHMMSS(int secsIn) {
        int hours = secsIn / 3600,
                remainder = secsIn % 3600,
                minutes = remainder / 60,
                seconds = remainder % 60;

        return ((hours < 10 ? "0" : "") + hours + ":" + (minutes < 10 ? "0" : "") + minutes + ":" + (seconds < 10 ? "0" : "") + seconds);
    }

    public static void testFormatToHHMMSS(){
        System.out.println(TimeFormatter.formatToHHMMSS(5));
        System.out.println(TimeFormatter.formatToHHMMSS(60));
        System.out.println(TimeFormatter.formatToHHMMSS(65));
        System.out.println(TimeFormatter.formatToHHMMSS(3600));
        System.out.println(TimeFormatter.formatToHHMMSS(150));
        System.out.println(TimeFormatter.formatToHHMMSS(3750));
    }
}
