package by.kozhevnikov.bsuir.ppvis.SeaBattle;

import java.util.ArrayList;
import java.util.List;

public class Ship{
	private int type;
	private boolean alive;
	private List<Cell> list;
	private List<Cell> copy;
	
	public Ship(int type){
		this.type = type;
		this.alive = true;
		list = new ArrayList<Cell>();
		copy = new ArrayList<Cell>();
	}

	public int getType() {
		return this.type;
	}
	
	public void add(Cell cell){
		this.list.add(cell);
	}
	
	public void remove(Cell cell){
		this.list.remove(cell);
	}
	
	public void doCopy(){
		for(int mark=0; mark<list.size(); mark++){
			copy.add(list.get(mark));
		}
	}

	public boolean isAlive() {
		if(list.size()!=0){
			alive = true;
		} else {
			alive = false;
		}
		return alive;
	}
	
	public ArrayList<Cell> getCopyList(){
		return (ArrayList<Cell>) copy;
	}
}
