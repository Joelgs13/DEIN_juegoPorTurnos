package org.example.juegoporturnos;

/**
 * Clase persona con todos los atributos y metodos que tendran todos
 * */
public class Persona {
    String nombre;
    int vida;
    int vidaMax;

    /**
     * constructor
     * @param nombre
     * nombre del jugador
     * @param vida
     * salud del jugador (actual)
     */
    Persona(String nombre, int vida) {
        this.nombre= nombre;
        this.vida = vida;
        this.vidaMax=vida;
    }

    /**
     * metodo privado al que accede el
     * metodo atacar para cojer el resultado de la tirada de ambos.
     * @return
     * Devuelve el numero obtenido aleatorio
     */
    public int hacerTirada(){
        return (int)(Math.random()*6)+1;
    }

    /**
     * devuelve si le quedan puntos de vida a esta persona
     * @return
     * si esta vivo o no
     */
    public boolean estaVivo(){
        return this.vida > 0;
    }

}
