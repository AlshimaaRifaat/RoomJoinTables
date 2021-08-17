package unilever.it.org.roomsample.database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import unilever.it.org.roomsample.dao.ClassStudentDao;
import unilever.it.org.roomsample.dao.SchoolDao;
import unilever.it.org.roomsample.entities.ClassStudent;
import unilever.it.org.roomsample.entities.School;

@Database(entities = {ClassStudent.class, School.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;



    public abstract ClassStudentDao classDao();

    public abstract SchoolDao schoolDao();

    public static AppDatabase getINSTANCE(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context, AppDatabase.class,"School_DB")
                            .allowMainThreadQueries()
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
