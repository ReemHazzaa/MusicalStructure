package com.example.reem.musicalstructure;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Reem on 28,Dec,2018
 */

public class SongAdapter extends ArrayAdapter<Song> {

    // Constructor to create a new Song object.
    public SongAdapter(Activity context, ArrayList<Song> songs) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // The second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter, the adapter is not going to use this second argument,
        // so it can be any value. Here, we used 0.
        super(context, 0, songs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Song} object located at this position in the list
        Song currentSong = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID songNameTextView
        TextView songNameTextView = listItemView.findViewById(R.id.songNameTextView);
        // Get the song's name from the current Song object and
        // set this text on the songNameTextView
        songNameTextView.setText(currentSong.getmSongName());

        // Find the TextView in the list_item.xml layout with the ID singerNameTextView
        TextView singerNameTextView = listItemView.findViewById(R.id.singerNameTextView);
        // Get the song's singer name from the current Song object and
        // set this text on the singerNameTextView
        singerNameTextView.setText(currentSong.getmSongSingerName());

        // Find the TextView in the list_item.xml layout with the ID songAlbumNameTextView
        TextView songAlbumNameTextView = listItemView.findViewById(R.id.songAlbumNameTextView);
        // Get the song's album name from the current Song object and
        // set this text on the songAlbumNameTextView
        songAlbumNameTextView.setText(currentSong.getmSongAlbum());

        // Return the whole list item layout (containing 3 TextViews)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
