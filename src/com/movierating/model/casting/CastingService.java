package com.movierating.model.casting;

import java.util.List;

public class CastingService {
    CastingDAO dao = new CastingDAO();

    public List<CastingDTO> selectCastingByMovieNo(int movieNo) {
        return dao.selectCastingByMovieNo(movieNo);
    }
}
