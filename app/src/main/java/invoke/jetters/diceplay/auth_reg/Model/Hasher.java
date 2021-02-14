package invoke.jetters.diceplay.auth_reg.Model;

import org.mindrot.jbcrypt.BCrypt;

public class Hasher {
    public static String getHash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(12));
    }
}
