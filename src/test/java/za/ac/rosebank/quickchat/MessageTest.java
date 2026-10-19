package za.ac.rosebank.quickchat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;
class MessageTest {
 @BeforeEach void reset(){Message.clearSentMessagesForTesting();}
 @Test void validMessage(){Message m=new Message("0012345678",0,"+27718693002","Hi Mike, can you join us for dinner tonight?");assertEquals("Message ready to send.",m.checkMessageLength());assertEquals("Cell phone number successfully captured.",m.checkRecipientCell());assertEquals("00:0:HITONIGHT",m.createMessageHash());assertTrue(m.checkMessageID());assertEquals("Message ID generated: 0012345678",m.messageIdGenerated());}
 @Test void tooLong(){Message m=new Message("1234567890",1,"+27718693002","a".repeat(253));assertEquals("Message exceeds 250 characters by 3; please reduce the size.",m.checkMessageLength());}
 @Test void invalidRecipient(){Message m=new Message("1234567890",1,"08575975889","Hi Keegan, did you receive the payment?");assertEquals("Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.",m.checkRecipientCell());}
 @Test void actionsAndTotals(){Message a=new Message("0012345678",0,"+27718693002","Hi Mike, can you join us for dinner tonight?");Message b=new Message("1234567890",1,"+27718693002","Hi Keegan, did you receive the payment?");assertEquals("Message successfully sent.",a.sentMessage(1));assertEquals("Press 0 to delete the message.",b.sentMessage(2));assertEquals(1,a.returnTotalMessagess());assertTrue(Message.printAllSentMessages().contains("HITONIGHT"));}
 @Test void storeJson(@TempDir Path dir)throws Exception{Message m=new Message("1234567890",1,"+27718693002","Hello there");assertEquals("Message successfully stored.",m.sentMessage(3));Path file=dir.resolve("messages.json");m.storeMessage(file);assertTrue(Files.readString(file).contains("Hello there"));assertEquals(0,Message.returnTotalMessages());}
 @Test void hashLoop(){String[] ids={"0012345678","1234567890"};String[] messages={"Hi Mike, can you join us for dinner tonight?","Hi Keegan, did you receive the payment?"};String[] expected={"00:0:HITONIGHT","12:1:HIPAYMENT"};for(int i=0;i<ids.length;i++)assertEquals(expected[i],new Message(ids[i],i,"+27718693002",messages[i]).createMessageHash());}
 @Test void idLength(){assertFalse(new Message("12345678901",0,"+27718693002","Hello").checkMessageID());assertEquals(10,new Message(0,"+27718693002","Hello").getMessageID().length());}
}
