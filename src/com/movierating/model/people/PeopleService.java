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
}
