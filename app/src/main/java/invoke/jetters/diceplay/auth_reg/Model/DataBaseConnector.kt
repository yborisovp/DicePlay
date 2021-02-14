package invoke.jetters.diceplay.auth_reg.Model

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.Socket
import io.reactivex.Single
import kotlin.jvm.Throws

class DataBaseConnector {
    private val reader: BufferedReader
    private val writer: OutputStreamWriter

    @Throws(IOException::class)
    fun sendRequest(user: User?, requestType: String): Single<Boolean> {
        return Single.create { subscriber ->
            writer.write(""" $requestType ${user?.login} ${user?.password} """.trimIndent())
            writer.flush()
            subscriber.onSuccess(reader.readLine() == "accept");
        }
    }

    init {
        val clientSocket = Socket("127.0.0.1", 8080)
        reader = BufferedReader(
                InputStreamReader(
                        clientSocket.getInputStream()))
        writer = OutputStreamWriter(clientSocket.getOutputStream())
    }
}