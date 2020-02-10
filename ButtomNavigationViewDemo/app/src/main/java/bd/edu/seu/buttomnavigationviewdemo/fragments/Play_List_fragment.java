package bd.edu.seu.buttomnavigationviewdemo.fragments;


import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;
import java.util.ArrayList;

import bd.edu.seu.buttomnavigationviewdemo.R;
import bd.edu.seu.buttomnavigationviewdemo.adapter.Music_list_adapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class Play_List_fragment extends Fragment {


    private ArrayList<String>  mySongs1;
    private RecyclerView recyclerView;
    static MediaPlayer mediaPlayer;
    private Boolean check_play=false;
    // Inflate the layout for this fragment
    VideoView videoView;
    MediaController mediaController;


    public Play_List_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_play__list_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        videoView = view.findViewById(R.id.videoViewId);
        mediaController=new MediaController(getActivity());
        videoView.setVisibility(View.GONE);

        final ArrayList<File> mySongs = findSong(Environment.getExternalStorageDirectory());
        mySongs1 = new ArrayList<>(mySongs.size());
        for(int i=0;i<mySongs.size();i++)
        {

            mySongs1.add(mySongs.get(i).getName().replace(".mp3","").replace(".wav",""));
        }
            recyclerView = view.findViewById(R.id.vedio_play_list);
            Music_list_adapter adapter = new Music_list_adapter(mySongs1, getActivity());
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setAdapter(adapter);

            adapter.setItemClickListener(new Music_list_adapter.ClickListener() {
                @Override
                public void onItemClickListener(int position, View v) {
                    Uri uri = Uri.parse(mySongs.get(position).toString());
                    videoView.setVisibility(View.VISIBLE);
                    videoView.setVideoURI(uri);
                    videoView.setMediaController(mediaController);
                    mediaController.setAnchorView(videoView);
                    videoView.start();
                }

                @Override
                public void onItemLongClickListener(int position, View v) {

                }
            });
    }



    public ArrayList<File> findSong(File file){
        ArrayList<File> arrayList = new ArrayList<>();

        File[] files = file.listFiles();

        assert files != null;
        for(File singleFile:files){
            if(singleFile.isDirectory() && !singleFile.isHidden()){
                arrayList.addAll(findSong(singleFile));
            }else{
                if(singleFile.getName().endsWith(".mp4") || singleFile.getName().endsWith(".mkv")){
                    arrayList.add(singleFile);
                }
            }
        }
        return arrayList;
    }
}
