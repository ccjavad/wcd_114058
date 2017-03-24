package memory;

public class MemoryImage {
    
    private String name;
    private boolean open;

    public MemoryImage(String name) {
        this.name = name;
    }
    
    public void setOpen(boolean open) {
        this.open = open;
    }
    
    public boolean isOpen() {
        return open;
    }
    
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if( !(obj instanceof MemoryImage) ) {
            return false;
        }
        
        MemoryImage i2 = (MemoryImage)obj;
        
        return name.equals(i2.name);
    }
    
    
}
