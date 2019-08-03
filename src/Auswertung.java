package ugsbo.com.notenSpeicher;

public class Auswertung {

  public static void main(String[] args) {
    NotenKette Work = new NotenKette("Prog 1", 1);
    Work.add("Prog 2", 2);
    Work.add("Wi", 3);
    
    System.out.println(Work.durchschnitt() + "\n");
    
    System.out.print(Work.toString());
  }

}