package juraj.podgajski.com.contentprovidersql.data;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

public class TasksContract {

    public static final String TABLE_NAME = "Tasks";

    public static class Colums {

        public static final String _ID = BaseColumns._ID;
        public static final String TASKS_NAME = "Name";
        public static final String TASKS_DESCRIPTION = "Description";
        public static final String TASKS_ORDER = "Order";

        private Colums() {
        }
    }

    // CONTENT_AUTHORITY je naziv naseg CONTENT PROVIDERA
    static final String CONTENT_AUTHORITY = "juraj.podgajski.com.contentprovidersql";

    static final Uri CONTENT_AUTHORITY_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    // Putanja za pristup tablici Tasks
    public static final Uri CONTENT_URI = Uri.withAppendedPath(CONTENT_AUTHORITY_URI, TABLE_NAME);

    static Uri buildTaskUri(long taskId) {
        return ContentUris.withAppendedId(CONTENT_URI, taskId);
    }

    static long getTaskId(Uri uri) {
        return ContentUris.parseId(uri);
    }
}
