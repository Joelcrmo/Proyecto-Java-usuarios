/**
 *
 * @author joelj
 */
import clases.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;




public class CrearPersonas extends javax.swing.JInternalFrame {

    ArrayList<Persona> Arraypersonas = new ArrayList<Persona>();
    Modelodedatos datospersona = new Modelodedatos(Arraypersonas);
    boolean mod = false;
    int modificar;
    JSONArray jsonArray = new JSONArray();
  
    public void crearPersonaXML(){
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder;
            builder = factory.newDocumentBuilder();
            DOMImplementation implementation= builder.getDOMImplementation();
    
            Document documento = implementation.createDocument(null, "Personas", null);
            documento.setXmlVersion("1.0");
            
            for(int i=0;i<this.Arraypersonas.size();i++){
            Element personas=documento.createElement("Usuario");
            
            Element id=documento.createElement("ID");
            id.appendChild(documento.createTextNode(this.Arraypersonas.get(i).getId()));
            personas.appendChild(id);
            
            Element nombre=(Element) documento.createElement("Nombre");
            nombre.appendChild(documento.createTextNode(this.Arraypersonas.get(i).getNombre()));
            personas.appendChild(nombre);
            
            Element apellido=(Element) documento.createElement("Apellido");
            apellido.appendChild(documento.createTextNode(this.Arraypersonas.get(i).getApellido()));
            personas.appendChild(apellido);
            
            Element correo=(Element) documento.createElement("Correo");
            correo.appendChild(documento.createTextNode(this.Arraypersonas.get(i).getCorreo()));
            personas.appendChild(correo);
            
            Element year=(Element) documento.createElement("Fecha");
            year.appendChild(documento.createTextNode(this.Arraypersonas.get(i).getAñoNac()));
            personas.appendChild(year);
            
            Element Password=(Element) documento.createElement("Contraseña");
            Password.appendChild(documento.createTextNode(this.Arraypersonas.get(i).getContraseña()));
            personas.appendChild(Password);
            
            documento.getDocumentElement().appendChild(personas);
            
            Source source = new DOMSource(documento);
            
            Result result = new StreamResult(new File("archivo.xml"));
            
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            }
        } catch (ParserConfigurationException | TransformerException ex ) {
            Logger.getLogger(CrearPersonas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    private void crearpersonaJson(){
        for(Persona persona:Arraypersonas){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("ID",persona.getId());
            jsonObject.put("Nombre",persona.getNombre());
            jsonObject.put("Apellido", persona.getApellido());
            jsonObject.put("Correo", persona.getCorreo());
            jsonObject.put("Año de nacimiento", persona.getAñoNac());
            jsonObject.put("Contraseña", persona.getContraseña());
            jsonArray.add(jsonObject);
        }
        try {
            FileWriter fileWriter = new FileWriter("archivo.json");
            fileWriter.write(jsonArray.toString());
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Creates new form CrearPersonas
     */
    public CrearPersonas() {
        initComponents();
    }
    //metodo para limpiar los campos de texto 
    public void limpiarcampos() {
        Idtxt.setText("");
        nombretxt.setText("");
        apellidotxt.setText("");
        añotext.setText("");
        contraseñatxt.setText("");
        emailtxt.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField11 = new javax.swing.JTextField();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        nombretxt = new javax.swing.JTextField();
        Idtxt = new javax.swing.JTextField();
        añotext = new javax.swing.JTextField();
        apellidotxt = new javax.swing.JTextField();
        emailtxt = new javax.swing.JTextField();
        crearpersona = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        contraseñatxt = new javax.swing.JPasswordField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        label3 = new java.awt.Label();
        label4 = new java.awt.Label();
        label5 = new java.awt.Label();
        label6 = new java.awt.Label();
        label7 = new java.awt.Label();
        label8 = new java.awt.Label();
        Modificar = new javax.swing.JButton();
        borrardatos = new javax.swing.JButton();
        XML = new javax.swing.JButton();
        JSON = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        sfds = new java.awt.Label();
        label1 = new java.awt.Label();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        jTextField11.setText("jTextField8");

        setBackground(new java.awt.Color(204, 204, 255));
        setFrameIcon(null);
        setPreferredSize(new java.awt.Dimension(1100, 650));

        jDesktopPane1.setBackground(new java.awt.Color(51, 51, 51));
        jDesktopPane1.setPreferredSize(new java.awt.Dimension(1100, 650));

        nombretxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombretxtActionPerformed(evt);
            }
        });

        Idtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdtxtActionPerformed(evt);
            }
        });

        añotext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añotextActionPerformed(evt);
            }
        });

        apellidotxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apellidotxtActionPerformed(evt);
            }
        });

        emailtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailtxtActionPerformed(evt);
            }
        });

        crearpersona.setFont(new java.awt.Font("Yu Gothic", 0, 12)); // NOI18N
        crearpersona.setText("Añadir usuario");
        crearpersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearpersonaActionPerformed(evt);
            }
        });

        cancelar.setFont(new java.awt.Font("Yu Gothic", 0, 12)); // NOI18N
        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        contraseñatxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contraseñatxtActionPerformed(evt);
            }
        });

        jTable1.setModel(datospersona
        );
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        label3.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        label3.setText("NOMBRE");

        label4.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        label4.setText("APELLIDO");

        label5.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        label5.setText("FECHA DE NACIMIENTO");

        label6.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        label6.setText("ID");

        label7.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        label7.setText("CONTRASEÑA");

        label8.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        label8.setText("E-MAIL");

        Modificar.setFont(new java.awt.Font("Yu Gothic", 0, 12)); // NOI18N
        Modificar.setText("Modificar datos");
        Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarActionPerformed(evt);
            }
        });

        borrardatos.setFont(new java.awt.Font("Yu Gothic", 0, 12)); // NOI18N
        borrardatos.setText("Borrar datos");
        borrardatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrardatosActionPerformed(evt);
            }
        });

        XML.setFont(new java.awt.Font("Yu Gothic", 0, 12)); // NOI18N
        XML.setText("Generar XML");
        XML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XMLActionPerformed(evt);
            }
        });

        JSON.setFont(new java.awt.Font("Yu Gothic", 0, 12)); // NOI18N
        JSON.setText("Generar JSON");
        JSON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JSONActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 70)); // NOI18N
        jLabel7.setText("🙋🏽");

        sfds.setFont(new java.awt.Font("Yu Gothic", 3, 24)); // NOI18N
        sfds.setText("LISTADO DE USUARIOS");

        label1.setFont(new java.awt.Font("Yu Gothic", 3, 24)); // NOI18N
        label1.setText("CONFIGURACIÓN DE USUARIOS");

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel1.setText("⚙️");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 45)); // NOI18N
        jLabel2.setText("🔎");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel3.setText("🙇🏽");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel4.setText("👶🏽");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel5.setText("💻");

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel6.setText("🖇️");

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel8.setText("🔐");

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel9.setText("📧");

        jDesktopPane1.setLayer(nombretxt, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(Idtxt, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(añotext, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(apellidotxt, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(emailtxt, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(crearpersona, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(cancelar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(contraseñatxt, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(label3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(label4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(label5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(label6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(label7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(label8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(Modificar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(borrardatos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(XML, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(JSON, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(sfds, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(label1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel3))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4)))
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(241, 241, 241)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                        .addGap(419, 419, 419)
                                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(XML, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(JSON, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                        .addGap(111, 111, 111)
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                                .addGap(0, 122, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(58, 58, 58)
                                .addComponent(sfds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(213, 213, 213))))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(crearpersona, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Idtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                    .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(64, 64, 64)
                                    .addComponent(jLabel7))
                                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(nombretxt, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(apellidotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(añotext, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(contraseñatxt, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(emailtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(74, 74, 74))
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(285, 285, 285)
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(borrardatos, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Idtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombretxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(apellidotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(añotext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contraseñatxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelar)
                    .addComponent(crearpersona))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(sfds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(borrardatos, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JSON))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Modificar)
                    .addComponent(XML))
                .addGap(0, 55, Short.MAX_VALUE))
        );

        sfds.getAccessibleContext().setAccessibleName("ffefe");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_cancelarActionPerformed

    private void contraseñatxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contraseñatxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contraseñatxtActionPerformed

    private void IdtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdtxtActionPerformed

    }//GEN-LAST:event_IdtxtActionPerformed

    private void crearpersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearpersonaActionPerformed
        Persona crearper = new Persona();
        crearper.setId(Idtxt.getText());
        crearper.setNombre(nombretxt.getText());
        crearper.setApellido(apellidotxt.getText());
        crearper.setAñoNac(añotext.getText());
        crearper.setContraseña(contraseñatxt.getText());
        crearper.setCorreo(emailtxt.getText());
        datospersona.setPersona(crearper);
        limpiarcampos();
    }//GEN-LAST:event_crearpersonaActionPerformed

    private void nombretxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombretxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombretxtActionPerformed

    private void apellidotxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apellidotxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apellidotxtActionPerformed

    private void emailtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailtxtActionPerformed

    private void añotextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añotextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_añotextActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        modificar = this.jTable1.getSelectedRow();
        var Persona = (Persona) this.Arraypersonas.get(modificar);
        Idtxt.setText(String.valueOf(jTable1.getValueAt(modificar, 0)));
        nombretxt.setText(String.valueOf(jTable1.getValueAt(modificar, 1)));
        apellidotxt.setText(String.valueOf(jTable1.getValueAt(modificar, 2)));
        añotext.setText(String.valueOf(jTable1.getValueAt(modificar, 3)));
        emailtxt.setText(String.valueOf(jTable1.getValueAt(modificar, 4)));
        contraseñatxt.setText(String.valueOf(jTable1.getValueAt(modificar, 5)));
    }//GEN-LAST:event_jTable1MouseClicked

    private void ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarActionPerformed
        mod = true;
        Persona crearper = new Persona();
        crearper.setId(Idtxt.getText());
        crearper.setNombre(nombretxt.getText());
        crearper.setApellido(apellidotxt.getText());
        crearper.setAñoNac(añotext.getText());
        crearper.setContraseña(contraseñatxt.getText());
        crearper.setCorreo(emailtxt.getText());
        datospersona.setValueRow(crearper, modificar);
        limpiarcampos();
    }//GEN-LAST:event_ModificarActionPerformed

    private void borrardatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrardatosActionPerformed
        int rowIndex = jTable1.getSelectedRow();
        if (rowIndex >= 0) {
            datospersona.removeRow(rowIndex);
            limpiarcampos();
        }
    }//GEN-LAST:event_borrardatosActionPerformed

    private void XMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XMLActionPerformed
       crearPersonaXML();
    }//GEN-LAST:event_XMLActionPerformed

    private void JSONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JSONActionPerformed
        crearpersonaJson();
    }//GEN-LAST:event_JSONActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Idtxt;
    private javax.swing.JButton JSON;
    private javax.swing.JButton Modificar;
    private javax.swing.JButton XML;
    private javax.swing.JTextField apellidotxt;
    private javax.swing.JTextField añotext;
    private javax.swing.JButton borrardatos;
    private javax.swing.JButton cancelar;
    private javax.swing.JPasswordField contraseñatxt;
    private javax.swing.JButton crearpersona;
    private javax.swing.JTextField emailtxt;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField11;
    private java.awt.Label label1;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Label label6;
    private java.awt.Label label7;
    private java.awt.Label label8;
    private javax.swing.JTextField nombretxt;
    private java.awt.Label sfds;
    // End of variables declaration//GEN-END:variables
}
