package core.sort.comparison;

public class Score implements Comparable<Score> {
    int value;

    public Score(int value) {
        this.value = value;
    }


    // 숫자 기준으로 정렬
    @Override
    public int compareTo(Score o) {
        return Integer.compare(this.value, o.value);
    }
}
