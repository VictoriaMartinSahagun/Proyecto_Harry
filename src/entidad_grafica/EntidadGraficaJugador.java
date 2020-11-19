package entidad_grafica;

import javax.swing.*;

public class EntidadGraficaJugador extends EntidadGrafica{
	private String harry = "/img/Harry.png", harry_daniado = "/img/HarryDaniado2.png";
	private String[] harry_muerto = {"/img/HarryMuerte2.png","/img/HarryMuerte3.png"};
	
	public EntidadGraficaJugador(JLabel label) {
		ImageIcon imagen;
		
		etiqueta = label;
		grafica = new ImageIcon();
		imagen = new ImageIcon(this.getClass().getResource(harry));
		grafica.setImage(imagen.getImage());
	}
	
	public void moverEtiqueta(int x, int y) {
		etiqueta.setLocation(x,y);
	}
	
	
}
