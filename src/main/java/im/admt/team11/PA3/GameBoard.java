package im.admt.team11.PA3;

public class GameBoard {
	
	Tile[] tiles = new Tile[40];

	public GameBoard() {
		
		for(int i = 0; i < tiles.length; i++) {
			if(i == 0) {
				tiles[i] = new SpecialTile("GO");
			}
			else if(i == 9) {
				tiles[i] = new SpecialTile("Jail");
			}
			else if(i == 19) {
				tiles[i] = new SpecialTile("Free Parking");
			}
			else if(i == 29) {
				tiles[i] = new SpecialTile("Go to Jail");
			}
			
		}
	}

}
