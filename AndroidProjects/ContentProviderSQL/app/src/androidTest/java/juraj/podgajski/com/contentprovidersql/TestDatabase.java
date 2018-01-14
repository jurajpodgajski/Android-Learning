package juraj.podgajski.com.contentprovidersql;

import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;

import java.util.HashSet;

import juraj.podgajski.com.contentprovidersql.data.AppDatabase;
import juraj.podgajski.com.contentprovidersql.data.TasksContract;

/**
 * Created by jurajdnd on 25/10/2017.
 */

public class TestDatabase extends AndroidTestCase {

    public void testCreateDb() {

        final HashSet<String> tableHashSet = new HashSet<>();
        tableHashSet.add(TasksContract.TABLE_NAME);
        mContext.deleteDatabase(AppDatabase.DATABASE_NAME);

        SQLiteDatabase database = new AppDatabase(this.mContext).getWritableDatabase();

        assertEquals(true, database.isOpen());

    }

}
