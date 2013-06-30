package com.example.client;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

/**
 * Created by IntelliJ IDEA.
 * User: Sergi
 * Date: 20/11/11
 * Time: 21:00
 * To change this template use File | Settings | File Templates.
 */
public interface Charset extends ClientBundle
{
    @Source("../resources/martian1.gif")
    public ImageResource Martian1();
    @Source("../resources/martian2.gif")
    public ImageResource Martian2();
    @Source("../resources/tank.gif")
    public ImageResource Tank();
    @Source("../resources/shot.gif")
    public ImageResource Shot();
}
