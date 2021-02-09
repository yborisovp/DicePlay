package invoke.jetters.diceplay.auth_reg.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOException;

import invoke.jetters.diceplay.R;
import invoke.jetters.diceplay.auth_reg.Model.User;
import invoke.jetters.diceplay.auth_reg.Presenter.AuthRegPresenter;

public class LoginActivity extends AppCompatActivity {

    private EditText login;
    private EditText password;
    private TextView wrongPassword;
    private TextView wrongLogin;
    private Button forgotPassword;

    private AuthRegPresenter authRegPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);

        login = (EditText) findViewById(R.id.login);
        password = (EditText)findViewById(R.id.password);
        wrongPassword = (TextView) findViewById(R.id.wrong_password);
        wrongLogin = (TextView) findViewById(R.id.wrong_login);

        Button authorization = (Button)findViewById(R.id.login_button);
        Button registration = (Button)findViewById(R.id.sign_up_button);
        forgotPassword = (Button) findViewById(R.id.forgot_password);

        try {
            authRegPresenter = new AuthRegPresenter();
        } catch (IOException e) {
            e.printStackTrace();
        }

        authorization.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//
//                try {
//                    if (!authRegPresenter.sendRequestToLogin(new User(login.getText().toString(), password.getText().toString().hashCode()))) {
                        showError();
//                    }
//                    else {
//                        Intent intent = new Intent(LoginActivity.this, Dashboard.class);
//                         startActivity(intent);
//                    }
//                   }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
            }
        });

        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideError();
                Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });
    }
    public void showError() {
        wrongLogin.setVisibility(View.VISIBLE);
        wrongPassword.setVisibility(View.VISIBLE);
        forgotPassword.setVisibility(View.VISIBLE);
    }

    public void hideError() {
        wrongLogin.setVisibility(View.INVISIBLE);
        wrongPassword.setVisibility(View.INVISIBLE);
        forgotPassword.setVisibility(View.INVISIBLE);
    }

}



