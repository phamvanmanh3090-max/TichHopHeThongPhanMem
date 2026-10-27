package com.example.quanlythietbi.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "thiet_bi")
public class ThietBi {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    @ColumnInfo(name = "ten_thiet_bi")
    private String tenThietBi;

    @NonNull
    @ColumnInfo(name = "nha_san_xuat")
    private String nhaSanXuat;

    public ThietBi(@NonNull String tenThietBi, @NonNull String nhaSanXuat) {
        this.tenThietBi = tenThietBi;
        this.nhaSanXuat = nhaSanXuat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getTenThietBi() {
        return tenThietBi;
    }

    public void setTenThietBi(@NonNull String tenThietBi) {
        this.tenThietBi = tenThietBi;
    }

    @NonNull
    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(@NonNull String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }
}
