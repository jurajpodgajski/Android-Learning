package juraj.podgajski.com.chucknorrisjoketeller;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import juraj.podgajski.com.chucknorrisjoketeller.model.Joke;

public class MainActivity extends AppCompatActivity {

    private final String JOKES_ENDPOINT = "http://api.icndb.com/jokes/random/3";

    private Button bGenerate;
    private TextView tvJokes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bGenerate = (Button) findViewById(R.id.bGenerate);
        tvJokes = (TextView) findViewById(R.id.tvJokes);

        bGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FetchData fetchData = new FetchData();
                fetchData.execute(JOKES_ENDPOINT);
            }
        });
    }

    private class FetchData extends AsyncTask<String, Void, List<Joke>> {

        @Override
        protected List<Joke> doInBackground(String... strings) {
            if (strings.length < 1 || strings[0] == null) {
                return null;
            }
            String stringURL = strings[0];
            URL url = createUrl(stringURL);

            String response = makeHTTPRequest(url);
            List<Joke> jokes = getJokesFromResponse(response);
            return jokes;
        }

        @Override
        protected void onPostExecute(List<Joke> jokes) {

            StringBuilder stringBuilder = new StringBuilder();
            for (Joke joke : jokes) {
                String jokeStr = joke.getJoke();
                stringBuilder.append(jokeStr + "\n\n");
            }
            tvJokes.setText(stringBuilder.toString());

        }

        private List<Joke> getJokesFromResponse(String response) {
            List<Joke> jokes = new ArrayList<>();

            if (TextUtils.isEmpty(response)) {
                return null;
            }
            try {
                JSONObject baseResponse = new JSONObject(response);
                JSONArray jsonArray = baseResponse.getJSONArray("value");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jokeJson = jsonArray.getJSONObject(i);
                    String jokeString = jokeJson.getString("joke");
                    Joke joke = new Joke(i, jokeString);
                    jokes.add(joke);

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jokes;
        }

        private String makeHTTPRequest(URL url) {

            String jsonResponse = "";
            HttpURLConnection httpURLConnection = null;
            InputStream inputStream = null;

            try {
                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setReadTimeout(2000);
                httpURLConnection.setConnectTimeout(2000);
                httpURLConnection.connect();

            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (httpURLConnection.getResponseCode() == 200) {
                    inputStream = httpURLConnection.getInputStream();
                    jsonResponse = readFromStream(inputStream);

                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            return jsonResponse;
        }

        private String readFromStream(InputStream inputStream) throws IOException {

            StringBuilder stringBuilder = new StringBuilder();
            if (inputStream != null) {

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
                String line = bufferedReader.readLine();
                while (line != null) {

                    stringBuilder.append(line);
                    line = bufferedReader.readLine();

                }
            }

            return stringBuilder.toString();

        }

        private URL createUrl(String stringURL) {

            URL url = null;

            try {
                url = new URL(stringURL);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            return url;
        }
    }
}