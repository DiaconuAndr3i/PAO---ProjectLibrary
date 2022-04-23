package com.springboot.system.Library.utilities;

public final class infoLoanDays {
    private static final Integer maxBorrowedDays;
    private static final Integer maxNumberOfCopies;

    static {
        maxBorrowedDays = 21;
        maxNumberOfCopies = 3;
    }

    public static Integer getMaxBorrowedDays(){
        return maxBorrowedDays;
    }

    public static Integer getMaxNumberOfCopies(){
        return maxNumberOfCopies;
    }
}
