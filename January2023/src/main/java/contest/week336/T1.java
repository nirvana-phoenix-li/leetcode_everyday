package contest.week336;

public class T1 {
    public static void main(String[] args) {
        T1 main = new T1();
        String[] strings = {"hey", "aeo", "mu", "ooo", "artro"};
        int i = main.vowelStrings(strings, 1, 4);


    }
//["hey","aeo","mu","ooo","artro"]
//        1
//        4
//     'a'、'e'、'i'、'o'、'u'
    public int vowelStrings(String[] words, int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            String word = words[i];
            boolean start = word.startsWith("a") || word.startsWith("e") || word.startsWith("i") || word.startsWith("o") || word.startsWith("u");
            boolean end = word.endsWith("a") || word.endsWith("e") || word.endsWith("i") || word.endsWith("o") || word.endsWith("u");
            if (start&&
            end){
                count++;
            }
        }
        return count;

    }
}
