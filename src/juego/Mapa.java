package juego;

import java.util.ArrayList;
import java.util.List;

import entidad.Entidad;
import entidad.enemigo.Enemigo;
import entidad.jugador.Jugador;
import entidad.proyectil.Proyectil;

public class Mapa {
	private List<Enemigo> enemigos;
	private List<Proyectil> proyectiles;
	private Jugador jugador;
	
	public Mapa(Jugador j, Horda h) {
		this.jugador=j;
		this.enemigos = new ArrayList<Enemigo>();
		for (Enemigo e: h.getHorda()) {
			enemigos.add(e);
		}
		this.proyectiles = new ArrayList<Proyectil>();
	}
	
	public List<Entidad> ElementosActivos() {
		List<Entidad> lista = new ArrayList<Entidad>();
		lista.add(jugador);
		
		for(Enemigo e:enemigos)
			lista.add(e);
		
		for(Proyectil p:proyectiles)
			lista.add(p);
		return lista;
	}
	
	public void agregarEnemigoActivo(Enemigo e) {
		enemigos.add(e);
		e.getEntidad().iniciar();
	}
	
	public void eliminarEnemigoActivo(Enemigo e) {
		enemigos.remove(e);
		e.getEntidad().desaparecer();
	}
	
	public void agregarProyectilActivo(Proyectil p) {
		proyectiles.add(p);
		p.getGrafica().disparo();
	}
	
	public void eliminarProyectilActivo(Proyectil p) {
		proyectiles.remove(p);
		p.getGrafica().desaparecer();
	}
}
