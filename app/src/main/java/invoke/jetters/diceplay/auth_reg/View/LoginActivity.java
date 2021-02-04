package invoke.jetters.diceplay.auth_reg.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;

import invoke.jetters.diceplay.R;
import invoke.jetters.diceplay.auth_reg.Model.User;
import invoke.jetters.diceplay.auth_reg.Presenter.AuthRegPresenter;

public class LoginActivity extends AppCompatActivity {

    private EditText login;
    private EditText password;

    private AuthRegPresenter authRegPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        login = findViewById(R.id.login);
        password = findViewById(R.id.password);

        Button authorization = findViewById(R.id.login_button);
        Button registration = findViewById(R.id.sign_up_button);


        try {
            authRegPresenter = new AuthRegPresenter();
        } catch (IOException e) {
            e.printStackTrace();
        }

        authorization.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    authRegPresenter.sendRequestToLogin(new User(login.getText().toString(), password.getText().toString()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    authRegPresenter.sendRequestToRegistration(new User(login.getText().toString(), password.getText().toString()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}


