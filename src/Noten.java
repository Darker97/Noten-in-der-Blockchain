package ugsbo.com.notenSpeicher;

import java.security.MessageDigest;

public class Noten {


  String Fach;
  int Note;
  double durchschnitt;
  Noten vorher;
  
  String ownHash;
  String previousHash;
  
  public Noten(String eingabeFach, int eingabeNote) {
    Fach = eingabeFach;
    Note = eingabeNote;
    durchschnitt = eingabeNote;
    
    vorher = null;
    previousHash = null;
    
    ownHash = createNewHash(eingabeFach);
  }
  
  public Noten(String eingabeFach, int eingabeNote, String previousHash, double durchschnitt, Noten vorher) {
    Fach = eingabeFach;
    Note = eingabeNote;
    ownHash = createNewHash(eingabeFach+previousHash);
    
    this.durchschnitt = (durchschnitt+eingabeNote)/2;
    
    this.vorher = vorher;
    this.previousHash = previousHash;
  }

  private String createNewHash(String input) {
    try {
      MessageDigest digest = MessageDigest.getInstance("SHA-256");            
      //Applies sha256 to our input, 
      byte[] hash = digest.digest(input.getBytes("UTF-8"));           
      StringBuffer hexString = new StringBuffer(); // This will contain hash as hexidecimal
      for (int i = 0; i < hash.length; i++) {
          String hex = Integer.toHexString(0xff & hash[i]);
          if(hex.length() == 1) hexString.append('0');
          hexString.append(hex);
      }
      return hexString.toString();
  }
  catch(Exception e) {
      throw new RuntimeException(e);
  }
  }
  
  
  public String getFach() {
    return Fach;
  }
  
  public int getNote() {
    return Note;
  }
  
  public double getDurchschnitt() {
    return durchschnitt;
  }
  
  public Noten getVorher() {
    return vorher;
  }
  
  public String getOwnHash() {
    return ownHash;
  }
  
}
