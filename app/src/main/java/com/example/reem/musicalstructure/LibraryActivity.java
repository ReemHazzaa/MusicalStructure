package com.example.reem.musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class LibraryActivity extends AppCompatActivity {

    // Create a list of all Songs
    ArrayList<Song> songs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        songs = new ArrayList<>();

        // Add songs to the songs list
        songs.add(new Song(getString(R.string.first_song_name), getString(R.string.first_song_album), getString(R.string.first_song_singer)));
        songs.add(new Song(getString(R.string.second_song_name), getString(R.string.secondt_song_album), getString(R.string.second_song_singer)));
        songs.add(new Song(getString(R.string.third_song_name), getString(R.string.third_song_album), getString(R.string.third_song_singer)));
        songs.add(new Song(getString(R.string.fourth_song_name), getString(R.string.fourth_song_album), getString(R.string.fourth_song_singer)));
        songs.add(new Song(getString(R.string.fifth_song_name), getString(R.string.fifth_song_album), getString(R.string.fifth_song_singer)));
        songs.add(new Song(getString(R.string.sixth_song_name), getString(R.string.sixth_song_album), getString(R.string.sixth_song_singer)));
        songs.add(new Song(getString(R.string.seventh_song_name), getString(R.string.seventh_song_album), getString(R.string.seventh_song_singer)));
        songs.add(new Song(getString(R.string.eighth_song_name), getString(R.string.eighth_song_album), getString(R.string.eighth_song_singer)));
        songs.add(new Song(getString(R.string.ninth_song_name), getString(R.string.ninth_song_album), getString(R.string.ninth_song_singer)));
        songs.add(new Song(getString(R.string.tenth_song_name), getString(R.string.tenth_song_album), getString(R.string.tenth_song_singer)));

        // Create an {@link SongAdapter}, whose data source is a list of {@link Song}s. The
        // adapter knows how to create list items for each item in the list.
        SongAdapter adapter = new SongAdapter(this, songs);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the {@link Song} object at the given position the user clicked on
                Song song = songs.get(position);

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
                intent.putExtra("songName", songs.get(0).getmSongName());
                intent.putExtra("songSinger", songs.get(0).getmSongSingerName());
                intent.putExtra("songAlbum", songs.get(0).getmSongAlbum());
                // Start the new activity and finish the current activity
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });

        // 2. Favorites
        ImageView favoritesImageView = findViewById(R.id.favoritesImageView);
        favoritesImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FavSongsActivity.class);
                // Start the new activity and finish the current activity
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }
}
