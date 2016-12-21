package cool.superfcking.apps.habittracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;

import cool.superfcking.apps.habittracker.data.HabitContract.HabitEntry;
import cool.superfcking.apps.habittracker.data.HabitDbHelper;

/**
 * Created by jsinclair on 21/12/16.
 */
public class HabitTracker extends AppCompatActivity {

    private HabitDbHelper mDbHelper;

    public HabitTracker(){

        mDbHelper = new HabitDbHelper(this);
    }

    public void insertHabit(){
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(HabitEntry.COLUMN_HABIT_NAME, "Picking nose");
        values.put(HabitEntry.COLUMN_HABIT_REPEAT_COUNT, 9000);
        values.put(HabitEntry.COLUMN_HABIT_DAY_OF_WEEK, HabitEntry.DAY_THURSDAY);

        db.insert(HabitEntry.TABLE_NAME, null, values);
    }

    public Cursor getHabits(){
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] projections = {
                HabitEntry.COLUMN_HABIT_NAME,
                HabitEntry.COLUMN_HABIT_REPEAT_COUNT,
                HabitEntry.COLUMN_HABIT_DAY_OF_WEEK
        };

        String sortOrder = HabitEntry.COLUMN_HABIT_NAME;

        Cursor cursor = db.query(HabitEntry.TABLE_NAME, projections, null, null, null, null, sortOrder);

        return cursor;

    }
}

