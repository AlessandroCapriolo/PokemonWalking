package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import level.OverWorld;
import screen.BaseScreen;
import abstracts.World;
import entity.Player;

public class Game {
	//Handles different types of worlds for the game to use.
	//It acts as a pointer that points to many different worlds.
	//Each world stays loaded, while the pointer just "slides" across towards the next world it is transitioning to.
	public static Random Randomize = new Random(System.currentTimeMillis());
	private final BaseScreen screen;
	//private final Keys inputs;
	//private final Gui guiInterface;
	private final List<World> worlds;
	private World overworld;
	private final Player player;
	
	//private Plot storyPlot;
	//private Data data;
	
	//private int xScroll;
	//private int yScroll;
	
	//private int xCamera;
	//private int yCamera;
	
	/**
	 * Creates the core component of the game.
	 * 
	 * All future game components are to be placed here.
	 * 
	 * @param BaseScreen
	 *            Takes in a BaseScreen that displays all rendered graphics to the screen.
	 * @param Keys
	 *            Takes the Keys object the input handler receives from the player for the game to handle. The input handler must control
	 *            this Keys object.
	 * @see BaseScreen
	 * @see NewInputHandler
	 * */
	public Game(BaseScreen output, Keys input) {
		this.screen = output;
		//this.inputs = input;
		
		player = new Player(input);
		player.setCenterCamPosition(output);
		
		//this.guiInterface = new Gui();
		
		worlds = new ArrayList<World>();
		
		this.overworld = new OverWorld(player);
		worlds.add(this.overworld);
	}
	
	/**
	 * Handles rendered objects.
	 * 
	 * All render() methods must be placed in here, in order to correctly render to the screen.
	 * 
	 * @return Nothing.
	 * */
	public void render() {
		//TODO: Do rendering by calling "BaseScreen" variable and call one of many draw methods provided.
		//TODO: Re-create the player's fixed position to camera's center, while everything else moves around.
		//TODO: Overworld must be drawn while the player is moving around. Small areas can only be seen after the camera culls out the overworld.
		/*
		for (World w : worlds)
			if (w != null) {
				w.render(screen, player.getX(), player.getY());
			}
		*/
		
		overworld.render(screen, player.getX(), player.getY());
	}
	
	/**
	 * Updates the game.
	 * 
	 * All tick() methods must be placed in here, in order to correctly update the game.
	 * 
	 * @return Nothing.
	 * */
	public void tick() {
		//TODO: This updates for all objects given.
		/*
		for (World w : worlds)
			if (w != null)
				w.tick();
		*/
		//player.tick();
		overworld.tick();
	}
	
	/**
	 * Currently unused.
	 * */
	public void save() {
		//TODO: Save data.
	}
	
	/**
	 * Currently unused.
	 * */
	public void load() {
		//TODO: Load data.
	}
	
	/**
	 * Currently unused.
	 * */
	public void setScrollOffset(int xCamCenter, int yCamCenter) {
		//CamCenter: the coordinates of the center of camera.
		//this.xScroll = xCamCenter;
		//this.yScroll = yCamCenter;
	}
	
	/**
	 * Currently unused. However, this is executed in the render() code.
	 * */
	public void setCameraRelativeToArea(int areaXPos, int areaYPos) {
		//Not used at the moment.
		
		//cam(x,y) = area(cam.x * -1 + xConstantOffset, cam.y * -1 + yConstantOffset)
		//this.xCamera = (-areaXPos + this.xScroll) / Tile.WIDTH;
		//this.yCamera = (-areaYPos + this.yScroll) / Tile.HEIGHT;
	}
}
