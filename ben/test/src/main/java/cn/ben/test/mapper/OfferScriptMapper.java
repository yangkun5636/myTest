package cn.ben.test.mapper;

import cn.ben.test.vo.OfferScript;
import java.util.List;

public interface OfferScriptMapper {
    int deleteByPrimaryKey(Long offerScriptId);

    int insert(OfferScript record);

    OfferScript selectByPrimaryKey(Long offerScriptId);

    List<OfferScript> selectAll();

    int updateByPrimaryKey(OfferScript record);
}