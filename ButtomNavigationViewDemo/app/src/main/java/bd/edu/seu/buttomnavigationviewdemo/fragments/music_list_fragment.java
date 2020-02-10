package bd.edu.seu.buttomnavigationviewdemo.fragments;


import android.Manifest;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Objects;

import bd.edu.seu.buttomnavigationviewdemo.R;
import bd.edu.seu.buttomnavigationviewdemo.adapter.Music_list_adapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class music_list_fragment extends Fragment {

    private ArrayList<String>  mySongs1;
    private RecyclerView recyclerView;
    static MediaPlayer mediaPlayer;
    private Boolean check_play=false;
    private int temp = Integer.MIN_VALUE;




    public music_list_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_music_list_fragment, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        final ArrayList<File> mySongs = findSong(Environment.getExternalStorageDirectory());
        mySongs1 = new ArrayList<>(mySongs.size());
        for(int i=0;i<mySongs.size();i++)
        {

            mySongs1.add(mySongs.get(i).getName().replace(".mp3","").replace(".wav",""));
        }


        recyclerView = view.findViewById(R.id.MyRecyclerViewID);
        Music_list_adapter adapter = new Music_list_adapter(mySongs1,getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);


        adapter.setItemClickListener(new Music_list_adapter.ClickListener() {
            @Override
            public void onItemClickListener(int position, View v) {
                if(position != temp){
                    temp = position;
                }else temp = -1;
                try {
                    if(temp == -1){
                        mediaPlayer.stop();
                        mediaPlayer.release();
                        temp = Integer.MIN_VALUE;
                    }else {
                        if (!check_play) {
                            mediaPlayer = getMediaPlayer(mySongs, position);
                            mediaPlayer.start();
                        }
                        if (mediaPlayer.isPlaying()) {

                            //--------stop the old music---------//
                            mediaPlayer.stop();
                            mediaPlayer.release();

                            //---------get a new media_player and start-----------//
                            mediaPlayer = getMediaPlayer(mySongs, position);
                            mediaPlayer.start();
                            check_play = true;
                        } else {
                            check_play = false;
                        }
                    }
                }catch (Exception e){
                    check_play = false;
                    Toast.makeText(getActivity(), "This music is corrupted", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onItemLongClickListener(int position, View v) {
                Toast.makeText(getActivity(), "cliked", Toast.LENGTH_SHORT).show();
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
                if(singleFile.getName().endsWith(".mp3") || singleFile.getName().endsWith(".wav")){
                    arrayList.add(singleFile);
                }
            }
        }
        return arrayList;
    }

    public MediaPlayer getMediaPlayer(ArrayList<File> files,int position){
        MediaPlayer tempMediaPlayer;
        Uri uri = Uri.parse(files.get(position).toString());
        tempMediaPlayer = MediaPlayer.create(getActivity(),uri);
        return tempMediaPlayer;
    }

}
