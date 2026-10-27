package com.example.quanlythietbi;

import static org.junit.Assert.assertEquals;

import android.content.Context;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.quanlythietbi.data.AppDatabase;
import com.example.quanlythietbi.data.ThietBi;
import com.example.quanlythietbi.data.ThietBiDao;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

@RunWith(AndroidJUnit4.class)
public class ThietBiDaoTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private AppDatabase database;
    private ThietBiDao dao;

    @Before
    public void setUp() {
        Context context = ApplicationProvider.getApplicationContext();
        database = Room.inMemoryDatabaseBuilder(context, AppDatabase.class)
                .allowMainThreadQueries()
                .build();
        dao = database.thietBiDao();
    }

    @After
    public void tearDown() {
        database.close();
    }

    @Test
    public void themVaSuaThietBi_duocLuuTrongRoom() throws InterruptedException {
        ThietBi thietBi = new ThietBi("Laptop", "Dell");
        int id = (int) dao.them(thietBi);

        List<ThietBi> sauKhiThem = getValue(dao.layTatCa());
        assertEquals(1, sauKhiThem.size());
        assertEquals("Laptop", sauKhiThem.get(0).getTenThietBi());

        ThietBi daSua = new ThietBi("Laptop XPS", "Dell");
        daSua.setId(id);
        assertEquals(1, dao.sua(daSua));

        List<ThietBi> sauKhiSua = getValue(dao.layTatCa());
        assertEquals("Laptop XPS", sauKhiSua.get(0).getTenThietBi());
    }

    private static <T> T getValue(LiveData<T> liveData) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        AtomicReference<T> value = new AtomicReference<>();
        Observer<T> observer = new Observer<T>() {
            @Override
            public void onChanged(T result) {
                value.set(result);
                latch.countDown();
                liveData.removeObserver(this);
            }
        };
        liveData.observeForever(observer);
        if (!latch.await(2, TimeUnit.SECONDS)) {
            liveData.removeObserver(observer);
            throw new AssertionError("LiveData không trả kết quả trong thời gian chờ");
        }
        return value.get();
    }
}
