package kristijan.kraupner.com.servisi;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import android.widget.Toast;


public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("MyIntentService");
    }

    private Handler handler = new Handler();

    @Override
    protected void onHandleIntent(Intent intent) {          // ova se metoda prva izvršava, worker/background thread
        if (intent != null) {
            int taskCount = intent.getIntExtra(MainActivity.TASK_COUNT,0);

            for (int i = 0; i<taskCount; i++) {
                performBackgroundTask();
                int progress = (int) ((i + 1) / (double) taskCount * 100);
                showProgress(progress);
            }
        }
    }

    private void showProgress(final int progress) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                String progressMessage = progress + "% izvrseno";
                Toast.makeText(getApplicationContext(), progressMessage, Toast.LENGTH_SHORT).show();
                        //umjesto MyIntentService.this koristiti getApplicationContext()
                        // zato što servis može biti trznut i iz neke druge aplikacije i u različitim stanjima
            }
        });
    }


    private void performBackgroundTask() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
