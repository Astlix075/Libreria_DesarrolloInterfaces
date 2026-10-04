package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.net.URL;
import java.util.concurrent.Flow;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import modelo.Libro;

public class UI extends JFrame {

	private static final long serialVersionUID = 1L;
	protected JTextField txISBN;
	protected JTextField txTitulo;
	protected JTextField txAutor;
	protected JTextField txEditorial;
	protected JTextField txPrecio;
	protected JTextField txUnidades;
	
	protected JLabel lbErrorISBN;
	protected JLabel lbErrorTitulo;
	protected JLabel lbErrorAutor;
	protected JLabel lbErrorEditorial;
	protected JLabel lbErrorPrecio;
	protected JLabel lbErrorUnidades;
	protected JLabel lbErrorFormato;
	protected JLabel lbErrorEstado;

	protected JRadioButton rdbtnCartone;
	protected JRadioButton rdbtnRustica;
	protected JRadioButton rdbtnGrapada;
	protected JRadioButton rdbtnEspiral;
	
	protected JRadioButton rdbtnReedicion;
	protected JRadioButton rdbtnNovedad;
	
	protected ButtonGroup grupoFormato;
	protected ButtonGroup grupoEstado;

	protected JLabel lbImagenLibro;

	protected JButton btConsultar;
	protected JButton btGuardar;
	protected JButton btBorrar;
	protected JButton btModificar;
	protected JButton btIniciar;
	protected JButton btSalir;
	protected JTable tablaLibros;
	
	// Componentes para Pestaña REPONER
	protected JComboBox<Libro> cbLibrosReponer;
	protected JTextField txCantidadReponer;
	protected JButton btAceptarReponer;
	
	// Componentes para Pestaña VENDER
	protected JComboBox<Libro> cbLibrosVender;
	protected JTextField txCantidadVender;
	protected JButton btAceptarVender;
	protected JTabbedPane tbPane;
	

