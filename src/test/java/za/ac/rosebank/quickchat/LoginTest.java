package za.ac.rosebank.quickchat;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class LoginTest {
 @Test void registrationAndLogin(){Login l=new Login("Njabulo","Ndlovu","nja_1","Nja@2026Secure","+27838968976");assertTrue(l.checkUserName());assertTrue(l.checkPasswordComplexity());assertTrue(l.checkCellPhoneNumber());assertEquals("User successfully registered.",l.registerUser());assertFalse(l.loginUser("wrong","wrong"));assertTrue(l.loginUser("nja_1","Nja@2026Secure"));assertEquals("Welcome Njabulo Ndlovu it is great to see you again.",l.returnLoginStatus());}
 @Test void invalidRegistration(){Login l=new Login("Njabulo","Ndlovu","njabulo","password","08575975889");assertFalse(l.checkUserName());assertFalse(l.checkPasswordComplexity());assertFalse(l.checkCellPhoneNumber());assertFalse(l.loginUser());}
}
