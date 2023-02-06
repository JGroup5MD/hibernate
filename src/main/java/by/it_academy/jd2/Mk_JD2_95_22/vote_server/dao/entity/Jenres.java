package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "genres")
public class Jenres {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    private String nameGenre;

    public Jenres() {
    }

    public Jenres(String nameGenre) {
        this.nameGenre = nameGenre;
    }

    public long getId() {
        return id;
    }

    public String getNameGenre() {
        return nameGenre;
    }

    @Override
    public String toString() {
        return "Genres{" +
                "id=" + id +
                ", nameGenre='" + nameGenre + '\'' +
                '}';
    }
}
