package sample;

public class Nomor {
    private int[] angka;

    public Nomor(int[] angka){
        this.angka = angka;
    }

    public void sort() {
        if (angka.length == 1) {
            return;
        }
        for (int j = 0; j < angka.length; j++){
            for (int i = 0; i < angka.length - 1; i++) {
                if (angka[i] > angka[i+1]) {
                    int temp = angka[i];
                    angka[i] = angka[i + 1];
                    angka[i + 1] = temp;
                }
            }
        }
    }

    public String modus() {
        int maxCount = 0, i, j;
        int maxValue = 0;
        for (i = 0; i < angka.length; ++i) {
            int count = 0;
            for (j = 0; j < angka.length; ++j) {
                if (angka[i] == angka[j])
                    ++count;
            }
            if (count > maxCount) {
                maxCount = count;
                maxValue = angka[i];
            }
        }
        return String.valueOf(maxValue);
    }

    public String mean(){
        int jumlah = 0, hasil;
        for (int j : angka) {
            jumlah = jumlah + j;
        }
        hasil = jumlah/angka.length;
        return String.valueOf(hasil);
    }

    public String median(){
        sort();
        if (angka.length % 2 == 0){
            return String.valueOf((angka[angka.length / 2] + angka[angka.length/2 +1])/2);
        }
        else {
            return String.valueOf(angka[angka.length/2]);
        }
    }
}
