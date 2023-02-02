package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto;

public class ResultVoteDto {
    private int resultArtist;
    private int resultGenre;

    public ResultVoteDto(int resultArtist, int resultGenre) {
        this.resultArtist = resultArtist;
        this.resultGenre = resultGenre;
    }

    public int getResultArtist() {
        return resultArtist;
    }

    public void setResultArtist(int resultArtist) {
        this.resultArtist = resultArtist;
    }

    public int getResultGenre() {
        return resultGenre;
    }

    public void setResultGenre(int resultGenre) {
        this.resultGenre = resultGenre;
    }

    @Override
    public String toString() {
        return "ResultVoteDto{" +
                "resultArtist=" + resultArtist +
                ", resultGenre=" + resultGenre +
                '}';
    }
}
