package harelchuk.maxim.throneserver;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface QuestionRepository extends CrudRepository<Question, Integer> {

    @Query("from Question where id_question IN (?1,?2,?3,?4,?5,?6,?7)")
    List<Question> findSevenByID(int id_1, int id_2, int id_3, int id_4, int id_5, int id_6, int id_7);

    @Query("select id_question from Question where level = ?1")
    ArrayList<Integer> findByLevel(int level);

    @Query("select id_question from Question where level = ?1 and in_book = ?2")
    ArrayList<Integer> findByLevelBook(int level, boolean in_book);

    @Query("select id_question from Question where level = ?1 and in_serial = ?2")
    ArrayList<Integer> findByLevelSerial(int level, boolean in_serial);

    @Query("select id_question from Question where category = ?1")
    ArrayList<Integer> findByCategory(int category);

    @Query("select id_question from Question where category = ?1 and in_book = ?2")
    ArrayList<Integer> findByCategoryBook(int category, boolean in_book);

    @Query("select id_question from Question where category = ?1 and in_serial = ?2")
    ArrayList<Integer> findByCategorySerial(int category, boolean in_serial);
    //List<Question> findByCategorySerial(int category, boolean in_serial);
}
