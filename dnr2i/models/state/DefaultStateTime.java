package dnr2i.models.state;

import dnr2i.models.*;
import dnr2i.models.entity.TimeEntity;

public final class DefaultStateTime extends StateTime {

    public DefaultStateTime(Time time) {
        super(time);
    }

    public void add(TimeEntity entity) {
        if (start == -1 || entity.getStartTime() < this.start) {
            start = entity.getStartTime();
        }
        if (end == -1 || entity.getEndTime() > this.end) {
            end = entity.getEndTime();
        }
    }

    @Override
    public void setCurrentTimeImpl(TimeEntity e, long t) {
        e.setCurrentTime(t);
    }

}
