package controllers;

import utils.Connector;

import java.net.ServerSocket;

public class CoreController {

    private static int countClient = 0;
    public static Connector connector;

    public CoreController(ServerSocket serverSocket) {
        connector = new Connector(serverSocket);
        countClient++;
    }

    public void work(ServerSocket serverSocket) {
        try {

        } catch (Exception e) {

        }
    }

}
