package SharedSystem;

public interface SharedConstants {
    public static final int PLAYER_EMPTY = 0;
    public static final int PLAYER_1 = 1;
    public static final int PLAYER_2 = 2;
    
    public static final int NETWORK_PLAYER_SEND = 0;
    public static final int NETWORK_PLAYER_READ = 1;
    
    public static final String ARENA_LOGO_FILENAME = "data/arenaLogo.png";
    public static final String GAMES_LOGO_FILENAME = "data/gamesLogo.png";
    
    public static final String TIC_TAC_TOE_NAME                = "Tic-Tac-Toe";
    public static final String TIC_TAC_TOE_PATH                = "data/tic-tac-toe/";
    public static final String TIC_TAC_TOE_LOGO_FILENAME       = TIC_TAC_TOE_PATH + "images/logo.png";
    public static final String TIC_TAC_TOE_BACKGROUND_FILENAME = TIC_TAC_TOE_PATH + "images/background.png";
    public static final String TIC_TAC_TOE_IMAGE_EMPTY         = TIC_TAC_TOE_PATH + "images/empty.png";
    public static final String TIC_TAC_TOE_IMAGE_CROSS         = TIC_TAC_TOE_PATH + "images/cross.png";
    public static final String TIC_TAC_TOE_IMAGE_CIRCLE        = TIC_TAC_TOE_PATH + "images/circle.png";
    public static final int TIC_TAC_TOE_GRID_SIZE  = 3;
    public static final int TIC_TAC_TOE_IMAGE_SIZE = 200;
    
    public static final String OTHELLO_NAME                = "Othello";
    public static final String OTHELLO_PATH                = "data/othello/";
    public static final String OTHELLO_LOGO_FILENAME       = OTHELLO_PATH + "images/logo.png";
    public static final String OTHELLO_BACKGROUND_FILENAME = OTHELLO_PATH + "images/background.png";
    public static final String OTHELLO_IMAGE_EMPTY         = OTHELLO_PATH + "images/empty.png";
    public static final String OTHELLO_IMAGE_BLACK         = OTHELLO_PATH + "images/black.png";
    public static final String OTHELLO_IMAGE_WHITE         = OTHELLO_PATH + "images/white.png";
    public static final int OTHELLO_GRID_SIZE  = 8;
    public static final int OTHELLO_IMAGE_SIZE = 75;
}
