package com.loloconsult.storebay.service;

import javax.ejb.Stateless;

/**
 * Created with IntelliJ IDEA.
 * User: Laurent
 * Date: 28/04/13
 * Time: 18:43
 * To change this template use File | Settings | File Templates.
 */
@Stateless
public class ServiceImpl implements Service {
    public String saluer() {
        return "Bonjour, comment ça va ???";
    }
}
