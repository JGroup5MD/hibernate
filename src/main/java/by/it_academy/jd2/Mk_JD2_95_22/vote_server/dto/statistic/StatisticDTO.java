package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.statistic;

public class StatisticDTO {
    private final long  id;
    private final String name;
    private long count;

    public StatisticDTO(long id, String name) {
        this.id = id;
        this.name = name;
        this.count = 0;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getCount() {
        return count;
    }
    public void addCount(){
        count++;
    }

    @Override
    public String toString() {
        return "StatisticDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
