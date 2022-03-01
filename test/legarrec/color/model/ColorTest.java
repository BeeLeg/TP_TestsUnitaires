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
        assertEquals(10, color1.getRouge());
        assertEquals(0, color1.getVert());
        assertEquals(255, color1.getBleu());
    }

    @Test
    public void testSetColors(){
        color1.setRouge(30);
        color1.setVert(30);
        color1.setBleu(30);
        assertEquals(30,color1.getRouge(), "La couleur rouge est pas bonne");
        assertEquals(30,color1.getVert(), "la couleur verte est pas bonne");
        assertEquals(30,color1.getBleu(), "la couleur bleue est pas bonne");
    }

    @Test
    public void testColorConstructor2(){
        assertEquals("#123456", color2.getHexa());
    }

    @Test
    public void testSetHexa(){
        color2.setHexa("#654321");
        assertEquals("#654321", color2.getHexa(), "l'Hexa n'est pas bon");
    }

    @Test
    public void testInvalideArgumentConstructor1(){
        assertThrows(IllegalArgumentException.class, () -> new Color(-1, 30, 25));
        IllegalArgumentException excep = assertThrows(IllegalArgumentException.class, () -> color1.setRouge(900));
        assertEquals("Valeur doit être comprise entre 0 et 255", excep.getMessage());

        assertThrows(IllegalArgumentException.class, () -> color1.setVert(-20));
        assertThrows(IllegalArgumentException.class, () -> color1.setBleu(900));
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