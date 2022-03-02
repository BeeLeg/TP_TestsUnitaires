package legarrec.color.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColorTest {
    private Color color1;
    private Color color2;

    @BeforeEach
    public void setUp(){
        color1 = new Color(10,0,255);
        color2 = new Color("#123456");
    }

    @Test
    public void testColorConstructor1() {
        assertEquals(10, color1.getRed());
        assertEquals(0, color1.getGreen());
        assertEquals(255, color1.getBlue());
        assertEquals("#0A00FF", color1.getHexValue());
    }

    @Test
    public void testSetColors(){
        color1.setRed(30);
        color1.setGreen(30);
        color1.setBlue(30);
        assertEquals(30,color1.getRed(), "La couleur rouge est pas bonne");
        assertEquals(30,color1.getGreen(), "la couleur verte est pas bonne");
        assertEquals(30,color1.getBlue(), "la couleur bleue est pas bonne");
    }

    @Test
    public void testColorConstructor2(){
        assertEquals("#123456", color2.getHexValue());
        assertEquals(18, color2.getRed());
        assertEquals(52, color2.getGreen());
        assertEquals(86, color2.getBlue());
    }

    @Test
    public void testSetHexa(){
        color2.setHexValue("#654321");
        assertEquals("#654321", color2.getHexValue(), "l'Hexa n'est pas bon");
    }

    @Test
    public void testInvalideArgumentConstructor1(){
        IllegalArgumentException excep = assertThrows(IllegalArgumentException.class, () -> color1.setRed(900));
        assertEquals("Valeur doit être comprise entre 0 et 255", excep.getMessage());
        assertThrows(IllegalArgumentException.class, () -> color1.setRed(-20));

        assertThrows(IllegalArgumentException.class, () -> color1.setGreen(-20));
        assertThrows(IllegalArgumentException.class, () -> color1.setGreen(900));

        assertThrows(IllegalArgumentException.class, () -> color1.setBlue(-20));
        assertThrows(IllegalArgumentException.class, () -> color1.setBlue(900));
    }

    @Test
    public void testRegEx(){
        assertTrue(color2.isHexaFormat("#123456"));
    }

    @Test
    public void testInvalideArgumentConstructor2(){
        assertThrows(IllegalArgumentException.class, () -> new Color("123456"));
    }

    @Test
    public void testToString(){
        assertEquals("[value=#0A00FF, r=10, g=0, b=255]", color1.toString());
    }

    @AfterEach
    public void tearDown() {
        color1 = null;
        color2 = null;
    }
}