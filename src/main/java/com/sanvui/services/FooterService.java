package com.sanvui.services;

import com.sanvui.model.dao.Imp.BaseDaoImp;
import com.sanvui.model.entities.Footer;

import java.util.List;

/**
 * @author: VuiSK
 * @created: 17/11/2021-2:27 PM
 * @mailto: sanvankhanh@gmail.com
 */

public class FooterService {
    public static boolean inserts(List<Footer> footers){
        BaseDaoImp imp = new BaseDaoImp(Footer.class);
        return imp.insert(footers);
    }

    public static List<Footer> findAll(){
        BaseDaoImp imp = new BaseDaoImp(Footer.class);
        return imp.findAll();
    }
}
