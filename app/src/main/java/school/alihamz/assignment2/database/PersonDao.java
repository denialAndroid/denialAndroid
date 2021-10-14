package school.alihamz.assignment2.database;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import school.alihamz.assignment2.model.AppData;

@Dao
public interface PersonDao {

    @Query("SELECT * FROM AppData ORDER BY ID")
    List<AppData> loadAllPersons();

    @Insert
    void insertPerson(AppData person);

    @Update
    void updatePerson(AppData person);

    @Delete
    void delete(AppData person);

}
