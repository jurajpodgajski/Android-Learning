package kristijan.kraupner.com.servisi;

import android.app.Service;
import android.os.AsyncTask;
import android.widget.Toast;

/**
 * Created by kkraupne on 25/09/2017.
 */

public class BackgroundTask extends AsyncTask<Integer, Integer, String> {   //ne mogu se slati primitivi

    private Service service;

    public BackgroundTask(Service service) {
        this.service = service;
    }

    @Override
    protected String doInBackground(Integer... integers) {  //Integer... integers je prvi parametar iz <>; protected String je što metoda vraća
        //ovo je na worker threadu
        //Integer... integers - je zapravo polje
        // to je ono što se sa .execute() i šalje iz MyService

        int taskCount = integers[0];
        for (int i = 0; i < taskCount; i++) {
            performLongTask();
            publishProgress((int) ((i + 1) / (double) taskCount * 100));
        }
        String result = taskCount + " zadataka izvrseno";
        return result;                            // vrijednost koja se vraća kad je cijeli posao gotov
    }


    @Override
    protected void onProgressUpdate(Integer... values) {       // ovo je na UI threadu, Integer... values - to je drugi parametar u AsyncTask<>
        String message = values[0] + "% izvrseno";
        Toast.makeText(service, message, Toast.LENGTH_SHORT).show();
    }

    //ovo je finalna metoda koja izvodi završni posao - kada asynctask završi sa poslom, izvodi se ova metoda
    //kada servis završi posao mora se ubiti
    @Override
    protected void onPostExecute(String s) {            // ovo je string result iz doInBackgrounda return value
        Toast.makeText(service, s, Toast.LENGTH_SHORT).show();
        service.stopSelf();                             // obavezno se mora zaustaviti servis
    }

    private void performLongTask() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
