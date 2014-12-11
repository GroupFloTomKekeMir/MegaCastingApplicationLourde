/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.iia.MegaCasting;

import fr.iia.Class.Adresse;
import fr.iia.Class.Annonceur;
import fr.iia.Class.Diffuseur;
import fr.iia.Class.Evenement;
import fr.iia.Class.Musique;
import fr.iia.Class.Offre;
import fr.iia.Connection.JavaConnect;
import static fr.iia.Connection.JavaConnect.ConnectDB;
import static fr.iia.Connection.JavaConnect.ImportDriver;
import fr.iia.DAO.AnnonceursDAO;
import fr.iia.DAO.DiffuseursDAO;
import fr.iia.DAO.EvenementDAO;
import fr.iia.DAO.MusiqueDAO;
import fr.iia.DAO.OffreDAO;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author Enzo
 */
public class MegaCastingMain extends javax.swing.JFrame {


    Connection cnx = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    /**
     * Creates new form MegaCastingMain
     */
    public MegaCastingMain() {
        initComponents();
        ImportDriver();
        cnx = JavaConnect.ConnectDB();
        
        refreshAllList();
    }
    
    private void offreListe(){
        DefaultTableModel model = (DefaultTableModel) offreTab.getModel();
        model.setNumRows(0);
        OffreDAO offreDAO = new OffreDAO();
        Collection<Offre> offre = offreDAO.lister(cnx);
        
        for(Offre o : offre){
            model.addRow(new Object[]{
                o.getTitre(),
                o.getReference(),
                o.getDate_debut_publi(),
                o.getFin_publi(),
                o.getNbr_poste(),
                o.getDescription_poste(),
                o.getDescription_profil(),
                o.getTelephone(),
                o.getDuree(),
                o.getContrat(),
                o.getAnnonceur(),
                o.getDiffuseur(),
                o.getMetier()              
            });
        }     
    }
    
    public void paintComponent(Graphics g){
    try {
      Image img = ImageIO.read(new File("Fond.jpg"));
      //g.drawImage(img, 50, 50, this);
      //Pour une image de fond
      g.drawImage(img, 50, 50, this.getWidth(), this.getHeight(), this);
    } catch (IOException e) {
      e.printStackTrace();
    }  
  }        

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        page = new javax.swing.JTabbedPane();
        AccueilPanel = new javax.swing.JPanel();
        offrePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        offreTab = new javax.swing.JTable();
        updateOffre = new javax.swing.JButton();
        annonceurPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        annonceurTab = new javax.swing.JTable();
        updateAnnonceurs = new javax.swing.JButton();
        diffuseurPanel = new javax.swing.JPanel();
        updateDiffuseur = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        diffuseurTab = new javax.swing.JTable();
        evenementPanel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        evenementTab = new javax.swing.JTable();
        updateEvenement = new javax.swing.JButton();
        musiquePanel = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        musiqueTab = new javax.swing.JTable();
        updateMusique = new javax.swing.JButton();
        barreMenu = new javax.swing.JMenuBar();
        fichierMenu = new javax.swing.JMenu();
        ajouterMenuFichier = new javax.swing.JMenu();
        offreMenuAjouter = new javax.swing.JMenuItem();
        annonceurMenuAjouter = new javax.swing.JMenuItem();
        diffuseurMenuAjouter = new javax.swing.JMenuItem();
        evenementMenuAjouter = new javax.swing.JMenuItem();
        musiqueMenuAjouter = new javax.swing.JMenuItem();
        modifierMenuFichier = new javax.swing.JMenu();
        offreMenuModifier = new javax.swing.JMenuItem();
        annonceurMenuModifier = new javax.swing.JMenuItem();
        diffuseurMenuModifier = new javax.swing.JMenuItem();
        evenementMenuModifier = new javax.swing.JMenuItem();
        musiqueMenuModifier = new javax.swing.JMenuItem();
        imprimerMenuFichier = new javax.swing.JMenuItem();
        quitterMenuFichier = new javax.swing.JMenuItem();
        editionMenu = new javax.swing.JMenu();
        aideMenu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Méga Casting");
        setResizable(false);

