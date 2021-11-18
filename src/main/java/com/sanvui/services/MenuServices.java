package com.sanvui.services;

import com.sanvui.model.dao.Imp.BaseDaoImp;
import com.sanvui.model.entities.Menu;

import java.util.List;

/**
 * @author: VuiSK
 * @created: 07/11/2021-11:56 AM
 * @mailto: sanvankhanh@gmail.com
 */

public class MenuServices {
    public static List<Menu> findAll(){
        BaseDaoImp imp = new BaseDaoImp(Menu.class);
        return imp.findAll();
    }
}
