package harelchuk.maxim.throneserver;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    @Query("from User where user_uuid = ?1")
    User findByUser_uuid(String user_uuid);

    @Query("select id_user from User where is_debit = false and is_credit = false order by user_money desc ")
    List<Integer> getSortedIds();

    @Query("from User where id_user=?1")
    User findUserById(int id);

}
