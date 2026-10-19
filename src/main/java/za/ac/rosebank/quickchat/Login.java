package za.ac.rosebank.quickchat;
public class Login {
 private final String firstName,lastName,username,password,phone;
 private boolean registered,authenticated;
 public Login(String firstName,String lastName,String username,String password,String phone){this.firstName=firstName;this.lastName=lastName;this.username=username;this.password=password;this.phone=phone;}
 public boolean checkUserName(){return username!=null&&username.contains("_")&&username.length()<=5;}
 public boolean checkPasswordComplexity(){return password!=null&&password.length()>=8&&password.matches(".*[A-Z].*")&&password.matches(".*[0-9].*")&&password.matches(".*[^A-Za-z0-9].*");}
 // Regex design reference: Oracle Java Pattern documentation:
 // https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/regex/Pattern.html
 // SA international mobile format: +27 plus 9 digits, beginning with 6, 7 or 8.
 public boolean checkCellPhoneNumber(){return phone!=null&&phone.matches("\\+27[6-8][0-9]{8}");}
 public String registerUser(){registered=false;if(!checkUserName())return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";if(!checkPasswordComplexity())return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";if(!checkCellPhoneNumber())return "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.";registered=true;return "User successfully registered.";}
 public boolean loginUser(String u,String p){authenticated=registered&&username.equals(u)&&password.equals(p);return authenticated;}
 /** Login requires freshly entered credentials; this no-argument method must not authenticate automatically. */
 @Deprecated public boolean loginUser(){authenticated=false;return false;}
 public String returnLoginStatus(){return authenticated?"Welcome "+firstName+" "+lastName+" it is great to see you again.":"Username or password incorrect, please try again.";}
 public boolean isAuthenticated(){return authenticated;}
 public boolean isRegistered(){return registered;}
}
