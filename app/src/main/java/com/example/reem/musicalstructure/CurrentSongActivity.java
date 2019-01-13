package com.example.reem.musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CurrentSongActivity extends AppCompatActivity {
    // Boolean variable to check status of "play/pause" image view (Clickable)
    boolean playImage = true;
    // Boolean variable to check status of "Add to favorites" image view (Clickable)
    boolean addedToFav = false;

    ImageView playImageView;
    ImageView favoriteImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_song);

        TextView songNameTextView = findViewById(R.id.songNameTextView);
        TextView songSingerTextView = findViewById(R.id.songSingerTextView);
        TextView songAlbumTextView = findViewById(R.id.songAlbumTextView);

        ImageView libraryImageView = findViewById(R.id.libraryImageView);
        ImageView favoritesImageView = findViewById(R.id.favoritesImageView);
        favoriteImageView = findViewById(R.id.favoriteImageView);
        playImageView = findViewById(R.id.playImageView);
        ImageView loopImageView = findViewById(R.id.loopImageView);
        ImageView skipPreviousImageView = findViewById(R.id.skipPreviousImageView);
        ImageView skipNextImageView = findViewById(R.id.skipNextImageView);

        // Receive the current Song data
        final String currentSongName = getIntent().getStringExtra("songName");
        String currentSongSingerName = getIntent().getStringExtra("songSinger");
        String currentSongAlbum = getIntent().getStringExtra("songAlbum");

        // Update the UI with these values
        songNameTextView.setText(currentSongName);
        songSingerTextView.setText(currentSongSingerName);
        songAlbumTextView.setText(currentSongAlbum);

        // Navigate to other activities
        // 1. Click Listener of the libraryImageView
        libraryImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Navigate to songs library
                Intent intent = new Intent(getApplicationContext(), LibraryActivity.class);
                // Start the new activity and finish the current activity
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });

        // 2. Favorites
        favoritesImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FavSongsActivity.class);
                // Start the new activity and finish the current activity
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });

        // Click Listener of the playImageView
        playImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Change the Image to Pause
                if (playImage) {
                    playImageView.setImageResource(R.drawable.baseline_pause_circle_outline_black_48);
                    playImage = false;
                } else {
                    playImageView.setImageResource(R.drawable.baseline_play_circle_outline_black_48);
                    playImage = true;
                }
            }
        });

        // Click Listener of the favoriteImageView
        favoriteImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!addedToFav) {
                    // Add the song to favorites
                    Toast.makeText(CurrentSongActivity.this, "Added to Favorites", Toast.LENGTH_SHORT).show();
                    addedToFav = true;
                    // Update the UI
                    favoriteImageView.setImageResource(R.drawable.baseline_favorite_black_24);
                } else {
                    // Remove the Song from fav list
                    Toast.makeText(CurrentSongActivity.this, "Removed from favorites", Toast.LENGTH_SHORT).show();
                    addedToFav = false;
                    // Update the UI
                    favoriteImageView.setImageResource(R.drawable.baseline_favorite_border_black_24);
                }
            }
        });

        // Click Listener for loopImageView
        loopImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CurrentSongActivity.this, "This function is not implemented!", Toast.LENGTH_SHORT).show();
            }
        });

        // Click Listener for skipPreviousImageView
        skipPreviousImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CurrentSongActivity.this, "This function is not implemented!", Toast.LENGTH_SHORT).show();
            }
        });

        // Click Listener for skipNextImageView
        skipNextImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CurrentSongActivity.this, "This function is not implemented!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
