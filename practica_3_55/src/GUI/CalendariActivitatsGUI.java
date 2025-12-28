package GUI;

import ActivitatsPackage.*;
import UsuarisPackage.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CalendariActivitatsGUI extends JFrame{
    private LlistaActivitats llistaActivitats;
    private LlistaInscripcio llistaInscripcions;
    private JTable taulaActivitats;
    private DefaultTableModel modelTaula;
    private JComboBox<String> comboFiltreTipus;
    private JComboBox<String> comboFiltreEstat;
    private JTextField campFiltreNom;
    private JLabel etiquetaDataActual;
    private JButton botoAnterior;
    private JButton botoSeguent;
    private LocalDate dataVisualitzada;
    
    public CalendariActivitatsGUI(LlistaActivitats activitats, LlistaInscripcio inscripcions) {
        this.llistaActivitats = activitats;
        this.llistaInscripcions = inscripcions;
        this.dataVisualitzada = LocalDate.now();
        
        inicialitzarComponents();
        configurarFinestra();
        actualitzarTaula();
    }
    
    private void inicialitzarComponents() {
        // Configurar el disseny principal
        setLayout(new BorderLayout(10, 10));
        
        // Panell superior amb filtres
        JPanel panellSuperior = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        panellSuperior.setBorder(BorderFactory.createTitledBorder("Filtres"));
        
        // Filtre per tipus d'activitat
        panellSuperior.add(new JLabel("Tipus:"));
        comboFiltreTipus = new JComboBox<>(new String[]{"Totes", "Un Dia", "Periòdiques", "Online"});
        panellSuperior.add(comboFiltreTipus);
        
        // Filtre per estat
        panellSuperior.add(new JLabel("Estat:"));
        comboFiltreEstat = new JComboBox<>(new String[]{"Totes", "Pendents", "Finalitzades"});
        panellSuperior.add(comboFiltreEstat);
        
        // Filtre per nom
        panellSuperior.add(new JLabel("Nom:"));
        campFiltreNom = new JTextField(15);
        panellSuperior.add(campFiltreNom);
        
        // Botó per aplicar filtres
        JButton botoFiltrar = new JButton("Filtrar");
        botoFiltrar.addActionListener(e -> actualitzarTaula());
        panellSuperior.add(botoFiltrar);
        
        add(panellSuperior, BorderLayout.NORTH);
        
        // Panell central amb navegació de data
        JPanel panellNavegacio = new JPanel(new BorderLayout());
        
        // Botons de navegació
        JPanel panellBotonsData = new JPanel(new FlowLayout());
        botoAnterior = new JButton("◀ Anterior");
        botoSeguent = new JButton("Seguent ▶");
        
        botoAnterior.addActionListener(e -> {
            dataVisualitzada = dataVisualitzada.minusDays(7);
            actualitzarTaula();
        });
        
        botoSeguent.addActionListener(e -> {
            dataVisualitzada = dataVisualitzada.plusDays(7);
            actualitzarTaula();
        });
        
        panellBotonsData.add(botoAnterior);
        panellBotonsData.add(botoSeguent);
        
        // Etiqueta amb la data actual
        etiquetaDataActual = new JLabel();
        etiquetaDataActual.setHorizontalAlignment(SwingConstants.CENTER);
        etiquetaDataActual.setFont(new Font("Arial", Font.BOLD, 14));
        actualitzarEtiquetaData();
        
        panellNavegacio.add(panellBotonsData, BorderLayout.WEST);
        panellNavegacio.add(etiquetaDataActual, BorderLayout.CENTER);
        
        // Botó per tornar al dia actual
        JButton botoAvui = new JButton("Avui");
        botoAvui.addActionListener(e -> {
            dataVisualitzada = LocalDate.now();
            actualitzarTaula();
        });
        
        JPanel panellAvui = new JPanel(new FlowLayout());
        panellAvui.add(botoAvui);
        panellNavegacio.add(panellAvui, BorderLayout.EAST);
        
        add(panellNavegacio, BorderLayout.CENTER);
        
        // Taula d'activitats
        String[] columnes = {"Nom", "Data Inici", "Data Fi", "Tipus", "Estat", "Participants", "Valoració"};
        modelTaula = new DefaultTableModel(columnes, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Taula no editable
            }
        };
        
        taulaActivitats = new JTable(modelTaula);
        taulaActivitats.setRowHeight(25);
        taulaActivitats.getColumnModel().getColumn(0).setPreferredWidth(150);
        taulaActivitats.getColumnModel().getColumn(1).setPreferredWidth(80);
        taulaActivitats.getColumnModel().getColumn(2).setPreferredWidth(80);
        taulaActivitats.getColumnModel().getColumn(3).setPreferredWidth(80);
        
        // Permetre ordenació per columnes
        taulaActivitats.setAutoCreateRowSorter(true);
        
        JScrollPane scrollPane = new JScrollPane(taulaActivitats);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Calendari d'Activitats"));
        
        add(scrollPane, BorderLayout.SOUTH);
        
        // Panell inferior amb informació
        JPanel panellInferior = new JPanel(new BorderLayout());
        panellInferior.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JLabel etiquetaInfo = new JLabel("Doble clic a una activitat per veure més detalls");
        etiquetaInfo.setHorizontalAlignment(SwingConstants.CENTER);
        panellInferior.add(etiquetaInfo, BorderLayout.CENTER);
        
        // Botó per exportar
        JButton botoExportar = new JButton("Exportar a PDF");
        botoExportar.addActionListener(e -> exportarAPDF());
        panellInferior.add(botoExportar, BorderLayout.EAST);
        
        add(panellInferior, BorderLayout.SOUTH);
        
        // Afegir listener per doble clic
        taulaActivitats.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    mostrarDetallsActivitat();
                }
            }
        });
    }
    
    private void configurarFinestra() {
        setTitle("Calendari d'Activitats - URV");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Icona de la finestra
        try {
            setIconImage(new ImageIcon(getClass().getResource("/icona.png")).getImage());
        } catch (Exception e) {
            // Si no hi ha icona, continuar sense ella
        }
    }
    
    private void actualitzarEtiquetaData() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataInici = dataVisualitzada.minusDays(3).format(formatter);
        String dataFi = dataVisualitzada.plusDays(3).format(formatter);
        etiquetaDataActual.setText("Setmana del " + dataInici + " al " + dataFi);
    }
    
    private void actualitzarTaula() {
        // Netejar la taula
        modelTaula.setRowCount(0);
        
        // Obtenir paràmetres de filtratge
        String tipusSeleccionat = (String) comboFiltreTipus.getSelectedItem();
        String estatSeleccionat = (String) comboFiltreEstat.getSelectedItem();
        String textFiltre = campFiltreNom.getText().trim().toLowerCase();
        
        // Actualitzar etiqueta de data
        actualitzarEtiquetaData();
        
        // Obtenir les activitats filtrades
        List<Activitats> activitatsFiltrades = obtenirActivitatsFiltrades(tipusSeleccionat, estatSeleccionat, textFiltre);
        
        // Afegir files a la taula
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        for (Activitats activitat : activitatsFiltrades) {
            // Verificar si està dins del rang de la setmana visualitzada
            if (estaDinsRangSetmana(activitat)) {
                String tipus = obtenirTipusActivitat(activitat);
                String estat = activitat.haFinalitzat() ? "Finalitzada" : "Pendent";
                
                // Obtenir nombre de participants
                int participants = obtenirNumeroParticipants(activitat);
                
                // Obtenir valoració mitjana
                double valoracio = obtenirValoracioMitjana(activitat);
                
                // Afegir fila a la taula
                modelTaula.addRow(new Object[]{
                    activitat.getNomActivitat(),
                    activitat.getDataINI().format(formatter),
                    activitat.getDataFi().format(formatter),
                    tipus,
                    estat,
                    participants,
                    String.format("%.1f", valoracio)
                });
            }
        }
        
        // Actualitzar títol de la taula amb nombre d'activitats
        ((javax.swing.border.TitledBorder) ((JScrollPane) getContentPane().getComponent(2)).getBorder())
            .setTitle("Calendari d'Activitats (" + modelTaula.getRowCount() + " activitats)");
    }
    
    private List<Activitats> obtenirActivitatsFiltrades(String tipus, String estat, String textFiltre) {
        List<Activitats> resultat = new ArrayList<>();
        
        for (int i = 0; i < llistaActivitats.getNumElements(); i++) {
            Activitats activitat = llistaActivitats.getActivitatPos(i);
            
            // Filtrar per tipus
            if (!"Totes".equals(tipus)) {
                String tipusActivitat = obtenirTipusActivitat(activitat);
                if (!tipus.equals(tipusActivitat)) {
                    continue;
                }
            }
            
            // Filtrar per estat
            if (!"Totes".equals(estat)) {
                boolean finalitzada = activitat.haFinalitzat();
                if (("Pendents".equals(estat) && finalitzada) ||
                    ("Finalitzades".equals(estat) && !finalitzada)) {
                    continue;
                }
            }
            
            // Filtrar per text
            if (!textFiltre.isEmpty() && 
                !activitat.getNomActivitat().toLowerCase().contains(textFiltre)) {
                continue;
            }
            
            resultat.add(activitat);
        }
        
        return resultat;
    }
    
    private boolean estaDinsRangSetmana(Activitats activitat) {
        LocalDate iniciSetmana = dataVisualitzada.minusDays(3);
        LocalDate fiSetmana = dataVisualitzada.plusDays(3);
        
        // L'activitat està dins del rang si comença o acaba dins de la setmana
        // o si la setmana està dins del període de l'activitat
        return (!activitat.getDataINI().isAfter(fiSetmana) && 
                !activitat.getDataFi().isBefore(iniciSetmana));
    }
    
    private String obtenirTipusActivitat(Activitats activitat) {
        if (activitat instanceof ActivitatsUnDia) {
            return "Un Dia";
        } else if (activitat instanceof ActivitatsPeriodiques) {
            return "Periòdiques";
        } else if (activitat instanceof ActivitatsOnline) {
            return "Online";
        }
        return "Desconegut";
    }
    
    private int obtenirNumeroParticipants(Activitats activitat) {
        // Buscar la inscripció corresponent a l'activitat
        for (int i = 0; i < llistaInscripcions.getNumElements(); i++) {
            Inscripcions inscripcio = llistaInscripcions.getInscripcionsPos(i);
            if (inscripcio != null && inscripcio.getActivitat() == activitat) {
                return inscripcio.getLlistaInscrits().getnUsuaris();
            }
        }
        return 0;
    }
    
    private double obtenirValoracioMitjana(Activitats activitat) {
        // Buscar la inscripció corresponent a l'activitat
        for (int i = 0; i < llistaInscripcions.getNumElements(); i++) {
            Inscripcions inscripcio = llistaInscripcions.getInscripcionsPos(i);
            if (inscripcio != null && inscripcio.getActivitat() == activitat) {
                Integer valoracio = inscripcio.getValoracio();
                return valoracio != null ? valoracio : 0.0;
            }
        }
        return 0.0;
    }
    
    private void mostrarDetallsActivitat() {
        int filaSeleccionada = taulaActivitats.getSelectedRow();
        if (filaSeleccionada >= 0) {
            // Obtenir el nom de l'activitat
            String nomActivitat = (String) modelTaula.getValueAt(filaSeleccionada, 0);
            
            // Buscar l'activitat a la llista
            Activitats activitat = null;
            for (int i = 0; i < llistaActivitats.getNumElements(); i++) {
                Activitats a = llistaActivitats.getActivitatPos(i);
                if (a.getNomActivitat().equals(nomActivitat)) {
                    activitat = a;
                    break;
                }
            }
            
            if (activitat != null) {
                // Crear finestra de detalls
                JDialog dialog = new JDialog(this, "Detalls de l'Activitat", true);
                dialog.setLayout(new BorderLayout());
                dialog.setSize(500, 400);
                dialog.setLocationRelativeTo(this);
                
                // Crear panell amb informació
                JPanel panellInfo = new JPanel(new GridLayout(0, 2, 10, 10));
                panellInfo.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
                
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                
                panellInfo.add(new JLabel("Nom:"));
                panellInfo.add(new JLabel(activitat.getNomActivitat()));
                
                panellInfo.add(new JLabel("Data Inici:"));
                panellInfo.add(new JLabel(activitat.getDataINI().format(formatter)));
                
                panellInfo.add(new JLabel("Data Fi:"));
                panellInfo.add(new JLabel(activitat.getDataFi().format(formatter)));
                
                panellInfo.add(new JLabel("Tipus:"));
                panellInfo.add(new JLabel(obtenirTipusActivitat(activitat)));
                
                panellInfo.add(new JLabel("Estat:"));
                panellInfo.add(new JLabel(activitat.haFinalitzat() ? "Finalitzada" : "Pendent"));
                
                panellInfo.add(new JLabel("Permès per:"));
                StringBuilder permisos = new StringBuilder();
                if (activitat.isPDI()) permisos.append("PDI ");
                if (activitat.isPTGAS()) permisos.append("PTGAS ");
                if (activitat.isEstudiants()) permisos.append("Estudiants");
                panellInfo.add(new JLabel(permisos.toString()));
                
                // Afegir informació específica segons el tipus
                String infoEspecifica = obtenirInfoEspecifica(activitat);
                if (!infoEspecifica.isEmpty()) {
                    panellInfo.add(new JLabel("Informació específica:"));
                    panellInfo.add(new JLabel("<html>" + infoEspecifica.replace("\n", "<br>") + "</html>"));
                }
                
                dialog.add(panellInfo, BorderLayout.CENTER);
                
                // Botó per tancar
                JButton botoTancar = new JButton("Tancar");
                botoTancar.addActionListener(e -> dialog.dispose());
                
                JPanel panellBoto = new JPanel();
                panellBoto.add(botoTancar);
                dialog.add(panellBoto, BorderLayout.SOUTH);
                
                dialog.setVisible(true);
            }
        }
    }
    
    private String obtenirInfoEspecifica(Activitats activitat) {
        if (activitat instanceof ActivitatsUnDia) {
            ActivitatsUnDia unDia = (ActivitatsUnDia) activitat;
            return String.format("Ciutat: %s\nHora: %s\nPreu: %.2f€\nPlaces: %d",
                unDia.getCiutat(), unDia.getHora(), unDia.getPreu(), unDia.getLimitPlaces());
        } else if (activitat instanceof ActivitatsPeriodiques) {
            ActivitatsPeriodiques periodiques = (ActivitatsPeriodiques) activitat;
            return String.format("Centre: %s\nDia: %s\nHora: %s\nSetmanes: %d\nPreu: %.2f€",
                periodiques.getNomCentre(), periodiques.getDiaDeLaSemana(),
                periodiques.getHora(), periodiques.getNumSetmanes(), periodiques.getPreu());
        } else if (activitat instanceof ActivitatsOnline) {
            ActivitatsOnline online = (ActivitatsOnline) activitat;
            return String.format("Enllaç: %s\nPeríode: %d dies",
                online.getEnllaç(), online.getPeriode());
        }
        return "";
    }
    
    private void exportarAPDF() {
        // Aquest mètode implementaria l'exportació a PDF
        // Per simplificació, només mostrarem un missatge
        JOptionPane.showMessageDialog(this,
            "Funció d'exportació a PDF en desenvolupament",
            "Exportar",
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    // Mètode per mostrar el calendari
    public static void mostrarCalendari(LlistaActivitats activitats, LlistaInscripcio inscripcions) {
        SwingUtilities.invokeLater(() -> {
            CalendariActivitatsGUI calendari = new CalendariActivitatsGUI(activitats, inscripcions);
            calendari.setVisible(true);
        });
    }
    
    // Mètode principal per proves
    public static void main(String[] args) {
        // Crear dades de prova
        LlistaActivitats activitats = crearDadesProva();
        LlistaInscripcio inscripcions = crearInscripcionsProva(activitats);
        
        // Mostrar el calendari
        mostrarCalendari(activitats, inscripcions);
    }
    
    private static LlistaActivitats crearDadesProva() {
        LlistaActivitats activitats = new LlistaActivitats(10);
        
        // Crear algunes activitats de prova
        LocalDate avui = LocalDate.now();
        
        // Activitat d'un dia
        ActivitatsUnDia activitat1 = new ActivitatsUnDia(
            "Visita al Museu",
            true, true, true,
            avui.plusDays(1), avui.plusDays(1),
            30, 5.0, "Tarragona", java.time.LocalTime.of(10, 0)
        );
        
        // Activitat periòdica
        ActivitatsPeriodiques activitat2 = new ActivitatsPeriodiques(
            "Curs de Programació",
            true, true, true,
            avui.minusDays(5), avui.plusDays(20),
            "Dimecres", "Campus Sescelades", "Tarragona",
            java.time.LocalTime.of(16, 0), avui.minusDays(5),
            8, 25, 50.0
        );
        
        // Activitat online
        ActivitatsOnline activitat3 = new ActivitatsOnline(
            "Webinar d'IA",
            true, false, true,
            avui.minusDays(10), avui.minusDays(5),
            "https://meet.google.com/abc-defg-hij",
            avui.minusDays(10), 5
        );
        
        activitats.Afegir(activitat1);
        activitats.Afegir(activitat2);
        activitats.Afegir(activitat3);
        
        return activitats;
    }
    
    private static LlistaInscripcio crearInscripcionsProva(LlistaActivitats activitats) {
        LlistaInscripcio inscripcions = new LlistaInscripcio(10);
        
        // Crear alguns usuaris de prova
        PDI professor = new PDI("jdoe", "john.doe", "Informàtica", "Sescelades");
        Estudiants estudiant = new Estudiants("mroe", "mary.roe", "Enginyeria Informàtica", 2023);
        PTGAS personal = new PTGAS("ajohn", "anna.john", "Campus Catalunya");
        
        // Inscriure usuaris a les activitats
        for (int i = 0; i < activitats.getNumElements(); i++) {
            Activitats activitat = activitats.getActivitatPos(i);
            inscripcions.Afegir(professor, activitat);
            inscripcions.Afegir(estudiant, activitat);
            inscripcions.Afegir(personal, activitat);
        }
        
        return inscripcions;
    }
}

