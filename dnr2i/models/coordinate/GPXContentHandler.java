
package dnr2i.models.coordinate;

import dnr2i.models.entity.TrackEntity;
import java.net.ContentHandler;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GPXContentHandler extends DefaultHandler{
    
    private double latitude, longitude;
    private long time;
    private ArrayList<TrackEntity> tracks; 
    // faire un getter public ArrayList<TrackEntity> getTracks(){
    //return tracks;}
    private String characters;
    public static SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
    
    
    public GPXContentHandler(){
        tracks = new ArrayList<TrackEntity>();
    }
    
    public void startElement(String uri,String localName, String qName, Attributes attributes) throws SAXException{
        
        if(qName.equalsIgnoreCase("trk")){
            tracks.add(new TrackEntity());
        }
        if(qName.equalsIgnoreCase("trkpt")){
            latitude = Double.parseDouble(attributes.getValue("lat"));
            longitude = Double.parseDouble(attributes.getValue("lon"));
        }
    }

    public ArrayList<TrackEntity> getTracks() {
        return tracks;
    }
    
    public void characters(char[] chars, int i, int j) throws SAXException
    {
        characters+=new String(chars,i,j);
    }
    
    public void endElement(String uri,String localName,String qName) throws SAXException{
        if(qName.equalsIgnoreCase("time")){
            try {
                time=SDF.parse(characters).getTime();
                //time =  -> parser ce qui est dans characters;
            } catch (ParseException ex) {
                Logger.getLogger(GPXContentHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(qName.equalsIgnoreCase("trkpt")){
            tracks.get(tracks.size()-1).addTrackPoint(new TrackPoint(latitude, longitude, time));
            //System.out.println("new point :"+latitude+" longitude="+longitude+" date="+new Date(time));
        }
        characters="";
    }
    
    
    
}
