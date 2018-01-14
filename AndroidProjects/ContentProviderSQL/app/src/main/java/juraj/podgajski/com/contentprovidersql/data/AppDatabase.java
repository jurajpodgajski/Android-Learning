package juraj.podgajski.com.contentprovidersql.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AppDatabase extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Tasks.db";
    public static final int DATABASE_VERSION = 1;

    private static AppDatabase instance = null;

    public AppDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    static AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = new AppDatabase(context);
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE " + TasksContract.TABLE_NAME
                + " (" + TasksContract.Colums._ID
                + " INTEGER PRIMARY KEY NOT NULL, "
                + TasksContract.Colums.TASKS_NAME + " TEXT NOT NULL, "
                + TasksContract.Colums.TASKS_DESCRIPTION + " TEXT);";

        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        switch (oldVersion) {

            case 1:
                // Upgrade logic 1
                break;

            case 2:
                // Upgrade logic 2
                break;

            default:
                throw new IllegalStateException("Problems with 'OnUpgrade'");

        }

    }
}
