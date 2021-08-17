package unilever.it.org.roomsample.dao;

import androidx.room.Dao;
import androidx.room.Insert;

import java.util.List;

import unilever.it.org.roomsample.entities.ClassStudent;

import static androidx.room.OnConflictStrategy.IGNORE;

@Dao
public interface ClassStudentDao {
    @Insert(onConflict = IGNORE)
    void insertMultipleRecord(List<ClassStudent> classStudentList);
}
