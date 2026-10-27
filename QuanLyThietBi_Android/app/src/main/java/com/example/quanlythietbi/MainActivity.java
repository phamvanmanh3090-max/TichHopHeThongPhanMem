package com.example.quanlythietbi;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlythietbi.data.AppDatabase;
import com.example.quanlythietbi.data.ThietBi;
import com.example.quanlythietbi.data.ThietBiDao;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout layoutTenThietBi;
    private TextInputLayout layoutNhaSanXuat;
    private TextInputEditText edtTenThietBi;
    private TextInputEditText edtNhaSanXuat;
    private MaterialButton btnThem;
    private MaterialButton btnSua;
    private TextView tvDanhSachTrong;

    private ThietBiAdapter adapter;
    private ThietBiDao thietBiDao;
    private final ExecutorService databaseExecutor = Executors.newSingleThreadExecutor();

    private int selectedId = -1;
    private boolean editing = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXaView();
        khoiTaoRecyclerView();
        khoiTaoDatabase();
        ganSuKien();
    }

    private void anhXaView() {
        layoutTenThietBi = findViewById(R.id.layoutTenThietBi);
        layoutNhaSanXuat = findViewById(R.id.layoutNhaSanXuat);
        edtTenThietBi = findViewById(R.id.edtTenThietBi);
        edtNhaSanXuat = findViewById(R.id.edtNhaSanXuat);
        btnThem = findViewById(R.id.btnThem);
        btnSua = findViewById(R.id.btnSua);
        tvDanhSachTrong = findViewById(R.id.tvDanhSachTrong);
    }

    private void khoiTaoRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerThietBi);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        adapter = new ThietBiAdapter(this::chonThietBi);
        recyclerView.setAdapter(adapter);
    }

    private void khoiTaoDatabase() {
        thietBiDao = AppDatabase.getInstance(this).thietBiDao();
        thietBiDao.layTatCa().observe(this, danhSach -> {
            adapter.submitList(danhSach);
            tvDanhSachTrong.setVisibility(danhSach.isEmpty() ? View.VISIBLE : View.GONE);
        });
    }

    private void ganSuKien() {
        btnThem.setOnClickListener(view -> themThietBi());
        btnSua.setOnClickListener(view -> xuLyNutSua());
    }

    private void themThietBi() {
        String tenThietBi = layNoiDung(edtTenThietBi);
        String nhaSanXuat = layNoiDung(edtNhaSanXuat);
        if (!kiemTraDuLieu(tenThietBi, nhaSanXuat)) {
            return;
        }

        ThietBi thietBi = new ThietBi(tenThietBi, nhaSanXuat);
        databaseExecutor.execute(() -> {
            thietBiDao.them(thietBi);
            runOnUiThread(() -> {
                Toast.makeText(this, R.string.them_thanh_cong, Toast.LENGTH_SHORT).show();
                xoaVungNhap();
            });
        });
    }

    private void xuLyNutSua() {
        if (selectedId < 0) {
            Toast.makeText(this, R.string.chon_thiet_bi_truoc, Toast.LENGTH_SHORT).show();
            return;
        }

        if (!editing) {
            editing = true;
            btnSua.setText(R.string.cap_nhat);
            btnThem.setEnabled(false);
            edtTenThietBi.requestFocus();
            hienBanPhim();
            Toast.makeText(this, R.string.co_the_chinh_sua, Toast.LENGTH_SHORT).show();
            return;
        }

        capNhatThietBi();
    }

    private void capNhatThietBi() {
        String tenThietBi = layNoiDung(edtTenThietBi);
        String nhaSanXuat = layNoiDung(edtNhaSanXuat);
        if (!kiemTraDuLieu(tenThietBi, nhaSanXuat)) {
            return;
        }

        ThietBi thietBi = new ThietBi(tenThietBi, nhaSanXuat);
        thietBi.setId(selectedId);
        databaseExecutor.execute(() -> {
            int soDong = thietBiDao.sua(thietBi);
            runOnUiThread(() -> {
                if (soDong > 0) {
                    Toast.makeText(this, R.string.cap_nhat_thanh_cong, Toast.LENGTH_SHORT).show();
                    xoaVungNhap();
                } else {
                    Toast.makeText(this, R.string.khong_tim_thay_thiet_bi, Toast.LENGTH_SHORT).show();
                }
            });
        });
    }

    private void chonThietBi(ThietBi thietBi) {
        selectedId = thietBi.getId();
        edtTenThietBi.setText(thietBi.getTenThietBi());
        edtNhaSanXuat.setText(thietBi.getNhaSanXuat());
        thoatCheDoSua();
        Toast.makeText(this, R.string.da_chon_thiet_bi, Toast.LENGTH_SHORT).show();
    }

    private boolean kiemTraDuLieu(String tenThietBi, String nhaSanXuat) {
        layoutTenThietBi.setError(null);
        layoutNhaSanXuat.setError(null);

        if (tenThietBi.isEmpty()) {
            layoutTenThietBi.setError(getString(R.string.loi_ten_thiet_bi));
            edtTenThietBi.requestFocus();
            Toast.makeText(this, R.string.du_lieu_chua_hop_le, Toast.LENGTH_SHORT).show();
            return false;
        }
        if (nhaSanXuat.isEmpty()) {
            layoutNhaSanXuat.setError(getString(R.string.loi_nha_san_xuat));
            edtNhaSanXuat.requestFocus();
            Toast.makeText(this, R.string.du_lieu_chua_hop_le, Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private String layNoiDung(TextInputEditText editText) {
        return editText.getText() == null ? "" : editText.getText().toString().trim();
    }

    private void xoaVungNhap() {
        edtTenThietBi.setText("");
        edtNhaSanXuat.setText("");
        layoutTenThietBi.setError(null);
        layoutNhaSanXuat.setError(null);
        selectedId = -1;
        adapter.clearSelection();
        thoatCheDoSua();
        anBanPhim();
        edtTenThietBi.requestFocus();
    }

    private void thoatCheDoSua() {
        editing = false;
        btnSua.setText(R.string.sua);
        btnThem.setEnabled(true);
    }

    private void hienBanPhim() {
        InputMethodManager inputMethodManager =
                (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.showSoftInput(edtTenThietBi, InputMethodManager.SHOW_IMPLICIT);
    }

    private void anBanPhim() {
        View view = getCurrentFocus();
        if (view == null) {
            return;
        }
        InputMethodManager inputMethodManager =
                (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        databaseExecutor.shutdown();
    }
}
