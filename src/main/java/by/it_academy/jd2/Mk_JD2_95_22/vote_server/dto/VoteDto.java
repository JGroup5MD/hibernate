package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.entity.Vote;

import java.time.LocalDateTime;
import java.util.Arrays;

public class VoteDto {
    public static class VoteBuilder {
        private int artist;
        private int genre_1;
        private int genre_2;
        private int genre_3;
        private int genre_4;
        private int genre_5;
        private String about;
        private String email;
        private LocalDateTime dt_create;

        private VoteBuilder() {
        }

        public static VoteBuilder create() {
            return new VoteBuilder();
        }

        public VoteBuilder setArtist(int artist) {
            this.artist = artist;
            return this;
        }

        public VoteBuilder setGenre_1(int genre_1) {
            this.genre_1 = genre_1;
            return this;
        }

        public VoteBuilder setGenre_2(int genre_2) {
            this.genre_2 = genre_2;
            return this;

        }

        public VoteBuilder setGenre_3(int genre_3) {
            this.genre_3 = genre_3;
            return this;

        }

        public VoteBuilder setGenre_4(int genre_4) {
            this.genre_4 = genre_4;
            return this;

        }

        public VoteBuilder setGenre_5(int genre_5) {
            this.genre_5 = genre_5;
            return this;

        }

        public VoteBuilder setAbout(String about) {
            this.about = about;
            return this;
        }

        public VoteBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public VoteBuilder setDt_create(LocalDateTime dt_create) {
            this.dt_create = dt_create;
            return this;
        }

        public Vote build() {
            return new Vote(artist, genre_1, genre_2, genre_3, genre_4, genre_5, about, email, dt_create);
        }
    }

}
