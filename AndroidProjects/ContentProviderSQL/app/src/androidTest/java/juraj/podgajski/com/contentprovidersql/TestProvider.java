package juraj.podgajski.com.contentprovidersql;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.test.AndroidTestCase;

import juraj.podgajski.com.contentprovidersql.data.TasksContract;

/**
 * Created by jurajdnd on 25/10/2017.
 */

public class TestProvider extends AndroidTestCase {

    public void testInsert() {

        ContentValues values = new ContentValues();
        values.put(TasksContract.Colums.TASKS_NAME, "task 1");
        values.put(TasksContract.Colums.TASKS_DESCRIPTION, "description 1");

        Uri uri = mContext.getContentResolver().insert(TasksContract.CONTENT_URI, values);

        assertTrue("Test failed because Uri is null", uri != null);

    }

    public void testUpdate() {

        ContentValues values = new ContentValues();
        values.put(TasksContract.Colums.TASKS_NAME, "task 1");
        values.put(TasksContract.Colums.TASKS_DESCRIPTION, "description 1");

        int count = mContext.getContentResolver().update(TasksContract.CONTENT_URI, values, null, null);

        assertTrue("There was no Updates", count > 0);

    }

    public void testDelete() {

        mContext.getContentResolver().delete(TasksContract.CONTENT_URI, null, null);

        Cursor results = mContext.getContentResolver().query(TasksContract.CONTENT_URI, null, null, null, null);

        assertEquals("There is something left in the DB", 0, results.getCount());

    }

    public void testQuery() {

        Cursor cursor = mContext.getContentResolver().query(TasksContract.CONTENT_URI, null, null, null, null, null);

        assertTrue(cursor.moveToFirst());

    }

}
