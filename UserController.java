package harelchuk.maxim.throneserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserRepository userRepository;
    private LeaderboardRepository leaderboardRepository;

    @Autowired
    UserController(UserRepository userRepository,
                   LeaderboardRepository leaderboardRepository) {
        this.userRepository = userRepository;
        this.leaderboardRepository = leaderboardRepository;
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/create/{user_uuid}")
    public @ResponseBody
    User createUserByUUID(@PathVariable String user_uuid) {
        User user = new User(user_uuid);
        userRepository.save(user);
        int id = userRepository.findByUser_uuid(user_uuid).getId_user();
        User user1 = userRepository.findByUser_uuid(user_uuid);
        user1.setUser_name("PLAYER " + String.valueOf(id));
        userRepository.save(user1);
        return getUserByUUID(user_uuid);
    }


    @GetMapping("/get/{user_uuid}")
    public @ResponseBody
    User getUserByUUID(@PathVariable("user_uuid") String user_uuid) {
        return userRepository.findByUser_uuid(user_uuid);
    }

    @GetMapping("/get/leaderboard")
    public @ResponseBody
    ArrayList<User> getLeaders() {
        List<Integer> leadersID = leaderboardRepository.getUsersId();
        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < leadersID.size(); i++) {
            users.add(userRepository.findUserById(leadersID.get(i)));
        }
        return users;
    }

    @PutMapping("/update/{id_user}/user_name/{user_name}")
    public void setUser_name(@PathVariable int id_user,
                             @PathVariable String user_name) {
        userRepository.findById(id_user).map(user -> {
            user.setUser_name(user_name);
            return userRepository.save(user);
        }).orElseThrow(() -> new UserNotFoundException(id_user));
    }


    @PutMapping("/update/{id_user}/add_user_money/{add}")
    public void addUser_money(@PathVariable int id_user,
                              @PathVariable long add) {
        userRepository.findById(id_user).map(user -> {
            user.setUser_money(user.getUser_money() + add);
            return userRepository.save(user);
        }).orElseThrow(() -> new UserNotFoundException(id_user));
    }


    @PutMapping("/update/{id_user}/subtract_user_money/{subtract}")
    public void subtractUser_money(@PathVariable int id_user,
                                   @PathVariable long subtract) {
        userRepository.findById(id_user).map(user -> {
            user.setUser_money(user.getUser_money() - subtract);
            return userRepository.save(user);
        }).orElseThrow(() -> new UserNotFoundException(id_user));
    }


    @PutMapping("/update/{id_user}/easy_lose")
    public void easy_lose(@PathVariable int id_user) {
        userRepository.findById(id_user).map(user -> {
            user.setEasy_games(1 + user.getEasy_games());
            return userRepository.save(user);
        }).orElseThrow(() -> new UserNotFoundException(id_user));
    }


    @PutMapping("/update/{id_user}/easy_win")
    public void easy_win(@PathVariable int id_user) {
        userRepository.findById(id_user).map(user -> {
            user.setEasy_games(1 + user.getEasy_games());
            user.setEasy_winnings(1 + user.getEasy_winnings());
            return userRepository.save(user);
        }).orElseThrow(() -> new UserNotFoundException(id_user));
    }


    @PutMapping("/update/{id_user}/medium_lose")
    public void medium_lose(@PathVariable int id_user) {
        userRepository.findById(id_user).map(user -> {
            user.setMedium_games(1 + user.getMedium_games());
            return userRepository.save(user);
        }).orElseThrow(() -> new UserNotFoundException(id_user));
    }


    @PutMapping("/update/{id_user}/medium_win")
    public void medium_win(@PathVariable int id_user) {
        userRepository.findById(id_user).map(user -> {
            user.setMedium_games(1 + user.getMedium_games());
            user.setMedium_winnings(1 + user.getMedium_winnings());
            return userRepository.save(user);
        }).orElseThrow(() -> new UserNotFoundException(id_user));
    }


    @PutMapping("/update/{id_user}/hard_lose")
    public void hard_lose(@PathVariable int id_user) {
        userRepository.findById(id_user).map(user -> {
            user.setHard_games(1 + user.getHard_games());
            return userRepository.save(user);
        }).orElseThrow(() -> new UserNotFoundException(id_user));
    }


    @PutMapping("/update/{id_user}/hard_win")
    public void hard_win(@PathVariable int id_user) {
        userRepository.findById(id_user).map(user -> {
            user.setHard_games(1 + user.getHard_games());
            user.setHard_winnings(1 + user.getHard_winnings());
            return userRepository.save(user);
        }).orElseThrow(() -> new UserNotFoundException(id_user));
    }


    @PutMapping("/update/{id_user}/is_adv/{is_adv}")
    public void setIs_adv(@PathVariable int id_user,
                          @PathVariable boolean is_adv) {
        userRepository.findById(id_user).map(user -> {
            user.setIs_adv(is_adv);
            return userRepository.save(user);
        }).orElseThrow(() -> new UserNotFoundException(id_user));
    }


    @PutMapping("/update/{id_user}/is_books/{is_books}")
    public void setIs_books(@PathVariable int id_user,
                            @PathVariable boolean is_books) {
        userRepository.findById(id_user).map(user -> {
            user.setIs_books(is_books);
            return userRepository.save(user);
        }).orElseThrow(() -> new UserNotFoundException(id_user));
    }


    @PutMapping("/update/{id_user}/is_films/{is_films}")
    public void setIs_films(@PathVariable int id_user,
                            @PathVariable boolean is_films) {
        userRepository.findById(id_user).map(user -> {
            user.setIs_films(is_films);
            return userRepository.save(user);
        }).orElseThrow(() -> new UserNotFoundException(id_user));
    }


    @PutMapping("/update/{id_user}/is_skin_targar/{is_skin_targar}")
    public void setIs_skin_targar(@PathVariable int id_user,
                                  @PathVariable boolean is_skin_targar) {
        userRepository.findById(id_user).map(user -> {
            user.setIs_skin_targar(is_skin_targar);
            return userRepository.save(user);
        }).orElseThrow(() -> new UserNotFoundException(id_user));
    }


    @PutMapping("/update/{id_user}/is_skin_stark/{is_skin_stark}")
    public void setIs_skin_stark(@PathVariable int id_user,
                                 @PathVariable boolean is_skin_stark) {
        userRepository.findById(id_user).map(user -> {
            user.setIs_skin_stark(is_skin_stark);
            return userRepository.save(user);
        }).orElseThrow(() -> new UserNotFoundException(id_user));
    }


    @PutMapping("/update/{id_user}/is_skin_lann/{is_skin_lann}")
    public void setIs_skin_lann(@PathVariable int id_user,
                                @PathVariable boolean is_skin_lann) {
        userRepository.findById(id_user).map(user -> {
            user.setIs_skin_lann(is_skin_lann);
            return userRepository.save(user);
        }).orElseThrow(() -> new UserNotFoundException(id_user));
    }


    @PutMapping("/update/{id_user}/is_skin_night/{is_skin_night}")
    public void setIs_skin_night(@PathVariable int id_user,
                                 @PathVariable boolean is_skin_night) {
        userRepository.findById(id_user).map(user -> {
            user.setIs_skin_night(is_skin_night);
            return userRepository.save(user);
        }).orElseThrow(() -> new UserNotFoundException(id_user));
    }


    @PutMapping("/update/{id_user}/current_theme/{current_theme}")
    public void setCurrent_theme(@PathVariable int id_user,
                                 @PathVariable int current_theme) {
        userRepository.findById(id_user).map(user -> {
            user.setCurrent_theme(current_theme);
            return userRepository.save(user);
        }).orElseThrow(() -> new UserNotFoundException(id_user));
    }


    @PutMapping("/update/{id_user}/add_credit/{add}")
    public void get_credit(@PathVariable int id_user,
                           @PathVariable long add) {
        long current_time = new Date().getTime();
        userRepository.findById(id_user).map(user -> {
            user.setUser_money(user.getUser_money() + add);
            user.setIs_credit(true);
            user.setCredit_sum(add);
            user.setCredit_time(current_time);
            user.setCredit_time_to_increase(current_time);
            return userRepository.save(user);
        }).orElseThrow(() -> new UserNotFoundException(id_user));
    }


    @PutMapping("/update/{id_user}/remove_credit")
    public void remove_credit(@PathVariable int id_user) {
        userRepository.findById(id_user).map(user -> {
            long money = user.getUser_money();
            long credit_sum = updated_credit_sum(id_user);
            if (money > credit_sum) {
                user.setUser_money(money - credit_sum);
                user.setIs_credit(false);
                user.setCredit_sum(0);
                user.setCredit_time(0);
                user.setCredit_time_to_increase(0);
            } /*else {
                //showUnsuccessfulMessage();
            }*/
            return userRepository.save(user);
        }).orElseThrow(() -> new UserNotFoundException(id_user));
    }


    //@GetMapping("/update/{id_user}/updated_credit_sum_and_time")
    private long updated_credit_sum(@PathVariable int id_user) {
        long current_time = new Date().getTime();
        long[] credit_sum_and_time = new long[2];
        userRepository.findById(id_user).map(user -> {
            credit_sum_and_time[0] = user.getCredit_sum();
            credit_sum_and_time[1] = user.getCredit_time_to_increase();
            if (user.isIs_credit()) {
                if ((current_time - credit_sum_and_time[1]) > (21600000)) {
                    while ((current_time - credit_sum_and_time[1]) > (21600000)) {
                        credit_sum_and_time[0] *= 1.07;
                        credit_sum_and_time[1] += 21600000;
                    }
                }
            }
            user.setCredit_sum(credit_sum_and_time[0]);
            user.setCredit_time_to_increase(credit_sum_and_time[1]);
            return userRepository.save(user);
        }).orElseThrow(() -> new UserNotFoundException(id_user));
        return credit_sum_and_time[0];
    }


    @PutMapping("/update/{id_user}/add_debit/{add}")
    public void add_debit(@PathVariable int id_user,
                          @PathVariable long add) {
        long current_time = new Date().getTime();
        userRepository.findById(id_user).map(user -> {
            long debit_sum = updated_debit_sum(id_user);
            user.setUser_money(user.getUser_money() - add);
            user.setIs_debit(true);
            user.setDebit_sum(debit_sum + add);
            user.setDebit_time(current_time);
            return userRepository.save(user);
        }).orElseThrow(() -> new UserNotFoundException(id_user));
    }


    @PutMapping("/update/{id_user}/remove_debit")
    public void remove_debit(@PathVariable int id_user) {
        userRepository.findById(id_user).map(user -> {
            long money = user.getUser_money();
            long debit_sum = updated_debit_sum(id_user);
            user.setUser_money(money + debit_sum);
            user.setIs_debit(false);
            user.setDebit_sum(0);
            user.setDebit_time(0);
            return userRepository.save(user);
        }).orElseThrow(() -> new UserNotFoundException(id_user));
    }


    //@GetMapping("/update/{id_user}/updated_debit_sum_and_time")
    private long updated_debit_sum(@PathVariable int id_user) {
        long current_time = new Date().getTime();
        long[] debit_sum_and_time = new long[2];
        userRepository.findById(id_user).map(user -> {
            debit_sum_and_time[0] = user.getDebit_sum();
            debit_sum_and_time[1] = user.getDebit_time();
            if (user.isIs_debit()) {
                if ((current_time - debit_sum_and_time[1]) > (21600000)) {
                    while ((current_time - debit_sum_and_time[1]) > (21600000)) {
                        debit_sum_and_time[0] *= 1.06;
                        debit_sum_and_time[1] += 21600000;
                    }
                }
            }
            user.setDebit_sum(debit_sum_and_time[0]);
            user.setDebit_time(debit_sum_and_time[1]);
            return userRepository.save(user);
        }).orElseThrow(() -> new UserNotFoundException(id_user));
        return debit_sum_and_time[0];
    }

}
