package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "vote")
public class Vote {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;
    private int artist;
    private int genre_1;
    private int genre_2;
    private int genre_3;
    private int genre_4;
    private int genre_5;
    private String about;
    private String email;
    private LocalDateTime dt_create;

    public Vote() {
    }

    public Vote(int artist, int genre_1, int genre_2, int genre_3, int genre_4, int genre_5,
                String about, String email, LocalDateTime dt_create) {
        this.artist = artist;
        this.genre_1 = genre_1;
        this.genre_2 = genre_2;
        this.genre_3 = genre_3;
        this.genre_4 = genre_4;
        this.genre_5 = genre_5;
        this.about = about;
        this.email = email;
        this.dt_create = dt_create;
    }

    public Vote(Vote newVote) {

    }

    public long getId() {
        return id;
    }

    public int getArtist() {
        return artist;
    }

    public int getGenre_1() {
        return genre_1;
    }

    public int getGenre_2() {
        return genre_2;
    }

    public int getGenre_3() {
        return genre_3;
    }

    public int getGenre_4() {
        return genre_4;
    }

    public int getGenre_5() {
        return genre_5;
    }

    public String getAbout() {
        return about;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getDt_create() {
        return dt_create;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "id=" + id +
                ", artist=" + artist +
                ", genre_1=" + genre_1 +
                ", genre_2=" + genre_2 +
                ", genre_3=" + genre_3 +
                ", genre_4=" + genre_4 +
                ", genre_5=" + genre_5 +
                ", about='" + about + '\'' +
                ", email='" + email + '\'' +
                ", dt_create=" + dt_create +
                '}';
    }

}
