package cool.superfcking.apps.habittracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cool.superfcking.apps.habittracker.data.HabitContract;
import cool.superfcking.apps.habittracker.data.HabitDbHelper;

public class MainActivity extends AppCompatActivity {

    private HabitDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDbHelper = new HabitDbHelper(this);
    }

    public void insertHabit(){
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(HabitContract.HabitEntry.COLUMN_HABIT_NAME, "Doing something habitual");
        values.put(HabitContract.HabitEntry.COLUMN_HABIT_REPEAT_COUNT, 9000);
        values.put(HabitContract.HabitEntry.COLUMN_HABIT_DAY_OF_WEEK, HabitContract.HabitEntry.DAY_THURSDAY);

        db.insert(HabitContract.HabitEntry.TABLE_NAME, null, values);
    }

    public Cursor getHabits(){
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] projections = {
                HabitContract.HabitEntry.COLUMN_HABIT_NAME,
                HabitContract.HabitEntry.COLUMN_HABIT_REPEAT_COUNT,
                HabitContract.HabitEntry.COLUMN_HABIT_DAY_OF_WEEK
        };

        String sortOrder = HabitContract.HabitEntry.COLUMN_HABIT_NAME;

        Cursor cursor = db.query(HabitContract.HabitEntry.TABLE_NAME, projections, null, null, null, null, sortOrder);

        return cursor;

    }
}