	public UI() {
		setAutoRequestFocus(false);
		setEnabled(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 560);
		
		JPanel contentPane = new JPanel(new BorderLayout(10, 10));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		// --- CABECERA ---
		JPanel p_superior = new JPanel();
		p_superior.setBackground(new Color(196, 196, 0));
		contentPane.add(p_superior, BorderLayout.NORTH);
		
		JLabel LBSuperior = new JLabel("LIBRERIA DE FÉLIX TREJO BAQUERO");
		LBSuperior.setForeground(Color.WHITE);
		LBSuperior.setFont(new Font("Tahoma", Font.BOLD, 20));
		p_superior.add(LBSuperior);
		
		// --- BOTONERA INFERIOR ---
		JPanel p_inferior = new JPanel();
		p_inferior.setBackground(new Color(234, 237, 103));
		contentPane.add(p_inferior, BorderLayout.SOUTH);
		
		btConsultar = new JButton("CONSULTAR");
		btConsultar.setBackground(new Color(204, 153, 51));
		p_inferior.add(btConsultar);

		btGuardar = new JButton("GUARDAR");
		btGuardar.setBackground(new Color(204, 153, 51));
		p_inferior.add(btGuardar);
		
		btBorrar = new JButton("BORRAR");
		btBorrar.setBackground(new Color(204, 153, 51));
		p_inferior.add(btBorrar);
		
		btModificar = new JButton("MODIFICAR");
		btModificar.setBackground(new Color(204, 153, 51));
		p_inferior.add(btModificar);
		
		btIniciar = new JButton("INICIAR");
		btIniciar.setBackground(new Color(204, 153, 51));
		p_inferior.add(btIniciar);
		
		btSalir = new JButton("SALIR");
		btSalir.setBackground(new Color(204, 153, 51));
		p_inferior.add(btSalir);
		
		// --- PESTAÑAS ---
		tbPane = new JTabbedPane(JTabbedPane.TOP);
		tbPane.setBackground(new Color(255, 255, 128));
		contentPane.add(tbPane, BorderLayout.CENTER);
		
		JPanel LIBRO = new JPanel(new GridBagLayout());
		LIBRO.setBackground(new Color(250, 250, 210));
		tbPane.addTab("LIBRO", null, LIBRO, null);
		
		Dimension tamCaja = new Dimension(130, 24);
		Font fuenteError = new Font("Tahoma", Font.BOLD, 11);

		// --- FILA 0: ISBN ---
		JLabel lbISBN = new JLabel("ISBN:");
		GridBagConstraints gbc_lbISBN = new GridBagConstraints();
		gbc_lbISBN.anchor = GridBagConstraints.WEST;
		gbc_lbISBN.insets = new Insets(8, 15, 3, 5);
		gbc_lbISBN.gridx = 0; 
		gbc_lbISBN.gridy = 0;
		LIBRO.add(lbISBN, gbc_lbISBN);

		txISBN = new JTextField();
		txISBN.setPreferredSize(tamCaja);
		GridBagConstraints gbc_txISBN = new GridBagConstraints();
		gbc_txISBN.anchor = GridBagConstraints.WEST;
		gbc_txISBN.insets = new Insets(8, 5, 3, 5);
		gbc_txISBN.gridx = 1; 
		gbc_txISBN.gridy = 0;
		LIBRO.add(txISBN, gbc_txISBN);
		
		lbErrorISBN = new JLabel("");
		lbErrorISBN.setFont(fuenteError);
		lbErrorISBN.setForeground(Color.RED);
		GridBagConstraints gbc_lbErrorISBN = new GridBagConstraints();
		gbc_lbErrorISBN.anchor = GridBagConstraints.WEST;
		gbc_lbErrorISBN.insets = new Insets(8, 5, 3, 10);
		gbc_lbErrorISBN.gridx = 2;
		gbc_lbErrorISBN.gridy = 0;
		LIBRO.add(lbErrorISBN, gbc_lbErrorISBN);

		// --- FILA 1: TITULO ---
		JLabel lblTitulo = new JLabel("Titulo:");
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.anchor = GridBagConstraints.WEST;
		gbc_lblTitulo.insets = new Insets(3, 15, 3, 5);
		gbc_lblTitulo.gridx = 0; 
		gbc_lblTitulo.gridy = 1;
		LIBRO.add(lblTitulo, gbc_lblTitulo);

		txTitulo = new JTextField();
		txTitulo.setPreferredSize(tamCaja);
		GridBagConstraints gbc_txTitulo = new GridBagConstraints();
		gbc_txTitulo.anchor = GridBagConstraints.WEST;
		gbc_txTitulo.insets = new Insets(3, 5, 3, 5);
		gbc_txTitulo.gridx = 1; 
		gbc_txTitulo.gridy = 1;
		LIBRO.add(txTitulo, gbc_txTitulo);
		
		lbErrorTitulo = new JLabel("");
		lbErrorTitulo.setFont(fuenteError);
		lbErrorTitulo.setForeground(Color.RED);
		GridBagConstraints gbc_lbErrorTitulo = new GridBagConstraints();
		gbc_lbErrorTitulo.anchor = GridBagConstraints.WEST;
		gbc_lbErrorTitulo.insets = new Insets(3, 5, 3, 10);
		gbc_lbErrorTitulo.gridx = 2;
		gbc_lbErrorTitulo.gridy = 1;
		LIBRO.add(lbErrorTitulo, gbc_lbErrorTitulo);

		// --- FILA 2: AUTOR ---
		JLabel lbAutor = new JLabel("Autor:");
		GridBagConstraints gbc_lbAutor = new GridBagConstraints();
		gbc_lbAutor.anchor = GridBagConstraints.WEST;
		gbc_lbAutor.insets = new Insets(3, 15, 3, 5);
		gbc_lbAutor.gridx = 0; 
		gbc_lbAutor.gridy = 2;
		LIBRO.add(lbAutor, gbc_lbAutor);

		txAutor = new JTextField();
		txAutor.setPreferredSize(tamCaja);
		GridBagConstraints gbc_txAutor = new GridBagConstraints();
		gbc_txAutor.anchor = GridBagConstraints.WEST;
		gbc_txAutor.insets = new Insets(3, 5, 3, 5);
		gbc_txAutor.gridx = 1; 
		gbc_txAutor.gridy = 2;
		LIBRO.add(txAutor, gbc_txAutor);
		
		lbErrorAutor = new JLabel("");
		lbErrorAutor.setFont(fuenteError);
		lbErrorAutor.setForeground(Color.RED);
		GridBagConstraints gbc_lbErrorAutor = new GridBagConstraints();
		gbc_lbErrorAutor.anchor = GridBagConstraints.WEST;
		gbc_lbErrorAutor.insets = new Insets(3, 5, 3, 10);
		gbc_lbErrorAutor.gridx = 2;
		gbc_lbErrorAutor.gridy = 2;
		LIBRO.add(lbErrorAutor, gbc_lbErrorAutor);

		// --- FILA 3: EDITORIAL ---
		JLabel lbEditorial = new JLabel("Editorial:");
		GridBagConstraints gbc_lbEditorial = new GridBagConstraints();
		gbc_lbEditorial.anchor = GridBagConstraints.WEST;
		gbc_lbEditorial.insets = new Insets(3, 15, 3, 5);
		gbc_lbEditorial.gridx = 0; 
		gbc_lbEditorial.gridy = 3;
		LIBRO.add(lbEditorial, gbc_lbEditorial);

		txEditorial = new JTextField();
		txEditorial.setPreferredSize(tamCaja);
		GridBagConstraints gbc_txEditorial = new GridBagConstraints();
		gbc_txEditorial.anchor = GridBagConstraints.WEST;
		gbc_txEditorial.insets = new Insets(3, 5, 3, 5);
		gbc_txEditorial.gridx = 1; 
		gbc_txEditorial.gridy = 3;
		LIBRO.add(txEditorial, gbc_txEditorial);
		
		lbErrorEditorial = new JLabel("");
		lbErrorEditorial.setFont(fuenteError);
		lbErrorEditorial.setForeground(Color.RED);
		GridBagConstraints gbc_lbErrorEditorial = new GridBagConstraints();
		gbc_lbErrorEditorial.anchor = GridBagConstraints.WEST;
		gbc_lbErrorEditorial.insets = new Insets(3, 5, 3, 10);
		gbc_lbErrorEditorial.gridx = 2;
		gbc_lbErrorEditorial.gridy = 3;
		LIBRO.add(lbErrorEditorial, gbc_lbErrorEditorial);

		// --- FILA 4: PRECIO ---
		JLabel lbPrecio = new JLabel("Precio:");
		GridBagConstraints gbc_lbPrecio = new GridBagConstraints();
		gbc_lbPrecio.anchor = GridBagConstraints.WEST;
		gbc_lbPrecio.insets = new Insets(3, 15, 3, 5);
		gbc_lbPrecio.gridx = 0; 
		gbc_lbPrecio.gridy = 4;
		LIBRO.add(lbPrecio, gbc_lbPrecio);

		txPrecio = new JTextField();
		txPrecio.setPreferredSize(tamCaja);
		GridBagConstraints gbc_txPrecio = new GridBagConstraints();
		gbc_txPrecio.anchor = GridBagConstraints.WEST;
		gbc_txPrecio.insets = new Insets(3, 5, 3, 5);
		gbc_txPrecio.gridx = 1; 
		gbc_txPrecio.gridy = 4;
		LIBRO.add(txPrecio, gbc_txPrecio);
		
		lbErrorPrecio = new JLabel("");
		lbErrorPrecio.setFont(fuenteError);
		lbErrorPrecio.setForeground(Color.RED);
		GridBagConstraints gbc_lbErrorPrecio = new GridBagConstraints();
		gbc_lbErrorPrecio.anchor = GridBagConstraints.WEST;
		gbc_lbErrorPrecio.insets = new Insets(3, 5, 3, 10);
		gbc_lbErrorPrecio.gridx = 2;
		gbc_lbErrorPrecio.gridy = 4;
		LIBRO.add(lbErrorPrecio, gbc_lbErrorPrecio);
		
		// --- FILA 5: UNIDADES ---
		JLabel lbUnidades = new JLabel("Unidades:");
		GridBagConstraints gbc_lbUnidades = new GridBagConstraints();
		gbc_lbUnidades.anchor = GridBagConstraints.WEST;
		gbc_lbUnidades.insets = new Insets(3, 15, 8, 5);
		gbc_lbUnidades.gridx = 0;
		gbc_lbUnidades.gridy = 5;		
		LIBRO.add(lbUnidades, gbc_lbUnidades);
		
		txUnidades = new JTextField();
		txUnidades.setPreferredSize(tamCaja);
		GridBagConstraints gbc_txUnidades = new GridBagConstraints();
		gbc_txUnidades.anchor = GridBagConstraints.WEST;
		gbc_txUnidades.insets = new Insets(3, 5, 8, 5);
		gbc_txUnidades.gridx = 1;
		gbc_txUnidades.gridy = 5;
		LIBRO.add(txUnidades, gbc_txUnidades);
		
		lbErrorUnidades = new JLabel("");
		lbErrorUnidades.setFont(fuenteError);
		lbErrorUnidades.setForeground(Color.RED);
		GridBagConstraints gbc_lbErrorUnidades = new GridBagConstraints();
		gbc_lbErrorUnidades.anchor = GridBagConstraints.WEST;
		gbc_lbErrorUnidades.insets = new Insets(3, 5, 8, 10);
		gbc_lbErrorUnidades.gridx = 2;
		gbc_lbErrorUnidades.gridy = 5;
		LIBRO.add(lbErrorUnidades, gbc_lbErrorUnidades);
		
		// COLUMNA 3: IMAGEN
		lbImagenLibro = new JLabel();
		lbImagenLibro.setHorizontalAlignment(SwingConstants.CENTER);
		URL urlImagen = UI.class.getResource("/vista/Libreria.png");
		if (urlImagen != null) {
			ImageIcon originalIcon = new ImageIcon(urlImagen);
			Image imgEscalada = originalIcon.getImage().getScaledInstance(180, 160, Image.SCALE_SMOOTH);
			lbImagenLibro.setIcon(new ImageIcon(imgEscalada));
		}

		GridBagConstraints gbc_img = new GridBagConstraints();
		gbc_img.gridx = 3; 
		gbc_img.gridy = 0;
		gbc_img.gridheight = 6; // Abarca 6 filas de alto
		gbc_img.fill = GridBagConstraints.BOTH;
		gbc_img.weightx = 1.0;
		gbc_img.insets = new Insets(8, 10, 8, 15);
		LIBRO.add(lbImagenLibro, gbc_img);

		// --- FILA 6: FORMATO ---
		JLabel lbFormato = new JLabel("Formato:");
		GridBagConstraints gbc_lbFormato = new GridBagConstraints();
		gbc_lbFormato.anchor = GridBagConstraints.WEST;
		gbc_lbFormato.insets = new Insets(5, 15, 3, 5);
		gbc_lbFormato.gridx = 0; 
		gbc_lbFormato.gridy = 6;
		LIBRO.add(lbFormato, gbc_lbFormato);

		JPanel panelFormato = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 3));
		panelFormato.setBackground(new Color(250, 250, 210));
		panelFormato.setBorder(new LineBorder(new Color(255, 165, 0), 1));

		rdbtnCartone = new JRadioButton("Cartoné");
		rdbtnCartone.setBackground(new Color(250, 250, 210));
		rdbtnRustica = new JRadioButton("Rústica");
		rdbtnRustica.setBackground(new Color(250, 250, 210));
		rdbtnGrapada = new JRadioButton("Grapada");
		rdbtnGrapada.setBackground(new Color(250, 250, 210));
		rdbtnEspiral = new JRadioButton("Espiral");
		rdbtnEspiral.setBackground(new Color(250, 250, 210));

		panelFormato.add(rdbtnCartone);
		panelFormato.add(rdbtnRustica);
		panelFormato.add(rdbtnGrapada);
		panelFormato.add(rdbtnEspiral);

		grupoFormato = new ButtonGroup();
		grupoFormato.add(rdbtnCartone);
		grupoFormato.add(rdbtnRustica);
		grupoFormato.add(rdbtnGrapada);
		grupoFormato.add(rdbtnEspiral);

		GridBagConstraints gbc_panelFormato = new GridBagConstraints();
		gbc_panelFormato.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelFormato.insets = new Insets(5, 5, 3, 5);
		gbc_panelFormato.gridx = 1; 
		gbc_panelFormato.gridy = 6;
		gbc_panelFormato.gridwidth = 2; // Abarca las columnas de texto e imagen
		LIBRO.add(panelFormato, gbc_panelFormato);
		
		lbErrorFormato = new JLabel("");
		lbErrorFormato.setFont(fuenteError);
		lbErrorFormato.setForeground(Color.RED);
		GridBagConstraints gbc_lbErrorFormato = new GridBagConstraints();
		gbc_lbErrorFormato.anchor = GridBagConstraints.WEST;
		gbc_lbErrorFormato.insets = new Insets(5, 5, 3, 10);
		gbc_lbErrorFormato.gridx = 3;
		gbc_lbErrorFormato.gridy = 6;
		LIBRO.add(lbErrorFormato, gbc_lbErrorFormato);

		// --- FILA 7: ESTADO ---
		JLabel lbEstado = new JLabel("Estado:");
		GridBagConstraints gbc_lbEstado = new GridBagConstraints();
		gbc_lbEstado.anchor = GridBagConstraints.WEST;
		gbc_lbEstado.insets = new Insets(3, 15, 8, 5);
		gbc_lbEstado.gridx = 0; 
		gbc_lbEstado.gridy = 7;
		LIBRO.add(lbEstado, gbc_lbEstado);

		JPanel panelEstado = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 3));
		panelEstado.setBackground(new Color(250, 250, 210));
		panelEstado.setBorder(new LineBorder(new Color(255, 165, 0), 1));

		rdbtnReedicion = new JRadioButton("Reedición");
		rdbtnReedicion.setBackground(new Color(250, 250, 210));
		rdbtnNovedad = new JRadioButton("Novedad");
		rdbtnNovedad.setBackground(new Color(250, 250, 210));

		panelEstado.add(rdbtnReedicion);
		panelEstado.add(rdbtnNovedad);

		grupoEstado = new ButtonGroup();
		grupoEstado.add(rdbtnReedicion);
		grupoEstado.add(rdbtnNovedad);

		GridBagConstraints gbc_panelEstado = new GridBagConstraints();
		gbc_panelEstado.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelEstado.insets = new Insets(3, 5, 8, 5);
		gbc_panelEstado.gridx = 1; 
		gbc_panelEstado.gridy = 7;
		gbc_panelEstado.gridwidth = 2; 
		LIBRO.add(panelEstado, gbc_panelEstado);
		
		lbErrorEstado = new JLabel("");
		lbErrorEstado.setFont(fuenteError);
		lbErrorEstado.setForeground(Color.RED);
		GridBagConstraints gbc_lbErrorEstado = new GridBagConstraints();
		gbc_lbErrorEstado.anchor = GridBagConstraints.WEST;
		gbc_lbErrorEstado.insets = new Insets(3, 5, 8, 10);
		gbc_lbErrorEstado.gridx = 3;
		gbc_lbErrorEstado.gridy = 7;
		LIBRO.add(lbErrorEstado, gbc_lbErrorEstado);
		
		LIBRO.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txISBN, txTitulo, txAutor, txEditorial, txPrecio, txUnidades}));
		
		// --- PESTAÑA ESTANTERÍA ---
		Color colorFondo = new Color(250, 250, 210);
		
		JPanel ESTANTERIA = new JPanel(new BorderLayout());
		ESTANTERIA.setBackground(colorFondo);
		tbPane.addTab("ESTANTERÍA", null, ESTANTERIA, null);
		
		tablaLibros = new JTable();
		tablaLibros.setRowHeight(30);
		tablaLibros.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tablaLibros.setBackground(colorFondo);
		tablaLibros.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 13));
		tablaLibros.getTableHeader().setBackground(new Color(220, 220, 170));
		tablaLibros.setGridColor(new Color(180, 180, 150));
		JScrollPane scrollPane = new JScrollPane(tablaLibros);
		scrollPane.setBackground(colorFondo);
		scrollPane.getViewport().setBackground(colorFondo);
		ESTANTERIA.add(scrollPane, BorderLayout.CENTER);
		
		// --- PESTAÑA REPONER ---
		JPanel pReponer = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 40));
		pReponer.setBackground(new Color(250, 250, 210));
		tbPane.addTab("REPONER", null, pReponer, null);
		
		JPanel boxReponer = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 40));
		boxReponer.setBackground(new Color(250, 250, 210));
		boxReponer.setBorder(new TitledBorder(new LineBorder(new Color(0, 150, 0), 2), " Reposición de Stock ", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 14), new Color(0, 100, 0)));
		
		cbLibrosReponer = new JComboBox<>();
		cbLibrosReponer.setPreferredSize(new Dimension(320, 28));
		
		txCantidadReponer = new JTextField();
		txCantidadReponer.setPreferredSize(new Dimension(80, 28));
		
		btAceptarReponer = new JButton("AÑADIR STOCK");
		btAceptarReponer.setBackground(new Color(144, 238, 144));
		
		boxReponer.add(new JLabel("Seleccionar Libro:"));
		boxReponer.add(cbLibrosReponer);
		boxReponer.add(new JLabel("Cantidad:"));
		boxReponer.add(txCantidadReponer);
		boxReponer.add(btAceptarReponer);
		
		pReponer.add(boxReponer);
		
		// --- PESTAÑA VENDER ---
		JPanel pVender = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 40));
		pVender.setBackground(new Color(250, 250, 210));
		tbPane.addTab("VENDER", null, pVender, null);
		
		JPanel boxVender = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 20));
		boxVender.setBackground(new Color(250, 250, 210));
		boxVender.setBorder(new TitledBorder(new LineBorder(Color.RED, 2), " Ventas de Libros ", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 14), Color.RED));
		
		cbLibrosVender = new JComboBox<>();
		cbLibrosVender.setPreferredSize(new Dimension(320, 28));
		
		txCantidadVender = new JTextField();
		txCantidadVender.setPreferredSize(new Dimension(80, 28));
		
		btAceptarVender = new JButton("REGISTRAR VENTA");
		btAceptarVender.setBackground(new Color(255, 182, 193));
		
		boxVender.add(new JLabel("Seleccionar Libro:"));
		boxVender.add(cbLibrosVender);
		boxVender.add(new JLabel("Cantidad:"));
		boxVender.add(txCantidadVender);
		boxVender.add(btAceptarVender);
		
		pVender.add(boxVender);
	}
}