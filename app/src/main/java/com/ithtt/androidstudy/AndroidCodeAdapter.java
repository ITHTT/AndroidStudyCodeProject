package com.ithtt.androidstudy;

import android.content.Intent;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ithtt on 16/9/21.
 */
public class AndroidCodeAdapter extends RecyclerView.Adapter<AndroidCodeAdapter.AndroidCodeViewHolder>{
    private List<AndroidCodeEntity> androidCodeList;

    public AndroidCodeAdapter(List<AndroidCodeEntity> list){
        this.androidCodeList=list;
    }

    @Override
    public AndroidCodeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_code_item,parent,false);
        return new AndroidCodeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AndroidCodeViewHolder holder, int position) {
        final AndroidCodeEntity androidCodeEntity=androidCodeList.get(position);
        holder.tvTitle.setText(androidCodeEntity.getTitle());
        holder.tvBrief.setText(androidCodeEntity.getBrief());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Class classObject=Class.forName(androidCodeEntity.getClassName());
                    Intent intent=new Intent(v.getContext(),classObject);
                    v.getContext().startActivity(intent);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return androidCodeList.size();
    }

    public static final class AndroidCodeViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_brief)
        TextView tvBrief;

        public AndroidCodeViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
