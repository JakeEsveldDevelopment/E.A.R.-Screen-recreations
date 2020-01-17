package com.jakeesveld.zolatoolsscreen;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivityRecyclerAdapter extends RecyclerView.Adapter<MainActivityRecyclerAdapter.ViewHolder>  {
    private List<ToolItem> dataList;

    public MainActivityRecyclerAdapter(List<ToolItem> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.tools_item_view, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final ToolItem data = dataList.get(position);

        holder.textTitle.setText(data.getName());
        holder.imageIcon.setImageResource(data.getIconId());
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(data.isExpanded()){
                    holder.expandContainer.removeAllViews();
                    data.setExpanded(false);
                    holder.imageArrow.setImageResource(R.drawable.arrow_down);
                }else{
                    holder.expandContainer.addView(getTextView(data.getDesc(), holder.expandContainer, true));
                    for(String link: data.getLinks()){
                        TextView textView = getTextView(link, holder.expandContainer, false);
                        textView.setTextColor(Color.argb(255, 0, 150, 180));
                        textView.setClickable(true);
                        holder.expandContainer.addView(textView);
                    }
                    data.setExpanded(true);
                    holder.imageArrow.setImageResource(R.drawable.arrow_up);
                }
            }
        });
    }

    private TextView getTextView(String link, View view, boolean first) {
        TextView textView = new TextView(view.getContext());
        textView.setText(link);
        textView.setTextSize(16);
        if(first){
            textView.setPadding(24, 24, 24, 48);
        }else {
            textView.setPadding(24, 24, 24, 24);
        }

        return textView;
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        View container;
        LinearLayout expandContainer;
        TextView textTitle;
        ImageView imageIcon, imageArrow;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            container = itemView.findViewById(R.id.container);
            expandContainer = itemView.findViewById(R.id.layout_expand);
            textTitle = itemView.findViewById(R.id.text_title);
            imageIcon = itemView.findViewById(R.id.image_icon);
            imageArrow = itemView.findViewById(R.id.image_arrow);
        }
    }
}