        javax.swing.GroupLayout AccueilPanelLayout = new javax.swing.GroupLayout(AccueilPanel);
        AccueilPanel.setLayout(AccueilPanelLayout);
        AccueilPanelLayout.setHorizontalGroup(
            AccueilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1261, Short.MAX_VALUE)
        );
        AccueilPanelLayout.setVerticalGroup(
            AccueilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );

        page.addTab("Accueil", AccueilPanel);

        offreTab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Titre", "Référence", "Début publication", "Fin publication", "Nombre de poste", "Description du poste", "Description du profil", "Durée du contrat(mois)", "Contrat", "Annonceur", "Diffuseur", "Metier"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        offreTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                offreTabMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(offreTab);

        updateOffre.setText("Mise à jour");
        updateOffre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateOffreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout offrePanelLayout = new javax.swing.GroupLayout(offrePanel);
        offrePanel.setLayout(offrePanelLayout);
        offrePanelLayout.setHorizontalGroup(
            offrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(offrePanelLayout.createSequentialGroup()
                .addGroup(offrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(updateOffre)
                    .addGroup(offrePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        offrePanelLayout.setVerticalGroup(
            offrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, offrePanelLayout.createSequentialGroup()
                .addComponent(updateOffre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        page.addTab("Offres", offrePanel);

        annonceurTab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nom", "Email", "Telephone", "N° rue", "Nom rue", "Code Postal", "Ville", "Region", "Logo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(annonceurTab);

        updateAnnonceurs.setText("Mise à jour");
        updateAnnonceurs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateAnnonceursActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout annonceurPanelLayout = new javax.swing.GroupLayout(annonceurPanel);
        annonceurPanel.setLayout(annonceurPanelLayout);
        annonceurPanelLayout.setHorizontalGroup(
            annonceurPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1261, Short.MAX_VALUE)
            .addGroup(annonceurPanelLayout.createSequentialGroup()
                .addComponent(updateAnnonceurs)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        annonceurPanelLayout.setVerticalGroup(
            annonceurPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, annonceurPanelLayout.createSequentialGroup()
                .addComponent(updateAnnonceurs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        page.addTab("Annonceurs", annonceurPanel);

        updateDiffuseur.setText("Mise à jour");
        updateDiffuseur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateDiffuseurActionPerformed(evt);
            }
        });

        diffuseurTab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nom", "Email", "Telephone", "N° rue", "Nom rue", "Code Postal", "Ville", "Region", "Logo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane6.setViewportView(diffuseurTab);

        javax.swing.GroupLayout diffuseurPanelLayout = new javax.swing.GroupLayout(diffuseurPanel);
        diffuseurPanel.setLayout(diffuseurPanelLayout);
        diffuseurPanelLayout.setHorizontalGroup(
            diffuseurPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(diffuseurPanelLayout.createSequentialGroup()
                .addComponent(updateDiffuseur)
                .addGap(0, 1176, Short.MAX_VALUE))
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1261, Short.MAX_VALUE)
        );
        diffuseurPanelLayout.setVerticalGroup(
            diffuseurPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, diffuseurPanelLayout.createSequentialGroup()
                .addComponent(updateDiffuseur)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        page.addTab("Diffuseurs", diffuseurPanel);

        evenementTab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nom", "Description", "Date", "N° Rue", "Nom Rue", "Code Postal", "Ville", "Region", "Annonceur"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(evenementTab);

        updateEvenement.setText("Mise à jour");

        javax.swing.GroupLayout evenementPanelLayout = new javax.swing.GroupLayout(evenementPanel);
        evenementPanel.setLayout(evenementPanelLayout);
        evenementPanelLayout.setHorizontalGroup(
            evenementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(evenementPanelLayout.createSequentialGroup()
                .addComponent(updateEvenement)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1261, Short.MAX_VALUE)
        );
        evenementPanelLayout.setVerticalGroup(
            evenementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, evenementPanelLayout.createSequentialGroup()
                .addComponent(updateEvenement)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        page.addTab("Evenements", evenementPanel);

        musiqueTab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Titre", "Description", "Genre", "Artiste"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane5.setViewportView(musiqueTab);

        updateMusique.setText("Mise à jour");

        javax.swing.GroupLayout musiquePanelLayout = new javax.swing.GroupLayout(musiquePanel);
        musiquePanel.setLayout(musiquePanelLayout);
        musiquePanelLayout.setHorizontalGroup(
            musiquePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(musiquePanelLayout.createSequentialGroup()
                .addGroup(musiquePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(musiquePanelLayout.createSequentialGroup()
                        .addComponent(updateMusique)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1251, Short.MAX_VALUE))
                .addContainerGap())
        );
        musiquePanelLayout.setVerticalGroup(
            musiquePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(musiquePanelLayout.createSequentialGroup()
                .addComponent(updateMusique)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        page.addTab("Musiques", musiquePanel);

        fichierMenu.setText("Fichier");

        ajouterMenuFichier.setText("Ajouter");

        offreMenuAjouter.setText("Offres");
        offreMenuAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                offreMenuAjouterActionPerformed(evt);
            }
        });
        ajouterMenuFichier.add(offreMenuAjouter);

        annonceurMenuAjouter.setText("Annonceurs");
        annonceurMenuAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                annonceurMenuAjouterActionPerformed(evt);
            }
        });
        ajouterMenuFichier.add(annonceurMenuAjouter);

        diffuseurMenuAjouter.setText("Diffuseurs");
        ajouterMenuFichier.add(diffuseurMenuAjouter);

        evenementMenuAjouter.setText("Evènements");
        evenementMenuAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                evenementMenuAjouterActionPerformed(evt);
            }
        });
        ajouterMenuFichier.add(evenementMenuAjouter);

        musiqueMenuAjouter.setText("Musiques");
        ajouterMenuFichier.add(musiqueMenuAjouter);

        fichierMenu.add(ajouterMenuFichier);

        modifierMenuFichier.setText("Modifier");

        offreMenuModifier.setText("Offres");
        modifierMenuFichier.add(offreMenuModifier);

        annonceurMenuModifier.setText("Annonceurs");
        modifierMenuFichier.add(annonceurMenuModifier);

        diffuseurMenuModifier.setText("Diffuseurs");
        modifierMenuFichier.add(diffuseurMenuModifier);

        evenementMenuModifier.setText("Evènements");
        modifierMenuFichier.add(evenementMenuModifier);

        musiqueMenuModifier.setText("Musiques");
        modifierMenuFichier.add(musiqueMenuModifier);

        fichierMenu.add(modifierMenuFichier);

        imprimerMenuFichier.setText("Imprimer");
        fichierMenu.add(imprimerMenuFichier);

        quitterMenuFichier.setText("Quitter");
        fichierMenu.add(quitterMenuFichier);

        barreMenu.add(fichierMenu);

        editionMenu.setText("Edition");
        barreMenu.add(editionMenu);

        aideMenu.setText("Aide");
        aideMenu.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        aideMenu.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jMenuItem1.setText("Docs  en ligne et support");
        aideMenu.add(jMenuItem1);

        jMenuItem2.setText("A propos");
        aideMenu.add(jMenuItem2);

        barreMenu.add(aideMenu);

        setJMenuBar(barreMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(page)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(page)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refreshAllList() {
        refreshListAnnonceur();
        refreshListDiffuseur();
        refreshListEvenement();
        refreshListMusique();
        refreshListOffre();
    }
    
    private void refreshListAnnonceur() {
        DefaultTableModel model = (DefaultTableModel) annonceurTab.getModel();
        model.setNumRows(0);
        
        AnnonceursDAO annonceurDao = new AnnonceursDAO();
        Collection<Annonceur> annonceurs = AnnonceursDAO.lister(cnx);
        
        for(Annonceur a : annonceurs) {
            model.addRow(new Object[]{
                a.getNom(),
                a.getMail(),
                a.getNumeroTel(),
                a.getAdresse().getNumero(),
                a.getAdresse().getRue(),
                a.getAdresse().getCodePostal(),
                a.getAdresse().getVille(),
                a.getAdresse().getLocalisation()
            });
        }
    }
    
    private void refreshListDiffuseur() {
        DefaultTableModel model = (DefaultTableModel) diffuseurTab.getModel();
        model.setNumRows(0);
        
        DiffuseursDAO diffuseurDAO = new DiffuseursDAO();
        Collection<Diffuseur> diffuseurs = DiffuseursDAO.lister(cnx);
        
        for(Diffuseur d : diffuseurs) {
            model.addRow(new Object[]{
                d.getNom(),
                d.getMail(),
                d.getNumeroTel(),
                d.getAdresse().getNumero(),
                d.getAdresse().getRue(),
                d.getAdresse().getCodePostal(),
                d.getAdresse().getVille(),
                d.getAdresse().getLocalisation()
            });
        }
    }
    
    private void refreshListOffre() {
        DefaultTableModel model = (DefaultTableModel) offreTab.getModel();
        model.setNumRows(0);
        
        OffreDAO offreDAO = new OffreDAO();
        Collection<Offre> offres = OffreDAO.lister(cnx);
        
        for(Offre o : offres) {
            model.addRow(new Object[]{
                o.getTitre(),
                o.getReference(),
                o.getDate_debut_publi(),
                o.getFin_publi(),
                o.getNbr_poste(),
                o.getDescription_poste(),
                o.getDescription_profil(),
                o.getDuree(),
                o.getContrat().getLibelle(),
                o.getAnnonceur().getNom(),
                o.getDiffuseur().getNom(),
                o.getMetier().getLibelle()
            });
        }
    }
    
    private void refreshListEvenement() {
        DefaultTableModel model = (DefaultTableModel) evenementTab.getModel();
        model.setNumRows(0);
        
        EvenementDAO evenementDAO = new EvenementDAO();
        Collection<Evenement> evenements = EvenementDAO.lister(cnx);
        
        for(Evenement e : evenements) {
            model.addRow(new Object[]{
                e.getNom(),
                e.getDescription(),
                e.getDate().toString(),
                e.getAdresse().getNumero(),
                e.getAdresse().getRue(),
                e.getAdresse().getCodePostal(),
                e.getAdresse().getVille(),
                e.getAdresse().getLocalisation(),
                e.getAnnonceur().getNom()
            });
        }
    }
    
    private void refreshListMusique() {
        DefaultTableModel model = (DefaultTableModel) musiqueTab.getModel();
        model.setNumRows(0);
        
        MusiqueDAO musiqueDAO = new MusiqueDAO();
        Collection<Musique> musiques = MusiqueDAO.lister(cnx);
        
        for(Musique m : musiques) {
            model.addRow(new Object[]{
                m.getTitre(),
                m.getDescription(),
                m.getGenre(),
                m.getUtilisateur().getNom_artiste()
            });
        }
    }
    
    private void evenementMenuAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_evenementMenuAjouterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_evenementMenuAjouterActionPerformed

    private void offreMenuAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_offreMenuAjouterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_offreMenuAjouterActionPerformed

    private void annonceurMenuAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_annonceurMenuAjouterActionPerformed
        // TODO add your handling code here:
        ajouterAnnonceur ajouterAnnonceurFrame = new ajouterAnnonceur();
        ajouterAnnonceurFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ajouterAnnonceurFrame.setSize(300, 300);
        ajouterAnnonceurFrame.setVisible(true);
    }//GEN-LAST:event_annonceurMenuAjouterActionPerformed

    private void offreTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_offreTabMouseClicked
        // TODO add your handling code here:
        try {
            int row = offreTab.getSelectedRow();
            String Table_click = (offreTab.getModel().getValueAt(row, 0).toString());
            String sql = "SELECT * FROM Offre WHERE id_offre ='" + Table_click + "' ";
            pst = cnx.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                String add1  = rs.getString("");
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_offreTabMouseClicked

    private void updateOffreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateOffreActionPerformed
        // TODO add your handling code here:
        
        String nom = JOptionPane.showInputDialog("Entrer votre nom");
        String name = JOptionPane.showInputDialog("Entrer votre nom");

        offreTab.getModel().setValueAt(name, offreTab.getSelectedRow(), 0);
        
    }//GEN-LAST:event_updateOffreActionPerformed

    private void updateAnnonceursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateAnnonceursActionPerformed
        // TODO add your handling code here:
        String nom = .getText();
        String prenom = textFieldFirstName.getText();
        int age = (int) spinnerAge.getValue();
        
        int num = (int) spinnerNumber.getValue();
        String rue = textFieldNameStreet.getText();
        int codePostal = Integer.parseInt(textFieldZip.getText());
        String ville = textFieldCity.getText();
        
        PersonneDao personneDao = new PersonneDao();
        Personne personne = PersonneDao.trouver(cnx, nom, prenom);
        
        if (personne == null) {
            Adresse adresse = new Adresse(codePostal, rue, ville);
            personne = new Personne(nom, prenom, age, adresse);
            
            try {
                PersonneDao.creer(cnx, personne);
                
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            
            personne.setNom(nom);
            personne.setPrenom(prenom);
            personne.setAge(age);
            
            Adresse adresse = personne.getAdresse();
            adresse.setNumero(num);
            adresse.setRue(rue);
            adresse.setCodePostal(codePostal);
            adresse.setVille(ville);
            
            try {
                personneDao.modifier(cnx, personne);
            } catch (Exception ex) {
                
            }
        }
        
        refreshListAnnonceur();
    }//GEN-LAST:event_updateAnnonceursActionPerformed

    private void updateDiffuseurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateDiffuseurActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateDiffuseurActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MegaCastingMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MegaCastingMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MegaCastingMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MegaCastingMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MegaCastingMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AccueilPanel;
    private javax.swing.JMenu aideMenu;
    private javax.swing.JMenu ajouterMenuFichier;
    private javax.swing.JMenuItem annonceurMenuAjouter;
    private javax.swing.JMenuItem annonceurMenuModifier;
    private javax.swing.JPanel annonceurPanel;
    private javax.swing.JTable annonceurTab;
    private javax.swing.JMenuBar barreMenu;
    private javax.swing.JMenuItem diffuseurMenuAjouter;
    private javax.swing.JMenuItem diffuseurMenuModifier;
    private javax.swing.JPanel diffuseurPanel;
    private javax.swing.JTable diffuseurTab;
    private javax.swing.JMenu editionMenu;
    private javax.swing.JMenuItem evenementMenuAjouter;
    private javax.swing.JMenuItem evenementMenuModifier;
    private javax.swing.JPanel evenementPanel;
    private javax.swing.JTable evenementTab;
    private javax.swing.JMenu fichierMenu;
    private javax.swing.JMenuItem imprimerMenuFichier;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JMenu modifierMenuFichier;
    private javax.swing.JMenuItem musiqueMenuAjouter;
    private javax.swing.JMenuItem musiqueMenuModifier;
    private javax.swing.JPanel musiquePanel;
    private javax.swing.JTable musiqueTab;
    private javax.swing.JMenuItem offreMenuAjouter;
    private javax.swing.JMenuItem offreMenuModifier;
    private javax.swing.JPanel offrePanel;
    private javax.swing.JTable offreTab;
    private javax.swing.JTabbedPane page;
    private javax.swing.JMenuItem quitterMenuFichier;
    private javax.swing.JButton updateAnnonceurs;
    private javax.swing.JButton updateDiffuseur;
    private javax.swing.JButton updateEvenement;
    private javax.swing.JButton updateMusique;
    private javax.swing.JButton updateOffre;
    // End of variables declaration//GEN-END:variables
}
