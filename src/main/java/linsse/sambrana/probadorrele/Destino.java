package linsse.sambrana.probadorrele;


import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class Destino implements Runnable{
	 
	
	private Buffer contenido = new Buffer();
	protected int count = 0;
	abstract String getTitulo();
	protected JLabel statusBar;
	private JPanel panel;

	public Destino(){
		this.panel = Ventana.getInstance().getStatusBar();
		this.statusBar = new JLabel();
		this.panel.add(this.statusBar);
		this.statusBar.setText(this.getTitulo());
	
	}
	
	protected String date(){
		Date now = new Date(); // java.util.Date, NOT java.sql.Date or java.sql.Timestamp!
		return new SimpleDateFormat("H:m:s").format(now);
		
	}
	
	public Buffer getBuffer()
	{
		return this.contenido;
	}
	
	
	public void add(UnidadLectura u)
	{
			this.getBuffer().add(u);
	}	
		
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
	
	protected int size(){
		return this.getBuffer().size();
		
	}
	

	


	
	
}
