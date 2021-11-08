package com.movierating.model.people;

import java.util.List;

public class PeopleService {
    PeopleDAO dao = new PeopleDAO();

    public List<PeopleDTO> selectPeoples() {
        return dao.selectPeoples();
    }

    public PeopleDTO selectPeople(int pid) {
        return dao.selectPeople(pid);
    }

    public List<PeopleDTO> selectPeopleByName(String name) {
        return dao.selectPeopleByName(name);
    }

    public List<PeopleCastingDTO> selectPeopleCasting(int pid) {
        return dao.selectPeopleCasting(pid);
    }

    public PeopleDTO addPeople(String name, String profileImageUrl) {
        return dao.addPeople(name, profileImageUrl);
    }

    public PeopleDTO modifyPeople(int pid, String name, String profileImageUrl) {
        return dao.modifyPeople(pid, name, profileImageUrl);
    }

    public boolean deletePeople(int pid) {
        return dao.deletePeople(pid);
    }
}
