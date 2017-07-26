package cn.itcast.ssm.service;

import cn.itcast.ssm.domain.Items;

import java.util.List;

/**
 * Created by Administrator on 2017/7/22.
 */
public interface ItemService {
    List<Items> itemList();

    Items findItemById(Integer id);

    void updateItem(Items item);
}
