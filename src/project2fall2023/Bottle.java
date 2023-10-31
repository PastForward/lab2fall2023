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
}
