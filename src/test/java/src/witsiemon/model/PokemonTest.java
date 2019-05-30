package src.witsiemon.model;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import src.witsiemon.model.Pokemon;

public class PokemonTest {

	@Test
	public void setHP_100_100() {
		src.witsiemon.model.Pokemon poke = new Pokemon("Test",100,10,10,10);		
		assertEquals(poke.getHP(), 100);
		
	}
	@Test
	public void setDMG_20_80() {
		src.witsiemon.model.Pokemon poke = new Pokemon("Test",100,10,10,10);
		poke.setDMG(20);
		assertEquals(poke.getHP(),80);
	}
	@Test
	public void setHP_20_100() {
		src.witsiemon.model.Pokemon poke = new Pokemon("Test",80,10,10,10);
		poke.setHP(20);
		assertEquals(poke.getHP(),100);
	}
	@Test
	public void getSpeed_null_10() {
		src.witsiemon.model.Pokemon poke = new Pokemon("Test",100,10,10,10);
		assertEquals(poke.getSpeed(),10);
		
	}
	@Test
	public void isAwake_100_true() {
		src.witsiemon.model.Pokemon poke = new Pokemon("Test",100,10,10,10);
		assertEquals(poke.isAwake(),true);
	}
	@Test
	public void isAwake_0_false() {
		src.witsiemon.model.Pokemon poke = new Pokemon("Test",100,10,10,10);
		assertEquals(poke.isAwake(),false);
	}
	@Test
	public void getName_test_test() {
		src.witsiemon.model.Pokemon poke = new Pokemon("Test",100,10,10,10);

		assertEquals(poke.getName(),"Test");
	}
	@Test
	public void getSP_10_10() {
		src.witsiemon.model.Pokemon poke = new Pokemon("Test",100,10,10,10);
		assertEquals(poke.getSP(),10);
	}
}
