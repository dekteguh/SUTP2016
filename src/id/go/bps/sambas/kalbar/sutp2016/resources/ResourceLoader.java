/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.bps.sambas.kalbar.sutp2016.resources;

import java.net.URL;

/**
 *
 * @author Takdir
 */
public class ResourceLoader {

    private static Class clazz;
    private static ResourceLoader resourceLoader = new ResourceLoader();

    private ResourceLoader(){
        clazz = this.getClass();
    }

    public static URL getResource(String name){
        return clazz.getResource(name);
    }
}
