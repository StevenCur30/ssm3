package cn.itcast.ssm.controller;

import cn.itcast.ssm.domain.Items;
import cn.itcast.ssm.service.ItemService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/7/22.
 */
@Controller
public class ItemListController {
    @Autowired
    private ItemService itemService;

    @RequestMapping("itemList")
    public String index(Model model) {
        List<Items> itemsList = itemService.itemList();
        model.addAttribute("itemList",itemsList);
        return "itemList";
    }

    @RequestMapping("/itemEdit/{id}")
    public String editItem(@PathVariable("id") Integer id,Model model){
        Items item = itemService.findItemById(id);
        model.addAttribute("item",item);
        return "editItem";
    }

    @RequestMapping("updateitem")
    public String updateItem(MultipartFile file,HttpServletRequest request,Items item) throws IOException {
        String fileName = file.getOriginalFilename();
        String prefixName = UUID.randomUUID().toString();
        String picName = prefixName+fileName.substring(fileName.lastIndexOf("."));
        String realPath = "D:\\JAVA_workspase\\ssm3\\web\\upload";
        String realUrl = request.getContextPath()+"/"+picName;
        item.setPic(realUrl);
        //处理文件上传
        File destFile =new File(realPath,picName);
        if (!destFile.isFile()){
            destFile.mkdirs();
        }
        file.transferTo(destFile);
        itemService.updateItem(item);
        return "redirect:itemList.do";
    }
}
