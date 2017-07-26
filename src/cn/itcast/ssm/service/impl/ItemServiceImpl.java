package cn.itcast.ssm.service.impl;

import cn.itcast.ssm.mapper.ItemMapper;
import cn.itcast.ssm.domain.Items;
import cn.itcast.ssm.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/7/22.
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemMapper itemMapper;
    @Override
    public List<Items> itemList() {
        return itemMapper.itemList();
    }

    @Override
    public Items findItemById(Integer id) {
        return itemMapper.findItemById(id);
    }

    @Override
    public void updateItem(Items item) {
        itemMapper.updateItem(item);
    }
}
