package harelchuk.maxim.throneserver;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    public User() {
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_user;

    private String user_uuid;

    private String user_name;

    private long user_money;

    private int easy_games;

    private int medium_games;

    private int hard_games;

    private int easy_winnings;

    private int medium_winnings;

    private int hard_winnings;

    private boolean is_adv;

    private boolean is_books;

    private boolean is_films;

    private boolean is_skin_targar;

    private boolean is_skin_stark;

    private boolean is_skin_lann;

    private boolean is_skin_night;

    private int current_theme;

    private boolean is_credit;

    private long credit_time;

    private long credit_time_to_increase;

    private long credit_sum;

    private boolean is_debit;

    private long debit_time;

    private long debit_sum;

    User(String user_uuid) {
        //id auto
        this.user_uuid = user_uuid;

        this.user_name = "";

        this.user_money = 1425;

        this.easy_games = 0;

        this.medium_games = 0;

        this.hard_games = 0;

        this.easy_winnings = 0;

        this.medium_winnings = 0;

        this.hard_winnings = 0;

        this.is_adv = true;

        this.is_books = false;

        this.is_films = true;

        this.is_skin_targar = true;

        this.is_skin_stark = false;

        this.is_skin_lann = false;

        this.is_skin_night = false;

        this.current_theme = 0;

        this.is_credit = false;

        this.credit_time = 0;

        this.credit_time_to_increase = 0;

        this.credit_sum = 0;

        this.is_debit = false;

        this.debit_time = 0;

        this.debit_sum = 0;
    }


    //setters

    public Integer getId_user() {
        return id_user;
    }

    public String getUser_uuid() {
        return user_uuid;
    }

    public String getUser_name() {
        return user_name;
    }

    public long getUser_money() {
        return user_money;
    }

    public int getEasy_games() {
        return easy_games;
    }

    public int getMedium_games() {
        return medium_games;
    }

    public int getHard_games() {
        return hard_games;
    }

    public int getEasy_winnings() {
        return easy_winnings;
    }

    public int getMedium_winnings() {
        return medium_winnings;
    }

    public int getHard_winnings() {
        return hard_winnings;
    }

    public boolean isIs_adv() {
        return is_adv;
    }

    public boolean isIs_books() {
        return is_books;
    }

    public boolean isIs_films() {
        return is_films;
    }

    public boolean isIs_skin_targar() {
        return is_skin_targar;
    }

    public boolean isIs_skin_stark() {
        return is_skin_stark;
    }

    public boolean isIs_skin_lann() {
        return is_skin_lann;
    }

    public boolean isIs_skin_night() {
        return is_skin_night;
    }

    public int getCurrent_theme() {
        return current_theme;
    }

    public long getCredit_time() {
        return credit_time;
    }

    public long getCredit_time_to_increase() {
        return credit_time_to_increase;
    }

    public long getCredit_sum() {
        return credit_sum;
    }

    public long getDebit_time() {
        return debit_time;
    }

    public boolean isIs_credit() {
        return is_credit;
    }

    public boolean isIs_debit() {
        return is_debit;
    }

    public long getDebit_sum() {
        return debit_sum;
    }

    //setters

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public void setUser_uuid(String user_uuid) {
        this.user_uuid = user_uuid;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }


    public void setUser_money(long user_money) {
        this.user_money = user_money;
    }


    public void setEasy_games(int easy_games) {
        this.easy_games = easy_games;
    }


    public void setMedium_games(int medium_games) {
        this.medium_games = medium_games;
    }


    public void setHard_games(int hard_games) {
        this.hard_games = hard_games;
    }


    public void setEasy_winnings(int easy_winnings) {
        this.easy_winnings = easy_winnings;
    }


    public void setMedium_winnings(int medium_winnings) {
        this.medium_winnings = medium_winnings;
    }


    public void setHard_winnings(int hard_winnings) {
        this.hard_winnings = hard_winnings;
    }


    public void setIs_adv(boolean is_adv) {
        this.is_adv = is_adv;
    }


    public void setIs_books(boolean is_books) {
        this.is_books = is_books;
    }


    public void setIs_films(boolean is_films) {
        this.is_films = is_films;
    }


    public void setIs_skin_targar(boolean is_skin_targar) {
        this.is_skin_targar = is_skin_targar;
    }


    public void setIs_skin_stark(boolean is_skin_stark) {
        this.is_skin_stark = is_skin_stark;
    }


    public void setIs_skin_lann(boolean is_skin_lann) {
        this.is_skin_lann = is_skin_lann;
    }


    public void setIs_skin_night(boolean is_skin_night) {
        this.is_skin_night = is_skin_night;
    }


    public void setCurrent_theme(int current_theme) {
        this.current_theme = current_theme;
    }


    public void setIs_credit(boolean is_credit) {
        this.is_credit = is_credit;
    }


    public void setCredit_time(long credit_time) {
        this.credit_time = credit_time;
    }

    public void setCredit_time_to_increase(long credit_time_to_increase) {
        this.credit_time_to_increase = credit_time_to_increase;
    }

    public void setCredit_sum(long credit_sum) {
        this.credit_sum = credit_sum;
    }


    public void setDebit_sum(long debit_sum) {
        this.debit_sum = debit_sum;
    }


    public void setIs_debit(boolean is_debit) {
        this.is_debit = is_debit;
    }


    public void setDebit_time(long debit_time) {
        this.debit_time = debit_time;
    }
}
