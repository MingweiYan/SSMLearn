import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestBCryptPasswordEncoder {

    @Test
    public void generatePassword(){
        String password = "123";
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        String encode1 = bCryptPasswordEncoder.encode(password);
        System.out.println("encode1:" + encode1);
    }
}
