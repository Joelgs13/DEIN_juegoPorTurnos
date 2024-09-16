package org.example.juegoporturnos;

import javax.management.PersistentMBean;

/**
 * Clase persona con todos los atributos y metodos que tendran todos
 *
 * */
public class Persona {
    String nombre;
    int vida;
    Boolean vivo;

    /**
     * constructor
     * @param vida
     */
    Persona(String nombre, int vida) {
        this.nombre= nombre;
        this.vida = vida;
        if (this.vida > 0) {
            this.vivo=true;
        }
    }


    public void atacar(String nombre) {
        System.out.println(this.nombre +" Atacando a " + nombre);
    }

    /**
     * metodo privado al que accede el
     * metodo atacar para cojer el resultado de la tirada de ambos.
     * Devuelve el numero obtenido aleatorio
     * @return
     */
    private int hacerTirada(){
        return (int)(Math.random()*6)+1;
    }

}
