
package clases;
import java.util.*;
import java.security.MessageDigest;
import java.math.BigInteger;

public class Persona{
	private String id;
	private String Nombre;
	private String apellido;
	private String añoNac;
        private String correo;
        private String edad;
        private String contraseña;
	public Persona(){
		//inicializamos variables
		id = "";
		Nombre = "";
		apellido = "";
                añoNac = "";
                correo = "";
                edad = "";
                contraseña = "";	
	}
	Scanner teclado= new Scanner(System.in);
    boolean isEmpty, isInt, isEmail, isTaken;
	public void setId(String id){
		this.id = id;
	}
        
        //Encriptacion de la contraseña
        
        public static String getSHA512(String input){
	String toReturn = null;
            try {
                MessageDigest digest = MessageDigest.getInstance("SHA-512");
                digest.reset();
                digest.update(input.getBytes("utf8"));
                toReturn = String.format("%0128x", new BigInteger(1, digest.digest()));
            } catch (Exception e) {
                e.printStackTrace();
            }return toReturn;
        }
        
        // Sets
	public void setNombre(){
        do{
            System.out.print(" Introduzca el nombre: ");
            String comp=teclado.nextLine();
            isEmpty=comp.matches("");
            try{
                if(isEmpty){
                    throw new PersonaExcepciones("Error. Debe introducir un nombre." + "\n"); // en el caso que no haya nada escrito
                }else{
                    this.Nombre =comp;
                }
            }catch(PersonaExcepciones e){
                System.out.println("\n Mensaje: "+e.getMessage());
            }
        }while(isEmpty);
    }
	public void setNombre(String nombres){
		this.Nombre = nombres;
	}

	public void setApellido(){
        do{
            System.out.print(" Introduzca los apellidos: ");
            String comp=teclado.nextLine();
            isEmpty=comp.matches("");
            try{
                if(isEmpty){
                    throw new PersonaExcepciones("Error. Debe introducir los apellidos." + "\n");
                }else{
                    this.apellido =comp;
                }
            }catch(PersonaExcepciones e){
                System.out.println("\n Mensaje: "+e.getMessage());
            }
        }while(isEmpty);
    }
	public void setApellido(String apellido){
		this.apellido = apellido;
	}
        public void setAñoNac(String añoNac){
		this.añoNac = añoNac;
	}
	public void setCorreo(){
        do{
            System.out.print(" Introduzca el correo: ");
            String comp=teclado.nextLine();
            String gmail="@gmail.com";
            String hotmail="@hotmail.com";
            isEmail=comp.contains(gmail)||comp.contains(hotmail);
            isEmpty=comp.matches("");
            try{// errores por si se ponen mal o no se ponen
                if(isEmpty){
                    throw new PersonaExcepciones("Error. Debe introducir una dirección de correo electrónico." + "\n");
                }else if(!isEmail){
                    throw new PersonaExcepciones("Error. El correo debe finalizar en @gmail.com o @hotmail.com." + "\n");
                }else{
                    this.correo =comp;
                }
            }catch(PersonaExcepciones e){
                System.out.println("\n Mensaje: "+e.getMessage());
            }
        }while(isEmpty || !isEmail);
    }
        public void setCorreo(String correo){
		this.correo = correo;
	}
        public void setEdad(String edad){
		this.edad = edad;
	}
        public void setContraseña(String contraseña){
		this.contraseña=getSHA512(contraseña);//constructor
	}
        // Gets
        public String getContraseña(){
            return this.contraseña;
        }
	public String getId(){
		return this.id;
	}
	public String getNombre(){
		return this.Nombre;
	}
	public String getApellido(){
		return this.apellido;
	}
        public String getAñoNac(){
		return this.añoNac;
	}
        public String getCorreo(){
		return this.correo;
	}
        public String getEdad(){
		return this.edad;
	}
        // Mostrar los datos
        public String getPersona(){
         return "Id: " + this.id + " Nombre: "+ this.Nombre + " Apellido: "+ this.apellido + " Año de Nacimiento: " + this.añoNac + " E-MAIL: " + this.correo + " Edad: "+ this.edad + this.contraseña;
    }
	public String getFichero(){
            return this.id + ","+this.Nombre+","+this.apellido+","+this.correo+","+this.añoNac;
	}
}

