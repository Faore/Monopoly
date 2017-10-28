package im.admt.team11.PA3;

public class SpecialTile extends Tile {
	public SpecialTile(String name) {
		super(name);
		if (name == "Go") {
			//player.addMoney(200);
		}
		else if (name == "Go to Jail") {
			//movePlayer() to jail
		}
		else if (name == "Free Parking") {
			//don't have to implement
		}
	}
}
