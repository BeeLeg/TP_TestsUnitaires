package legarrec.color.model;

import java.util.regex.Pattern;

public class Color {

    public int rouge;
    public int vert;
    public int bleu;
    public String hexa;

    public Color(int rouge, int vert, int bleu) throws IllegalArgumentException {
        if((rouge <= 255 && vert <= 255 && bleu <= 255) && (rouge >= 0 && vert >= 0 && bleu >= 0)){
            this.rouge = rouge;
            this.vert = vert;
            this.bleu = bleu;
        } else
            throw new IllegalArgumentException("Valeur doit être comprise entre 0 et 255");
    }

    public int getRouge(){
        return rouge;
    }
    public int getVert(){
        return vert;
    }
    public int getBleu(){
        return bleu;
    }


    public Color(String hexa) {
        if(isHexaFormat(hexa))
            this.hexa = hexa;
        else
            throw new IllegalArgumentException("Mauvais format de couleur Hexa");
    }

    public String getHexa(){
        return hexa;
    }

    public boolean isHexaFormat(String string) {
        return Pattern.matches("^#[0-9A-F]{1,6}+$", string);
    }
}
