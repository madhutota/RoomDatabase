package bornbaby.com.roomdatabase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by madhu on 15-Mar-18.
 */
@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User>getAllUsers();
    @Insert
     void insertAllUser(User...users);

}
