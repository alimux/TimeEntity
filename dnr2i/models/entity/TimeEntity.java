/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnr2i.models.entity;

import dnr2i.util.event.ModelListenable;

/**
 *
 * @author user
 */
public abstract class TimeEntity extends ModelListenable{

    protected long startTime;
    protected long endTime;
    protected long currentTime;

    public TimeEntity() {
    }

    public long getDuration()
    {
        return endTime-startTime;
    }
    
    //getter
    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public long getCurrentTime() {
        return currentTime;
    }
    //setter

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public void setCurrentTime(long currentTime) {
        this.currentTime = currentTime;
    }

    /**
     * Méthode Abstraite sans implementation
     */
    public abstract void createEvent();

}
