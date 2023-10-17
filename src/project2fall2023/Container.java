package project2fall2023;

/** Represents a container that will store items.
 *
 * @author Aron Kabai-Tokes
 */
public class Container {
    private String name;
    private int storageCapacity;
    
    /** Creates a container.
     * 
     * @param newContainerName      The name of the new container set
     *                              by the user.
     * @param newStorageCapacity    The storage capacity of the container 
     *                              set by the user. Must be > 0.
     */
    public Container(String newContainerName, int newStorageCapacity) {
        name = newContainerName;
        
        if (newStorageCapacity <= 0)
            newStorageCapacity = 1;
        
        storageCapacity = newStorageCapacity;
    }
    
    /** Gets the storage capacity.
     * 
     * @return returns the storage capacity.
     */
    public int getStorageCapacity() {
        return storageCapacity;
    }
    
    /** Sets the storage capacity.
     * 
     * @param newStorageCapacity    The new storage capacity. Must be > 0.
     */
    public void setStorageCapacity(int newStorageCapacity) {
        if (newStorageCapacity > 0)
        storageCapacity = newStorageCapacity;
    }
    
    /** Gets the name of the container.
     * 
     * @return  the name of the container.
     */
    public String getName() {
        return this.name;
    }
    
    /** Sets the name of the container.
     * 
     * @param newName   the new name.
     */
    public void setName(String newName) {
        name = newName;
    }
    
    /**
      The equals method compares this container to another Object.
      @param obj object to test for equality.
      @return Boolean with result of test for equality.
   */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Container))
            throw new ClassCastException("A Container object expected.");

        Container otherContainer = (Container) obj;  // cast the Object to a Container
        return this.name.equalsIgnoreCase(otherContainer.getName())
                && this.storageCapacity == otherContainer.getStorageCapacity();
    }
    
    /**
      The compareTo method compares this Container to another Object.
      if this container is before other container, return a value < 0.
      if this container is after other container, return a value > 0.
      if this container is equal to other container, return 0.
      @param otherContainer The object to test for equality.
      @return int with result of comparison.
   */
    public int compareTo(Container otherContainer) {
        if (!(otherContainer instanceof Container))
            throw new ClassCastException("A Container object expected.");
        
        if (getStorageCapacity() < otherContainer.getStorageCapacity()) {
            return -1;
        } else if (getStorageCapacity() > otherContainer.getStorageCapacity()) {
            return 1;
        } else return name.compareToIgnoreCase(otherContainer.getName());
        
    }
}
