package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "app.Singer")
public class Singers {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;
    @Column(name="name")
    private String nameArtist;

    public Singers() {
    }

    public Singers(String nameArtist) {
        this.nameArtist = nameArtist;
    }

    public long getId() {
        return id;
    }

    public String getNameArtist() {
        return nameArtist;
    }

    @Override
    public String toString() {
        return "Artists{" +
                "id=" + id +
                ", nameArtist='" + nameArtist + '\'' +
                '}';
    }

    public void setNameArtist(String nameArtist) {
        this.nameArtist = nameArtist;
    }
}
