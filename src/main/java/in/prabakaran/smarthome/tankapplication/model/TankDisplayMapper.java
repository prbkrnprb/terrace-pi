package in.prabakaran.smarthome.tankapplication.model;

public enum TankDisplayMapper {

	FRESH_WATER(Tanks.FRESH_WATER, DisplayBoard.FRESH_WATER),
	SALT_WATER(Tanks.SALT_WATER, DisplayBoard.SALT_WATER);
	
	private final Tanks tanks;
	private final DisplayBoard board;
	
	private TankDisplayMapper(final Tanks tanks, final DisplayBoard board) {
		this.board = board;
		this.tanks = tanks;
	}

	public Tanks getTanks() {
		return tanks;
	}

	public DisplayBoard getBoard() {
		return board;
	}
}
