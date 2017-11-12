package im.admt.team11.PA3.Util;

import im.admt.team11.PA3.Game.Board.Pieces.TokenTypes;

import java.util.HashMap;

public class TokenMap {
    public static HashMap<TokenTypes, String> getTokenMap() {
        HashMap<TokenTypes, String> tokenMap = new HashMap<TokenTypes, String>();
        tokenMap.put(TokenTypes.Blue, "/BlueToken.png");
        tokenMap.put(TokenTypes.Red, "/RedToken.png");
        tokenMap.put(TokenTypes.Green, "GreenToken.png");
        tokenMap.put(TokenTypes.Yellow, "YellowToken.png");
        return tokenMap;
    }


}
