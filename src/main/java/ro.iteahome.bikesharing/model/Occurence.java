package ro.iteahome.bikesharing.model;

public class Occurence implements Comparable<Occurence>{
    int id;
    int numberOfOccurences;

    public Occurence(int id, int numberOfOccurences) {
        this.id = id;
        this.numberOfOccurences = numberOfOccurences;
    }

    public Occurence() {
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

    @java.lang.Override
    public int compareTo(Occurence occurence) {
        return this.numberOfOccurences - occurence.numberOfOccurences;
    }
}
