package memory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Memory {

    public enum Level {
        EASY(3), NORMAL(4), HARD(5);

        private final int pairs;

        private Level(int pairs) {
            this.pairs = pairs;
        }

        public int getPairs() {
            return pairs;
        }
    }

    private List<MemoryImage> images;
    private MemoryImage lastImage;

    public Memory(Level level, List<String> imageNames) {

        imageNames = new ArrayList<>(imageNames);
        
        images = new ArrayList<>();
        
        Random r = new Random();
        for (int i = 0; i < level.getPairs(); i++) {

            int index = r.nextInt(imageNames.size());
            String imgName = imageNames.remove(index);
            
            images.add(new MemoryImage(imgName));
            images.add(new MemoryImage(imgName));
        }

        Collections.shuffle(images);
    }

    public void openImage(int index) {
        MemoryImage currentImage = images.get(index);
        currentImage.setOpen(true);
        
        if(lastImage==null) {
            lastImage=currentImage;
        } else {
            
            if(lastImage.equals(currentImage)) {
               lastImage = null;
            } else {
                lastImage.setOpen(false);
                lastImage = currentImage;
            }
        }
    }

    public List<MemoryImage> getImages() {
        return images;
    }
}
