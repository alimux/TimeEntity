package dnr2i.models.state;

import dnr2i.models.*;
import dnr2i.models.entity.TimeEntity;

public final class SynchronizedStateTime extends StateTime {
    
    public SynchronizedStateTime(Time time) {
        super(time);
    }
    
    public void add(TimeEntity entity) {
        start = 0;
        
        if (end == -1 || entity.getDuration() > this.end) {
            end = entity.getDuration();
        }
    }
    
    @Override
    public void setCurrentTimeImpl(TimeEntity e, long t) {
        e.setCurrentTime(t + e.getStartTime());
    }
    
}
