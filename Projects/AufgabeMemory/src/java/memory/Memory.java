package memory;

import java.util.ArrayList;
import java.util.List;

public class Memory {
    
    public enum Level { EASY, NORMAL, HARD }

    public Memory(Level level, List<String> imageNames) {
    }

    public void openImage(int index) {
    }
    
    public List<MemoryImage> getImages() {
        List<MemoryImage> testList = new ArrayList<>();
        testList.add(new MemoryImage());
        testList.add(new MemoryImage());
        testList.add(new MemoryImage());
        
        return testList;
    }
}
