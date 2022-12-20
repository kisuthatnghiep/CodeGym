package Gear;

import java.util.Comparator;

public class IDComparator  implements Comparator<Gear> {
    @Override
    public int compare(Gear o1, Gear o2) {
        return Double.compare(o1.getId(), o2.getId());
    }
}
