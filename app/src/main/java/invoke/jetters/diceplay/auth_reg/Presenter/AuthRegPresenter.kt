package invoke.jetters.diceplay.auth_reg.Presenter

import android.content.ContentValues.TAG
import android.util.Log
import invoke.jetters.diceplay.auth_reg.Model.DataBaseConnector
import invoke.jetters.diceplay.auth_reg.Model.User
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import java.io.IOException
import kotlin.jvm.Throws

class AuthRegPresenter {
    private var dataBaseConnector: DataBaseConnector? = null


    @Throws(IOException::class)
    fun AuthRegPresenter() {
        dataBaseConnector = DataBaseConnector()
    }

    @Throws(IOException::class)
    fun sendRequestToLogin(user: User?): Boolean {
        var answerFromServer: Boolean = false;
        val dispose = dataBaseConnector?.requestToLogin(user)
                ?.subscribeOn(Schedulers.newThread())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe( {
                    answerFromServer = it;
                }, {
                    Log.e(TAG, "We have a problems my dear");
                })

        return answerFromServer;
    }

    @Throws(IOException::class)
    fun sendRequestToRegistration(user: User?): Boolean {
        var answerFromServer: Boolean = false;
        val dispose = dataBaseConnector?.requestToRegistration(user)
                ?.subscribeOn(Schedulers.newThread())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe( {
                    answerFromServer = it;
                }, {
                    Log.e(TAG, "We have a problems my dear");
                })

        return answerFromServer;
    }
}