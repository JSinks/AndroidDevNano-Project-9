package cool.superfcking.apps.habittracker.data;

import android.provider.BaseColumns;

public final class HabitContract {

    public static class HabitEntry implements BaseColumns {
        public static final String TABLE_NAME = "habits";

        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_HABIT_NAME = "habit_name";
        public static final String COLUMN_HABIT_REPEAT_COUNT = "number_of_times";
        public static final String COLUMN_HABIT_DAY_OF_WEEK = "day_of_week";

        public static final int DAY_MONDAY = 0;
        public static final int DAY_TUESDAY = 1;
        public static final int DAY_WEDNESDAY = 2;
        public static final int DAY_THURSDAY = 3;
        public static final int DAY_FRIDAY = 4;
        public static final int DAY_SATURDAY = 5;
        public static final int DAY_SUNDAY = 5;

    }
}
