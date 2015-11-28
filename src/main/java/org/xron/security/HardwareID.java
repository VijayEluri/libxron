/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xron.security;

import java.net.InetAddress;
import java.net.NetworkInterface;

/**
 * @author ben
 */
public class HardwareID {

  public static void main(String[] args) {
    getMacID();
  }

  public static void getMacID() {
    try {
      InetAddress[] addresses = InetAddress.getAllByName(InetAddress.getLocalHost().getHostName());
            /*
             * Get NetworkInterfaces for the current host and then read the
             * hardware addresses.
             */

      System.out.println("numAddresses: " + addresses.length);
//
      for (InetAddress inetAddress : addresses) {
        System.out.println("Address: " + inetAddress);
        NetworkInterface ni = NetworkInterface.getByInetAddress(inetAddress);
        System.out.println("ni = " + ni);
        if (ni != null) {
          byte[] mac = ni.getHardwareAddress();

          System.out.println("mac = " + mac);
          System.out.println(mac.length);
          for (int i = 0; i < mac.length; i++) {
            System.out.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : "");
          }
        }
      }
    } catch (Exception x) {
      x.printStackTrace();
      // todo: stop ignoring
    }
  }
}
