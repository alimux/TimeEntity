/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnr2i.models.coordinate;

/**
 *
 * @author user
 */
public class TrackPoint {
    
    private double latitude;
    private double longitude;
    private long time;
    
    public TrackPoint(double lat, double lon, long dateTP){
    
        latitude = lat;
        longitude = lon;
        time = dateTP;
        
        
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public long getTime() {
        return time;
    }
    
}
