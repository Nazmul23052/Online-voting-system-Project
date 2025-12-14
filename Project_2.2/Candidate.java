package com.ovs.model;

public class Candidate {
    public final long id;
    public final String name;
    public final String party;
    public final String manifesto;

    public Candidate(long id, String name, String party, String manifesto) {
        this.id = id;
        this.name = name;
        this.party = party;
        this.manifesto = manifesto;
    }
}
