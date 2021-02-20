package com.example.tsf_bankingapp.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tsf_bankingapp.models.Model;
import com.example.tsf_bankingapp.R;
import com.example.tsf_bankingapp.TransferMoney;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    private List<Model> dataList;
    private Activity context;
//    private RoomDB database;

    int lastpos = -1;
    public MainAdapter(Activity context, List<Model> dataList){
        this.context = context;
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);

        return new ViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder holder, int position) {

        Model data = dataList.get(position);
//        database = RoomDB.getInstance(context);

        holder.name.setText("Name : "+data.getName());
        holder.balance.setText("Current Balance : "+data.getBalance()+"");
        holder.email.setText("Email : "+data.getEmail());

        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, TransferMoney.class);

                i.putExtra("name_from", data.getName());
                i.putExtra("balance_from", data.getBalance());
                i.putExtra("email_from", data.getEmail());
                context.startActivity(i);
                context.overridePendingTransition(R.anim.toptonormal, R.anim.fixed);
            }
        });
        holder.balance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, TransferMoney.class);

                i.putExtra("name_from", data.getName());
                i.putExtra("balance_from", data.getBalance());
                i.putExtra("email_from", data.getEmail());
                context.startActivity(i);
                context.overridePendingTransition(R.anim.toptonormal, R.anim.fixed);
            }
        });
        holder.email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, TransferMoney.class);

                i.putExtra("name_from", data.getName());
                i.putExtra("balance_from", data.getBalance());
                i.putExtra("email_from", data.getEmail());
                context.startActivity(i);
                context.overridePendingTransition(R.anim.toptonormal, R.anim.fixed);
            }
        });
//        holder.edit.setOnClickListener(new View.OnClickListener() {
//            @SuppressLint("ResourceAsColor")
//            @Override
//            public void onClick(View v) {
//                MainData d = dataList.get(holder.getAdapterPosition());
//
//                int sID = d.getID();
//                String stext = d.getSname();
//
//                Dialog dialog = new Dialog(context);
//                dialog.setContentView(R.layout.dialog_update);
//                int width = WindowManager.LayoutParams.MATCH_PARENT;
//                int height = WindowManager.LayoutParams.WRAP_CONTENT;
//                dialog.getWindow().setLayout(width,height);
//                dialog.show();
//
//                EditText editText = dialog.findViewById(R.id.edit_text);
//                Button button = dialog.findViewById(R.id.updatebtn);
//
//                editText.setText(d.getText());
//
//                button.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        String stext = editText.getText().toString().trim();
//                        database.mainDao().update(sID,stext);
//                        dialog.dismiss();
//
//                        dataList.clear();
//                        dataList.addAll(database.mainDao().getAll());
//                        notifyDataSetChanged();
//                    }
//                });
//
//                holder.delete.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        MainData d = dataList.get(position);
//                        database.mainDao().delete(d);
//
//                        dataList.remove(holder.getAdapterPosition());
//
//                        notifyItemRemoved(position);
//                        notifyItemRangeChanged(position, dataList.size());
//                    }
//                });
//            }
//        });

        holder.layout.setBackgroundResource(R.color.white);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, email, balance;
        LinearLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
//            delete = itemView.findViewById(R.id.delete);
//            edit = itemView.findViewById(R.id.edit);
            email = itemView.findViewById(R.id.email);
//            cardView = itemView.findViewById(R.id.cardview);
            layout = itemView.findViewById(R.id.linearlayout);
            balance = itemView.findViewById(R.id.balance);

        }
    }
}
