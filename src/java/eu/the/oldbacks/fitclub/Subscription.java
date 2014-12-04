package eu.the.oldbacks.fitclub;

import java.util.Date;
import org.apache.commons.lang3.time.DateUtils;

/**
 *
 * @author Stefano
 */
public class Subscription {
    public final static int 
            TEST            = 0,
            ANNUAL          = 1,
            ANNUALPLUSONE   = 2,
            HALFYEARLY      = 3,
            QUARTERLY       = 4,
            MONTHLY         = 5;
    
    private final int type;
    private final Date start;
    private final Date end;

    private Subscription(int type, Date start, Date end) {
        this.type = type;
        this.start = start;
        this.end = end;
    }
    
    public static Subscription annualPlusOne() {
        return annualPlusOne(new Date(System.currentTimeMillis()));
    }
    public static Subscription annualPlusOne(Date start) {
        if ( start == null ) throw new NullPointerException("Date start is null");
        return new Subscription(ANNUALPLUSONE, start, DateUtils.addMonths(start, 13));
    }
    public static Subscription annual() {
        return annual(new Date(System.currentTimeMillis()));
    }
    public static Subscription annual(Date start) {
        if ( start == null ) throw new NullPointerException("Date start is null");
        return new Subscription(ANNUAL, start, DateUtils.addMonths(start, 12));
    }
    public static Subscription halfyearly() {
        return halfyearly(new Date(System.currentTimeMillis()));
    }
    public static Subscription halfyearly(Date start) {
        if ( start == null ) throw new NullPointerException("Date start is null");
        return new Subscription(HALFYEARLY, start, DateUtils.addMonths(start, 6));
    }
    public static Subscription quarterly() {
        return quarterly(new Date(System.currentTimeMillis()));
    }
    public static Subscription quarterly(Date start) {
        if ( start == null ) throw new NullPointerException("Date start is null");
        return new Subscription(QUARTERLY, start, DateUtils.addMonths(start, 1));
    }
    public static Subscription monthly() {
        return monthly(new Date(System.currentTimeMillis()));
    }
    public static Subscription monthly(Date start) {
        if ( start == null ) throw new NullPointerException("Date start is null");
        return new Subscription(MONTHLY, start, DateUtils.addMonths(start, 1));
    }
    public static Subscription test() {
        return test(new Date(System.currentTimeMillis()));
    }
    public static Subscription test(Date start) {
        if ( start == null ) throw new NullPointerException("Date start is null");
        return new Subscription(TEST, start, DateUtils.addDays(start, 7));
    }
    
    public boolean isTest() {
        return TEST == type;
    }
}
