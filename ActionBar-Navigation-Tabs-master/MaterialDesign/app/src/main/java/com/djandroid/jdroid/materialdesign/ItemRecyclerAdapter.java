package com.djandroid.jdroid.materialdesign;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import com.djandroid.jdroid.materialdesign.ClientLibrary.HttpModel.AndroidTaskService.TaskDetailResponse;
import com.google.gson.Gson;

/**
 * Created by kundan on 10/26/2015.
 */
public class ItemRecyclerAdapter extends  RecyclerView.Adapter<ItemRecylerViewHolder> {

    String [] project_name={"人员1","人员2","人员3","人员4",
            "人员5","工具1","工具2","工具3","工具4","工具5","工具6"};
    Context context;
    LayoutInflater inflater;
    TaskDetailResponse projectdetail;
    public ItemRecyclerAdapter(Context context, TaskDetailResponse temp) {
        this.context=context;
        this.projectdetail = temp;
        inflater=LayoutInflater.from(context);
    }
    @Override
    public ItemRecylerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=inflater.inflate(R.layout.item_list, parent, false);
        ItemRecylerViewHolder viewHolder=new ItemRecylerViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ItemRecylerViewHolder holder, int position) {
        holder.tv1.setText(projectdetail.taskCategoryList.get(position).CategoryName);
        holder.itemView.setOnClickListener(clickListener);
        holder.itemView.setTag(holder);
    }

    View.OnClickListener clickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ItemRecylerViewHolder vholder = (ItemRecylerViewHolder) v.getTag();
            int position = vholder.getPosition();
            Intent intent=new Intent();
            intent.putExtra("projectitems", new Gson().toJson(projectdetail.taskCategoryList.get(position)));
            intent.setClass(context, QuestionActivity.class);
            context.startActivity(intent);

            //Toast.makeText(context,"This is position "+position,Toast.LENGTH_SHORT ).show();

        }
    };

    @Override
    public int getItemCount() {
        return projectdetail.taskCategoryList.size();
    }
}