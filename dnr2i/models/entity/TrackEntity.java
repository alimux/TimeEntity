package dnr2i.models.entity;

import dnr2i.models.coordinate.TrackPoint;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class TrackEntity extends TimeEntity {

    private ArrayList<TrackPoint> trackPoints;
    private TrackPoint currentPosition;

    public TrackEntity() {
        trackPoints = new ArrayList<TrackPoint>();
    }

    public void addTrackPoint(TrackPoint p) {
        boolean firstPoint = (trackPoints.size() == 0);
        if (firstPoint) {
            currentPosition = p;
        }
        if (p.getTime() < startTime || firstPoint) {
            startTime = p.getTime();
        }
        if (p.getTime() > endTime || firstPoint) {
            endTime = p.getTime();
            trackPoints.add(p);
        }
        fireChanged();

    }

    public ArrayList<TrackPoint> getTrackPoints() {
        return trackPoints;
    }

    public TrackPoint getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentTime(long t) {
        currentPosition = getPoint(t);
        fireChanged();
        //System.out.println("setcurrenttime in trackentity");
    }

    public TrackPoint getPoint(long time) {
        int i;
        for (i = 0; i < trackPoints.size(); i++) {
            if (trackPoints.get(i).getTime()>time) {
                break;
            }
        }
        //System.out.println("i=" + i);
        return trackPoints.get(Math.max(0, i - 1));
    }

    @Override
    public void createEvent() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
