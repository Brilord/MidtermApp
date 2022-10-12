package com.example.midtermapp.database;

//import androidx.room.Dao;
//import androidx.room.Delete;
//import androidx.room.Insert;
//import androidx.room.Query;
//
//import com.example.midtermapp.database.User;
//
//import java.util.List;
//
//@Dao
//public interface UserDao {
//    @Query("SELECT * FROM user")
//    List<User> getAllUsers();
//
//    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
//    List<User> loadAllByIds(int[] userIds);
//
//    @Query("SELECT * FROM user WHERE name LIKE :first AND " +
//            "score LIKE :last LIMIT 1")
//    User findByName(String first, String last);
//
//    @Insert
//    void insertAll(User... users);
//
//    @Delete
//    void delete(User user);
//}
