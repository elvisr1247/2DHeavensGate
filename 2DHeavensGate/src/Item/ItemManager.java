package Item;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import main.Game;

public class ItemManager {
	
	private Game game;
	private ArrayList<Item>items = new ArrayList<Item>();
	
	public ItemManager(Game game) {
		this.game = game;
	}
	
	public void update() {
		Iterator<Item> it = items.iterator();
		//while item still has something to update
		while(it.hasNext()) {
			Item i = it.next();
			i.update();
			/*if the player has picked it up remove it 
			from the world and add it to the inventory*/
			if(i.getCount() == Item.PICKED_UP) it.remove();
				
			
		}
	}
	
	public void draw(Graphics g) {
		//renders all the items
		for(Item i : items)i.draw(g);
	}

	public void addItem(Item i) {
		i.setGame(game);
		items.add(i);
	}

}
