package invoke.jetters.diceplay.auth_reg.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;

import invoke.jetters.diceplay.R;
import invoke.jetters.diceplay.auth_reg.Model.Hasher;
import invoke.jetters.diceplay.auth_reg.Model.User;
import invoke.jetters.diceplay.auth_reg.Presenter.AuthRegPresenter;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class RegistrationActivity extends AppCompatActivity implements IView {
    private EditText login;
    private EditText password;
    private EditText user;
    private CompositeDisposable disposeBag;

    private AuthRegPresenter authRegPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        login = findViewById(R.id.login);
        password = findViewById(R.id.password);
        user = findViewById(R.id.user);


        Button registration = findViewById(R.id.sign_up_button);


        authRegPresenter = new AuthRegPresenter(RegistrationActivity.this);


        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Disposable dispose = authRegPresenter.sendRequestToServer(
                            new User(login.getText().toString(),
                                     Hasher.getHash(password.getText().toString()),
                                     user.getText().toString()
                            ),
                            "registration"
                    );
                    disposeBag.add(dispose);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onDestroy() {
        disposeBag.clear();
        super.onDestroy();
    }


    @Override
    public void onError() {

    }

    @Override
    public void hideError() {

    }

    @Override
    public void onSuccess() {
//        Intent intent = new Intent(RegistrationActivity.this, Dashboard.class);
//        startActivity(intent);
    }
}