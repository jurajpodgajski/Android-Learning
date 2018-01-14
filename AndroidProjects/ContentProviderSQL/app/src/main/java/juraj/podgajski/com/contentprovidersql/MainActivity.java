package juraj.podgajski.com.contentprovidersql;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import juraj.podgajski.com.contentprovidersql.data.TasksContract;

public class MainActivity extends AppCompatActivity {

    private EditText etTaskName, etTaskDescription;
    private ListView lvResults;
    private Button bInsert, bUpdate, bDelete;
    private SwipeRefreshLayout srlSwipe;

    // handles
    private SimpleCursorAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitWidgets();

        SetupListeners();


    }

    private void SetupListeners() {
        bInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ContentValues values = new ContentValues();
                values.put(TasksContract.Colums.TASKS_NAME, etTaskName.getText().toString().trim());
                values.put(TasksContract.Colums.TASKS_DESCRIPTION, etTaskDescription.getText().toString().trim());
                getContentResolver().insert(TasksContract.CONTENT_URI, values);

            }
        });
        bUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ContentValues values = new ContentValues();
                values.put(TasksContract.Colums.TASKS_NAME, etTaskName.getText().toString().trim());
                values.put(TasksContract.Colums.TASKS_DESCRIPTION, etTaskDescription.getText().toString().trim());
                String selection = TasksContract.Colums.TASKS_NAME + " = ? ";
                String[] selArg = {etTaskName.getText().toString().trim()};
                getContentResolver().update(TasksContract.CONTENT_URI, values, selection, selArg);


            }
        });
        bDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        srlSwipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // coursour treba porvijeriti sa if() jer moze vratiti null
                Cursor results = getContentResolver().query(TasksContract.CONTENT_URI, null, null, null, null);

                String[] fromColumns = {TasksContract.Colums.TASKS_DESCRIPTION};
                int[] toViews = {android.R.id.text1};

                adapter = new SimpleCursorAdapter(MainActivity.this, android.R.layout.simple_list_item_1, results, fromColumns, toViews, 0);
                lvResults.setAdapter(adapter);

                srlSwipe.setRefreshing(false);
            }
        });

        lvResults.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String taskId = "/" + id;
                getContentResolver().delete(Uri.parse(TasksContract.CONTENT_URI + taskId), null, null);

            }
        });
    }

    private void InitWidgets() {
        etTaskName = (EditText) findViewById(R.id.etTaskName);
        etTaskDescription = (EditText) findViewById(R.id.etTaskDescription);
        lvResults = (ListView) findViewById(R.id.lvResults);
        bDelete = (Button) findViewById(R.id.bDelete);
        bInsert = (Button) findViewById(R.id.bInsert);
        bUpdate = (Button) findViewById(R.id.bUpdate);
        srlSwipe = (SwipeRefreshLayout) findViewById(R.id.srlSwipe);
    }
}
