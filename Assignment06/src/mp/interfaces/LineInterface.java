package mp.interfaces;

import mp.objects.Point;

public interface LineInterface {
    public Point getLocation();
    public void setLocation(Point newLocation);
    public int getWidth();
    public void setWidth(int newVal);
    public int getHeight() ;
    public void setHeight(int newVal);
}
