
package tresenraya;


import java.util.Scanner;

/**
 * 
 * @author Ach
 * @version 7.1
 * 
 */
public class Sesion {

    //Atributos
    private Jugador Humano; 
    private Jugador IA; 
    private Partida partida;
    private Ranking ranking;

    //Constructor
    public Sesion() {

    }
    /**
     * 
     * Iniciar la relacion de clases, la clase Sesion con la clase IA0, donde recibe una atributo por parametro.
     * 
     * @param name En parametro que tiene que recibir es el nombre de la IA.
     */
    private void newIA(String name) {
        this.IA = new IA0(this, name);
    }
    
    /**
     * 
     * Iniciar la relacion de clases, la clase Sesion con la clase Jugador, donde recibe un atributo por parametro.
     * @param nombre El parametro que tiene que recibir es el nombre del jugador.
     */
    private void newJugador(String nombre) {
        this.Humano = new Jugador(this, nombre);
    }

    /**
     * 
     * Iniciar la relacion de la clases, la clase Sesion con la clase Partida, donde recibe varios atributos por parametro.
     * @param Humano    EL primer parametro que recibe son los datos del jugador humano.
     * @param IA        El segundo parametro que tiene que recibir son los datos de la IA.
     * @param ranking   El ultimo parametro que recibe son los datos del ranking.
     */
    private void newPartida(Jugador Humano, Jugador IA, Ranking ranking) {
        this.partida = new Partida(Humano, IA, ranking);
    }
    
    /**
     *  
     * Iniciar la relacion de clases, la clase Sesion con la clase Ranking, donde recibe un dato por parametro.
     * @param player    El parametro que tiene que recibir son las partidas realizadas por el jugador humano.
     */
    private void newRanking(Jugador player) {
        this.ranking = new Ranking(player);
    }

    /**
     * 
     * Menu de opciones para selecionar la opcion que desehemos
     */
    private void menu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        //Mostrar Menu
        System.out.println("--MENU--");
        System.out.println("1- Comenzar partida.");
        System.out.println("2- Mostrar ranking.");
        System.out.println("3- Salir.");
        System.out.println();
        System.out.print("Escoje una opción por favor: ");
        //Funcionalidad del menu
        while (exit == false) {
            int option = scanner.nextInt();
            System.out.println();
            switch (option) {
                case 1:
                    this.newPartida(this.Humano, this.IA, this.ranking);
                    this.menu();
                case 2:
                    this.ranking.showRanking(Humano);
                    this.menu();
                case 3:
                    exit = true;
            }
        }
    }

   /**
    * 
    * @param args 
    * Main del proyecto para ir ejecutando los demas metodos
    */
    public static void main(String[] args) {
        //Crear Sesion
        Sesion sesion = new Sesion();
        //Scaner para leer datos por teclado
        Scanner scanner = new Scanner(System.in);
        //Crear Jugador humano
        System.out.print("Escriba su nombre: ");
        String name = scanner.nextLine();
        sesion.newJugador(name);

        //Crear Ranking
        sesion.newRanking(sesion.Humano);
        //Crear IA
        sesion.newIA("IA");
        //Iniciar menu
        sesion.menu();
    }// Cierre del metodo

}