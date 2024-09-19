package com.codebly.zibro.view.home.menu.customerservice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codebly.zibro.R;

import java.util.List;

public class QnAAdapter extends RecyclerView.Adapter<QnAAdapter.QnAViewHolder> {
    private List<QnAItem> qnaList;

    public QnAAdapter(List<QnAItem> qnaList) {
        this.qnaList = qnaList;
    }

    @NonNull
    @Override
    public QnAViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_qna, parent, false);
        return new QnAViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QnAViewHolder holder, int position) {
        QnAItem currentItem = qnaList.get(position);
        holder.questionText.setText(currentItem.getQuestion());
        holder.answerText.setText(currentItem.getAnswer());

        boolean isExpanded = currentItem.isExpanded();
        holder.answerText.setVisibility(isExpanded ? View.VISIBLE : View.GONE);

        holder.itemView.setOnClickListener(v -> {
            currentItem.setExpanded(!currentItem.isExpanded());
            notifyItemChanged(position);
        });
    }

    @Override
    public int getItemCount() {
        return qnaList.size();
    }

    public static class QnAViewHolder extends RecyclerView.ViewHolder {
        TextView questionText;
        TextView answerText;

        public QnAViewHolder(@NonNull View itemView) {
            super(itemView);
            questionText = itemView.findViewById(R.id.questionText);
            answerText = itemView.findViewById(R.id.answerText);
        }
    }
}
