package dnr2i.models;

import java.util.*;
import dnr2i.models.entity.*;
import dnr2i.models.state.*;
import dnr2i.util.event.ModelListenable;

public final class Time extends ModelListenable {

    private final List<TimeEntity> entities;

    private final StateTime defaultState;
    private final StateTime synchronizedState;
    private StateTime currentState = null;

    public Time() {

        entities = new ArrayList<>();

        defaultState = new DefaultStateTime(this);
        synchronizedState = new SynchronizedStateTime(this);

        currentState = defaultState;
    }

    public void setCurrentTime(long t) {
        currentState.setCurrentTime(t);
        fireChanged();
    }

    public List<TimeEntity> getEntities() {
        return entities;
    }

    public StateTime getSynchronizedState() {
        return synchronizedState;
    }

    public void switchState(boolean sync) {

        currentState = sync ? synchronizedState : defaultState;
        setCurrentTime(currentState.getCurrent());
        fireChanged();
        System.out.println("l'état courant est : " + currentState);
    }

    public void add(TimeEntity entity) {

        entities.add(entity);
        defaultState.add(entity);
        synchronizedState.add(entity);
        fireChanged();
    }

    public void remove(TimeEntity entity) {

        entities.remove(entity);
        defaultState.remove(entity);
        synchronizedState.remove(entity);
        fireChanged();

    }

    public long getStart() {

        return currentState.getStart();
    }

    public long getEnd() {

        return currentState.getEnd();
    }

    public long getCurrent() {
        return currentState.getCurrent();
    }

    public double getRatioFromTime()
    {
        return ((double) (currentState.getCurrent()-currentState.getStart())) / (currentState.getEnd() - currentState.getStart());
    }
    
    public void setTimeToRatio(double ratio) {
        System.out.println("time="+currentState.getStart() + ((long) (ratio * (currentState.getEnd() - currentState.getStart()))));
        setCurrentTime(currentState.getStart() + ((long) (ratio * (currentState.getEnd() - currentState.getStart()))));
    }

}
