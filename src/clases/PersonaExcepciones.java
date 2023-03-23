package clases;
public class PersonaExcepciones extends Exception {
    private String errorMessage;
    //Se crea el constructor con el mensaje de error
    public PersonaExcepciones(){
        this.errorMessage="Error indefinido";
    }
    //El constructor con parametros de string devuelve el mensaje
    public PersonaExcepciones(String message){
        this.errorMessage=message;
    }
    //Recibir mensajes de error desde persona 
    public String getMessage(){
        return this.errorMessage;
    }
}
