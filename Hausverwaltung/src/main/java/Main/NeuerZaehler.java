/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main;

import Objects.MessdatenEintrag;
import Utility.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Properties;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/**
 *
 * @author Phineas Gaming
 */
public class NeuerZaehler extends javax.swing.JFrame {

    DataIO io;
    JDatePickerImpl picker;
    private final int zaehlerwechsel;
    private final MessdatenEintrag uebergabe;
    
    private JTextField textfieldKdNr;
    private JTextField textfieldHsNr;
    private JTextField textfieldWhNr;
    private JComboBox comboBoxArt;
    private JTextField textfieldZaeNr;
    private JTextField textfieldKrStr;
    private JTextField textfieldHsStr;
    private JTextField textfieldKomm;
    
    /**
     * Creates new form NeuerZaehler
     * @param io
     * @param zaehlerwechsel
     * @param uebergabe
     */
    public NeuerZaehler(DataIO io, int zaehlerwechsel, MessdatenEintrag uebergabe) {
        initComponents();
        
        this.io = io;
        this.zaehlerwechsel = zaehlerwechsel;
        this.uebergabe = uebergabe;
        
        jPanel1.setLayout(new GridLayout(0,2));
        
        JLabel l1 = new JLabel("Kundennummer");
        textfieldKdNr = new JTextField();
        textfieldKdNr.setDocument(new TextFieldFilter(TextFieldFilter.NUMERIC));
        jPanel1.add(l1);
        jPanel1.add(textfieldKdNr);
        
        JLabel l2 = new JLabel("Hausnummer");
        textfieldHsNr = new JTextField();
        jPanel1.add(l2);
        jPanel1.add(textfieldHsNr);
        
        JLabel l4 = new JLabel("Wohnungsnummer");
        textfieldWhNr = new JTextField();
        textfieldWhNr.setDocument(new TextFieldFilter(TextFieldFilter.NUMERIC));
        jPanel1.add(l4);
        jPanel1.add(textfieldWhNr);
        
        JLabel l5 = new JLabel("Art");
        String[] arten = {"Strom", "Wasser", "Heizung", "Gas"};
        comboBoxArt = new JComboBox(arten);
        comboBoxArt.setSelectedIndex(0);
        //art.addActionListener(this);
        jPanel1.add(l5);
        jPanel1.add(comboBoxArt);
        
        JLabel l6 = new JLabel("Zählernummer");
        textfieldZaeNr = new JTextField();
        textfieldZaeNr.setDocument(new TextFieldFilter(TextFieldFilter.NUMERIC));
        jPanel1.add(l6);
        jPanel1.add(textfieldZaeNr);
        
        JLabel l7 = new JLabel("Ablesedatum");
        jPanel1.add(l7);
        jPanel1.add(initDatePicker());
        
        JLabel l8 = new JLabel("Stand Kraftstrom (kWh)");
        textfieldKrStr = new JTextField();
        textfieldKrStr.setDocument(new TextFieldFilter(TextFieldFilter.NUMERIC + TextFieldFilter.DECIMAL));
        jPanel1.add(l8);
        jPanel1.add(textfieldKrStr);
        
        JLabel l9 = new JLabel("Stand Haushaltsstrom (kWh)");
        textfieldHsStr = new JTextField();
        textfieldHsStr.setDocument(new TextFieldFilter(TextFieldFilter.NUMERIC + TextFieldFilter.DECIMAL));
        jPanel1.add(l9);
        jPanel1.add(textfieldHsStr);
        
        JLabel l10 = new JLabel("Kommentar");
        textfieldKomm = new JTextField();
        jPanel1.add(l10);
        jPanel1.add(textfieldKomm);
        
        if(uebergabe != null){
            initTextFields();
        }
        
        
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        add(southPanel, BorderLayout.SOUTH);
        
        JButton btnSave = new JButton("save");
        southPanel.add(btnSave);
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean wechsel = false;
                if(zaehlerwechsel == Constants.WECHSEL_JA){
                    wechsel = true;
                }
                
                // check input (empty...)
                if(!checkFields()){
                    return;
                }
                
                save(
                        Integer.parseInt(textfieldKdNr.getText()),
                        textfieldHsNr.getText(),
                        Integer.parseInt(textfieldWhNr.getText()),
                        comboBoxArt.getSelectedItem().toString(),
                        Integer.parseInt(textfieldZaeNr.getText()),
                        getDateAsInt(picker.getModel().getValue()),
                        wechsel,
                        Float.parseFloat(textfieldKrStr.getText()),
                        Float.parseFloat(textfieldHsStr.getText()),
                        textfieldKomm.getText()
                );
            }
        });
        
        
        setSize(400,300);
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Neuen Zähler erfassen");
        setAlwaysOnTop(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel1.setLayout(new java.awt.GridLayout(10, 2));
        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     * @param io
     * @param zaehlerwechsel
     * @param uebergabe
     */
    public static void main(String args[], DataIO io, int zaehlerwechsel, MessdatenEintrag uebergabe) {
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
            java.util.logging.Logger.getLogger(NeuerZaehler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NeuerZaehler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NeuerZaehler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NeuerZaehler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NeuerZaehler(io, zaehlerwechsel, uebergabe).setVisible(true);
            }
        });
    }
    
    public void save(int kundennr, String hausnr, int wohnungsnr, String zaehlerart, int zaehlernr, int ablesedatum, boolean zahlerwechsel, float zaehlerstandK, float zaehlerstandH, String kommentar)
    {        
        io.addEntry(kundennr, hausnr, wohnungsnr, zaehlerart, zaehlernr, ablesedatum, zahlerwechsel, zaehlerstandK, zaehlerstandH, kommentar);

        if(zaehlerwechsel == Constants.WECHSEL_SETZEN){
            MessdatenEintrag e = new MessdatenEintrag(kundennr, hausnr, wohnungsnr, zaehlerart, zaehlernr, ablesedatum, zahlerwechsel, zaehlerstandK, zaehlerstandH, kommentar);
            NeuerZaehler neu = new NeuerZaehler(io, Constants.WECHSEL_JA, e);
            neu.setTitle("Neuen Zähler einlesen");
            neu.setVisible(true);
        }
        dispose();
    }
    
    private JDatePickerImpl initDatePicker()
    {
        UtilDateModel model = new UtilDateModel();
        LocalDate today = LocalDate.now();
        model.setDate(today.getYear(), today.getMonthValue() - 1, today.getDayOfMonth());
        model.setSelected(true);
        
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        picker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        //picker.setTextEditable(true);
        picker.setDoubleClickAction(true);
        
        return picker;
    }
    
    private int getDateAsInt(Object pickerDate)
    {
        Date date = (Date) pickerDate;
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyyMMdd");
        return Integer.parseInt(dateFormatter.format(date));
    }
    
    private void initTextFields() {
        textfieldKdNr.setText(String.valueOf(uebergabe.getKundennr()));
        textfieldHsNr.setText(uebergabe.getHausnr());
        textfieldWhNr.setText(String.valueOf(uebergabe.getWohnungsnr()));
        comboBoxArt.setSelectedItem(uebergabe.getZaehlerart());
        textfieldZaeNr.setText(String.valueOf(uebergabe.getZaehlernr()));
    }
    
    private boolean checkFields()
    {
        boolean valid = true;
        
        if(textfieldKdNr.getText() == null || textfieldKdNr.getText().isBlank()){
            textfieldKdNr.setBackground(Color.red);
            valid = false;
        }else{
            textfieldKdNr.setBackground(null);
        }
        if(textfieldHsNr.getText() == null || textfieldHsNr.getText().isBlank()){
            textfieldHsNr.setBackground(Color.red);
            valid = false;
        }else{
            textfieldHsNr.setBackground(null);
        }
        if(textfieldWhNr.getText() == null || textfieldWhNr.getText().isBlank()){
            textfieldWhNr.setBackground(Color.red);
            valid = false;
        }else{
            textfieldWhNr.setBackground(null);
        }
        if(textfieldZaeNr.getText() == null || textfieldZaeNr.getText().isBlank()){
            textfieldZaeNr.setBackground(Color.red);
            valid = false;
        }else{
            textfieldZaeNr.setBackground(null);
        }
        if(textfieldKrStr.getText() == null || textfieldKrStr.getText().isBlank()){
            textfieldKrStr.setBackground(Color.red);
            valid = false;
        }else{
            textfieldKrStr.setBackground(null);
        }
        if(textfieldHsStr.getText() == null || textfieldHsStr.getText().isBlank()){
            textfieldHsStr.setBackground(Color.red);
            valid = false;
        }else{
            textfieldHsStr.setBackground(null);
        }
        
        return valid;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    
}
