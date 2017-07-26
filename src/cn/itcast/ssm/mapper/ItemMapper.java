package cn.itcast.ssm.mapper;

import cn.itcast.ssm.domain.Items;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/7/22.
 */
@Repository
public interface ItemMapper {
    List<Items> itemList();

    Items findItemById(Integer id);

    void updateItem(Items item);
}
