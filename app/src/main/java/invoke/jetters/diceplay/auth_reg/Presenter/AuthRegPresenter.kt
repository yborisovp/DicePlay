package invoke.jetters.diceplay.auth_reg.Presenter

import android.app.Activity
import android.content.ContentValues.TAG
import android.util.Log
import invoke.jetters.diceplay.auth_reg.Model.DataBaseConnector
import invoke.jetters.diceplay.auth_reg.Model.User
import invoke.jetters.diceplay.auth_reg.View.IView
import invoke.jetters.diceplay.auth_reg.View.LoginActivity
import invoke.jetters.diceplay.auth_reg.View.RegistrationActivity
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import java.io.IOException
import kotlin.jvm.Throws

class AuthRegPresenter {

    private var dataBaseConnector: DataBaseConnector? = DataBaseConnector();
    private val disposeBag = CompositeDisposable();

    private lateinit var view: IView;

    constructor(view: IView) {
        this.view = view;
    }


    @Throws(IOException::class)
    fun sendRequestToServer(user: User?, requestType: String): Disposable? {
        var answerFromServer: Boolean = false;
        val dispose = dataBaseConnector?.sendRequest(user, requestType)
                ?.subscribeOn(Schedulers.newThread())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe( {
                    answerFromServer = it;
                }, {
                    Log.e(TAG, "We have a problems my dear");
                })

        if(answerFromServer) {
            this.view.onSuccess();
        }
        else {
            this.view.onError();
        }

        return dispose;
    }


}