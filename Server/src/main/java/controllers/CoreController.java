package controllers;

import db.IHandler;
import db.users.UsersHandler;
import helpers.ControllerFactory;
import helpers.IController;
import models.User;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.Connector;

import java.net.ServerSocket;
import java.util.ArrayList;

public class CoreController {
    Logger logger = LogManager.getLogger(CoreController.class);
    private static int countClient = 0;
    public static Connector connector;

    public CoreController(ServerSocket serverSocket) {
        connector = new Connector(serverSocket);
        countClient++;
    }

    public void work(ServerSocket serverSocket) {
        try {
            IHandler usersHandler = new UsersHandler();
            connector = new Connector(serverSocket);
            System.out.println("User connector --> " + ++countClient);

            while (true) {
                String req = connector.readLine();
                switch (req) {
                    case "signIn" -> {
                        String login = connector.readLine();
                        String pass = connector.readLine();
                        ArrayList<User> clients = (ArrayList<User>) usersHandler.getList().clone();

                        for (User client : clients) {
                            System.out.println(client.toString());
                            if (pass.equals(client.getPassword()) && login.equals(client.getLogin())) {
                                connector.writeLine("true");

                                if (client.getFlag() == 1) {

                                    connector.writeLine("adminUI");
                                    IController iController = ControllerFactory.getType("admin");
                                    iController.start();
                                    return;

                                } else if (client.getFlag() == 2) {
                                    System.out.println(client);
                                    connector.writeLine("clientUI");
                                    connector.writeObj(client);

                                    IController iController = ControllerFactory.getType("client");
                                    iController.start();
                                    return;

                                } else {
                                    logger.log(Level.ERROR, "do not flags please view database and class User");
                                    break;
                                }
                            }
                        }
                        connector.writeLine("false");
                        connector.writeLine("false");
                    }
                    case "signUp" -> {
                        if (usersHandler.addObj(connector.readObj())) {
                            connector.writeLine("true");
                        } else {
                            connector.writeLine("false");
                        }
                    }
                    default -> {
                        logger.log(Level.ERROR, "class ServerController switch(connector.readLine()) error");
                    }
                }
            }
        } catch (Exception e) {
            logger.log(Level.ERROR, e.getMessage());
        }
    }

}
