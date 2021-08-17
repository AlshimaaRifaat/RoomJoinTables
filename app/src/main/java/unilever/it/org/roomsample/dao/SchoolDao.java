package unilever.it.org.roomsample.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import unilever.it.org.roomsample.entities.ClassStudent;
import unilever.it.org.roomsample.entities.JoinSchoolClassData;
import unilever.it.org.roomsample.entities.School;

import static androidx.room.OnConflictStrategy.IGNORE;

@Dao
public interface SchoolDao {
   @Insert(onConflict = IGNORE)
   void insertMultipleRecord(List<School> schools);

   @Query("SELECT School.schoolName,ClassStudent.className " +
         /*   "COUNT(Student.studentId) as studentcount," +
            "'[' || GROUP_CONCAT(DISTINCT('{\"id\":'||'\"'||Student.studentId || '\"'|| ', \" name \":'|| '\"'||Student.studentName|| '\"'||'}'))||']' studentDetails " +*/
           "FROM School " +
           "LEFT JOIN ClassStudent ON ClassStudent.schoold=School.schoolId\n"/* +
            "LEFT JOIN Student ON ClassStudent.classId=Student.classId\n" +
            "GROUP BY School.schoolId"*/)
   List<JoinSchoolClassData> getSchoolCLassData();
}
