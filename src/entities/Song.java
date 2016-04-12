package entities;

import java.util.Date;

/**
 * Created by dgardy on 4/6/2016.
 */
public class Song implements Comparable<Song> {

    private int trackId;
    private String name;
    private String kind;
    private int size;
    private double totalTime;
    private int trackNumber;
    private Date dateModified;
    private Date dateAdded;
    private int bitRate;
    private int sampleRate;
    private String comments;
    private int playCount;
    private int playDate;
    private Date playDateUtc;
    private int rating;
    private boolean ratingSet = false;
    private int normalization;
    private String persistentId;
    private String trackType;
    private String location;
    private int fileFolderCount;
    private int libraryFolderCount;


    private String artist;
    private String albumArtist;
    private String album;
    private String genre;
    private int year;
    private int albumRating;
    private int albumRatingComputed;


    public int compareTo(Song s) {
        if(album == null || album.isEmpty())
            return 0;
        return album.compareTo(s.getAlbum());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Song song = (Song) o;

        return trackId == song.trackId;

    }

    @Override
    public int hashCode() {
        return trackId;
    }

    @Override
    public String toString() {
        return "Song{" +
                "trackId=" + trackId +
                ", name='" + name + '\'' +
                ", kind='" + kind + '\'' +
                ", size=" + size +
                ", totalTime=" + totalTime +
                ", trackNumber=" + trackNumber +
                ", dateModified=" + dateModified +
                ", dateAdded=" + dateAdded +
                ", bitRate=" + bitRate +
                ", sampleRate=" + sampleRate +
                ", comments='" + comments + '\'' +
                ", playCount=" + playCount +
                ", playDate=" + playDate +
                ", playDateUtc=" + playDateUtc +
                ", rating=" + rating +
                ", normalization=" + normalization +
                ", persistentId='" + persistentId + '\'' +
                ", trackType='" + trackType + '\'' +
                ", location='" + location + '\'' +
                ", fileFolderCount=" + fileFolderCount +
                ", libraryFolderCount=" + libraryFolderCount +
                '}';
    }

    public Song() {
    }

    public boolean isRatingSet() {
        return ratingSet;
    }

    public void setRatingSet(boolean ratingSet) {
        this.ratingSet = ratingSet;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public double getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(double totalTime) {
        this.totalTime = totalTime;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public int getBitRate() {
        return bitRate;
    }

    public void setBitRate(int bitRate) {
        this.bitRate = bitRate;
    }

    public int getSampleRate() {
        return sampleRate;
    }

    public void setSampleRate(int sampleRate) {
        this.sampleRate = sampleRate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getPlayCount() {
        return playCount;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

    public int getPlayDate() {
        return playDate;
    }

    public void setPlayDate(int playDate) {
        this.playDate = playDate;
    }

    public Date getPlayDateUtc() {
        return playDateUtc;
    }

    public void setPlayDateUtc(Date playDateUtc) {
        this.playDateUtc = playDateUtc;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getNormalization() {
        return normalization;
    }

    public void setNormalization(int normalization) {
        this.normalization = normalization;
    }

    public String getPersistentId() {
        return persistentId;
    }

    public void setPersistentId(String persistentId) {
        this.persistentId = persistentId;
    }

    public String getTrackType() {
        return trackType;
    }

    public void setTrackType(String trackType) {
        this.trackType = trackType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getFileFolderCount() {
        return fileFolderCount;
    }

    public void setFileFolderCount(int fileFolderCount) {
        this.fileFolderCount = fileFolderCount;
    }

    public int getLibraryFolderCount() {
        return libraryFolderCount;
    }

    public void setLibraryFolderCount(int libraryFolderCount) {
        this.libraryFolderCount = libraryFolderCount;
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
