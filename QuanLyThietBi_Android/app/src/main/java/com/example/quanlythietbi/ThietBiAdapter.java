package com.example.quanlythietbi;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlythietbi.data.ThietBi;
import com.google.android.material.card.MaterialCardView;

public class ThietBiAdapter extends ListAdapter<ThietBi, ThietBiAdapter.ThietBiViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(ThietBi thietBi);
    }

    private final OnItemClickListener listener;
    private int selectedId = -1;

    public ThietBiAdapter(OnItemClickListener listener) {
        super(DIFF_CALLBACK);
        this.listener = listener;
    }

    private static final DiffUtil.ItemCallback<ThietBi> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<ThietBi>() {
                @Override
                public boolean areItemsTheSame(@NonNull ThietBi oldItem, @NonNull ThietBi newItem) {
                    return oldItem.getId() == newItem.getId();
                }

                @Override
                public boolean areContentsTheSame(@NonNull ThietBi oldItem, @NonNull ThietBi newItem) {
                    return oldItem.getTenThietBi().equals(newItem.getTenThietBi())
                            && oldItem.getNhaSanXuat().equals(newItem.getNhaSanXuat());
                }
            };

    @NonNull
    @Override
    public ThietBiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_thiet_bi, parent, false);
        return new ThietBiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ThietBiViewHolder holder, int position) {
        ThietBi thietBi = getItem(position);
        holder.bind(thietBi, thietBi.getId() == selectedId);
        holder.itemView.setOnClickListener(view -> {
            int oldSelectedId = selectedId;
            selectedId = thietBi.getId();
            if (oldSelectedId != selectedId) {
                notifyItemChangedById(oldSelectedId);
                notifyItemChangedById(selectedId);
            }
            listener.onItemClick(thietBi);
        });
    }

    public void clearSelection() {
        int oldSelectedId = selectedId;
        selectedId = -1;
        notifyItemChangedById(oldSelectedId);
    }

    private void notifyItemChangedById(int id) {
        if (id < 0) {
            return;
        }
        for (int i = 0; i < getItemCount(); i++) {
            if (getItem(i).getId() == id) {
                notifyItemChanged(i);
                return;
            }
        }
    }

    static class ThietBiViewHolder extends RecyclerView.ViewHolder {
        private final MaterialCardView cardView;
        private final TextView tvTenThietBi;
        private final TextView tvNhaSanXuat;

        ThietBiViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = (MaterialCardView) itemView;
            tvTenThietBi = itemView.findViewById(R.id.tvTenThietBi);
            tvNhaSanXuat = itemView.findViewById(R.id.tvNhaSanXuat);
        }

        void bind(ThietBi thietBi, boolean selected) {
            tvTenThietBi.setText(thietBi.getTenThietBi());
            tvNhaSanXuat.setText(itemView.getContext().getString(
                    R.string.nha_san_xuat_format,
                    thietBi.getNhaSanXuat()
            ));
            tvTenThietBi.setTypeface(null, selected ? Typeface.BOLD : Typeface.NORMAL);
            cardView.setStrokeWidth(dpToPx(selected ? 2 : 1));
            cardView.setStrokeColor(ContextCompat.getColor(
                    itemView.getContext(),
                    selected ? R.color.primary : R.color.outline_variant
            ));
            cardView.setCardBackgroundColor(ContextCompat.getColor(
                    itemView.getContext(),
                    selected ? R.color.primary_container : R.color.surface
            ));
        }

        private int dpToPx(int dp) {
            return Math.round(dp * itemView.getResources().getDisplayMetrics().density);
        }
    }
}
