package com.serafinebot.dint.recyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private WordListAdapter adapter;
        public TextView itemView;

        public WordViewHolder(View itemView, WordListAdapter adapter) {
            super(itemView);
            this.itemView = itemView.findViewById(R.id.word);
            this.adapter = adapter;
            itemView.setOnClickListener(this);
        }

        @SuppressLint("SetTextI18n")
        @Override
        public void onClick(View v) {
            this.itemView.setText("Clicked!" + this.itemView.getText());
        }
    }

    private LayoutInflater layoutInflater;
    private LinkedList<String> words;

    public WordListAdapter(Context context, LinkedList<String> words) {
        this.layoutInflater = LayoutInflater.from(context);
        this.words = words;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = this.layoutInflater.inflate(R.layout.element, parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        String mCurrent = this.words.get(position);
        holder.itemView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return this.words.size();
    }
}
