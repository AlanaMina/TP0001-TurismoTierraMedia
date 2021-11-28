package app;

public class Atraccion extends Producto{

	public Atraccion(String nombre, double costo, double tiempo, tipo tipoDeAtraccion, int cupo) {
		super(nombre, costo, tiempo, tipoDeAtraccion, cupo);
	}

	@Override
	public String toString() {
		return super.nombre + "(" + super.costo + " monedas, " + super.tiempo + " horas, " + super.cupo + " lugares, tipo: " + super.tipoDeAtraccion+ ")";
	}
	
	public boolean esPromo() {
		return false;
	}
	
	public void restarCupo() {
		super.cupo-=1;
	}
}
