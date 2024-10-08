package everyday.y2024.october;

import java.util.HashSet;
import java.util.List;

public class DestCity1436 {

    public String destCity(List<List<String>> paths) {
        HashSet<String> hashSet = new HashSet<>();
        for (List<String> path : paths) {
            hashSet.add(path.get(0));
        }

        for (List<String> path : paths) {
            if (!hashSet.contains(path.get(1))) {
                return path.get(1);
            }
        }
        return null;
    }
}
