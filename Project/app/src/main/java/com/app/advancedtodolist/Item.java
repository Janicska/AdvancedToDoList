package com.app.advancedtodolist;

import java.sql.Date;
import java.sql.Time;

public class Item implements Comparable<Item>{
    private int priority;
    private String what;
    private Time duration;
    private Time from;
    private Time to;
    private Date when;
    private boolean done;


    public Item(int priority, String what, Time duration, Time from, Time to, Date when) {
        this.priority = priority;
        this.what = what;
        this.duration = duration;
        this.from = from;
        this.to = to;
        this.when = when;
        this.done=false;
    }

    public int getPriority() {
        return priority;
    }

    public String getWhat() {
        return what;
    }

    public Time getDuration(){return duration;}

    public Time getFrom() {
        return from;
    }

    public Time getTo() {
        return to;
    }

    public Date getWhen() {
        return when;
    }

    public boolean getDone(){return done;}

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setWhat(String what) {
        this.what = what;
    }

    public void setDuration(Time duration){this.duration= duration;}

    public void setFrom(Time from) {
        this.from = from;
    }

    public void setTo(Time to) {
        this.to = to;
    }

    public void setWhen(Date when) {
        this.when = when;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return priority == item.priority &&
                done == item.done &&
                what.equals(item.what) &&
                from.equals(item.from) &&
                to.equals(item.to) &&
                when.equals(item.when);
    }


    /* 1->this nagyobb o-nál
    0 -> egyenlőek
    -1 -> o nagyobb thisnél
    */
    @Override
    public int compareTo(Item o) {
        return (this.priority-o.priority)>0 ? 1 : ((this.priority-o.priority)<0 ? -1 : 0);
    }

    @Override
    public String toString() {
        return priority +
                "     " + what + "    " +
                "     " + from.toString() +
                "     " + to.toString();
    }
}
