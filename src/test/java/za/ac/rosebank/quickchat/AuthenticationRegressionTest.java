package za.ac.rosebank.quickchat;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class AuthenticationRegressionTest {
 @Test void cannotLoginWithoutEnteredCredentials() {
  Login user = new Login("Njabulo", "Ndlovu", "nja_1", "Secure@123", "+27718693002");
  assertEquals("User successfully registered.", user.registerUser());
  assertFalse(user.loginUser());
  assertFalse(user.isAuthenticated());
  assertFalse(user.loginUser("nja_1", "wrong"));
  assertTrue(user.loginUser("nja_1", "Secure@123"));
 }
}
