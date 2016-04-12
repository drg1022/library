import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Album {

    private String artist;
    private String albumArtist;
    private String album;
    private String genre;
    private int year;
    private int albumRating;
    private int albumRatingComputed;

    private double totalRating;
    private int totalTracks;
    private double totalSize;
    private double totalTime;
    private int totalPlayCount;
    private double percentOfSongsRated;

    private Set<Song> songs = new HashSet<Song>();
    private boolean allRatingSet = true;

    public Album() {    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Album album1 = (Album) o;

        if (!albumArtist.equals(album1.albumArtist)) return false;
        return album.equals(album1.album);

    }

    @Override
    public int hashCode() {
        int result = albumArtist.hashCode();
        result = 31 * result + album.hashCode();
        return result;
    }

    public void aggregateTrackInfo(){
        totalRating = 0;
        totalPlayCount = 0;
        totalSize = 0;
        totalTime = 0;
        for(Song song:songs){
            totalSize += (song.getSize()/1000000);
            totalPlayCount += song.getPlayCount();
            totalTime += (song.getTotalTime()/1000)/60;
            if(song.isRatingSet() && allRatingSet){
                totalRating += song.getRating();
            }else{
                allRatingSet = false;
                totalRating = 0;
            }
        }
        totalTracks = songs.size();
        if(totalRating!=0)
            totalRating = totalRating/totalTracks;
    }

    public Set getSongs() {
        return songs;
    }

    public void addSong(Song song) {
        this.songs.add(song);
    }

    public double getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(double totalTime) {
        this.totalTime = totalTime;
    }

    public int getTotalPlayCount() {
        return totalPlayCount;
    }

    public void setTotalPlayCount(int totalPlayCount) {
        this.totalPlayCount = totalPlayCount;
    }

    public double getTotalRating() {
        return totalRating;
    }

    public void setTotalRating(int totalRating) {
        this.totalRating = totalRating;
    }

    public int getTotalTracks() {
        return totalTracks;
    }

    public void setTotalTracks(int totalTracks) {
        this.totalTracks = totalTracks;
    }

    public double getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbumArtist() {
        return albumArtist;
    }

    public void setAlbumArtist(String albumArtist) {
        this.albumArtist = albumArtist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getAlbumRating() {
        return albumRating;
    }

    public void setAlbumRating(int albumRating) {
        this.albumRating = albumRating;
    }

    public int getAlbumRatingComputed() {
        return albumRatingComputed;
    }

    public void setAlbumRatingComputed(int albumRatingComputed) {
        this.albumRatingComputed = albumRatingComputed;
    }
}
