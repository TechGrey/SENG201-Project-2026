package seng201.team99.stores;

import seng201.team99.consumables.Adventurer;

import java.util.ArrayList;

public class Party {
    private Integer maxMembers;
    private ArrayList<Adventurer> members;

    public Party(Integer maxMembers) {
        this.maxMembers = maxMembers;
        this.members = new ArrayList<Adventurer>();
    }

    public ArrayList<Adventurer> getMembers() {
        return this.members;
    }

    public void addMember(Adventurer adventurer) {
        // Will need to throw a custom PartyMembersFull exception.
        if (this.members.size() >= maxMembers) {
            // throw new PartyMembersFullException;
            return;
        }

        this.members.add(adventurer);
    }

    public void removeMember(Adventurer adventurer) {
        if (!this.members.contains(adventurer)) {
            //  throw new PartyMemberNotExistException
            return;
        }

        this.members.remove(adventurer);
    }
}
