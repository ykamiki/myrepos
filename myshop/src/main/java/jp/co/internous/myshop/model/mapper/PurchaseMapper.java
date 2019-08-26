package jp.co.internous.myshop.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

import jp.co.internous.myshop.model.domain.Goods;
import jp.co.internous.myshop.model.domain.Purchase;
import jp.co.internous.myshop.model.domain.dto.HistoryDto;

@Mapper
public interface PurchaseMapper {
	
	List<HistoryDto> findHistory(@Param("userId") String userId);
	
	List<Goods> findHistory2(@Param("userId") String userId);
	
	@Insert("INSERT INTO purchase (user_id, goods_id, item_count, total, created_at) " +
			"VALUES (#{userId}, #{goodsId}, #{itemCount}, #{total}, #{createdAt})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    void insert(Purchase purchase);

}
