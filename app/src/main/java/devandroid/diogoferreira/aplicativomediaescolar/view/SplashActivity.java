package devandroid.diogoferreira.aplicativomediaescolar.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import devandroid.diogoferreira.aplicativomediaescolar.R;
import devandroid.diogoferreira.aplicativomediaescolar.database.AlunoDB;

public class SplashActivity extends AppCompatActivity {

    public static final int TIME_OUT_SPLASH = 10000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        contarTelaSplash();
    }

    private void contarTelaSplash() {
        new Handler().postDelayed(() -> {

            AlunoDB db = new AlunoDB(SplashActivity.this);

            Intent TelaPrincipal = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(TelaPrincipal);
            finish();
        },TIME_OUT_SPLASH);
    }

}