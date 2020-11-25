package entidad.premio;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

import entidad.Entidad;
import entidad_grafica.EntidadGraficaPremio;
import entidad_grafica.EntidadGraficaPremioSnitch;
import juego.Juego;
import movimiento.MovimientoVerticalPremio;
import visitor.Visitor;
import visitor.VisitorPremio;

public class EfectoArma extends Efecto {
	/**
	 * Crea un nuevo EfectoArma partiendo de ciertos parametros
	 * @param lim_inf int
	 * @param lim_sup int
	 * @param nombre String
	 * @param juego Juego
	 */
	public EfectoArma(int lim_inf,int lim_sup,String nombre, Juego juego) {
		this.nombre=nombre;
		this.juego=juego;
		JLabel etiqueta = new JLabel();
		EntidadGraficaPremio ent_graf = new EntidadGraficaPremioSnitch(new JLabel()); 
		int direccion=-1;
		int velocidad=2;
		movimiento = new MovimientoVerticalPremio(this,direccion,velocidad,lim_inf,lim_sup);
		v = new VisitorPremio(this);
	}
	
	@Override
	public void activar() {
		juego.mejorarHechizos();
	}

	@Override
	public void aceptar(Visitor v) {
		v.visitarEfectoSuperArma(this);
	}

	@Override
	public List<Entidad> detectarColisiones() {
		List<Entidad> lista = new ArrayList<Entidad>();
		
		for(Entidad e: juego.getMapa().getEntidadesActivas()) {
			if( (e.getBordeIzq()>=borde_izq && e.getBordeIzq()<=borde_der) || (e.getBordeDer()>=borde_izq && e.getBordeDer()<=borde_der) ) {
				
				if(borde_abajo<=e.getBordeArriba()) {
					lista.add(e);
				}
				
			}
		}
		
		return lista;
	}

	@Override
	public void mover() {
		movimiento.mover();
	}

	@Override
	public void accionar() {
		this.mover();
	}

}
