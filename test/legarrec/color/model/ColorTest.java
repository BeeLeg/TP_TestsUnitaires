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
    public void testColorConstructor2(){
        assertEquals("#123456", color2.getHexa());
    }

    @Test
    public void testInvalideArgumentConstructor1(){
        assertThrows(IllegalArgumentException.class, () -> new Color(-1, 30, 25));
    }

    @Test
    public void testRegEx(){
        assertTrue(color2.isHexaFormat("#123456"));
    }

    @Test
    public void testInvalideArgumentConstructor2(){
        assertThrows(IllegalArgumentException.class, () -> new Color("123456"));
    }

    @AfterEach
    public void tearDown() {
        color1 = null;
    }
}