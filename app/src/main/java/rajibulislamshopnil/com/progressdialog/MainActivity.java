package rajibulislamshopnil.com.progressdialog;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.progressBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setProgressStyle(progressDialog.STYLE_HORIZONTAL);
                progressDialog.setTitle("Downloading");
                progressDialog.setMessage("Downloading ....");
                progressDialog.setIcon(R.mipmap.ic_launcher);
                progressDialog.setMax(100);
                progressDialog.setProgress(0);
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int progress = 0;
                        while (progress<= 100){

                            try {
                                progressDialog.setProgress(progress);
                                progress++;
                                Thread.sleep(200);


                            }catch (Exception ex){

                            }

                        }
                        progressDialog.dismiss();
                        MainActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, "Downloading completed ", Toast.LENGTH_SHORT).show();
                            }
                        });

                    }
                });
                t.start();
                progressDialog.show();


            }
        });


    }
}
