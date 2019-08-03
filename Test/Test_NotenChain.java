package com.ugsbo.notenSpeicher;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import ugsbo.com.notenSpeicher.NotenKette;

public class Test_NotenChain {

  public NotenKette Workingobjekt;
  
  @Before
  public void setUp() throws Exception {
    Workingobjekt = new NotenKette("first", 2);
  }

  @Test
  public void hinzufügen() {
    String eingabeFach = "Mathe";
    int eingabeNote = 2;
    
    double erwartet = 2;
    double ergebnis;
    
    Workingobjekt.add(eingabeFach, eingabeNote);
    ergebnis = Workingobjekt.durchschnitt();
    
    assertEquals(erwartet, ergebnis, 0.1);
  }
  
  @Test
  public void hinzufügenMehrAlsEinmal() {
    String eingabeFach = "Mathe";
    int eingabeNote = 2;
    double ergebnis;
    double erwartet = 2;
    
    Workingobjekt.add(eingabeFach, eingabeNote);
    Workingobjekt.add(eingabeFach, eingabeNote);
    Workingobjekt.add(eingabeFach, eingabeNote);
    
    ergebnis = Workingobjekt.durchschnitt();
    
    assertEquals(erwartet, ergebnis, 0.1);
  }
  
  @Test
  public void hinzufügenistNull() {
    String eingabeFach = "Mathe";
    int eingabeNote = 2;
    int eingabeNotezwei = 0;
    double ergebnis;
    double erwartet = 2;
    
    Workingobjekt.add(eingabeFach, eingabeNote);
    Workingobjekt.add(eingabeFach, eingabeNotezwei);
    
    ergebnis = Workingobjekt.durchschnitt();
    
    assertEquals(erwartet, ergebnis, 0.1);
  }
  
}
