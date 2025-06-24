package core.sort.comparison;

public class Word implements Comparable<Word> {
    String word;

    public Word(String word) {
        this.word = word;
    }


    // 문자열 기준으로 정렬
    @Override
    public int compareTo(Word o) {
        return Integer.compare(this.word.length(), o.word.length());
    }
}
