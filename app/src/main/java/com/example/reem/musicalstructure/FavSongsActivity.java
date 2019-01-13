package com.example.reem.musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class FavSongsActivity extends AppCompatActivity {

    // Create an ArrayList of the user favorite Songs
    ArrayList<Song> favoriteSongs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav_songs);

        favoriteSongs = new ArrayList<>();

        // Add Song(s) to the favoriteSongs ArrayList.
        // To implement the real functionality of letting the user save his own fav songs,
        // the use of a storage is needed!
        favoriteSongs.add(new Song(getString(R.string.first_song_name), getString(R.string.first_song_album), getString(R.string.first_song_singer)));
        favoriteSongs.add(new Song(getString(R.string.fourth_song_name), getString(R.string.fourth_song_album), getString(R.string.fourth_song_singer)));
        favoriteSongs.add(new Song(getString(R.string.tenth_song_name), getString(R.string.tenth_song_album), getString(R.string.tenth_song_singer)));
        favoriteSongs.add(new Song(getString(R.string.third_song_name), getString(R.string.third_song_album), getString(R.string.third_song_singer)));

        // Set the SongAdapter to display the favoriteSongs ArrayList.
        SongAdapter adapter = new SongAdapter(this, favoriteSongs);

        ListView listView = findViewById(R.id.favSongsList);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the {@link Song} object at the given position the user clicked on
                Song song = favoriteSongs.get(position);

                //  Navigate to the details screen of the currently playing song
                Intent intent = new Intent(getApplicationContext(), CurrentSongActivity.class);
                // Send the current Song data between activities
                intent.putExtra("songName", song.getmSongName());
                intent.putExtra("songSinger", song.getmSongSingerName());
                intent.putExtra("songAlbum", song.getmSongAlbum());
                startActivity(intent);
            }
        });

        // Navigate to other activities
        // 1. Now playing
        ImageView nowPlayingImageView = findViewById(R.id.nowPlayingImageView);
        nowPlayingImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CurrentSongActivity.class);
                // Send the data of the 1st Song to the Now playing activity to
                // prevent it from being empty
                intent.putExtra("songName", favoriteSongs.get(1).getmSongName());
                intent.putExtra("songSinger", favoriteSongs.get(1).getmSongSingerName());
                intent.putExtra("songAlbum", favoriteSongs.get(1).getmSongAlbum());
                // Start the new activity and finish the current activity
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });

        // 2. Music library
        ImageView libraryImageView = findViewById(R.id.libraryImageView);
        libraryImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LibraryActivity.class);
                // Start the new activity and finish the current activity
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }
}
