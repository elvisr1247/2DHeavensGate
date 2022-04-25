package entitys;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;

import main.Game;

public class EntityManager {
	
	private Game game;
	private Player player;
	
	private ArrayList<Entity> entities;
	
	private Comparator<Entity> renderSort = new Comparator<>() {

		@Override
		public int compare(Entity a, Entity b) {
			if(a.getY() + a.getHeight()<b.getY()+b.getHeight())
				return -1;
			return 1;
		}
	};

	public EntityManager(Game game) {
		this.game = game;
		player = new Player(game,1129,500);
		entities = new ArrayList<Entity>();
		
		entities.add(player);
	}
	
	public void update() {
		for(int i = 0; i < entities.size();i++) {
			Entity e = entities.get(i);
			e.update();
			if(!e.isActiveEntity() && !e.isUnkillableEntity()) {
				entities.remove(e);
			}
		}
		entities.sort(renderSort);
	}
	
	public void draw(Graphics g) {
		for(Entity e : entities)e.draw(g);
	}

	public void addEntity(Entity e) {
		entities.add(e);
	}
	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
}
