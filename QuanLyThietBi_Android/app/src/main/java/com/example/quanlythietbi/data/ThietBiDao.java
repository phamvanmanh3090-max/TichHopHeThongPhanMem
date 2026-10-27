package com.example.quanlythietbi.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ThietBiDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    long them(ThietBi thietBi);

    @Update
    int sua(ThietBi thietBi);

    @Query("SELECT * FROM thiet_bi ORDER BY id DESC")
    LiveData<List<ThietBi>> layTatCa();
}
