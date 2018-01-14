package juraj.podgajski.com.telephone;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_SMS_SEND_CODE = 1;
    private static final int REQUEST_CALL_PHONE_CODE = 2;
    private EditText etNumber, etText;
    private Button bPrepareSms, bSendSms, bDial, bCall;
    private final String TEL_URI = "tel:";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitWidgets();

        SetupListeners();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_SMS_SEND_CODE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(MainActivity.this, "SMS Permission Granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "SMS Permission Not Granted", Toast.LENGTH_SHORT).show();
                }
            }
            case REQUEST_CALL_PHONE_CODE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    String telNumber = TEL_URI + etNumber.getText().toString().trim();
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(telNumber));
                    if (checkCallPermission()) {
                        startActivity(intent);
                    }
                } else {
                    Toast.makeText(MainActivity.this, "CALL Permission Not Granted", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private void SetupListeners() {
        bPrepareSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hasNumber() && hasText()) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.putExtra("address", etNumber.getText().toString());
                    intent.putExtra("sms_body", etText.getText().toString());
                    intent.setType("vnd.android-dir/mms-sms");
                    try {
                        startActivity(intent);
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, "Nema native aplikacije", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        bSendSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (hasNumber() && hasText()) {
                    if (checkSendSmsPermission()) {
                        SmsManager smsManager = SmsManager.getDefault();
                        smsManager.sendTextMessage(etNumber.getText().toString(), null, etText.getText().toString(), null, null);
                        Toast.makeText(MainActivity.this, "Sms Successfully Sent", Toast.LENGTH_SHORT).show();
                        etNumber.setText("");
                        etText.setText("");
                    }
                }

            }
        });

        bDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hasNumber()) {
                    String telNumber = TEL_URI + etNumber.getText().toString().trim();
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(telNumber));
                    startActivity(intent);
                }
            }
        });

        bCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hasNumber()) {
                    String telNumber = TEL_URI + etNumber.getText().toString().trim();
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(telNumber));
                    if (checkCallPermission()) {
                        startActivity(intent);
                    }
                }
            }
        });
    }

    private boolean checkSendSmsPermission() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, REQUEST_SMS_SEND_CODE);
            return false;
        }
    }

    private boolean checkCallPermission() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL_PHONE_CODE);
            return false;
        }
    }

    private boolean hasText() {
        if (etText.getText().toString().trim().length() == 0) {
            Toast.makeText(MainActivity.this, "Unesite poruku", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private boolean hasNumber() {
        if (etNumber.getText().length() == 0) {
            etNumber.requestFocus();
            Toast.makeText(this, "Unesite broj telefona", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private void InitWidgets() {
        etNumber = (EditText) findViewById(R.id.etNumber);
        etText = (EditText) findViewById(R.id.etText);
        bPrepareSms = (Button) findViewById(R.id.bPrepareSms);
        bSendSms = (Button) findViewById(R.id.bSendSms);
        bDial = (Button) findViewById(R.id.bDial);
        bCall = (Button) findViewById(R.id.bCall);
    }
}
