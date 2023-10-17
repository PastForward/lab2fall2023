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
}
