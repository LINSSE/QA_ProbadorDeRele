package linsse.sambrana.probadorrele;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class DestinoGraficos extends Destino
{
	
	private JPanel panelGraficos = Ventana.getInstance().getPanelGraficos();
	XYSeries[][] seriesArray;
	XYSeriesCollection[] datasetArray;//aqui estan todos los datos
	private JFreeChart[] chartArray = new JFreeChart[15];
	int puertos = 3;
	int sensores = 12;
	int graph_limit = 10; // NOSONAR
	
	public DestinoGraficos(){
		for (int i = 0; i < sensores; i++) 
		{
			XYSeriesCollection dataset = new XYSeriesCollection();
			this.chartArray[i] = ChartFactory.createXYLineChart("Titulo", null, null, dataset);
			this.chartArray[i].getXYPlot().getRangeAxis().setRange(0, 300);
			this.panelGraficos.add(new ChartPanel(this.chartArray[i]));
		}
	}

	public void run() {
		int c = 0;
		 while(Boolean.TRUE)// NOSONAR
		  {	
			 try {
				Thread.sleep(3000);
			} catch (InterruptedException e) { // NOSONAR
		
			
				e.printStackTrace(); // NOSONAR
			}
			 UnidadLectura u = this.get();
			 this.statusBar.setText("Total de Registros: "+(20+c++)+"/"+this.size()+" en cola");
			 System.out.println("GRAFICANDO"); // NOSONAR
			 u.show();
//			
	        }
	}

	@Override
	String getTitulo() {
	
		return "Graph";
	}
	
}
