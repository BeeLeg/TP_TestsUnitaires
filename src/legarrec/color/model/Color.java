package legarrec.color.model;

import java.util.regex.Pattern;

public class Color {

    private static final short MIN_VALUE = 0;
    private static final short MAX_VALUE = 255;

    public int red;
    public int green;
    public int blue;
    public String hexaValue;

    public Color(int rouge, int vert, int bleu) throws IllegalArgumentException {
        if(isRGBValueValide(rouge) && isRGBValueValide(vert) && isRGBValueValide(bleu)){
            this.red = rouge;
            this.green = vert;
            this.blue = bleu;
            this.hexaValue = String.format("#%02X%02X%02X", red, green, blue);
        } else
            throw new IllegalArgumentException("Valeur doit être comprise entre 0 et 255");
    }

    public Color(String hexa) {
        if(hexa == null || !isHexaFormat(hexa)){
            throw new IllegalArgumentException("Mauvais format de couleur Hexa");
        }
        else {
            this.hexaValue = hexa;
            red = Integer.valueOf(hexa.substring(1, 3), 16);
            green = Integer.valueOf(hexa.substring(3, 5), 16);
            blue = Integer.valueOf(hexa.substring(5, 7), 16);
        }
    }

    public int getRed(){
        return red;
    }
    public int getGreen(){
        return green;
    }
    public int getBlue(){
        return blue;
    }

    public void setRed(int rouge){
        if(rouge <= MAX_VALUE  && rouge >= MIN_VALUE ){
            this.red = rouge;
            updateHexaValue();
        } else
            throw new IllegalArgumentException("Valeur doit être comprise entre 0 et 255");
    }

    public void setGreen(int vert){
        if(vert <= MAX_VALUE  && vert >= MIN_VALUE ){
            this.green = vert;
            updateHexaValue();
        } else
            throw new IllegalArgumentException("Valeur doit être comprise entre 0 et 255");
    }

    public void setBlue(int bleu){
        if(bleu <= MAX_VALUE  && bleu >= MIN_VALUE ){
            this.blue = bleu;
            updateHexaValue();
        } else
            throw new IllegalArgumentException("Valeur doit être comprise entre 0 et 255");
    }

    public String getHexValue(){
        return hexaValue;
    }

    public void setHexValue(String hexa){
        if(hexa != null && isHexaFormat(hexa)) {
            this.hexaValue = hexa;
            red = Integer.valueOf(hexa.substring(1, 3), 16);
            green = Integer.valueOf(hexa.substring(3, 5), 16);
            blue = Integer.valueOf(hexa.substring(5, 7), 16);
        }else
            throw new IllegalArgumentException("Mauvais format de couleur Hexa");
    }

    public void updateHexaValue(){
        setHexValue(String.format("#%02X%02X%02X", getRed(), getGreen(), getBlue()));
    }

    public boolean isHexaFormat(String string) {
        return Pattern.matches("^#[0-9A-F]{6}+$", string);
    }

    public boolean isRGBValueValide(int value){
        return value <= MAX_VALUE && value >= MIN_VALUE;
    }

    @Override
    public String toString() {
        return "[value="+getHexValue()+", r="+getRed()+", g="+getGreen()+", b="+getBlue()+"]";
    }
}
