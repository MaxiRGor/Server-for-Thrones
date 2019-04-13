package harelchuk.maxim.throneserver.User;

import harelchuk.maxim.throneserver.Leaderboard.LeaderboardRepository;
import harelchuk.maxim.throneserver.Leaderboard.LeaderboardUser;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserRepository userRepository;
    private LeaderboardRepository leaderboardRepository;
    private UserSinglePointsRepository userSinglePointsRepository;

    @Autowired
    UserController(UserRepository userRepository,
                   LeaderboardRepository leaderboardRepository,
                   UserSinglePointsRepository userSinglePointsRepository) {
        this.userRepository = userRepository;
        this.leaderboardRepository = leaderboardRepository;
        this.userSinglePointsRepository = userSinglePointsRepository;
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<User> getUsers() {
        return userRepository.findAll();
    }


    @GetMapping("/create")
    public @ResponseBody
    User createUser() {
        byte[] uuid_bytes = getBytesFromUUID(UUID.randomUUID());
        String uuid = getUUIDFromBytes(uuid_bytes).toString();
        String uniqueNumber = RandomStringUtils.random(4, true, true);
        User user = new User(uniqueNumber, uuid_bytes, uuid);
        userRepository.save(user);
        int id = userRepository.getByUuidBytes(uuid_bytes).getId();
        UserSinglePoints userSinglePoints = new UserSinglePoints(id);
        userSinglePointsRepository.save(userSinglePoints);
        User user1 = userRepository.getByUuidBytes(uuid_bytes);
        user1.setName("PLAYER " + String.valueOf(id));
        userRepository.save(user1);
        return getUserByUUID(uuid);
    }


    @GetMapping("/get/{uuid}")
    public @ResponseBody
    User getUserByUUID(@PathVariable("uuid") String uuid) {
        return userRepository.getByUuidBytes(getBytesFromUUID(UUID.fromString(uuid)));
    }

    @GetMapping("/get/money/{uuid}")
    public @ResponseBody
    Long getMoney(@PathVariable("uuid") String uuid) {
        return userRepository.getByUuidBytes(getBytesFromUUID(UUID.fromString(uuid))).getMoney();
    }

    @GetMapping("/get/points/{uuid}")
    public @ResponseBody
    UserSinglePoints getUserPoints(@PathVariable("uuid") String uuid) {
        int id = userRepository.getByUuidBytes(getBytesFromUUID(UUID.fromString(uuid))).getId();
        UserSinglePoints updating = userSinglePointsRepository.getUserSinglePointsByUserId(id);
        int points;
        long currentTime = new Date().getTime();
        if (updating.getTimeWhenFull() == 0) {  //previously checked after long time
            points = updating.getMaxPoints();
            System.out.println(1);
        } else {
            if (updating.getTimeWhenFull() < currentTime) {     //now checking after long time
                points = updating.getMaxPoints();
                updating.setTimeWhenFull(0);
                System.out.println(2);
            } else {
                points = (int) (updating.getMaxPoints() - 1 - (updating.getTimeWhenFull() - currentTime) / 150000);     //already played
                System.out.println(3);
            }
        }
        updating.setPoints(points);
        userSinglePointsRepository.save(updating);
        return updating;
    }


    @GetMapping("/get/leaderboard")
    public @ResponseBody
    ArrayList<LeaderboardUser> getLeaders() {
        List<Integer> leadersIds = leaderboardRepository.selectAllId();
        ArrayList<LeaderboardUser> leaders = new ArrayList<>();
        for (Integer leadersId : leadersIds) {
            User user = userRepository.getById(leadersId);
            //  icon = ?
            LeaderboardUser leaderboardUser = new LeaderboardUser(0, user.getName(), user.getMoney(),
                    user.getEasyGames(), user.getEasyWinnings(), user.getMediumGames(), user.getMediumWinnings(),
                    user.getHardGames(), user.getHardWinnings());
            leaders.add(leaderboardUser);
        }
        return leaders;
    }

    @PutMapping("/update/{uuid}/user_name/{user_name}")
    public void setUser_name(@PathVariable String uuid,
                             @PathVariable String user_name) {
        User updating = userRepository.getByUuidBytes(getBytesFromUUID(UUID.fromString(uuid)));
        updating.setName(user_name);
        userRepository.save(updating);
    }

    @PutMapping("/update/{uuid}/add_user_money/{add}")
    public void addUser_money(@PathVariable String uuid,
                              @PathVariable long add) {
        User updating = userRepository.getByUuidBytes(getBytesFromUUID(UUID.fromString(uuid)));
        updating.addUser_money(add);
        userRepository.save(updating);
    }

    @GetMapping("/update/{uuid}/subtract_points/{points}")
    public boolean subtractUserPoints(@PathVariable String uuid,
                                      @PathVariable int points) {
        int id = userRepository.getByUuidBytes(getBytesFromUUID(UUID.fromString(uuid))).getId();
        UserSinglePoints updating = userSinglePointsRepository.getUserSinglePointsByUserId(id);
        long timeWhenFull;
        if (updating.getTimeWhenFull() == 0) {
            long currentTime = new Date().getTime();
            timeWhenFull = currentTime + points * 150000;
        } else {
            timeWhenFull = updating.getTimeWhenFull() + points * 150000;
        }
        updating.setPoints(updating.getPoints() - points);
        updating.setTimeWhenFull(timeWhenFull);
        userSinglePointsRepository.save(updating);
        return true;
    }


    //////////////////////NOT ADDED///////////////////
    @GetMapping("/update/{uuid}/set_50_max_points")
    public boolean setMaxPoints(@PathVariable String uuid) {
        int id = userRepository.getByUuidBytes(getBytesFromUUID(UUID.fromString(uuid))).getId();
        UserSinglePoints updating = userSinglePointsRepository.getUserSinglePointsByUserId(id);
        updating.setMaxPoints(50);
        updating.setTimeWhenFull(0);
        userSinglePointsRepository.save(updating);
        return true;
    }


    @PutMapping("/update/{uuid}/easy_lose/")
    public void easy_lose(@PathVariable String uuid) {
        User updating = userRepository.getByUuidBytes(getBytesFromUUID(UUID.fromString(uuid)));
        updating.updateEasy_loses();
        userRepository.save(updating);
    }


    @PutMapping("/update/{uuid}/easy_win/{add}")
    public void easy_win(@PathVariable String uuid,
                         @PathVariable int add) {
        User updating = userRepository.getByUuidBytes(getBytesFromUUID(UUID.fromString(uuid)));
        updating.updateEasy_winnings(add);
        userRepository.save(updating);
    }

    @PutMapping("/update/{uuid}/medium_lose/")
    public void medium_lose(@PathVariable String uuid) {
        User updating = userRepository.getByUuidBytes(getBytesFromUUID(UUID.fromString(uuid)));
        updating.updateMedium_loses();
        userRepository.save(updating);
    }


    @PutMapping("/update/{uuid}/medium_win/{add}")
    public void medium_win(@PathVariable String uuid,
                           @PathVariable int add) {
        User updating = userRepository.getByUuidBytes(getBytesFromUUID(UUID.fromString(uuid)));
        updating.updateMedium_winnings(add);
        userRepository.save(updating);
    }

    @PutMapping("/update/{uuid}/hard_lose")
    public void hard_lose(@PathVariable String uuid) {
        User updating = userRepository.getByUuidBytes(getBytesFromUUID(UUID.fromString(uuid)));
        updating.updateHard_loses();
        userRepository.save(updating);
    }


    @PutMapping("/update/{uuid}/hard_win/{add}")
    public void hard_win(@PathVariable String uuid,
                         @PathVariable int add) {
        User updating = userRepository.getByUuidBytes(getBytesFromUUID(UUID.fromString(uuid)));
        updating.updateHard_winnings(add);
        userRepository.save(updating);
    }


    @PutMapping("/update/{uuid}/remove_adv}")
    public void remove_adv(@PathVariable String uuid) {
        User updating = userRepository.getByUuidBytes(getBytesFromUUID(UUID.fromString(uuid)));
        updating.removeAdv();
        userRepository.save(updating);
    }


    @PutMapping("/update/{uuid}/is_books/{is_books}")
    public void setIs_books(@PathVariable String uuid,
                            @PathVariable boolean is_books) {
        User updating = userRepository.getByUuidBytes(getBytesFromUUID(UUID.fromString(uuid)));
        updating.setBooks(is_books);
        userRepository.save(updating);
    }


    @PutMapping("/update/{uuid}/is_films/{is_films}")
    public void setIs_films(@PathVariable String uuid,
                            @PathVariable boolean is_films) {
        User updating = userRepository.getByUuidBytes(getBytesFromUUID(UUID.fromString(uuid)));
        updating.setFilms(is_films);
        userRepository.save(updating);
    }


    @PutMapping("/update/{uuid}/buy_skin_targar/{cost}")
    public void buy_skin_targar(@PathVariable String uuid,
                                @PathVariable long cost) {
        User updating = userRepository.getByUuidBytes(getBytesFromUUID(UUID.fromString(uuid)));
        updating.buy_skin_targar(cost);
        userRepository.save(updating);
    }


    @PutMapping("/update/{uuid}/buy_skin_stark/{cost}")
    public void buy_skin_stark(@PathVariable String uuid,
                               @PathVariable long cost) {
        User updating = userRepository.getByUuidBytes(getBytesFromUUID(UUID.fromString(uuid)));
        updating.buy_skin_stark(cost);
        userRepository.save(updating);
    }


    @PutMapping("/update/{uuid}/buy_skin_lann/{cost}")
    public void buy_skin_lann(@PathVariable String uuid,
                              @PathVariable long cost) {
        User updating = userRepository.getByUuidBytes(getBytesFromUUID(UUID.fromString(uuid)));
        updating.buy_skin_lann(cost);
        userRepository.save(updating);
    }


    @PutMapping("/update/{uuid}/buy_skin_night/{cost}")
    public void buy_skin_night(@PathVariable String uuid,
                               @PathVariable long cost) {
        User updating = userRepository.getByUuidBytes(getBytesFromUUID(UUID.fromString(uuid)));
        updating.buy_skin_night(cost);
        userRepository.save(updating);
    }


    @PutMapping("/update/{uuid}/current_theme/{current_theme}")
    public void setCurrent_theme(@PathVariable String uuid,
                                 @PathVariable int current_theme) {
        User updating = userRepository.getByUuidBytes(getBytesFromUUID(UUID.fromString(uuid)));
        updating.setCurrentTheme(current_theme);
        userRepository.save(updating);
    }


    @PutMapping("/update/{uuid}/get_credit/{get}")
    public void get_credit(@PathVariable String uuid,
                           @PathVariable long get) {
        User updating = userRepository.getByUuidBytes(getBytesFromUUID(UUID.fromString(uuid)));
        updating.getCredit(get);
        userRepository.save(updating);
    }


    @PutMapping("/update/{uuid}/return_credit")
    public void return_credit(@PathVariable String uuid) {
        User updating = userRepository.getByUuidBytes(getBytesFromUUID(UUID.fromString(uuid)));
        updating.returnCredit();
        userRepository.save(updating);
    }


    @PutMapping("/update/{uuid}/add_debit/{add}")
    public void add_debit(@PathVariable String uuid,
                          @PathVariable long add) {
        User updating = userRepository.getByUuidBytes(getBytesFromUUID(UUID.fromString(uuid)));
        updating.addDebit(add);
        userRepository.save(updating);
    }


    @PutMapping("/update/{uuid}/return_debit")
    public void return_debit(@PathVariable String uuid) {
        User updating = userRepository.getByUuidBytes(getBytesFromUUID(UUID.fromString(uuid)));
        updating.returnDebit();
        userRepository.save(updating);
    }


    private byte[] getBytesFromUUID(UUID uuid) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
        bb.putLong(uuid.getMostSignificantBits());
        bb.putLong(uuid.getLeastSignificantBits());
        return bb.array();
    }

    private UUID getUUIDFromBytes(byte[] bytes) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        Long high = byteBuffer.getLong();
        Long low = byteBuffer.getLong();
        return new UUID(high, low);
    }

}
