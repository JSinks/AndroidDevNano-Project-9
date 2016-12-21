package cool.superfcking.apps.habittracker.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import cool.superfcking.apps.habittracker.data.HabitContract.HabitEntry;


/**
 * Created by jsinclair on 21/12/16.
 */
public class HabitDbHelper extends SQLiteOpenHelper {

    private final static String DATABASE_NAME = "habits.db";
    private final static int DATABASE_VERSION = 1;

    public HabitDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_HABITS_TABLE = "CRATE TABLE " + HabitEntry.TABLE_NAME + " ("
                + HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HabitEntry.COLUMN_HABIT_NAME + " TEXT NOT NULL, "
                + HabitEntry.COLUMN_HABIT_REPEAT_COUNT + " INTEGER NOT NULL, "
                + HabitEntry.COLUMN_HABIT_DAY_OF_WEEK + " INTEGER NOT NULL);";

        db.execSQL(SQL_CREATE_HABITS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //No upgrade script as there are no versions to upgrade from/to
    }
}
