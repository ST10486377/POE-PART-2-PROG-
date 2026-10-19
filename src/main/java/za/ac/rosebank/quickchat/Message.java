package za.ac.rosebank.quickchat;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
public class Message {
 public enum Status {DRAFT,SENT,STORED,DISCARDED}
 private static final SecureRandom RANDOM=new SecureRandom();
 private static final List<Message> sentMessages=new ArrayList<>();
 private final String messageID,recipient,message;
 private final int messageNumber;
 private Status status=Status.DRAFT;
 public Message(int messageNumber,String recipient,String message){this(generateId(),messageNumber,recipient,message);}
 public Message(String id,int number,String recipient,String message){this.messageID=id;this.messageNumber=number;this.recipient=recipient;this.message=message;}
 private static String generateId(){long n=1_000_000_000L+RANDOM.nextLong(9_000_000_000L);return Long.toString(n);}
 public boolean checkMessageID(){return messageID!=null&&messageID.matches("[0-9]{1,10}");}
 public boolean checkMessagelD(){return checkMessageID();} // compatibility with spelling in rubric
 public String messageIdGenerated(){return "Message ID generated: "+messageID;}
 // International +27 followed by nine digits: +27718693002 is 12 characters including '+';
 // the rubric's '10 characters' conflicts with its accepted example.
 public String checkRecipientCell(){return recipient!=null&&recipient.matches("\\+27[6-8][0-9]{8}")?"Cell phone number successfully captured.":"Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";}
 public String checkMessageLength(){if(message==null)return "Message exceeds 250 characters by 0; please reduce the size.";int extra=message.length()-250;return extra>0?"Message exceeds 250 characters by "+extra+"; please reduce the size.":"Message ready to send.";}
 public String createMessageHash(){if(message==null||message.isBlank())return "";String[] words=message.trim().split("\\s+");String first=words[0].replaceAll("[^\\p{L}\\p{N}]","");String last=words[words.length-1].replaceAll("[^\\p{L}\\p{N}]","");return (messageID.length()>=2?messageID.substring(0,2):messageID)+":"+messageNumber+":"+(first+last).toUpperCase(Locale.ROOT);}
 public String sentMessage(int selection){if(selection==1){if(!checkMessageID()||!checkRecipientCell().equals("Cell phone number successfully captured.")||!checkMessageLength().equals("Message ready to send."))return "Message not sent: please correct the message details.";if(status!=Status.SENT){sentMessages.add(this);status=Status.SENT;}return "Message successfully sent.";}if(selection==2){if(status==Status.SENT)sentMessages.remove(this);status=Status.DISCARDED;return "Press 0 to delete the message.";}if(selection==3){status=Status.STORED;return "Message successfully stored.";}return "Invalid option.";}
 public String SentMessage(int selection){return sentMessage(selection);}
 public String printMessages(){return "Message ID: "+messageID+"\nMessage Hash: "+createMessageHash()+"\nRecipient: "+recipient+"\nMessage: "+message;}
 public static String printAllSentMessages(){StringBuilder sb=new StringBuilder();for(Message m:sentMessages)sb.append(m.printMessages()).append("\n\n");return sb.toString();}
 public static int returnTotalMessages(){return sentMessages.size();}
 public int returnTotalMessagess(){return returnTotalMessages();}
 public void storeMessage(Path file) throws IOException {if(status!=Status.STORED)throw new IllegalStateException("Select Store Message first.");List<Message> stored=new ArrayList<>();Gson gson=new GsonBuilder().setPrettyPrinting().create();if(Files.exists(file)){String content=Files.readString(file,StandardCharsets.UTF_8);Message[] existing=gson.fromJson(content,Message[].class);if(existing!=null)stored.addAll(List.of(existing));}boolean exists=stored.stream().anyMatch(m->m.messageID.equals(messageID));if(!exists)stored.add(this);if(file.getParent()!=null)Files.createDirectories(file.getParent());Files.writeString(file,gson.toJson(stored),StandardCharsets.UTF_8);}
 public String getMessageID(){return messageID;}
 public Status getStatus(){return status;}
 public static void clearSentMessagesForTesting(){sentMessages.clear();}
}
