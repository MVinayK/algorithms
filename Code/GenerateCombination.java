import java.util.HashSet;
import java.util.Set;

public class GenerateCombination {


    public void generateCombination(String str) {

        Set<String> set = new HashSet<>();
        generateCombHelper(str, 0, str.length() - 1, set);
        set.stream().forEach(System.out::println);
    }

    private void generateCombHelper(String str, int st, int ed, Set<String> set) {

        if(st >= ed || ed <= st) {
            return;
        }
        
        set.add("{ " + str.charAt(st) + " , " + str.charAt(ed) + " }");

        generateCombHelper(str, st+1, ed, set);
        generateCombHelper(str, st, ed-1, set);

    }
}