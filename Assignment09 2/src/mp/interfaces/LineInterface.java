package mp.interfaces;

import util.models.PropertyListenerRegisterer;


public interface LineInterface extends PropertyListenerRegisterer{
    public PointInterface getLocation();
    public void setLocation(PointInterface newLocation);
    public int getWidth();
    public void setWidth(int newVal);
    public int getHeight() ;
    public void setHeight(int newVal);
}
