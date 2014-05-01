package abstracts;

import java.awt.Graphics;

import main.Keys;
import screen.BaseScreen;

public abstract class SubMenu {
	
	protected boolean subMenuActivation;
	
	private String name;
	private String enabledDescription;
	private String disabledDescription;
	private boolean enabled;
	
	public SubMenu(String name, String enabled, String disabled) {
		this.name = name;
		this.enabledDescription = enabled;
		this.disabledDescription = disabled;
		this.subMenuActivation = false;
	}
	
	public boolean isActivated() {
		return this.subMenuActivation;
	}
	
	public void enableSubMenu() {
		this.subMenuActivation = true;
	}
	
	public void disableSubMenu() {
		this.subMenuActivation = false;
	}
	
	public void toggleDescription(boolean value) {
		this.enabled = value;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDescription() {
		if (this.enabled)
			return this.enabledDescription;
		else
			return this.disabledDescription;
	}
	
	public abstract SubMenu initialize(Keys keys);
	
	public abstract void tick();
	
	public abstract void render(BaseScreen output, Graphics graphics);
}
