package com.example.badal.fourth_assign;

/**
 * Created by Badal on 07-11-2016.
 */
public class Movies{
    private String mtitle;
    private String actorname;
    private String actressname;

    public String getActorname() {
        return actorname;
    }

    public void setActorname(String actorname) {
        this.actorname = actorname;
    }

    public String getActressname() {
        return actressname;
    }

    public void setActressname(String actressname) {
        this.actressname = actressname;
    }

    public Movies(){

    }
    public Movies(String motitle,String act_name,String actr_name){
        this.mtitle=motitle;
        this.actorname=act_name;
        this.actressname=actr_name;
    }

    public String getMtitle() {
        return mtitle;
    }

    public void setMtitle(String mtitle) {
        this.mtitle = mtitle;
    }
}
