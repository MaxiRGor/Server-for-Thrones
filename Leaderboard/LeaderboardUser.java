package harelchuk.maxim.throneserver.Leaderboard;

public class LeaderboardUser {

    private int icon;
    private String name;
    private long money;
    private int easyGames;
    private int easyWins;
    private int mediumGames;
    private int mediumWins;
    private int hardGames;
    private int hardWins;

    public LeaderboardUser(int icon, String name, long money, int easyGames, int easyWinnings, int mediumGames, int mediumWinnings, int hardGames, int hardWinnings) {
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
}
