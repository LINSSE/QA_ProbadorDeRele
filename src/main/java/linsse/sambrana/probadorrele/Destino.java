package linsse.sambrana.probadorrele;


import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class Destino implements Runnable{
	 
	
	/**
	 * Buffer de datos asociado al destino
	 */
	private Buffer contenido = new Buffer();
	protected int count = 0;
	abstract String getTitulo();
	protected JLabel statusBar;
	private JPanel panel;

	/**
	 * Constructor
	 * Instancia el panel en barra de estado correspendiente al destino
	 */
	public Destino(){
		this.panel = Ventana.getInstance().getStatusBar();
		this.statusBar = new JLabel();
		this.panel.add(this.statusBar);
		this.statusBar.setText(this.getTitulo());
	
	}
	
	/**
	 * obtener la hora, minuto y segundo actual
	 * @return hora en formato H:m:s
	 */
	protected String date(){
		Date now = new Date(); // java.util.Date, NOT java.sql.Date or java.sql.Timestamp!
		return new SimpleDateFormat("H:m:s").format(now);
		
	}
	
	/**
	 * Obtiene el Buffer de datos relacionado al destino
	 * @return Buffer de datos
	 */
	public Buffer getBuffer()
	{
		return this.contenido;
	}
	
	
	/**
	 * Añade una unidad de lectura generada por el manejador de entradas
	 * @param u
	 */
	public void add(UnidadLectura u)
	{
			this.getBuffer().add(u);
	}	
		
	/**
	 * Obtiene la unidad de lectura al principio del Buffer
	 * @return Unidad de lectura
	 */
	public UnidadLectura get(){
		UnidadLectura u = this.getBuffer().get();
		if (u != null) 
		{			
			return u;	
		}
		else {
			System.out.println(this.getTitulo()+": buffer vacio"); //NOSONAR
			return null;
		}
				
	}
	
	/**
	 * Obtiene el tamaño actual del buffer
	 * @return numero de elementos en el buffer
	 */
	protected int size(){
		return this.getBuffer().size();
		
	}
	

	


	
	
}
