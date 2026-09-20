class Playlist {
    private String[] songs = new String[10];
    private int count = 0;

    public void addSong(String song) {
        if (count < songs.length) {
            songs[count++] = song;
        }
    }

    public String[] getSongs() {
        String[] copy = new String[count];

        for (int i = 0; i < count; i++) {
            copy[i] = songs[i];
        }

        return copy;
    }

    public int getSongCount() {
        return count;
    }
}

public class session_8prg7 {
    public static void main(String[] args) {
        Playlist p = new Playlist();

        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();

        copy[0] = "Hacked";

        System.out.println("Original First Song = " + p.getSongs()[0]);
        System.out.println("Song Count = " + p.getSongCount());
    }
}