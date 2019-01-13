package com.example.reem.musicalstructure;

/**
 * Created by Reem on 28,Dec,2018
 */

public class Song {
    private String mSongName;
    private String mSongAlbum;
    private String mSongSingerName;

    /**
     * Create a new Song object.
     *
     * @param songName       is the song name.
     * @param songAlbum      is the album name of the song.
     * @param songSingerName is the name of the singer who sings the song.
     */
    public Song(String songName, String songAlbum, String songSingerName) {
        mSongName = songName;
        mSongAlbum = songAlbum;
        mSongSingerName = songSingerName;
    }

    /**
     * @return the song name.
     */
    public String getmSongName() {
        return mSongName;
    }

    /**
     * @return the song album's name or if it's a single.
     */
    public String getmSongAlbum() {
        return mSongAlbum;
    }

    /**
     * @return the singer name who sing's the song.
     */
    public String getmSongSingerName() {
        return mSongSingerName;
    }
}
