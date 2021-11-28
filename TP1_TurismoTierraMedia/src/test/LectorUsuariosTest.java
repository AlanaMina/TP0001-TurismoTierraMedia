package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import app.LectorUsuarios;
import app.Usuario;
import app.tipo;

public class LectorUsuariosTest {
	LectorUsuarios lector;
	ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	
	@Before
	public void setUp() throws Exception {
		lector  =  new LectorUsuarios();
		Usuario u1 = new Usuario("Eowyn", tipo.AVENTURA, 100, 80);
		Usuario u2 = new Usuario("Gandalf", tipo.PAISAJE, 100, 5);
		Usuario u3 = new Usuario("Sam", tipo.DEGUSTACION, 36, 8);
		Usuario u4 = new Usuario("Galadriel", tipo.PAISAJE, 120, 5);
		usuarios.add(u1);
		usuarios.add(u2);
		usuarios.add(u3);
		usuarios.add(u4);
	}

	@Test
	public void test() {
		assertEquals(usuarios, lector.getUsuarios("usuarios.txt"));
	}

}
