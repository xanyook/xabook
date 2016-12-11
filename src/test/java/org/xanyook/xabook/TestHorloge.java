package org.xanyook.xabook;

import org.junit.Test;

public class TestHorloge {

    private final int ANGLE_HOURS   = 360 / 12;
    private final int ANGLE_MINUTES = 360 / 60;
    private final int MAX_HOURS     = 12;
    private final int MAX_MINUTES   = 60;
    private final int MIN_VALUE     = 0;

    public int calculate(int hour, int minute) {

        System.out.printf( "testing : %s %s \n", hour, minute );

        if (( 12 < hour ) || ( 60 < minute )) {
            throw new IllegalArgumentException( "Wrong value" );
        }

        final int hourAngle = getHoursAngle( hour );
        final int minuteAngle = getMinuteAngle( minute );

        System.out.printf( "hours : %s \n", hourAngle );
        System.out.printf( "minutes : %s \n", minuteAngle );
        System.out.printf( " ----" );

        return Math.min( hourAngle, minuteAngle );
    }

    private int getHoursAngle(int hours) {

        int value = hours;
        if (MAX_HOURS == hours) {
            value = MIN_VALUE;
        }

        return value * ANGLE_HOURS;

    }

    private int getMinuteAngle(int minutes) {
        int value = minutes;
        if (MAX_MINUTES == minutes) {
            value = MIN_VALUE;
        }

        return value * ANGLE_MINUTES;
    }

    @Test
    public void testAngle() {
        System.out.println( calculate( 12, 15 ) );
        System.out.println( calculate( 12, 0 ) );
        System.out.println( calculate( 2, 0 ) );
        System.out.println( calculate( 12, 15 ) );
    }
}
