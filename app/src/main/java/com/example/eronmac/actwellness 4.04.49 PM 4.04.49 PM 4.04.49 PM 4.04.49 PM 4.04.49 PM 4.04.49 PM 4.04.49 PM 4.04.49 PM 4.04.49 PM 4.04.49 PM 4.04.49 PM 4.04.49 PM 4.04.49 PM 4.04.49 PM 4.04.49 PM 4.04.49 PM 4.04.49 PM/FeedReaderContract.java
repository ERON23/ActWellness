package com.example.eronmac.actwellness;

import android.provider.BaseColumns;

public final class FeedReaderContract {

    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private FeedReaderContract() {}

    /* Inner class that defines the table contents */
    public static class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "goodnite";
        public static final String COL_WHEN = "whentime";
        public static final String COL_WHAT = "what";
    }

}


