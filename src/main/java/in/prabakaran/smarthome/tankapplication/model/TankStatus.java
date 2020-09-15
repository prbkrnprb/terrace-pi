package in.prabakaran.smarthome.tankapplication.model;

public class TankStatus implements Cloneable {

	private boolean bottomProbe;
	private boolean middleProbe;
	private boolean topProbe;

	public TankStatus(final boolean bottomProbe, final boolean middleProbe, final boolean topProbe) {
		this.bottomProbe = bottomProbe;
		this.middleProbe = middleProbe;
		this.topProbe = topProbe;
	}
	
	public TankStatus() {
		
	}

	public boolean isBottomProbe() {
		return bottomProbe;
	}

	public boolean isMiddleProbe() {
		return middleProbe;
	}

	public boolean isTopProbe() {
		return topProbe;
	}

	@Override
	public TankStatus clone() {
		return new TankStatus(this.bottomProbe, this.middleProbe, this.topProbe);
	}

	public void setBottomProbe(boolean bottomProbe) {
		this.bottomProbe = bottomProbe;
	}

	public void setMiddleProbe(boolean middleProbe) {
		this.middleProbe = middleProbe;
	}

	public void setTopProbe(boolean topProbe) {
		this.topProbe = topProbe;
	}

}
