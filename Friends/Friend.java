package harelchuk.maxim.throneserver.Friends;

public class Friend {

    Friend() {
    }

    private int id;
    private int icon;
    private String name;
    private long money;
    private int easyGames;
    private int easyWins;
    private int mediumGames;
    private int mediumWins;
    private int hardGames;
    private int hardWins;

    public Friend(int id, int icon, String name, long money, int easyGames, int easyWinnings, int mediumGames, int mediumWinnings, int hardGames, int hardWinnings) {
        this.id = id;
        this.icon = icon;
        this.name = name;
        this.money = money;
        this.easyGames = easyGames;
        this.easyWins = easyWinnings;
        this.mediumGames = mediumGames;
        this.mediumWins = mediumWinnings;
        this.hardGames = hardGames;
        this.hardWins = hardWinnings;
    }

    public int getIcon() {
        return icon;
    }

    public long getMoney() {
        return money;
    }


    public int getEasyGames() {
        return easyGames;
    }


    public int getEasyWins() {
        return easyWins;
    }


    public int getMediumGames() {
        return mediumGames;
    }


    public int getMediumWins() {
        return mediumWins;
    }


    public int getHardGames() {
        return hardGames;
    }


    public int getHardWins() {
        return hardWins;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
