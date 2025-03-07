package com.example.firebaseauth.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.firebaseauth.R;
import com.example.firebaseauth.model.ChatModel;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;


public class ChatAdapter extends FirestoreRecyclerAdapter<ChatModel, ChatAdapter.ChatViewHolder> {


    public ChatAdapter(@NonNull FirestoreRecyclerOptions<ChatModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ChatViewHolder chatViewHolder, int i, @NonNull ChatModel chatModel) {
        chatViewHolder.message.setText(chatModel.getMessage());

        if(!chatModel.getChat_image().equals("")){
            Glide.with(chatViewHolder.chat_image.getContext().getApplicationContext())
                    .load(chatModel.getChat_image())
                    .into(chatViewHolder.chat_image);
            chatViewHolder.chat_image.setVisibility(View.VISIBLE);
        }else {
            chatViewHolder.chat_image.setVisibility(View.GONE);
        }
    }

    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item,parent,false);
        return new ChatViewHolder(v);
    }

    class ChatViewHolder extends RecyclerView.ViewHolder{

        TextView message;
        CircleImageView user_image;
        ImageView chat_image;

        public ChatViewHolder(@NonNull View itemView) {
            super(itemView);
            message = itemView.findViewById(R.id.message);
            user_image = itemView.findViewById(R.id.user_image);
            chat_image = itemView.findViewById(R.id.chat_image);
        }
    }
}