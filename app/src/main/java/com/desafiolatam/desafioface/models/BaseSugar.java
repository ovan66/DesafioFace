package com.desafiolatam.desafioface.models;

import com.orm.SugarRecord;

/**
 * Created by santo_000 on 22-11-2016.
 */

public class BaseSugar extends SugarRecord {

    public long server_Id;

    public long getServer_Id() {
        return server_Id;
    }

    public void setServer_Id(long server_Id) {
        this.server_Id = server_Id;
    }

    public void create(){
        setServer_Id(getId());
        setId(null);
        save();
    }


    @Override
    public long save() {
        return super.save();
    }
}
