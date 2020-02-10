package bd.edu.seu.buttomnavigationviewdemo.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import bd.edu.seu.buttomnavigationviewdemo.R;

public class Music_list_adapter extends RecyclerView.Adapter<Music_list_adapter.Music_list_view> {

    private static ClickListener clickListener;
    //private static MyClickListener myClickListener;
    private ArrayList<String> mySongList;
    private Context context;

    public Music_list_adapter(ArrayList<String> mySongList, Context context) {
        this.mySongList = mySongList;
        this.context = context;
    }

    @NonNull
    @Override
    public Music_list_view onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.music_list_adapter_layout,null);
        return new Music_list_view(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Music_list_view holder, int position) {
        holder.songNmae.setText(mySongList.get(position));
    }

    @Override
    public int getItemCount() {
        return mySongList.size();
    }

     class Music_list_view extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{
        TextView songNmae;
         Music_list_view(@NonNull View itemView) {
            super(itemView);
            songNmae = itemView.findViewById(R.id.musicNameid);
            itemView.setOnLongClickListener(this);
            itemView.setOnClickListener(this);
        }

         @Override
         public void onClick(View view) {
             clickListener.onItemClickListener(getAdapterPosition(),view);
         }

         @Override
         public boolean onLongClick(View view) {
             clickListener.onItemLongClickListener(getAdapterPosition(),view);
             return false;
         }
     }



    public interface ClickListener{
        void onItemClickListener(int position, View v);
        void onItemLongClickListener(int position,View v);
    }
    public void setItemClickListener(ClickListener clickListener){
        Music_list_adapter.clickListener = clickListener;
    }
//    public interface MyClickListener{
//        void setOnItemClickListener(int position, View view);
//    }

//
//    public void setItemClickListener(MyClickListener myClickListener){
//        Music_list_adapter.myClickListener = myClickListener;
//    }


}
