/*
    Dans le main
    Time time = new Time();
    GPXTrackCreator createTrack = new GPXTrackCreator(time);
    createTrack.createFromGPX("path.../../");
 */
package dnr2i.models.coordinate;

import dnr2i.models.Time;
import dnr2i.models.entity.TrackEntity;
import dnr2i.models.entity.VueTrack2DJFrame;
import dnr2i.models.entity.VueTrackLabel;
import dnr2i.view.TimeGUI;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/**
 * Parse GPX file
 *
 * @author user
 */
public class GPXTrackCreator {

    private Time time;

    public GPXTrackCreator(Time time) {
        this.time = time;
    }

    public void createFromGPX(String f) {
        GPXContentHandler gpxHandler = new GPXContentHandler();

        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(f, gpxHandler);
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            ex.printStackTrace();
        }

        for (TrackEntity t : gpxHandler.getTracks()) {
            time.add(t);
            new VueTrackLabel(t);
            new VueTrack2DJFrame(t);

            System.out.println("ajout");
        }

    }

    public static void main(String[] args) {
        Time time = new Time();

        GPXTrackCreator creator = new GPXTrackCreator(time);
        creator.createFromGPX("C:\\M2\\Java\\TimeEntity\\gpx\\voieVerte2Trajectoires.gpx");
        System.out.println(new Date(time.getStart()));
        System.out.println(new Date(time.getEnd()));
        TimeGUI gui = new TimeGUI(time);

    }
}
