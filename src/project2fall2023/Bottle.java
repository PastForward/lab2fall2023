package project2fall2023;

/** Bottle, a subclass of container that holds liquid.
 *
 * @author Aron Kabai-Tokes
 */
public class Bottle extends Container implements Comparable<Container> {
    private String color;
    
    /** Temperature of the contents inside the bottle.
     * 
     */
    private int contentTemperature;
    
    /** Creates a bottle.
     * 
     * @param newName                   name of bottle.
     * @param newStorageCapacity        size of storage.
     * @param newColor                  color type.
     * @param newContentTemperature     temperature of item contents in Celsius.
     */
    public Bottle(String newName, int newStorageCapacity,
            String newColor, int newContentTemperature) {
        super(newName, newStorageCapacity);
        color = newColor;
        contentTemperature = newContentTemperature;
    }
    
    /** gets the color of the bottle.
     * 
     * @return  The color of the bottle.
     */
    public String getColor() {
        return this.color;
    }
    
    /** Sets the color of the bottle.
     * 
     * @param newColor  The new color of the bottle.
     */
    public void setColor(String newColor) {
        this.color = newColor;
    }
    
    /** Gets the temperature of the contents within the bottle.
     * 
     * @return  the content temperature within the bottle.
     */
    public int getContentTemperature() {
        return this.contentTemperature;
    }
    
    /** sets the temperature of the contents within the bottle.
     * 
     * @param newContentTemperature     the new temperature of the contents 
     *                                  within the bottle.
     */
    public void setContentTemperature(int newContentTemperature) {
        this.contentTemperature = newContentTemperature;
    }
    
    // TODO: implement proper compareTo() and equals() methods for Bottle
    /**
      The compareTo method compares this Bottle to another Object.
      if this bottle is before other container, return a value < 0.
      if this bottle is after other container, return a value > 0.
      if this bottle is equal to other container, return 0.
      @param otherBottle The object to test for equality.
      @return int with result of comparison.
   */
    public int compareTo(Bottle otherBottle) {
        
        if (!(otherBottle instanceof Bottle))
            throw new ClassCastException("A bottle object expected.");
        
        // if they are unequal at the parent level than there is no need to
        // compare them at the child level
        if (super.compareTo(otherBottle) != 0)
            return super.compareTo(otherBottle);
        
        // comparison between temperatures
        return this.contentTemperature - otherBottle.getContentTemperature();
    }
}
