package com.movierating.model.collection;

import java.util.List;

public class CollectionService {
    CollectionDAO dao = new CollectionDAO();

    public List<CollectionDTO> selectCollectionListByMovieNo(int movie_id) {
        return dao.selectCollectionListByMovieNo(movie_id);
    }

    public CollectionDTO makeDefaultCollection(String name, String description, int mno) {
        return dao.makeDefaultCollection(name, description, mno);
    }

    public List<CollectionDTO> selectCollectionsByMno(int mno) {
        return dao.selectCollectionsByMno(mno);
    }

    public CollectionDTO selectCollection(int coll_no) {
        return dao.selectCollection(coll_no);
    }

    public boolean insertMovieIntoCollection(int movie_id, int coll_no) {
        return dao.insertMovieIntoCollection(movie_id, coll_no);
    }
}
