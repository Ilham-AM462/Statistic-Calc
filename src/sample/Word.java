package sample;

public class Word {
    public String[] word;

    public Word(String[] word) {
        this.word = word;
    }

    public void sort() {
        if (word.length == 1) {
            return;
        }
        for (int j = 0; j < word.length; j++){
            for (int i = 0; i < word.length - 1; i++) {
                if (word[i].compareTo(word[i + 1]) > 0) {
                    String temp = word[i];
                    word[i] = word[i + 1];
                    word[i + 1] = temp;
                }
            }
        }
    }

    public String modus() {
        int maxCount = 0, i, j;
        String maxValue = "Tidak ada modus";
        for (i = 0; i < word.length; ++i) {
            int count = 0;
            for (j = 0; j < word.length; ++j) {
                if (word[i].equals(word[j]))
                    ++count;
            }
            if (count > maxCount) {
                maxCount = count;
                maxValue = word[i];
            }
        }
        return maxValue;
    }

    public String median(){
        sort();
        if (word.length % 2 == 0){
            return word[word.length/2] + ", " + word[word.length/2 +1];
        }
        else {
            return word[word.length/2];
        }
    }
}
