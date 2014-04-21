package me.inplex.inengine.world;

import java.util.ArrayList;
import java.util.List;

import me.inplex.inengine.entity.Entity;

public class World {
	public List<Entity> list = new ArrayList<Entity>();
	
	public void add(Entity entity){
		list.add(entity);
	}
	

}
