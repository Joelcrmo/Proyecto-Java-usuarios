/**
 * @author saagy
 */

package clases;

import java.awt.List;
import java.util.ArrayList;
import java.util.Date;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.swing.table.AbstractTableModel;
import java.io.IOException;


public class Modelodedatos extends AbstractTableModel{
    
    private static final int DNI = 0;
    private static final int NOMBRE = 1;
    private static final int APE1 = 2;
    private static final int EMAIL = 3;
    private static final int FENAC = 4;
    private static final int PWD = 5;
    
    private ArrayList<Persona> listaPersonas;
    
    private static final String[] columns = new String[]{"Dni", "Nombre", "Ape1", "fecha", "email", "Contraseña"};
    private static final Class<?>[] clase = { String.class, String.class, String.class,String.class,String.class, String.class};

    
    private String[] columnNames = {"Dni", "Nombre", "Apellido", "Fecha", "E-mail", "Contraseña"};
    

    /**
     *
     * @param listaPersonas
     */
    
    public Modelodedatos(ArrayList<Persona> listaPersonas){
        this.listaPersonas=listaPersonas;
    }
    
    @Override
    public int getRowCount() {
        return listaPersonas.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }
    
      public void removeRow(int rowIndex) {
        listaPersonas.remove(rowIndex);
        fireTableDataChanged();
    }
      private void exportTableToXML() throws ParserConfigurationException, TransformerException, IOException {
        // Crea el objeto DocumentBuilderFactory y el objeto DocumentBuilder
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
      }
    
    @Override  // Devuelve valor de la celda que s esta en la fila rowIndex y en la columna columnIndex
    public Object getValueAt(int rowIndex, int columnIndex) {
        Persona a = getPersona(rowIndex);

        if(a != null) {
            switch (columnIndex) {
                case DNI:
                    return a.getId();
                case NOMBRE:
                    return a.getNombre();
                case APE1:
                    return a.getApellido();
                 case FENAC:
                    return a.getAñoNac();
                case EMAIL:
                    return a.getCorreo();
                case PWD:
                    return a.getContraseña();
               }
        }
        return "";
    }
    @Override  // Escribe valor en la celda que esta en la fila rowIndex y en la columna columnIndex
    public void setValueAt(Object valor,int rowIndex, int columnIndex) {
        Persona a = getPersona(rowIndex);
      
        if(a != null) {
            switch (columnIndex) {
                case DNI:
                     a.setId(valor.toString());
                case NOMBRE:
                     a.setNombre(valor.toString());
                case APE1:
                     a.setApellido(valor.toString());
                 case FENAC:
                     a.setAñoNac(valor.toString());
                case EMAIL:
                     a.setCorreo(valor.toString());
                case PWD:
                     a.setContraseña(valor.toString());
               }
        }  
    }
    public void setValueRow(Persona a,int rowIndex) {
        Persona modificar = getPersona(rowIndex);

        if(modificar != null) {
            modificar.setId(a.getId());
            modificar.setNombre(a.getNombre());
            modificar.setApellido(a.getApellido());
            modificar.setAñoNac(a.getAñoNac());
            modificar.setCorreo(a.getCorreo());
            modificar.setContraseña(a.getContraseña());
            this.fireTableDataChanged();
           }
    }
  
    
    public Persona getPersona(int rowIndex) {
        if (getRowCount() > rowIndex && rowIndex >= 0) {
            return listaPersonas.get(rowIndex);
        }
        return null;
    }

    public ArrayList<Persona> getlistaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(ArrayList<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
        for (Persona per: listaPersonas) {
            System.out.println(per.getAñoNac());
            System.out.println(per.getCorreo());
        }
        this.fireTableDataChanged(); 
        
    }

    public void setPersona(Persona sb){
        listaPersonas.add(sb);
        this.fireTableRowsInserted(listaPersonas.size()-1, listaPersonas.size()-1);
    }
   @Override
    public Class<?> getColumnClass(int columnIndex) {
        return clase[columnIndex];
    }
    
    @Override 
    public String getColumnName(int index) { 
        return columnNames[index]; 
    } 

   
    public String[] getColumnNames() {
        return columnNames;
    }

    public void setColumnNames(String[] columnNames) {
        this.columnNames = columnNames;
    }
}