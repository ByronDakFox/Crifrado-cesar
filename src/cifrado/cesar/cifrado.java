/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifrado.cesar;

/**
 *
 * @author byron
 */
public class cifrado {

    private String mayus;
    private String minus;

    public cifrado(String mayus, String minus) {
        this.mayus = mayus;
        this.minus = minus;
    }
    
    

    public String cifrar(String texto, int desplazamiento) {
        String salida = "";

        for (int i = 0; i < texto.length(); i++) {
            if ((this.mayus.indexOf(texto.charAt(i)) != -1) || (this.minus.indexOf(texto.charAt(i)) != -1)) {
                salida += (this.mayus.indexOf(texto.charAt(i)) != -1) ? this.mayus.charAt(((this.mayus.indexOf(texto.charAt(i)) + desplazamiento) % this.mayus.length()))
                        : this.minus.charAt(((this.minus.indexOf(texto.charAt(i)) + desplazamiento) % this.minus.length()));
            } else {
                salida += texto.charAt(i);
            }
        }

        return salida;
    }

    public String descifrar(String texto, int desplazamiento) {
        String salida = "";
        for (int i = 0; i < texto.length(); i++) {
            if (this.mayus.indexOf(texto.charAt(i)) != -1 || this.minus.indexOf(texto.charAt(i)) != -1) {
                if (this.mayus.indexOf(texto.charAt(i)) != -1) {
                    if ((this.mayus.indexOf(texto.charAt(i)) - desplazamiento) < 0) {
                        salida += this.mayus.charAt((this.mayus.length()) + ((this.mayus.indexOf(texto.charAt(i))) - desplazamiento));
                    } else {
                        salida += this.mayus.charAt(((this.mayus.indexOf(texto.charAt(i))) - desplazamiento) % (this.mayus.length()));
                    }
                } else {
                    if (this.minus.indexOf(texto.charAt(i)) < 0) {
                        salida += this.minus.charAt((this.minus.length()) + ((this.minus.indexOf(texto.charAt(i))) - desplazamiento));
                    } else {
                        salida += this.minus.charAt(((this.minus.indexOf(texto.charAt(i))) - desplazamiento) % (this.minus.length()));
                    }
                }
            } else {
                salida += texto.charAt(i);
            }
        }
        return salida;
    }

}
