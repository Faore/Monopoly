package im.admt.team11.PA3.Util;

import im.admt.team11.PA3.Game.Board.Pieces.TokenTypes;

import java.util.HashMap;

public class TokenMap {
    public static HashMap<TokenTypes, String> getTokenMap() {
        HashMap<TokenTypes, String> tokenMap = new HashMap<TokenTypes, String>();
        tokenMap.put(TokenTypes.Blue, "/BlueToken.png");
        tokenMap.put(TokenTypes.Red, "/RedToken.png");
        tokenMap.put(TokenTypes.Green, "/GreenToken.png");
        tokenMap.put(TokenTypes.Yellow, "/YellowToken.png");
        return tokenMap;
    }

    public static HashMap<TokenTypes, String> getHouseMap() {
        HashMap<TokenTypes, String> tokenMap = new HashMap<TokenTypes, String>();
        tokenMap.put(TokenTypes.Blue, "/BlueHouse.png");
        tokenMap.put(TokenTypes.Red, "/RedHouse.png");
        tokenMap.put(TokenTypes.Green, "/GreenHouse.png");
        tokenMap.put(TokenTypes.Yellow, "/YellowHouse.png");
        return tokenMap;
    }

    public static HashMap<TokenTypes, String> getHotelMap() {
        HashMap<TokenTypes, String> tokenMap = new HashMap<TokenTypes, String>();
        tokenMap.put(TokenTypes.Blue, "/BlueHotel.png");
        tokenMap.put(TokenTypes.Red, "/RedHotel.png");
        tokenMap.put(TokenTypes.Green, "/GreenHotel.png");
        tokenMap.put(TokenTypes.Yellow, "/YellowHotel.png");
        return tokenMap;
    }
}
