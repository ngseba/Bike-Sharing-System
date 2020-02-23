package ro.iteahome.bikesharing.model;

public class Occurrence implements Comparable<Occurrence>{
    int id;
    int numberOfOccurences;

    public Occurrence(int id, int numberOfOccurences) {
        this.id = id;
        this.numberOfOccurences = numberOfOccurences;
    }

    public Occurrence() {
        this.id = -1;
        this.numberOfOccurences = -1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfOccurences() {
        return numberOfOccurences;
    }

    public void setNumberOfOccurences(int numberOfOccurences) {
        this.numberOfOccurences = numberOfOccurences;
    }

    public void increaseNumberOfOccurences() {
        this.numberOfOccurences++;
    }

    @java.lang.Override
    public int compareTo(Occurrence occurrence) {
        return occurrence.numberOfOccurences - this.numberOfOccurences;
    }
}
