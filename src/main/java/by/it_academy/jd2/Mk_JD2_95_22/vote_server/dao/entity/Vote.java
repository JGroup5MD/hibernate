package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "app.VoteWithMail")
public class Vote {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;
    @Column(name="mail")
    private String mail;
    @Column(name="about")
    private String about;
    @Column(name="date")
    private LocalDateTime date;
    @ManyToOne
    @JoinTable(
            name="app.Singer-Vote",
            joinColumns=
            @JoinColumn(name="vote_id", referencedColumnName="id"),
            inverseJoinColumns=
            @JoinColumn(name="singer_id", referencedColumnName="id")
    )
    private Singers singer;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="app.Jenre-Vote",
            joinColumns=
            @JoinColumn(name="vote_id", referencedColumnName="id"),
            inverseJoinColumns=
            @JoinColumn(name="genre_id", referencedColumnName="id")
    )
    private List<Jenres> genres;


    public Vote() {
    }

    public Vote(String mail, String about, LocalDateTime date, Singers singer, List<Jenres> genres) {
        this.mail = mail;
        this.about = about;
        this.date = date;
        this.singer = singer;
        this.genres = genres;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Singers getSinger() {
        return singer;
    }

    public void setSinger(Singers singer) {
        this.singer = singer;
    }

    public List<Jenres> getGenres() {
        return genres;
    }

    public void setGenres(List<Jenres> genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "id=" + id +
                ", mail='" + mail + '\'' +
                ", about='" + about + '\'' +
                ", date=" + date +
                ", singer=" + singer +
                ", genres=" + genres +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vote vote = (Vote) o;
        return id == vote.id && Objects.equals(mail, vote.mail) && Objects.equals(about, vote.about) && Objects.equals(date, vote.date) && Objects.equals(singer, vote.singer) && Objects.equals(genres, vote.genres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mail, about, date, singer, genres);
    }
}
