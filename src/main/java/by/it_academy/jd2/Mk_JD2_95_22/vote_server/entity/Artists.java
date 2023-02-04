package by.it_academy.jd2.Mk_JD2_95_22.vote_server.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "artists")
public class Artists {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    private String nameArtist;

    public Artists() {
    }

    public Artists(String nameArtist) {
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
}
