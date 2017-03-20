package ds;

import java.util.Comparator;

public class StadtUtils { 

    public static final Comparator<Stadt> CMP_NACH_NAMEN 
        = new Comparator<Stadt> () {
            public int compare(Stadt s1, Stadt s2) {
                return s1.getName().compareTo(s2.getName());
            }
        };
    
    public static final Comparator<Stadt> CMP_NACH_LAND 
        = (Stadt s1, Stadt s2) -> {
           return s1.getLand().compareTo(s2.getLand());
        };
    
    public static final Comparator<Stadt> CMP_NACH_EINWOHNER 
        = (s1, s2) -> s1.getEinwohner() - s2.getEinwohner();
    
}       

