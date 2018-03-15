package bornbaby.com.roomdatabase;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by madhu on 15-Mar-18.
 */
@Database(entities = {User.class},version = 1 )
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao  userDao();
}
