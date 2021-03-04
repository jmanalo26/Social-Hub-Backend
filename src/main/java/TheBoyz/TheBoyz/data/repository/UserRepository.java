package TheBoyz.TheBoyz.data.repository;

import TheBoyz.TheBoyz.data.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * The interface class for the User Repository
 */
public interface UserRepository extends JpaRepository<User, Long> {

      @Query(value = "select user_table.user_id,  user_table.username,  user_table.email,  user_table.password, user_table.phone_number, user_table.login_preference\n" +
              "from general_preferences\n" +
              "inner join user_table on user_table.user_id=general_preferences.user_id", nativeQuery = true)
      User findPreferences(int userId);
   /**
    * This finds and retrieves a user by the user id.
    *
    * @param userId the distinct user id
    * @param pageable the pageable response
    * @return a user object
    */
   public Page<User> findByUserIdContainingOrderByUserId(Long userId, Pageable pageable);

   public User findByUserId(int userId);
   /**
    * Find the User by username
    * @param username the username created by the user
    * @return a user object
    */
   public User findUserByUsername(String username);
   public User findUserByEmail(String email);
   public User findUserByPhoneNumber(String phoneNumber);

   /**
    * Finds the user by their login information from the front end
    * @param email the user's email
    * @param password the user's password
    * @return the user
    */
   public User findUserByEmailAndPassword(String email, String password);

   /**
    * Finds a username
    * @param username the user's username
    * @return a string for the username.
    */
   public String findUserNameByUsername(String username);

   /**
    *Finds the user by their email
    * @param email the user's email
    * @return retunrs a string of the user's email.
    */
   public String findUserEmailByEmail(String email);

   /**
    *Finds the user by their phoneNumber
    * @param phoneNumber
    * @return returns a phone number
    */
   public String findUserPhoneNumberByPhoneNumber(String phoneNumber);
}
