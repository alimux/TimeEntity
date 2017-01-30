package dnr2i.models.state;

import dnr2i.models.*;
import dnr2i.models.entity.*;

public abstract class StateTime {

    protected long start = -1;
    protected long current = -1;
    protected long end = -1;

    private final Time time;

    public StateTime(Time time) {

        this.time = time;
    }

    abstract public void add(TimeEntity entity);

    public void remove(TimeEntity entity) {

    }

    public void setCurrentTime(long t) {
        this.current = t;
        for (TimeEntity e : time.getEntities()) {
            setCurrentTimeImpl(e, t);
        }
    }

    public abstract void setCurrentTimeImpl(TimeEntity e, long t);

    public long getStart() {

        return start;
    }

    public long getEnd() {

        return end;
    }

    public long getCurrent() {

        return current;
    }
}
